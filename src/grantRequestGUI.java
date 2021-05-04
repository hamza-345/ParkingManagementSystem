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
 
public class grantRequestGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel LbookingID = new JLabel("Booking ID");
    JTextField TbookingID = new JTextField();
    JButton grant = new JButton("Grant Request");
    
 
 
    grantRequestGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {

    	LbookingID.setBounds(50, 290, 100, 30);
        TbookingID.setBounds(150, 290, 150, 30);
        grant.setBounds(50, 430, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(LbookingID);
        container.add(TbookingID);
        container.add(grant);
  
    }
 
    public void addActionEvent() {
        grant.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == grant) {
        	Officer.grantRequest(TbookingID.getText());
        	TbookingID.setText("");
        }
        
 
        
    }
 
}
