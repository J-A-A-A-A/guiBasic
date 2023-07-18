package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Array;

public class Calender extends JFrame implements ActionListener {
    String[] months = { "September","October", "November", "December","January", "February", "March", "April", "May", "June", "July", "August"};
    int[] daysInMonths = {30,31,30,31,31,28,31,30,31,30,31,31};
    int[] dayMonthStart = {6,1,4,6,1,4,4,7,2,5,7,3};
    int year;

    public void firstDayOfYear(int year){
        int sum;
        for (int y = 0; y<2;y++) {
            year = year+y;
            System.out.println(year);
            int lastTwoDigits = (year % 100);
            int quotient = lastTwoDigits / 4;
            sum = lastTwoDigits + quotient;
            if (year >= 2000) {
                sum += 6;
            } else {
                sum += 5;
            }
            for(int x = 0; x<12;x++) {
                if ((x<4 && y==0)||(x>3 && y==1)) {
                    dayMonthStart[x] = (dayMonthStart[x] + sum) % 7;
                    if (dayMonthStart[x] == 0) {
                        dayMonthStart[x] = 7;
                    }
                }
            }
        }
    }

    public Calender(int year){
        this.year = year;
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
        firstDayOfYear(year);
    }

    public Calender(int dayOfWeek,int daysInMonth){
        int week = 1;
        int width = 50;
        int height = 50;
        for(int d = 1; d <= daysInMonth; d++){
            JButton button = new JButton(Integer.toString(d));
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
        setBounds(0,0,550,500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int x = 0; x<12;x++) {
            if (e.getActionCommand().equals(months[x])) {
                new Calender(dayMonthStart[x], daysInMonths[x]);
            }
        }



    }

}
