package RealWork;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class NPrrEnterProcess {

	JFrame frmEnterProcess;
	private JTextField textFieldProcess;
	private JTextField textFieldQT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NPrrEnterProcess window = new NPrrEnterProcess();
					window.frmEnterProcess.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NPrrEnterProcess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnterProcess = new JFrame();
		frmEnterProcess.setBounds(100, 100, 384, 226);
		frmEnterProcess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnterProcess.setVisible(true);
		frmEnterProcess.setResizable(false);
		frmEnterProcess.getContentPane().setBackground(SystemColor.windowBorder);
		frmEnterProcess.getContentPane().setLayout(null);
		frmEnterProcess.setLocationRelativeTo(null);
		frmEnterProcess.setTitle("CPU Scheduling Simulator");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBorder(new MatteBorder(10, 5, 10, 5, (Color) new Color(128, 128, 128)));
		panel.setBounds(0, 0, 378, 198);
		frmEnterProcess.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNonpreemptiveFcfsScheduling = new JLabel("Non-Preemptive Round Robin Scheduling");
		lblNonpreemptiveFcfsScheduling.setBounds(0, 21, 378, 33);
		lblNonpreemptiveFcfsScheduling.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonpreemptiveFcfsScheduling.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 21));
		lblNonpreemptiveFcfsScheduling.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNonpreemptiveFcfsScheduling);
		
		JLabel lblEnterTotalNumber = new JLabel("Enter total number of Processes and Quantum Time");
		lblEnterTotalNumber.setBounds(0, 55, 378, 33);
		lblEnterTotalNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTotalNumber.setForeground(Color.LIGHT_GRAY);
		lblEnterTotalNumber.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 16));
		panel.add(lblEnterTotalNumber);
		
		JLabel lblInvalidInput = new JLabel("");
		lblInvalidInput.setForeground(new Color(255, 99, 71));
		lblInvalidInput.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 19));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setBounds(242, 99, 126, 20);
		panel.add(lblInvalidInput);
		
		textFieldProcess = new JTextField();
		textFieldProcess.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textFieldProcess.setBounds(106, 83, 126, 20);
		panel.add(textFieldProcess);
		textFieldProcess.setColumns(10);
		
		JLabel lblofprocess = new JLabel("No. of P:");
		lblofprocess.setForeground(Color.LIGHT_GRAY);
		lblofprocess.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
		lblofprocess.setBounds(35, 86, 59, 17);
		panel.add(lblofprocess);
		
		JLabel lblQt = new JLabel("QT:");
		lblQt.setForeground(Color.LIGHT_GRAY);
		lblQt.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
		lblQt.setBounds(35, 112, 59, 17);
		panel.add(lblQt);
		
		textFieldQT = new JTextField();
		textFieldQT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textFieldQT.setColumns(10);
		textFieldQT.setBounds(106, 114, 126, 20);
		panel.add(textFieldQT);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(76, 144, 89, 29);
		btnGoBack.setForeground(SystemColor.windowBorder);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmEnterProcess.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 15));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		panel.add(btnGoBack);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int totalP = Integer.parseInt(textFieldProcess.getText());
				int QT = Integer.parseInt(textFieldQT.getText());
				if (textFieldProcess.getText().trim().isEmpty() || textFieldQT.getText().trim().isEmpty()) {
					lblInvalidInput.setText("Invalid Input");
					textFieldProcess.setText("");
				}
				else if (totalP > 0  && totalP <= 10) {
					NPrr a = new NPrr(totalP, QT);
					frmEnterProcess.setVisible(false);
				}
				else {
					lblInvalidInput.setText("Invalid Input");
					textFieldProcess.setText("");
				}
				
			}
		});
		btnEnter.setBounds(191, 143, 89, 29);
		btnEnter.setForeground(SystemColor.windowBorder);
		btnEnter.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 18));
		btnEnter.setBackground(Color.LIGHT_GRAY);
		panel.add(btnEnter);
	}
}
