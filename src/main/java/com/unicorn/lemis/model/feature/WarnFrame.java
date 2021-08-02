package com.unicorn.lemis.model.feature;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * @author kano_dayo
 * @date 2021/6/20 18:35
 */

public class WarnFrame {

    JFrame warning = new JFrame();;

    public WarnFrame(){
    }
    public void retrieveSuccessful() {
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
        JOptionPane.showMessageDialog(warning, "找回成功");
    }
    public void checkWarning() {
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Microsoft YaHei UI", 0, 13)));
        JOptionPane.showMessageDialog(warning, "授权码或注册类型错误");
    }

}
