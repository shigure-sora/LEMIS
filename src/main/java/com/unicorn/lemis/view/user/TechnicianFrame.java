package com.unicorn.lemis.view.user;

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

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/21 1:32
 */

public class TechnicianFrame extends JFrame implements ActionListener {
    private JFrame frame;

    public static JPanel mainPanelCenter;

    public static RegistryFrame registryFrame;

    private static CustomIcon buttonDefault;
    private static CustomIcon buttonLab;
    private static CustomIcon buttonEquip;
    private static CustomIcon buttonTech;
    private static CustomIcon buttonRequest;
    private static CustomIcon buttonWorker;
    private static CustomIcon buttonCheck;

    public static TechDefaultPanel defaultPanel;
    public static TechnicianEquipmentManagePanel equipmentManagePanel;
    public static TechnicianRequestPanel requestPanel;
    public static TechnicianWorkerPanel workerPanel;
    public static AboutPanel aboutPanel;
    private Timer time;

    public TechnicianFrame() throws Exception{
        /**
         * @description 初始化技术员面板
         */
        frame = new JFrame();
        frame.setBounds(FrameConsts.MAIN_FRAME_X, FrameConsts.MAIN_FRAME_Y, FrameConsts.MAIN_FRAME_WIDTH, FrameConsts.MAIN_FRAME_HEIGHT);
        frame.setTitle(FrameConsts.SOFTWARE_NAME+" "+FrameConsts.SOFTWARE_VERSION);
        frame.setIconImage(FrameConsts.IMAGE_ICON);
        frame.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        JPanel mainPanel = new JPanel(true);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());
        JPanel panelDown = new JPanel();
        panelDown.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        JLabel labelCopyright = new JLabel("Copyright 2021 | All Rights Reserved. Future-Tech Corporation  アトリは、高性能ですから! | www.soracraft.com");
        labelCopyright.setFont(FrameConsts.FONT_NORMAL);
        labelCopyright.setForeground(Color.BLACK);
        panelDown.add(labelCopyright);
        mainPanel.add(panelDown,BorderLayout.PAGE_END);

        //选择栏
        SelectBarPanelTech selectbar = new SelectBarPanelTech();
        defaultPanel = new TechDefaultPanel();
        equipmentManagePanel = new TechnicianEquipmentManagePanel();
        requestPanel = new TechnicianRequestPanel();
        workerPanel = new TechnicianWorkerPanel();
        aboutPanel = new AboutPanel();

        mainPanel.add(selectbar, BorderLayout.WEST);

        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(defaultPanel, BorderLayout.CENTER);

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
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
