package QUIZ;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{


    JButton rules,exit;
    JTextField tfname;
    /**
     * 
     */
    Login(){

        
       
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/i1.jpg"));
        JLabel img=new JLabel(i1);
        img.setBounds(0, 0, 550, 600);
        add(img);

        // ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/i1.jpg")); // load the image to a imageIcon
        // Image image = imageIcon.getImage(); // transform it 
        // Image newimg = image.getScaledInstance(550, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        // imageIcon = new ImageIcon(newimg);
        // JLabel img=new JLabel(imageIcon);
        // img.setBounds(0, 0, 550, 600);
        // add(img);
        
        
        
        
        
        JLabel heading=new JLabel("Smarty Pints");
        heading.setBounds(700,40,300,100);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,43));
        heading.setForeground(new Color(150,50,100));
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(700,100,300,100);
        name.setFont(new Font("Monglian Baiti",Font.BOLD,20));
        name.setForeground(new Color(150,50,100));
        add(name);


        tfname=new JTextField(null);
        tfname.setBounds(700,170, 500, 40);
        tfname.setFont(new Font("Monglian Baiti",Font.BOLD,18));
        add(tfname);

        rules=new JButton("Rules");
        rules.setBounds(700, 280, 200, 40);
        rules.setBackground(new Color(150,50,100));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);


        exit=new JButton("Exit");
        exit.setBounds(1000, 280, 200, 40);
        exit.setBackground(new Color(150,50,100));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
          
        setSize(1250,600);
        setLocation(150, 150);
      
       
        setVisible(true);


    }
    
   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rules){
            String name=tfname.getText();

            setVisible(false);
            new Rules(name);
        }else if(e.getSource()==exit){
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }

}
