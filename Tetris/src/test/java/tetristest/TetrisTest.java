package tetristest;


import javafx.scene.shape.Rectangle;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.logics.TetrisCheck;
import tetris.logics.TetrisMoves;
import tetris.logics.Tetromino;
import tetris.logics.TetrominoFactory;

public class TetrisTest {
    Tetromino tetrominoCanMoveLeftAndRight;
    
    @Before
    public void setUp() {
        tetrominoCanMoveLeftAndRight = TetrominoFactory.createRandomTetromino(0);
    }
    
    @Test
    public void testTetrominoExist(){
        Tetromino test = new Tetromino(new Rectangle(30, 30), new Rectangle(30, 30), new Rectangle(30, 30), new Rectangle(30, 30), "0");
        assertTrue(test!=null);    
    }
    @Test
    public void testrandomNumbersize1(){
        int test = TetrominoFactory.randomNumber();
        assertTrue(test >= 0);
    }
    
    @Test
    public void testrandomNumbersize2(){
        int test = TetrominoFactory.randomNumber();
        assertTrue(test < 7);
    }
    
    @Test
    public void testTetrominoFactoryExist(){
        TetrominoFactory test = new TetrominoFactory();
        assertTrue(test != null);
    }
    
    @Test
    public void testCreateRandomTetrominoO(){
        Tetromino o = TetrominoFactory.createRandomTetromino(0);
        assertTrue(o.piece1.getX() == 220.0 && o.piece1.getY() == 50.0 &&
                   o.piece2.getX() == 250.0 && o.piece2.getY() == 50.0 &&
                   o.piece3.getX() == 220.0 && o.piece3.getY() == 80.0 &&
                   o.piece4.getX() == 250.0 && o.piece4.getY() == 80.0);
    }
    
    @Test
    public void testCreateRandomTetrominoI(){
        Tetromino i = TetrominoFactory.createRandomTetromino(1);
        assertTrue(i.piece1.getX() == 190.0 && i.piece1.getY() == 50.0 &&
                   i.piece2.getX() == 220.0 && i.piece2.getY() == 50.0 &&
                   i.piece3.getX() == 250.0 && i.piece3.getY() == 50.0 &&
                   i.piece4.getX() == 280.0 && i.piece4.getY() == 50.0);
    }
    
    @Test
    public void testCreateRandomTetrominoS(){
        Tetromino s = TetrominoFactory.createRandomTetromino(2);
        assertTrue(s.piece1.getX() == 280.0 && s.piece1.getY() == 50.0 &&
                   s.piece2.getX() == 250.0 && s.piece2.getY() == 50.0 &&
                   s.piece3.getX() == 250.0 && s.piece3.getY() == 80.0 &&
                   s.piece4.getX() == 220.0 && s.piece4.getY() == 80.0);
    }
    
    @Test
    public void testCreateRandomTetrominoZ(){
        Tetromino z = TetrominoFactory.createRandomTetromino(3);
        assertTrue(z.piece1.getX() == 220.0 && z.piece1.getY() == 50.0 &&
                   z.piece2.getX() == 250.0 && z.piece2.getY() == 50.0 &&
                   z.piece3.getX() == 250.0 && z.piece3.getY() == 80.0 &&
                   z.piece4.getX() == 280.0 && z.piece4.getY() == 80.0);
    }
    
    @Test
    public void testCreateRandomTetrominoL(){
        Tetromino l = TetrominoFactory.createRandomTetromino(4);
        assertTrue(l.piece1.getX() == 220.0 && l.piece1.getY() == 80.0 &&
                   l.piece2.getX() == 220.0 && l.piece2.getY() == 50.0 &&
                   l.piece3.getX() == 250.0 && l.piece3.getY() == 50.0 &&
                   l.piece4.getX() == 280.0 && l.piece4.getY() == 50.0);
    }
    
