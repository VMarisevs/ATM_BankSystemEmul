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

//import classes.Customer;
import classes.Accounts;
import classes.PrivateConnections;
//import classes.Staff;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AccountEditInfo extends JFrame {
	// creating connection
	PrivateConnections newConnection = new PrivateConnections();
			
	// creating array list of accounts and members
	ArrayList<Accounts> varAcoount = new ArrayList<Accounts>();
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
	
	public void run(){
		this.setSize(820, 520);
		this.setVisible(true);
	}
	
	public void FillInformation(Accounts xCustomer){
		txtID.setText(""+xCustomer.getDBID());
		txtPPS.setText(xCustomer.getPPSNumber());
		txtFirstname.setText(xCustomer.getFirstName());
		txtLastname.setText(xCustomer.getLastName());
		txtAddress.setText(xCustomer.getAddress());
		txtPhone.setText(xCustomer.getPhone());
		txtDOB.setText(xCustomer.getDateOfBirth());
		txtEmail.setText(xCustomer.getEmail());
		
		txtAccountNumber.setText(""+xCustomer.getAccountNumber());
		txtOverdraft.setText(""+xCustomer.getOverdraft());
		txtFunds.setText(""+xCustomer.getFunds());
		txtLimit.setText(""+xCustomer.getLimit());
			
		// Gender combo box changes
		int gender =0;
			if (xCustomer.getGender()){
				gender = 1;
			}
		cbGender.setSelectedIndex(gender);
		
		// City combo box changes
		
		cbCity.setModel(new DefaultComboBoxModel(new String[] {"", "Abbeyleix", "Achill Island", "Adare", "Ahakista", "Aherlow", "Aldergrove", "Aran Islands", "Ardara", "Ardmore", "Arklow", "Armagh", "Athlone", "Athy", "Ballina", "Ballinafad", "Ballinasloe", "Ballybofey", "Ballybunnion", "Ballyconneely", "Ballyconnell", "Ballycotton", "Ballylickey", "Ballyliffin", "Ballymacarbry", "Ballymena", "Ballyshannon", "Ballyvaughan", "Banagher", "Bandon", "Banteer", "Bantry", "Belfast", "Belturbet", "Birr", "Blackrock", "Blarney", "Blessington", "Boyle", "Bray", "Bunclody", "Buncrana", "Bundoran", "Bunratty", "Bushmills", "Caherdaniel", "Cahir/Caher", "Cappoquin", "Caragh Lake", "Carlingford", "Carlow", "Carrick-on-Shan", "Carrick-on-Suir", "Carrickmacross", "Cashel", "Cashel Bay", "Castlebaldwin", "Castlebar", "Castleblaney", "Castledermot", "Cavan", "Clifden", "Clonakilty", "Clondalkin", "Clones", "Clonmel", "Cobh", "Coleraine", "Cong", "Cork City", "Courtown Harbour", "Crossmolina", "Dalkey", "Derry", "Dingle", "Donegal", "Doolin", "Drogheda", "Dublin", "Dun Laoghaire", "Dunadry", "Dundalk", "Dundrum", "Dunfanaghy", "Dungarvan", "Dunlavin", "Dunmanway", "Durrus", "Ennis", "Enniscorthy", "Enniskillen", "Ennistymon", "Fahan", "Fermoy", "Furbo", "Galway City", "Glandore", "Glendalough", "Glengarriff", "Gorey", "Gougane Barra", "Greystones", "Hillsborough", "Holywood", "Howth", "Innishannon", "Kanturk", "Kenmare", "Kilkee", "Kilkenny", "Killaloe", "Killarney", "Killiney", "Killybegs", "Kilrush", "Kilternan", "Kinsale", "Knock", "Lahinch", "Larne", "Leenane", "Letterfrack", "Letterkenny", "Limerick City", "Lisdoonvarna", "Longford", "Lucan", "Macroom", "Malahide", "Mallow", "Maynooth", "Midleton", "Moycullen", "Mullinavat", "Mullingar", "Navan", "New Ross", "Newbridge", "Newcastle", "Newmarket", "Newport", "Oughterard", "Parknasilla", "Portlaoise", "Portmarnock", "Portrush", "Rathlin Island", "Rathmullan", "Rathnew", "Recess", "Renvyle", "Rosapenna", "Roscommon", "Rosslare", "Rosslare Europort", "Rossnowlagh", "Roundstone", "Shanagarry", "Shankill", "Shannon", "Skibbereen", "Skull", "Slane", "Sligo", "Spiddal", "Stillorgan", "Strabane", "Straffan", "Tahilla", "Templeglantine", "Thomastown", "Tipperary", "Tralee", "Tramore", "Virginia", "Waterford City", "Waterville", "Westport", "Wexford", "Wicklow", "Youghal"}));
		cbCity.setSelectedIndex(xCustomer.getCityID());
		
	}
	
	
	

	AccountEditInfo(){
		setResizable(false);
					
		// assigning variable customer 
		varAcoount = newConnection.getListOfAccounts();
		
		/*
		 * 
		 * */
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setEnabled(false);
		txtAccountNumber.setEditable(false);
		txtAccountNumber.setBounds(394, 100, 86, 20);
		panel.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtOverdraft = new JTextField();
		txtOverdraft.setBounds(394, 131, 86, 20);
		panel.add(txtOverdraft);
		txtOverdraft.setColumns(10);
		
		txtFunds = new JTextField();
		txtFunds.setBounds(394, 162, 86, 20);
		panel.add(txtFunds);
		txtFunds.setColumns(10);
		
		txtLimit = new JTextField();
		txtLimit.setBounds(394, 193, 86, 20);
		panel.add(txtLimit);
		txtLimit.setColumns(10);
		
		txtID = new JTextField();
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
		lblId.setBounds(27, 103, 69, 14);
		panel.add(lblId);
		
		JLabel lblPps = new JLabel("PPS:");
		lblPps.setBounds(27, 134, 69, 14);
		panel.add(lblPps);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(27, 165, 69, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(27, 196, 69, 14);
		panel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(27, 227, 69, 14);
		panel.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(27, 260, 69, 14);
		panel.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(27, 289, 70, 14);
		panel.add(lblPhone);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(27, 320, 70, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(27, 351, 70, 14);
		panel.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 385, 70, 14);
		panel.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(554, 11, 220, 440);
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
		lblAccountNumber.setBounds(286, 100, 98, 17);
		panel.add(lblAccountNumber);
		
		JLabel lblOverdraft = new JLabel("Overdraft Limit:");
		lblOverdraft.setBounds(286, 134, 98, 17);
		panel.add(lblOverdraft);
		
		JLabel lblFunds = new JLabel("Funds:");
		lblFunds.setBounds(286, 165, 98, 17);
		panel.add(lblFunds);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setBounds(286, 196, 98, 17);
		panel.add(lblLimit);
	
		// my Code
		lstBox.clear();
		for (int i=0; i < varAcoount.size(); i++){  
	         lstBox.addElement(varAcoount.get(i).getAccountNumber() + " " +varAcoount.get(i).getFirstName() + " " + varAcoount.get(i).getLastName());
	    }
		
		
		// end my Code
		
	}
	
	// events
	 private void personListValueChanged(javax.swing.event.ListSelectionEvent evt){
		 FillInformation(varAcoount.get(personList.getSelectedIndex()));
	 }
	 
	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt){
			if (!(personList.isSelectionEmpty())){
				// saving to array list first
				varAcoount.get(personList.getSelectedIndex()).setOverdraft(txtOverdraft.getText())
															.setFunds(txtFunds.getText())
															.setLimit(txtLimit.getText())
															.setDBID(txtID.getText());

				
				
				newConnection.saveAccounts(varAcoount.get(personList.getSelectedIndex()));;
				//int id = personList.getSelectedIndex();
				//lstBox.removeAllElements();
				//for (int i=0; i < varStaff.size(); i++){  
			    //   lstBox.addElement(varStaff.get(i).getFirstName() + " " + varStaff.get(i).getLastName());
			    //}
			}
	}

	private void btnInsertActionPerformed(java.awt.event.ActionEvent evt){
		
		
		varAcoount.add(new Accounts());
		//setting the right id for account so it could be changed and save it at the same time
		varAcoount.get(varAcoount.size()-1).setAccountNumber(""+(varAcoount.get(varAcoount.size()-2).getAccountNumber()+1));
		lstBox.addElement(varAcoount.get(varAcoount.size()-1).getAccountNumber() + " " + varAcoount.get(varAcoount.size()-1).getFirstName() + " " + varAcoount.get(varAcoount.size()-1).getLastName());
		newConnection.insertAccount();
	}
}// end of programm

	

/**
* @author Vladislavs Marisevs
*/