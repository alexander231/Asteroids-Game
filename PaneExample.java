import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.*;
import java.util.*;

public class PaneExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        
        pane.setPrefSize(1000, 800);
        
        Polygon ship = new Polygon();
        ship.getPoints().addAll(new Double[] {
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0});
        
        ship.setFill(Color.DARKCYAN);
        ship.setStrokeWidth(3.0);
        ship.setStroke(Color.DARKSLATEGREY);
        ship.setTranslateX(400);
        ship.setTranslateY(400);
        ship.setRotate(30);

        pane.getChildren().add(ship);

        Scene scene = new Scene(pane, Color.BEIGE);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();


       
    }

    public static void main(String[] args) {
        launch(args);
    }
}