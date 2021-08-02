package com.unicorn.lemis.view.user;

import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.view.LoginFeature.RegistryFrame;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/21 1:32
 */

public class WorkerFrame extends JFrame implements ActionListener {
    private JFrame frame;

    public static JPanel mainPanelCenter;

    public static JTable dataTable;
    public static String global_user_id = null;
    JLabel labelTitle,labelSecondTitle,userInfo,user_name,welcome,timeLabel,text1,text2;

    public static WorkerArea workerPanel;
    public static WorkerDefaultPanel workerDefaultPanel;
    public static AboutPanel aboutPanel;

    private Timer time;


    public WorkerFrame() throws Exception{
        /**
         * @description 初始化维修员面板
         */
        LOGGER.info("Initializing WorkerFrame");
        frame = new JFrame();
        frame.setBounds(FrameConsts.MAIN_FRAME_X, FrameConsts.MAIN_FRAME_Y, FrameConsts.MAIN_FRAME_WIDTH, FrameConsts.MAIN_FRAME_HEIGHT);
        frame.setTitle(FrameConsts.SOFTWARE_NAME+" "+FrameConsts.SOFTWARE_VERSION);
        frame.setIconImage(FrameConsts.IMAGE_ICON);
        frame.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        JPanel mainPanel = new JPanel(true);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());
        JPanel panelDown = new JPanel();
        panelDown.setBackground(FrameConsts.SELECTBAR_BACK_COLOR);
        JLabel labelCopyright = new JLabel("Copyright 2021 | All Rights Reserved. Future-Tech Corporation  アトリは、高性能ですから! | www.soracraft.com");
        labelCopyright.setFont(FrameConsts.FONT_NORMAL);
        labelCopyright.setForeground(Color.WHITE);
        panelDown.add(labelCopyright);
        mainPanel.add(panelDown,BorderLayout.PAGE_END);
        SelectBarWorker selectbar = new SelectBarWorker();
        workerDefaultPanel = new WorkerDefaultPanel();
        workerPanel = new WorkerArea();
        aboutPanel = new AboutPanel();
        mainPanel.add(selectbar, BorderLayout.WEST);
        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(workerDefaultPanel, BorderLayout.CENTER);
        //mainPanelCenter.add(getTimelabel(),BorderLayout.SOUTH);

        mainPanel.add(mainPanelCenter, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LOGGER.info("Closing system...");
                LOGGER.info("アトリは、高性能ですから!");
            }
        });
    }
    // TODO: 2021/6/24 临时加上的小玩意
/*
    private JPanel getTimelabel() {
        LOGGER.info("成功获取用户数据");
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,1));
        if (timeLabel == null) {
            timeLabel = new JLabel("");
            userInfo = new JLabel("");
            user_name = new JLabel("");
            welcome = new JLabel("欢迎使用LEMIS!");
            text1 = new JLabel(" 当前登录用户：");
            text2 = new JLabel(" 权限组: ");
            timeLabel.setLayout(new BorderLayout());
            timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
            userInfo.setFont(new Font("微软雅黑", Font.BOLD, 12));
            user_name.setFont(new Font("微软雅黑", Font.BOLD, 12));
            welcome.setFont(new Font("微软雅黑", Font.BOLD, 12));
            text1.setFont(new Font("微软雅黑", Font.BOLD, 12));
            text2.setFont(new Font("微软雅黑", Font.BOLD, 12));
            userInfo.setForeground(new Color(238, 83, 80));
            user_name.setForeground(new Color(37, 174, 96));
            timeLabel.setForeground(new Color(112, 164, 255));
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timePanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
            time = new Timer(1000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    userInfo.setText(UserDataAccessObject.infoGetter(global_user_id));
                    user_name.setText(UserDataAccessObject.titleChecker(global_user_id));
                    timeLabel.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE HH:mm:ss").format(new Date()));

                }
            });
            time.start();
            timePanel.add(welcome);
            timePanel.add(text1);
            timePanel.add(userInfo);
            timePanel.add(text2);
            timePanel.add(user_name);
            timePanel.add(timeLabel);
        }
        return timePanel;
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

