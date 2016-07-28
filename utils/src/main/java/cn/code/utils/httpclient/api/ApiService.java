package cn.code.utils.httpclient.api;

import cn.code.utils.httpclient.common.HttpResponseParser;
import cn.code.utils.httpclient.common.HttpTools;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 针对API请求的封装
 */
@Service
public class ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);

    private static String apiUrl;

    /**
     * 获取API请求服务器地址
     *
     * @return
     */
    public String getApiUrl() {
        if (apiUrl == null) {
            //从数据库或者配置文件中加载一次
            apiUrl = "";//NOSONAR
        }
        return apiUrl;
    }

    /**
     * 请求API，返回一个对象
     *
     * @param url    api地址
     * @param cls    预期返回的对象，String.class,boolean.class
     * @param params 请求参数
     * @param <T>    对象
     * @return
     */
    public <T> T getForObject(String url, Class<T> cls, Map<String, String> params) {
        String jsonStr = HttpResponseParser.getSuccessResponse(HttpTools.doGet(url, params, false));
        if (jsonStr == null) {
            return null;
        }
        if (cls == null) {
            LOGGER.error("param cls is null");
            return null;
        }
        //将返回结果从json转换为Map
        Map<String, Object> resultMap = JSON.parseObject(jsonStr, HashMap.class);
        T obj = null;
        String code = (String) resultMap.get("code");
        //如果返回成功
        if (ApiResponseCode.SUCCESS.equals(code)) {
            try {
                obj = JSONObject.parseObject(resultMap.get("data").toString(), cls);
            } catch (Exception e) {
                obj = (T) resultMap.get("data");
                LOGGER.error("parseObject error ,date is {},error is ", JSON.toJSON(resultMap.get("data")), e);
            }
        }
        return obj;
    }
}
