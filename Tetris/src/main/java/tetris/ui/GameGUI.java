package tetris.ui;

import tetris.logics.TetrisCheck;
import tetris.logics.TetrisMoves;
import tetris.logics.Tetromino;
import tetris.logics.TetrominoFactory;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameGUI {
    public static Tetromino tetromino;
    public static int pointsNumber;
    
    public static void startTetris(Stage primaryStage, Pane screen, Scene scene) {
        screen.setStyle("-fx-background-color: grey;");
        
        Text points = new Text(30, 30, "Points: " + String.valueOf(pointsNumber));
        points.setFill(Color.BLACK);
        points.setStyle("-fx-font-size: 2em;");
        screen.getChildren().add(points);
        
        printGrid(screen);
        
        int[][] grid = new int[10][20];
        
        tetromino = TetrominoFactory.createRandomTetromino(TetrominoFactory.randomNumber());
        screen.getChildren().addAll(tetromino.piece1, tetromino.piece2, tetromino.piece3, tetromino.piece4);
        
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {
                    if (TetrisCheck.gameOver(grid)) {
                        points.setText("Points: " + String.valueOf(pointsNumber));
                        
                        printGrid(screen);
                        if (TetrisMoves.moveDown(tetromino, grid, screen)) {
                            tetromino = TetrominoFactory.createRandomTetromino(TetrominoFactory.randomNumber());
                            screen.getChildren().addAll(tetromino.piece1, tetromino.piece2, tetromino.piece3, tetromino.piece4);
                            printGrid(screen);
                        }
                        scene.setOnKeyPressed(event ->{
                            if (event.getCode() == KeyCode.DOWN) TetrisMoves.moveDown(tetromino, grid, screen);
                            if (event.getCode() == KeyCode.Q) System.exit(0); 
                            if (event.getCode() == KeyCode.LEFT) TetrisMoves.moveLeft(tetromino, grid);
                            if (event.getCode() == KeyCode.RIGHT) TetrisMoves.moveRight(tetromino, grid);
                            if (event.getCode() == KeyCode.UP) TetrisMoves.rotate(tetromino, grid);
                        });
                    }
                });
            }
        };
        timer.schedule(timertask, 0, 300);
    }
    
    public static void printGrid(Pane screen){
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
}
