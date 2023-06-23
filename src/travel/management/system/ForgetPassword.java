package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JButton search, back,retrieve ;
    JTextField textUsername, textName,textQuestion,textEmailId, textAnswer, passwordField;
    ForgetPassword()
    {
        setBounds(425,200,900,390);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(610,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,300);
        add(p1);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        labelUsername.setBounds(50,20,125,25);
        p1.add(labelUsername);

        textUsername = new JTextField();
        textUsername.setBounds(190,20,180,25);
        textUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textUsername);

        search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBorder(new LineBorder(new Color(133,193,233)));
        search.setOpaque(true);
        search.addActionListener(this);
        p1.add(search);

        JLabel labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName.setBounds(50,60,125,25);
        p1.add(labelName);

        textName = new JTextField();
        textName.setBounds(190,60,180,25);
        textName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textName);

        JLabel labelEmailId = new JLabel("Your Email-Id: ");
        labelEmailId.setFont(new Font("Tahoma",Font.BOLD,14));
        labelEmailId.setBounds(50,100,125,25);
        p1.add(labelEmailId);

        textEmailId = new JTextField();
        textEmailId.setBounds(190,100,180,25);
        textEmailId.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textEmailId);

        JLabel labelSecurity = new JLabel("Security Question:");
        labelSecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        labelSecurity.setBounds(50,140,130,25);
        p1.add(labelSecurity);

        textQuestion = new JTextField();
        textQuestion.setBounds(190,140,180,25);
        textQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textQuestion);

        JLabel labelAnswer = new JLabel("Answer: ");
        labelAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        labelAnswer.setBounds(50,180,125,25);
        p1.add(labelAnswer);

        textAnswer = new JTextField();
        textAnswer.setBounds(190,180,180,25);
        textAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textAnswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380,180,100,25);
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBorder(new LineBorder(new Color(133,193,233)));
        retrieve.setOpaque(true);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setFont(new Font("Tahoma",Font.BOLD,14));
        labelPassword.setBounds(50,220,125,25);
        p1.add(labelPassword);

        passwordField = new JTextField();
        passwordField.setBounds(190,220,180,25);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordField);


        back = new JButton("Back");
        back.setBounds(190,260,100,25);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setOpaque(true);
        back.addActionListener(this);
        p1.add(back);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = textUsername.getText();

        Conn c = new Conn();

        if(e.getSource() == back)
         {
            setVisible(false);
            new Login();
         }
        else if ( e.getSource() == search) {
            try{
                String query = "select * from trvelsystemaccount where username = '"+username+"'";
                ResultSet rs=  c.s.executeQuery(query);

                while(rs.next())
                {
                    textName.setText(rs.getString("name"));
                    textEmailId.setText(rs.getString("email"));
                    textQuestion.setText(rs.getString("securityQ"));
                }
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }

        }
        else if ( e.getSource() == retrieve)
        {
            try {
                String query1 = "select * from trvelsystemaccount where answer = '"+textAnswer.getText()+"' AND username = '"+username+"'";

                ResultSet rs = c.s.executeQuery(query1);


                while(rs.next()) {

                        passwordField.setText(rs.getString("password"));
                    }


            }
            catch (Exception e2)
            {
                JOptionPane.showMessageDialog(null,"Wrong Answer Input. Try Again.");
                System.out.println(e2);
                e2.printStackTrace();
                return;
            }

        }

    }


    public static void main(String []args)
    {
        new ForgetPassword();
    }

}
