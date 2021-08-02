package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.TechnicianManagePanel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author kano_dayo
 * @date 2021/6/23 20:42
 */

public class TechEdit extends JFrame implements ActionListener {
    public static String uid = null;
    public static String uname = null;
    public static String udept = null;
    public static String ulab = null;
    public static String ustatus = null;
    public static String utele = null;


    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    static boolean flag = false;
    @SuppressWarnings({"unchecked", "deprecation"})
    JComboBox comboBox = null;
    JPanel panel;
    JLabel user_statuslabel, dept_label, user_teleLabel, user_labLabel;
    JLabel user_NameLabel;
    JLabel banner, footer;
    JButton button, button1;
    JTextField user_name,user_title, user_tele, user_dept, user_status, user_lab;
    JPasswordField user_passwords;

    public TechEdit() {

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);
        //设置组件
        user_name = new JTextField(uname);
        user_dept = new JTextField(udept);
        user_title = new JTextField("Technician");
        user_tele = new JTextField(utele);
        user_status = new JTextField(ustatus);
        user_lab = new JTextField(ulab);
        //说明栏
        user_NameLabel = new JLabel("姓名");
        user_teleLabel = new JLabel("手机号码");
        dept_label = new JLabel("所属二级学院");
        user_labLabel = new JLabel("所在实验室");
        user_statuslabel = new JLabel("状态");

        panel = new JPanel();
        button = new JButton("修 改");
        button1 = new JButton("取 消");

        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        user_name.setFont(FrameConsts.INPUT_FONT);
        user_tele.setFont(FrameConsts.INPUT_FONT);
        user_dept.setFont(FrameConsts.INPUT_FONT);
        user_status.setFont(FrameConsts.INPUT_FONT);
        user_lab.setFont(FrameConsts.INPUT_FONT);

        user_NameLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);
        dept_label.setFont(FrameConsts.LABEL_FONT);
        user_statuslabel.setFont(FrameConsts.LABEL_FONT);
        user_labLabel.setFont(FrameConsts.LABEL_FONT);

        /**
         * @description Location
         */

        //TextField
        user_name.setBounds(130, 50, 250, 37);
        user_tele.setBounds(130, 100, 250, 37);
        user_lab.setBounds(130, 150, 250, 37);
        user_status.setBounds(130, 200, 250, 37);
        user_dept.setBounds(130, 250, 250, 37);

        //Label Location
        user_NameLabel.setBounds(50, 50, 40, 37);
        user_teleLabel.setBounds(50, 100, 65, 37);
        user_labLabel.setBounds(50, 150, 65, 37);
        user_statuslabel.setBounds(50, 200, 40, 37);
        dept_label.setBounds(50, 250, 80, 37);

        //text input
        user_name.setBounds(160, 50, 250, 37);
        user_tele.setBounds(160, 100, 250, 37);
        user_lab.setBounds(160, 150, 250, 37);
        user_status.setBounds(160, 200, 250, 37);
        user_dept.setBounds(160, 250, 250, 37);

        //button and box
        button.setBounds(225, 400, 100, 37);
        button1.setBounds(225, 450, 100, 37);
        button.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button1.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(user_NameLabel);
        panel.add(user_teleLabel);
        panel.add(user_labLabel);
        panel.add(user_statuslabel);
        panel.add(dept_label);

        panel.add(user_name);
        panel.add(user_tele);
        panel.add(user_lab);
        panel.add(user_status);
        panel.add(user_dept);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005, 310);//position
        this.setSize(550, 820);
        this.add(panel, BorderLayout.CENTER);
        this.add(banner, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("修改实验技术员数据");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        UserDataAccessObject check = new UserDataAccessObject();
        if (event.getSource() == button) {
            try {
                LEMIS_User user = new LEMIS_User();
                String user_id = user.getUser_id();
                String user_password = user.getUser_password();
                String user_auth = user.getUser_auth();
                UserDataAccessObject in = new UserDataAccessObject();
                user.setUser_id(user_id);
                user.setUser_password(user_password);
                user.setUser_auth(user_auth);
                user.setUser_name(user_name.getText());
                user.setUser_title("Technician");
                user.setUser_tele(user_tele.getText());
                user.setUser_lab(user_lab.getText());
                user.setUser_status(user_status.getText());
                user.setUser_dept(user_dept.getText());
                DataBaseUtil.getConn();
                try {
                    in.update(user);
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    JOptionPane.showMessageDialog(jFrame,"修改成功");
                    this.dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        }if(event.getSource() == button1){
            this.dispose();//取消选项
        }
    }
}
