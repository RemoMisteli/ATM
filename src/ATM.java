import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JPanel slot;
	
	private String pinEntry = "", amount = "";
	private Banknote banknote;
	private JTextPane maintext;
	private Card card;
	
	Timer timer = new Timer(5000, (e)->reset());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM frame = new ATM();
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
	public ATM() {
		setTitle("ATM prototype");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		banknote = new Banknote();
		banknote.setVisible(false);
		banknote.setBackground(Color.GREEN);
		banknote.setBounds(423, 271, 70, 112);
		contentPane.add(banknote);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.CYAN);
		panel.setBounds(185, 11, 300, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		maintext = new JTextPane();
		maintext.setFont(new Font("Arial", Font.BOLD, 14));
		maintext.setBackground(Color.CYAN);
		maintext.setEditable(false);
		maintext.setText("Welcome to ID Bank, please enter your card.");
		maintext.setBounds(63, 52, 166, 64);
		panel.add(maintext);
		
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.setVisible(false);
		lblCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCancel.setBounds(10, 138, 46, 14);
		panel.add(lblCancel);
		
		JLabel lblOk = new JLabel("Ok");
		lblOk.setVisible(false);
		lblOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOk.setBounds(244, 138, 46, 14);
		panel.add(lblOk);
		
		JLabel lbl100 = new JLabel("100");
		lbl100.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl100.setBounds(244, 24, 46, 14);
		panel.add(lbl100);
		
		JLabel lbl150 = new JLabel("150");
		lbl150.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl150.setBounds(244, 64, 46, 14);
		panel.add(lbl150);
		
		JLabel lbl200 = new JLabel("200");
		lbl200.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl200.setBounds(244, 102, 46, 14);
		panel.add(lbl200);
		
		JLabel lbl20 = new JLabel("20");
		lbl20.setHorizontalAlignment(SwingConstants.LEFT);
		lbl20.setBounds(10, 24, 46, 14);
		panel.add(lbl20);
		
		JLabel lbl50 = new JLabel("50");
		lbl50.setHorizontalAlignment(SwingConstants.LEFT);
		lbl50.setBounds(10, 64, 46, 14);
		panel.add(lbl50);
		
		JLabel lbl70 = new JLabel("70");
		lbl70.setHorizontalAlignment(SwingConstants.LEFT);
		lbl70.setBounds(10, 102, 46, 14);
		panel.add(lbl70);
		
		card = new Card();
		card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.moveToTarget(slot.getX()+10, slot.getY()+10);
				maintext.setText("Enter your PIN, and press OK\n");
				pinEntry = "";
				lblCancel.setVisible(true);
				lblOk.setVisible(true);
			}
		});
		card.setBackground(Color.PINK);
		card.setBounds(10, 245, 60, 90);
		contentPane.add(card);
		
		slot = new JPanel();
		slot.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		slot.setBounds(423, 224, 81, 15);
		contentPane.add(slot);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(203, 212, 198, 123);
		contentPane.add(btnPanel);
		btnPanel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "1";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "2";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "3";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "4";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "5";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "6";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "7";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "8";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "9";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn9);
		
		JButton btnBlanc = new JButton("");
		btnPanel.add(btnBlanc);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "0";
				maintext.setText(maintext.getText()+"*");
			}
		});
		btnPanel.add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry = "";
			}
		});
		btnC.setBackground(Color.RED);
		btnC.setUI((ButtonUI) BasicButtonUI.createUI(btnC));
		btnPanel.add(btnC);
		
		JButton btn20 = new JButton("");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "20";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn20.setBounds(128, 24, 47, 28);
		contentPane.add(btn20);
		
		JButton btn50 = new JButton("");
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "50";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn50.setBounds(128, 63, 47, 28);
		contentPane.add(btn50);
		
		JButton btn70 = new JButton("");
		btn70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "70";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn70.setBounds(128, 103, 47, 28);
		contentPane.add(btn70);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnCancel.setBounds(128, 142, 47, 28);
		contentPane.add(btnCancel);
		
		JButton btn100 = new JButton("");
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "100";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn100.setBounds(495, 24, 47, 28);
		contentPane.add(btn100);
		
		JButton btn150 = new JButton("");
		btn150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "150";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn150.setBounds(495, 63, 47, 28);
		contentPane.add(btn150);
		
		JButton btn200 = new JButton("");
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				amount = "200";
				maintext.setText("Chosen amount: "+amount);
			}
		});
		btn200.setBounds(495, 103, 47, 28);
		contentPane.add(btn200);
		
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible()) return;
				if (pinEntry.compareTo("1234")==0) {
					if (amount.length()>0) {
						// an amount was chosen, eject note
						System.out.println("Ejecting amount: "+amount);
						banknote.animate(amount);
						timer.start();
					}
					else {
						System.out.println("PIN Ok");
						maintext.setText("Choose amount and press Ok.");
						lbl20.setVisible(true);
						lbl50.setVisible(true);
						lbl70.setVisible(true);
						lbl100.setVisible(true);
						lbl150.setVisible(true);
						lbl200.setVisible(true);
						amount = "";
					}
				}
				else {
					System.err.println("Wrong PIN");
					maintext.setText("PIN was incorrect. Try again.");
					pinEntry="";
				}
				
			}
		});
		btnOk.setBounds(495, 142, 47, 28);
		contentPane.add(btnOk);
		
		JPanel outputSlot = new JPanel();
		outputSlot.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		outputSlot.setBounds(411, 265, 93, 15);
		contentPane.add(outputSlot);
		
		JPanel background = new JPanel();
		background.setBackground(SystemColor.activeCaption);
		background.setBounds(108, 0, 458, 408);
		contentPane.add(background);
		
		JLabel lblIdBank = new JLabel("ID Bank");
		lblIdBank.setIcon(new ImageIcon(getClass().getResource("logo.png")));
		lblIdBank.setHorizontalAlignment(SwingConstants.RIGHT);
		//lblIdBank.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		GroupLayout gl_background = new GroupLayout(background);
		gl_background.setHorizontalGroup(
			gl_background.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_background.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdBank, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(349, Short.MAX_VALUE))
		);
		gl_background.setVerticalGroup(
			gl_background.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_background.createSequentialGroup()
					.addContainerGap(343, Short.MAX_VALUE)
					.addComponent(lblIdBank, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		background.setLayout(gl_background);
	}
	
	public void reset() {
		// Two lines of code that clear the variables pinEntry and amount.
		pinEntry=""; amount="";
		// A line that makes the banknote invisible again, using setVisible(false) method.
		banknote.setVisible(false);
		// A line that sets the card to the original location and gives original dimensions.
		// For this, look for the definition of the card (in the constructor) and copy the line using the setBounds(...) method.
		card.setBounds(10, 245, 60, 90);
		// A line that sets the original welcome text to maintext.
		maintext.setText("Welcome to ID Bank, please enter your card.");
		timer.stop();
	}
}
