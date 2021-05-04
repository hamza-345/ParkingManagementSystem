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
 
public class officerGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JButton add = new JButton("Add Space");
    JButton remove = new JButton("Remove Space");
    JButton grant = new JButton("Grant Request");
    JButton cancel = new JButton("Cancel Request");
    
    
 
    officerGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
  
        add.setBounds(150, 150, 150, 30);
        remove.setBounds(150, 250, 150, 30);
        grant.setBounds(150, 350, 150, 30);
        cancel.setBounds(150, 450, 150, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        
        container.add(add);
        container.add(remove);
        container.add(grant);
        container.add(cancel);
    }
 
    public void addActionEvent() {
    	add.addActionListener(this);
    	remove.addActionListener(this);
    	grant.addActionListener(this);
        cancel.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == add) {
        	 addSpaceGUI frame = new addSpaceGUI();
             frame.setTitle("BookGUI");  
             frame.setVisible(true);
             frame.setBounds(10, 10, 370, 600);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setResizable(false);
 
        }
 
        if (e.getSource() == remove) {
        	removeSpaceGUI frame = new removeSpaceGUI();
            frame.setTitle("BookGUI");  
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            
        }
        if (e.getSource() == grant) {
        	grantRequestGUI frame = new grantRequestGUI();
            frame.setTitle("grantRequestGUI");  
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
        if (e.getSource() == cancel) {
        	cancelRequestGUI frame = new cancelRequestGUI();
            frame.setTitle("cancelRequestGUI");  
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
        
    }
 
}
 
 
