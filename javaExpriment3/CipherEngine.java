package com.javaExpriment3;
/**
 * This creates a window with a field for entering text, and associated
 * EventButton object for responding to user actions. The program will
 * take input and either encode it or decode it, using a simple Caesar Cipher,
 * where each letter is shifted 3 positions up or down (wrapping as needed).
 *
 * @author M. Allen
 * @author YOUR NAME HERE
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.*;


public class CipherEngine {
    // instance variables: placing these here allows them to be used
    // in multiple places (like the createWindow() and buttonPressed() methods)
    private JTextField input;

    /**
     * Simple main: creates the CipherEngine object, and then runs its methods to do
     * the work.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        CipherEngine engine = new CipherEngine();
        engine.createWindow();
    }

    /**
     * Creates the graphical window and its contents.
     */
    public void createWindow() {
        int windowWidth = 500;
        int windowHeight = 150;
        int graphicHeight = 25;

        JFrame win = new JFrame();
        win.setSize(windowWidth, windowHeight);
        win.setLocation(50, 50);
        win.setTitle("Fdhvdu Flskhu");
        Color paleGreen = new Color(152, 251, 152);
        win.getContentPane().setBackground(paleGreen);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setVisible(true);

        input = new JTextField();
        input.setBounds(50, windowHeight / 4, windowWidth - 100, graphicHeight);
        win.add(input, 0);

        //加密按钮
        EventButton button = new EventButton(this);
        button.setLocation(windowWidth / 2 - 50, windowHeight / 4 + 2 * graphicHeight);
        button.setSize(100, graphicHeight);
        button.setText("Encode");
        win.add(button, 0);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //改变按钮的文字为Encode或者Decode
                if (button.getText().equals("Encode")) {
                    button.setText("Decode");
                } else {
                    button.setText("Encode");
                }

            }
        });

        win.repaint();
    }

    //加密算法
    private String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += 3;
                if (c > 'z') {
                    c -= 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c += 3;
                if (c > 'Z') {
                    c -= 26;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
    //解密算法
    private String decode(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c -= 3;
                if (c < 'a') {
                    c += 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c -= 3;
                if (c < 'A') {
                    c += 26;
                }
            }
            sb.append(c);

        }
        return sb.toString();
    }

    int count = 0;
    public void buttonPressed() {
        //获取输入的字符串，并调用加密或者解密算法
        String input = this.input.getText();
        //根据次数判断是加密还是解密，偶数次加密，奇数次解密

        if (count % 2 == 0) {
            //加密
            //将结果显示在输入框中
            this.input.setText(encode(input));
            count++;
        } else {
            //解密
            //将结果显示在输入框中
            this.input.setText(decode(input));
            count++;
        }

    }


}


