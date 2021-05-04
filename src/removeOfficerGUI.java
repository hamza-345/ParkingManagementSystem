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
 
public class removeOfficerGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel LemailAddress = new JLabel("Email Address");
    JTextField TemailAddress = new JTextField();
    JButton remove = new JButton("Remove Officer");
    
 
 
    removeOfficerGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {

    	LemailAddress.setBounds(50, 290, 100, 30);
        TemailAddress.setBounds(150, 290, 150, 30);
        remove.setBounds(50, 430, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(LemailAddress);
        container.add(TemailAddress);
        container.add(remove);
  
    }
 
    public void addActionEvent() {
        remove.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == remove) {
        	Administrator.removeOfficer(TemailAddress.getText());
        	TemailAddress.setText("");
        }
        
 
        
    }
 
}