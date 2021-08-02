package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.TechnicianFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:26
 */

public class TechDefaultPanel extends JPanel {


    UserDataAccessObject user = new UserDataAccessObject();



    public static JTable dataTable;
    public static String global_user_id = null;

    private static CustomIcon buttonEquip;
    private static CustomIcon buttonRequest;
    private static CustomIcon buttonWorker;
    private Timer time;

    JLabel labelTitle,labelSecondTitle,userInfo,user_name,welcome,timeLabel,text1,text2;



    public TechDefaultPanel(){
        super();
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        addParts();
        addListener();

    }

    public void addParts(){
        this.add(getUpPanel(),BorderLayout.NORTH);
        this.add(getCenterPanel(),BorderLayout.CENTER);
        this.add(getTimelabel(),BorderLayout.SOUTH);

    }

    private JPanel getUpPanel(){
        JPanel upPanel = new JPanel();
        upPanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        upPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,200));
        JPanel up = new JPanel();
        up.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        up.setLayout(new GridLayout(2,1));
        //大标题与小标题
        String strMsg1 = "Laboratory Equipment Management Information System";
        String strMsg2 = "实 验 设 备 管 理 信 息 系 统";
        labelTitle = new JLabel(strMsg1);
        labelSecondTitle = new JLabel(strMsg2);
        labelTitle.setFont(FrameConsts.FONT_WELOCME);
        labelTitle.setForeground(Color.black);
        labelSecondTitle.setFont(FrameConsts.FONT_SECONDTITLE);
        labelSecondTitle.setForeground(Color.black);
        labelSecondTitle.setHorizontalAlignment(SwingConstants.CENTER);
        up.add(labelTitle);
        up.add(labelSecondTitle);
        upPanel.add(up);
        return upPanel;
    }

    private JPanel getCenterPanel(){

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        centerPanel.setLayout(new BorderLayout());

        JPanel selectArea = new JPanel();
        selectArea.setLayout(new BorderLayout());
        selectArea.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        JPanel selectFunctionPanel = new JPanel();
        selectFunctionPanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        selectFunctionPanel.setLayout(new FlowLayout(FlowLayout.CENTER,25,5));

        buttonEquip = new CustomIcon(FrameConsts.D2_ICON,FrameConsts.D2_ICON_ENABLE,FrameConsts.D2_ICON,"");
        buttonWorker = new CustomIcon(FrameConsts.D4_ICON,FrameConsts.D4_ICON_ENABLE,FrameConsts.D4_ICON,"");
        buttonRequest = new CustomIcon(FrameConsts.D5_ICON,FrameConsts.D5_ICON_ENABLE,FrameConsts.D5_ICON,"");

        selectFunctionPanel.add(buttonEquip);
        selectFunctionPanel.add(buttonWorker);
        selectFunctionPanel.add(buttonRequest);

        selectArea.add(selectFunctionPanel,BorderLayout.CENTER);
        centerPanel.add(selectArea,BorderLayout.CENTER);
        return centerPanel;

    }

    // TODO: 2021/6/24 临时加上的小玩意

    private JPanel getTimelabel() {
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 1));
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
            time = new Timer(1000, new ActionListener() {
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
    }
    private void addListener(){
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonEquip.addActionListener(e -> {
            TechnicianFrame.mainPanelCenter.removeAll();TechnicianFrame.mainPanelCenter.add(TechnicianFrame.equipmentManagePanel,BorderLayout.CENTER);TechnicianFrame.mainPanelCenter.updateUI();
        });
        buttonWorker.addActionListener(e -> {
            TechnicianFrame.mainPanelCenter.removeAll();TechnicianFrame.mainPanelCenter.add(TechnicianFrame.workerPanel,BorderLayout.CENTER);TechnicianFrame.mainPanelCenter.updateUI();
        });
        buttonRequest.addActionListener(e -> {
            TechnicianFrame.mainPanelCenter.removeAll();TechnicianFrame.mainPanelCenter.add(TechnicianFrame.requestPanel,BorderLayout.CENTER);TechnicianFrame.mainPanelCenter.updateUI();
        });
    }

}
