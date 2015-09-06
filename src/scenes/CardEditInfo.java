package scenes;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;


import classes.Cards;
//import classes.Customer;
//import classes.Accounts;
import classes.PrivateConnections;
//import classes.Staff;


import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class CardEditInfo extends JFrame {
	// creating connection
	PrivateConnections newConnection = new PrivateConnections();
			
	// creating array list of accounts and members
	ArrayList<Cards> varCard = new ArrayList<Cards>();
	// creating list model
	DefaultListModel lstBox = new DefaultListModel();
	
	private JTextField txtID;
	private JTextField txtPPS;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDOB;
	private JTextField txtEmail;
	private JComboBox cbCity;
	private JComboBox cbGender;

	private JList personList;
	
	private JTextField txtAccountNumber;
	private JTextField txtOverdraft;
	private JTextField txtFunds;
	private JTextField txtLimit;
	
	private JTextField txtCardID;
	private JTextField txtPin;
	private JTextField txtExpDate;
	private JTextField txtBlock;
	
	public void run(){
		this.setSize(860, 520);
		this.setVisible(true);
	}
	
	public void FillInformation(Cards xCard){
		txtID.setText(""+xCard.getDBID());
		txtPPS.setText(xCard.getPPSNumber());
		txtFirstname.setText(xCard.getFirstName());
		txtLastname.setText(xCard.getLastName());
		txtAddress.setText(xCard.getAddress());
		txtPhone.setText(xCard.getPhone());
		txtDOB.setText(xCard.getDateOfBirth());
		txtEmail.setText(xCard.getEmail());
		
		txtAccountNumber.setText(""+xCard.getAccountNumber());
		txtOverdraft.setText(""+xCard.getOverdraft());
		txtFunds.setText(""+xCard.getFunds());
		txtLimit.setText(""+xCard.getLimit());
		
		txtCardID.setText(xCard.getCardNumber());
		txtPin.setText(xCard.getPin());
		txtExpDate.setText(xCard.getExpDate());
		txtBlock.setText(""+xCard.getBlock());
			
		// Gender combo box changes
		int gender =0;
			if (xCard.getGender()){
				gender = 1;
			}
		cbGender.setSelectedIndex(gender);
		
		// City combo box changes
		
		cbCity.setModel(new DefaultComboBoxModel(new String[] {"", "Abbeyleix", "Achill Island", "Adare", "Ahakista", "Aherlow", "Aldergrove", "Aran Islands", "Ardara", "Ardmore", "Arklow", "Armagh", "Athlone", "Athy", "Ballina", "Ballinafad", "Ballinasloe", "Ballybofey", "Ballybunnion", "Ballyconneely", "Ballyconnell", "Ballycotton", "Ballylickey", "Ballyliffin", "Ballymacarbry", "Ballymena", "Ballyshannon", "Ballyvaughan", "Banagher", "Bandon", "Banteer", "Bantry", "Belfast", "Belturbet", "Birr", "Blackrock", "Blarney", "Blessington", "Boyle", "Bray", "Bunclody", "Buncrana", "Bundoran", "Bunratty", "Bushmills", "Caherdaniel", "Cahir/Caher", "Cappoquin", "Caragh Lake", "Carlingford", "Carlow", "Carrick-on-Shan", "Carrick-on-Suir", "Carrickmacross", "Cashel", "Cashel Bay", "Castlebaldwin", "Castlebar", "Castleblaney", "Castledermot", "Cavan", "Clifden", "Clonakilty", "Clondalkin", "Clones", "Clonmel", "Cobh", "Coleraine", "Cong", "Cork City", "Courtown Harbour", "Crossmolina", "Dalkey", "Derry", "Dingle", "Donegal", "Doolin", "Drogheda", "Dublin", "Dun Laoghaire", "Dunadry", "Dundalk", "Dundrum", "Dunfanaghy", "Dungarvan", "Dunlavin", "Dunmanway", "Durrus", "Ennis", "Enniscorthy", "Enniskillen", "Ennistymon", "Fahan", "Fermoy", "Furbo", "Galway City", "Glandore", "Glendalough", "Glengarriff", "Gorey", "Gougane Barra", "Greystones", "Hillsborough", "Holywood", "Howth", "Innishannon", "Kanturk", "Kenmare", "Kilkee", "Kilkenny", "Killaloe", "Killarney", "Killiney", "Killybegs", "Kilrush", "Kilternan", "Kinsale", "Knock", "Lahinch", "Larne", "Leenane", "Letterfrack", "Letterkenny", "Limerick City", "Lisdoonvarna", "Longford", "Lucan", "Macroom", "Malahide", "Mallow", "Maynooth", "Midleton", "Moycullen", "Mullinavat", "Mullingar", "Navan", "New Ross", "Newbridge", "Newcastle", "Newmarket", "Newport", "Oughterard", "Parknasilla", "Portlaoise", "Portmarnock", "Portrush", "Rathlin Island", "Rathmullan", "Rathnew", "Recess", "Renvyle", "Rosapenna", "Roscommon", "Rosslare", "Rosslare Europort", "Rossnowlagh", "Roundstone", "Shanagarry", "Shankill", "Shannon", "Skibbereen", "Skull", "Slane", "Sligo", "Spiddal", "Stillorgan", "Strabane", "Straffan", "Tahilla", "Templeglantine", "Thomastown", "Tipperary", "Tralee", "Tramore", "Virginia", "Waterford City", "Waterville", "Westport", "Wexford", "Wicklow", "Youghal"}));
		cbCity.setSelectedIndex(xCard.getCityID());
		
	}
	
	
	

	CardEditInfo(){
		setResizable(false);
					
		// assigning variable customer 
		varCard = newConnection.getListOfCards();
		
		/*
		 * 
		 * */
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setBounds(401, 100, 170, 20);
		panel.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtOverdraft = new JTextField();
		txtOverdraft.setEnabled(false);
		txtOverdraft.setEditable(false);
		txtOverdraft.setBounds(457, 286, 114, 20);
		panel.add(txtOverdraft);
		txtOverdraft.setColumns(10);
		
		txtFunds = new JTextField();
		txtFunds.setEnabled(false);
		txtFunds.setEditable(false);
		txtFunds.setBounds(457, 317, 114, 20);
		panel.add(txtFunds);
		txtFunds.setColumns(10);
		
		txtLimit = new JTextField();
		txtLimit.setEnabled(false);
		txtLimit.setEditable(false);
		txtLimit.setBounds(457, 348, 114, 20);
		panel.add(txtLimit);
		txtLimit.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setBounds(106, 100, 170, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPPS = new JTextField();
		txtPPS.setEditable(false);
		txtPPS.setEnabled(false);
		txtPPS.setBounds(106, 131, 170, 20);
		panel.add(txtPPS);
		txtPPS.setColumns(10);
		
		txtFirstname = new JTextField();
		txtFirstname.setEditable(false);
		txtFirstname.setEnabled(false);
		txtFirstname.setBounds(106, 162, 170, 20);
		panel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setEditable(false);
		txtLastname.setEnabled(false);
		txtLastname.setColumns(10);
		txtLastname.setBounds(106, 193, 170, 20);
		panel.add(txtLastname);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setEnabled(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(106, 224, 170, 20);
		panel.add(txtAddress);
		
		cbCity = new JComboBox();
		cbCity.setEnabled(false);
		cbCity.setBounds(106, 255, 170, 20);
		panel.add(cbCity);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(107, 286, 133, 20);
		panel.add(txtPhone);
		
		txtDOB = new JTextField();
		txtDOB.setEditable(false);
		txtDOB.setEnabled(false);
		txtDOB.setColumns(10);
		txtDOB.setBounds(107, 317, 133, 20);
		panel.add(txtDOB);
		
		cbGender = new JComboBox();
		cbGender.setEnabled(false);
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(107, 348, 133, 20);
		panel.add(cbGender);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(107, 384, 133, 20);
		panel.add(txtEmail);
		
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(27, 103, 69, 14);
		panel.add(lblId);
		
		JLabel lblPps = new JLabel("PPS:");
		lblPps.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPps.setBounds(27, 134, 69, 14);
		panel.add(lblPps);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(27, 165, 69, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(27, 196, 69, 14);
		panel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(27, 227, 69, 14);
		panel.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(27, 260, 69, 14);
		panel.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(27, 289, 70, 14);
		panel.add(lblPhone);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setBounds(27, 320, 70, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(27, 351, 70, 14);
		panel.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(27, 385, 70, 14);
		panel.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(605, 11, 220, 440);
		panel.add(scrollPane);
		
		
		
		
		personList =  new javax.swing.JList(lstBox);
		scrollPane.setViewportView(personList);
		personList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				personListValueChanged(evt);
				
			}
		});
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});
		btnSave.setBounds(346, 448, 89, 23);
		panel.add(btnSave);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnInsertActionPerformed(evt);
			}
		});
		btnInsert.setBounds(455, 448, 89, 23);
		panel.add(btnInsert);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountNumber.setBounds(293, 100, 98, 17);
		panel.add(lblAccountNumber);
		
		JLabel lblOverdraft = new JLabel("Overdraft Limit:");
		lblOverdraft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOverdraft.setBounds(349, 289, 98, 17);
		panel.add(lblOverdraft);
		
		JLabel lblFunds = new JLabel("Funds:");
		lblFunds.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFunds.setBounds(349, 320, 98, 17);
		panel.add(lblFunds);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimit.setBounds(349, 351, 98, 17);
		panel.add(lblLimit);
		
		txtCardID = new JTextField();
		txtCardID.setEditable(false);
		txtCardID.setBounds(401, 131, 170, 20);
		panel.add(txtCardID);
		txtCardID.setColumns(10);
		
		JLabel lblCardId = new JLabel("Card ID:");
		lblCardId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCardId.setBounds(328, 128, 63, 20);
		panel.add(lblCardId);
		
		txtPin = new JTextField();
		txtPin.setBounds(401, 162, 170, 20);
		panel.add(txtPin);
		txtPin.setColumns(10);
		
		JLabel lblPinCode = new JLabel("Pin Code:");
		lblPinCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPinCode.setBounds(328, 165, 63, 17);
		panel.add(lblPinCode);
		
		txtExpDate = new JTextField();
		txtExpDate.setBounds(401, 193, 170, 20);
		panel.add(txtExpDate);
		txtExpDate.setColumns(10);
		
		JLabel lblExpireDate = new JLabel("Expire Date:");
		lblExpireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpireDate.setBounds(322, 196, 69, 17);
		panel.add(lblExpireDate);
		
		txtBlock = new JTextField();
		txtBlock.setEnabled(false);
		txtBlock.setEditable(false);
		txtBlock.setBounds(401, 224, 170, 20);
		panel.add(txtBlock);
		txtBlock.setColumns(10);
		
		JLabel lblAttemptsLeft = new JLabel("Attempts left:");
		lblAttemptsLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttemptsLeft.setBounds(315, 224, 76, 20);
		panel.add(lblAttemptsLeft);
		
		JButton btnNewPin = new JButton("New Pin");
		btnNewPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNewPinActionPerformed(evt);
			}
		});
		btnNewPin.setBounds(235, 448, 89, 23);
		panel.add(btnNewPin);
	
		// my Code
		lstBox.clear();
		for (int i=0; i < varCard.size(); i++){  
	         lstBox.addElement(varCard.get(i).getAccountNumber() + "  |  " +varCard.get(i).getFirstName() + " " + varCard.get(i).getLastName()+ " " +varCard.get(i).getCardNumber());
	    }
		
		
		// end my Code
		
	}
	
	// events
	 private void personListValueChanged(javax.swing.event.ListSelectionEvent evt){
		 FillInformation(varCard.get(personList.getSelectedIndex()));
	 }
	 
	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt){
			if (!(personList.isSelectionEmpty())){
				// saving to array list first
				varCard.get(personList.getSelectedIndex()).setPin(txtPin.getText())
															.setExpDate(txtExpDate.getText())
															.setAccountNumber(txtAccountNumber.getText());
															
								
				newConnection.saveCards(varCard.get(personList.getSelectedIndex()));

			}
	}

	private void btnInsertActionPerformed(java.awt.event.ActionEvent evt){
		
		
		varCard.add(new Cards());
		//setting the right id for account so it could be changed and save it at the same time
		varCard.get(varCard.size()-1).setCardNumber2(""+(varCard.get(varCard.size()-2).getCardNumber2()+1));
		lstBox.addElement(varCard.get(varCard.size()-1).getAccountNumber() + " " + varCard.get(varCard.size()-1).getFirstName() + " " + varCard.get(varCard.size()-1).getLastName());
		newConnection.insertCard();
	}
	
	private void btnNewPinActionPerformed(java.awt.event.ActionEvent evt){
		if (!(personList.isSelectionEmpty())){
			// saving to array list first
			varCard.get(personList.getSelectedIndex()).generatePin()
														.setExpDate(txtExpDate.getText())
														.setAccountNumber(txtAccountNumber.getText());
														
			txtPin.setText(varCard.get(personList.getSelectedIndex()).getPin());				
			newConnection.saveCards(varCard.get(personList.getSelectedIndex()));
		}
	}

}// end of programm

	
/**
* @author Vladislavs Marisevs
*/