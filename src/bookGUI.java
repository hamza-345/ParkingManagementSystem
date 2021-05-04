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
 
public class bookGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel LspaceNumber = new JLabel("Space Number");
    JLabel LlicensePlate = new JLabel("License Plate");
    JLabel LtimeHours = new JLabel("How long (hours)");
    JTextField TspaceNumber = new JTextField();
    JTextField TlicensePlate = new JTextField();
    JTextField TtimeHours = new JTextField();
    JButton book = new JButton("Book Space");
    String user;
 
 
    bookGUI(String user) {
    	this.user = user;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {

    	LspaceNumber.setBounds(50, 150, 100, 30);
    	LlicensePlate.setBounds(50, 220, 100, 30);
    	LtimeHours.setBounds(50, 290, 300, 30);
        TspaceNumber.setBounds(150, 150, 150, 30);
        TlicensePlate.setBounds(150, 220, 150, 30);
        TtimeHours.setBounds(150, 300, 150, 30);
        book.setBounds(50, 400, 100, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(LspaceNumber);
        container.add(LlicensePlate);
        container.add(LtimeHours);
        container.add(TspaceNumber);
        container.add(TlicensePlate);
        container.add(TtimeHours);
        container.add(book);
  
    }
 
    public void addActionEvent() {
        book.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == book) {
        	Customer.bookSpace(new Booking(TspaceNumber.getText(), this.user, System.currentTimeMillis() + (Long.parseLong(TtimeHours.getText()) * 3600000), TlicensePlate.getText(), "no", "no"));
        	TspaceNumber.setText("");
        	TtimeHours.setText("");
        	TlicensePlate.setText("");
        }
        
 
        
    }
 
}