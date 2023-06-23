package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, forgetPassword, signUp;
    JTextField textUsername, textPassword;
    Login(){
        setSize(900,400);
        setLocation(400,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 =new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(90,90,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(60,20,100,25);
        labelUsername.setFont(new Font("SYSTEM",Font.PLAIN,16));
        p2.add(labelUsername);

        textUsername = new JTextField();
        textUsername.setBounds(60,60,300,30);
        textUsername.setFont(new Font("SAN SERIE",Font.PLAIN,16));
        textUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(textUsername);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(60,100,100,25);
        labelPassword.setFont(new Font("SYSTEM",Font.PLAIN,16));
        p2.add(labelPassword);

        textPassword = new JTextField();
        textPassword.setBounds(60,140,300,30);
        textPassword.setFont(new Font("SAN SERIE",Font.PLAIN,16));
        textPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(textPassword);

        login = new JButton("Login");
        login.setBounds(60,190,130,40);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setOpaque(true);
        login.addActionListener(this);
        p2.add(login);

        signUp = new JButton("Sign-Up");
        signUp.setBounds(230,190,130,40);
        signUp.setBackground(new Color(133,193,233));
        signUp.setForeground(Color.WHITE);
        signUp.setBorder(new LineBorder(new Color(133,193,233)));
        signUp.setOpaque(true);
        signUp.addActionListener(this);
        p2.add(signUp);

        forgetPassword = new JButton("Forget Password");
        forgetPassword.setBounds(145,240,130,40);
        forgetPassword.setBackground(new Color(133,193,233));
        forgetPassword.setForeground(Color.WHITE);
        forgetPassword.setBorder(new LineBorder(new Color(133,193,233)));
        forgetPassword.setOpaque(true);
        forgetPassword.addActionListener(this);
        p2.add(forgetPassword);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.red);
        p2.add(text);






        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String username = textUsername.getText();
        String password = textPassword.getText();

        try {
            if (e.getSource() == login)
            {
                if(username.equals("") || password.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please enter all required fields.");
                        return;
                    }
                else {
                      try
                       {
                         //String userName = textUsername.getText();
                         //String passWord = textPassword.getText();
                         String query = "select * from trvelsystemaccount where username = '" + username + "' AND password = '" + password + "'";
                         Conn c = new Conn();
                         ResultSet rs = c.s.executeQuery(query);
                         if (rs.next())
                          {
                              JOptionPane.showMessageDialog(null, "Logged In Successfully.!");

                              setVisible(false);
                            new Loading(username);
                          }
                         else
                         {
                             JOptionPane.showMessageDialog(null,"Incorrect Username Or Password. Please check again.");
                         }
                       }
                       catch (Exception e2)
                       {
                           System.out.println(e2);
                       }
                }

                } else if (e.getSource() == signUp) {
                    setVisible(false);
                    new Signup();

                } else if (e.getSource() == forgetPassword) {
                    setVisible(false);
                    new ForgetPassword();
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

    }


        public static void main(String args [])
    {
        new Login();
    }
}
