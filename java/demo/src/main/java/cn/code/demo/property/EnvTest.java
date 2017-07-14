package cn.code.demo.property;

import java.util.Map;

/**
 * Created by hang.lei on 2017/7/14.
 */
public class EnvTest {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for(Map.Entry<String,String> entry :env.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
