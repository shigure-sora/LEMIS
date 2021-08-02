package com.unicorn.lemis.model.feature;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.entity.LEMIS_Request;
import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.RequestDataAccessObject;
import com.unicorn.lemis.model.service.UserService;
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
 * @date 2021/6/24 21:52
 */

public class RequestInsert extends JFrame implements ActionListener {

    RequestDataAccessObject request = new RequestDataAccessObject();

    private JFrame jFrame;
    private UserService userService;
    private ConfigManager checker;
    static boolean flag = false;
    @SuppressWarnings({"unchecked", "deprecation"})
    JComboBox comboBox = null;
    JPanel panel;
    JLabel req_id,NameLabel,NoLabel,req_repair_manlabel,seriesLabel,problemlabel,labLabel,statuslabel,status,req_info;
    JLabel banner, footer;
    JButton button, button1;
    JTextField name,no,reqman,series,problem,lab;

    public RequestInsert(){

        banner = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_top(CUnet).png"));//设置背景图片
        banner.setOpaque(false);
        footer = new JLabel(new ImageIcon("src/main/resources/assets/lemis/textures/reg_down(CUnet).png"));
        footer.setOpaque(false);
        //设置组件
        req_id = new JLabel(request.randomcode());
        name = new JTextField(50);
        no = new JTextField(50);
        reqman = new JTextField(50);
        series = new JTextField(50);
        problem = new JTextField(50);
        lab = new JTextField(50);
        status = new JLabel("Waiting");
        //说明栏
        req_info = new JLabel("申请ID");
        NameLabel = new JLabel("设备名称");
        NoLabel = new JLabel("设备ID");
        req_repair_manlabel = new JLabel("维修申请者");
        seriesLabel = new JLabel("类型");
        problemlabel = new JLabel("问题");
        labLabel = new JLabel("所在实验室");
        statuslabel = new JLabel("状态");

        panel = new JPanel();
        button = new JButton("提 交");
        button1 = new JButton("取 消");

        /**
         * @description 设置组件位置以及字体
         */
        //Fonts
        req_info.setFont(FrameConsts.LABEL_FONT);
        req_id.setFont(FrameConsts.INPUT_FONT);
        name.setFont(FrameConsts.INPUT_FONT);
        no.setFont(FrameConsts.INPUT_FONT);
        reqman.setFont(FrameConsts.INPUT_FONT);
        series.setFont(FrameConsts.INPUT_FONT);
        problem.setFont(FrameConsts.INPUT_FONT);
        lab.setFont(FrameConsts.INPUT_FONT);
        status.setFont(FrameConsts.INPUT_FONT);
        req_id.setFont(FrameConsts.LABEL_FONT);
        NameLabel.setFont(FrameConsts.LABEL_FONT);
        NoLabel.setFont(FrameConsts.LABEL_FONT);
        req_repair_manlabel.setFont(FrameConsts.LABEL_FONT);
        seriesLabel.setFont(FrameConsts.LABEL_FONT);
        problemlabel.setFont(FrameConsts.LABEL_FONT);
        labLabel.setFont(FrameConsts.LABEL_FONT);
        statuslabel.setFont(FrameConsts.LABEL_FONT);



        /**
         * @description Location
         */

        //TextField
        name.setBounds(130, 100, 250, 37);
        no.setBounds(130, 150, 250, 37);
        reqman.setBounds(130, 200, 250, 37);
        series.setBounds(130, 250, 250, 37);
        problem.setBounds(130,300,250,37);
        lab.setBounds(130,350,250,37);
        status.setBounds(130,400,250,37);


        //Label Location
        req_info.setBounds(50,50,65,37);
        NameLabel.setBounds(50, 100, 65, 37);
        NoLabel.setBounds(50, 150, 65, 37);
        req_repair_manlabel.setBounds(50, 200, 80, 37);
        seriesLabel.setBounds(50, 250, 80, 37);
        problemlabel.setBounds(50,300,65,37);
        labLabel.setBounds(50,350,65,37);
        statuslabel.setBounds(50,400,65,37);

        //text input
        req_id.setBounds(160,50,250,37);
        name.setBounds(160, 100, 250, 37);
        no.setBounds(160, 150, 250, 37);
        reqman.setBounds(160, 200, 250, 37);
        series.setBounds(160, 250, 250, 37);
        problem.setBounds(160,300,250,37);
        lab.setBounds(160,350,250,37);
        status.setBounds(160,400,250,37);

        //button and box
        button.setBounds(225, 450, 100, 37);
        button1.setBounds(225, 500, 100, 37);
        button.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button1.setFont(new Font("Microsoft YaHei UI", 0, 16));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.GRAY);//字体颜色
        button1.setBackground(new Color(255, 255, 255));
        button1.setForeground(Color.GRAY);//字体颜色
        //panel settings
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(req_info);
        panel.add(NameLabel);
        panel.add(NoLabel);
        panel.add(req_repair_manlabel);
        panel.add(seriesLabel);
        panel.add(problemlabel);
        panel.add(labLabel);
        panel.add(statuslabel);

        panel.add(req_id);
        panel.add(name);
        panel.add(no);
        panel.add(reqman);
        panel.add(series);
        panel.add(problem);
        panel.add(lab);
        panel.add(status);

        panel.add(button);
        panel.add(button1);
        this.add(panel);
        // TODO: 2021/6/20 position
        this.setLocation(1005, 260);//position
        this.setSize(550, 880);
        this.add(panel, BorderLayout.CENTER);
        this.add(banner, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("维修申请");
        this.setIconImage(FrameConsts.IMAGE_ICON);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this);
        button1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            try {
                LEMIS_Request equip = new LEMIS_Request();
                RequestDataAccessObject reg = new RequestDataAccessObject();
                equip.setRequest_id(req_id.getText());
                equip.setEquip_no(no.getText());
                equip.setEquip_name(name.getText());
                equip.setReq_repair_man(reqman.getText());
                equip.setEquip_series(series.getText());
                equip.setProblem(problem.getText());
                equip.setLab(lab.getText());
                equip.setStatus(status.getText());

                DataBaseUtil.getConn();
                try {
                    reg.insert(equip);
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
                    JOptionPane.showMessageDialog(jFrame,"已发送申请");
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
