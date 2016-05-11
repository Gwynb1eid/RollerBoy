package Game.Obstacle;

import Game.Road;

import javax.swing.*;
import java.awt.*;

public class StaticCar extends Obstacles {
    Image img = new ImageIcon(getClass().getResource("/sCar1.png")).getImage();

    public StaticCar(int x, int y, int v, Road road) {
        super(x, y, v, road);
    }

}
