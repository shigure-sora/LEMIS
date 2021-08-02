package com.unicorn.lemis;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.dao.UserDataAccessObject;
import com.unicorn.lemis.util.PropertyUtil;
import com.unicorn.lemis.view.LoginFeature.LoginFrame;
import com.unicorn.lemis.view.LoginFeature.RegistryFrame;
import com.unicorn.lemis.view.feature.FrameConsts;
import com.unicorn.lemis.view.feature.panel.*;
import com.unicorn.lemis.view.user.AdministratorFrame;
import com.unicorn.lemis.view.user.StudentFrame;
import com.unicorn.lemis.view.user.TeacherFrame;
import com.unicorn.lemis.view.user.WorkerFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Launch_TestMode {
    private JFrame frame;

    public static JPanel mainPanelCenter;

    public static DefaultPanel defaultPanel;
    public static LaboratoryManagePanel laboratoryManagePanel;
    public static EquipmentManagePanel equipmentManagePanel;
    public static TechnicianManagePanel technicianManagePanel;
    public static RequestPanel requestPanel;
    public static WorkerPanel workerPanel;
    public static CheckPanel checkPanel;

    public static void main(String[] args) throws Exception {


        //Data base test
       //LEMIS_User user = new LEMIS_User("316381099", "kano_dayo", "123456", "Administrator", "17777777777", "BigData", "122448");
        //UserDataAccessObject assa = new  UserDataAccessObject();
        //String user_id = "1000";
        //assa.insert(user);
        //assa.update(user);
        //assa.delete("1000");
        //assa.queryUser(user);
        //System.out.println(assa);
        //String a =assa.titleChecker("316381099");
        //String user_auth = assa.randomcode(user);
        //System.out.println(user_auth);
        //boolean flag=assa.checker("122448");
        // System.out.println(a);
        /**
         * @description Frame test
         */
        // TODO: 2021/6/19 多线程处理模块测试 
        /**try {
            for(int i=0; i<=10; i++){
                Connection conn = DataBaseUtil.getConnection1();
                System.out.println(conn);
                DataBaseUtil.freeConnection(conn);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        //random test
        /**Random rand = new Random();
        for(int i=0; i<10; i++) {
            System.out.println(rand.nextInt(400000000) + 316381099);
        }
        int user_id = 316381099;
        user_id++;
        System.out.println(user_id);*/
            try {
                //BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
                //UIManager.put("RootPane.setupButtonVisible",false);
                //org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
               // LoginFrame LF = new LoginFrame();
                AdministratorFrame af = new AdministratorFrame();
                //WorkerFrame wf = new WorkerFrame();
                //StudentFrame sf = new StudentFrame();
                //TeacherFrame tf = new TeacherFrame();
                //RegistryFrame rf = new RegistryFrame();
                //RetrieveFrame rt = new RetrieveFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

}
