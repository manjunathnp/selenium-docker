package com.automation.utilities;

import com.automation.tests.vendorportal.model.VendorPortalTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JSonUtils {
    private static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);
    private static final ObjectMapper mapper=new ObjectMapper();

    public static <T> T getTestData(String path, Class<T> type){
        try(InputStream stream=ResourceLoader.getResource(path)){
            return mapper.readValue(stream, type);
        }catch (Exception e){
            log.error("Unable to Read TestData File {}",path, e);
        }
        return null;
    }
}
