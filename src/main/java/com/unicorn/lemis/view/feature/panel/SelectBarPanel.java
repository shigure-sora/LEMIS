package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.Launch_TestMode;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.util.PropertyUtil;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.Launch_TestMode;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.TechnicianFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author kano_dayo
 * @date 2021/6/22 22:00
 */

public class SelectBarPanel extends JPanel {

    public static String global_user_id = null;


    private static CustomIcon buttonDefault;
    private static CustomIcon buttonLab;
    private static CustomIcon buttonEquip;
    private static CustomIcon buttonTech;
    private static CustomIcon buttonRequest;
    private static CustomIcon buttonWorker;
    private static CustomIcon buttonCheck;
    private static CustomIcon buttonInfo;

    public SelectBarPanel(){
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
        buttonLab = new CustomIcon(FrameConsts.LAB_ICON, FrameConsts.LAB_ICON_ENABLE,
                FrameConsts.LAB_ICON, "实验室管理");
        buttonEquip = new CustomIcon(FrameConsts.EQUIP_ICON, FrameConsts.EQUIP_ICON_ENABLE,
                FrameConsts.EQUIP_ICON, "设备管理");
        buttonTech = new CustomIcon(FrameConsts.TECHNICIAN_ICON, FrameConsts.TECHNICIAN_ICON_ENABLE,
                FrameConsts.TECHNICIAN_ICON,"实验技术员管理");
        buttonRequest = new CustomIcon(FrameConsts.REQUEST_ICON, FrameConsts.REQUEST_ICON_ENABLE,
                FrameConsts.REQUEST_ICON, "设备报修申请");
        buttonWorker = new CustomIcon(FrameConsts.WORKER_ICON, FrameConsts.WORKER_ICON_ENABLE,
                FrameConsts.WORKER_ICON,"维修员工作列表");
        buttonCheck = new CustomIcon(FrameConsts.CHECK_ICON, FrameConsts.CHECK_ICON_ENABLE,
                FrameConsts.CHECK_ICON, "报修申请审核");
        buttonInfo = new CustomIcon(FrameConsts.I_ICON, FrameConsts.I_ICON_ENABLE,
                FrameConsts.I_ICON, "关于");

        panelUp.add(buttonDefault);
        panelUp.add(buttonLab);
        panelUp.add(buttonEquip);
        panelUp.add(buttonRequest);
        panelUp.add(buttonTech);
        panelUp.add(buttonWorker);
        panelUp.add(buttonCheck);
        panelDown.add(buttonInfo,BorderLayout.SOUTH);


        this.add(panelUp);
        this.add(panelDown);

    }
    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonDefault.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON_ENABLE);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

                AdministratorFrame.mainPanelCenter.removeAll();
                AdministratorFrame.mainPanelCenter.add(AdministratorFrame.defaultPanel, BorderLayout.CENTER);
                AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonLab.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON_ENABLE);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            AdministratorFrame.mainPanelCenter.removeAll();
            AdministratorFrame.mainPanelCenter.add(AdministratorFrame.laboratoryManagePanel, BorderLayout.CENTER);
            AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonEquip.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON_ENABLE);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

                AdministratorFrame.mainPanelCenter.removeAll();
                AdministratorFrame.mainPanelCenter.add(AdministratorFrame.equipmentManagePanel, BorderLayout.CENTER);
                AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonTech.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON_ENABLE);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            AdministratorFrame.mainPanelCenter.removeAll();
            AdministratorFrame.mainPanelCenter.add(AdministratorFrame.technicianManagePanel, BorderLayout.CENTER);
            AdministratorFrame.mainPanelCenter.updateUI();
        });

        buttonRequest.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON_ENABLE);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

                AdministratorFrame.mainPanelCenter.removeAll();
                AdministratorFrame.mainPanelCenter.add(AdministratorFrame.requestPanel, BorderLayout.CENTER);
                AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonWorker.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON_ENABLE);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON);

                AdministratorFrame.mainPanelCenter.removeAll();
                AdministratorFrame.mainPanelCenter.add(AdministratorFrame.workerPanel, BorderLayout.CENTER);
                AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonCheck.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON_ENABLE);
            buttonInfo.setIcon(FrameConsts.I_ICON);

            AdministratorFrame.mainPanelCenter.removeAll();
            AdministratorFrame.mainPanelCenter.add(AdministratorFrame.checkPanel, BorderLayout.CENTER);
            AdministratorFrame.mainPanelCenter.updateUI();

        });

        buttonInfo.addActionListener(e -> {

            buttonDefault.setIcon(FrameConsts.DEFAULT_ICON);
            buttonLab.setIcon(FrameConsts.LAB_ICON);
            buttonEquip.setIcon(FrameConsts.EQUIP_ICON);
            buttonTech.setIcon(FrameConsts.TECHNICIAN_ICON);
            buttonRequest.setIcon(FrameConsts.REQUEST_ICON);
            buttonWorker.setIcon(FrameConsts.WORKER_ICON);
            buttonCheck.setIcon(FrameConsts.CHECK_ICON);
            buttonInfo.setIcon(FrameConsts.I_ICON_ENABLE);

            AdministratorFrame.mainPanelCenter.removeAll();
            AdministratorFrame.mainPanelCenter.add(AdministratorFrame.aboutPanel, BorderLayout.CENTER);
            AdministratorFrame.mainPanelCenter.updateUI();

        });
    }

    public static void reload(){
        SelectBarPanel.buttonRequest.updateUI();
        SelectBarPanel.buttonCheck.updateUI();
        SelectBarPanel.buttonEquip.updateUI();
        SelectBarPanel.buttonLab.updateUI();
        SelectBarPanel.buttonWorker.updateUI();
        SelectBarPanel.buttonTech.updateUI();
        SelectBarPanel.buttonDefault.updateUI();
    }

}
