package com.automation.utilities;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DemoReader {
    public static void main(String[] args) throws Exception{
        InputStream inputStream=ResourceLoader.getResource("test-suites/a/testFile.txt");

        String content=IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        System.out.println(content);
    }
}
