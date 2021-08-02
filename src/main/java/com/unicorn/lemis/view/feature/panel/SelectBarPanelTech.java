package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.TechnicianFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author kano_dayo
 * @date 2021/6/22 22:00
 */

public class SelectBarPanelTech extends JPanel{


    private static CustomIcon buttonDefault;
    private static CustomIcon buttonEquip;
    private static CustomIcon buttonRequest;
    private static CustomIcon buttonWorker;
    private static CustomIcon buttonInfo;

    public SelectBarPanelTech(){
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
        buttonEquip = new CustomIcon(FrameConsts.EQUIP_ICON, FrameConsts.EQUIP_ICON_ENABLE,
                FrameConsts.EQUIP_ICON, "设备管理");
        buttonRequest = new CustomIcon(FrameConsts.REQUEST_ICON, FrameConsts.REQUEST_ICON_ENABLE,
                FrameConsts.REQUEST_ICON, "设备报修申请");
        buttonWorker = new CustomIcon(FrameConsts.WORKER_ICON, FrameConsts.WORKER_ICON_ENABLE,
                FrameConsts.WORKER_ICON,"维修员工作列表");
        buttonInfo = new CustomIcon(FrameConsts.I_ICON, FrameConsts.I_ICON_ENABLE,
                FrameConsts.I_ICON, "关于");


        panelUp.add(buttonDefault);
        panelUp.add(buttonEquip);
        panelUp.add(buttonRequest);
        panelUp.add(buttonWorker);


        panelDown.add(buttonInfo,BorderLayout.SOUTH);
        this.add(panelUp);
        this.add(panelDown);

    }
    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonDefault.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON_ENABLE);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            TechnicianFrame.mainPanelCenter.removeAll();
            TechnicianFrame.mainPanelCenter.add(TechnicianFrame.defaultPanel, BorderLayout.CENTER);
            TechnicianFrame.mainPanelCenter.updateUI();

        });

        buttonEquip.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON_ENABLE);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            TechnicianFrame.mainPanelCenter.removeAll();
            TechnicianFrame.mainPanelCenter.add(TechnicianFrame.equipmentManagePanel, BorderLayout.CENTER);
            TechnicianFrame.mainPanelCenter.updateUI();

        });

        buttonRequest.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON_ENABLE);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            TechnicianFrame.mainPanelCenter.removeAll();
            TechnicianFrame.mainPanelCenter.add(TechnicianFrame.requestPanel, BorderLayout.CENTER);
            TechnicianFrame.mainPanelCenter.updateUI();

        });

        buttonWorker.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON_ENABLE);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            TechnicianFrame.mainPanelCenter.removeAll();
            TechnicianFrame.mainPanelCenter.add(TechnicianFrame.workerPanel, BorderLayout.CENTER);
            TechnicianFrame.mainPanelCenter.updateUI();

        });

        buttonInfo.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON_ENABLE);

            TechnicianFrame.mainPanelCenter.removeAll();
            TechnicianFrame.mainPanelCenter.add(TechnicianFrame.aboutPanel, BorderLayout.CENTER);
            TechnicianFrame.mainPanelCenter.updateUI();

        });
    }
}
