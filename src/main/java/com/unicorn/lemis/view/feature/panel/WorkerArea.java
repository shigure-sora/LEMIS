package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.entity.LEMIS_Maintain;
import com.unicorn.lemis.entity.LEMIS_Request;
import com.unicorn.lemis.model.dao.CheckDataAccessObject;
import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.WorkerDataAccessObject;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.WorkerFrame;

import javax.swing.*;
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
 * @date 2021/6/22 23:54
 */

public class WorkerArea extends JPanel {

    public static String greq_id =null;
    public static String gequip_name = null;
    public static String gequip_id = null;
    public static String gproblem = null;
    public static String gstatus = null;
    public static String gseries = null;
    public static String gworkerName = null;

    WorkerDataAccessObject worker = new WorkerDataAccessObject();
    EquipDataAccessObject equip = new EquipDataAccessObject();
    CheckDataAccessObject check = new CheckDataAccessObject();
    LEMIS_Maintain work = new LEMIS_Maintain();



    public static JTable dataTable;

    private DefaultTableModel defaultTableModel = null;

    private static CustomIcon buttonNewTechnician, buttonEditTechnician, buttonDeleteTechnician, buttonFreshTechnician;

    private static Object[][] tableDatas;

    private String head[] = null;
    private Vector<Vector<String>> vec1;
    private Vector<String> vec2 = null;

    JLabel labelTitle;


    public WorkerArea() throws SQLException {
        super();
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        addParts();
        head = new String[]{"请求ID", "设备名称", "设备ID", "设备类别","问题描述", "状态"};
        DefaultTableModel tableModel = new DefaultTableModel(initialize(), head);
        dataTable.setModel(tableModel);
        tableModel.fireTableDataChanged();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        dataTable.setDefaultRenderer(Object.class, renderer);
        addListener();
    }


