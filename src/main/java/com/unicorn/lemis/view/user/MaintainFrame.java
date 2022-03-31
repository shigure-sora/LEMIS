package com.unicorn.lemis.view.user;

import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.AboutPanel;
import com.unicorn.lemis.view.feature.panel.SelectBarWorker;
import com.unicorn.lemis.view.feature.panel.WorkerArea;
import com.unicorn.lemis.view.feature.panel.WorkerDefaultPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2022/3/25 1:32
 */

public class MaintainFrame extends JFrame implements ActionListener {
    private JFrame frame;

    public static JPanel mainPanelCenter;

    public static JTable dataTable;
    public static String global_user_id = null;
    JLabel labelTitle,labelSecondTitle,userInfo,user_name,welcome,timeLabel,text1,text2;

    public static WorkerArea workerPanel;
    public static WorkerDefaultPanel workerDefaultPanel;
    public static AboutPanel aboutPanel;

    private Timer time;


    public MaintainFrame() throws Exception{

        /**
         * @description 初始化维修员面板
         */
        LOGGER.info("Initializing MaintainFrame");
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
     //TODO: 2021/6/24 临时加上的小玩意
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

