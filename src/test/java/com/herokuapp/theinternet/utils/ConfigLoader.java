package com.herokuapp.theinternet.utils;

import com.herokuapp.theinternet.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.PRODUCTION));
        switch (EnvType.valueOf(env)){
            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
                break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                break;
            default:
                throw new IllegalStateException("Invalid Enviroment Type" + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }

        return configLoader;

    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) {
            return prop;
        }
        else {
            throw new RuntimeException("property baseUrl is not specified in the configs.properties file");
        }
    }
}
