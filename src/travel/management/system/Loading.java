package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    Loading(String username)
    {
        this.username=username;
        t= new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel And Tourism Application");
        text.setBounds(70,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Rayleway",Font.BOLD,30));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(220,130,200,30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Rayleway",Font.BOLD,16));
        add(loading);

        JLabel userName = new JLabel("Welcome "+username);
        userName.setBounds(20,310,400,40);
        userName.setForeground(Color.red);
        userName.setFont(new Font("Rayleway",Font.BOLD,16));
        add(userName);

        t.start();




        setVisible(true);
    }
    @Override
    public void run() {
        try{
            for(int i = 0;i<=101;i++)
            {
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                if(value < max)
                {
                    bar.setValue(bar.getValue()+1);
                } else {
                    setVisible(false);
                    //new class object;
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }


    public static void main(String []args)
    {
        new Loading("");
    }


}
