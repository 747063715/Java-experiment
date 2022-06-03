package com.javaExpeiment2; /**
 * This program will do some simple interactive
 * text-processing and input manipulation.
 *
 * @author M. Allen
 */

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Program {
    /**
     * A window is opened containing 2 text-fields, a button,
     * and a label area for displaying more text.  The buttons
     * take any user input and display different versions on-screen.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        // variables for window size; also used to position objects
        int windowWidth = 500;
        int windowHeight = 250;

        // variable for window color
        Color lightSkyBlue = new Color(135, 206, 250);

        // create the window for the program
        JFrame win = new JFrame();
        win.setLocation(50, 50);
        win.setSize(windowWidth, windowHeight);
        win.getContentPane().setBackground(lightSkyBlue);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("What do you say?");
        win.setVisible(true);
        win.setResizable(false);

        // add the first label: it is given size and location using setBounds();
        // it is set to be opaque so that we can see it on-screen
        int indent = 50;
        int labelWidth = windowWidth - (2 * indent);
        int labelHeight = 25;
        int labelYCoordinate = 25;


        //add the first label
        JLabel answer1 = new JLabel();
        answer1.setBounds(indent, labelYCoordinate, labelWidth, labelHeight);
        answer1.setBackground(Color.white);
        answer1.setOpaque(true);
        win.add(answer1, 0);



        //add the second label
        //it is set to be opaque so that we can see it on-screen
        JLabel answer2 = new JLabel();
        answer2.setBounds(indent, labelYCoordinate + labelHeight + 25, labelWidth, labelHeight);
        answer2.setBackground(Color.white);
        answer2.setOpaque(true);
        win.add(answer2, 0);


        //create a JTextField
        int textFieldWidth = windowWidth - (2 * indent);
        int textFieldHeight = 25;
        int textFieldYCoordinate = labelYCoordinate + labelHeight + 75;
        JTextField textField = new JTextField();
        textField.setBounds(indent, textFieldYCoordinate, textFieldWidth, textFieldHeight);
        win.add(textField, 0);


        //create a JButton
        TextButton button = new TextButton(textField);
        button.setSize(100, 25);
        button.setLocation(100, 175);
        win.add(button);
        button.setText("ALL CAPS");

        //create a JButton
        TextButton button2 = new TextButton(textField);
        button2.setSize(100, 25);
        button2.setLocation(250, 175);
        win.add(button2);
        button2.setText("Capitalize");


        /*
        ��������ť����¼�������������ť�����ʱ������TextButton���getInput()����
         */
        //����������ݸ�Ϊ�Ե�һ����ĸ��д��������Ķ���Сд����ʽ��������ڶ��� JLabel ����ʾ�м��ǩ�е��ı���
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer2.setText(textField.getText().substring(0, 1).toUpperCase() + textField.getText().substring(1).toLowerCase());

            }
        });

        //������ַ�����ʾ����һ��label��
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer1.setText(textField.getText().toUpperCase());
            }
        });
        float b = 0.1f;




        win.repaint();
    }
}
