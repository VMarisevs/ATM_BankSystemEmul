package scenes;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import classes.PrivateConnections;
import classes.Cards;
import javax.swing.SwingConstants;

public class ABMachine extends JFrame {
	private JTextField txtCardN;
	private JLabel CreditCard;
	private JButton btnCard;
	JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	JButton btnl1,btnl2,btnl3,btnl4,btnr1,btnr2,btnr3,btnr4;
	JLabel lblFundsAvailable;
	
	Cards varCard;
	private int scenario;
	private String pin;
	private String differentAmount;
	JLabel ATM;
	private PrivateConnections newConnection;
	
	public ABMachine() {
		setResizable(false);
		scenario =0;
		pin = new String();
		differentAmount = new String();
		varCard = new Cards();
		// 0 no card inside
		// 1 enter pin first digit
		// 2 enter pin second digit
		// 3 enter pin third digit
		// 4 enter pin fourth digit
		// 5 choose menu
		// 6 another transaction
		// 7 funds on the screen
		// 8 select amount cash with receipt
		// 9 select amount cash without receipt
		// 10 different Amount with receipt
		// 11 different Amount without receipt
		// 12 overdraft limit
		// 13 print mini statement
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnCard = new JButton("");
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCardActionPerformed(evt);
			}
		});
		btnCard.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnCard.png")));
		btnCard.setBounds(284, 316, 66, 20);
		panel.add(btnCard);
		
		JLabel lblCard = new JLabel("");
		lblCard.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnCard1.png")));
		lblCard.setBounds(284, 316, 66, 20);
		panel.add(lblCard);
		
		btn0 = new JButton("");
		btn0.setToolTipText("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn0);
			}
		});
		btn0.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn0.png")));
		btn0.setBounds(164, 407, 22, 14);
		panel.add(btn0);
		

		
		btn1 = new JButton("");
		btn1.setToolTipText("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn1);
			}
		});
		btn1.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn1.png")));
		btn1.setBounds(142, 359, 22, 14);
		panel.add(btn1);
		
		btn2 = new JButton("");
		btn2.setToolTipText("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn2);
			}
		});
		btn2.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn2.png")));
		btn2.setBounds(168, 359, 22, 14);
		panel.add(btn2);
		
		btn3 = new JButton("");
		btn3.setToolTipText("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				buttonScenario(btn3);
			}
		});
		btn3.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn3.png")));
		btn3.setBounds(191, 359, 22, 14);
		panel.add(btn3);
		
		btn4 = new JButton("");
		btn4.setToolTipText("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn4);
			}
		});
		btn4.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn4.png")));
		btn4.setBounds(142, 375, 22, 14);
		panel.add(btn4);
		
		btn5 = new JButton("");
		btn5.setToolTipText("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn5);
			}
		});
		btn5.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn5.png")));
		btn5.setBounds(166, 375, 22, 14);
		panel.add(btn5);
		
		btn6 = new JButton("");
		btn6.setToolTipText("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn6);
			}
		});
		btn6.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn6.png")));
		btn6.setBounds(191, 375, 22, 14);
		panel.add(btn6);
		
		btn7 = new JButton("");
		btn7.setToolTipText("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn7);
			}
		});
		btn7.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn7.png")));
		btn7.setBounds(142, 391, 22, 14);
		panel.add(btn7);
		
		btn8 = new JButton("");
		btn8.setToolTipText("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn8);
			}
		});
		btn8.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn8.png")));
		btn8.setBounds(165, 391, 22, 14);
		panel.add(btn8);
		
		btn9 = new JButton("");
		btn9.setToolTipText("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonScenario(btn9);
			}
		});
		btn9.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btn9.png")));
		btn9.setBounds(190, 391, 22, 14);
		panel.add(btn9);
		
		btnl1 = new JButton("");
		btnl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnl1);
			}
		});
		btnl1.setToolTipText("a");
		btnl1.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnl1.png")));
		btnl1.setBounds(31, 135, 23, 20);
		panel.add(btnl1);
		
		btnl2 = new JButton("");
		btnl2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnl2);
			}
		});
		btnl2.setToolTipText("b");
		btnl2.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnl2.png")));
		btnl2.setBounds(31, 165, 23, 20);
		panel.add(btnl2);
		
		btnl3 = new JButton("");
		btnl3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnl3);
			}
		});
		btnl3.setToolTipText("c");
		btnl3.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnl3.png")));
		btnl3.setBounds(31, 195, 23, 20);
		panel.add(btnl3);
		
		btnl4 = new JButton("");
		btnl4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnl4);
			}
		});
		btnl4.setToolTipText("d");
		btnl4.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnl4.png")));
		btnl4.setBounds(31, 225, 23, 20);
		panel.add(btnl4);
		
		btnr1 = new JButton("");
		btnr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnr1);
			}
		});
		btnr1.setToolTipText("e");
		btnr1.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnr1.png")));
		btnr1.setBounds(346, 135, 23, 20);
		panel.add(btnr1);
		
		btnr2 = new JButton("");
		btnr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnr2);
			}
		});
		btnr2.setToolTipText("f");
		btnr2.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnr2.png")));
		btnr2.setBounds(346, 165, 23, 20);
		panel.add(btnr2);
		
		btnr3 = new JButton("");
		btnr3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnr3);
			}
		});
		btnr3.setToolTipText("g");
		btnr3.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnr3.png")));
		btnr3.setBounds(346, 195, 23, 20);
		panel.add(btnr3);
		
		btnr4 = new JButton("");
		btnr4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideButtonScenario(btnr4);
			}
		});
		btnr4.setToolTipText("h");
		btnr4.setIcon(new ImageIcon(ABMachine.class.getResource("/imgbtn/btnr4.png")));
		btnr4.setBounds(346, 226, 23, 20);
		panel.add(btnr4);
		
		lblFundsAvailable = new JLabel("");
		lblFundsAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		lblFundsAvailable.setForeground(new Color(2, 254, 32));
		lblFundsAvailable.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFundsAvailable.setBounds(155, 135, 102, 14);
		panel.add(lblFundsAvailable);
		lblFundsAvailable.setVisible(false);
		
		ATM = new JLabel("");
		ATM.setBounds(5, 5, 393, 423);
		ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/insertCard.png")));
		panel.add(ATM);
		
		txtCardN = new JTextField();
		txtCardN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				txtCardNFocusLost(evt);
			}
		});
		txtCardN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				txtCardNKeyTyped(evt);
			}
		});
		//txtCardN.addKeyListener(new KeyAdapter() {});
		txtCardN.setFont(new Font("SansSerif", Font.BOLD, 24));
		txtCardN.setForeground(new Color(255, 250, 240));
		txtCardN.setBackground(UIManager.getColor("textHighlight"));
		txtCardN.setBounds(436, 261, 384, 32);
		panel.add(txtCardN);
		
		CreditCard = new JLabel("");
		CreditCard.setIcon(new ImageIcon(ABMachine.class.getResource("/img/creditCard.png")));
		CreditCard.setBounds(391, 94, 481, 311);
		panel.add(CreditCard);
	}
	
	// closing bug
	private void txtCardNFocusLost(java.awt.event.FocusEvent evt){
		if (txtCardN.getText().length()>=16){
			txtCardN.setText(txtCardN.getText().substring(0, 16));
		}
	}
	
	private void txtCardNKeyTyped(java.awt.event.KeyEvent evt){
		char varCharTyped = evt.getKeyChar();
		
		if(!(Character.isDigit(varCharTyped)) || Character.isISOControl(varCharTyped) || txtCardN.getText().length()>=16){
			evt.consume();
		}
	}
	// end of bug
	
	// card eject method
	public void btnCardActionPerformed(java.awt.event.ActionEvent evt){
		// Hide the card and check for numbers
		// connection that check card number in db
		newConnection = new PrivateConnections();
		if ((txtCardN.getText().length()>=16) && (newConnection.checkCardInDatabase(txtCardN.getText().toString())>1)){
			btnCard.setVisible(false); 
			txtCardN.setVisible(false);
			CreditCard.setVisible(false);
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin0.png")));
			scenario = 1;
			
			varCard.setCardNumber(txtCardN.getText());
			txtCardN.setText("");
		} else if ((txtCardN.getText().length()>=16) && (newConnection.checkCardInDatabase(txtCardN.getText().toString())<=1)) {
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/BlockedCard.png")));
			scenario = 0;
			btnCard.setVisible(true); 
			txtCardN.setVisible(true);
			CreditCard.setVisible(true);
		}
		
	}
	
	public void enterPin(int pinKey){
		pin = pin+pinKey;
		switch (pin.length()){
		case 1:
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin1.png")));
			break;
		case 2:
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin2.png")));
			break;
		case 3: 
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin3.png")));
			break;
		case 4: 
			ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin4.png")));
			break;
		}
			
		if (pin.length()>=4){
			//check the pin and card number
			//System.out.println(pin);
			varCard.setPin(pin);pin = new String();
			if (newConnection.checkCardInDatabase(varCard.getCardNumber()) >1){
			
				if (newConnection.checkCardAndPinInDatabase(varCard.getCardNumber(), varCard.getPin())){
					
					ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/ChooseOption.png")));
					scenario =5;
				} else {
					ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/EnterPin0.png")));
					scenario = 1;
				}
			} else if (newConnection.checkCardInDatabase(varCard.getCardNumber()) == 1) {
				scenario = 0;
				btnCard.setVisible(true); 
				txtCardN.setVisible(true);
				CreditCard.setVisible(true);
				ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/BlockedCard.png")));
			} 
			
		}
	}
	
	public void differentAmount(int amountKey){
		differentAmount = differentAmount + amountKey;
		lblFundsAvailable.setText(differentAmount);
			if(!lblFundsAvailable.isVisible()){
				lblFundsAvailable.setVisible(true);
			}
	}
	
	public void buttonScenario(JButton xButton){
		
		if (scenario == 1) {
			// enter pin scenario
		switch (xButton.getToolTipText().charAt(0)){
									case '0' :
													enterPin(0);
													break;
									case '1' :
													enterPin(1);
													break;
									case '2' :
													enterPin(2);
													break;
									case '3' :
													enterPin(3);
													break;
									case '4' :
													enterPin(4);
													break;
									case '5' :
													enterPin(5);
													break;
									case '6' :
													enterPin(6);
													break;
									case '7' :
													enterPin(7);
													break;
									case '8' :
													enterPin(8);
													break;
									case '9' :
													enterPin(9);
													break;
										}
		}else if (scenario == 10){
			// differentAmount scenario
			switch (xButton.getToolTipText().charAt(0)){
									case '0' :
										differentAmount(0);
													break;
									case '1' :
										differentAmount(1);
													break;
									case '2' :
										differentAmount(2);
													break;
									case '3' :
										differentAmount(3);
													break;
									case '4' :
										differentAmount(4);
													break;
									case '5' :
										differentAmount(5);
													break;
									case '6' :
										differentAmount(6);
													break;
									case '7' :
										differentAmount(7);
													break;
									case '8' :
										differentAmount(8);
													break;
									case '9' :
										differentAmount(9);
													break;
										}
		
		}
	}
	
	public void sideButtonScenario(JButton xButton){
		if (scenario == 5) {
			varCard = newConnection.getCardInfo(varCard);
			switch (xButton.getToolTipText().charAt(0)){
										case 'a' :
														
														break;
										case 'b' :
														//cash with receipt
														scenario = 8;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/AmountScreen.png")));
														break;
										case 'c' :
														//balance on the screen
														//System.out.println(""+varCard.getFunds());
														scenario = 7;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/FundsOnTheScreen.png")));
														lblFundsAvailable.setText(""+varCard.getFunds());
														lblFundsAvailable.setVisible(true);
														break;
										case 'd' :
														//print balance
														System.out.println("\nAccount Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
														System.out.println("Account Balance:\t\t"+varCard.getFunds());
														System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
														System.out.println("Account Number: \t\t"+ varCard.getAccountNumber());
														scenario = 6;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
														break;
										case 'e' :
														
														break;
										case 'f' :
														//cash without receipt
														scenario = 9;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/AmountScreen.png")));
														break;
										case 'g' :
														//print mini statement
															scenario = 13;
															ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OptionNotAvailable.png")));
														break;
										case 'h' :
														//change pin
														scenario = 13;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OptionNotAvailable.png")));
														break;
										
											}
			}
			else if(scenario == 6) {
				// print balance
				switch (xButton.getToolTipText().charAt(0)){
										case 'd' :
											//No => quit
											scenario = 0;
											ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/insertCard.png")));
											varCard = new Cards();
											btnCard.setVisible(true); 
											txtCardN.setVisible(true);
											CreditCard.setVisible(true);
											break;
										case 'h' :
												// Continue,=> stay
											scenario = 5;
											ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/ChooseOption.png")));
											break;	
											
										}
				
			
			} else if (scenario == 7){
				// print balance on the screen
				switch (xButton.getToolTipText().charAt(0)){
							case 'h' :
									// Continue
								scenario = 6;
								lblFundsAvailable.setVisible(false);
								ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
								break;			
				} 
			} else if (scenario == 8) {
				// cash with receipt, select amount
				
				switch (xButton.getToolTipText().charAt(0)){

								case 'b' :
												//10 euro cash
												if ((varCard.getFunds()-10)> -(varCard.getOverdraft())){
													varCard.setFunds(""+(varCard.getFunds()-10));
													newConnection.saveAccounts(varCard);
													scenario = 6;
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
													System.out.println("\nCash widthdraw: \t\t\t10.00");
															
													System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
													System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
													System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
													System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'c' :
												//20 euro cash
												if ((varCard.getFunds()-20)> -(varCard.getOverdraft())){
														varCard.setFunds(""+(varCard.getFunds()-20));
														newConnection.saveAccounts(varCard);
														scenario = 6;
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
														System.out.println("\nCash widthdraw: \t\t\t20.00");
														
														System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
														System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
														System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
														System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'd' :
												//40 euro cash
												if ((varCard.getFunds()-40)> -(varCard.getOverdraft())){
															varCard.setFunds(""+(varCard.getFunds()-40));
															newConnection.saveAccounts(varCard);
															scenario = 6;
															ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
															System.out.println("\nCash widthdraw: \t\t\t40.00");
															
															System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
															System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
															System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
															System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;

								case 'f' :
												//50 euro cash
												if ((varCard.getFunds()-50)> -(varCard.getOverdraft())){
															varCard.setFunds(""+(varCard.getFunds()-50));
															newConnection.saveAccounts(varCard);
															scenario = 6;
															ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
															System.out.println("\nCash widthdraw: \t\t\t50.00");
															
															System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
															System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
															System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
															System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'g' :
												//100 euro cash
												if ((varCard.getFunds()-100)> -(varCard.getOverdraft())){
													varCard.setFunds(""+(varCard.getFunds()-100));
													newConnection.saveAccounts(varCard);
													
													scenario = 6;
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
													System.out.println("\nCash widthdraw: \t\t\t100.00");
													
													System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
													System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
													System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
													System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'h' :
												//different amount
												scenario = 10;
												lblFundsAvailable.setText("");
												differentAmount = "";
												ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/DifferentAmount.png")));
												break;
								
									}
			} else if (scenario == 9) {
				// cash without receipt, select amount
				
				switch (xButton.getToolTipText().charAt(0)){

								case 'b' :
												//10 euro cash
												if ((varCard.getFunds()-10)> -(varCard.getOverdraft())){
													varCard.setFunds(""+(varCard.getFunds()-10));
													newConnection.saveAccounts(varCard);
													scenario = 6;
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));		
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
																						
												break;
								case 'c' :
												//20 euro cash
												if ((varCard.getFunds()-20)> -(varCard.getOverdraft())){
													varCard.setFunds(""+(varCard.getFunds()-20));
													newConnection.saveAccounts(varCard);
													scenario = 6;
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
												} else {
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'd' :
												//40 euro cash
													if ((varCard.getFunds()-40)> -(varCard.getOverdraft())){
																varCard.setFunds(""+(varCard.getFunds()-40));
																newConnection.saveAccounts(varCard);
																scenario = 6;
																ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
													} else {
														scenario = 12;
														lblFundsAvailable.setVisible(false);
														ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
													}
												
												break;

								case 'f' :
												//50 euro cash
												if ((varCard.getFunds()-50)> -(varCard.getOverdraft())){
													varCard.setFunds(""+(varCard.getFunds()-50));
													newConnection.saveAccounts(varCard);
													scenario = 6;
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
												} else{
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'g' :
												//100 euro cash
												if ((varCard.getFunds()-100)> -(varCard.getOverdraft())){
												varCard.setFunds(""+(varCard.getFunds()-100));
												newConnection.saveAccounts(varCard);
												scenario = 6;
												ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
												} else{
													scenario = 12;
													lblFundsAvailable.setVisible(false);
													ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
												}
												
												break;
								case 'h' :
												//different amount
												scenario = 10;
												lblFundsAvailable.setText("");
												differentAmount = "";
												ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/DifferentAmount.png")));
												break;
								
									}
			} else if (scenario == 10){
				// print balance on the screen
				switch (xButton.getToolTipText().charAt(0)){
							case 'h' :
									// Continue different amount with receipt
								if (lblFundsAvailable.getText()!=""){
									if (varCard.getFunds()-Float.parseFloat(lblFundsAvailable.getText())> -(varCard.getOverdraft())) {
										varCard.setFunds(""+(varCard.getFunds()-Float.parseFloat(lblFundsAvailable.getText())));
										newConnection.saveAccounts(varCard);
										System.out.println("\nCash widthdraw: \t\t\t"+ lblFundsAvailable.getText());
										
										System.out.println("Account Holer: \t\t\t" + varCard.getFirstName() + " " + varCard.getLastName());
										System.out.println("Account Balance:\t\t\t"+varCard.getFunds());
										System.out.println("Card Number: \t\t\t" + varCard.getCardNumber());
										System.out.println("Account Number: \t\t\t"+ varCard.getAccountNumber());
										
										lblFundsAvailable.setText("");
										scenario = 6;
										lblFundsAvailable.setVisible(false);
										ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
									} else {
										lblFundsAvailable.setText("");
										scenario = 12;
										lblFundsAvailable.setVisible(false);
										ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
									}
								}
								
								break;			
				} 
			} else if (scenario == 11){
				// print balance on the screen
				switch (xButton.getToolTipText().charAt(0)){
							case 'h' :
									// Continue different amount with receipt
								if (varCard.getFunds()> -(varCard.getOverdraft())){
									varCard.setFunds(""+(varCard.getFunds()-Float.parseFloat(lblFundsAvailable.getText())));
									newConnection.saveAccounts(varCard);
									scenario = 6;
									lblFundsAvailable.setVisible(false);
									ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/anotherTransaction.png")));
								} else {
									lblFundsAvailable.setText("");
									scenario = 12;
									lblFundsAvailable.setVisible(false);
									ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/OverdraftLimit.png")));
								}
								break;			
				} 
			}else if(scenario == 12) {
				// Overdraft limit
				switch (xButton.getToolTipText().charAt(0)){
										case 'd' :
											//No => quit
											scenario = 0;
											ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/insertCard.png")));
											varCard = new Cards();
											btnCard.setVisible(true); 
											txtCardN.setVisible(true);
											CreditCard.setVisible(true);
											break;
										case 'h' :
												// Continue,=> stay
											scenario = 5;
											ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/ChooseOption.png")));
											break;	
											
										}
				
			
			}else if (scenario == 13){
				// print mini statement
				switch (xButton.getToolTipText().charAt(0)){
							case 'h' :
									// Continue
								scenario = 5;
								lblFundsAvailable.setVisible(false);
								ATM.setIcon(new ImageIcon(ABMachine.class.getResource("/img/ChooseOption.png")));
								break;			
				} 
			}
	
	
	
	
	}
	
	public void run(){
		this.setSize(900, 500);
		this.setVisible(true);
	}
}
