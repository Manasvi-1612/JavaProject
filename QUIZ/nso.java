package QUIZ;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nso extends JFrame {

    public nso() {
        super("Dynamic Resize Example");

        // Set the layout manager to BorderLayout
        setLayout(new BorderLayout());

        // Load the image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Icons/i1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an ImageIcon from the image
        ImageIcon icon = new ImageIcon(image);

        // Create a JLabel with the ImageIcon
        JLabel label = new JLabel(icon);

        // Set the preferred, minimum, and maximum size of the JLabel
        label.setPreferredSize(new Dimension(300, 100));
        label.setMinimumSize(new Dimension(200, 50));
        label.setMaximumSize(new Dimension(600, 200));

        // Add the JLabel to the CENTER of the BorderLayout
        add(label, BorderLayout.CENTER);

        // Handle resize events
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Get the new size of the JFrame
                Dimension size = getContentPane().getSize();

                // Get the original size of the image
                int originalWidth = icon.getIconWidth();
                int originalHeight = icon.getIconHeight();

                // Calculate the new size of the image
                int newWidth = (int) (originalWidth * ((double) size.width / label.getPreferredSize().width));
                int newHeight = (int) (originalHeight * ((double) size.height / label.getPreferredSize().height));

                // Resize the image
                ImageIcon newIcon = new ImageIcon(icon.getImage().getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH));

                // Set the new ImageIcon on the JLabel
                label.setIcon(newIcon);
            }
        });

        // Set the size of the JFrame
        setSize(400, 300);

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new nso();
    }
}