    public void addParts() {
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * @description 面板上部
     */

    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, FrameConsts.MAIN_H_GAP, 5));
        labelTitle = new JLabel("维修管理");
        labelTitle.setFont(FrameConsts.FONT_TITLE);
        labelTitle.setForeground(FrameConsts.SELECTBAR_BACK_COLOR);
        panelUp.add(labelTitle);
        return panelUp;
    }

    /**
     * @description 面板中部
     */
    private JPanel getCenterPanel() {
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        panelCenter.setLayout(new GridLayout(1, 1));
        panelCenter.add(getDataPanel());

        return panelCenter;
    }


    /**
     * @description data
     */
    private JPanel getDataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.setLayout(new BorderLayout());
        //网格布局
        JPanel dataControl = new JPanel();
        dataControl.setLayout(new GridLayout(2, 1));
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        //流式布局
        JPanel lControl = new JPanel();
        lControl.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        lControl.setLayout(new FlowLayout(FlowLayout.LEFT, FrameConsts.MAIN_H_GAP, 5));
        JPanel rControl = new JPanel();
        rControl.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        rControl.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 5));

        JLabel labelNew = new JLabel("维修管理");
        labelNew.setFont(FrameConsts.FONT_SUBTITLE);
        labelNew.setForeground(new Color(0, 142, 250));
        lControl.add(labelNew);
        //按钮设置
        buttonEditTechnician = new CustomIcon(FrameConsts.FIX_ICON, FrameConsts.FIX_ICON_ENABLE, FrameConsts.EDITTECHNICIAN_ICON_DISABLE, "");
        buttonDeleteTechnician = new CustomIcon(FrameConsts.CFIX_ICON, FrameConsts.CFIX_ICON_ENABLE, FrameConsts.DELETETECHNICIAN_ICON_DISABLE, "");
        buttonFreshTechnician = new CustomIcon(FrameConsts.FRESHTECHNICIAN_ICON, FrameConsts.FRESHTECHNICIAN_ICON_ENABLE, FrameConsts.FRESHTECHNICIAN_ICON_DISABLE, "");
        rControl.add(buttonEditTechnician);
        rControl.add(buttonDeleteTechnician);
        rControl.add(buttonFreshTechnician);

        dataControl.add(rControl);
        dataControl.add(lControl);

        //表格设置
        dataPanel.add(dataControl, BorderLayout.NORTH);
        dataTable = new JTable(tableDatas, new String[]{"请求ID", "设备名称", "设备ID", "设备类别","问题描述", "状态"});
        dataTable.setFont(FrameConsts.FONT_NORMAL);
        dataTable.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
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
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(81);
        dataTable.getColumnModel().getColumn(5).setMaxWidth(91);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.add(scrollPane, BorderLayout.CENTER);
        return dataPanel;

    }

    /**
     * @param
     * @return java.lang.Object[][]
     * @description 获取表内数据
     */
    public Object[][] initialize() throws SQLException {
        LEMIS_Maintain maintain = new LEMIS_Maintain();
        java.util.List<LEMIS_Maintain> list = worker.queryMaintain(maintain);
        tableDatas = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            tableDatas[i][0] = list.get(i).getReq_id();
            tableDatas[i][1] = list.get(i).getEquip_name();
            tableDatas[i][2] = list.get(i).getEquip_no();
            tableDatas[i][3] = list.get(i).getEquip_series();
            tableDatas[i][4] = list.get(i).getProblem();
            tableDatas[i][5] = list.get(i).getStatus();
        }
        worker.deleteNull();
        return tableDatas;
    }

    public void reload() throws SQLException {
        LEMIS_Maintain maintain = new LEMIS_Maintain();
        List<LEMIS_Maintain> list = worker.queryMaintain(maintain);
        tableDatas = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            tableDatas[i][0] = list.get(i).getReq_id();
            tableDatas[i][1] = list.get(i).getEquip_name();
            tableDatas[i][2] = list.get(i).getEquip_no();
            tableDatas[i][3] = list.get(i).getEquip_series();
            tableDatas[i][4] = list.get(i).getProblem();
            tableDatas[i][5] = list.get(i).getStatus();
        }
        worker.deleteNull();
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);
    }
    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonEditTechnician.addActionListener(e -> {
            String newStatus = "Normal";
            dataTable.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    int i=dataTable.getSelectedRow();
                    greq_id = (String) dataTable.getValueAt(i, 0);
                    gequip_name = (String) dataTable.getValueAt(i, 1);
                    gequip_id = (String) dataTable.getValueAt(i, 2);
                    gseries = (String) dataTable.getValueAt(i, 3);
                    gproblem = (String) dataTable.getValueAt(i, 4);
                    gstatus = (String) dataTable.getValueAt(i, 5);
                }
            });
            LEMIS_Equip maintain = new LEMIS_Equip();
            maintain.setEquip_no(gequip_id);
            maintain.setProblem(gproblem);
            maintain.setStatus(newStatus);
            maintain.setWorker_name(gworkerName);
            maintain.setReq_repair_man("");
            try {
                DataBaseUtil.getConn();
                worker.delete(greq_id);
                equip.workerUpdate(maintain);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        buttonDeleteTechnician.addActionListener(e -> {
            String newStatus = "Wating";
            work.setNewStatus(newStatus);
            dataTable.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    int i=dataTable.getSelectedRow();
                    greq_id = (String) dataTable.getValueAt(i, 0);
                    gequip_name = (String) dataTable.getValueAt(i, 1);
                    gequip_id = (String) dataTable.getValueAt(i, 2);
                    gseries = (String) dataTable.getValueAt(i, 3);
                    gproblem = (String) dataTable.getValueAt(i, 4);
                    gstatus = (String) dataTable.getValueAt(i, 5);
                }
            });
            LEMIS_Request maintain = new LEMIS_Request();
            maintain.setRequest_id(greq_id);
            maintain.setEquip_name(gequip_name);
            maintain.setEquip_no(gequip_id);
            maintain.setProblem(gproblem);
            maintain.setStatus(gstatus);
            maintain.setEquip_series(gseries);
            try {
                DataBaseUtil.getConn();
                check.updateStatus(maintain);
                worker.delete(greq_id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        buttonFreshTechnician.addActionListener(e -> {
            try {
                WorkerFrame.workerPanel.reload();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
