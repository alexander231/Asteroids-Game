//package asteroids;
import javafx.scene.paint.Color;
//import asteroids.logic.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.*;
import java.util.*;

public class AsteroidsApp extends Application{

    public static int WIDTH = 1000;
    public static int HEIGHT = 800;

    
    @Override
    public void start(Stage window) throws Exception {
        Pane space = new Pane();
        space.setPrefSize(WIDTH, HEIGHT);
        Scene mainWindow = new Scene(space, Color.BEIGE) ;
        Ship ship = new Ship(600, 500);
        ship.setColorShip();
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            Random rnd = new Random();
            asteroids.add(new Asteroid(rnd.nextInt(100), rnd.nextInt(100)));
        }
        
        //score board
        asteroids.forEach(asteroid -> space.getChildren().add(asteroid.getCharacter()));
        asteroids.forEach(asteroid -> asteroid.setAsteroidColor());
        space.getChildren().add(ship.getCharacter());
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        mainWindow.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        mainWindow.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        new AnimationTimer() {

            private void moveShipWithArrowsKey() {

                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                    
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                asteroids.forEach(asteroid -> {
                    if(ship.collide(asteroid)) {
                        stop();
                    }
                });

            }
        

            @Override
            public void handle(long now) {
                moveShipWithArrowsKey();
                
            }
        }.start();
        window.setScene(mainWindow);
        window.setTitle("Asteroids");
        window.show();

    }
        
    public static void main(String[] args) {
        launch(args);
    }
}
