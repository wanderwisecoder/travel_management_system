package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payments extends JFrame implements ActionListener {

    JButton pay, back;
    String username;

    Payments( String username )
    {
        this.username = username;

        setBounds(500,200,805,625);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);

        pay = new JButton("Pay Now");
        pay.setBounds(420,0,80,40);
        pay.setFont(new Font("Tahoma",Font.PLAIN,16));
       // pay.setMargin(new Insets(0,0,0,140));
      //  pay.setBorder(new LineBorder(new Color(133,193,233)));
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(520,0,80,40);
      //  back.setBackground(new Color(0,0,102));
        //back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
       // back.setMargin(new Insets(0,0,0,140));
       // back.setBorder(new LineBorder(new Color(133,193,233)));
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == pay)
        {
            setVisible(false);
            new Paytm();

        } else if ( e.getSource() == back )
        {
            setVisible(false);
            new Dashboard("");

        }

    }

    public static void main(String []args)
    {
     new Payments("");
    }


}
