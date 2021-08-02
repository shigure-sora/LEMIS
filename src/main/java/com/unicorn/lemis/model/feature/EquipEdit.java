package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.entity.LEMIS_Equip;

import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.service.EquipService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.util.DataBaseUtil;
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

public class EquipEdit extends JFrame implements ActionListener {
    public static String eno = null;
    public static String ename = null;
    public static String elab = null;
    public static String epro = null;
    public static String estatus = null;
    public static String ereq = null;
    public static String ework = null;


    private JFrame jFrame;
    private EquipService equipService;
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

    public EquipEdit() {

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);
        //设置组件
        user_name = new JTextField(elab);
        user_dept = new JTextField(epro);
        user_tele = new JTextField(estatus);
        user_status = new JTextField(ework);
        user_lab = new JTextField(ereq);
        //说明栏
        user_NameLabel = new JLabel("所在实验室");
        user_teleLabel = new JLabel("设备状态");
        dept_label = new JLabel("问题");
        user_labLabel = new JLabel("维修申请者");
        user_statuslabel = new JLabel("维修员");

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
        user_lab.setBounds(130, 200, 250, 37);
        user_status.setBounds(130, 250, 250, 37);
        user_dept.setBounds(130, 150, 250, 37);

        //Label Location
        user_NameLabel.setBounds(50, 50, 65, 37);
        user_teleLabel.setBounds(50, 100, 65, 37);
        user_labLabel.setBounds(50, 200, 65, 37);
        user_statuslabel.setBounds(50, 250, 40, 37);
        dept_label.setBounds(50, 150, 80, 37);

        //text input
        user_name.setBounds(160, 50, 250, 37);
        user_tele.setBounds(160, 100, 250, 37);
        user_lab.setBounds(160, 200, 250, 37);
        user_status.setBounds(160, 250, 250, 37);
        user_dept.setBounds(160, 150, 250, 37);

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
        this.setTitle("修改设备数据");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            try {
                LEMIS_Equip equip = new LEMIS_Equip();
                String equip_no = equip.getEquip_no();
                String equip_name = equip.getEquip_name();
                String manufacturing_date = equip.getManufacturing_date();
                String expiring_date = equip.getExpiring_date();
                String equip_series = equip.getEquip_series();
                String manufactory = equip.getManufactory();
                EquipDataAccessObject in = new EquipDataAccessObject();
                equip.setEquip_no(equip_no);
                equip.setEquip_name(equip_name);
                equip.setManufacturing_date(manufacturing_date);
                equip.setExpiring_date(expiring_date);
                equip.setEquip_series(equip_series);
                equip.setManufactory(manufactory);
                equip.setEquip_lab(user_name.getText());
                equip.setStatus(user_tele.getText());
                equip.setProblem(user_dept.getText());
                equip.setReq_repair_man(user_lab.getText());
                equip.setWorker_name(user_status.getText());
                DataBaseUtil.getConn();
                try {
                    in.update(equip);
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
