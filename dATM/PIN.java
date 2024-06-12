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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class pin {

	private JFrame frame;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private JTextField pinLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pin window = new pin();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Deposit Dashboard");
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		frame.setContentPane(bgPane);
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.add(logoPanel);
		bgPane.setLayout(null);
		// panel na nakalagay lahat
		JPanel DepositDashboardInfoPane = new RoundedPanel();
		DepositDashboardInfoPane.setBackground(new Color(255, 255, 255));
		DepositDashboardInfoPane.setBounds(45, 238, 930, 480);
		bgPane.add(DepositDashboardInfoPane);
		DepositDashboardInfoPane.setLayout(null);
		
		JButton cancelBtn = new RoundedButton("CANCEL");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 191, 255));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBounds(500, 376, 135, 63);
		DepositDashboardInfoPane.add(cancelBtn);
		
		JButton confirmBtn = new RoundedButton("CONFIRM");
		confirmBtn.setForeground(new Color(240, 255, 255));
		confirmBtn.setBackground(new Color(26, 172, 119));
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBounds(700, 376, 135, 63);
		DepositDashboardInfoPane.add(confirmBtn);
		
		pinLabel = new JTextField();
		pinLabel.setBackground(new Color(225, 245, 225));
		pinLabel.setForeground(new Color(0, 100, 0));
		pinLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		pinLabel.setBounds(78, 168, 765, 102);
		DepositDashboardInfoPane.add(pinLabel);
		pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinLabel.setColumns(10);
		
		JLabel DepositDashboardLbl = new JLabel("Enter pin");
		DepositDashboardLbl.setBounds(10, 25, 307, 43);
		DepositDashboardInfoPane.add(DepositDashboardLbl);
		DepositDashboardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		DepositDashboardLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		
		
		
		
		
		JButton eraseBTN = new RoundedButton("DELETE");
		eraseBTN.setForeground(new Color(240, 255, 255));
		eraseBTN.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBTN.setBackground(new Color(255, 127, 127));
		eraseBTN.setBounds(300, 376, 135, 63);
		DepositDashboardInfoPane.add(eraseBTN);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
    }
}
