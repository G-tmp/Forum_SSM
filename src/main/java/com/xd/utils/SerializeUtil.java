package com.xd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SerializeUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     *  Serialize
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2String(T obj){
        if (obj == null)
            return null;


        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  unSeralize
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (clazz == null || str == null || str.equals(""))
            return null;


        try {
            return clazz.equals(String.class) ? (T)str : objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
