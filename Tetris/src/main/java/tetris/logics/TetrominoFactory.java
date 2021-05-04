package tetris.logics;

import java.util.Random;
import javafx.scene.shape.Rectangle;

/**
 * Create random number between 0 - 6 and then use it to create random tetromino 
 * @author kimmo
 */
public class TetrominoFactory {

    /**
     * Raffle tetromino
     * @param randomNumber (int) between 1 - 6
     * @return random tetromino
     */
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
    
    /**
     * Create tetromino O
     * @return Create tetromino O
     */
    public static Tetromino createO() {
        return new Tetromino(new Rectangle(220, 50, 30, 30), 
                new Rectangle(250, 50, 30, 30), 
                new Rectangle(220, 80, 30, 30), 
                new Rectangle(250, 80, 30, 30), "0");
    }
    
    /**
     * Create tetromino I
     * @return tetromino I
     */
    public static Tetromino createI() {
        return new Tetromino(new Rectangle(190, 50, 30, 30),
                new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30), "I");
    }
    
    /**
     * Create tetromino S
     * @return tetromino S
     */
    public static Tetromino createS() {
        return new Tetromino(new Rectangle(280, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(250, 80, 30, 30),
                new Rectangle(220, 80, 30, 30), "S");
    }
    
    /**
     * Create tetromino Z
     * @return tetromino Z
     */
    public static Tetromino createZ() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(250, 80, 30, 30),
                new Rectangle(280, 80, 30, 30), "Z");
    }
    
    /**
     * Create tetromino L
     * @return tetromino L
     */
    public static Tetromino createL() {
        return new Tetromino(new Rectangle(220, 80, 30, 30),
                new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30), "L");
    }
    
    /**
     * Create tetromino J
     * @return tetromino J
     */
    public static Tetromino createJ() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30),
                new Rectangle(280, 80, 30, 30), "J");
    }
    
    /**
     * Create tetromino T
     * @return tetromino T
     */
    public static Tetromino createT() {
        return new Tetromino(new Rectangle(220, 50, 30, 30),
                new Rectangle(250, 50, 30, 30),
                new Rectangle(280, 50, 30, 30),
                new Rectangle(250, 80, 30, 30), "T");
    }
    
    /**
     * Create number between 1 - 6
     * @return int 1 - 6
     */
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(7);
    }
}
