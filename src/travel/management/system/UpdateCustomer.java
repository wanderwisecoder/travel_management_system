package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelUsername1,labelName1,labelEmail1;
    JComboBox comboId;
    JTextField textFieldNumber,textFieldCountry,textFieldAddress,textFieldPhone,textFieldEmail,textFieldId,textFieldGender;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JButton update, back;
    String username;

    UpdateCustomer( String username)
    {
        this.username = username;
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel labelHeading = new JLabel("UPDATE CUSTOMER DETAILS");
        labelHeading.setBounds(270,5,300,25);
        labelHeading.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelHeading);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(30,50,150,25);
        add(labelUsername);

        labelUsername1 = new JLabel();
        labelUsername1.setBounds(220,50,150,25);
        add(labelUsername1);

        JLabel labelId = new JLabel("Id:");
        labelId.setBounds(30,90,150,25);
        add(labelId);

        textFieldId =new JTextField();
        textFieldId.setBounds(220,90,150,25);
        add(textFieldId);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(30,130,150,25);
        add(labelNumber);

        textFieldNumber =new JTextField();
        textFieldNumber.setBounds(220,130,150,25);
        add(textFieldNumber);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(30,170,150,25);
        add(labelName);

        labelName1 = new JLabel();
        labelName1.setBounds(220,170,150,25);
        add(labelName1);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(30,210,150,25);
        add(labelGender);

        textFieldGender =new JTextField();
        textFieldGender.setBounds(220,210,150,25);
        add(textFieldGender);

        JLabel labelCountry = new JLabel("Country:");
        labelCountry.setBounds(30,250,150,25);
        add(labelCountry);

        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(220,250,150,25);
        add(textFieldCountry);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(30,290,150,25);
        add(labelAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(220,290,150,25);
        add(textFieldAddress);

        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(30,330,150,25);
        add(labelPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(220,330,150,25);
        add(textFieldPhone);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30,370,150,25);
        add(labelEmail);

        textFieldEmail =new JTextField();
        textFieldEmail.setBounds(220,370,150,25);
        add(textFieldEmail);

        update = new JButton("Update");
        update.setBounds(70,430,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBorder(new LineBorder(new Color(133,193,233)));
        update.setOpaque(true);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(230,430,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);

        try
        {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from customerDetails where username = '"+ username + "'");
            while(rs.next())
            {
                labelUsername1.setText(rs.getString("username"));
                textFieldId.setText(rs.getString("id"));
                textFieldNumber.setText(rs.getString("number"));
                labelName1.setText(rs.getString("name"));
                textFieldGender.setText(rs.getString("gender"));
                textFieldCountry.setText(rs.getString("country"));
                textFieldAddress.setText(rs.getString("address"));
                textFieldPhone.setText(rs.getString("phone"));
                textFieldEmail.setText(rs.getString("email"));

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
        else if(e.getSource() == update)
        {
            Conn c1 = new Conn();
            String username = labelUsername1.getText();
            String id = textFieldId.getText();
            String number = textFieldNumber.getText();
            String name = labelName1.getText();
            String gender = textFieldGender.getText();
            String country = textFieldCountry.getText();
            String address = textFieldAddress.getText();
            String phone = textFieldPhone.getText();
            String email = textFieldEmail.getText();


            if(username.equals("") || id.equals("") || number.equals("") || name.equals("") || gender.equals("") || country.equals("") || address.equals("") || phone.equals("") || email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter all the required fields.");
                return;
            } else if (phone.length() < 10) {
                JOptionPane.showMessageDialog(null, "Please enter 10 digit phone number.");
                return;
            } else {

                String query = "update customerDetails set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender ='" + gender + "', country ='" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "'";

                try {
                    c1.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Your Details has been Updated Successfully.!");
                    setVisible(false);
                    new Login();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println(e1);
                }
            }

            setVisible(false);
            new Dashboard(username);
        }

    }

    public static void main(String []args)
    {
        new UpdateCustomer("");
    }
}
