package com.unicorn.lemis.view.feature;

import com.unicorn.lemis.Launch;
import com.unicorn.lemis.Launch_TestMode;
import com.unicorn.lemis.view.feature.panel.SelectBarPanel;
import com.unicorn.lemis.view.user.AdministratorFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @description Frame相关的常量
 * @author kano_dayo
 * @date 2021/6/15 13:00
 */

public class FrameConsts {

    /**
     * @description 软件名称,版本
     */
    public final static String SOFTWARE_NAME = "LEMIS";
    public final static String SOFTWARE_VERSION = "2021.1";
    public final static String AIRILIB = "Airilib";
    public final static String AIRILIB_VERSION = "2020.3";
    public final static String AUTHOR = "kano_dayo";


    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit().getImage(AdministratorFrame.class.getResource("/assets/lemis/textures/LEMIS.png"));

    public final static ImageIcon ABOUT_LEMIS_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/LEMIS.png"));
    public final static ImageIcon AIRILIB_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Airilib.png"));
    public final static ImageIcon AUTHOR_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Author.png"));

    public final static ImageIcon DEFAULT_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default.png"));
    public final static ImageIcon DEFAULT_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default_Enable.png"));


    public final static ImageIcon LAB_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Lab.png"));
    public final static ImageIcon LAB_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Lab_Enable.png"));


    public final static ImageIcon EQUIP_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Equip.png"));
    public final static ImageIcon EQUIP_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Equip_Enable.png"));


    public final static ImageIcon REQUEST_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Request.png"));
    public final static ImageIcon REQUEST_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Request_Enable.png"));


    public final static ImageIcon TECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Technician.png"));
    public final static ImageIcon TECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Technician_Enable.png"));


    public final static ImageIcon WORKER_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Worker.png"));
    public final static ImageIcon WORKER_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Worker_Enable.png"));


    public final static ImageIcon CHECK_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Check.png"));
    public final static ImageIcon CHECK_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Check_Enable.png"));

    public final static ImageIcon NEWTECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/NewTech.png"));
    public final static ImageIcon NEWTECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/NewTech_Enable.png"));
    public final static ImageIcon NEWTECHNICIAN_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/NewTech_Disable.png"));

    public final static ImageIcon EDITTECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/EditTech.png"));
    public final static ImageIcon EDITTECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/EditTech_Enable.png"));
    public final static ImageIcon EDITTECHNICIAN_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/EditTech_Disable.png"));

    public final static ImageIcon DELETETECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/DeleteTech.png"));
    public final static ImageIcon DELETETECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/DeleteTech_Enable.png"));
    public final static ImageIcon DELETETECHNICIAN_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/DeleteTech_Disable.png"));

    public final static ImageIcon FRESHTECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/FreshTech.png"));
    public final static ImageIcon FRESHTECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/FreshTech_Enable.png"));
    public final static ImageIcon FRESHTECHNICIAN_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/FreshTech_Disable.png"));

    public final static ImageIcon QUERYTECHNICIAN_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/QueryTech.png"));
    public final static ImageIcon QUERYTECHNICIAN_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/QueryTech_Enable.png"));
    public final static ImageIcon QUERYTECHNICIAN_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/QueryTech_Disable.png"));


    public final static ImageIcon D1_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default2.png"));
    public final static ImageIcon D1_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default2e.png"));

    public final static ImageIcon D2_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default3.png"));
    public final static ImageIcon D2_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default3e.png"));

    public final static ImageIcon D3_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d4.png"));
    public final static ImageIcon D3_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d4e.png"));

    public final static ImageIcon D4_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d5.png"));
    public final static ImageIcon D4_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d5e.png"));

    public final static ImageIcon D5_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default1.png"));
    public final static ImageIcon D5_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Default1e.png"));

    public final static ImageIcon D6_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d6.png"));
    public final static ImageIcon D6_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/d6e.png"));

