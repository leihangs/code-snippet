package com.code.guides.httpclient.common;

import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 11:41
 * @description:
 */
@Service
public class HttpClientService {

    @Autowired
    private CloseableHttpClient httpClient;
    @Autowired
    private RequestConfig requestConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientService.class);

    /**
     * 执行GET请求
     *
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public String doGet(String url) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(this.requestConfig);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    /**
     * 带有参数的GET请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     * @throws URISyntaxException
     */
    public String doGet(String url, Map<String, String> params)
            throws ClientProtocolException, IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        for (String key : params.keySet()) {
            uriBuilder.addParameter(key, params.get(key));
        }
        return this.doGet(uriBuilder.build().toString());
    }

    /**
     * 执行POST请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public HttpResult doPost(String url, Map<String, String> params) throws IOException {
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);
        if (params != null) {
            // 设置2个post参数，一个是scope、一个是q
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                parameters.add(new BasicNameValuePair(key, params.get(key)));
            }
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
        }

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * 执行POST请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public HttpResult doPost(String url) throws IOException {
        return this.doPost(url, null);
    }

    /**
     * 提交json数据
     *
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPostJson(String url, String json) throws ClientProtocolException, IOException {
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);

        if (json != null) {
            // 构造一个form表单式的实体
            StringEntity stringEntity = new StringEntity(json);
            stringEntity.setContentType("application/x-www-form-urlencoded");
            //将请求实体设置到httpPost对象中
            httpPost.setEntity(stringEntity);
        }

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = this.httpClient.execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * 文件下载 到文件夹
     *
     * @param url
     * @param fileName
     */
    public void download(String url, String fileName, String filePath) throws IOException {
        CloseableHttpResponse resultResponse = null;
        String defaultFileName = "C://";
        try {
            Map<String, String> params = new HashMap();
            params.put("fileName", fileName);
            params.put("filePath", filePath);
            URIBuilder uriBuilder = new URIBuilder(url);
            for (String key : params.keySet()) {
                uriBuilder.addParameter(key, params.get(key));
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            httpGet.setConfig(this.requestConfig);

            resultResponse = httpClient.execute(httpGet);

            HttpEntity entity = resultResponse.getEntity();
            InputStream is = entity.getContent();
            File file = new File(getFilePath(defaultFileName, resultResponse));
            file.getParentFile().mkdirs();
            int cache = 10 * 1024;
            try (FileOutputStream out = new FileOutputStream(file)) {
                /**
                 * 根据实际运行效果 设置缓冲区大小
                 */
                byte[] buffer = new byte[cache];
                int ch = 0;
                while ((ch = is.read(buffer)) != -1) {
                    out.write(buffer, 0, ch);
                }
            }
            is.close();
        } catch (Exception e) {
            LOGGER.error("download error:", e);
        } finally {
            if (resultResponse != null) {
                resultResponse.close();
            }
        }
    }

    //下载文件输出到http流中
    public void download(String url, String fileName, String filePath, HttpServletResponse response) throws IOException {
        CloseableHttpResponse resultResponse = null;
        String defaultFileName = "C://";
        try {
            Map<String, String> params = new HashMap();
            params.put("fileName", fileName);
            params.put("filePath", filePath);
            URIBuilder uriBuilder = new URIBuilder(url);
            for (String key : params.keySet()) {
                uriBuilder.addParameter(key, params.get(key));
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            httpGet.setConfig(this.requestConfig);

            resultResponse = httpClient.execute(httpGet);

            HttpEntity entity = resultResponse.getEntity();
            InputStream is = entity.getContent();
            OutputStream os = response.getOutputStream();
            int read = 0;
            byte[] temp = new byte[1024 * 1024];
            while ((read = is.read(temp)) > 0) {
                byte[] bytes = new byte[read];
                System.arraycopy(temp, 0, bytes, 0, read);
                os.write(bytes);
            }
            os.flush();
            is.close();
        } catch (Exception e) {
            LOGGER.error("download error:", e);
        } finally {
            if (resultResponse != null) {
                resultResponse.close();
            }
        }
    }

    /**
     * 获取response要下载的文件的默认路径
     *
     * @param response
     * @return
     */
    private String getFilePath(String defaultFilePath, HttpResponse response) {
        String filename = getFileName(response);
        if (filename != null) {
            defaultFilePath += filename;
        } else {
            defaultFilePath += getRandomFileName();
        }
        return defaultFilePath;
    }

    /**
     * 获取response header中Content-Disposition中的filename值
     *
     * @param response
     * @return
     */
    private String getFileName(HttpResponse response) {
        Header contentHeader = response.getFirstHeader("Content-Disposition");
        String filename = null;
        if (contentHeader != null) {
            HeaderElement[] values = contentHeader.getElements();
            if (values.length == 1) {
                NameValuePair param = values[0].getParameterByName("filename");
                if (param != null) {
                    try {
                        //filename = new String(param.getValue().toString().getBytes(), "utf-8");
                        //filename=URLDecoder.decode(param.getValue(),"utf-8");
                        filename = param.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filename;
    }

    /**
     * 获取随机文件名
     *
     * @return
     */
    private String getRandomFileName() {
        return String.valueOf(System.currentTimeMillis());
    }

}
