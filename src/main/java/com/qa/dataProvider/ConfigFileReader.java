package com.qa.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;
    public String environment;
    public ConfigFileReader() {
   //     environment = System.getProperty("config");
        String envFilePath = "src/test/resources/config/config.properties";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(envFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(envFilePath + " file not found at ");
        }
    }


    public String getToNopURL() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("Application URL not found");
    }


}
