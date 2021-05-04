package tetristest;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.logics.TetrisCheck;
import tetris.logics.TetrisMoves;
import tetris.logics.Tetromino;
import tetris.logics.TetrominoFactory;
import tetris.ui.GameGUI;
import static tetris.ui.GameGUI.tetromino;

public class TetrisTest {
    Tetromino tetrominoCanMoveLeftAndRight;
    
    @Before
    public void setUp() {
        tetrominoCanMoveLeftAndRight = TetrominoFactory.createRandomTetromino(0);
    }
    
    @Test
    public void testTetrominoExist(){
        Tetromino test = new Tetromino(new Rectangle(30, 30), new Rectangle(30, 30), new Rectangle(30, 30), new Rectangle(30, 30), "0");
        assertTrue(test != null);    
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
    
    @Test 
    public void testColorO(){
        Tetromino t = TetrominoFactory.createRandomTetromino(0);
        assertTrue(t.piece1.getFill() == Color.YELLOW);
    }
    
    @Test 
    public void testColorI(){
        Tetromino t = TetrominoFactory.createRandomTetromino(1);
        assertTrue(t.piece1.getFill() == Color.CYAN);
    }
    
    @Test 
    public void testColorS(){
        Tetromino t = TetrominoFactory.createRandomTetromino(2);
        assertTrue(t.piece1.getFill() == Color.LAWNGREEN);
    }
    
    @Test 
    public void testColorZ(){
        Tetromino t = TetrominoFactory.createRandomTetromino(3);
        assertTrue(t.piece1.getFill() == Color.RED);
    }
    
    @Test 
    public void testColorL(){
        Tetromino t = TetrominoFactory.createRandomTetromino(4);
        assertTrue(t.piece1.getFill() == Color.ORANGE);
    }
    
    @Test 
    public void testColorJ(){
        Tetromino t = TetrominoFactory.createRandomTetromino(5);
        assertTrue(t.piece1.getFill() == Color.BLUE);
    }
    
    @Test 
    public void testColorT(){
        Tetromino t = TetrominoFactory.createRandomTetromino(6);
        assertTrue(t.piece1.getFill() == Color.HOTPINK);
    }
    
    @Test 
    public void testTetrominoposition1(){
        Tetromino t = TetrominoFactory.createRandomTetromino(6);
        t.changePostion();
        assertTrue(t.position == 2);
    }
    
    @Test 
    public void testTetrominoposition2(){
        Tetromino t = TetrominoFactory.createRandomTetromino(6);
        t.changePostion();
        t.changePostion();
        t.changePostion();
        t.changePostion();
        assertTrue(t.position == 1);
    }
    
    @Test 
    public void testUpdateGrid1(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(190, 50, 30, 30));
        TetrisCheck.updateGrid(screen, grid);
        assertTrue(grid[3][0] == 1);
    }
    
