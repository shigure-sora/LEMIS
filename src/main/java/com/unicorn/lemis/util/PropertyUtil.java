package com.unicorn.lemis.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.unicorn.lemis.Launch.LOGGER;
/**
 * @author kano_dayo
 * @date 2021/6/15 12:39
 */

public class PropertyUtil {
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(UtilConsts.PATH_CONFIG));
            properties.load(in);
            String value = properties.getProperty(key);
            LOGGER.info("Successful");
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("Fail to load config");
            return null;
        }
    }
    /**
    public static String getLanguage(String key){
        Properties prop = new Properties();
        try {
            InputStream in1 = new BufferedInputStream(new FileInputStream(UtilConsts.LANGUAGE_PROPERTY));
            prop.load(in1);
            String value = prop.getProperty(key);
            return value;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }*/

}
