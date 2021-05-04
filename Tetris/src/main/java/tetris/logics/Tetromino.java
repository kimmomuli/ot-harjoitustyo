package tetris.logics;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *
 * @author kimmo
 */
public class Tetromino {
    
    /**
     * One of four rectangle
     */
    public Rectangle piece1;

    /**
     * One of four rectangle
     */
    public Rectangle piece2;

    /**
     * One of four rectangle
     */
    public Rectangle piece3;

    /**
     * One of four rectangle
     */
    public Rectangle piece4;

    /**
     * Tetrominos name
     */
    public String name;

    /**
     * Tetrominos position
     */
    public int position;

    /**
     * Create 4 rectangle, name and paint them and give position to tetromino 
     * @param piece1
     * @param piece2
     * @param piece3
     * @param piece4
     * @param name
     */
    public Tetromino(Rectangle piece1, Rectangle piece2, Rectangle piece3, Rectangle piece4, String name) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
        this.piece4 = piece4;
        this.name = name;
        paint(name);
        this.position = 1;
    }
    
    /**
     * Choice a color by name
     * @param name
     */
    public void paint(String name) {
        if (name.equals("0")) { 
            setColor(Color.YELLOW); 
        } else if (name.equals("I")) { 
            setColor(Color.CYAN); 
        } else if (name.equals("S")) { 
            setColor(Color.LAWNGREEN); 
        } else if (name.equals("Z")) { 
            setColor(Color.RED); 
        } else if (name.equals("L")) { 
            setColor(Color.ORANGE); 
        } else if (name.equals("J")) { 
            setColor(Color.BLUE); 
        } else if (name.equals("T")) { 
            setColor(Color.HOTPINK); 
        }
    }
    
    /**
     * Fill rectangles with color
     * @param color 
     */
    public void setColor(Color color) {
        piece1.setFill(color);
        piece2.setFill(color);
        piece3.setFill(color);
        piece4.setFill(color);
    }
    
    /**
     * change tetrominoes position
     * the position is in variable position
     */
    public void changePostion() {
        position++;
        if (position == 5) {
            position = 1;
        }
    }
}
