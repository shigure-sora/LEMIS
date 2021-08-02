package com.unicorn.lemis.util;

import java.io.*;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * check if config.properties exists （2021.6.27更新，此功能现已废弃，仅保留检查字符串功能）
 * @author kano_dayo
 * @date 2021/6/17 17:14
 */

public class ConfigManager {
    private volatile static ConfigManager confManager;
    private static Properties props;
    //判断输入字符是否为空
    //trim() 方法用于删除字符串的头尾空白符
    public static boolean isEmpty(String code){
        if(code==null || "".equals(code.trim())){//输入为空或者输入字符串为空串
            return true;
        }else{
            return false;
        }
    }
    //判断是否不是空
    public static boolean isNotEmpty(String code){//输入为空或者输入字符串为空串
        if(code!=null && !"".equals(code.trim())){
            return true;
        }else{
            return false;
        }
    }
}

