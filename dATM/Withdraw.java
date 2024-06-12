package dARM;

import java.awt.Color;
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
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private JTextField amountTxtField;
	private Dashboard dashboard;
	private String account[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw(new String[]{"", "", ""});
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
	public Withdraw(String[] account) {
		this.account = account;
		
		setTitle("Withdraw Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Custom JPanel for background image
		bgPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bgPane);
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.add(logoPanel);
		bgPane.setLayout(null);
		
		JPanel withdrawPnl = new RoundedPanel();
		withdrawPnl.setBackground(new Color(255, 255, 255));
		withdrawPnl.setBounds(40, 230, 930, 480);
		bgPane.add(withdrawPnl);
		withdrawPnl.setLayout(null);
		
		JLabel withdrawLbl = new JLabel("Withdraw");
		withdrawLbl.setBounds(10, 30, 277, 27);
		withdrawPnl.add(withdrawLbl);
		withdrawLbl.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel accInfolbl = new JLabel("Account Information: ");
		accInfolbl.setBounds(73, 61, 336, 33);
		withdrawPnl.add(accInfolbl);
		accInfolbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel accNamelbl = new JLabel("Client Name:");
		accNamelbl.setBounds(90, 92, 140, 30);
		withdrawPnl.add(accNamelbl);
		accNamelbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel NameLbl = new JLabel();
		NameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		NameLbl.setBounds(240, 96, 533, 25);
		withdrawPnl.add(NameLbl);
		
		JLabel clientNumLbl = new JLabel("Client No.:");
		clientNumLbl.setBounds(90, 122, 140, 30);
		withdrawPnl.add(clientNumLbl);
		clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel NumberLbl = new JLabel();
		NumberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		NumberLbl.setBounds(218, 126, 555, 25);
		withdrawPnl.add(NumberLbl);
	
		JLabel currentLbl = new JLabel("Current Balance");
		currentLbl.setBounds(90, 122, 140, 30);
		currentLbl.add(clientNumLbl);
		clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel currentBalLbl = new JLabel();
		currentLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentLbl.setBounds(208, 144, 140, 30);
		withdrawPnl.add(currentLbl);
		
		
		
		amountTxtField = new JTextField();
		amountTxtField.setBackground(new Color(225, 245, 225));
		amountTxtField.setForeground(new Color(0, 100, 0));
		amountTxtField.setFont(new Font("Poppins", Font.BOLD, 60));
		amountTxtField.setBounds(142, 215, 631, 104);
		withdrawPnl.add(amountTxtField);
		amountTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxtField.setColumns(10);
		
		
		
		
	
			
		
		
		
		JButton cancelBtn = new RoundedButton("CANCEL");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 191, 255));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBounds(500, 376, 135, 63);
		withdrawPnl.add(cancelBtn);
		
		JButton confirmBtn = new RoundedButton("CONFIRM");
		confirmBtn.setForeground(new Color(240, 255, 255));
		confirmBtn.setBackground(new Color(26, 172, 119));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBounds(700, 376, 135, 63);
		withdrawPnl.add(confirmBtn);
		
		JButton eraseBTN = new RoundedButton("DELETE");
		eraseBTN.setForeground(new Color(240, 255, 255));
		eraseBTN.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBTN.setBackground(new Color(255, 127, 127));
		eraseBTN.setBounds(300, 376, 135, 63);
		withdrawPnl.add(eraseBTN);
		
		NumberLbl.setText(account[0]);
		NameLbl.setText(account[1]);
		currentBalLbl.setText(account[2]);		
//		------------- EVENTS -------------
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard = new Dashboard(account);
				dashboard.setVisible(true);
				dashboard.setLocationRelativeTo(null);
				Withdraw.this.dispose();
			}
		});
		
		amountTxtField.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			char c = e.getKeyChar();
        		if(!Character.isDigit(c)) {
        			e.consume();
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
