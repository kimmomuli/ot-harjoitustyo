
import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Tetromino;
import tetris.TetrominoFactory;

public class TetrisTest {
    
    Tetromino tetromino;
    TetrominoFactory tetrominoFactory;
    
    @Before
    public void setUp() {
        tetromino = new Tetromino(new Rectangle(1, 1),
                        new Rectangle(1, 1),
                        new Rectangle(1, 1),
                        new Rectangle(1, 1));
        tetrominoFactory = new TetrominoFactory();
    }
    
    @Test
    public void testTetromino(){
        assertNull(tetromino);
    }
    
    @Test
    public void testTetrominoFactory(){
        assertNull(tetrominoFactory.createRandomTetromino());
    }
    
}
