package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Destinations extends JFrame implements Runnable
{
    Thread t1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,l11;
    JLabel [] label = new JLabel[] {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,l11};
    Destinations()
    {
        setBounds(500,200,800,600);

        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null, i6 = null, i7 = null, i8 = null, i9 = null, i10 = null, i11 = null;
        ImageIcon [] iImage = new ImageIcon[] {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11};

        Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null, j8 = null, j9 = null, j10 = null, j11 = null;
        Image [] jImage = new Image[] {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11};

        ImageIcon k1 = null, k2 = null, k3 = null, k4 = null, k5 = null, k6 = null, k7 = null, k8 = null, k9 = null, k10 = null;
        ImageIcon [] kImage = new ImageIcon[] {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11};

        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11 ;


        for(int i=0; i<=10 ; i++)
        {
            iImage[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
            jImage[i] = iImage[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kImage [i] = new ImageIcon(jImage[i]);
            label[i] = new JLabel(kImage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }
        t1 = new Thread(this);
        t1.start();

        setVisible(true);


    }
    @Override
    public void run() {
        String [] text = new String[] {"JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel", "Oberoy Hotel", "Taj Hotel", "Continental Hotel", "Raddisson Blue Hotel", "Classsio Hotel", "The Bay Club Hotel", "Breeze Blow Hotel"};
        try
        {
            for( int i=0; i<=10 ; i++)
            {
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
            setVisible(false);

        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }
    public static void main(String []args)
    {
        new Destinations();
    }


}
