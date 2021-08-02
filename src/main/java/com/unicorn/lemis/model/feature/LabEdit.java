package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.entity.LEMIS_Lab;
import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.LabDataAccessObject;
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
 * @date 2021/6/24 16:59
 */

public class LabEdit extends JFrame implements ActionListener {
    public static String lid= null;
    public static String lname = null;
    public static String lequip = null;
    public static String ltech = null;
    public static String ldept = null;
    public static String lsit = null;
    public static String lstatus = null;

    private JFrame jFrame;
    private EquipService equipService;
    private ConfigManager checker;
    static boolean flag = false;
    @SuppressWarnings({"unchecked", "deprecation"})
    JComboBox comboBox = null;
    JPanel panel;
    JLabel labIdl,labId,labNamel, labEquipl, labTechl,labDeptl,labSitl,labStatusl;
    JLabel banner, footer;
    JButton button, button1;
    JTextField labName, labEquip, labTech,labDept,labSit,labStatus;

    public LabEdit(){

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);
        //设置组件
        labName = new JTextField(lname);
        labEquip = new JTextField(lequip);
        labTech = new JTextField(ltech);
        labDept = new JTextField(ldept);
        labSit = new JTextField(lsit);
        labStatus = new JTextField(lstatus);
        //说明栏
        labIdl = new JLabel("实验室ID");
        labId = new JLabel(lid);
        labNamel = new JLabel("实验室名称");
        labEquipl = new JLabel("设备数");
        labTechl = new JLabel("实验技术员");
        labDeptl = new JLabel("所属二级学院");
        labSitl = new JLabel("座位数");
        labStatusl = new JLabel("实验室状态");


        panel = new JPanel();
        button = new JButton("修 改");
        button1 = new JButton("取 消");

        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        labName.setFont(FrameConsts.INPUT_FONT);
        labEquip.setFont(FrameConsts.INPUT_FONT);
        labTech.setFont(FrameConsts.INPUT_FONT);
        labDept.setFont(FrameConsts.INPUT_FONT);
        labSit.setFont(FrameConsts.INPUT_FONT);
        labStatus.setFont(FrameConsts.INPUT_FONT);

        labIdl.setFont(FrameConsts.LABEL_FONT);
        labId.setFont(FrameConsts.LABEL_FONT);
        labNamel.setFont(FrameConsts.LABEL_FONT);
        labEquipl.setFont(FrameConsts.LABEL_FONT);
        labTechl.setFont(FrameConsts.LABEL_FONT);
        labDeptl.setFont(FrameConsts.LABEL_FONT);
        labSitl.setFont(FrameConsts.LABEL_FONT);
        labStatusl.setFont(FrameConsts.LABEL_FONT);

        /**
         * @description Location
         */

        //TextField
        labName.setBounds(130, 100, 250, 37);
        labEquip.setBounds(130, 150, 250, 37);
        labTech.setBounds(130, 200, 250, 37);
        labDept.setBounds(130, 250, 250, 37);
        labSit.setBounds(130, 300, 250, 37);
        labStatus.setBounds(130,350,250,37);

        //Label Location
        labIdl.setBounds(50, 50, 65, 37);
        labId.setBounds(160, 50, 65, 37);
        labNamel.setBounds(50, 100, 65, 37);
        labEquipl.setBounds(50, 150, 65, 37);
        labTechl.setBounds(50, 200, 65, 37);
        labDeptl.setBounds(50, 250, 80, 37);
        labSitl.setBounds(50,300,65,37);
        labStatusl.setBounds(50,350,65,37);
        //text input
        labName.setBounds(160, 100, 250, 37);
        labEquip.setBounds(160, 150, 250, 37);
        labTech.setBounds(160, 200, 250, 37);
        labDept.setBounds(160, 250, 250, 37);
        labSit.setBounds(160, 300, 250, 37);
        labStatus.setBounds(160,350,250,37);

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

        panel.add(labIdl);
        panel.add(labId);
        panel.add(labNamel);
        panel.add(labEquipl);
        panel.add(labTechl);
        panel.add(labDeptl);
        panel.add(labSitl);
        panel.add(labStatusl);

        panel.add(labName);
        panel.add(labEquip);
        panel.add(labTech);
        panel.add(labDept);
        panel.add(labSit);
        panel.add(labStatus);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        this.setLocation(1005, 310);//position
        this.setSize(550, 820);
        this.add(panel, BorderLayout.CENTER);
        this.add(banner, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("修改实验室数据");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            try {
                LEMIS_Lab lab = new LEMIS_Lab();
                String lab_id = lab.getLab_name();
                LabDataAccessObject in = new LabDataAccessObject();
                lab.getLab_id(lab_id);
                lab.setLab_name(labName.getText());
                lab.setLab_equip(labEquip.getText());
                lab.setLab_technician(labTech.getText());
                lab.setLab_dept(labDept.getText());
                lab.setLab_sit(labSit.getText());
                lab.setLab_status(labStatus.getText());
                DataBaseUtil.getConn();
                try {
                    in.update(lab);
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
