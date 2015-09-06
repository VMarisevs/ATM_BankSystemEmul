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

import classes.PrivateConnections;
import classes.Staff;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AdminEditInfo extends JFrame {
	// creating connection
	PrivateConnections newConnection = new PrivateConnections();
			
	// creating array list of staff members
	ArrayList<Staff> varStaff = new ArrayList<Staff>();
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
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JComboBox cbCity;
	private JComboBox cbGender;
	private JCheckBox chckbxAdmin;
	private JList personList;
	
	public void run(){
		this.setSize(820, 520);
		this.setVisible(true);
	}
	
	public void FillInformation(Staff xStaff){
		txtID.setText(""+xStaff.getDBID());
		txtPPS.setText(xStaff.getPPSNumber());
		txtFirstname.setText(xStaff.getFirstName());
		txtLastname.setText(xStaff.getLastName());
		txtAddress.setText(xStaff.getAddress());
		txtPhone.setText(xStaff.getPhone());
		txtDOB.setText(xStaff.getDateOfBirth());
		txtEmail.setText(xStaff.getEmail());
		txtLogin.setText(xStaff.getLogin());
		txtPassword.setText(xStaff.getPassword());
			
		// Gender combo box changes
		int gender =0;
			if (xStaff.getGender()){
				gender = 1;
			}
		cbGender.setSelectedIndex(gender);
		
		// City combo box changes
		
		cbCity.setModel(new DefaultComboBoxModel(new String[] {"", "Abbeyleix", "Achill Island", "Adare", "Ahakista", "Aherlow", "Aldergrove", "Aran Islands", "Ardara", "Ardmore", "Arklow", "Armagh", "Athlone", "Athy", "Ballina", "Ballinafad", "Ballinasloe", "Ballybofey", "Ballybunnion", "Ballyconneely", "Ballyconnell", "Ballycotton", "Ballylickey", "Ballyliffin", "Ballymacarbry", "Ballymena", "Ballyshannon", "Ballyvaughan", "Banagher", "Bandon", "Banteer", "Bantry", "Belfast", "Belturbet", "Birr", "Blackrock", "Blarney", "Blessington", "Boyle", "Bray", "Bunclody", "Buncrana", "Bundoran", "Bunratty", "Bushmills", "Caherdaniel", "Cahir/Caher", "Cappoquin", "Caragh Lake", "Carlingford", "Carlow", "Carrick-on-Shan", "Carrick-on-Suir", "Carrickmacross", "Cashel", "Cashel Bay", "Castlebaldwin", "Castlebar", "Castleblaney", "Castledermot", "Cavan", "Clifden", "Clonakilty", "Clondalkin", "Clones", "Clonmel", "Cobh", "Coleraine", "Cong", "Cork City", "Courtown Harbour", "Crossmolina", "Dalkey", "Derry", "Dingle", "Donegal", "Doolin", "Drogheda", "Dublin", "Dun Laoghaire", "Dunadry", "Dundalk", "Dundrum", "Dunfanaghy", "Dungarvan", "Dunlavin", "Dunmanway", "Durrus", "Ennis", "Enniscorthy", "Enniskillen", "Ennistymon", "Fahan", "Fermoy", "Furbo", "Galway City", "Glandore", "Glendalough", "Glengarriff", "Gorey", "Gougane Barra", "Greystones", "Hillsborough", "Holywood", "Howth", "Innishannon", "Kanturk", "Kenmare", "Kilkee", "Kilkenny", "Killaloe", "Killarney", "Killiney", "Killybegs", "Kilrush", "Kilternan", "Kinsale", "Knock", "Lahinch", "Larne", "Leenane", "Letterfrack", "Letterkenny", "Limerick City", "Lisdoonvarna", "Longford", "Lucan", "Macroom", "Malahide", "Mallow", "Maynooth", "Midleton", "Moycullen", "Mullinavat", "Mullingar", "Navan", "New Ross", "Newbridge", "Newcastle", "Newmarket", "Newport", "Oughterard", "Parknasilla", "Portlaoise", "Portmarnock", "Portrush", "Rathlin Island", "Rathmullan", "Rathnew", "Recess", "Renvyle", "Rosapenna", "Roscommon", "Rosslare", "Rosslare Europort", "Rossnowlagh", "Roundstone", "Shanagarry", "Shankill", "Shannon", "Skibbereen", "Skull", "Slane", "Sligo", "Spiddal", "Stillorgan", "Strabane", "Straffan", "Tahilla", "Templeglantine", "Thomastown", "Tipperary", "Tralee", "Tramore", "Virginia", "Waterford City", "Waterville", "Westport", "Wexford", "Wicklow", "Youghal"}));
		cbCity.setSelectedIndex(xStaff.getCityID());
		
		chckbxAdmin.setSelected(xStaff.getAdmin());;
	}
	
	
	

	AdminEditInfo(){
		setResizable(false);
					
		// assigning variable staff 
		varStaff = newConnection.getListOfStaff();
		
		/*
		 * 
		 * */
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(106, 100, 170, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPPS = new JTextField();
		txtPPS.setBounds(106, 131, 170, 20);
		panel.add(txtPPS);
		txtPPS.setColumns(10);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(106, 162, 170, 20);
		panel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(106, 193, 170, 20);
		panel.add(txtLastname);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(106, 224, 170, 20);
		panel.add(txtAddress);
		
		cbCity = new JComboBox();
		cbCity.setBounds(106, 255, 170, 20);
		panel.add(cbCity);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(380, 100, 133, 20);
		panel.add(txtPhone);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(380, 131, 133, 20);
		panel.add(txtDOB);
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(380, 162, 133, 20);
		panel.add(cbGender);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(380, 198, 133, 20);
		panel.add(txtEmail);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(380, 229, 133, 20);
		panel.add(txtLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(380, 260, 133, 20);
		panel.add(txtPassword);
		
		chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setBounds(380, 290, 133, 23);
		panel.add(chckbxAdmin);
		
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
		lblPhone.setBounds(300, 103, 70, 14);
		panel.add(lblPhone);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(300, 134, 70, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(300, 165, 70, 14);
		panel.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(300, 199, 70, 14);
		panel.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(300, 230, 70, 14);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(300, 263, 70, 14);
		panel.add(lblPassword);
		
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
		btnSave.setBounds(121, 355, 89, 23);
		panel.add(btnSave);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnInsertActionPerformed(evt);
			}
		});
		btnInsert.setBounds(230, 355, 89, 23);
		panel.add(btnInsert);
	
		// my Code
		lstBox.clear();
		for (int i=0; i < varStaff.size(); i++){  
	         lstBox.addElement(varStaff.get(i).getFirstName() + " " + varStaff.get(i).getLastName());
	    }
		
		
		// end my Code
		
	}
	
	// events
	 private void personListValueChanged(javax.swing.event.ListSelectionEvent evt){
		 FillInformation(varStaff.get(personList.getSelectedIndex()));
	 }
	 
	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt){
			if (!(personList.isSelectionEmpty())){
				// saving to array list first
				varStaff.get(personList.getSelectedIndex()).setPPSNumber(txtPPS.getText())
															.setFirstName(txtFirstname.getText())
															.setLastName(txtLastname.getText())
															.setAddress(txtAddress.getText())
															.setPhone(txtPhone.getText())
															.setDateOfBirth(txtDOB.getText())
															.setEmail(txtEmail.getText())
															.setCity(""+cbCity.getSelectedIndex())
															.setGender(""+cbGender.getSelectedIndex());
				varStaff.get(personList.getSelectedIndex()).setPassword(txtPassword.getText())
															.setLogin(txtLogin.getText())
															.setAdmin(chckbxAdmin.isSelected());
				
				newConnection.saveStaff(varStaff.get(personList.getSelectedIndex()));
				
				//int id = personList.getSelectedIndex();
				//lstBox.removeAllElements();
				//for (int i=0; i < varStaff.size(); i++){  
			    //   lstBox.addElement(varStaff.get(i).getFirstName() + " " + varStaff.get(i).getLastName());
			    //}
			}
	}

	private void btnInsertActionPerformed(java.awt.event.ActionEvent evt){
		varStaff.add(new Staff());
		//setting the right id for staff so it could be changed and save it at the same time
		varStaff.get(varStaff.size()-1).setDBID(""+(varStaff.get(varStaff.size()-2).getDBID()+1));
		lstBox.addElement(varStaff.get(varStaff.size()-1).getFirstName() + " " + varStaff.get(varStaff.size()-1).getLastName());
		newConnection.insertStaff();
	}

	
}// end of programm

	

/**
* @author Vladislavs Marisevs
*/