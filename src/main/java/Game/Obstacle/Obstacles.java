package Game.Obstacle;

import Game.Road;

import javax.swing.*;
import java.awt.*;

public class Obstacles {

    public int x;
    public int y;
    int v;

    Road road;
    public Image img = new ImageIcon(getClass().getResource("/hole.png")).getImage();


    public Obstacles(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        x = x - road.player.v + v;
    }


    public Rectangle getRect() {
        return new Rectangle(x, y, 80, 30);
    }





}
