package cn.code.utils.httpclient.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 使用httpclient模拟http请求工具
 * httpclient.version: 4.5.2
 */
public class HttpTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpTools.class);

    private static PoolingHttpClientConnectionManager connMgr;

    private static RequestConfig defaultRequestConfig;

    private static final int MAX_TIMEOUT = 10000;

    private HttpTools() {
        throw new IllegalAccessError("HttpTools class");
    }

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池最大连接数
        connMgr.setMaxTotal(200);
        //设置每个路由上的默认连接最大数
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
        // Defines period of inactivity in milliseconds after which persistent
        // connections must be re-validated prior to being leased to the consumer.
        connMgr.setValidateAfterInactivity(1000);
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);

        defaultRequestConfig = configBuilder.build();
    }


    /**
     * 发送POST请求
     *
     * @param url    url地址
     * @param params 参数map：Map<String, String>
     * @return 返还post请求原始的response
     */
    public static HttpResponse doPost(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(setPostParams(params), Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            LOGGER.error("http client doPost error,url is {},params is {},error is ", url, JSON.toJSON(params), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    LOGGER.error("IOException:", e);
                }
            }
        }
        return response;
    }

    /**
     * 发送POST请求,发送附件
     *
     * @param url       url地址
     * @param params    参数map：Map<String, String>
     * @param fileLists 附件
     * @return 返还post请求原始的response
     */
    public static HttpResponse doPost(String url, Map<String, String> params, List<File> fileLists) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            for (String key : params.keySet()) {
                builder.addPart(key, new StringBody(params.get(key), ContentType.TEXT_PLAIN));
            }
            for (File file : fileLists) {
                FileBody fileBody = new FileBody(file);
                builder.addPart("files", fileBody);
            }
            HttpEntity httpEntity = builder.build();
            httpPost.setEntity(httpEntity);
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            LOGGER.error("http client doPost error,url is {},params is {},error is ", url, JSON.toJSON(params), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    LOGGER.error("IOException:", e);
                }
            }
        }
        return response;
    }


    /**
     * 发送GET请求
     *
     * @param url     url地址
     * @param params  参数map：Map<String, String>
     * @param isHttps 是否是https请求
     * @return 返还post请求原始的response
     */
    public static HttpResponse doGet(String url, Map<String, String> params, boolean isHttps) {
        HttpResponse response = null;
        CloseableHttpClient httpclient;
        if (isHttps) {
            httpclient = createSSLClientDefault();
        } else {
            httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        }
        try {
            HttpGet httpGet = new HttpGet(setGetParams(url, params));
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            LOGGER.error("http client doGet error,url is {},params is {},error is ", url, JSON.toJSON(params), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    LOGGER.error("IOException:", e);
                }
            }
        }
        return response;
    }



    /**
     * 封装参数POST
     *
     * @param params 参数map
     * @return 返回List<NameValuePair>格式
     */
    private static List<NameValuePair> setPostParams(Map<String, String> params) {
        List<NameValuePair> pairList = new ArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
            pairList.add(pair);
        }
        return pairList;
    }

    /**
     * 封装参数GET
     *
     * @param url    请求url
     * @param params 参数map
     * @return 返回url形式
     */
    private static String setGetParams(String url, Map<String, String> params) {
        if (params == null || params.size() == 0)
            return url;
        StringBuilder sb = new StringBuilder(url);
        String concatString = url.indexOf('?') != -1 ? "&" : "?";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(concatString);
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if ("?".equals(concatString))
                concatString = "&";
        }
        return sb.toString();
    }

    /**
     * 创建SSL客户端
     *
     * @return
     */
    private static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            LOGGER.error("KeyManagementException:", e);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException:", e);
        } catch (KeyStoreException e) {
            LOGGER.error("KeyStoreException:", e);
        }
        return HttpClients.createDefault();
    }

}
