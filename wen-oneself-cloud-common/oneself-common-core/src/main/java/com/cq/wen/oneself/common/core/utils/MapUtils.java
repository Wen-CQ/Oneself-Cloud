package com.cq.wen.oneself.common.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Title: MapUtils
 * @Author wen
 * @Date: 2022/7/15 17:15
 */
public class MapUtils {


    public static Map<String,Object> of(String k, Object v){
        Map<String, Object> map = new HashMap<>();
        map.put(k,v);
        return map;
    }

    public static Map<String,Object> of(String k, Object v,String k1, Object v1){
        Map<String, Object> map = new HashMap<>();
        map.put(k,v);
        map.put(k1,v1);
        return map;
   }

    public static Map<String,Object> of(String k, Object v,String k1, Object v1,String k2, Object v2){
        Map<String, Object> map = new HashMap<>();
        map.put(k,v);
        map.put(k1,v1);
        map.put(k2,v2);
        return map;
    }
}