    @Test 
    public void testUpdateGrid2(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(250, 470, 30, 30));
        TetrisCheck.updateGrid(screen, grid);
        assertTrue(grid[5][14] == 1);
    }
    
    @Test 
    public void testUpdateGrid3(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(250, 470, 30, 30));
        screen.getChildren().add(new Line(250, 470, 30, 30));
        TetrisCheck.updateGrid(screen, grid);
        assertTrue(grid[5][14] == 1);
    }
    
    @Test 
    public void testDropUpperRectangels1(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(250, 470, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(16);
        grid[5][14] = 1;
        TetrisCheck.dropUpperRectangels(grid, screen, test, row);
        assertTrue(grid[5][14] == 0);
    }
    
    @Test 
    public void testDropUpperRectangels2(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(250, 470, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(10);
        grid[5][14] = 1;
        TetrisCheck.dropUpperRectangels(grid, screen, test, row);
        assertTrue(grid[5][14] == 1);
    }
    
    @Test 
    public void testDeleteLine1(){
        int[][] grid = new int[10][20];
        for (int i = 0; i < 10; i++) {
            grid[i][0] = 1;
        }
        Pane screen = new Pane();
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        TetrisCheck.deleteLine(test, grid, screen, row);
        assertTrue(grid[0][0] == 0);
    }
    
    @Test 
    public void testDeleteLine2(){
        int[][] grid = new int[10][20];
        for (int i = 0; i < 10; i++) {
            grid[i][19] = 1;
        }
        Pane screen = new Pane();
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(370, 620, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(20);
        TetrisCheck.deleteLine(test, grid, screen, row);
        assertTrue(grid[9][19] == 0);
    }
    
    @Test 
    public void testIsFullRow1(){
        int[][] grid = new int[10][20];
        for (int i = 0; i < 10; i++) {
            grid[i][0] = 1;
        }
        ArrayList test = TetrisCheck.isFullRow(grid);
        assertTrue(test.size() == 1);
    }
    
    @Test 
    public void testIsFullRow2(){
        int[][] grid = new int[10][20];
        for (int i = 0; i < 10; i++) {
            grid[i][0] = 1;
            grid[i][5] = 1;
            grid[i][9] = 1;
            grid[i][19] = 1;
        }
        ArrayList test = TetrisCheck.isFullRow(grid);
        assertTrue(test.size() == 4);
    }
    
    @Test 
    public void testRemoveRow1(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(100, 50, 30, 30));
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        grid[0][0] = 1;
        TetrisCheck.removeRow(grid, screen, row);
        assertTrue(grid[0][0] == 0);
    }
    
    /*@Test 
    public void testCheckCounter1(){
        TetrisCheck.checkCounter(1);
        assertTrue(GameGUI.pointsNumber == 100);
    }
    
    @Test 
    public void testCheckCounter2(){
        TetrisCheck.checkCounter(2);
        assertTrue(GameGUI.pointsNumber == 300);
    }
    
    @Test 
    public void testCheckCounter3(){
        TetrisCheck.checkCounter(3);
        assertTrue(GameGUI.pointsNumber == 700);
    }
    
    @Test 
    public void testCheckCounter4(){
        TetrisCheck.checkCounter(4);
        assertTrue(GameGUI.pointsNumber == 1500);
    }*/
    
    @Test 
    public void testRemoveRows(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(100, 50, 30, 30));
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        TetrisCheck.removeRows(grid, screen);
        assertTrue(grid[0][0] == 0);
    }
    
    @Test 
    public void testTetrisCheck(){
        TetrisCheck t = new TetrisCheck();
        assertTrue(t != null);
    }
    
    @Test 
    public void testRemoveRow3(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(100, 50, 30, 30));
        screen.getChildren().add(new Line(100, 50, 30, 30));
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        grid[0][0] = 1;
        TetrisCheck.removeRow(grid, screen, row);
        assertTrue(grid[0][0] == 0);
    }
    
    @Test 
    public void testRemoveRow4(){
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        grid[0][0] = 1;
        TetrisCheck.removeRow(grid, screen, row);
        assertTrue(grid[0][0] == 1);
    }
    
    @Test 
    public void testRemoveRowsFix(){
        int[][] grid = new int[10][20];
        for (int i = 0; i < 10; i++) {
            grid[i][0] = 1;
        }
        Pane screen = new Pane();
        screen.getChildren().add(new Rectangle(100, 50, 30, 30));
        ArrayList<Node> test = new ArrayList<>();
        test.add(new Rectangle(100, 50, 30, 30));
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        TetrisCheck.removeRows(grid, screen);
        assertTrue(grid[0][0] == 0);
    }
    
    @Test
    public void test1CanRotateTo2() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        assertTrue(TetrisMoves.canRotateTo2(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateTo2() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        assertTrue(TetrisMoves.canRotateTo2(t, grid) == true);
    }
    
    @Test
    public void test3CanRotateTo2() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        for (int i = 0; i < 10; i++) {
            grid[i][0] = 1;
        }
        assertTrue(TetrisMoves.canRotateTo2(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateTo3() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        assertTrue(TetrisMoves.canRotateTo3(t, grid) == true);
    }
    
    @Test
    public void test2CanRotateTo3() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        assertTrue(TetrisMoves.canRotateTo3(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateTo3() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        for (int i = 0; i < 20; i++) {
            grid[6][i] = 1;
        }
        assertTrue(TetrisMoves.canRotateTo3(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateTo4() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        for (int i = 0; i < 23; i++) {
            TetrisMoves.moveDown(t);
        }
        assertTrue(TetrisMoves.canRotateTo4(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateTo4() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        assertTrue(TetrisMoves.canRotateTo4(t, grid) == true);
    }
    
    @Test
    public void test3CanRotateTo4() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        TetrisMoves.moveDown(t);
        for (int i = 0; i < 10; i++) {
            grid[i][3] = 1;
        }
        assertTrue(TetrisMoves.canRotateTo4(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateTo1() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        TetrisMoves.rotateTto4(t);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        TetrisMoves.moveLeft(t, grid);
        assertTrue(TetrisMoves.canRotateTo1(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateTo1() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        TetrisMoves.rotateTto4(t);
        assertTrue(TetrisMoves.canRotateTo1(t, grid) == true);
    }
    
    @Test
    public void test3CanRotateTo1() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.rotateTto2(t);
        TetrisMoves.rotateTto3(t);
        TetrisMoves.rotateTto4(t);
        TetrisMoves.moveDown(t);
        for (int i = 0; i < 20; i++) {
            grid[4][i] = 1;
        }
        assertTrue(TetrisMoves.canRotateTo1(t, grid) == false);
    }
    
    @Test
    public void testCanRotateT1() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 1);
    }
    
    @Test
    public void testCanRotateT2() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void testCanRotateT3() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.moveRight(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void testCanRotateT4() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 3);
    }
    
    @Test
    public void testCanRotateT5() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveDown(t);
        }
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 3);
    }
    
    @Test
    public void testCanRotateT6() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 4);
    }
    
    @Test
    public void testCanRotateT7() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 4);
    }
    
    @Test
    public void testCanRotateT9() {
        Tetromino t = TetrominoFactory.createT();
        int[][] grid = new int[10][20];
        TetrisMoves.moveDown(t);
        TetrisMoves.moveDown(t);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        TetrisMoves.rotatePieceT(t, grid);
        assertTrue(t.position == 1);
    }
    
    @Test
    public void testTetrisMovesExist() {
        TetrisMoves t = new TetrisMoves();
        assertTrue(t != null);
    }
    
    @Test
    public void testTetrisMovesMoveDown1() {
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        Tetromino t = TetrominoFactory.createT();
        screen.getChildren().addAll(t.piece1, t.piece2, t.piece3, t.piece4);
        assertTrue(TetrisMoves.moveDown(t, grid, screen) == false);
    }
    
    @Test
    public void testTetrisMovesMoveDown2() {
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        Tetromino t = TetrominoFactory.createT();
        for (int i = 0; i < 30; i++) {
            TetrisMoves.moveDown(t, grid, screen);
        }
        screen.getChildren().addAll(t.piece1, t.piece2, t.piece3, t.piece4);
        assertTrue(TetrisMoves.moveDown(t, grid, screen) == true);
    }
    
    @Test
    public void testCanMoveDown() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        assertTrue(TetrisMoves.canMoveDown(t, grid) == true);
    }
    
    @Test
    public void testTetrisMovesInArea1() {
        Tetromino t = TetrominoFactory.createI();
        assertTrue(TetrisMoves.inArea(t) == true);
    }
    
    @Test
    public void testTetrisMovesInArea2() {
        Tetromino t = TetrominoFactory.createI();
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveDown(t);
        }
        assertTrue(TetrisMoves.inArea(t) == false);
    }
    
    @Test
    public void testTetrisMovesSavePlace1() {
        Tetromino t = TetrominoFactory.createI();
        int[][] grid = new int[10][20];
        TetrisMoves.savePlace(t, grid);
        assertTrue(grid[3][0] == 1 &&
                grid[4][0] == 1 &&
                grid[5][0] == 1 &&
                grid[6][0] == 1);
    }
    @Test
    public void testTetrisMovesSavePlace2() {
        Tetromino t = TetrominoFactory.createI();
        int[][] grid = new int[10][20];
        TetrisMoves.savePlace(t, grid);
        assertTrue(grid[3][1] == 0 &&
                grid[4][1] == 0 &&
                grid[5][1] == 0 &&
                grid[7][0] == 0);
    }
    
    @Test
    public void testTetrisMovesMoveDown3() {
        int[][] grid = new int[10][20];
        Pane screen = new Pane();
        Tetromino t = TetrominoFactory.createI();
        for (int i = 0; i < 10; i++) {
            grid[i][1] = 1;
        }
        screen.getChildren().addAll(t.piece1, t.piece2, t.piece3, t.piece4);
        assertTrue(TetrisMoves.moveDown(t, grid, screen) == true);
    }
    
    @Test
    public void testTetrisInArea3() {
        Tetromino t = TetrominoFactory.createI();
        t.piece2.setY(620);
        assertTrue(TetrisMoves.inArea(t) == false);
    }
    
    @Test
    public void testTetrisInArea4() {
        Tetromino t = TetrominoFactory.createI();
        t.piece3.setY(620);
        assertTrue(TetrisMoves.inArea(t) == false);
    }
    
    @Test
    public void testcanMoveDown2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[3][1] = 1;
        assertTrue(TetrisMoves.canMoveDown(t, grid) == false);
    }
    
    @Test
    public void testcanMoveDown3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canMoveDown(t, grid) == false);
    }
    
    @Test
    public void testcanMoveDown4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[5][1] = 1;
        assertTrue(TetrisMoves.canMoveDown(t, grid) == false);
    }
    
    @Test
    public void testcanMoveDown5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canMoveDown(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece2.setX(100);
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece3.setX(100);
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece4.setX(100);
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == true);
    }
    
    @Test
    public void testcanMoveLeft5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[3][0] = 1;
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft6() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[3][1] = 1;
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft7() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[3][2] = 1;
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveLeft8() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[3][3] = 1;
        assertTrue(TetrisMoves.canMoveLeft(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece1.setX(370);
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    @Test
    public void testcanMoveRight8() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece3.setX(370);
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        t.piece4.setX(370);
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        assertTrue(TetrisMoves.canMoveRight(t, grid) == true);
    }
    
    @Test
    public void testcanMoveRight4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[5][1] = 1;
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight6() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testcanMoveRight7() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[5][3] = 1;
        assertTrue(TetrisMoves.canMoveRight(t, grid) == false);
    }
    
    @Test
    public void testRotateI1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 140 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateI2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateI3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 140 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateI4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        for (int i = 0; i < 10; i++) {
            grid[i][2] = 1;
        }
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateI5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 20; i++) {
            grid[3][i] = 1;
        }
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 140 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateS1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateS2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateS3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateZ1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateZ2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateZ3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateL1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 50 && t.piece1.getX() == 220);
    }
    
    @Test
    public void testRotateL2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 50 && t.piece1.getX() == 280);
    }
    
    @Test
    public void testRotateL3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 110 && t.piece1.getX() == 280);
    }
    
    @Test
    public void testRotateL4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 110 && t.piece1.getX() == 220);
    }
    
    @Test
    public void testRotateL5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 50 && t.piece1.getX() == 220);
    }
    
    @Test
    public void testRotateJ1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateJ2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateJ3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 50 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateJ4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateJ5() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 110 && t.piece4.getX() == 220);
    }
    
    @Test
    public void testRotateT1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createT();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece3.getY() == 50 && t.piece4.getX() == 250);
    }
    
    @Test
    public void testRotateT2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createT();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece4.getY() == 80 && t.piece4.getX() == 280);
    }
    
    @Test
    public void testRotateT3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createT();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 110 && t.piece1.getX() == 250);
    }
    
    @Test
    public void testRotateT4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createT();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        assertTrue(t.piece1.getY() == 80 && t.piece1.getX() == 220);
    }
    
    @Test
    public void test1canRotateITo2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveDown(t);
        }
        assertTrue(TetrisMoves.canRotateITo2(t, grid) == false);
    }
    
    @Test
    public void test2canRotateITo2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateITo2(t, grid) == false);
    }
    
    @Test
    public void test3canRotateITo2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        grid[4][3] = 1;
        assertTrue(TetrisMoves.canRotateITo2(t, grid) == false);
    }
    
    @Test
    public void test1canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == false);
    }
    
    @Test
    public void test2canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveRight(t, grid);
        }
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == false);
    }
    
    @Test
    public void test3canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == true);
    }
    
    @Test
    public void test4canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[3][0] = 1;
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == false);
    }
    
    @Test
    public void test5canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == false);
    }
    
    @Test
    public void test6canRotateITo3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createI();
        TetrisMoves.rotate(t, grid);
        grid[6][0] = 1;
        assertTrue(TetrisMoves.canRotateITo3(t, grid) == false);
    }
    
    @Test
    public void testRotatePieceS1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.rotate(t, grid);
        assertTrue(t.position == 1);
    }
    
    @Test
    public void testRotatePieceS2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        TetrisMoves.rotate(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void testRotatePieceZ1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.rotate(t, grid);
        assertTrue(t.position == 1);
    }
    
    @Test
    public void testRotatePieceZ2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        TetrisMoves.rotate(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void test1CanRotateSto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        assertTrue(TetrisMoves.canRotateSto2(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateSto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        assertTrue(TetrisMoves.canRotateSto2(t, grid) == true);
    }
    
    @Test
    public void test3CanRotateSto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateSto2(t, grid) == false);
    }
    
    @Test
    public void test4CanRotateSto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        grid[6][2] = 1;
        assertTrue(TetrisMoves.canRotateSto2(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateSto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        t.piece2.setX(100);
        assertTrue(TetrisMoves.canRotateSto3(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateSto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canRotateSto3(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateSto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createS();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[4][2] = 1;
        assertTrue(TetrisMoves.canRotateSto3(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateJto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.rotate(t, grid);
        assertTrue(TetrisMoves.canRotateJto2(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateJto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateJto2(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateJto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canRotateJto2(t, grid) == false);
    }
    
    @Test
    public void test4CanRotateJto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        grid[4][2] = 1;
        assertTrue(TetrisMoves.canRotateJto2(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateJto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        t.piece2.setX(370);
        assertTrue(TetrisMoves.canRotateJto3(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateJto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canRotateJto3(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateJto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateJto3(t, grid) == false);
    }
    
    @Test
    public void test4CanRotateJto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[4][0] = 1;
        assertTrue(TetrisMoves.canRotateJto3(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateJto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        t.piece2.setY(620);
        assertTrue(TetrisMoves.canRotateJto4(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateJto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateJto4(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateJto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[6][0] = 1;
        assertTrue(TetrisMoves.canRotateJto4(t, grid) == false);
    }
    
    @Test
    public void test4CanRotateJto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canRotateJto4(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateJto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        t.piece2.setX(100);
        assertTrue(TetrisMoves.canRotateJto1(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateJto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateJto1(t, grid) == false);
    }
    
    @Test
    public void test3CanRotateJto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canRotateJto1(t, grid) == false);
    }
    
    @Test
    public void test4CanRotateJto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[6][2] = 1;
        assertTrue(TetrisMoves.canRotateJto1(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateZto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canRotateZto2(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateZto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        grid[6][0] = 1;
        assertTrue(TetrisMoves.canRotateZto2(t, grid) == false);
    }
    
    @Test
    public void test1CanRotateZto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateZto3(t, grid) == false);
    }
    
    @Test
    public void test2CanRotateZto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createZ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[6][2] = 1;
        assertTrue(TetrisMoves.canRotateZto3(t, grid) == false);
    }
    
    @Test
    public void test1rotatePieceL() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.rotatePieceL(t, grid);
        assertTrue(t.position == 1);
    }
    
    @Test
    public void test2rotatePieceL() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveRight(t, grid);
        }
        TetrisMoves.rotatePieceL(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void test3rotatePieceL() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveDown(t);
        }
        TetrisMoves.rotatePieceL(t, grid);
        assertTrue(t.position == 3);
    }
    
    @Test
    public void test4rotatePieceL() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        TetrisMoves.rotatePieceL(t, grid);
        assertTrue(t.position == 4);
    }
    
    @Test
    public void test1canRotateLto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        grid[4][0] = 1;
        assertTrue(TetrisMoves.canRotateLto2(t, grid) == false);
    }
    
    @Test
    public void test2canRotateLto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateLto2(t, grid) == false);
    }
    
    @Test
    public void test3canRotateLto2() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canRotateLto2(t, grid) == false);
    }
    
    @Test
    public void test1canRotateLto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[6][0] = 1;
        assertTrue(TetrisMoves.canRotateLto3(t, grid) == false);
    }
    
    @Test
    public void test2canRotateLto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canRotateLto3(t, grid) == false);
    }
    
    @Test
    public void test3canRotateLto3() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateLto3(t, grid) == false);
    }
    
    @Test
    public void test1canRotateLto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[6][2] = 1;
        assertTrue(TetrisMoves.canRotateLto4(t, grid) == false);
    }
    
    @Test
    public void test2canRotateLto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[5][2] = 1;
        assertTrue(TetrisMoves.canRotateLto4(t, grid) == false);
    }
    
    @Test
    public void test3canRotateLto4() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[5][0] = 1;
        assertTrue(TetrisMoves.canRotateLto4(t, grid) == false);
    }
    
    @Test
    public void test1canRotateLto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[4][2] = 1;
        assertTrue(TetrisMoves.canRotateLto1(t, grid) == false);
    }
    
    @Test
    public void test2canRotateLto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[4][1] = 1;
        assertTrue(TetrisMoves.canRotateLto1(t, grid) == false);
    }
    
    @Test
    public void test3canRotateLto1() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createL();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        grid[6][1] = 1;
        assertTrue(TetrisMoves.canRotateLto1(t, grid) == false);
    }
    
    @Test
    public void test1RotatePieceJ() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 10; i++) {
            TetrisMoves.moveRight(t, grid);
        }
        TetrisMoves.rotatePieceJ(t, grid);
        assertTrue(t.position == 2);
    }
    
    @Test
    public void test2RotatePieceJ() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveDown(t);
        }
        TetrisMoves.rotatePieceJ(t, grid);
        assertTrue(t.position == 3);
    }
    
    @Test
    public void test3RotatePieceJ() {
        int[][] grid = new int[10][20];
        Tetromino t = TetrominoFactory.createJ();
        TetrisMoves.moveDown(t);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        TetrisMoves.rotate(t, grid);
        for (int i = 0; i < 20; i++) {
            TetrisMoves.moveLeft(t, grid);
        }
        TetrisMoves.rotatePieceJ(t, grid);
        assertTrue(t.position == 4);
    }
}
