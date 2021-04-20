package tetris;

import javafx.scene.shape.Rectangle;

public class Tetromino {
    
    Rectangle piece1;
    Rectangle piece2;
    Rectangle piece3;
    Rectangle piece4;

    public Tetromino(Rectangle piece1, Rectangle piece2, Rectangle piece3, Rectangle piece4) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
        this.piece4 = piece4;
    }
}
