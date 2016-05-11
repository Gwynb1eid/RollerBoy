package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    Image imgNorm = new ImageIcon(getClass().getResource("/girl0.png")).getImage();
    Image imgNorm2 = new ImageIcon(getClass().getResource("/girl1.png")).getImage();
    Image imgJump = new ImageIcon(getClass().getResource("/girl3.png")).getImage();

    Image img = imgNorm;

    public static final int MAX_V = 50;
    public int v = 0;
    int dv = 0;
    int s = 0;
    double fallingSpeed = 0.15;

    int x = 0;
    int y = 250;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 826;

    boolean jumping = false;

    public void move() {
        s += v;
        v += dv;
        y -= dy;
        if (v <= 0) {
            v = 0;
        }
        if (v >= MAX_V) {
            v = MAX_V;
        }

        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 826;
        } else {
            layer1 -= v;
            layer2 -= v;
        }

    }

    public Rectangle getRect() {
        return new Rectangle(x , y + 90, 90, 10);  // 90 * 110
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            dv = 1;
        }

        if (key == KeyEvent.VK_LEFT) {
            dv = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            if (y == 110) {
                //dy = -60;
                y = 170;
            } else if (y == 170) {
                y = 250;
                //dy = -80;
            }
        }

        if (key == KeyEvent.VK_UP) {
            if (y == 250) {
                y = 170;
                //dy = 80;
            } else if (y == 170) {
                y = 110;
                //dy = 60;
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            jumping = true;
            y = y - 30;
            img = imgJump;

        }



    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dv = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (key == KeyEvent.VK_SPACE) {
            jumping = false;
            img = imgNorm;
            y = y + 30;

        }

    }

}
