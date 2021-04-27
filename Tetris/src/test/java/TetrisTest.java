
import javafx.scene.shape.Rectangle;
import tetris.logics.Tetromino;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.logics.Tetromino;
import tetris.logics.TetrominoFactory;

public class TetrisTest {
    
    Tetromino tetromino;
    TetrominoFactory tetrominoFactory;
    
    @Before
    public void setUp() {
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
