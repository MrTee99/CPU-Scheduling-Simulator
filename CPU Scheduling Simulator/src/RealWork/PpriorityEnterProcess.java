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

public class PpriorityEnterProcess {

	private JFrame frmEnterProcess;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PpriorityEnterProcess window = new PpriorityEnterProcess();
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
	public PpriorityEnterProcess() {
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
		
		JLabel lblNonpreemptiveFcfsScheduling = new JLabel("Preemptive Priority Scheduling");
		lblNonpreemptiveFcfsScheduling.setBounds(0, 21, 378, 33);
		lblNonpreemptiveFcfsScheduling.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonpreemptiveFcfsScheduling.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 23));
		lblNonpreemptiveFcfsScheduling.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNonpreemptiveFcfsScheduling);
		
		JLabel lblEnterTotalNumber = new JLabel("Enter total number of Processes");
		lblEnterTotalNumber.setBounds(0, 55, 378, 33);
		lblEnterTotalNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTotalNumber.setForeground(Color.LIGHT_GRAY);
		lblEnterTotalNumber.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
		panel.add(lblEnterTotalNumber);
		
		JLabel lblInvalidInput = new JLabel("");
		lblInvalidInput.setForeground(new Color(255, 99, 71));
		lblInvalidInput.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 19));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setBounds(0, 108, 378, 20);
		panel.add(lblInvalidInput);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==com.sun.glass.events.KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textField.setBounds(111, 83, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(92, 143, 89, 29);
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
				
				int totalP = Integer.parseInt(textField.getText());
				if (totalP > 0  && totalP <= 10) {
					Ppriority a = new Ppriority(totalP);
					frmEnterProcess.setVisible(false);
				}
				else {
					lblInvalidInput.setText("Invalid Input");
					textField.setText("");
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
