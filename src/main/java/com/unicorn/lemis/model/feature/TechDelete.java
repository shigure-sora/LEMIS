package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.view.LoginFeature.LoginFrame;
import com.unicorn.lemis.view.feature.FrameConsts;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author kano_dayo
 * @date 2021/6/23 21:06
 */

public class TechDelete extends JFrame implements ActionListener {

    public static String gName = null;
    public static String gStatus = null;
    public static String gUid = null;


    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    JPanel panel;
    JLabel user_idLabel,user_teleLabel,user_NameLabel;
    JLabel banner,footer;
    JButton button,button1;
    JLabel user_name,user_id,user_tele;


    public TechDelete(){

        user_name = new JLabel(gName);
        user_tele = new JLabel(gStatus);
        user_name.setFont(FrameConsts.LABEL_FONT);
        user_tele.setFont(FrameConsts.LABEL_FONT);
        //说明栏
        user_idLabel = new JLabel("姓名");
        user_teleLabel = new JLabel("状态");
        user_idLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);

        panel=new JPanel();
        button=new JButton("确 定");
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
        //Label Location
        user_idLabel.setBounds(200,25,40,37);
        user_teleLabel.setBounds(200,75,40,37);
        user_teleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        user_name.setBounds(230,25,150,37);
        user_tele.setBounds(230,75,150,37);

        //button and box
        button.setBounds(153,125,100,37);
        button1.setBounds(283,125,100,37);
        button.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        button1.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(user_idLabel);
        panel.add(user_teleLabel);

        panel.add(user_name);
        panel.add(user_tele);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005,610);//position
        this.setSize(550,210);
        this.add(panel,BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("删除");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            UserDataAccessObject del = new UserDataAccessObject();
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
        if (event.getSource() == button1) {
            this.dispose();
        }
    }
}