    @Test
    public void testCreateRandomTetrominoJ(){
        Tetromino j = TetrominoFactory.createRandomTetromino(5);
        assertTrue(j.piece1.getX() == 220.0 && j.piece1.getY() == 50.0 &&
                   j.piece2.getX() == 250.0 && j.piece2.getY() == 50.0 &&
                   j.piece3.getX() == 280.0 && j.piece3.getY() == 50.0 &&
                   j.piece4.getX() == 280.0 && j.piece4.getY() == 80.0);
    }
    
    @Test
    public void testCreateRandomTetrominoT(){
        Tetromino t = TetrominoFactory.createRandomTetromino(6);
        assertTrue(t.piece1.getX() == 220.0 && t.piece1.getY() == 50.0 &&
                   t.piece2.getX() == 250.0 && t.piece2.getY() == 50.0 &&
                   t.piece3.getX() == 280.0 && t.piece3.getY() == 50.0 &&
                   t.piece4.getX() == 250.0 && t.piece4.getY() == 80.0);
    }
    
    @Test
    public void testCreateRandomTetrominoDefault(){
        Tetromino t = TetrominoFactory.createRandomTetromino(10);
        assertTrue(t.piece1.getX() == 220.0 && t.piece1.getY() == 50.0 &&
                   t.piece2.getX() == 250.0 && t.piece2.getY() == 50.0 &&
                   t.piece3.getX() == 280.0 && t.piece3.getY() == 50.0 &&
                   t.piece4.getX() == 250.0 && t.piece4.getY() == 80.0);
    }
    
    @Test
    public void testTetrisMovesgameOverTrue(){
        int[][] test = new int[10][10];
        assertTrue(TetrisCheck.gameOver(test) == true);
    }
    
    @Test
    public void testTetrisMovesgameOverFalse(){
        int[][] test = new int[10][10];
        test[3][0] = 1;
        assertTrue(TetrisCheck.gameOver(test) == false);
    }
    
    @Test
    public void testTetrisMovesCanMoveRight(){
        int[][] empty = new int[10][20];
        assertTrue(TetrisMoves.canMoveRight(tetrominoCanMoveLeftAndRight, empty) == true);
    }
    @Test
    public void testTetrisMovesCanMoveLeft(){
        int[][] empty = new int[10][20];
        assertTrue(TetrisMoves.canMoveLeft(tetrominoCanMoveLeftAndRight, empty) == true);
    }
    
    @Test
    public void testTetrisMovesCantMoveRight(){
        int[][] grid = new int[10][20];
        grid[6][0] = 1;
        assertTrue(TetrisMoves.canMoveRight(tetrominoCanMoveLeftAndRight, grid) == false);
    }
    @Test
    public void testTetrisMovesCantMoveLeft(){
        int[][] grid = new int[10][20];
        grid[4][0] = 1;
        assertTrue(TetrisMoves.canMoveLeft(tetrominoCanMoveLeftAndRight, grid) == false);
    }
    
    @Test
    public void testTetrisMovesMoveRight(){
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createRandomTetromino(0);
        TetrisMoves.moveRight(t, grid);
        assertTrue(t.piece1.getX() == 250.0 && t.piece1.getY() == 50.0 &&
                   t.piece2.getX() == 280.0 && t.piece2.getY() == 50.0 &&
                   t.piece3.getX() == 250.0 && t.piece3.getY() == 80.0 &&
                   t.piece4.getX() == 280.0 && t.piece4.getY() == 80.0);
    }
    
    @Test
    public void testTetrisMovesMoveLeft(){
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createRandomTetromino(0);
        TetrisMoves.moveLeft(t, grid);
        assertTrue(t.piece1.getX() == 190.0 && t.piece1.getY() == 50.0 &&
                   t.piece2.getX() == 220.0 && t.piece2.getY() == 50.0 &&
                   t.piece3.getX() == 190.0 && t.piece3.getY() == 80.0 &&
                   t.piece4.getX() == 220.0 && t.piece4.getY() == 80.0);
    }
}
