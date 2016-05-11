package Game.Obstacle;

import Game.Road;

import javax.swing.*;
import java.awt.*;

public class Hole extends Obstacles {

    Image img = new ImageIcon(getClass().getResource("/hole.png")).getImage();

    public Hole (int x, int y, int v, Road road) {
        super(x, y, 0, road);

    }

}
