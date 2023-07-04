package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Calender extends JFrame implements ActionListener {
    String[] months = {"January", "February", "March", "April", "May", "June", "July",
                        "August", "September","October", "November", "December"};
    public Calender(){
        int width = 130;
        int height = 50;
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x <= 5; x++) {
                JButton button = new JButton(months[x+(6*y)]);
                button.setBounds(0 + ((width + (width / 5)) * x+1), 0 + ((height + (height / 5)) * y+1), width, height);
                button.addActionListener(this);
                getContentPane().add(button);
            }
            setLayout(null);
            setBounds(0,0,1000,250);
            setVisible(true);
        }
    }
    public Calender(int dayOfWeek,int daysInMonth){
        int week = 1;
        int width = 50;
        int height = 50;
        for(int day = 1; day <= daysInMonth; day++){
            JButton button = new JButton(Integer.toString(day));
            button.setBounds(0+((width+(width/5))*dayOfWeek),0+((height+(height/5))*week),width,height);
            button.addActionListener(this);
            getContentPane().add(button);
            if(dayOfWeek == 7){
                dayOfWeek = 0;
                week++;
            }
            dayOfWeek++;
        }
        setLayout(null);
        setBounds(0,0,550,450);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("January")){
            new Calender(1,31);
        }
    }

}
