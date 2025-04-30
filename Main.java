import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

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

        JLabel repoLabel = new JLabel("Repo Name:");
        repoLabel.setSize(500,500);
        repoLabel.setLocation(230,-5);
        repoLabel.setForeground(Color.white);
        mainPanel.add(repoLabel);

        JTextField repofield = new JTextField();
        repofield.setBounds(330, 220, 175, 50);
        mainPanel.add(repofield);

        JLabel tokenLabel = new JLabel("Token:");
        tokenLabel.setSize(500,500);
        tokenLabel.setLocation(230,55);
        tokenLabel.setForeground(Color.white);
        mainPanel.add(tokenLabel);

        JTextField tokenfield = new JTextField();
        tokenfield.setBounds(330, 280, 175, 50);
        mainPanel.add(tokenfield);

        LogoPanel logoPanel = new LogoPanel();
        logoPanel.setSize(200,200);
        logoPanel.setLocation(310,50);
        mainPanel.add(logoPanel, BorderLayout.CENTER);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100,50);
        submitButton.setLocation(345,345);
        
                submitButton.addActionListener(new ActionListener(){
        
                public void actionPerformed(ActionEvent e){
                    System.out.println(projectpathfield.getText());
                    System.out.println(tokenfield.getText());
                    System.out.println(repofield.getText());
                    String projecttextSubmitted = projectpathfield.getText();
                    String tokenfieldtextSubmitted = tokenfield.getText();
                    String repotextSubmitted = repofield.getText();
                    createLocalRepo(repofield.getText(), projectpathfield.getText());
                    createGitHubRepo();
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

            //Mock example of Created Repo
            public static void createGitHubRepo(){
                System.out.println("Repo Created.");
            }

            public static void createReadMe(String t, String p){
                String title = "# "+t;
                try (FileWriter fW = new FileWriter(new File(p, "README.md"))) {
                    fW.write(title);
                    System.out.println("README.md has been created.");
                } 
                catch (IOException e) {
                    System.out.println("ERROR: "+e.getMessage());
                }
            }


            public static void createLocalRepo(String name, String path){
                File project = new File(path, name);

                if(!project.exists()){
                    project.mkdirs();
                }
                
                createReadMe(name, path);

                try{
                    ProcessBuilder init = new ProcessBuilder("git", "init");
                    init.directory(project);
                    Process p1 = init.start();
                    p1.waitFor();
                    System.out.println("Git init made in "+project.getAbsolutePath());

                    ProcessBuilder add = new ProcessBuilder("git", "add", ".");
                    add.directory(project);
                    Process p2 = add.start();
                    p2.waitFor();

                    ProcessBuilder commit = new ProcessBuilder("git", "commit", "-m", "Initial commit");
                    commit.directory(project);
                    Process p3 = commit.start();
                    p3.waitFor();
                }
                catch (IOException | InterruptedException e){
                    System.out.println("ERROR: "+e.getMessage());
                }
            }
}