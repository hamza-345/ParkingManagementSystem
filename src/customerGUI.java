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
 
public class customerGUI extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JButton book = new JButton("Book Space");
    JButton cancel = new JButton("Cancel Space");
    JButton view = new JButton("View Booking");
    JButton pay = new JButton("Pay");
    String user;
 
    customerGUI(String user) {
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
  
        book.setBounds(150, 150, 150, 30);
        cancel.setBounds(150, 250, 150, 30);
        view.setBounds(150, 350, 150, 30 );
        pay.setBounds(150, 450, 150, 30 );
 
 
    }
 
    public void addComponentsToContainer() {
        
        container.add(book);
        container.add(cancel);
        container.add(view);
        container.add(pay);
    }
 
    public void addActionEvent() {
    	book.addActionListener(this);
        cancel.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == book) {
        	 bookGUI frame = new bookGUI(this.user);
             frame.setTitle("BookGUI");  
             frame.setVisible(true);
             frame.setBounds(10, 10, 370, 600);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setResizable(false);
 
        }
 
        if (e.getSource() == cancel) {
        	cancelSpaceGUI frame = new cancelSpaceGUI();
            frame.setTitle("cancelSpaceGUI");  
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

       }
        
        if (e.getSource() == view) {
            Customer.viewBooking();
        	
        }
        
        if (e.getSource() == pay) {
            
        }
    }
 
}
 
 
