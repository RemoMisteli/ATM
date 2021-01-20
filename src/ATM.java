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
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
	private JTextPane pintext;
	private Card card;
	private boolean VisibleAmount = false;
	private boolean VisibleAction = false;
	public static boolean VisiblePin = false;
	private JLabel lblBalance;
	private JLabel lblWithdrawChf;
	private JLabel lblPincode;
	private JLabel lblDeposit;
	private JLabel lblExit;
	private JLabel lblWithdrawEur;
	private JLabel lbl10;
	private JLabel lbl20;
	private JLabel lbl50;
	private JLabel lbl100;
	private JLabel lbl200;
	private JLabel lbl1000;
	private JButton btn10;
	private JButton btn20;
	private JButton btn50;
	private JButton btn100;
	private JButton btn200;
	private JButton btn1000;
	private JButton btnBalance;
	private JButton btnWithdrawChf;
	private JButton btnWithdrawEur;
	private JButton btnDeposit;
	private JButton btnPincode;
	private JButton btnexit;

	private int wrongPin = 0;

	Timer timer = new Timer(5000, (e) -> reset());

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
		setTitle("ATM Gibsso");
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

		/* Welcome screen */
		maintext = new JTextPane();
		maintext.setFont(new Font("Arial", Font.BOLD, 14));
		maintext.setBackground(Color.CYAN);
		maintext.setEditable(false);
		maintext.setText("Welcome to Gibbso Bank, please enter your card.");
		maintext.setBounds(65, 30, 150, 54);
		panel.add(maintext);

		/* PinText screen */
		pintext = new JTextPane();
		pintext.setFont(new Font("Arial", Font.BOLD, 14));
		pintext.setBackground(Color.CYAN);
		pintext.setEditable(false);
		pintext.setText("");
		pintext.setVisible(VisiblePin);
		pintext.setBounds(60, 120, 140, 50);
		panel.add(pintext);
		/* Confirm and Cancel Button */
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

		/* Action Labels */
		lblBalance = new JLabel("Balance");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(244, 24, 46, 14);
		lblBalance.setVisible(VisibleAction);
		panel.add(lblBalance);

		lblWithdrawChf = new JLabel("Withdraw CHF");
		lblWithdrawChf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawChf.setBounds(210, 64, 80, 14);
		lblWithdrawChf.setVisible(VisibleAction);
		panel.add(lblWithdrawChf);

		lblPincode = new JLabel("Change Pin");
		lblPincode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPincode.setBounds(210, 103, 80, 14);
		lblPincode.setVisible(VisibleAction);
		panel.add(lblPincode);

		lblDeposit = new JLabel("Deposit");
		lblDeposit.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeposit.setBounds(10, 24, 46, 14);
		lblDeposit.setVisible(VisibleAction);
		panel.add(lblDeposit);

		lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.LEFT);
		lblExit.setBounds(10, 64, 46, 14);
		lblExit.setVisible(VisibleAction);
		panel.add(lblExit);

		lblWithdrawEur = new JLabel("Withdraw EUR");
		lblWithdrawEur.setHorizontalAlignment(SwingConstants.LEFT);
		lblWithdrawEur.setBounds(10, 102, 80, 14);
		lblWithdrawEur.setVisible(VisibleAction);
		panel.add(lblWithdrawEur);
		/* Amount Labels */
		lbl100 = new JLabel("100");
		lbl100.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl100.setBounds(244, 24, 46, 14);
		lbl100.setVisible(VisibleAmount);
		panel.add(lbl100);

		lbl50 = new JLabel("50");
		lbl50.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl50.setBounds(244, 64, 46, 14);
		lbl50.setVisible(VisibleAmount);
		panel.add(lbl50);

		lbl20 = new JLabel("20");
		lbl20.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl20.setBounds(244, 102, 46, 14);
		lbl20.setVisible(VisibleAmount);
		panel.add(lbl20);

		lbl200 = new JLabel("200");
		lbl200.setHorizontalAlignment(SwingConstants.LEFT);
		lbl200.setBounds(10, 24, 46, 14);
		lbl200.setVisible(VisibleAmount);
		panel.add(lbl200);

		lbl1000 = new JLabel("1000");
		lbl1000.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1000.setBounds(10, 64, 46, 14);
		lbl1000.setVisible(VisibleAmount);
		panel.add(lbl1000);

		lbl10 = new JLabel("10");
		lbl10.setHorizontalAlignment(SwingConstants.LEFT);
		lbl10.setBounds(10, 102, 46, 14);
		lbl10.setVisible(VisibleAmount);
		panel.add(lbl10);

		ATMCard c1 = new ATMCard("name", "vorname", "00000000000000000000000001", "Raifaisen", "0001", "2525", "0000",
				false);
		ATMCard c2 = new ATMCard("name2", "vorname2", "00000000000000000000000002", "Raifaisen", "0001", "2525", "0000",
				false);
		ATMCard c3 = new ATMCard("name3", "vorname3", "00000000000000000000000003", "Raifaisen", "0001", "2525", "0000",
				false);

		ATMCard[] cards = { c1, c2, c3 };

		JComboBox<String> cardList = new JComboBox<String>();// add list of cards

		for (int i = 0; i < cards.length; i++) {
			cardList.addItem(cards[i].toString());

		}
		cardList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});

		cardList.setBounds(10, 200, 70, 20);
		contentPane.add(cardList);

		card = new Card();
		card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					card.setCard(cards[cardList.getSelectedIndex()]);
				} catch (Exception e) {
					System.out.println("No Card Selected");
				}
				/* Pin input */
				if (card.getCard().getIBAN() != null && card.getCard().getCardNumber() != null
						&& !card.getCard().isGespert()) {
					card.moveToTarget(slot.getX() + 10, slot.getY() + 10);
					ATM.VisiblePin = true;
					pintext.setVisible(ATM.VisiblePin);
					maintext.setText("Enter your PIN, and press OK\n");
					pinEntry = "";
					lblCancel.setVisible(true);
					lblOk.setVisible(true);
				}
			}
		});
		/* Number PAD */
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
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "2";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "3";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "4";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "5";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "6";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "7";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "8";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "9";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn9);

		JButton btnBlanc = new JButton("");
		btnPanel.add(btnBlanc);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry += "0";
				pintext.setText(pintext.getText() + "*");
			}
		});
		btnPanel.add(btn0);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinEntry = "";
				pintext.setText("");
			}
		});
		btnC.setBackground(Color.RED);
		btnC.setUI((ButtonUI) BasicButtonUI.createUI(btnC));
		btnPanel.add(btnC);

		/* Amount Buttons */
		btn10 = new JButton("");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "10";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn10.setBounds(128, 24, 47, 28);
		contentPane.add(btn10);

		btn20 = new JButton("");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "20";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn20.setBounds(128, 63, 47, 28);
		contentPane.add(btn20);

		btn50 = new JButton("");
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "50";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn50.setBounds(128, 103, 47, 28);
		contentPane.add(btn50);

		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnCancel.setBounds(128, 142, 47, 28);
		contentPane.add(btnCancel);

		btn100 = new JButton("");
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "100";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn100.setBounds(495, 24, 47, 28);
		contentPane.add(btn100);

		btn200 = new JButton("");
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "200";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn200.setBounds(495, 63, 47, 28);
		contentPane.add(btn200);

		JButton btn1000 = new JButton("");
		btn1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				amount = "1000";
				maintext.setText("Chosen amount: " + amount);
			}
		});
		btn1000.setBounds(495, 103, 47, 28);
		contentPane.add(btn1000);

		//disable allAmount Buttons
		//stateAmountButtons(false);
		/* Pin Check */
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblOk.isVisible())
					return;
				if (pinEntry.compareTo(card.getCard().getPin()) == 0) {
					wrongPin = 0;
					if (amount.length() > 0) {// pin check
						// an amount was chosen, eject note
						System.out.println("Ejecting amount: " + amount);
						banknote.animate(amount);
						timer.start();
					} else {
						System.out.println("PIN Ok");
						maintext.setText("Choose action and press Ok.");
						disablePinText(false);
						System.out.println("disabled");
						stateVisibleActions(true);
						System.out.println("davai");
						amount = "";
					}
				} else {
					wrongPin++;
					if (wrongPin == 3) {
						card.getCard().karteSperren();

						System.err.println("karte gespert");
						// Remove card out of card list
					}
					System.err.println("Wrong PIN");
					maintext.setText("PIN was incorrect. Try again.");
					pinEntry = "";
				}

			}
		});
		/** Styling */
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
		/* Logo */
		JLabel lblIdBank = new JLabel("ID Bank");
		lblIdBank.setIcon(new ImageIcon(getClass().getResource("logo.png")));
		lblIdBank.setHorizontalAlignment(SwingConstants.RIGHT);
		// lblIdBank.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		GroupLayout gl_background = new GroupLayout(background);
		gl_background.setHorizontalGroup(gl_background.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_background.createSequentialGroup().addContainerGap()
						.addComponent(lblIdBank, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(349, Short.MAX_VALUE)));
		gl_background.setVerticalGroup(gl_background.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_background.createSequentialGroup().addContainerGap(343, Short.MAX_VALUE)
						.addComponent(lblIdBank, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		background.setLayout(gl_background);
	}

	public void reset() {
		// Two lines of code that clear the variables pinEntry and amount.
		pinEntry = "";
		amount = "";
		pintext.setText("");
		stateVisibleActions(false);
		VisibleAction = false;
		VisibleAmount = false;

		// A line that makes the banknote invisible again, using setVisible(false)
		// method.
		banknote.setVisible(false);
		// A line that sets the card to the original location and gives original
		// dimensions.
		// For this, look for the definition of the card (in the constructor) and copy
		// the line using the setBounds(...) method.
		card.setBounds(10, 245, 60, 90);
		// A line that sets the original welcome text to maintext.
		maintext.setText("Welcome to Gibbso Bank, please enter your card.");
		timer.stop();
	}

	public void stateVisibleActions(boolean status) {
		lblBalance.setVisible(status);
		lblDeposit.setVisible(status);
		lblPincode.setVisible(status);
		lblExit.setVisible(status);
		lblWithdrawChf.setVisible(status);
		lblWithdrawEur.setVisible(status);

	}

	public void stateAmountButtons(boolean status) {
		btn10.setEnabled(status);
		btn20.setEnabled(status);
		btn50.setEnabled(status);
		btn100.setEnabled(status);
		btn200.setEnabled(status);
		btn1000.setEnabled(status);
	}

	public void disablePinText(boolean status) {
		// VisiblePin=false;
		pintext.setVisible(status);
	}

	/*
	 * public void disableAmounts(boolean status) { lblBalance.setVisible(status);
	 * lblDeposit.setVisible(status); lblPincode.setVisible(status);
	 * lblexit.setVisible(status); lblWithdrawChf.setVisible(status);
	 * lblWithdrawEur.setVisible(status);
	 * 
	 * }
	 */
	public void exitButton() {
		System.exit(1);
	}
}
