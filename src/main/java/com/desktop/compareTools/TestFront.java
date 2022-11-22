package com.desktop.compareTools;

import com.util.compare.JsonContain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommonTools
 * com.desktop.compareTools
 * 2022/11/19
 **/
public class TestFront {
    private JTextArea InterfaceStand;
    private JTextArea JsonRequest;
    private JButton CompareButton;
    private JButton ClearJson;
    private JButton ClearInterface;
    private JPanel CompareJPanel;
    private JScrollPane JsonJPanel;
    private JScrollPane IneterFaceJPanel;
    private JTextArea CompareResult;
    private JScrollPane CompareRes;
    //将info立即追加到JTextArea中
 /*   public static void appendInterfaceJTextArea(String info) {
        InterfaceStand.append(info + "\n");
        InterfaceStand.paintImmediately(InterfaceStand.getX(), InterfaceStand.getY(), InterfaceStand.getWidth(), InterfaceStand.getHeight());

    }
    public static void appendJsonJTextArea(String info) {
        JsonRequest.append(info + "\n");
        JsonRequest.paintImmediately(JsonRequest.getX(), JsonRequest.getY(), JsonRequest.getWidth(), JsonRequest.getHeight());

    }*/

    public TestFront() {

       ClearJson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JsonRequest.setText("");
            }
        });

       CompareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            CompareResult.setText("");
            Map<String, List<String>> res=new HashMap<>();
            res=  new JsonContain().JsonJudge(InterfaceStand.getText().split("\n"),JsonRequest.getText());
            CompareResult.setText("请求中符合接口标准的字段有：\n");
            for(int i=0;i<res.get("exist").size();i++)
            {
                CompareResult.append(res.get("exist").get(i)+"\n");
            }
            CompareResult.append("\n接口有请求没有的字段：\n");
            for(int i=0;i<res.get("nothingness").size();i++)
            {
                CompareResult.append(res.get("nothingness").get(i)+"\n");
            }
            CompareResult.append("\n接口没有请求有的字段：\n");
            for(int i=0;i<res.get("jsonmaore").size();i++)
            {
                CompareResult.append(res.get("jsonmaore").get(i)+"\n");
            }
            }
        });
        ClearInterface.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceStand.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestFront");
        frame.setContentPane(new TestFront().CompareJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
