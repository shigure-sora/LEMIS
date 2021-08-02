package com.unicorn.lemis.view.feature.panel;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.model.dao.EquipDataAccessObject;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.model.feature.EquipDelete;
import com.unicorn.lemis.model.feature.EquipEdit;
import com.unicorn.lemis.model.feature.EquipInsert;
import com.unicorn.lemis.model.service.EquipService;
import com.unicorn.lemis.view.components.CustomIcon;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.TechnicianFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author kano_dayo
 * @date 2021/6/22 21:21
 */

public class EquipmentManagePanel extends JPanel {

    EquipDataAccessObject equipDataAccessObject = new EquipDataAccessObject();

    public static String global_user_id = null;

    private EquipService equipService = null;



    public static JTable dataTable;

    private static CustomIcon buttonNewEquip, buttonEditEquip, buttonDeleteEquip, buttonFreshEquip,buttonQueryEquip;

    private static Object[][] tableDatas;

    private String head[] = null;
    JLabel labelTitle;

    public EquipmentManagePanel() throws Exception {
        super();
        this.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        addParts();
        head = new String[]{"设备编号", "设备名称", "所在实验室","生产日期", "保修日期", "厂商", "类型", "状态", "问题描述","维修申请人","维修员"};
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
        labelTitle = new JLabel("设备管理");
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

        JLabel labelNew = new JLabel("设备列表");
        labelNew.setFont(FrameConsts.FONT_SUBTITLE);
        labelNew.setForeground(new Color(0, 142, 250));
        lControl.add(labelNew);
        //按钮设置
        buttonNewEquip = new CustomIcon(FrameConsts.NEWTECHNICIAN_ICON, FrameConsts.NEWTECHNICIAN_ICON_ENABLE, FrameConsts.NEWTECHNICIAN_ICON_DISABLE, "");
        buttonEditEquip = new CustomIcon(FrameConsts.EDITTECHNICIAN_ICON, FrameConsts.EDITTECHNICIAN_ICON_ENABLE, FrameConsts.EDITTECHNICIAN_ICON_DISABLE, "");
        buttonDeleteEquip = new CustomIcon(FrameConsts.DELETETECHNICIAN_ICON, FrameConsts.DELETETECHNICIAN_ICON_ENABLE, FrameConsts.DELETETECHNICIAN_ICON_DISABLE, "");
        buttonFreshEquip = new CustomIcon(FrameConsts.FRESHTECHNICIAN_ICON, FrameConsts.FRESHTECHNICIAN_ICON_ENABLE, FrameConsts.FRESHTECHNICIAN_ICON_DISABLE, "");
        buttonQueryEquip = new CustomIcon(FrameConsts.QUERYTECHNICIAN_ICON,FrameConsts.QUERYTECHNICIAN_ICON_ENABLE,FrameConsts.QUERYTECHNICIAN_ICON_DISABLE,"");
        rControl.add(buttonNewEquip);
        rControl.add(buttonEditEquip);
        rControl.add(buttonDeleteEquip);
        rControl.add(buttonFreshEquip);
        rControl.add(buttonQueryEquip);

        dataControl.add(rControl);
        dataControl.add(lControl);

        //表格设置
        dataPanel.add(dataControl, BorderLayout.NORTH);
        dataTable = new JTable(tableDatas, new String[]{"设备编号", "设备名称", "所在实验室","生产日期", "保修日期", "厂商", "类型", "状态", "问题描述","维修申请人","维修员"});
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
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(180);
        dataTable.getColumnModel().getColumn(3).setMaxWidth(180);
        dataTable.getColumnModel().getColumn(4).setPreferredWidth(180);
        dataTable.getColumnModel().getColumn(4).setMaxWidth(180);
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(5).setMaxWidth(120);
        dataTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(6).setMaxWidth(130);
        dataTable.getColumnModel().getColumn(7).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(7).setMaxWidth(130);
        dataTable.getColumnModel().getColumn(8).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(8).setMaxWidth(130);
        dataTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(9).setMaxWidth(130);
        dataTable.getColumnModel().getColumn(10).setPreferredWidth(120);
        dataTable.getColumnModel().getColumn(10).setMaxWidth(130);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBackground(FrameConsts.MAIN_BACKGROUND_COLOR);
        dataPanel.add(scrollPane, BorderLayout.CENTER);
        return dataPanel;

    }

