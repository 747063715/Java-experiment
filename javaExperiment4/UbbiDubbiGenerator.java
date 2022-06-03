package com.javaExperiment4; /**
 * EXPLAIN WHAT THIS PROGRAM DOES (DELETE THIS)
 *
 * @author YOUR NAME HERE
 */

import javax.swing.*;
import java.awt.*;

public class UbbiDubbiGenerator {
    private JTextField input;
    private JLabel output;

    /**
     * Simple main: creates the Driver object, and then runs its methods to do
     * the actual heavy lifting.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        UbbiDubbiGenerator d = new UbbiDubbiGenerator();
        d.createWindow();
    }

    /**
     * Creates the graphical window and its contents.
     */
    public void createWindow() {
        //创建窗口
        JFrame win = new JFrame();
        win.setTitle("Ubbi Dubbi Generator");
        win.setSize(690, 200);
        win.setLocation(50, 50);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.getContentPane().setBackground(Color.GRAY);
        win.setResizable(false);
        win.setLayout(null);
        win.setVisible(true);

        Label label1 = new Label("input:");
        label1.setBounds(50, 30, 50, 25);
        win.add(label1);

        input = new JTextField();
        input.setBounds(90, 30, 500, 25);
        win.add(input, 0);


        Label label2 = new Label("Ubbi Dubbi:");
        label2.setBounds(16, 70, 90, 25);
        win.add(label2);

        output = new JLabel();
        output.setBounds(90, 70, 500, 25);

        //设置output的背景颜色为白色
        output.setBackground(Color.white);
        output.setOpaque(true);
        win.add(output, 0);

        //创建按钮，位置居中
        EventButton tranButton = new EventButton(this);
        tranButton.setLocation(win.getWidth() / 2 - 50, 120);
        tranButton.setSize(100, 25);
        tranButton.setText("Translate");
        win.add(tranButton, 0);

        win.repaint();

    }

    /**
     * When a related EventButton is pressed, it will call this method.
     * <p>
     * The code will read in user input and translate to Ubbi Dubbi.
     */
    public void buttonPressed() {
        //任何元音序列（a, e, i, o, u）在它们之前都添加了音节 “ub”。任何出现的“y”都视为辅音，任何其他字母或标点符号都将被保持不变。
        String inputString = input.getText();
        //将输入的字符串转换为小写
        inputString = inputString.toLowerCase();
        //
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            //获取输入的字符
            char c = inputString.charAt(i);
            //寻找连续的元音字母序列，在前面添加ub
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (i > 0) {
                    //获取前一个字符
                    char pre = inputString.charAt(i - 1);
                    if (pre != 'a' && pre != 'e' && pre != 'i' && pre != 'o' && pre != 'u') {
                        outputString.append("ub");
                    }
                }

            }
            //将其他字母添加到输出字符串中
            outputString.append(c);
        }
        //将输出的字符串放到output中
        output.setText(outputString.toString());

    }


}
