package tetris.logics;

import javafx.scene.shape.Rectangle;

public class Tetromino {
    
    public Rectangle piece1;
    public Rectangle piece2;
    public Rectangle piece3;
    public Rectangle piece4;
    public String name;

    public Tetromino(Rectangle piece1, Rectangle piece2, Rectangle piece3, Rectangle piece4, String name) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
        this.piece4 = piece4;
        this.name = name;
    }
}