    /**
     * update and query
     * @return java.lang.Object[][]
     * @description 获取表内数据
     */
    public Object[][] initialize() throws Exception {
        LEMIS_Equip equip = new LEMIS_Equip();
        List<LEMIS_Equip> list = equipDataAccessObject.queryEquip(equip);
        int length = head.length;
        tableDatas = new Object[list.size()][length];
        for (int i = 0; i < list.size(); i++) {
                tableDatas[i][0] = list.get(i).getEquip_no();
                tableDatas[i][1] = list.get(i).getEquip_name();
                tableDatas[i][2] = list.get(i).getEquip_lab();
                tableDatas[i][3] = list.get(i).getManufacturing_date();
                tableDatas[i][4] = list.get(i).getExpiring_date();
                tableDatas[i][5] = list.get(i).getManufactory();
                tableDatas[i][6] = list.get(i).getEquip_series();
                tableDatas[i][7] = list.get(i).getStatus();
                tableDatas[i][8] = list.get(i).getProblem();
                tableDatas[i][9] = list.get(i).getReq_repair_man();
                tableDatas[i][10] = list.get(i).getWorker_name();
        }
        return tableDatas;
    }

    public void reload() throws Exception {
        LEMIS_Equip equip = new LEMIS_Equip();
        List<LEMIS_Equip> list = equipDataAccessObject.queryEquip(equip);
        int length = head.length;
        tableDatas = new Object[list.size()][length];
        for (int i = 0; i < list.size(); i++) {
                tableDatas[i][0] = list.get(i).getEquip_no();
                tableDatas[i][1] = list.get(i).getEquip_name();
                tableDatas[i][2] = list.get(i).getEquip_lab();
                tableDatas[i][3] = list.get(i).getManufacturing_date();
                tableDatas[i][4] = list.get(i).getExpiring_date();
                tableDatas[i][5] = list.get(i).getManufactory();
                tableDatas[i][6] = list.get(i).getEquip_series();
                tableDatas[i][7] = list.get(i).getStatus();
                tableDatas[i][8] = list.get(i).getProblem();
                tableDatas[i][9] = list.get(i).getReq_repair_man();
                tableDatas[i][10] = list.get(i).getWorker_name();

        }
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);
    }

    public void queryProblem() throws Exception {
        String status = "needFix";
        List<LEMIS_Equip> list = equipDataAccessObject.queryStatus(status);
        int length = head.length;
        tableDatas = new Object[list.size()][length];
        for (int i = 0; i < list.size(); i++) {
            tableDatas[i][0] = list.get(i).getEquip_no();
            tableDatas[i][1] = list.get(i).getEquip_name();
            tableDatas[i][2] = list.get(i).getEquip_lab();
            tableDatas[i][3] = list.get(i).getManufacturing_date();
            tableDatas[i][4] = list.get(i).getExpiring_date();
            tableDatas[i][5] = list.get(i).getManufactory();
            tableDatas[i][6] = list.get(i).getEquip_series();
            tableDatas[i][7] = list.get(i).getStatus();
            tableDatas[i][8] = list.get(i).getProblem();
            tableDatas[i][9] = list.get(i).getReq_repair_man();
            tableDatas[i][10] = list.get(i).getWorker_name();
        }
        TableModel dataModel = new DefaultTableModel(tableDatas, head);
        dataTable.setModel(dataModel);
    }

    private void addListener() {
        // TODO: 2021/6/26 rewrite in lambda finish
        buttonNewEquip.addActionListener(e -> new EquipInsert());
        buttonEditEquip.addActionListener(e -> new EquipEdit());
        buttonDeleteEquip.addActionListener(e -> new EquipDelete());
        dataTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=dataTable.getSelectedRow();
                EquipEdit.eno = (String) dataTable.getValueAt(i, 0);
                EquipEdit.elab = (String) dataTable.getValueAt(i, 2);
                EquipEdit.estatus = (String) dataTable.getValueAt(i, 7);
                EquipEdit.epro = (String) dataTable.getValueAt(i, 8);
                EquipEdit.ereq = (String) dataTable.getValueAt(i, 9);
                EquipEdit.ework = (String) dataTable.getValueAt(i, 10);
                EquipDelete.gUid = (String) dataTable.getValueAt(i,0);
                EquipDelete.gName = (String) dataTable.getValueAt(i,1);
                EquipDelete.gStatus = (String) dataTable.getValueAt(i,5);
            }
        });
        buttonFreshEquip.addActionListener(e -> {
            try {
                    AdministratorFrame.equipmentManagePanel.reload();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        buttonQueryEquip.addActionListener(e -> {
            try {

                    AdministratorFrame.equipmentManagePanel.queryProblem();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }
}
