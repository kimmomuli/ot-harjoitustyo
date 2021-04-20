package tetris;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane screen = new Pane();
        screen.setPrefSize(500, 700);
        
        Text points = new Text(30, 30, "Points: ");
        points.setFill(Color.RED);
        points.setStyle("-fx-font-size: 2em;");
        screen.getChildren().add(points);
        
        printGrid(screen);
        
        int[][] grid = new int[10][20];
        for (int[] list: grid) Arrays.fill(list, 0);
        
        
        Scene scene = new Scene(screen);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        boolean run = true;
        Tetromino tetromino = TetrominoFactory.createRandomTetromino();
        screen.getChildren().addAll(tetromino.piece1, tetromino.piece2, tetromino.piece3, tetromino.piece4);
        
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {
                    if (run) moveDown(tetromino);
                });
            }
        };
        timer.schedule(timertask, 0, 200);
    }
    
    public void moveDown(Tetromino tetromino){
        tetromino.piece1.setY(tetromino.piece1.getY() + 30);
        tetromino.piece2.setY(tetromino.piece2.getY() + 30);
        tetromino.piece3.setY(tetromino.piece3.getY() + 30);
        tetromino.piece4.setY(tetromino.piece4.getY() + 30);
    }
    
    public void printGrid(Pane screen){
        int x = 100;
        for (int i = 0; i < 11; i++) {
            screen.getChildren().add(new Line(x, 50, x, 650));
            x+=30;
        }
        int y = 50;
        for (int i = 0; i < 21; i++) {
            screen.getChildren().add(new Line(100, y, 400, y));
            y+=30;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
