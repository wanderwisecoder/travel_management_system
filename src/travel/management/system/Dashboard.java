package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton addPersonalDetails, updatePersonalDetails,viewPersonalDetails,deletePersonalDetails, checkPackages,bookPackage,viewPackage,viewHotels,bookHotel,viewBookedHotel,destinations,payments,notepad,calculator,about,quit,logOut;
    String username;

    Dashboard(String username){
        //setBounds(0,0,1710,1070);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        this.username=username;

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1710,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading =new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,1020);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setBorder(new LineBorder(new Color(133,193,233)));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.setBorder(new LineBorder(new Color(133,193,233)));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.setBorder(new LineBorder(new Color(133,193,233)));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.setBorder(new LineBorder(new Color(133,193,233)));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,110));
        checkPackages.setBorder(new LineBorder(new Color(133,193,233)));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage = new JButton("Booked Package");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.setBorder(new LineBorder(new Color(133,193,233)));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.setBorder(new LineBorder(new Color(133,193,233)));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,120));
        viewHotels.setBorder(new LineBorder(new Color(133,193,233)));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotels");
        bookHotel.setBounds(0,400,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,140));
        bookHotel.setBorder(new LineBorder(new Color(133,193,233)));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,450,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,140));
        viewBookedHotel.setBorder(new LineBorder(new Color(133,193,233)));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,140));
        destinations.setBorder(new LineBorder(new Color(133,193,233)));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,140));
        payments.setBorder(new LineBorder(new Color(133,193,233)));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,145));
        calculator.setBorder(new LineBorder(new Color(133,193,233)));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));
        notepad.setBorder(new LineBorder(new Color(133,193,233)));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        about.setBorder(new LineBorder(new Color(133,193,233)));
        about.addActionListener(this);
        p2.add(about);

        logOut = new JButton("Log-Out");
        logOut.setBounds(0,750,300,50);
        logOut.setBackground(new Color(0,0,102));
        logOut.setForeground(Color.white);
        logOut.setFont(new Font("Tahoma",Font.PLAIN,20));
        logOut.setMargin(new Insets(0,0,0,175));
        logOut.setBorder(new LineBorder(new Color(133,193,233)));
        logOut.addActionListener(this);
        p2.add(logOut);

        quit = new JButton("Quit");
        quit.setBounds(0,800,300,50);
        quit.setBackground(new Color(0,0,102));
        quit.setForeground(Color.white);
        quit.setFont(new Font("Tahoma",Font.PLAIN,20));
        quit.setMargin(new Insets(0,0,0,175));
        quit.setBorder(new LineBorder(new Color(133,193,233)));
        quit.addActionListener(this);
        p2.add(quit);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(100,50,1650,1000);
        add(icon1);

        JLabel textTitel = new JLabel("Travel and Tourism Management System");
        textTitel.setBounds(400,50,1200,70);
        textTitel.setForeground(Color.white);
        textTitel.setFont(new Font("Raleway",Font.BOLD,50));
        icon1.add(textTitel);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource() == addPersonalDetails )
        {
            setVisible(false);
            new AddCustomer(username);
        }
        else if (e.getSource() == viewPersonalDetails)
        {
            setVisible(false);
            new ViewCustomerDetails(username);
        }
        else if (e.getSource() == logOut)
        {
            setVisible(false);
            new Login();
        }
        else if (e.getSource() == quit) {
            setVisible(false);
        }
        else if (e.getSource() == checkPackages)
        {
            //setVisible(false);
            new CheckPackage();
        }
        else if (e.getSource() == viewPackage)
        {
            //setVisible(false);
            new ViewPackage(username);
        }else if (e.getSource() == viewHotels)
        {
            //setVisible(false);
            new CheckHotels();
        }
        else if (e.getSource() == updatePersonalDetails)
        {
            //setVisible(false);
            new UpdateCustomer(username);
        }
        else if (e.getSource() == bookPackage)
        {
            //setVisible(false);
            new UpdateCustomer(username);
        }
        else if (e.getSource() == destinations)
        {
            //setVisible(false);
            new Destinations();
        }
        else if (e.getSource() == bookHotel)
        {
         new BookHotel(username);
        }
        else if ( e.getSource() == viewBookedHotel )
        {
            new ViewBookedHotel(username);
        }
        else if ( e.getSource() == payments )
        {
            new Payments(username);
        }
        else if ( e.getSource() == calculator )
        {
            try
            {
                Runtime.getRuntime().exec("open -a Calculator");
            }
            catch (Exception e1)
            {
                System.out.println(e1);
            }

        }
        else if ( e.getSource() == notepad )
        {
            try
            {
                Runtime.getRuntime().exec("open /System/Applications/notes.app");
            }
            catch (Exception e1)
            {
                System.out.println(e1);
            }
        }
        else if ( e.getSource() == about)
        {
            new About();
        }
        else if ( e.getSource() == deletePersonalDetails )
        {
            new DeleteDetails(username);
        }


    }

    public static void main(String [] args){
        new Dashboard("");

    }
}
