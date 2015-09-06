package scenes;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class UsersMenu extends JFrame {
	AdminEditInfo AEI;
	AccountEditInfo AcEI;
	CardEditInfo CaEI;
	CustomerEditInfo CEI;
	ABMachine ABM;
	JLabel lblLblimg;
	public UsersMenu() {
		setResizable(false);
		AEI = new AdminEditInfo();
		AcEI = new AccountEditInfo();
		CaEI = new CardEditInfo();
		CEI = new CustomerEditInfo();
		ABM = new ABMachine();
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 220, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAutomatedBankingMachine = new JButton("Automated Banking Machine");
		btnAutomatedBankingMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAutomatedBankingMachineActionPerformed(evt);
			}
		});
		btnAutomatedBankingMachine.setBounds(10, 195, 200, 23);
		panel.add(btnAutomatedBankingMachine);
		
		JButton btnAccountsManager = new JButton("Accounts Manager");
		btnAccountsManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAccountsManagerActionPerformed(evt);
			}
		});
		btnAccountsManager.setBounds(10, 45, 200, 23);
		panel.add(btnAccountsManager);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		btnExit.setBounds(10, 228, 200, 23);
		panel.add(btnExit);
		
		JButton btnCustomersManager = new JButton("Customers Manager");
		btnCustomersManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCustomersManagerActionPerformed(evt);
			}
		});
		btnCustomersManager.setBounds(10, 11, 200, 23);
		panel.add(btnCustomersManager);
		
		JButton btnCardsManager = new JButton("Cards Manager");
		btnCardsManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCardsManagerActionPerformed(evt);
			}
		});
		btnCardsManager.setBounds(10, 79, 200, 23);
		panel.add(btnCardsManager);
		
		JButton btnStaffManager = new JButton("Staff Manager");
		btnStaffManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnStaffManagerActionPerformed(evt);
			}
		});
		btnStaffManager.setBounds(10, 113, 200, 23);
		panel.add(btnStaffManager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 0, 274, 262);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblLblimg = new JLabel("");
		lblLblimg.setIcon(new ImageIcon(UsersMenu.class.getResource("/img/Teaser.png")));
		lblLblimg.setBounds(10, 11, 254, 251);
		panel_1.add(lblLblimg);
	}
	
	private void btnExitActionPerformed(java.awt.event.ActionEvent evt){
		this.setVisible(false);
		this.dispose();
	}
	
	private void btnCustomersManagerActionPerformed(java.awt.event.ActionEvent evt){
		if (!CEI.isVisible()){
			CEI = new CustomerEditInfo();			
			CEI.run();
		} else {
			CEI.setVisible(false);
			CEI.dispose();
		}
		}
		
	private void btnAccountsManagerActionPerformed(java.awt.event.ActionEvent evt){
		if (!AcEI.isVisible()){
			AcEI = new AccountEditInfo();
			AcEI.run();
		} else {
			AcEI.setVisible(false);
			AcEI.dispose();
		}
		}
	
	private void btnCardsManagerActionPerformed(java.awt.event.ActionEvent evt){
		if (!CaEI.isVisible()){
			CaEI = new CardEditInfo();
			CaEI.run();
		} else {
			CaEI.setVisible(false);
			CaEI.dispose();
		}
		}
	
	private void btnStaffManagerActionPerformed(java.awt.event.ActionEvent evt){
		if (!AEI.isVisible()){
			AEI = new AdminEditInfo();
			AEI.run();
		} else {
			AEI.setVisible(false);
			AEI.dispose();
		}
		}
	
	private void btnAutomatedBankingMachineActionPerformed(java.awt.event.ActionEvent evt){
		if (!ABM.isVisible()){
			ABM = new ABMachine();
			ABM.run();
		} else {
			ABM.setVisible(false);
			ABM.dispose();
		}
	}
	
	
	public void run(){
		this.setSize(500, 300);
		this.setVisible(true);
	}
}
