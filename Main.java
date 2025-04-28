import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

        JLabel projectpathLabel = new JLabel("Project Path:");
        projectpathLabel.setSize(500,500);
        projectpathLabel.setLocation(230,-70);
        projectpathLabel.setForeground(Color.white);
        mainPanel.add(projectpathLabel);

        JTextField projectpathfield = new JTextField();
        projectpathfield.setBounds(330, 155, 175, 50);
        mainPanel.add(projectpathfield);

        JLabel tokenLabel = new JLabel("Token:");
        tokenLabel.setSize(500,500);
        tokenLabel.setLocation(230,5);
        tokenLabel.setForeground(Color.white);
        mainPanel.add(tokenLabel);

        JTextField tokenfield = new JTextField();
        tokenfield.setBounds(330, 230, 175, 50);
        mainPanel.add(tokenfield);
        
                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100,50);
                submitButton.setLocation(345,345);
        
                submitButton.addActionListener(new ActionListener(){
        
                public void actionPerformed(ActionEvent e){
                    System.out.println(projectpathfield.getText());
                    System.out.println(tokenfield.getText());
                    String projecttextSubmitted = projectpathfield.getText();
                    String tokenfieldtextSubmitted = tokenfield.getText();
                    
                    
                }
                });
                mainPanel.add(submitButton);
        
                frame.setContentPane(mainPanel);
        
                frame.setVisible(true);
        
                
            }
        
            private static void add(JTextField projectpathfield) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'add'");
            }
}