package com.unicorn.lemis.view.components;

import javax.swing.*;
import java.awt.*;

/**
 * @description 自定义按钮类，自定义默认图标、激活图标、失效图标和Comments提示
 * @author kano_dayo
 * @date 2021/6/15 14:28
 */

public class CustomIcon extends JButton {

    private ImageIcon Enable, Disable;
    private String Comments;

    /**
     * @description Constructor
     * @param Normal  默认图标
     * @param Enable  激活图标
     * @param Disable 失效图标
     * @param Comments 提示
     */

    public CustomIcon(ImageIcon Normal, ImageIcon Enable, ImageIcon Disable, String Comments) {
        super(Normal);
        this.Enable = Enable;
        this.Disable = Disable;
        this.Comments = Comments;

        initialize();
        setStatus();
    }


    /**
     * @description 初始化按钮属性
     */

    private void initialize() {
        this.setBorderPainted(false);//无边框
        this.setFocusPainted(false);//无焦点渲染
        this.setContentAreaFilled(false);//无内容
        this.setFocusable(true);//无焦点
        this.setMargin(new Insets(0, 0, 0, 0));//边距为0
    }
    /**
     * @description 设置按钮状态
     */

    private void setStatus() {
        this.setRolloverIcon(Enable);//鼠标移过状态
        this.setPressedIcon(Enable);//鼠标按压状态
        this.setDisabledIcon(Disable);//图标失效
        }


}
