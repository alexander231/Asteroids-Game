
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
 
public class Ship extends Character{

    public Ship(int x, int y) {
        // dimensions and appereance of the ship
        super(new Polygon(-7.5, -7.5, 17.5, 0, -7.5, 7.5), x, y);
    }
    public void setColorShip() {
        this.getCharacter().setFill(Color.DARKCYAN);
        this.getCharacter().setStrokeWidth(3.0);
        this.getCharacter().setStroke(Color.DARKSLATEGREY);
    }
}
