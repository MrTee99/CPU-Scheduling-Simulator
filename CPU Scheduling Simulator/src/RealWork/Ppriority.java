package RealWork;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Ppriority {

	private JFrame frmPpriority;
	public static int totalP;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppriority window = new Ppriority();
					window.frmPpriority.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ppriority() {
		initialize();
	}
	
	public Ppriority(int totalProcess) {
		totalP = totalProcess;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPpriority = new JFrame();
		frmPpriority.setBounds(100, 100, 771, 626);
		frmPpriority.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPpriority.setVisible(true);
		frmPpriority.setResizable(false);
		frmPpriority.getContentPane().setBackground(SystemColor.windowBorder);
		frmPpriority.getContentPane().setLayout(null);
		frmPpriority.setLocationRelativeTo(null);
		frmPpriority.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 765, 598);
		frmPpriority.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("Preemptive Priority Scheduling");
		lblCpuSchedulingSimulator.setBounds(0, 21, 763, 67);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 30));
		panel.add(lblCpuSchedulingSimulator);
		
		JLabel lblProcessId = new JLabel("PROCESS ID");
		lblProcessId.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblProcessId.setForeground(Color.GRAY);
		lblProcessId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessId.setBounds(10, 99, 106, 18);
		panel.add(lblProcessId);
		
		JLabel lblBurstTime = new JLabel("BURST TIME");
		lblBurstTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurstTime.setForeground(Color.GRAY);
		lblBurstTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblBurstTime.setBounds(113, 99, 123, 18);
		panel.add(lblBurstTime);
		
		JLabel lblWaitTime = new JLabel("WAIT TIME");
		lblWaitTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitTime.setForeground(Color.GRAY);
		lblWaitTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblWaitTime.setBounds(465, 99, 123, 18);
		panel.add(lblWaitTime);
		
		JLabel lblTurnaroundTime = new JLabel("TURNAROUND TIME");
		lblTurnaroundTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnaroundTime.setForeground(Color.GRAY);
		lblTurnaroundTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblTurnaroundTime.setBounds(572, 99, 191, 18);
		panel.add(lblTurnaroundTime);
		
		JLabel lblPriority = new JLabel("PRIORITY");
		lblPriority.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriority.setForeground(Color.GRAY);
		lblPriority.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblPriority.setBounds(228, 99, 118, 18);
		panel.add(lblPriority);
		
		JLabel lblArrivalTime = new JLabel("ARRIVAL TIME");
		lblArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrivalTime.setForeground(Color.GRAY);
		lblArrivalTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 16));
		lblArrivalTime.setBounds(336, 99, 136, 18);
		panel.add(lblArrivalTime);
		
		JLabel[] lblPid = new JLabel[10];
		int yaxis = 128;
		for(int i =0; i<10; i++) {
			lblPid[i] = new JLabel("P" + (i+1));
			lblPid[i].setVisible(false);
			lblPid[i].setForeground(Color.LIGHT_GRAY);
			lblPid[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			lblPid[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblPid[i].setBounds(6, yaxis, 123, 23);
			panel.add(lblPid[i]);
			yaxis = yaxis+30;
		}
		
		JTextField[] BTinput = new JTextField[10];
		yaxis = 128;
		for(int i =0; i<10; i++) {
			BTinput[i] = new JTextField();
			BTinput[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
						arg0.consume();
					}
				}
			});
			BTinput[i].setEnabled(false);
			BTinput[i].setVisible(false);
			BTinput[i].setForeground(SystemColor.windowBorder);
			BTinput[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			BTinput[i].setBounds(122, yaxis, 105, 23);
			panel.add(BTinput[i]);
			BTinput[i].setColumns(10);
			yaxis = yaxis+30;
		}
		
		JTextField[] Priorityinput = new JTextField[10];
		yaxis = 128;
		for(int i =0; i<10; i++) {
			Priorityinput[i] = new JTextField();
			Priorityinput[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
						arg0.consume();
					}
				}
			});
			Priorityinput[i].setEnabled(false);
			Priorityinput[i].setVisible(false);
			Priorityinput[i].setForeground(SystemColor.windowBorder);
			Priorityinput[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			Priorityinput[i].setBounds(245, yaxis, 85, 23);
			panel.add(Priorityinput[i]);
			Priorityinput[i].setColumns(10);
			yaxis = yaxis+30;
		}
		
		JTextField[] ATinput = new JTextField[10];
		yaxis = 128;
		for(int i =0; i<10; i++) {
			ATinput[i] = new JTextField();
			ATinput[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
						arg0.consume();
					}
				}
			});
			ATinput[i].setEnabled(false);
			ATinput[i].setVisible(false);
			ATinput[i].setForeground(SystemColor.windowBorder);
			ATinput[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			ATinput[i].setBounds(350, yaxis, 110, 23);
			panel.add(ATinput[i]);
			ATinput[i].setColumns(10);
			yaxis = yaxis+30;
		}
		
		JLabel[] lblWT = new JLabel[10];
		yaxis = 128;
		for(int i =0; i<10; i++) {
			lblWT[i] = new JLabel("---");
			lblWT[i].setVisible(false);
			lblWT[i].setForeground(Color.LIGHT_GRAY);
			lblWT[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			lblWT[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblWT[i].setBounds(470, yaxis, 123, 23);
			panel.add(lblWT[i]);
			yaxis = yaxis+30;
		}
		
		JLabel[] lblTT = new JLabel[10];
		yaxis = 128;
		for(int i =0; i<10; i++) {
			lblTT[i] = new JLabel("---");
			lblTT[i].setVisible(false);
			lblTT[i].setForeground(Color.LIGHT_GRAY);
			lblTT[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			lblTT[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblTT[i].setBounds(600, yaxis, 123, 23);
			panel.add(lblTT[i]);
			yaxis = yaxis+30;
		}
		
		JLabel lblAVGwt = new JLabel("Average Wait Time:");
		lblAVGwt.setHorizontalAlignment(SwingConstants.CENTER);
		lblAVGwt.setForeground(Color.GRAY);
		lblAVGwt.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 23));
		lblAVGwt.setBounds(21, 533, 219, 42);
		panel.add(lblAVGwt);
		
		JLabel lblAVGwtAnswer = new JLabel("--");
		lblAVGwtAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAVGwtAnswer.setForeground(Color.GRAY);
		lblAVGwtAnswer.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 23));
		lblAVGwtAnswer.setBounds(225, 533, 137, 42);
		panel.add(lblAVGwtAnswer);
		
		JLabel lblAVGttAnswer = new JLabel("--");
		lblAVGttAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAVGttAnswer.setForeground(Color.GRAY);
		lblAVGttAnswer.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 23));
		lblAVGttAnswer.setBounds(640, 533, 103, 42);
		panel.add(lblAVGttAnswer);
		
		JPanel panelWT = new JPanel();
		panelWT.setBounds(21, 533, 341, 42);
		panel.add(panelWT);
		
		JLabel lblAVGtt = new JLabel("Average Turnaround Time:");
		lblAVGtt.setBounds(374, 531, 272, 42);
		panel.add(lblAVGtt);
		lblAVGtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblAVGtt.setForeground(Color.GRAY);
		lblAVGtt.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 25));
		
		JPanel panelTT = new JPanel();
		panelTT.setBounds(372, 533, 371, 42);
		panel.add(panelTT);
		
		/*
		 * 
		 * Open specific number of processes
		 * 
		 */
		for(int i =1; i<=10; i++) {
			if(totalP == i) {
				for(int j=0; j<totalP; j++) {
					lblPid[j].setVisible(true);
					
					BTinput[j].setVisible(true);
					BTinput[j].setEnabled(true);
					
					Priorityinput[j].setVisible(true);
					Priorityinput[j].setEnabled(true);
					
					ATinput[j].setVisible(true);
					ATinput[j].setEnabled(true);
					
					lblWT[j].setVisible(true);
					
					lblTT[j].setVisible(true);
				}
				break;
			}
		}
		
		/*
		 * 
		 * GANT CHART CONSTRUCTION ITEMS INITIALIZED HERE
		 * 
		 */
		JPanel[] GC = new JPanel[24];
		int X1axis = 180, X2axis = 180;
		for(int i =0; i<24; i++) {
			GC[i] = new JPanel();
			GC[i].setBackground(new Color(127, 255, 0));
			GC[i].setVisible(false);
			if(i<12) {
				GC[i].setBounds(X1axis, 437, 40, 30);
				X1axis = X1axis+46;
			}
			else {
				GC[i].setBounds(X2axis, 483, 40, 30);
				X2axis = X2axis+46;
			}
			panel.add(GC[i]);
		}
		
		JLabel[] GCPid = new JLabel[24];
		for(int i=0; i<24; i++) {
			GCPid[i] = new JLabel("Pid");
			GC[i].add(GCPid[i]);
			GCPid[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
			GCPid[i].setForeground(SystemColor.windowBorder);
			GCPid[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		JLabel[] timeline = new JLabel[25];
		X1axis = 154;
		X2axis = 154;
		for(int i=0; i<25; i++) {
			timeline[i] = new JLabel("");
			timeline[i].setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 10));
			timeline[i].setHorizontalAlignment(SwingConstants.CENTER);
			timeline[i].setForeground(Color.LIGHT_GRAY);
			if(i<12) {
				timeline[i].setBounds(X1axis, 467, 46, 14);
				X1axis = X1axis+46;
			}
			else {
				timeline[i].setBounds(X2axis, 513, 46, 14);
				X2axis = X2axis+46;
			}
			panel.add(timeline[i]);
		}
		
		/*
		 * 
		 * REAL CODING WORK HERE
		 * 
		 */
	}

}
