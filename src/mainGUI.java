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
 
public class mainGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel Luser = new JLabel("Email Address");
    JLabel Lpassword = new JLabel("Password");
    JTextField Tuser = new JTextField();
    JPasswordField Tpassword = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton register = new JButton("Register");
    
 
 
    mainGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public JTextField getTuser() {
		return Tuser;
	}

	public void setTuser(JTextField tuser) {
		Tuser = tuser;
	}

	public JPasswordField getTpassword() {
		return Tpassword;
	}

	public void setTpassword(JPasswordField tpassword) {
		Tpassword = tpassword;
	}

	public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        Luser.setBounds(50, 150, 100, 30);
        Lpassword.setBounds(50, 220, 100, 30);
        Tuser.setBounds(150, 150, 150, 30);
        Tpassword.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        register.setBounds(200, 300, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(Luser);
        container.add(Lpassword);
        container.add(Tuser);
        container.add(Tpassword);
        container.add(loginButton);
        container.add(register);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        register.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == loginButton) {
            String user;
            String Password;
            user = Tuser.getText();
            Password = Tpassword.getText();
            
			if (User.exists(user, Password).equals("admin")) {
            	 AdministratorGUI frame = new AdministratorGUI();
                 frame.setTitle("AdministratorGUI");
                 frame.setVisible(true);
                 frame.setBounds(10, 10, 370, 600);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setResizable(false);
            } 
            else if (User.exists(user, Password).equals("customer")){
            	customerGUI frame = new customerGUI(user);
                frame.setTitle("customerGUI");
                frame.setVisible(true);
                frame.setBounds(10, 10, 370, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
           }
            else if (User.exists(user, Password).equals("officer")) {
            	officerGUI frame = new officerGUI();
                frame.setTitle("customerGUI");
                frame.setVisible(true);
                frame.setBounds(10, 10, 370, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
           }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }
 
        if (e.getSource() == register) {
        	registerGUI frame = new registerGUI();
            frame.setTitle("registerGUI");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            Tuser.setText("");
            Tpassword.setText("");
        }
    }
 
}
 
 