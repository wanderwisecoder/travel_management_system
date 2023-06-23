package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener
{

    JButton back;

    Paytm()
    {
        setBounds(500,200,800,600);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try
        {
            pane.setPage("http://paytm.com/rent-payment");

        }
        catch (Exception e)
        {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404. Page not Found.</html>");
            System.out.println(e);
        }
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        back = new JButton("Back");
        back.setBounds(610,20,80,40);
        //  back.setBackground(new Color(0,0,102));
        //back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        // back.setMargin(new Insets(0,0,0,140));
        // back.setBorder(new LineBorder(new Color(133,193,233)));
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payments("");

    }

    public static void main(String []args)
    {
        new Paytm();
    }



}
