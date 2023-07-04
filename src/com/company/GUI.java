package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class GUI extends JFrame implements ActionListener {
    JButton testButton;
    public GUI(){
        testButton = new JButton("January");
        testButton.setBounds(10,10,150,50);
        testButton.addActionListener(this);
        getContentPane().add(testButton);
        setLayout(null);
        //pack();
        setBounds(0,0,300,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("January")){
            System.out.println("hello");
        }
    }
}
