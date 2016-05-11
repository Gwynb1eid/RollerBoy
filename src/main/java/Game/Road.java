package Game;

import Game.Obstacle.Obstacles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable {
    Timer mainTimer = new Timer(20, this);

    Image img = new ImageIcon(getClass().getResource("/roadNew.png")).getImage();

    public Player player = new Player();
    Background bg = new Background();

    int i = 1;
    Thread obstaclesFactory = new Thread(this);
    ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();

    public Road() {
        mainTimer.start();
        obstaclesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    public void run() {
        while (true) {
            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(2000));
                obstacles.add(new Obstacles(900, rnd.nextInt(450), rnd.nextInt(60), this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint (Graphics g) {
        //g = (Graphics2D) g;

        bg.x =  470 - player.s / 1000;

        if (player.v != 0) {
            if (i < 100 || i > 130 ) {
                player.img = player.imgNorm;
            }
            if (i >= 100 && i < 130){
                player.img = player.imgNorm2;
            }
            if (i > 130) {
                i = 0;
            }
            i++;
        }


        ((Graphics2D) g).drawImage(bg.img2, 0, 0, null);
        ((Graphics2D) g).drawImage(bg.img, bg.x, bg.y, null);

        ((Graphics2D) g).drawImage(img, player.layer1, getHeight() - 236, null);
        ((Graphics2D) g).drawImage(img, player.layer2, getHeight() - 236, null);

        ((Graphics2D) g).drawImage(player.img, player.x, player.y, null);

        double v = player.v;
        g.setColor(Color.YELLOW);
        Font font = new Font("Courier New", Font.BOLD, 22);

        ((Graphics2D) g).drawString("Speed: " + v + " km/h", 20, 30);

        Iterator<Obstacles> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacles obst = iterator.next();
            if (obst.x > 1600 || obst.x < -1600) {
                iterator.remove();
            } else {
                obst.move();
                ((Graphics2D) g).drawImage(obst.img, obst.x, obst.y, null);
            }
            ((Graphics2D) g).drawImage(obst.img, obst.x, obst.y, null);
        }
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        testCollision();
        repaint();
        //System.out.println(obstacles.size());
    }

    public void testCollision() {
        Iterator<Obstacles> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacles obst = iterator.next();
            if (player.getRect().intersects(obst.getRect())) {
                JOptionPane.showMessageDialog(null, "You loose!");
                //JOptionPane.showMessageDialog(null, "Try next time.");
                //System.exit(1);
            }
        }

    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed (KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased (KeyEvent e) {
            player.keyReleased(e);
        }

    }


}
