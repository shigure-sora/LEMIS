package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.model.feature.TechDelete;
import com.unicorn.lemis.model.feature.TechEdit;
import com.unicorn.lemis.model.feature.TechInsert;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:20
 */

public class TechnicianManagePanel extends JPanel  {

    UserDataAccessObject user = new UserDataAccessObject();



    public static JTable dataTable;

    private DefaultTableModel defaultTableModel=null;

    private static CustomIcon buttonNewTechnician,buttonEditTechnician,buttonDeleteTechnician,buttonFreshTechnician;

    private static Object[][] tableDatas;

    private String head[] = null;
    private Vector<Vector<String>> vec1;
    private Vector<String> vec2=null;

    JLabel labelTitle;


    public TechnicianManagePanel(){
        super();
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        addParts();
        head = new String[]{"ID","姓名","电话","所属二级学院","所在实验室","状态"};
        DefaultTableModel tableModel=new DefaultTableModel(initialize(),head);
        dataTable.setModel(tableModel);
        tableModel.fireTableDataChanged();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        dataTable.setDefaultRenderer(Object.class, renderer);
        addListener();
    }


    public void addParts(){
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * @description 面板上部
     */

    private JPanel getUpPanel(){
        JPanel panelUp = new JPanel();
        panelUp.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT,FrameConsts.MAIN_H_GAP,5));
        labelTitle = new JLabel("实验技术员管理");
        labelTitle.setFont(FrameConsts.FONT_TITLE);
        labelTitle.setForeground(FrameConsts.SELECTBAR_BACK_COLOR);
        panelUp.add(labelTitle);
        return panelUp;
    }

    /**
     * @description 面板中部
     */
    private JPanel getCenterPanel(){
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelCenter.setLayout(new GridLayout(1,1));
        panelCenter.add(getDataPanel());

        return panelCenter;
    }


    /**
     * @description data
    */
    private JPanel getDataPanel(){
        JPanel dataPanel = new JPanel();
        dataPanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.setLayout(new BorderLayout());
        //网格布局
        JPanel dataControl = new JPanel();
        dataControl.setLayout(new GridLayout(2,1));
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        //流式布局
        JPanel lControl = new JPanel();
        lControl.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        lControl.setLayout(new FlowLayout(FlowLayout.LEFT,FrameConsts.MAIN_H_GAP,5));
        JPanel rControl = new JPanel();
        rControl.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        rControl.setLayout(new FlowLayout(FlowLayout.RIGHT,50,5));

        JLabel labelNew = new JLabel("实验技术员列表");
        labelNew.setFont(FrameConsts.FONT_SUBTITLE);
        labelNew.setForeground(new Color(0,142,250));
        lControl.add(labelNew);
        //按钮设置
        buttonNewTechnician = new CustomIcon(FrameConsts.NEWTECHNICIAN_ICON,FrameConsts.NEWTECHNICIAN_ICON_ENABLE,FrameConsts.NEWTECHNICIAN_ICON_DISABLE,"");
        buttonEditTechnician = new CustomIcon(FrameConsts.EDITTECHNICIAN_ICON,FrameConsts.EDITTECHNICIAN_ICON_ENABLE,FrameConsts.EDITTECHNICIAN_ICON_DISABLE,"");
        buttonDeleteTechnician = new CustomIcon(FrameConsts.DELETETECHNICIAN_ICON,FrameConsts.DELETETECHNICIAN_ICON_ENABLE,FrameConsts.DELETETECHNICIAN_ICON_DISABLE,"");
        buttonFreshTechnician = new CustomIcon(FrameConsts.FRESHTECHNICIAN_ICON,FrameConsts.FRESHTECHNICIAN_ICON_ENABLE,FrameConsts.FRESHTECHNICIAN_ICON_DISABLE,"");
        rControl.add(buttonNewTechnician);
        rControl.add(buttonEditTechnician);
        rControl.add(buttonDeleteTechnician);
        rControl.add(buttonFreshTechnician);

        dataControl.add(rControl);
        dataControl.add(lControl);

        //表格设置
        dataPanel.add(dataControl,BorderLayout.NORTH);
        dataTable = new JTable(tableDatas,new String[]{"ID","姓名","电话","所属二级学院","所在实验室","状态"});
        dataTable.setFont(FrameConsts.FONT_NORMAL);
        dataTable.getTableHeader().setFont(FrameConsts.FONT_NORMAL);
        dataTable.getTableHeader().setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataTable.getTableHeader().setBorder(BorderFactory.createLineBorder(FrameConsts.SELECTBAR_BACK_COLOR));
        dataTable.setRowHeight(36);
        dataTable.setGridColor(FrameConsts.TABLE_LINE_COLOR);
        //列宽
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(113);
        dataTable.getColumnModel().getColumn(0).setMaxWidth(116);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(73);
        dataTable.getColumnModel().getColumn(1).setMaxWidth(78);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(140);
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(143);
        dataTable.getColumnModel().getColumn(3).setMaxWidth(153);
        dataTable.getColumnModel().getColumn(4).setPreferredWidth(81);
        dataTable.getColumnModel().getColumn(4).setMaxWidth(91);
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(5).setMaxWidth(120);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.add(scrollPane,BorderLayout.CENTER);
        return dataPanel;

    }

    /**
     * @description 获取表内数据
     * @param []
     * @return java.lang.Object[][]
     */
    public Object[][] initialize(){
        String title = "Technician";
       List<LEMIS_User> list = user.queryTechnician(title);
        tableDatas = new Object[list.size()][6];
        for (int i = 0;i<list.size();i++){
            tableDatas [i][0] = list.get(i).getUser_id();
            tableDatas [i][1] = list.get(i).getUser_name();
            tableDatas [i][2] = list.get(i).getUser_tele();
            tableDatas [i][3] = list.get(i).getUser_dept();
            tableDatas [i][4] = list.get(i).getUser_lab();
            tableDatas [i][5] = list.get(i).getUser_status();
        }
        return tableDatas;
    }

    public void reload() {
        String title = "Technician";
        List<LEMIS_User> list = user.queryTechnician(title);
        tableDatas = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            tableDatas[i][0] = list.get(i).getUser_id();
            tableDatas[i][1] = list.get(i).getUser_name();
            tableDatas[i][2] = list.get(i).getUser_tele();
            tableDatas[i][3] = list.get(i).getUser_dept();
            tableDatas[i][4] = list.get(i).getUser_lab();
            tableDatas[i][5] = list.get(i).getUser_status();
        }
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);
    }

    // TODO: 2021/6/23 Update Info
    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonNewTechnician.addActionListener(e -> new TechInsert());
        buttonEditTechnician.addActionListener(e -> new TechEdit());
        buttonDeleteTechnician.addActionListener(e -> new TechDelete());
        buttonFreshTechnician.addActionListener(e -> AdministratorFrame.technicianManagePanel.reload());
        dataTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int i=dataTable.getSelectedRow();
                TechEdit.uid = (String) dataTable.getValueAt(i, 0);
                TechEdit.uname = (String) dataTable.getValueAt(i, 1);
                TechEdit.utele = (String) dataTable.getValueAt(i, 2);
                TechEdit.udept = (String) dataTable.getValueAt(i, 3);
                TechEdit.ulab = (String) dataTable.getValueAt(i, 4);
                TechEdit.ustatus = (String) dataTable.getValueAt(i, 5);
                TechDelete.gUid = (String) dataTable.getValueAt(i,0);
                TechDelete.gName = (String) dataTable.getValueAt(i,1);
                TechDelete.gStatus = (String) dataTable.getValueAt(i,5);
            }
        });
    }

}
