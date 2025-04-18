import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("QBay App");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.lightGray);

        JLabel helloLabel = new JLabel("Welcome to the Button!");
        helloLabel.setSize(500,500);
        helloLabel.setLocation(100,100);
        helloLabel.setForeground(Color.white);
        mainPanel.add(helloLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100,50);
        submitButton.setLocation(345,345);

        submitButton.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e){
            System.out.println("You clicked the button!");
            helloLabel.setText("Goodbye!");
        }
        });
        mainPanel.add(submitButton);

        frame.setContentPane(mainPanel);

        frame.setVisible(true);

        
    }
}