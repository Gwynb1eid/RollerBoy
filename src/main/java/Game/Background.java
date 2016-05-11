package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background extends JPanel implements ActionListener {

    int dt = 500;
    Timer bgTimer = new Timer(dt, this);

    int x = 470;
    int y = 47;

    Image img = new ImageIcon(getClass().getResource("/houses.png")).getImage();
    Image img2 = new ImageIcon(getClass().getResource("/staticBg.png")).getImage();

    public Background() {
        bgTimer.start();
    }

/*    public void paint (Graphics g) {
        ((Graphics2D) g).drawImage(img2, 0, 0, null);
        ((Graphics2D) g).drawImage(img, layer2, y, null);
    }*/

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
