package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField textUsername, textName,textAnswer,textEmailId;
    JPasswordField passwordField;
    Choice securityQuestions;



    Signup(){

        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        labelUsername.setBounds(50,20,125,25);
        p1.add(labelUsername);

        textUsername = new JTextField();
        textUsername.setBounds(190,20,180,25);
        textUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textUsername);

        JLabel labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName.setBounds(50,60,125,25);
        p1.add(labelName);

        textName = new JTextField();
        textName.setBounds(190,60,180,25);
        textName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textName);

        JLabel labelEmailId = new JLabel("Enter Email-Id: ");
        labelEmailId.setFont(new Font("Tahoma",Font.BOLD,14));
        labelEmailId.setBounds(50,100,125,25);
        p1.add(labelEmailId);

        textEmailId = new JTextField();
        textEmailId.setBounds(190,100,180,25);
        textEmailId.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textEmailId);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setFont(new Font("Tahoma",Font.BOLD,14));
        labelPassword.setBounds(50,140,125,25);
        p1.add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(190,140,180,25);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordField);

        JLabel labelSecurity = new JLabel("Security Question:");
        labelSecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        labelSecurity.setBounds(50,180,130,25);
        p1.add(labelSecurity);

        securityQuestions = new Choice();
        securityQuestions.add("Favourite Anime");
        securityQuestions.add("Fav Anime Character");
        securityQuestions.add("Favorite Destination");
        securityQuestions.add("Your first cell phone");
        securityQuestions.add("Your birth location");
        securityQuestions.add("Your lucky number");
        securityQuestions.setBounds(185,180,190,25);
        p1.add(securityQuestions);

        JLabel labelAnswer = new JLabel("Answer: ");
        labelAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        labelAnswer.setBounds(50,220,125,25);
        p1.add(labelAnswer);

        textAnswer = new JTextField();
        textAnswer.setBounds(190,220,180,25);
        textAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textAnswer);

        create = new JButton("Create");
        create.setBounds(50,270,130,40);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setBorder(new LineBorder(new Color(133,193,233)));
        create.setOpaque(true);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(240,270,130,40);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,200,250);
        add(image);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           Conn c = new Conn();
           if(e.getSource() == create)
           {
               String username = textUsername.getText();
               String name = textName.getText();
               String email = textEmailId.getText();
               String password = passwordField.getText();
               String securityQuestion = securityQuestions.getSelectedItem();
               String answer = textAnswer.getText();
               String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
               String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[.com,.in]+$";
               boolean emailValidation = email.matches(regex);


               if(username.equals("") || name.equals("") || password.equals("") || securityQuestion.equals("") || answer.equals("") || email.equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Please enter all the required fields.");
                   return;
               } else if (name.length() < 3) {
                   JOptionPane.showMessageDialog(null, "Please enter your full name");
                   return;
               }else if (!emailValidation) {
                   JOptionPane.showMessageDialog(null, "Given email-id is not valid.");
                   return;
                   
               } else if(!password.matches(passwordPattern)) {
                   JOptionPane.showMessageDialog(null, "Password is weak");
                   return;
               }
               else {

                   String query = "insert into trvelsystemaccount values('" + username + "','" + name + "', '" + email + "', '" + password + "', '" + securityQuestion + "', '"+answer+"');";

                   try {
                       c.s.executeUpdate(query);

                       JOptionPane.showMessageDialog(null, "Account Created Successfully.!");
                       setVisible(false);
                       new Login();
                   } catch (Exception e1) {
                       e1.printStackTrace();
                       System.out.println(e1);
                   }
               }
           }
           else if(e.getSource() == back)
           {
               setVisible(false);
               new Login();
           }
       }
       catch (Exception ae)
       {
           ae.printStackTrace();
           System.out.println(ae);
       }
    }

    public static void main(String []args)
    {
        new Signup();
    }

    
}
