package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
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
 * @date 2021/6/24 23:14
 */

public class EquipDelete extends JFrame implements ActionListener {

    public static String gName = null;
    public static String gStatus = null;
    public static String gUid = null;


    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    JPanel panel;
    JLabel user_idLabel,user_teleLabel,namel;
    JLabel banner,footer;
    JButton button2,button1;
    JLabel user_name,user_id,user_tele;

    public EquipDelete(){

        user_name = new JLabel(gUid);
        user_id = new JLabel(gName);
        user_tele = new JLabel(gStatus);
        user_name.setFont(FrameConsts.LABEL_FONT);
        user_tele.setFont(FrameConsts.LABEL_FONT);
        //说明栏
        user_idLabel = new JLabel("设备ID");
        namel = new JLabel("设备名");
        user_teleLabel = new JLabel("类别");
        user_idLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);
        namel.setFont(FrameConsts.LABEL_FONT);


        panel=new JPanel();
        button2=new JButton("确 定");
        button1=new JButton("取 消");
        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        user_name.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        user_tele.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        user_id.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));

        /**
         * @description Location
         */
        user_name.setHorizontalAlignment(SwingConstants.CENTER);
        user_tele.setHorizontalAlignment(SwingConstants.CENTER);
        user_id.setHorizontalAlignment(SwingConstants.CENTER);
        //Label Location
        user_idLabel.setBounds(150,25,65,37);
        user_teleLabel.setBounds(150,105,65,37);
        namel.setBounds(150,65,65,37);
        user_teleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namel.setHorizontalAlignment(SwingConstants.CENTER);
        user_name.setBounds(230,25,150,37);
        user_tele.setBounds(230,105,150,37);
        user_id.setBounds(230,65,150,37);
        //button and box
        button2.setBounds(153,200,100,37);
        button1.setBounds(283,200,100,37);
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
        panel.add(namel);

        panel.add(user_name);
        panel.add(user_id);
        panel.add(user_tele);

        panel.add(button2);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005,610);//position
        this.setSize(550,310);
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
            EquipDataAccessObject del = new EquipDataAccessObject();
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
