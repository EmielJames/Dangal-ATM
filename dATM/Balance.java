package dARM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;

public class Balance extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    private JLabel balance;
    private Dashboard dashboard;
    private String account[];
       
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Balance frame = new Balance(new String[]{"", "", ""});
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Balance(String[] account) {
    	this.account = account;
        System.out.println("Account info: " + Arrays.toString(account));
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\ljame\\Downloads\\Dangal-ATM-main (1)\\Dangal-ATM-main\\img\\bg.png"));
        } catch (IOException e) {
            System.out.println("Error loading background image: " + e.getMessage());
            e.printStackTrace();
        }

        contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    System.out.println("Painting background image.");
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Allow for absolute positioning
        setContentPane(contentPane);

        // Custom panel for logo image
        JPanel logoPnl = new ImagePanel("C:\\Users\\ljame\\Downloads\\Dangal-ATM-main (1)\\Dangal-ATM-main\\img\\Dangal ATM");
        logoPnl.setBounds(350, 80, 250, 100);
        contentPane.add(logoPnl);
        System.out.println("Logo panel bounds: " + logoPnl.getBounds());
        
        JPanel chckBalPnl = new RoundedPanel();
        chckBalPnl.setBackground(new Color(255, 255, 255));
        chckBalPnl.setBounds(40, 230, 930, 480);
        contentPane.add(chckBalPnl);
        chckBalPnl.setLayout(null);
        
        JLabel lblchckBalPnlalance = new JLabel("Check Balance");
        lblchckBalPnlalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblchckBalPnlalance.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblchckBalPnlalance.setBounds(35, 30, 277, 27);
        chckBalPnl.add(lblchckBalPnlalance);
        
        JLabel accInfoLbl = new JLabel("Account Information");
        accInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        accInfoLbl.setBounds(73, 61, 336, 33);
        chckBalPnl.add(accInfoLbl);
        
        JLabel ckientLbl = new JLabel("Client Name:");
        ckientLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        ckientLbl.setBounds(90, 92, 140, 30);
        chckBalPnl.add(ckientLbl);
        
        JLabel accNameLbl = new JLabel();
        accNameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
        accNameLbl.setBounds(240, 96, 533, 25);
        accNameLbl.setForeground(new Color(17, 141, 87));
        chckBalPnl.add(accNameLbl);
        
        
        JLabel clientNumLbl = new JLabel("Client No.:");
        clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientNumLbl.setBounds(90, 122, 140, 30);
        chckBalPnl.add(clientNumLbl);
        
        JLabel accNum = new JLabel();
        accNum.setFont(new Font("Tahoma", Font.BOLD, 18));
        accNum.setBounds(218, 126, 555, 25);
        accNum.setForeground(new Color(17, 141, 87));
        chckBalPnl.add(accNum);
        
      
        
        JPanel panel = new RoundedPanel();
        panel.setBounds(142, 215, 631, 104);
        chckBalPnl.add(panel);
        panel.setLayout(null);
        
        balance = new JLabel("Balance");
        balance.setBounds(0, 23, 631, 54);
        panel.add(balance);
        balance.setHorizontalAlignment(SwingConstants.CENTER);
        balance.setForeground(new Color(0, 100, 0));
        balance.setBackground(new Color(255, 255, 255));
        balance.setFont(new Font("Tahoma", Font.BOLD, 44));
        
        JButton cancelBtn = new RoundedButton("CANCEL");
        cancelBtn.setForeground(new Color(240, 255, 255));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancelBtn.setBackground(new Color(0, 191, 255));
        cancelBtn.setBounds(535, 376, 135, 63);
        chckBalPnl.add(cancelBtn);

        accNum.setText(account[0]);
        accNameLbl.setText(account[1]);
        balance.setText(account[2]);
        
        JButton exitBtn = new RoundedButton("EXIT");
        exitBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                System.out.println("exitBtn button clicked.");
        	}
        });
        exitBtn.setForeground(new Color(240, 255, 255));
        exitBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitBtn.setBackground(new Color(255,146,72));
        exitBtn.setBounds(703, 376, 135, 63);
        chckBalPnl.add(exitBtn);
//        -------------- EVENTS ---------------

        cancelBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked.");
        		dashboard = new Dashboard(account);
        		dashboard.setVisible(true);
        		dashboard.setLocationRelativeTo(null);
        		Balance.this.dispose();
        	}
        });
    }
    
    // Custom JPanel class with rounded corners
    class RoundedPanel extends JPanel {
        private static final long serialUID = 1L;
        private int cornerRadius = 15;

        public RoundedPanel() {
            super();
            setOpaque(false); // To ensure the background is transparent
        }

        public RoundedPanel(int radius) {
            this();
            this.cornerRadius = radius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            System.out.println("Painting RoundedPanel.");
        }
    }

    // Custom JButton class with rounded corners and no visible border
    class RoundedButton extends JButton {
        private static final long serialUID = 1L;
        
        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false); // To remove the default fill behavior
            setBorderPainted(false); // To ensure the border is not painted
            setFocusPainted(false); // To remove the focus border
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            super.paintComponent(g2);
            g2.dispose();
            System.out.println("Painting RoundedButton.");
        }

        @Override
        protected void paintBorder(Graphics g) {
            // Overridden to remove the border painting
        }

        @Override
        public boolean contains(int x, int y) {
            int width = getWidth();
            int height = getHeight();
            int arcWidth = 30;
            int arcHeight = 30;
            return new RoundRectangle2D.Float(0, 0, width, height, arcWidth, arcHeight).contains(x, y);
        }
    }

    // Custom JPanel class for displaying an image
    class ImagePanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                image = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
                e.printStackTrace();
            }
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                System.out.println("Painting ImagePanel.");
            }
        }
    }
}
