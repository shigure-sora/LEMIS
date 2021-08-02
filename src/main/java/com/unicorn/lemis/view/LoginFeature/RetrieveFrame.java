package com.unicorn.lemis.view.LoginFeature;

import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.view.feature.FrameConsts;

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
 * @date 2021/6/19 22:53
 */

public class RetrieveFrame extends JFrame implements ActionListener {

    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    JPanel panel;
    JLabel user_idLabel,user_teleLabel,user_NameLabel;
    JLabel banner,footer;
    JButton button,button1;
    JTextField user_name,user_id,user_tele;

    public RetrieveFrame(){

        LOGGER.info("Prepare to Retrieve");

        // TODO: 2021/6/20 disable banner picture

        //banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        //banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);

        user_id = new JTextField(50);
        user_tele = new JTextField(50);
        //说明栏
        user_idLabel = new JLabel("账号");
        user_teleLabel = new JLabel("电话");

        panel=new JPanel();
        button=new JButton("提 交");
        button1=new JButton("取 消");
        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        user_id.setFont(FrameConsts.INPUT_FONT);
        user_tele.setFont(FrameConsts.INPUT_FONT);
        user_idLabel.setFont(FrameConsts.LABEL_FONT);
        user_teleLabel.setFont(FrameConsts.LABEL_FONT);

        /**
         * @description Location
         */

        //TextField
        user_id.setBounds(130,25,250,37);
        user_tele.setBounds(130,75,250,37);

        //Label Location
        user_idLabel.setBounds(50,25,40,37);
        user_teleLabel.setBounds(50,75,40,37);

        //text input
        user_id.setBounds(160,25,250,37);
        user_tele.setBounds(160,75,250,37);

        //button and box
        button.setBounds(170,125,100,37);
        button1.setBounds(300,125,100,37);
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
        panel.add(user_teleLabel);

        panel.add(user_id);
        panel.add(user_tele);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005,520);//position
        this.setSize(550,400);
        this.add(footer,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle(FrameConsts.SOFTWARE_NAME+" "+FrameConsts.SOFTWARE_VERSION+"  找回密码");
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

        String cuser_id = user_id.getText();
        String cuser_tele = user_tele.getText();

            if(ConfigManager.isEmpty(cuser_id)&& ConfigManager.isEmpty(cuser_tele)&&event.getSource()==button){
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    JOptionPane.showMessageDialog(jFrame, "请输入账号和注册时的电话");
                }else if(ConfigManager.isEmpty(cuser_id)&& ConfigManager.isNotEmpty(cuser_tele)&&event.getSource()==button){
                        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                        JOptionPane.showMessageDialog(jFrame, "请输入账号");
                    } else if(ConfigManager.isNotEmpty(cuser_id)&& ConfigManager.isEmpty(cuser_tele)&&event.getSource()==button){
                            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                            JOptionPane.showMessageDialog(jFrame, "请输入注册时的电话");
                        } else if(ConfigManager.isNotEmpty(cuser_id)|| ConfigManager.isNotEmpty(cuser_tele)&&event.getSource()==button){
                            String password = UserDataAccessObject.retrievePassword(cuser_id, cuser_tele);
                            if(event.getSource()==button){
                                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                                JOptionPane.showMessageDialog(jFrame,"你的密码是"+password);
                                this.dispose();
                                LOGGER.info("Retrieve successful");
                                new LoginFrame();
                            }
        }if (event.getSource()==button1){
            this.dispose();
            LOGGER.info("Retrieve cancel");
            new LoginFrame();
        }
    }
}
