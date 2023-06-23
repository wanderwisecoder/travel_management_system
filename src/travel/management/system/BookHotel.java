package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice cHotels, cTypeofRoom, cTypeoFood;
    JTextField tNoOfPersons, tNoOfDays, tTypeOfRoom;
    String username;
    JLabel labelUsername1, labelId1, labelIdNumber1,labelPhone1, labelTotalPrice1, labelNoDays;
    JButton checkPrice , bookHotel, back;

    BookHotel( String username )
    {
        this.username = username;
        setBounds(350,200,1100,725);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK Hotel");
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

        JLabel labelSelectPackage = new JLabel("Select Hotel: ");
        labelSelectPackage.setBounds(40,120,150,20);
        labelSelectPackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelSelectPackage);

        cHotels = new Choice();
        cHotels.setBounds(250,120,175,20);
        add(cHotels);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while(rs.next())
            {
                cHotels.add(rs.getString("name"));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        JLabel labelNoPerson = new JLabel("Number of Persons: ");
        labelNoPerson.setBounds(40,170,150,20);
        labelNoPerson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelNoPerson);

        tNoOfPersons = new JTextField();
        tNoOfPersons.setBounds(250,170,175,20);
        tNoOfPersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tNoOfPersons);

        JLabel labelNoDays = new JLabel("Number of Days: ");
        labelNoDays.setBounds(40,220,150,20);
        labelNoDays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelNoDays);

        tNoOfDays = new JTextField();
        tNoOfDays.setBounds(250,220,175,20);
        tNoOfDays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tNoOfDays);

        JLabel labelTypeOfRoom = new JLabel("AC/Non-AC: ");
        labelTypeOfRoom.setBounds(40,270,150,20);
        labelTypeOfRoom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTypeOfRoom);

        cTypeofRoom = new Choice();
        cTypeofRoom.add("AC");
        cTypeofRoom.add("Non-AC");
        cTypeofRoom.setBounds(250,270,175,20);
        add(cTypeofRoom);

        JLabel labelTypeOfFood = new JLabel("Food Included: ");
        labelTypeOfFood.setBounds(40,320,150,20);
        labelTypeOfFood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTypeOfFood);

        cTypeoFood = new Choice();
        cTypeoFood.add("Yes");
        cTypeoFood.add("No");
        cTypeoFood.setBounds(250,320,175,20);
        add(cTypeoFood);

        JLabel labelId = new JLabel("Id: ");
        labelId.setBounds(40,370,100,20);
        labelId.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelId);

        labelId1 = new JLabel();
        labelId1.setBounds(250,370,175,20);
        labelId1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelId1);

        JLabel labelIdNumber = new JLabel("Id Number: ");
        labelIdNumber.setBounds(40,420,100,20);
        labelIdNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelIdNumber);

        labelIdNumber1 = new JLabel();
        labelIdNumber1.setBounds(250,420,175,20);
        labelIdNumber1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelIdNumber1);

        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(40,470,100,20);
        labelPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelPhone);

        labelPhone1 = new JLabel();
        labelPhone1.setBounds(250,470,175,20);
        labelPhone1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelPhone1);

        JLabel labelTotalPrice = new JLabel("Total Price: ");
        labelTotalPrice.setBounds(40,520,100,20);
        labelTotalPrice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTotalPrice);

        labelTotalPrice1 = new JLabel();
        labelTotalPrice1.setBounds(250,520,175,20);
        labelTotalPrice1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelTotalPrice1);

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(40,570,130,40);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBorder(new LineBorder(new Color(133,193,233)));
        checkPrice.setOpaque(true);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(240,570,130,40);
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.white);
        bookHotel.setBorder(new LineBorder(new Color(133,193,233)));
        bookHotel.setOpaque(true);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBounds(140,620,130,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,375,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,40,900,600);
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
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotels where name = '" + cHotels.getSelectedItem() + "'");

                while (rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int acroom = Integer.parseInt(rs.getString("room"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));

                    int persons = Integer.parseInt(tNoOfPersons.getText());
                    int days = Integer.parseInt(tNoOfDays.getText());

                    String acSelected = cTypeofRoom.getSelectedItem();
                    String foodSelected = cTypeoFood.getSelectedItem();

                    if( persons * days > 0 )
                    {
                        int total = 0;
                        total += acSelected.equals("AC") ? acroom :  0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelTotalPrice1.setText( "Rs. " + total + "/-" ) ;

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number.");
                    }

                }
                /*String cpackage = cHotels.getSelectedItem();
                int cost = 0;
                int paxs = Integer.parseInt(tNoOfPersons.getText());
                if (cpackage.equals("Gold Package")) {
                    cost += 52000;

                } else if (cpackage.equals("Silver Package")) {
                    cost += 42000;

                } else if (cpackage.equals("Bronze Package")) {
                    cost += 32000;
                }
                cost *= paxs;
                labelTotalPrice1.setText("Rs. " + cost);*/
            }
            catch (Exception e1)
            {
                System.out.println(e1);
            }

        }
            else if (e.getSource() == bookHotel)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookedhotel values ('"+ labelUsername1.getText() +"', '" + cHotels.getSelectedItem() + "', '" + tNoOfPersons.getText() + "', '" + tNoOfDays.getText() + "', '" + cTypeofRoom.getSelectedItem() + "', '" + cTypeoFood.getSelectedItem() +" ', ' " + labelId1.getText() + "', '" + labelIdNumber1.getText() + "', '" + labelPhone1.getText()+ "', '" + labelTotalPrice1.getText() +"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                /*setVisible(false);
                new Dashboard(username);*/
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
        new BookHotel("");
    }
}
