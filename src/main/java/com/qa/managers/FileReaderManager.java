package com.qa.managers;

import com.qa.dataProvider.ConfigFileReader;

public class FileReaderManager {
    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {

    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public static void setConfigFileReader(ConfigFileReader configFileReader) {
        FileReaderManager.configFileReader = configFileReader;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
