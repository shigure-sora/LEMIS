package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.LabDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.view.feature.FrameConsts;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author kano_dayo
 * @date 2021/6/24 17:00
 */

public class LabDelete extends JFrame implements ActionListener {

    public static String gName = null;
    public static String gStatus = null;
    public static String gUid = null;


    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    JPanel panel;
    JLabel user_idLabel,user_teleLabel,user_NameLabel;
    JLabel banner,footer;
    JButton button2,button1;
    JLabel user_name,user_id,user_tele;
    public LabDelete(){

        user_name = new JLabel(gUid);
        user_id = new JLabel(gName);
        user_tele = new JLabel(gStatus);
        user_name.setFont(FrameConsts.LABEL_FONT);
        user_tele.setFont(FrameConsts.LABEL_FONT);
        //说明栏
        user_idLabel = new JLabel("实验室ID");
        user_teleLabel = new JLabel("实验室状态");
        user_NameLabel = new JLabel("实验室名称");
        user_idLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);
        user_NameLabel.setFont(FrameConsts.LABEL_FONT);

        panel=new JPanel();
        button2=new JButton("确 定");
        button1=new JButton("取 消");
        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        user_name.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        user_tele.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));

        /**
         * @description Location
         */
        user_name.setHorizontalAlignment(SwingConstants.CENTER);
        user_tele.setHorizontalAlignment(SwingConstants.CENTER);
        user_id.setHorizontalAlignment(SwingConstants.CENTER);
        //Label Location
        user_idLabel.setBounds(200,25,65,37);
        user_teleLabel.setBounds(200,85,65,37);
        user_NameLabel.setBounds(200,55,65,37);
        user_teleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_name.setBounds(230,25,150,37);
        user_tele.setBounds(230,85,150,37);
        user_id.setBounds(230,55,150,37);

        //button and box
        button2.setBounds(153,125,100,37);
        button1.setBounds(283,125,100,37);
        button2.setFont(new Font("Microsoft YaHei UI",0,16));
        button1.setFont(new Font("Microsoft YaHei UI",0,16));
        button2.setBackground(new Color(255, 255, 255));
        button2.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(user_idLabel);
        panel.add(user_teleLabel);
        panel.add(user_NameLabel);

        panel.add(user_name);
        panel.add(user_tele);
        panel.add(user_id);

        panel.add(button2);
        panel.add(button1);
        this.add(panel);
        this.setLocation(1005,610);//position
        this.setSize(550,210);
        this.add(panel,BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("删除");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button2.addActionListener(this);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event_delete) {
        if (event_delete.getSource() == button2) {
            LabDataAccessObject del = new LabDataAccessObject();
            try {
                del.delete(gUid);
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                JOptionPane.showMessageDialog(jFrame, "删除成功");
                this.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (event_delete.getSource() == button1) {
            this.dispose();
        }
    }
}
