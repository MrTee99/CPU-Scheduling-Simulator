package MainInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setBounds(100, 100, 544, 359);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.setVisible(true);
		frmMainMenu.setResizable(false);
		frmMainMenu.getContentPane().setBackground(SystemColor.windowBorder);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setLocationRelativeTo(null);
		frmMainMenu.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 538, 331);
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("CPU Scheduling Simulator");
		lblCpuSchedulingSimulator.setBounds(5, 50, 528, 42);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 41));
		panel.add(lblCpuSchedulingSimulator);
		
		JButton btnNonpreemptiveScheduling = new JButton("Non-Preemptive Scheduling");
		btnNonpreemptiveScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NonPreemptive np = new NonPreemptive();
				frmMainMenu.setVisible(false);
			}
		});
		btnNonpreemptiveScheduling.setForeground(SystemColor.windowBorder);
		btnNonpreemptiveScheduling.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 24));
		btnNonpreemptiveScheduling.setBounds(90, 134, 362, 67);
		btnNonpreemptiveScheduling.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNonpreemptiveScheduling);
		
		JButton btnPreemptiveScheduling = new JButton("Preemptive Scheduling");
		btnPreemptiveScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Preemptive p = new Preemptive();
				frmMainMenu.setVisible(false);
			}
		});
		btnPreemptiveScheduling.setForeground(SystemColor.windowBorder);
		btnPreemptiveScheduling.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 24));
		btnPreemptiveScheduling.setBackground(Color.LIGHT_GRAY);
		btnPreemptiveScheduling.setBounds(90, 212, 362, 67);
		panel.add(btnPreemptiveScheduling);

	}

}
