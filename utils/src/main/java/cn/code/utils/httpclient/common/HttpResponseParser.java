package cn.code.utils.httpclient.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http请求解析工具
 */
public class HttpResponseParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpResponseParser.class);

    private HttpResponseParser() {
        throw new IllegalAccessError("HttpResponseParser class");
    }

    /**
     * 返回response中的数据
     *
     * @param response
     * @return
     */
    public static String getSuccessResponse(HttpResponse response) {
        String responseStr = null;
        HttpEntity entity = null;
        if (response == null) {
            return null;
        }
        try {
            //http请求状态码
            int statusCode = response.getStatusLine().getStatusCode();
            LOGGER.info("状态码 : " + statusCode);
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            responseStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            LOGGER.error("getSuccessResponse error,entity is {},error is ", JSON.toJSON(entity), e);
        }
        return responseStr;
    }


}
