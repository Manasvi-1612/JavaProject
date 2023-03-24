package QUIZ;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

public class SJGK extends JPanel implements ActionListener{ 
    public JLabel userLabel;
    public JLabel passLabel;
    public JTextField userField;
    public JTextField passField;
    public JButton login;
    public JButton closeLogin;
    public JButton help;
    
    public SJGK(){
        userLabel = new JLabel("Username: ");
        passLabel = new JLabel("Password: ");
        userField = new JTextField(16);
        passField = new JTextField(16);
    
        login = new JButton("Login");
        login.setActionCommand("login");
        login.setMnemonic(KeyEvent.VK_L);
        closeLogin = new JButton("Close");
        closeLogin.setActionCommand("closeLogin");
        closeLogin.setMnemonic(KeyEvent.VK_E);
        help = new JButton("Help");
        help.setActionCommand("helpLogin");
        help.setMnemonic(KeyEvent.VK_H);
    
        login.addActionListener(this);
        closeLogin.addActionListener(this);
        help.addActionListener(this);

        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/i1.jpg"));
        JLabel img=new JLabel(i1);
        img.setBounds(0, 0, 550, 600);
        add(img);
    
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(login);
        add(help);
        add(closeLogin);
    
    }
    public void actionPerformed(ActionEvent e){ 
    }
    public static void initComponents(){
        JFrame loginFrame = new JFrame("Encrypted Chat - Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SJGK loginPanel = new SJGK();
        loginPanel.setLayout(new FlowLayout());
        loginFrame.setSize(900, 700);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);        
    }
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                initComponents();
            }
        });
    }
}