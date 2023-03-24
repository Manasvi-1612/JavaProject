package QUIZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    JButton exit,pa;

    Score(String username,int score){
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/i3.png"));
        Image image = i1.getImage();
        Image newimg = image.getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        i1 = new ImageIcon(newimg);
        JLabel img = new JLabel(i1);
        img.setBounds(0, 200, 300, 250);
        add(img);

        JLabel heading = new JLabel("ThankYou "+username+" for playing Smarty Pints");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel s = new JLabel("Your score is: "+score);
        s.setBounds(350, 200, 300, 30);
        s.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(s);
        

        pa=new JButton("Play Again");
        pa.setBounds(350, 280, 120, 30);
        pa.setFont(new Font("Tahoma", Font.BOLD, 16));
        pa.setBackground(Color.darkGray);
        pa.setForeground(Color.WHITE);
        pa.addActionListener(this);
        add(pa);
        
        exit=new JButton("Exit");
        exit.setBounds(550, 280, 120, 30);
        exit.setFont(new Font("Tahoma", Font.BOLD, 16));
        exit.setBackground(Color.darkGray);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        if(e.getSource()==pa){
            new Login();
        }
        
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
    
}
