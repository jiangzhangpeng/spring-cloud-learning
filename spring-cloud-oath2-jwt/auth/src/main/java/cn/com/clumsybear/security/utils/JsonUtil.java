package cn.com.clumsybear.security.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
    public static String toJson(Object object){
      return JSON.toJSONString(object);
    }
}
