package com.unicorn.lemis.view.LoginFeature;

import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.*;
import com.unicorn.lemis.view.user.*;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/19 15:26
 */

public class LoginFrame extends JFrame implements ActionListener {
    private JFrame jFrame;
    private UserService userService;
    private JComboBox select;
    static boolean flag = false;


    JPanel panel;
    JLabel banner,authorization,selects;
    JLabel user_NameLabel,user_passwordLabel;
    JButton button,registry,retrieve;
    JTextField user_name;
    JPasswordField user_passwords;


    public LoginFrame(){



        this.userService = new UserService();

        //设置组件
        jFrame = new JFrame();
        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/banner(CUnet).png"));//设置背景图片，图片名称顾名思义
        panel = new JPanel();
        user_name = new JTextField(50);
        user_passwords = new JPasswordField(50);
        user_NameLabel = new JLabel("账号");
        user_passwordLabel = new JLabel("密码");

        /**
         * @description 组件信息
         */
        //注册用户
        registry = new JButton("信息注册");
        registry.setForeground(new Color(0,191,255));//字体颜色RGB
        registry.setBackground(Color.white);
        registry.setBorderPainted(false);
        registry.setFont(FrameConsts.NormalUI2_FONT);//设置字体与字体大小
        registry.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//显示光标
        //找回密码
        retrieve = new JButton("找回密码");
        retrieve.setForeground(new Color(0,191,255));//字体颜色RGB
        retrieve.setBackground(Color.white);
        retrieve.setBorderPainted(false);
        retrieve.setFont(FrameConsts.NormalUI2_FONT);//设置字体与字体大小
        retrieve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//显示光标
        //登录
        button = new JButton("登录");
        panel.setLayout(null);
        panel.setBackground(Color.white);

        /**
         * @description 设置组件位置以及字体
         */

        //用户名
        user_name.setBounds(130,14,250,37);
        user_name.setFont(FrameConsts.NormalUI2_FONT);
        user_NameLabel.setBounds(50,14,40,37);
        user_NameLabel.setFont(FrameConsts.NormalUI2_FONT);
        //密码
        user_passwords.setBounds(130,48,250,37);
        user_passwords.setFont(FrameConsts.NormalUI2_FONT);
        user_passwordLabel.setBounds(50,48,40,37);
        user_passwordLabel.setFont(FrameConsts.NormalUI2_FONT);
        //信息注册与找回密码
        registry.setBounds(390,10,120,34);
        retrieve.setBounds(390,50,120,34);
        //登录按钮
        button.setBounds(130,130,250,37);
        button.setFont(FrameConsts.INPUT_FONT);
        //button.setForeground(new Color(0,142,250));
        button.setBackground(new Color(0, 142, 250));//字体颜色RGB
        button.setForeground(Color.white);
        //选择
        /**
         * @description 添加组件
         */

        panel.add(registry);
        panel.add(retrieve);
        panel.add(button);
        panel.add(user_name);
        panel.add(user_passwords);
        panel.add(user_NameLabel);
        panel.add(user_passwordLabel);
        panel.setSize(540,190);
        this.add(banner,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
        this.setSize(550,400);//窗口大小
        this.setTitle(FrameConsts.SOFTWARE_NAME+" "+FrameConsts.SOFTWARE_VERSION+"  登录");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(1010,520);//position
        this.setResizable(false);
        this.setVisible(true);
        registry.addActionListener(this);
        retrieve.addActionListener(this);
        button.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LOGGER.info("Closing system...");
                LOGGER.info("アトリは、高性能ですから!");
            }
        });
    }

    /**
     * @param [event]
     * @return void
     */

    @Override
    public void actionPerformed(ActionEvent event) {
        String user_id = user_name.getText();
        String user_password = new String(user_passwords.getPassword());
            try {
                if(event.getSource()==registry){
                    this.dispose();
                    RegistryFrame RF = new RegistryFrame();
                    RF.setVisible(true);
                        }else if(event.getSource()==retrieve){
                            this.dispose();
                            RetrieveFrame ReF = new RetrieveFrame();
                            ReF.setVisible(true);
                            }//注册与找回密码逻辑
                if(ConfigManager.isEmpty(user_id)&& ConfigManager.isEmpty(user_password)&&event.getSource()==button){
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    JOptionPane.showMessageDialog(jFrame, "请输入账号和密码");
                }else if(ConfigManager.isEmpty(user_id)&& ConfigManager.isNotEmpty(user_password)&&event.getSource()==button){
                        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        JOptionPane.showMessageDialog(jFrame, "请输入账号");
                    } else if(ConfigManager.isNotEmpty(user_id)&& ConfigManager.isEmpty(user_password)&&event.getSource()==button){
                            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                            JOptionPane.showMessageDialog(jFrame, "请输入密码");
                        } else if(ConfigManager.isNotEmpty(user_id)|| ConfigManager.isNotEmpty(user_password)&&event.getSource()==button){
                                flag = UserDataAccessObject.loginChecker(user_id, user_password);
                            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag) {
                //关闭登录窗口对象
                this.dispose();
                //创建系统主窗口对象
                String select = UserDataAccessObject.titleChecker(user_id);//获得用户标识
                // TODO: 2021/6/21 switch select
                switch (select){
                    case "Administrator":
                        try {
                            new AdministratorFrame();
                            LOGGER.info("Login with Administrator");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        DefaultPanel.global_user_id = user_name.getText();//传递参数
                        EquipmentManagePanel.global_user_id = user_name.getText();
                        break;
                    case "Technician":
                        try {
                            new TechnicianFrame();
                            LOGGER.info("Login with Technician");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EquipmentManagePanel.global_user_id = user_name.getText();
                        TechDefaultPanel.global_user_id = user_name.getText();
                        break;
                    case "Maintenance Worker":
                        try {
                            new WorkerFrame();
                            LOGGER.info("Login with Maintenance Worker");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        WorkerPanel.gworkerName = user_name.getText();//传递参数
                        WorkerDefaultPanel.global_user_id = user_name.getText();
                        break;
                    case "Teacher":
                        try {
                            new TeacherFrame();
                            LOGGER.info("Login with Teacher");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        TeacherDefaultPanel.global_user_id = user_name.getText();
                        break;
                    case "Student":
                        try {
                            new StudentFrame();
                            LOGGER.info("Login with Student");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        StudentDefaultPanel.global_user_id = user_name.getText();
                        break;
                }
               // new MainFrame();
            } else if(ConfigManager.isNotEmpty(user_id)&& ConfigManager.isNotEmpty(user_password)){
                //弹出提示对话框
                JOptionPane.showMessageDialog(jFrame, "用户或者密码有误!");
            }

    }

}