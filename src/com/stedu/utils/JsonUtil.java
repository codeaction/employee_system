package com.stedu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJSON(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static void toJSON(OutputStream out, Object obj) throws IOException {
        mapper.writeValue(out, obj);
    }
}
