package com.jjdev.eagle.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author JGilson
 */
public class JJsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JJsonUtils.class);

    public JJsonUtils() {
    }

    /**
     * Convert Java object to JSON.
     *
     * @param object
     * @return String
     */
    public static String objectToJson(Object object) {

        if (object == null) {
            log.info("Null value for objectToJson.");
            return null;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            log.error("ERROR Convert objectToJson. {}", ex);
            return null;
        }
    }

    /**
     * Convert JSON to Java object.
     *
     * @param object
     * @return Object
     */
    public static Object jsonToObject(String json, Class<?> classType) {

        if (json == null || json.isEmpty()) {
            log.info("Null or empty value for jsonToObject.");
            return null;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, classType);
        } catch (IOException ex) {
            log.error("ERROR Convert jsonToObject. {}", ex);
            return null;
        }
    }

}
