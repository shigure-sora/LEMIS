package com.unicorn.lemis.init;

import com.unicorn.lemis.view.LoginFeature.LoginFrame;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/14 16:11
 */

public class LEMIS_Initialize {
    public LEMIS_Initialize(){onInitialize();}
    public static void onInitialize(){
        LOGGER.info("Initializing . . .");
        LOGGER.info("Loading config...");
        LoginFrame loginFrame = new LoginFrame();

    }
}
