package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice cPackage;
    JTextField tNoOfPersons;
    String username;
    JLabel labelUsername1, labelId1, labelIdNumber1,labelPhone1, labelTotalPrice1;
    JButton checkPrice , bookPackage, back;

    BookPackage( String username )
    {
        this.username = username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);


        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(40,70,100,20);
        labelUsername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelUsername);

        labelUsername1 = new JLabel();
        labelUsername1.setBounds(250,70,100,20);
        labelUsername1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelUsername1);

        JLabel labelSelectPackage = new JLabel("Select Package: ");
        labelSelectPackage.setBounds(40,120,150,20);
        labelSelectPackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelSelectPackage);

        cPackage = new Choice();
        cPackage.add("Gold Package");
        cPackage.add("Silver Package");
        cPackage.add("Bronze Package");
        cPackage.setBounds(250,120,150,20);
        add(cPackage);

        JLabel labelNumber = new JLabel("Number of Persons: ");
        labelNumber.setBounds(40,170,150,20);
        labelNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelNumber);

        tNoOfPersons = new JTextField();
        tNoOfPersons.setBounds(250,170,100,20);
        tNoOfPersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tNoOfPersons);

        JLabel labelId = new JLabel("Id: ");
        labelId.setBounds(40,220,100,20);
        labelId.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelId);

        labelId1 = new JLabel();
        labelId1.setBounds(250,220,150,20);
        labelId1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelId1);

        JLabel labelIdNumber = new JLabel("Id Number: ");
        labelIdNumber.setBounds(40,270,100,20);
        labelIdNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelIdNumber);

        labelIdNumber1 = new JLabel();
        labelIdNumber1.setBounds(250,270,100,20);
        labelIdNumber1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelIdNumber1);

        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(40,320,100,20);
        labelPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelPhone);

        labelPhone1 = new JLabel();
        labelPhone1.setBounds(250,320,100,20);
        labelPhone1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelPhone1);

        JLabel labelTotalPrice = new JLabel("Total Price: ");
        labelTotalPrice.setBounds(40,370,100,20);
        labelTotalPrice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTotalPrice);

        labelTotalPrice1 = new JLabel();
        labelTotalPrice1.setBounds(250,370,100,20);
        labelTotalPrice1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTotalPrice1);

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(40,420,130,40);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBorder(new LineBorder(new Color(133,193,233)));
        checkPrice.setOpaque(true);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(240,420,130,40);
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.white);
        bookPackage.setBorder(new LineBorder(new Color(133,193,233)));
        bookPackage.setOpaque(true);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBounds(140,470,130,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,600,400);
        add(image);

        try
        {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from customerDetails where username = '"+ username + "'");
            while(rs.next())
            {
                labelUsername1.setText(rs.getString("username"));
                labelId1.setText(rs.getString("id"));
                labelIdNumber1.setText(rs.getString("number"));
                labelPhone1.setText(rs.getString("phone"));

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
        if(e.getSource() == checkPrice)
        {
            String cpackage = cPackage.getSelectedItem();
            int cost = 0;
            int paxs = Integer.parseInt(tNoOfPersons.getText());
            if( cpackage.equals("Gold Package"))
            {
                cost += 52000;

            }else if( cpackage.equals("Silver Package"))
            {
                cost += 42000;

            } else if( cpackage.equals("Bronze Package"))
            {
                cost += 32000;
            }
            cost *= paxs;
            labelTotalPrice1.setText("Rs. " + cost);



        } else if (e.getSource() == bookPackage)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookedpackages values ('"+ labelUsername1.getText() +"', '" + cPackage.getSelectedItem() + "', '" + tNoOfPersons.getText() + "', '" + labelId1.getText() + "', '" + labelIdNumber1.getText() + "', '" +labelPhone1.getText()+ "', '" + labelTotalPrice1.getText() +"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }


        } else if (e.getSource() == back) {

            setVisible(false);
            new Dashboard(username);

        }

    }

    public static void main(String [] args)
    {
        new BookPackage("");
    }
}
