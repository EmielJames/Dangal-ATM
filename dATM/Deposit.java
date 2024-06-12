package dARM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private JTextField amountTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setTitle("Deposit Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\USER\\dATM\\imgs\\bg.png"));
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
		JPanel logoPanel = new ImagePanel("C:\\Users\\USER\\dATM\\imgs\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.add(logoPanel);
		bgPane.setLayout(null);
		
		JPanel DepositInfoPane = new JPanel();
		DepositInfoPane.setBackground(new Color(255, 255, 255));
		DepositInfoPane.setBounds(45, 238, 930, 480);
		bgPane.add(DepositInfoPane);
		DepositInfoPane.setLayout(null);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 128, 0));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBounds(447, 367, 135, 63);
		DepositInfoPane.add(cancelBtn);
		
		JButton confirmBtn = new JButton("CONFIRM");
		confirmBtn.setForeground(new Color(240, 255, 255));
		confirmBtn.setBackground(new Color(0, 128, 0));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBounds(260, 367, 135, 63);
		DepositInfoPane.add(confirmBtn);
		
		JLabel accInfolbl = new JLabel("Account Information: ");
		accInfolbl.setBounds(114, 79, 336, 33);
		DepositInfoPane.add(accInfolbl);
		accInfolbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel accNamelbl = new JLabel("Client Name:");
		accNamelbl.setBounds(140, 111, 140, 30);
		DepositInfoPane.add(accNamelbl);
		accNamelbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel accNameLbl = new JLabel();
        accNameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
        accNameLbl.setBounds(240, 96, 533, 25);
        accNameLbl.setForeground(new Color(17, 141, 87));
        DepositInfoPane.add(accNameLbl);
		
		JLabel clientNumLbl = new JLabel("Client No.:");
		clientNumLbl.setBounds(140, 140, 108, 30);
		DepositInfoPane.add(clientNumLbl);
		clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel accNum = new JLabel();
        accNum.setFont(new Font("Tahoma", Font.BOLD, 18));
        accNum.setBounds(218, 126, 555, 25);
        accNum.setForeground(new Color(17, 141, 87));
        DepositInfoPane.add(accNum);
		
		amountTxtField = new JTextField();
		amountTxtField.setBackground(new Color(192, 192, 192));
		amountTxtField.setForeground(new Color(0, 100, 0));
		amountTxtField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		amountTxtField.setBounds(117, 252, 765, 102);
		DepositInfoPane.add(amountTxtField);
		amountTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxtField.setColumns(10);
		
		JLabel DepositLbl = new JLabel("Deposit: ");
		DepositLbl.setBounds(21, 25, 307, 43);
		DepositInfoPane.add(DepositLbl);
		DepositLbl.setHorizontalAlignment(SwingConstants.CENTER);
		DepositLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel balanceLbl = new JLabel(" ");
		balanceLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		balanceLbl.setBounds(662, 87, 258, 25);
		DepositInfoPane.add(balanceLbl);
		
		JLabel lblNewLabel = new JLabel("₱");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 95));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 241, 78, 113);
		DepositInfoPane.add(lblNewLabel);
		
		JLabel NameLbl = new JLabel(" ");
		NameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		NameLbl.setBounds(260, 115, 135, 25);
		DepositInfoPane.add(NameLbl);
		
		JLabel NumberLbl = new JLabel(" ");
		NumberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		NumberLbl.setBounds(238, 144, 135, 25);
		DepositInfoPane.add(NumberLbl);
		
		JButton eraseBTN = new JButton("DELETE");
		eraseBTN.setForeground(new Color(240, 255, 255));
		eraseBTN.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBTN.setBackground(new Color(0, 128, 0));
		eraseBTN.setBounds(635, 367, 135, 63);
		DepositInfoPane.add(eraseBTN);
		
		JLabel amountLbl = new JLabel("Enter the Amount You Want to Deposit");
		amountLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		amountLbl.setBounds(114, 220, 361, 21);
		DepositInfoPane.add(amountLbl);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCurrentBalance.setBounds(140, 168, 158, 30);
		DepositInfoPane.add(lblCurrentBalance);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
