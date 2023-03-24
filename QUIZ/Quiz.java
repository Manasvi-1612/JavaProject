package QUIZ;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] userans = new String[10][1];

    JButton[] btn;

    JLabel q, qno;
    JRadioButton[] opt;
    ButtonGroup group;

    public static int timer = 15;
    public static int ans = 0;
    public static int count = 0;
    public static int score = 0;
    

    String username;
    Quiz(String username) {

        this.username=username;
        setBounds(10, 0, 1510, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/i2.jpg"));
        Image image = i1.getImage();
        Image newimg = image.getScaledInstance(1500, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        i1 = new ImageIcon(newimg);
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1500, 400);
        add(img);

        qno = new JLabel("1");
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        q = new JLabel("1");
        q.setBounds(150, 450, 900, 30);
        q.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(q);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt = new JRadioButton[4];

        int y = 520;
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            opt[i] = new JRadioButton("Option" + (i + 1));
            opt[i].setBounds(170, y, 700, 30);
            opt[i].setBackground(Color.WHITE);
            opt[i].setFont(new Font("Dialog", Font.PLAIN, 20));
            y += 40;
            add(opt[i]);
            group.add(opt[i]);
        }

        String[] str = { "Next", "50-50 LifeLine", "Submit" };
        btn = new JButton[3];
        int x = 530;
        for (int i = 0; i < str.length; i++) {
            btn[i] = new JButton(str[i]);
            btn[i].setBounds(1100, x, 200, 40);
            btn[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            btn[i].setBackground(Color.darkGray);
            btn[i].setForeground(Color.WHITE);
            btn[i].addActionListener(this);
            add(btn[i]);
            x += 80;
        }
        btn[2].setEnabled(false);

        start(count);

        setVisible(true);
    }

    public void start(int c) {
        qno.setText("" + (c + 1) + ". ");
        q.setText(questions[c][0]);
        for (int i = 0; i < 4; i++) {
            opt[i].setText(questions[c][i + 1]);
            opt[i].setActionCommand(questions[c][i + 1]);
        }

        group.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn[0]) {
            repaint();
            for (int i = 0; i < 4; i++)
                opt[i].setEnabled(true);
            ans = 1;

            if (group.getSelection() == null) { // if answer is not selected when is time up
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            if (count == 8) {
                btn[0].setEnabled(false);
                btn[2].setEnabled(true);
            }
            start(++count);

        } else if (e.getSource() == btn[1]) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt[1].setEnabled(false);
                opt[2].setEnabled(false);
            } else {
                opt[1].setEnabled(false);
                opt[3].setEnabled(false);
            }

            btn[1].setEnabled(false);

        } else {
            if (group.getSelection() == null) { // if answer is not selected when is time up
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            for (int i = 0; i < userans.length; i++) {
                if (userans[i][0] == answers[i][1])
                    score += 10;
            }

            setVisible(false);
            new Score(username,score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left -" + timer + " seconds";
        g.setColor(Color.RED);

        g.setFont(new Font("Tahoma", Font.BOLD, 19));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans == 1) { // answer is selected
            ans = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;

            for (int i = 0; i < 4; i++)
                opt[i].setEnabled(true);

            if (count == 8) {
                btn[0].setEnabled(false);
                btn[2].setEnabled(true);
            }
            if (count == 9) { // Auto submit
                if (group.getSelection() == null) { // if answer is not selected when is time up
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }

                for (int i = 0; i < userans.length; i++) {
                    if (userans[i][0].equals(answers[i][1]))
                        score += 10;
                }

                setVisible(false);
                new Score(username,score);
                            
            } else {
                if (group.getSelection() == null) { // if answer is not selected when is time up
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }

}
