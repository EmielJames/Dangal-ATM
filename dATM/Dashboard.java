package dARM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedImage backgroundImage;
	private Balance balance;
	private Withdraw withdraw;
	private String account[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(new String[]{"", "", ""});
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
	public Dashboard(String[] account) {
		this.account = account;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\\\Users\\\\ljame\\\\Downloads\\\\Dangal-ATM-main (1)\\\\Dangal-ATM-main\\\\img\\\\bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Custom JPanel for background image
		contentPane = new JPanel() {
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

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);  // Using null layout for custom placement of components
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\\\Users\\\\ljame\\\\Downloads\\\\Dangal-ATM-main (1)\\\\Dangal-ATM-main\\\\img\\\\logo.png");
		logoPanel.setBounds(175, 15, 200, 80);
		contentPane.add(logoPanel);
		
		JPanel panel = new RoundedPanel();
		panel.setBounds(39, 112, 510, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton CBbtn = new RoundedButton("CHECK BALANCE");
		CBbtn.setBounds(39, 26, 435, 159);
		panel.add(CBbtn);
		CBbtn.setForeground(new Color(255,255,255));
		CBbtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		CBbtn.setBackground(new Color(26, 172, 119));
		
		JButton deposit = new RoundedButton("DEPOSIT");
		deposit.setBounds(39, 393, 435, 159);
		panel.add(deposit);
		deposit.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		deposit.setForeground(new Color(255,255,255));
		deposit.setBackground(new Color(26, 172, 119));
		
		JButton withdrawBtn = new RoundedButton("WITHDRAW");
		withdrawBtn.setBounds(39, 206, 435, 159);
		panel.add(withdrawBtn);
		withdrawBtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		withdrawBtn.setBackground(new Color(26, 172, 119));
		withdrawBtn.setForeground(new Color(255,255,255));
		
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw = new Withdraw(account);
				withdraw.setVisible(true);
				withdraw.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});
		
//		------------- EVENTS -----------
		
		CBbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balance = new Balance(account);
				balance.setVisible(true);
				balance.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});
	}

	// Custom JPanel class for displaying an image
	class ImagePanel extends JPanel {
		private static final long serialVersionUID = 1L;
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
}
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

// Define RoundedButton outside the Dashboard class
class RoundedButton extends JButton {
	private static final long serialVersionUID = 1L;

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
		Shape round = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
		g2.setColor(getBackground());
		g2.fill(round);
		g2.setColor(getForeground());
		g2.draw(round);
		g2.dispose();
		super.paintComponent(g);
	}
}
