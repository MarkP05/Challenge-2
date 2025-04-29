import java.awt.*;
import javax.swing.*;

public class LogoPanel extends JPanel {
    Image logo;
    int x = 0;
    int y = 0;
    final int WIDTH = 100;
	final int HEIGHT = 100;

    public LogoPanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.LIGHT_GRAY);
		logo = new ImageIcon("logo.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(logo, 40, 0, 100, 100, this);
    }
}
