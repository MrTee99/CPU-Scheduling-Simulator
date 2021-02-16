package MainInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import RealWork.NPfcfsEnterProcess;
import RealWork.PfcfsEnterProcess;
import RealWork.PpriorityEnterProcess;
import RealWork.PsjfEnterProcess;

public class Preemptive {

	private JFrame frmP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preemptive window = new Preemptive();
					window.frmP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Preemptive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmP = new JFrame();
		frmP.setBounds(100, 100, 544, 359);
		frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmP.setVisible(true);
		frmP.setResizable(false);
		frmP.getContentPane().setBackground(SystemColor.windowBorder);
		frmP.getContentPane().setLayout(null);
		frmP.setLocationRelativeTo(null);
		frmP.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 538, 331);
		frmP.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("CPU Scheduling Simulator");
		lblCpuSchedulingSimulator.setBounds(5, 50, 528, 42);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 41));
		panel.add(lblCpuSchedulingSimulator);
		
		JLabel lblPreemptive = new JLabel("Preemptive");
		lblPreemptive.setBounds(5, 103, 528, 27);
		lblPreemptive.setForeground(Color.LIGHT_GRAY);
		lblPreemptive.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreemptive.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 26));
		panel.add(lblPreemptive);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PfcfsEnterProcess ep = new PfcfsEnterProcess();
				
			}
		});
		btnFcfs.setForeground(SystemColor.windowBorder);
		btnFcfs.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnFcfs.setBackground(Color.LIGHT_GRAY);
		btnFcfs.setBounds(72, 148, 190, 53);
		panel.add(btnFcfs);
		
		JButton btnPriority = new JButton("Priority");
		btnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PpriorityEnterProcess ep = new PpriorityEnterProcess();
				
			}
		});
		btnPriority.setForeground(SystemColor.windowBorder);
		btnPriority.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		btnPriority.setBackground(Color.LIGHT_GRAY);
		btnPriority.setBounds(178, 212, 190, 53);
		panel.add(btnPriority);
		
		JButton btnSjf = new JButton("SJF");
		btnSjf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PsjfEnterProcess ep = new PsjfEnterProcess();
				
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
				frmP.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		btnGoBack.setBounds(228, 280, 89, 29);
		panel.add(btnGoBack);
	}

}
