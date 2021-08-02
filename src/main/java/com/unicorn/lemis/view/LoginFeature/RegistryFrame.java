package com.unicorn.lemis.view.LoginFeature;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.model.feature.WarnFrame;
import com.unicorn.lemis.view.feature.FrameConsts;
import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/19 22:52
 */

public class RegistryFrame extends JFrame implements ActionListener {
    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    static boolean flag = false;
    Vector<String> AL = new Vector<String>();
    @SuppressWarnings({"unchecked", "deprecation"})
    JComboBox comboBox = null;
    JPanel panel;
    JLabel user_idLabel, user_authlabel, dept_label, user_titleLabel, user_teleLabel;
    JLabel user_NameLabel, user_passwordLabel;
    JLabel banner, footer;
    JButton button, button1;
    JTextField user_name, user_id, user_tele, user_dept, user_title, user_auth;
    JPasswordField user_passwords;


    public RegistryFrame() {

        LOGGER.info("Prepare to Registry");

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);

        //设置组件
        user_passwords = new JPasswordField(50);
        user_name = new JTextField(50);
        user_id = new JTextField(50);
        user_dept = new JTextField(50);
        user_title = new JTextField(50);
        user_tele = new JTextField(50);
        user_auth = new JTextField(50);
        //说明栏
        user_idLabel = new JLabel("账号");
        user_NameLabel = new JLabel("姓名");
        user_passwordLabel = new JLabel("密码");
        user_teleLabel = new JLabel("电话");
        user_titleLabel = new JLabel("权限组");
        user_authlabel = new JLabel("授权码");
        dept_label = new JLabel("所属二级学院");

        //选择栏
        // TODO: 2021/6/20 change ArrayList to Vector
        comboBox = new JComboBox<String>(AL);
        AL.add("Administrator");
        AL.add("Technician");
        AL.add("Maintenance Worker");
        AL.add("Teacher");
        AL.add("Student");
        comboBox.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(),"请选择权限组",0,0,FrameConsts.NormalUI2_FONT));
        comboBox.setMaximumRowCount(5);

        panel = new JPanel();
        button = new JButton("注 册");
        button1 = new JButton("取 消");
        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        user_id.setFont(FrameConsts.NormalUI_FONT);
        user_name.setFont(FrameConsts.NormalUI_FONT);
        user_passwords.setFont(FrameConsts.NormalUI_FONT);
        user_title.setFont(FrameConsts.NormalUI_FONT);
        user_tele.setFont(FrameConsts.NormalUI_FONT);
        user_dept.setFont(FrameConsts.NormalUI_FONT);
        user_auth.setFont(FrameConsts.NormalUI_FONT);
        comboBox.setFont(FrameConsts.NormalUI_FONT);
        user_idLabel.setFont(FrameConsts.LABEL_FONT);
        user_NameLabel.setFont(FrameConsts.LABEL_FONT);
        user_passwordLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);
        user_titleLabel.setFont(FrameConsts.LABEL_FONT);
        user_authlabel.setFont(FrameConsts.LABEL_FONT);
        dept_label.setFont(FrameConsts.LABEL_FONT);



        /**
         * @description Location
         */

        //TextField
        user_id.setBounds(130, 50, 250, 37);
        user_name.setBounds(130, 100, 250, 37);
        user_passwords.setBounds(130, 150, 250, 37);
        user_tele.setBounds(130, 200, 250, 37);
        user_auth.setBounds(130, 300, 250, 37);
        user_dept.setBounds(130, 350, 250, 37);

        //Label Location
        user_idLabel.setBounds(50, 50, 40, 37);
        user_NameLabel.setBounds(50, 100, 40, 37);
        user_passwordLabel.setBounds(50, 150, 40, 37);
        user_teleLabel.setBounds(50, 200, 40, 37);
        user_titleLabel.setBounds(50, 250, 40, 37);
        user_authlabel.setBounds(50, 300, 40, 37);
        dept_label.setBounds(50, 350, 80, 37);

        //text input
        user_id.setBounds(160, 50, 250, 37);
        user_name.setBounds(160, 100, 250, 37);
        user_passwords.setBounds(160, 150, 250, 37);
        user_tele.setBounds(160, 200, 250, 37);
        user_auth.setBounds(160, 300, 250, 37);
        user_dept.setBounds(160, 350, 250, 37);

        //button and box
        comboBox.setBounds(160, 240, 250, 50);
        comboBox.setBackground(Color.WHITE);
        button.setBounds(225, 400, 100, 37);
        button1.setBounds(225, 450, 100, 37);
        button.setFont(FrameConsts.INPUT_FONT);
        button1.setFont(FrameConsts.INPUT_FONT);
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(user_idLabel);
        panel.add(user_NameLabel);
        panel.add(user_passwordLabel);
        panel.add(user_titleLabel);
        panel.add(user_teleLabel);
        panel.add(dept_label);
        panel.add(user_authlabel);

        panel.add(user_id);
        panel.add(user_name);
        panel.add(user_passwords);
        panel.add(user_tele);
        panel.add(user_auth);
        panel.add(user_dept);

        panel.add(comboBox);
        panel.add(button);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005, 310);//position
        this.setSize(550, 820);
        this.add(banner, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle(FrameConsts.SOFTWARE_NAME+" "+FrameConsts.SOFTWARE_VERSION+"  注册");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LOGGER.info("Closing system...");
                LOGGER.info("アトリは、高性能ですから!");
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent event) {
        UserDataAccessObject check = new UserDataAccessObject();
        if (event.getSource() == button) {
            String user_authcode = new String(user_auth.getText());
            int temp = comboBox.getSelectedIndex();
            String user_titlecode = (String) comboBox.getSelectedItem();
            try {
                //检查授权码
                if (check.checker(user_authcode,user_titlecode)) {
                    //检查注册信息是否完整
                    LEMIS_User user = new LEMIS_User();
                    UserDataAccessObject reg = new UserDataAccessObject();
                    String user_auth = reg.randomcode(user);
                    user.setUser_id(user_id.getText());
                    user.setUser_name(user_name.getText());
                    String pw = new String(user_passwords.getPassword());
                    user.setUser_password(pw);
                    int select = comboBox.getSelectedIndex() + 1;
                    String til = (String) comboBox.getSelectedItem();
                    user.setUser_title(til);
                    user.setUser_tele(user_tele.getText());
                    user.setUser_dept(user_dept.getText());
                    user.setUser_auth(user_auth);
                    DataBaseUtil.getConn();
                    try {
                        reg.insert(user);
                        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        JOptionPane.showMessageDialog(jFrame,"注册成功");
                        LOGGER.info("Registry successful");
                        this.dispose();
                        new LoginFrame();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        }
                }else {
                    WarnFrame wf = new WarnFrame();
                    wf.checkWarning();

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
            }if(event.getSource() == button1){
                this.dispose();//取消选项
                LOGGER.info("Registry cancel");
                new LoginFrame();
        }
    }
}

