package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewBookedHotel(String username)
    {
        this.username=username;

        setBounds(400,200,1000,750);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel labelHeading = new JLabel("VIEW BOOKED HOTEL DETAILS");
        labelHeading.setBounds(150,20,350,25);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelHeading);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(30,60,150,25);
        add(labelUsername);

        JLabel labelUsername1 = new JLabel();
        labelUsername1.setBounds(220,60,150,25);
        add(labelUsername1);

        JLabel labelHotelName = new JLabel("Hotel Name: ");
        labelHotelName.setBounds(30,120,150,25);
        add(labelHotelName);

        JLabel labelHotelName1 = new JLabel();
        labelHotelName1.setBounds(220,120,150,25);
        add(labelHotelName1);

        JLabel labelTotalPersons = new JLabel("Total Persons: ");
        labelTotalPersons.setBounds(30,180,150,25);
        add(labelTotalPersons);

        JLabel labelTotalPersons1 = new JLabel();
        labelTotalPersons1.setBounds(220,180,150,25);
        add(labelTotalPersons1);

        JLabel labelTotalDays = new JLabel("Total Days: ");
        labelTotalDays.setBounds(30,240,150,25);
        add(labelTotalDays);

        JLabel labelTotalDays1 = new JLabel();
        labelTotalDays1.setBounds(220,240,150,25);
        add(labelTotalDays1);

        JLabel labelTypeOfRoom = new JLabel("AC/Non-AC: ");
        labelTypeOfRoom.setBounds(30,300,150,25);
        add(labelTypeOfRoom);

        JLabel labelTypeOfRoom1 = new JLabel();
        labelTypeOfRoom1.setBounds(220,300,150,25);
        add(labelTypeOfRoom1);

        JLabel labelFoodIncluded = new JLabel("Food Included? ");
        labelFoodIncluded.setBounds(30,360,150,25);
        add(labelFoodIncluded);

        JLabel labelFoodIncluded1 = new JLabel();
        labelFoodIncluded1.setBounds(220,360,150,25);
        add(labelFoodIncluded1);

        JLabel labelId = new JLabel("Id : ");
        labelId.setBounds(30,420,150,25);
        add(labelId);

        JLabel labelId1 = new JLabel();
        labelId1.setBounds(220,420,150,25);
        add(labelId1);

        JLabel labelIdNumber = new JLabel("Id Number: ");
        labelIdNumber.setBounds(30,480,150,25);
        add(labelIdNumber);

        JLabel labelIdNumber1 = new JLabel();
        labelIdNumber1.setBounds(220,480,150,25);
        add(labelIdNumber1);

        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(30,540,150,25);
        add(labelPhone);

        JLabel labelPhone1 = new JLabel();
        labelPhone1.setBounds(220,540,150,25);
        add(labelPhone1);

        JLabel labelTotalPrice = new JLabel("Total Price: ");
        labelTotalPrice.setBounds(30,600,150,25);
        add(labelTotalPrice);

        JLabel labelTotalPrice1 = new JLabel();
        labelTotalPrice1.setBounds(220,600,150,25);
        add(labelTotalPrice1);

        back = new JButton("Back");
        back.setBounds(150,660,150,25);
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
        image.setBounds(320,100,650,500);
        add(image);



        try
        {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from bookedhotel where username = '"+ username + "'");
            while(rs.next())
            {
                labelUsername1.setText(rs.getString("username"));
                labelHotelName1.setText(rs.getString("hotelname"));
                labelTotalPersons1.setText(rs.getString("persons"));
                labelTotalDays1.setText(rs.getString("noofdays"));
                labelTypeOfRoom1.setText(rs.getString("roomtype"));
                labelFoodIncluded1.setText(rs.getString("includefood"));
                labelId1.setText(rs.getString("id"));
                labelIdNumber1.setText(rs.getString("idnumber"));
                labelPhone1.setText(rs.getString("phone"));
                labelTotalPrice1.setText(rs.getString("price"));

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
        new ViewBookedHotel("apacheboy");
    }
}
