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
import RealWork.NPfcfsEnterProcess;
import RealWork.NPpriorityEnterProcess;
import RealWork.NPrrEnterProcess;
import RealWork.NPsjfEnterProcess;

public class NonPreemptive {

	private JFrame frmNP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NonPreemptive window = new NonPreemptive();
					window.frmNP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NonPreemptive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNP = new JFrame();
		frmNP.setBounds(100, 100, 544, 359);
		frmNP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNP.setVisible(true);
		frmNP.setResizable(false);
		frmNP.getContentPane().setBackground(SystemColor.windowBorder);
		frmNP.getContentPane().setLayout(null);
		frmNP.setLocationRelativeTo(null);
		frmNP.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 538, 331);
		frmNP.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("CPU Scheduling Simulator");
		lblCpuSchedulingSimulator.setBounds(5, 50, 528, 42);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 41));
		panel.add(lblCpuSchedulingSimulator);
		
		JLabel lblNonPreemptive = new JLabel("Non-Preemptive");
		lblNonPreemptive.setBounds(5, 103, 528, 27);
		lblNonPreemptive.setForeground(Color.LIGHT_GRAY);
		lblNonPreemptive.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonPreemptive.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 26));
		panel.add(lblNonPreemptive);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NPfcfsEnterProcess ep = new NPfcfsEnterProcess();
				
			}
		});
		btnFcfs.setForeground(SystemColor.windowBorder);
		btnFcfs.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnFcfs.setBackground(Color.LIGHT_GRAY);
		btnFcfs.setBounds(72, 148, 190, 53);
		panel.add(btnFcfs);
		
		JButton btnPriority = new JButton("Priority");
		btnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NPpriorityEnterProcess ep = new NPpriorityEnterProcess();
				
			}
		});
		btnPriority.setForeground(SystemColor.windowBorder);
		btnPriority.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnPriority.setBackground(Color.LIGHT_GRAY);
		btnPriority.setBounds(72, 212, 190, 53);
		panel.add(btnPriority);
		
		JButton btnRoundRobin = new JButton("Round Robin");
		btnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NPrrEnterProcess ep = new NPrrEnterProcess();
			}
		});
		btnRoundRobin.setForeground(SystemColor.windowBorder);
		btnRoundRobin.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnRoundRobin.setBackground(Color.LIGHT_GRAY);
		btnRoundRobin.setBounds(285, 212, 190, 53);
		panel.add(btnRoundRobin);
		
		JButton btnSjf = new JButton("SJF");
		btnSjf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NPsjfEnterProcess ep = new NPsjfEnterProcess();
				
			}
		});
		btnSjf.setForeground(SystemColor.windowBorder);
		btnSjf.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnSjf.setBackground(Color.LIGHT_GRAY);
		btnSjf.setBounds(285, 148, 190, 53);
		panel.add(btnSjf);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(SystemColor.windowBorder);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu mm = new MainMenu();
				frmNP.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		btnGoBack.setBounds(228, 280, 89, 29);
		panel.add(btnGoBack);
	}

}
