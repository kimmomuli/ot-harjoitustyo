package tetris;

import java.util.Random;
import javafx.scene.shape.Rectangle;

public class TetrominoFactory {
    
    public static Tetromino createRandomTetromino() {
        Random random = new Random();
        int randomNumber = random.nextInt(7);
        
        switch(randomNumber) {
            case 0:
                //piece O
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(220, 80, 30, 30),
                        new Rectangle(250, 80, 30, 30), "0");
            case 1:
                //piece I
                return new Tetromino(new Rectangle(190, 50, 30, 30),
                        new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(280, 50, 30, 30), "I");
            case 2:
                //piece S
                return new Tetromino(new Rectangle(280, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(250, 80, 30, 30),
                        new Rectangle(220, 80, 30, 30), "S");
            case 3:
                //piece Z
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(250, 80, 30, 30),
                        new Rectangle(280, 80, 30, 30), "Z");
            case 4:
                //piece L
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(280, 50, 30, 30),
                        new Rectangle(220, 80, 30, 30), "L");
            case 5:
                //piece J
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(280, 50, 30, 30),
                        new Rectangle(280, 80, 30, 30), "J");
            case 6:
                //piece T
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(280, 50, 30, 30),
                        new Rectangle(250, 80, 30, 30), "T");
            default:
                //piece T
                return new Tetromino(new Rectangle(220, 50, 30, 30),
                        new Rectangle(250, 50, 30, 30),
                        new Rectangle(280, 50, 30, 30),
                        new Rectangle(250, 80, 30, 30), "T");
        }   
    }
}