    public final static ImageIcon QUERYLAB_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Lab_Query.png"));
    public final static ImageIcon QUERYLAB_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Lab_Query_Enable.png"));
    public final static ImageIcon QUERYLAB_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon CHECKLIST_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Approve.png"));
    public final static ImageIcon CHECKLIST_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Approve_Enable.png"));
    public final static ImageIcon CHECKLIST_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon FIX_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Fix.png"));
    public final static ImageIcon FIX_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Fix_Enable.png"));
    public final static ImageIcon FIX_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon REJECT_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Reject.png"));
    public final static ImageIcon REJECT_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Reject_Enable.png"));
    public final static ImageIcon REJECT_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon CFIX_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/FixFail.png"));
    public final static ImageIcon CFIX_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/FixFail_Enable.png"));
    public final static ImageIcon CFIX_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon SENT_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Sent.png"));
    public final static ImageIcon SENT_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Sent_Enable.png"));
    public final static ImageIcon SENT_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon C_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/c.png"));
    public final static ImageIcon C_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/c_Enable.png"));
    public final static ImageIcon C_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static ImageIcon I_ICON = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/info.png"));
    public final static ImageIcon I_ICON_ENABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/info_Enable.png"));
    public final static ImageIcon I_ICON_DISABLE = new ImageIcon(AdministratorFrame.class.getResource("/assets/lemis/textures/Disable.png"));

    public final static Color MAIN_BACKGROUND_COLOR = Color.WHITE;

    public final static Color SELECTBAR_ICON_COLOR = new Color(255, 255, 255);
    public final static Color SELECTBAR_BACK_COLOR = new Color(37, 174, 96);
    public final static Color TABLE_LINE_COLOR = new Color(229, 229, 229);
    public final static Color Copyright_Color = new Color(255, 255, 255);

    public final static Color MAIN_BACK_COLOR = Color.WHITE;


    public final static  Font FONT_TITLE = new Font("Microsoft YaHei UI",0,27);
    public final static  Font FONT_SECONDTITLE = new Font("Microsoft YaHei UI",0,24);
    public final static  Font FONT_WELOCME = new Font("Microsoft YaHei UI",0,40);
    public final static  Font FONT_NORMAL = new Font("Microsoft YaHei UI", 0, 13);
    public final static  Font FONT_SUBTITLE = new Font("Microsoft YaHei UI",0,16);
    public final static  Font LABEL_FONT = new Font("Microsoft YaHei UI",0,13);
    public final static  Font INPUT_FONT = new Font("Microsoft YaHei UI",0,16);
    public final static  Font NormalUI_FONT = new Font("Microsoft YaHei UI",0,18);
    public final static  Font NormalUI2_FONT = new Font("Microsoft YaHei UI",0,14);
    /**
     * @description 主窗口大小
     */
    public final static int MAIN_FRAME_X = 507;
    public final static int MAIN_FRAME_Y = 297;
    public final static int MAIN_FRAME_WIDTH = 1640;
    public final static int MAIN_FRAME_HEIGHT = 846;

    /**
     * @description 登录窗口大小
     */
    public final static int LOGIN_FRAME_X = 1010;
    public final static int LOGIN_FRAME_Y = 520;
    public final static int LOGIN_FRAME_WIDTH = 550;
    public final static int LOGIN_FRAME_HEIGHT = 400;

    /**
     * @description 注册窗口大小
     */
    public final static int REGISTRY_FRAME_X = 1005;
    public final static int REGISTRY_FRAME_Y = 310;
    public final static int REGISTRY_FRAME_WIDTH = 550;
    public final static int REGISTRY_FRAME_HEIGHT = 820;

    /**
     * @description 找回密码窗口大小
     */
    public final static int RETRIEVE_FRAME_X = 1005;
    public final static int RETRIEVE_FRAME_Y = 520;
    public final static int RETRIEVE_FRAME_WIDTH = 550;
    public final static int RETRIEVE_FRAME_HEIGHT = 400;

    /**
     * @description 系统当前路径
     */
    public final static String CURRENT_DIR = System.getProperty("user.dir");

    // 样式布局相关
    /**
     * @description 主面板水平间隔
     */
    public final static int MAIN_H_GAP = 50;

    public final static Dimension LABLE_OBJ = new Dimension(1300, 30);
    public final static Dimension LABLE_OBJ_SIZE = new Dimension(78, 30);

}
