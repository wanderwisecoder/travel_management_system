package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton delete,back;
    String username;

    DeleteDetails(String username)
    {
        this.username=username;

        setBounds(450,180,870,740);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(30,60,150,25);
        add(labelUsername);

        JLabel labelUsername1 = new JLabel();
        labelUsername1.setBounds(220,60,150,25);
        add(labelUsername1);

        JLabel labelId = new JLabel("Id: ");
        labelId.setBounds(30,120,150,25);
        add(labelId);

        JLabel labelId1 = new JLabel();
        labelId1.setBounds(220,120,150,25);
        add(labelId1);

        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(30,180,150,25);
        add(labelNumber);

        JLabel labelNumber1 = new JLabel();
        labelNumber1.setBounds(220,180,150,25);
        add(labelNumber1);

        JLabel labelName = new JLabel("Name: ");
        labelName.setBounds(30,240,150,25);
        add(labelName);

        JLabel labelName1 = new JLabel();
        labelName1.setBounds(220,240,150,25);
        add(labelName1);

        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(30,300,150,25);
        add(labelGender);

        JLabel labelGender1 = new JLabel();
        labelGender1.setBounds(220,300,150,25);
        add(labelGender1);

        JLabel labelCountry = new JLabel("Country: ");
        labelCountry.setBounds(500,60,150,25);
        add(labelCountry);

        JLabel labelCountry1 = new JLabel();
        labelCountry1.setBounds(690,60,150,25);
        add(labelCountry1);

        JLabel labelAddress = new JLabel("Address: ");
        labelAddress.setBounds(500,120,150,25);
        add(labelAddress);

        JLabel labelAddress1 = new JLabel();
        labelAddress1.setBounds(690,120,150,25);
        add(labelAddress1);

        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(500,180,150,25);
        add(labelPhone);

        JLabel labelPhone1 = new JLabel();
        labelPhone1.setBounds(690,180,150,25);
        add(labelPhone1);

        JLabel labelEmail = new JLabel("Email Id: ");
        labelEmail.setBounds(500,240,150,25);
        add(labelEmail);

        JLabel labelEmail1 = new JLabel();
        labelEmail1.setBounds(690,240,150,25);
        add(labelEmail1);

        delete = new JButton("Delete");
        delete.setBounds(350,400,150,25);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBorder(new LineBorder(new Color(133,193,233)));
        delete.setOpaque(true);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(626,210,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10,475,600,200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626,210,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(615,475,600,200);
        add(image2);

        try
        {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from customerDetails where username = '"+ username + "'");
            while(rs.next())
            {
                labelUsername1.setText(rs.getString("username"));
                labelId1.setText(rs.getString("id"));
                labelNumber1.setText(rs.getString("number"));
                labelName1.setText(rs.getString("name"));
                labelGender1.setText(rs.getString("gender"));
                labelCountry1.setText(rs.getString("country"));
                labelAddress1.setText(rs.getString("address"));
                labelPhone1.setText(rs.getString("phone"));
                labelEmail1.setText(rs.getString("email"));

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
        if(e.getSource() == delete)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("delete from bookedhotel where username = '" +username+"'");
                c.s.executeUpdate("delete from bookedpackages where username = '" +username+"'");
               // c.s.executeUpdate("delete from customerDetails where username = '" +username+"'");
                c.s.executeUpdate("delete from hotels where username = '" +username+"'");
                c.s.executeUpdate("delete from trvelsystemaccount where username = '" +username+"'");

                JOptionPane.showMessageDialog(null, "Your Data has been Deleted Successfully.");
                System.exit(0);
            }
            catch (Exception e1)
            {
                System.out.println(e1);
            }
        }

    }

    public static void main(String []args)
    {
        new DeleteDetails("apacheboy");
    }
}
