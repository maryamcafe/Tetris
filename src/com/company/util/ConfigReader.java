package com.company.util;

import java.util.Properties;

public class ConfigReader extends Properties {
    //we want some method to parse integer from string
    public int readInt(String keyName){
        return Integer.parseInt(this.getProperty(keyName));
    }

    public boolean readBoolean(String keyName) {
        return Boolean.parseBoolean(this.getProperty(keyName));
    }


}
