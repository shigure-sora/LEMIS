package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.StudentFrame;
import com.unicorn.lemis.view.user.TeacherFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:26
 */

public class SelectBarTea extends JPanel {


    private static CustomIcon buttonDefault;
    private static CustomIcon buttonRequest;
    private static CustomIcon buttonInfo;

    public SelectBarTea(){
        initialize();
        addButtion();
        addListener();
    }

    private void initialize() {
        Dimension preferredSize = new Dimension(48, FrameConsts.MAIN_FRAME_HEIGHT);
        this.setPreferredSize(preferredSize);
        this.setMaximumSize(preferredSize);
        this.setMinimumSize(preferredSize);
        this.setBackground(FrameConsts.SELECTBAR_ICON_COLOR);
        this.setLayout(new GridLayout(2, 1));
    }


    /**
     * @description 添加侧边选择按钮
     */
    private void addButtion() {

        JPanel panelUp = new JPanel();
        panelUp.setBackground(FrameConsts.SELECTBAR_ICON_COLOR);
        panelUp.setLayout(new FlowLayout(4, -2, 1));
        JPanel panelDown = new JPanel();
        panelDown.setBackground(FrameConsts.SELECTBAR_ICON_COLOR);
        panelDown.setLayout(new BorderLayout(0, 0));

        buttonDefault = new CustomIcon(FrameConsts.DEFAULT_ICON_ENABLE, FrameConsts.DEFAULT_ICON_ENABLE,
                FrameConsts.DEFAULT_ICON,"默认");
        buttonRequest = new CustomIcon(FrameConsts.REQUEST_ICON, FrameConsts.REQUEST_ICON_ENABLE,
                FrameConsts.REQUEST_ICON, "设备报修申请");
        buttonInfo = new CustomIcon(FrameConsts.I_ICON, FrameConsts.I_ICON_ENABLE,
                FrameConsts.I_ICON, "关于");


        panelUp.add(buttonDefault);
        panelUp.add(buttonRequest);


        panelDown.add(buttonInfo,BorderLayout.SOUTH);
        this.add(panelUp);
        this.add(panelDown);

    }
    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonDefault.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON_ENABLE);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);

            TeacherFrame.mainPanelCenter.removeAll();
            TeacherFrame.mainPanelCenter.add(TeacherFrame.teacherDefaultPanel, BorderLayout.CENTER);
            TeacherFrame.mainPanelCenter.updateUI();

        });

        buttonRequest.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON_ENABLE);
            ;
            TeacherFrame.mainPanelCenter.removeAll();
            TeacherFrame.mainPanelCenter.add(TeacherFrame.workerPanel, BorderLayout.CENTER);
            TeacherFrame.mainPanelCenter.updateUI();

        });

        buttonInfo.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON_ENABLE);

            TeacherFrame.mainPanelCenter.removeAll();
            TeacherFrame.mainPanelCenter.add(TeacherFrame.aboutPanel, BorderLayout.CENTER);
            TeacherFrame.mainPanelCenter.updateUI();

        });
    }
}
