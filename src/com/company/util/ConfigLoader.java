package com.company.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private HashMap<String, ConfigReader> addresses;
    private ConfigReader gameConstants;
    private ConfigReader graphicConfig;
    private String defaultURL = "src/com/company/resources/MainConfigFile.properties";
    private String URLName = "RESOURCES_URL";
    private String imageRepo;

    private ConfigLoader(){
        init();
    }

    public static ConfigLoader getInstance(){
        if (configLoader == null)
            configLoader = new ConfigLoader();
        return configLoader;
    }

    private void init() {
        addresses = new HashMap<>();
        try {
            ConfigReader addresses = new ConfigReader();
            Reader reader = new FileReader(defaultURL);
            addresses.load(reader);
            this.addresses.put(URLName, addresses);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Main config file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadConfigurations();
    }

    private void loadConfigurations() {

        for (Map.Entry entry: addresses.get(URLName).entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());

            String address = (String) entry.getValue();
            String key = ((String) entry.getKey()).toLowerCase();

            ConfigReader configs = new ConfigReader();

            if (key.contains("url")){
                try {
                    File file = new File(address);
                    FileReader reader = new FileReader(file);
                    configs.load(reader);
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println(key + " file not found");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(key + " load failed");
                }
            }

            if(key.contains("game")){
                gameConstants = configs;
            } else if(key.contains("graphic")){
                graphicConfig = configs;
            } else if(key.contains("image")){
                imageRepo = address;
            }
        }
    }

    public  ConfigReader getGameConstants() {
        return gameConstants;
    }

    public ConfigReader getGraphicConfig() {
        return graphicConfig;
    }

    public String getImageRepo() {
        return imageRepo;
    }

    public String getAddress(String addressName) {
        return addresses.get(URLName).getProperty(addressName);
    }
}
