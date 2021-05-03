package tetris.logics;

import java.util.Random;
import javafx.scene.shape.Rectangle;

public class TetrominoFactory {
    public static Tetromino createRandomTetromino(int randomNumber) {
        switch (randomNumber) {
            case 0:
                return createO();
            case 1:
                return createI();
            case 2:
                return createS();
            case 3:
                return createZ();
            case 4:
                return createL();
            case 5:
                return createJ();
            case 6:
                return createT();
            default:
                return createT();
        }   
    }
    
    public static Tetromino createO() {
        return new Tetromino(new Rectangle(220, 50, 30, 30), 
                new Rectangle(250, 50, 30, 30), 
                new Rectangle(220, 80, 30, 30), 
                new Rectangle(250, 80, 30, 30), "0");
    }
    
    public static Tetromino createI() {
        return new Tetromino(new Rectangle(190, 50, 30, 30),
                new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30), "I");
    }
    
    public static Tetromino createS() {
        return new Tetromino(new Rectangle(280, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(250, 80, 30, 30),
                new Rectangle(220, 80, 30, 30), "S");
    }
    
    public static Tetromino createZ() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(250, 80, 30, 30),
                new Rectangle(280, 80, 30, 30), "Z");
    }
    
    public static Tetromino createL() {
        return new Tetromino(new Rectangle(220, 80, 30, 30),
                new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30), "L");
    }
    
    public static Tetromino createJ() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30),
                new Rectangle(280, 80, 30, 30), "J");
    }
    
    public static Tetromino createT() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30),
                new Rectangle(250, 80, 30, 30), "T");
    }
    
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(7);
    }
}
