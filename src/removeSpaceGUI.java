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
 
public class removeSpaceGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel LspaceNumber = new JLabel("Space Number");
    JTextField TspaceNumber = new JTextField();
    JButton remove = new JButton("Remove Space");
    
 
 
    removeSpaceGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {

    	LspaceNumber.setBounds(50, 290, 100, 30);
        TspaceNumber.setBounds(150, 290, 150, 30);
        remove.setBounds(50, 430, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(LspaceNumber);
        container.add(TspaceNumber);
        container.add(remove);
  
    }
 
    public void addActionEvent() {
        remove.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == remove) {
        	Officer.removeSpace(TspaceNumber.getText());
        	TspaceNumber.setText("");
        }
        
 
        
    }
 
}