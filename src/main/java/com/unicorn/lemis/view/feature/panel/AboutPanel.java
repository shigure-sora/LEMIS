package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;

import javax.swing.*;
import java.awt.*;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:24
 */

public class AboutPanel extends JPanel {

    JLabel labelTitle;

    public AboutPanel() {
        initialize();
        addComponent();
    }

    private void initialize() {
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent() {

        this.add(getUpPanel(),BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);

    }

    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, FrameConsts.MAIN_H_GAP, 15));
        labelTitle = new JLabel("关于LEMIS");
        labelTitle.setFont(FrameConsts.FONT_TITLE);
        labelTitle.setForeground(FrameConsts.SELECTBAR_BACK_COLOR);
        panelUp.add(labelTitle);
        return panelUp;
    }

    /**
     * 中部
     */
    private JPanel getCenterPanel() {
        // 中间面板
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 165));

        // 图标、版本Grid
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelInfo.setLayout(new GridLayout(3, 3));

        JPanel panelInfo1 = new JPanel();
        panelInfo.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelInfo.setLayout(new GridLayout(3, 3));

        // 初始化组件
        CustomIcon iconAbout = new CustomIcon(FrameConsts.ABOUT_LEMIS_ICON, FrameConsts.ABOUT_LEMIS_ICON, FrameConsts.ABOUT_LEMIS_ICON, "");
        CustomIcon iconAirilib = new CustomIcon(FrameConsts.AIRILIB_ICON, FrameConsts.AIRILIB_ICON, FrameConsts.AIRILIB_ICON, "");
        CustomIcon iconAuthor = new CustomIcon(FrameConsts.AUTHOR_ICON, FrameConsts.AUTHOR_ICON, FrameConsts.AUTHOR_ICON, "");
        JLabel labelName = new JLabel(FrameConsts.SOFTWARE_NAME);
        JLabel labelVersion = new JLabel(" "+"版本 "+FrameConsts.SOFTWARE_VERSION);
        JLabel labelAirilib = new JLabel(FrameConsts.AIRILIB);
        JLabel labelAirilibVersion = new JLabel(" "+"版本 "+FrameConsts.AIRILIB_VERSION);
        JLabel labelAuthor = new JLabel(FrameConsts.AUTHOR);
        JLabel label1 = new JLabel("软件信息");
        JLabel label2 = new JLabel("Airilib信息");
        JLabel label3 = new JLabel("作者");

        // 字体
        labelName.setFont(FrameConsts.FONT_NORMAL);
        labelVersion.setFont(FrameConsts.FONT_NORMAL);
        labelAirilib.setFont(FrameConsts.FONT_NORMAL);
        labelAirilibVersion.setFont(FrameConsts.FONT_NORMAL);
        labelAuthor.setFont(FrameConsts.FONT_NORMAL);
        label1.setFont(FrameConsts.FONT_NORMAL);
        label2.setFont(FrameConsts.FONT_NORMAL);
        label3.setFont(FrameConsts.FONT_NORMAL);

        // 大小
        Dimension size = new Dimension(150, 30);
        labelName.setPreferredSize(size);
        labelVersion.setPreferredSize(size);
        labelAirilib.setPreferredSize(size);
        labelAirilibVersion.setPreferredSize(size);
        labelAuthor.setPreferredSize(size);
        Dimension size1 = new Dimension(50, 30);
        label1.setPreferredSize(size1);
        label2.setPreferredSize(size1);
        label3.setPreferredSize(size1);

        // 组合元素
        panelInfo.add(label1);
        panelInfo.add(iconAbout);
        panelInfo.add(labelName);
        panelInfo.add(labelVersion);
        panelInfo.add(label2);
        panelInfo.add(iconAirilib);
        panelInfo.add(labelAirilib);
        panelInfo.add(labelAirilibVersion);
        panelInfo.add(label3);
        panelInfo.add(iconAuthor);
        panelInfo.add(labelAuthor);

        panelCenter.add(panelInfo);
        return panelCenter;
    }
}
