import javax.swing.JFrame;

public class main {
    public static void main(String[] a) {
        mainGUI frame = new mainGUI();
        frame.setTitle("MainGUI");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
}
