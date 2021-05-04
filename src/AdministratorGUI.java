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
 
public class AdministratorGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JButton add = new JButton("Add Officer");
    JButton remove = new JButton("Remove Officer");
    JButton status = new JButton("Change Status");
 
    AdministratorGUI() {
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
        status.setBounds(150, 350, 150, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        
        container.add(add);
        container.add(remove);
        container.add(status);
        
    }
 
    public void addActionEvent() {
        add.addActionListener(this);
        remove.addActionListener(this);
        status.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == add) {
        	 addOfficerGUI frame = new addOfficerGUI();
             frame.setTitle("addOfficerGUI");  
             frame.setVisible(true);
             frame.setBounds(10, 10, 370, 600);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setResizable(false);
 
        }
 
        if (e.getSource() == remove) {
        	 removeOfficerGUI frame = new removeOfficerGUI();
             frame.setTitle("removeOfficerGUI");  
             frame.setVisible(true);
             frame.setBounds(10, 10, 370, 600);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setResizable(false);
        }
        if (e.getSource() == status) {
       	 changeStatusGUI frame = new changeStatusGUI();
            frame.setTitle("removeOfficerGUI");  
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
       }
    }
 
}
 
 
