package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.entity.LEMIS_Lab;
import com.unicorn.lemis.model.dao.LabDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
import com.unicorn.lemis.util.ConfigManager;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.LaboratoryManagePanel;

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

public class LabInsert extends JFrame implements ActionListener {

    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    static boolean flag = false;
    @SuppressWarnings({"unchecked", "deprecation"})
    JComboBox comboBox = null;
    JPanel panel;
    JLabel equipNolable, equipNamelabel, equipLablabel, manufacturingDatelabel,expiringDatelabel,manufactorylabel,equipSerieslabel,statuslabel;
    JLabel banner, footer;
    JButton button, button1;
    JTextField equipNo, equipName, equipLab,manufacturingDate,expiringDate,manufactory,equipSeries;

    public LabInsert(){

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);
        //设置组件
        equipNo = new JTextField(50);
        equipName = new JTextField(50);
        equipLab = new JTextField(50);
        manufacturingDate = new JTextField(50);
        expiringDate = new JTextField(50);
        manufactory = new JTextField(50);
        equipSeries = new JTextField(50);
        //说明栏
        equipNolable = new JLabel("实验室ID");
        equipNamelabel = new JLabel("实验室名称");
        equipLablabel = new JLabel("设备数");
        manufacturingDatelabel = new JLabel("实验技术员");
        expiringDatelabel = new JLabel("所在二级学院");
        manufactorylabel = new JLabel("座位数");
        equipSerieslabel = new JLabel("实验室状态");

        panel = new JPanel();
        button = new JButton("添 加");
        button1 = new JButton("取 消");

        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        equipNo.setFont(FrameConsts.INPUT_FONT);
        equipName.setFont(FrameConsts.INPUT_FONT);
        equipLab.setFont(FrameConsts.INPUT_FONT);
        manufacturingDate.setFont(FrameConsts.INPUT_FONT);
        expiringDate.setFont(FrameConsts.INPUT_FONT);
        manufactory.setFont(FrameConsts.INPUT_FONT);
        equipSeries.setFont(FrameConsts.INPUT_FONT);
        equipNolable.setFont(FrameConsts.LABEL_FONT);
        equipNamelabel.setFont(FrameConsts.LABEL_FONT);
        equipLablabel.setFont(FrameConsts.LABEL_FONT);
        manufacturingDatelabel.setFont(FrameConsts.LABEL_FONT);
        expiringDatelabel.setFont(FrameConsts.LABEL_FONT);
        manufactorylabel.setFont(FrameConsts.LABEL_FONT);
        equipSerieslabel.setFont(FrameConsts.LABEL_FONT);

        /**
         * @description Location
         */

        //TextField
        equipNo.setBounds(130, 50, 250, 37);
        equipName.setBounds(130, 100, 250, 37);
        equipLab.setBounds(130, 150, 250, 37);
        manufacturingDate.setBounds(130, 200, 250, 37);
        expiringDate.setBounds(130,250,250,37);
        manufactory.setBounds(130, 300, 250, 37);
        equipSeries.setBounds(130, 350, 250, 37);

        //Label Location
        equipNolable.setBounds(50, 50, 65, 37);
        equipNamelabel.setBounds(50, 100, 65, 37);
        equipLablabel.setBounds(50, 150, 80, 37);
        manufacturingDatelabel.setBounds(50, 200, 80, 37);
        expiringDatelabel.setBounds(50, 250, 80, 37);
        manufactorylabel.setBounds(50, 300, 40, 37);
        equipSerieslabel.setBounds(50, 350, 80, 37);

        //text input
        equipNo.setBounds(160, 50, 250, 37);
        equipName.setBounds(160, 100, 250, 37);
        equipLab.setBounds(160, 150, 250, 37);
        manufacturingDate.setBounds(160, 200, 250, 37);
        expiringDate.setBounds(160,250,250,37);
        manufactory.setBounds(160, 300, 250, 37);
        equipSeries.setBounds(160, 350, 250, 37);

        //button and box
        button.setBounds(225, 480, 100, 37);
        button1.setBounds(225, 530, 100, 37);
        button.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button1.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(equipNolable);
        panel.add(equipNamelabel);
        panel.add(equipLablabel);
        panel.add(manufacturingDatelabel);
        panel.add(expiringDatelabel);
        panel.add(manufactorylabel);
        panel.add(equipSerieslabel);

        panel.add(equipNo);
        panel.add(equipName);
        panel.add(equipLab);
        panel.add(manufacturingDate);
        panel.add(expiringDate);
        panel.add(manufactory);
        panel.add(equipSeries);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        this.setLocation(1005, 260);//position
        this.setSize(550, 920);
        this.add(panel, BorderLayout.CENTER);
        this.add(banner, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("注册实验室");
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
                LabDataAccessObject reg = new LabDataAccessObject();
                lab.setLab_id(equipNo.getText());
                lab.setLab_name(equipName.getText());
                lab.setLab_equip(equipLab.getText());
                lab.setLab_technician(manufacturingDate.getText());
                lab.setLab_dept(expiringDate.getText());
                lab.setLab_sit(manufactory.getText());
                lab.setLab_status(equipSeries.getText());
                DataBaseUtil.getConn();
                try {
                    reg.insert(lab);
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    JOptionPane.showMessageDialog(jFrame,"添加成功");
                    this.dispose();
                    LaboratoryManagePanel.AL.add(equipName.getText());
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
