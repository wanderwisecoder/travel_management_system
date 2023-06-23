package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewPackage(String username)
    {
        this.username=username;

        setBounds(450,180,870,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel labelHeading = new JLabel("VIEW PACKAGE DETAILS");
        labelHeading.setBounds(150,20,300,25);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelHeading);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(30,60,150,25);
        add(labelUsername);

        JLabel labelUsername1 = new JLabel();
        labelUsername1.setBounds(220,60,150,25);
        add(labelUsername1);

        JLabel labelPackage = new JLabel("Package: ");
        labelPackage.setBounds(30,120,150,25);
        add(labelPackage);

        JLabel labelPackage1 = new JLabel();
        labelPackage1.setBounds(220,120,150,25);
        add(labelPackage1);

        JLabel labelTotalPersons = new JLabel("Total Persons: ");
        labelTotalPersons.setBounds(30,180,150,25);
        add(labelTotalPersons);

        JLabel labelTotalPersons1 = new JLabel();
        labelTotalPersons1.setBounds(220,180,150,25);
        add(labelTotalPersons1);

        JLabel labelId = new JLabel("Id: ");
        labelId.setBounds(30,240,150,25);
        add(labelId);

        JLabel labelId1 = new JLabel();
        labelId1.setBounds(220,240,150,25);
        add(labelId1);

        JLabel labelIdNumber = new JLabel("Id Number: ");
        labelIdNumber.setBounds(30,300,150,25);
        add(labelIdNumber);

        JLabel labelIdNumber1 = new JLabel();
        labelIdNumber1.setBounds(220,300,150,25);
        add(labelIdNumber1);

        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(30,360,150,25);
        add(labelPhone);

        JLabel labelPhone1 = new JLabel();
        labelPhone1.setBounds(220,360,150,25);
        add(labelPhone1);

        JLabel labelTotalPrice = new JLabel("Total Price: ");
        labelTotalPrice.setBounds(30,420,150,25);
        add(labelTotalPrice);

        JLabel labelTotalPrice1 = new JLabel();
        labelTotalPrice1.setBounds(220,420,150,25);
        add(labelTotalPrice1);

        back = new JButton("Back");
        back.setBounds(150,540,150,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(290,100,590,390);
        add(image);



        try
        {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from bookedpackages where username = '"+ username + "'");
            while(rs.next())
            {
                labelUsername1.setText(rs.getString("username"));
                labelPackage1.setText(rs.getString("packGE"));
                labelTotalPersons1.setText(rs.getString("nopersons"));
                labelId1.setText(rs.getString("id"));
                labelIdNumber1.setText(rs.getString("number"));
                labelPhone1.setText(rs.getString("phone"));
                labelTotalPrice1.setText(rs.getString("totalprice"));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back)
        {
            setVisible(false);
            new Dashboard(username);
        }

    }

    public static void main(String []args)

    {
        new ViewPackage("");
    }
}
