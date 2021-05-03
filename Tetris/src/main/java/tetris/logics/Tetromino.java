package tetris.logics;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Tetromino {
    
    public Rectangle piece1;
    public Rectangle piece2;
    public Rectangle piece3;
    public Rectangle piece4;
    public String name;
    public int position;

    public Tetromino(Rectangle piece1, Rectangle piece2, Rectangle piece3, Rectangle piece4, String name) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
        this.piece4 = piece4;
        this.name = name;
        paint(name);
        this.position = 1;
    }
    
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
    
    public void setColor(Color color) {
        piece1.setFill(color);
        piece2.setFill(color);
        piece3.setFill(color);
        piece4.setFill(color);
    }
    
    public void changePostion() {
        position++;
        if (position == 5) {
            position = 1;
        }
    }
}
