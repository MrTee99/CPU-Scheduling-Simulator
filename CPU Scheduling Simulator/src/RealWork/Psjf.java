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

public class Psjf {

	private JFrame frmPsjf;
	public static int totalP;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Psjf window = new Psjf();
					window.frmPsjf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Psjf() {
		initialize();
	}
	
	public Psjf(int totalProcess) {
		totalP = totalProcess;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPsjf = new JFrame();
		frmPsjf.setBounds(100, 100, 771, 626);
		frmPsjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPsjf.setVisible(true);
		frmPsjf.setResizable(false);
		frmPsjf.getContentPane().setBackground(SystemColor.windowBorder);
		frmPsjf.getContentPane().setLayout(null);
		frmPsjf.setLocationRelativeTo(null);
		frmPsjf.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 765, 598);
		frmPsjf.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpuSchedulingSimulator = new JLabel("Preemptive SJF Scheduling");
		lblCpuSchedulingSimulator.setBounds(0, 21, 763, 67);
		lblCpuSchedulingSimulator.setForeground(Color.LIGHT_GRAY);
		lblCpuSchedulingSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuSchedulingSimulator.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 30));
		panel.add(lblCpuSchedulingSimulator);
		
		JLabel lblProcessId = new JLabel("PROCESS ID");
		lblProcessId.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		lblProcessId.setForeground(Color.GRAY);
		lblProcessId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessId.setBounds(0, 99, 123, 18);
		panel.add(lblProcessId);
		
		JLabel lblBurstTime = new JLabel("BURST TIME");
		lblBurstTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurstTime.setForeground(Color.GRAY);
		lblBurstTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		lblBurstTime.setBounds(133, 99, 123, 18);
		panel.add(lblBurstTime);
		
		JLabel lblWaitTime = new JLabel("WAIT TIME");
		lblWaitTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitTime.setForeground(Color.GRAY);
		lblWaitTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		lblWaitTime.setBounds(426, 99, 123, 18);
		panel.add(lblWaitTime);
		
		JLabel lblTurnaroundTime = new JLabel("TURNAROUND TIME");
		lblTurnaroundTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnaroundTime.setForeground(Color.GRAY);
		lblTurnaroundTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		lblTurnaroundTime.setBounds(559, 99, 204, 18);
		panel.add(lblTurnaroundTime);
		
		JLabel lblArrivalTime = new JLabel("ARRIVAL TIME");
		lblArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrivalTime.setForeground(Color.GRAY);
		lblArrivalTime.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		lblArrivalTime.setBounds(266, 99, 150, 18);
		panel.add(lblArrivalTime);
		
		JLabel[] lblPid = new JLabel[10];
		int yaxis = 128;
		for(int i =0; i<10; i++) {
			lblPid[i] = new JLabel("P" + (i+1));
			lblPid[i].setVisible(false);
			lblPid[i].setForeground(Color.LIGHT_GRAY);
			lblPid[i].setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
			lblPid[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblPid[i].setBounds(8, yaxis, 123, 23);
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
			BTinput[i].setBounds(135, yaxis, 123, 23);
			panel.add(BTinput[i]);
			BTinput[i].setColumns(10);
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
			ATinput[i].setBounds(280, yaxis, 123, 23);
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
			lblWT[i].setBounds(430, yaxis, 123, 23);
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
		int[] BT = new int[totalP];
		int[] AT = new int[totalP];
		int[] pID = new int[totalP];
		int[] RT = new int[totalP];
		int[] WT = new int[totalP];
		int[] TT = new int[totalP];
		
		//Setting process id
		for(int i=0; i<totalP; i++) {
			pID[i] = i+1;
		}
		
		//Taking BT & AT input after Enter button is pressed
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				int totalBT=0, temp=0;
				int min, premin=totalP-1;
				int totalWT = 0, totalTT = 0;
				double avgWT, avgTT;
						
				btnEnter.setEnabled(false);
						
				for(int i=1; i<=10; i++) {
					if(totalP == i) {
						for(int j = 0; j<totalP; j++) {
							BT[j] = Integer.parseInt(BTinput[j].getText());
							AT[j] = Integer.parseInt(ATinput[j].getText());
							
							totalBT = totalBT + BT[j];
							RT[j] = BT[j];
						}
						break;
					}
				}
						
				//Disabling all text fields
				for(int i=0; i<10; i++) {
					BTinput[i].setEnabled(false);
					ATinput[i].setEnabled(false);
				}
					
				//sorting w.r.t Arrival Time
				for(int i=0; i<totalP; i++) {
					for(int j=1; j<totalP; j++) {
						if(AT[j-1] > AT[j]) 
						{
							temp = AT[j-1];
							AT[j-1] = AT[j];
							AT[j] = temp;
									
							temp = BT[j-1];
							BT[j-1] = BT[j];
							BT[j] = temp;
							
							temp = RT[j-1];
							RT[j-1] = RT[j];
							RT[j] = temp;
									
							temp = pID[j-1];
							pID[j-1] = pID[j];
							pID[j] = temp;
						}
					}
				}
				
				// Assigning default value = -1 to all positions of array
				int[] GCpID = new int[totalBT];
				int[] GCtimeline = new int[totalBT+1];
				
				
				for(int i=0; i<GCtimeline.length; i++) {
					GCtimeline[i] = -1;
					if(i!=(GCtimeline.length-1)) {
						GCpID[i] = -1;
					}
				}
				
				// calculating turnaround time and Gantt chart values
				int k =0;
				for (int i = 0; i <= totalBT; i++) {	
					min = 0;
					for (int j = 0; j<totalP; j++)
					{
						if ((AT[j] <= i) && (RT[j]<RT[min]) && (RT[j] != 0)) 
						{
							min = j;													
						}
					}
					if (premin != min || i == 0)										
					{
						GCpID[k] = pID[min];
						GCtimeline[k] = i;
						k++;
					}
					RT[min]--;															
					if (RT[min] == 0)													
					{
						TT[min] = (i - AT[min]) + 1;										
					}
					premin = min;
				}
				GCtimeline[k] = totalBT;
				
				// calculating Wait Time
				for (int i = 0; i<totalP; i++)
				{
					WT[i] = TT[i] - BT[i];
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
							temp = AT[j-1];
							AT[j-1] = AT[j];
							AT[j] = temp;
							
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
				
				//sorting w.r.t Arrival Time
				for(int i=0; i<totalP; i++) {
					for(int j=1; j<totalP; j++) {
						if(AT[j-1] > AT[j]) 
						{
							temp = AT[j-1];
							AT[j-1] = AT[j];
							AT[j] = temp;
							
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
				
				for(int i =0; i<GCpID.length; i++) {
					if(GCpID[i] != -1) {
						GC[i].setVisible(true);
						GCPid[i].setText("P" + GCpID[i]);
					}
				}
				for(int i =0; i<GCtimeline.length; i++) {
					if(GCtimeline[i] != -1) {
						timeline[i].setText("" + GCtimeline[i]);
					}
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
