package MainInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StartingPage {

	private JFrame frmStartingPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingPage window = new StartingPage();
					window.frmStartingPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartingPage = new JFrame();
		frmStartingPage.setResizable(false);
		frmStartingPage.getContentPane().setBackground(SystemColor.windowBorder);
		frmStartingPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 538, 331);
		frmStartingPage.getContentPane().add(panel);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("CPU Scheduling Simulator");
		lblCpuSchedulingSimulator.setBounds(5, 50, 528, 42);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 41));
		
		JLabel lblProjectBy = new JLabel("Project by");
		lblProjectBy.setBounds(5, 110, 528, 27);
		lblProjectBy.setForeground(Color.LIGHT_GRAY);
		lblProjectBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectBy.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 26));
		
		JLabel lblTahirSaeed = new JLabel("Tahir Saeed - 37893");
		lblTahirSaeed.setBounds(5, 141, 528, 27);
		lblTahirSaeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblTahirSaeed.setForeground(Color.LIGHT_GRAY);
		lblTahirSaeed.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
		
		JLabel lblUsmanAfaq = new JLabel("Usman Afaq - 38144");
		lblUsmanAfaq.setBounds(5, 163, 528, 27);
		lblUsmanAfaq.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsmanAfaq.setForeground(Color.LIGHT_GRAY);
		lblUsmanAfaq.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
		panel.setLayout(null);
		panel.add(lblCpuSchedulingSimulator);
		panel.add(lblProjectBy);
		panel.add(lblTahirSaeed);
		panel.add(lblUsmanAfaq);
		
		JLabel lblShahzaibHasan = new JLabel("Shahzaib Hassan - 38162");
		lblShahzaibHasan.setHorizontalAlignment(SwingConstants.CENTER);
		lblShahzaibHasan.setForeground(Color.LIGHT_GRAY);
		lblShahzaibHasan.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
		lblShahzaibHasan.setBounds(5, 186, 528, 27);
		panel.add(lblShahzaibHasan);
		
		JLabel lblAliUrRehman = new JLabel("Ali ur Rehman - 38096");
		lblAliUrRehman.setHorizontalAlignment(SwingConstants.CENTER);
		lblAliUrRehman.setForeground(Color.LIGHT_GRAY);
		lblAliUrRehman.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
		lblAliUrRehman.setBounds(5, 210, 528, 27);
		panel.add(lblAliUrRehman);
		
		JButton btnNewButton = new JButton("Click to Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainMenu mm = new MainMenu();
				frmStartingPage.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setBounds(127, 263, 278, 43);
		panel.add(btnNewButton);
		frmStartingPage.setBounds(100, 100, 544, 359);
		frmStartingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartingPage.setLocationRelativeTo(null);
		frmStartingPage.setTitle("CPU Scheduling Simulator");
	}
}
