package com.unicorn.lemis;

import com.unicorn.lemis.init.LEMIS_Initialize;
import java.awt.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author kano_dayo
 * @date 2021/6/14 16:07
 */

// TODO: 2021/6/27 update icon

public class Launch {
    public static final String ID = "LEMIS";
    public static final Logger LOGGER = LogManager.getLogger(ID);
    /**
     * @description Launch LEMIS
     *  本来想弄个Synchronized来整线程安全的，但是我这屎一样的代码，还可能会造成死锁，想想还是算了qwq
     *  用之前先修改config文件夹里的config。properties
     *  求个github关注qwq https://github.com/shigure-sora
     */
    public static void main(String[] args){
        //排队,节省内存,用完就销毁
        EventQueue.invokeLater(() -> {
            try {
                LEMIS_Initialize.onInitialize();
                LOGGER.info("アトリは、高性能ですから!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
