
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class registerGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel LfirstName = new JLabel("First Name");
    JLabel LlastName = new JLabel("Last Name");
    JLabel LemailAddress = new JLabel("Email Address");
    JLabel Lpassword = new JLabel("Password");
    JTextField TfirstName = new JTextField();
    JTextField TlastName = new JTextField();
    JTextField TemailAddress = new JTextField();
    JTextField Tpassword = new JTextField();
    JButton add = new JButton("Add Customer");
    
 
 
    registerGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	LfirstName .setBounds(50, 150, 100, 30);
    	LlastName .setBounds(50, 220, 100, 30);
    	LemailAddress.setBounds(50, 290, 100, 30);
    	Lpassword.setBounds(50, 360, 100, 30);
    	TfirstName .setBounds(150, 150, 150, 30);
        TlastName.setBounds(150, 220, 150, 30);
        TemailAddress.setBounds(150, 290, 150, 30);
        Tpassword.setBounds(150, 360, 150, 30);
        add.setBounds(50, 430, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(LfirstName);
        container.add(LlastName);
        container.add(LemailAddress);
        container.add(Lpassword);
        container.add(TfirstName);
        container.add(TlastName);
        container.add(TemailAddress);
        container.add(Tpassword);
        container.add(add);
  
    }
 
    public void addActionEvent() {
        add.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == add) {
        	Boolean exists = false;
    		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/users.csv";
    		Customer customer = new Customer(TfirstName.getText(), TlastName.getText(), TemailAddress.getText(), Tpassword.getText());
    		MaintainUser maintain = new MaintainUser();
    		try {
    			maintain.load(path);
    			for(User u: maintain.users){
    				if(u.getEmail().equals(customer.getEmail())) {
    					JOptionPane.showMessageDialog(new Frame(), "User Already Exists!");
    					exists = true;
    					break;
    				}
    			}
    			if(! exists) {
    					maintain.users.add(customer);
    					JOptionPane.showMessageDialog(new Frame(), "User Added!");
    					maintain.update(path);
    				}
    			}
    		catch (Exception e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		}
        	TfirstName.setText("");
        	TlastName.setText("");
        	TemailAddress.setText("");
        	Tpassword.setText("");
        	
        	
        }
 
        
    }
 
}
 
 
