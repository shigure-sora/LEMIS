package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.entity.LEMIS_Lab;
import com.unicorn.lemis.model.dao.LabDataAccessObject;
import com.unicorn.lemis.model.feature.*;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:19
 */

public class LaboratoryManagePanel extends JPanel {

    LabDataAccessObject lab = new LabDataAccessObject();



    public static JTable dataTable;

    private DefaultTableModel defaultTableModel=null;

    private static CustomIcon buttonNewLaboratory,buttonEditLaboratory,buttonDeleteLaboratory,buttonFreshLaboratory,buttonQueryLaboratory;

    private static Object[][] tableDatas;

    private String head[] = null;

    JComboBox comboBox = null;

    public static Vector<String> AL = new Vector<String>();

    JLabel labelTitle;


    public LaboratoryManagePanel() throws SQLException {
        super();
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        addParts();
        head = new String[]{"ID","实验室名","设备数","实验技术员","所属二级学院","座位数","状态"};
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
        labelTitle = new JLabel("实验室管理");
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

        JLabel labelNew = new JLabel("实验室列表");
        labelNew.setFont(FrameConsts.FONT_SUBTITLE);
        labelNew.setForeground(new Color(0,142,250));
        lControl.add(labelNew);
        //select box
        comboBox = new JComboBox<String>(AL);
        AL.add("BigData-Lab");
        AL.add("BasicPhysics-Lab");
        AL.add("Chemical Laboratory");
        AL.add("Software Lab");
        AL.add("FTC-Lab");
        comboBox.setBorder(BorderFactory.createCompoundBorder());
        comboBox.setFont(new Font("Microsoft YaHei UI", 0, 13));
        comboBox.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        //按钮设置
        buttonNewLaboratory = new CustomIcon(FrameConsts.NEWTECHNICIAN_ICON,FrameConsts.NEWTECHNICIAN_ICON_ENABLE,FrameConsts.NEWTECHNICIAN_ICON_DISABLE,"");
        buttonEditLaboratory = new CustomIcon(FrameConsts.EDITTECHNICIAN_ICON,FrameConsts.EDITTECHNICIAN_ICON_ENABLE,FrameConsts.EDITTECHNICIAN_ICON_DISABLE,"");
        buttonDeleteLaboratory = new CustomIcon(FrameConsts.DELETETECHNICIAN_ICON,FrameConsts.DELETETECHNICIAN_ICON_ENABLE,FrameConsts.DELETETECHNICIAN_ICON_DISABLE,"");
        buttonFreshLaboratory = new CustomIcon(FrameConsts.FRESHTECHNICIAN_ICON,FrameConsts.FRESHTECHNICIAN_ICON_ENABLE,FrameConsts.FRESHTECHNICIAN_ICON_DISABLE,"");
        buttonQueryLaboratory = new CustomIcon(FrameConsts.QUERYLAB_ICON,FrameConsts.QUERYLAB_ICON_ENABLE,FrameConsts.QUERYLAB_ICON_DISABLE,"");
        rControl.add(buttonNewLaboratory);
        rControl.add(buttonEditLaboratory);
        rControl.add(buttonDeleteLaboratory);
        rControl.add(buttonFreshLaboratory);
        rControl.add(comboBox);
        rControl.add(buttonQueryLaboratory);

        dataControl.add(rControl);
        dataControl.add(lControl);

        //表格设置
        dataPanel.add(dataControl,BorderLayout.NORTH);
        dataTable = new JTable(tableDatas,new String[]{"ID","实验室名","设备数","实验技术员","所属二级学院","座位数","状态"});
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
        dataTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(6).setMaxWidth(120);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        scrollPane.setForeground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.add(scrollPane,BorderLayout.CENTER);
        return dataPanel;
    }

    /**
     * @description 获取表内数据
     * @param
     * @return java.lang.Object[][]
     */
    public Object[][] initialize() throws SQLException {
        LEMIS_Lab laboratory = new LEMIS_Lab();
        List<LEMIS_Lab> list = lab.queryLab(laboratory);
        tableDatas = new Object[list.size()][7];
        for (int i = 0;i<list.size();i++){
            tableDatas [i][0] = list.get(i).getLab_id();
            tableDatas [i][1] = list.get(i).getLab_name();
            tableDatas [i][2] = list.get(i).getLab_equip();
            tableDatas [i][3] = list.get(i).getLab_technician();
            tableDatas [i][4] = list.get(i).getLab_dept();
            tableDatas [i][5] = list.get(i).getLab_sit();
            tableDatas [i][6] = list.get(i).getLab_status();
        }
        return tableDatas;
    }

    public void reload() throws SQLException {
        LEMIS_Lab laboratory = new LEMIS_Lab();
        List<LEMIS_Lab> list = lab.queryLab(laboratory);
        tableDatas = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            tableDatas [i][0] = list.get(i).getLab_id();
            tableDatas [i][1] = list.get(i).getLab_name();
            tableDatas [i][2] = list.get(i).getLab_equip();
            tableDatas [i][3] = list.get(i).getLab_technician();
            tableDatas [i][4] = list.get(i).getLab_dept();
            tableDatas [i][5] = list.get(i).getLab_sit();
            tableDatas [i][6] = list.get(i).getLab_status();
        }
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);
    }

    public void QueryLab(){
        String labName = (String) comboBox.getSelectedItem();
        List<LEMIS_Lab> list = lab.queryLaboratory(labName);
        tableDatas = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            tableDatas [i][0] = list.get(i).getLab_id();
            tableDatas [i][1] = list.get(i).getLab_name();
            tableDatas [i][2] = list.get(i).getLab_equip();
            tableDatas [i][3] = list.get(i).getLab_technician();
            tableDatas [i][4] = list.get(i).getLab_dept();
            tableDatas [i][5] = list.get(i).getLab_sit();
            tableDatas [i][6] = list.get(i).getLab_status();
        }
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);

    }

    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonNewLaboratory.addActionListener(e -> new LabInsert());
        buttonEditLaboratory.addActionListener(e -> new LabEdit());
        buttonDeleteLaboratory.addActionListener(e -> new LabDelete());
        buttonFreshLaboratory.addActionListener(e -> {
            try {
                AdministratorFrame.laboratoryManagePanel.reload();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        buttonQueryLaboratory.addActionListener(e ->AdministratorFrame.laboratoryManagePanel.QueryLab() );
        dataTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=dataTable.getSelectedRow();
                LabEdit.lid = (String) dataTable.getValueAt(i, 0);
                LabEdit.lname = (String) dataTable.getValueAt(i, 1);
                LabEdit.lequip = (String) dataTable.getValueAt(i, 2);
                LabEdit.ltech = (String) dataTable.getValueAt(i, 3);
                LabEdit.ldept = (String) dataTable.getValueAt(i, 4);
                LabEdit.lsit = (String) dataTable.getValueAt(i, 5);
                LabEdit.lstatus = (String) dataTable.getValueAt(i,6);
                LabDelete.gUid = (String) dataTable.getValueAt(i,0);
                LabDelete.gName = (String) dataTable.getValueAt(i,1);
                LabDelete.gStatus = (String) dataTable.getValueAt(i,5);
            }
        });
    }
}
