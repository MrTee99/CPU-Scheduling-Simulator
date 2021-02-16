package RealWork;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class NPfcfs {

	private JFrame frmNPfcfs;
	public static int totalP;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NPfcfs window = new NPfcfs();
					window.frmNPfcfs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NPfcfs() {
		initialize();
	}
	
	public NPfcfs(int totalProcess) {
		totalP = totalProcess;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNPfcfs = new JFrame();
		frmNPfcfs.setBounds(100, 100, 771, 626);
		frmNPfcfs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNPfcfs.setVisible(true);
		frmNPfcfs.setResizable(false);
		frmNPfcfs.getContentPane().setBackground(SystemColor.windowBorder);
		frmNPfcfs.getContentPane().setLayout(null);
		frmNPfcfs.setLocationRelativeTo(null);
		frmNPfcfs.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 765, 598);
		frmNPfcfs.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("Non-Preemptive FCFS Scheduling");
		lblCpuSchedulingSimulator.setBounds(0, 21, 763, 67);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 30));
		panel.add(lblCpuSchedulingSimulator);
		
		JLabel lblProcessId = new JLabel("PROCESS ID");
		lblProcessId.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 22));
		lblProcessId.setForeground(Color.GRAY);
		lblProcessId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessId.setBounds(21, 98, 148, 31);
		panel.add(lblProcessId);
		
		JLabel lblBurstTime = new JLabel("BURST TIME");
		lblBurstTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurstTime.setForeground(Color.GRAY);
		lblBurstTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 22));
		lblBurstTime.setBounds(179, 99, 162, 30);
		panel.add(lblBurstTime);
		
		JLabel lblWaitTime = new JLabel("WAIT TIME");
		lblWaitTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitTime.setForeground(Color.GRAY);
		lblWaitTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 22));
		lblWaitTime.setBounds(351, 99, 149, 30);
		panel.add(lblWaitTime);
		
		JLabel lblTurnaroundTime = new JLabel("TURNAROUND TIME");
		lblTurnaroundTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnaroundTime.setForeground(Color.GRAY);
		lblTurnaroundTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 22));
		lblTurnaroundTime.setBounds(510, 99, 233, 30);
		panel.add(lblTurnaroundTime);
		
		JLabel[] lblPid = new JLabel[10];
		int yaxis = 128;
		for(int i =0; i<10; i++) {
			lblPid[i] = new JLabel("P" + (i+1));
			lblPid[i].setVisible(false);
			lblPid[i].setForeground(Color.LIGHT_GRAY);
			lblPid[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			lblPid[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblPid[i].setBounds(27, yaxis, 123, 23);
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
			BTinput[i].setBounds(185, yaxis, 150, 23);
			panel.add(BTinput[i]);
			BTinput[i].setColumns(10);
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
			lblWT[i].setBounds(370, yaxis, 123, 23);
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
			lblTT[i].setBounds(560, yaxis, 123, 23);
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
		JPanel[] GC = new JPanel[10];
		int Xaxis = 180;
		for(int i =0; i<10; i++) {
			GC[i] = new JPanel();
			GC[i].setBackground(new Color(127, 255, 0));
			GC[i].setVisible(false);
			GC[i].setBounds(Xaxis, 437, 40, 67);
			panel.add(GC[i]);
			Xaxis = Xaxis+46;
		}
		
		JLabel[] GCPid = new JLabel[10];
		for(int i=0; i<10; i++) {
			GCPid[i] = new JLabel("Pid");
			GC[i].add(GCPid[i]);
			GCPid[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
			GCPid[i].setForeground(SystemColor.windowBorder);
			GCPid[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		JLabel[] timeline = new JLabel[11];
		Xaxis = 154;
		for(int i=0; i<11; i++) {
			timeline[i] = new JLabel("");
			timeline[i].setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 10));
			timeline[i].setHorizontalAlignment(SwingConstants.CENTER);
			timeline[i].setForeground(Color.LIGHT_GRAY);
			timeline[i].setBounds(Xaxis, 508, 46, 14);
			panel.add(timeline[i]);
			Xaxis = Xaxis+46;
		}
		
		/*
		 * 
		 * REAL CODING WORK HERE
		 * 
		 */
		int[] BT = new int[totalP];
		int[] pID = new int[totalP];
		int[] WT = new int[totalP];
		int[] TT = new int[totalP];
		
		//Setting process id
		for(int i=0; i<totalP; i++) {
			pID[i] = i+1;
		}
		
		//Taking BT input after Enter button is pressed
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int totalWT = 0, totalTT = 0;
				int temp=0;
				double avgWT, avgTT;
				
				btnEnter.setEnabled(false);
				
				for(int i=1; i<=10; i++) {
					if(totalP == i) {
						for(int j = 0; j<totalP; j++) {
							BT[j] = Integer.parseInt(BTinput[j].getText());
						}
						break;
					}
				}
				
				//Disabling all text fields
				for(int i=0; i<10; i++) {
					BTinput[i].setEnabled(false);
				}
				

				//calculating wait time & turnaround time
				WT[0] = 0;
				TT[0] = WT[0] + BT[0];
				for(int i=1; i<totalP; i++) {
					WT[i] = TT[i-1];	
					
					TT[i] = WT[i] + BT[i];
				}
				
				//calculating Average wait-time & turnaround-time
				for(int i =0; i<WT.length; i++) {
					totalWT = totalWT + WT[i];
				}
						
				for(int i =0; i<TT.length; i++) {
					totalTT = totalTT + TT[i];
				}
						
				avgWT = (double) totalWT/totalP;
				avgTT = (double) totalTT/totalP;
				
				//Sorting w.r.t Process ID
				for(int i=0; i<totalP; i++) {
					for(int j=1; j<totalP; j++) {
						if(pID[j-1] > pID[j]) 
						{		
							temp = BT[j-1];
							BT[j-1] = BT[j];
							BT[j] = temp;
											
							temp = pID[j-1];
							pID[j-1] = pID[j];
							pID[j] = temp;
							
							temp = WT[j-1];
							WT[j-1] = WT[j];
							WT[j] = temp;
									
							temp = TT[j-1];
							TT[j-1] = TT[j];
							TT[j] = temp;
						}
					}
				}
				
				//Printing/Displaying Wait Time, Turnaround Time, WT avg and TT avg
				lblAVGwtAnswer.setText("" + df2.format(avgWT));
				lblAVGttAnswer.setText("" + df2.format(avgTT));	
				
				for(int i =1; i<=10; i++) {
					if(totalP == i) {
						for(int j =0; j<totalP; j++) {
							lblWT[j].setText("" + WT[j]);
							lblTT[j].setText("" + TT[j]);
						}
						break;
					}
				}
				

				/*
				 * 
				 * 
				 * Now Creating GANTT CHART
				 * 
				 *
				 */
				
				int TimePassed = 0;
				timeline[0].setText("0");
				
				for(int i =0; i<totalP; i++) {
					GC[i].setVisible(true);
					GCPid[i].setText("P" + pID[i]);
					TimePassed = TimePassed + BT[i];
					timeline[i+1].setText("" + TimePassed);
				}

			}
		});
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.setForeground(Color.GRAY);
		btnEnter.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 32));
		btnEnter.setBounds(20, 437, 138, 85);
		panel.add(btnEnter);
	}
}
