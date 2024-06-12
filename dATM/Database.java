package dARM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Database extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] header = {"STUDENT NUMBER", "FIRST NAME", "LAST NAME"};
	private String[][] data = {{"2300650", "MAG-USARA, KIRT ASIA", "69420.00"},
							   {"2300649", "FATAL, MOISES JR.", "42690.00"},
							   {"2300646", "FARINAS, JORICK CHRISTIAN", "10000.00"},
							   {"2300640", "ESCUZAR, EMIEL JAMES", "20000.00"},
							   {"2302745", "PEGA, JEDE ISAIAH MAXWEIL", "30000.00"}};
	private DefaultTableModel modelStudents = new DefaultTableModel(data, header) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database frame = new Database();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Database() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
