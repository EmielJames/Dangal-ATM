package dARM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Landing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel landingPane;
    private BufferedImage backgroundImage;
    private JTextField userTextField;
    private Dashboard dashboard;
    
    private String[] header = {"STUDENT NUMBER", "FIRST NAME", "LAST NAME"};
	private String[][] data = {
        {"2300650", "MAG-USARA, KIRT ASIA", "₱69,420.00"},
		{"2300649", "FATAL, MOISES JR.", "₱42,690.00"},
		{"2300646", "FARINAS, JORICK CHRISTIAN", "₱10,000.00"},
		{"2300640", "ESCUZAR, EMIEL JAMES", "₱20,000.00"},
		{"2302745", "PEGA, JEDE ISAIAH MAXWEIL", "₱30,000.00"}
    };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Landing frame = new Landing();
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
    public Landing() {
        setTitle("Dangal ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\ljame\\Downloads\\Dangal-ATM-main (1)\\Dangal-ATM-main\\img\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Background panel
        landingPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        landingPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(landingPane);
        landingPane.setLayout(null);
        
        JPanel loginPanel = new RoundedPanel();
        loginPanel.setBackground(SystemColor.control);
        loginPanel.setBounds(50, 60, 410, 636);
        landingPane.add(loginPanel);
        loginPanel.setLayout(null);
        
        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\ljame\\Downloads\\Dangal-ATM-main (1)\\Dangal-ATM-main\\img\\Dangal ATM.png");
        logoPanel.setBounds(55, 80, 310, 100);
        loginPanel.add(logoPanel);
        
        JLabel customerLabel = new JLabel("USER LOGIN");
        customerLabel.setForeground(new Color(17, 141, 87));
        customerLabel.setFont(new Font("Poppins", Font.BOLD, 25));
        customerLabel.setBackground(Color.GREEN);
        customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customerLabel.setBounds(10, 221, 400, 31);
        loginPanel.add(customerLabel);
        
        // Custom panel with rounded corners
        JPanel cuslblPane = new RoundedPanel(30); // 30 is the radius of the corners
        cuslblPane.setBackground(new Color(225, 245, 225));
        cuslblPane.setBounds(31, 210, 350, 53);
        loginPanel.add(cuslblPane);
        
        // Custom panel for profile icon
        JPanel profileIcon = new ImagePanel("C:\\Users\\ljame\\Downloads\\Dangal-ATM-main (1)\\Dangal-ATM-main\\img\\user-fill.png");
        profileIcon.setBounds(40, 325, 20, 20);
        loginPanel.add(profileIcon);
        
        
        userTextField = new JTextField();
        userTextField.setFont(new Font("Tahoma", Font.BOLD, 40));
        userTextField.setForeground(new Color(17, 141, 87));
        userTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userTextField.setBounds(79, 294, 280, 82);
        loginPanel.add(userTextField);
        userTextField.setColumns(10);
        
        JButton loginBTN = new RoundedButton("Login");
        loginBTN.setBackground(new Color(46,149,87));
        loginBTN.setForeground(new Color(255, 255, 255));
        loginBTN.setBounds(130, 440, 140, 50);
        loginBTN.setFont(new Font("Tahoma", Font.BOLD, 24)); // Set a larger font size
        loginPanel.add(loginBTN);	
        
        JLabel lblNewLabel = new JLabel("Activate Account");
        lblNewLabel.setForeground(new Color(17, 141, 87));
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 386, 410, 39);
        loginPanel.add(lblNewLabel);
        
        // Events
        loginBTN.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		for(int i = 0; i < data.length; i++) {
        			if(userTextField.getText().equals(data[i][0])) {
            			Landing.this.dispose();
            			dashboard = new Dashboard(data[i]);
                    	dashboard.setVisible(true);
                    	dashboard.setLocationRelativeTo(null);
        			}
        		}
        		userTextField.setText(null);
        	}
        });
        
        userTextField.addKeyListener(new KeyAdapter() {
        		@Override
        		public void keyTyped(KeyEvent e) {
        			char c = e.getKeyChar();
            		if(!Character.isDigit(c)) {
            			e.consume();
            		}
        		}
        });
        	
        userTextField.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
        	   if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        		   for(int i = 0; i < data.length; i++) {
           			if(userTextField.getText().equals(data[i][0])) {
               			Landing.this.dispose();
               			dashboard = new Dashboard(data[i]);
                       	dashboard.setVisible(true);
                       	dashboard.setLocationRelativeTo(null);
           			}
           		}
           		userTextField.setText(null);
        	   }
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
        }
    }

    // Custom JPanel class for displaying an image
    class ImagePanel extends JPanel {
        private static final long serialUID = 1L;
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                image = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
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
}
