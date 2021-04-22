package tetris;

import javafx.scene.shape.Rectangle;

public class TetrisMoves {
    public final static boolean moveDown(Tetromino t, int[][] grid){
        if (inArea(t) && canMoveDown(t, grid)) {
            moveDown(t);
            return true;
        }
        savePlace(t, grid);
        return false;
    }
    
    public static void moveDown(Tetromino t){
        t.piece1.setY(t.piece1.getY() + 30);
        t.piece2.setY(t.piece2.getY() + 30);
        t.piece3.setY(t.piece3.getY() + 30);
        t.piece4.setY(t.piece4.getY() + 30);
    }
    
    public static boolean inArea(Tetromino t){
        return (t.piece1.getY() < 620 &&
                t.piece2.getY() < 620 &&
                t.piece3.getY() < 620 &&
                t.piece4.getY() < 620);
    }
    
    public static boolean canMoveDown(Tetromino t, int[][] grid){
        return (grid[xCoordinate(t.piece1)][yCoordinate(t.piece1) + 1] == 0 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) + 1] == 0 &&
                grid[xCoordinate(t.piece3)][yCoordinate(t.piece3) + 1] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) + 1] == 0);
    }
    
    public static void savePlace(Tetromino t, int[][] grid){
        grid[xCoordinate(t.piece1)][yCoordinate(t.piece1)] = 1;
        grid[xCoordinate(t.piece2)][yCoordinate(t.piece2)] = 1;
        grid[xCoordinate(t.piece3)][yCoordinate(t.piece3)] = 1;
        grid[xCoordinate(t.piece4)][yCoordinate(t.piece4)] = 1;                         
    }
    
    public static int xCoordinate(Rectangle piece){
        return (int) ((piece.getX() - 100) / 30);
    }
    
    public static int yCoordinate(Rectangle piece){
        return (int) ((piece.getY() - 50) / 30);
    }
    
    public static void moveLeft(Tetromino t, int[][] grid) {
        if (canMoveLeft(t, grid)) {
            t.piece1.setX(t.piece1.getX() - 30);
            t.piece2.setX(t.piece2.getX() - 30);
            t.piece3.setX(t.piece3.getX() - 30);
            t.piece4.setX(t.piece4.getX() - 30);
        }
    }
    
    public static boolean canMoveLeft(Tetromino t, int[][] grid){
        return (t.piece1.getX() > 100 &&
                t.piece2.getX() > 100 &&
                t.piece3.getX() > 100 &&
                t.piece4.getX() > 100 &&
                grid[xCoordinate(t.piece1) - 1][yCoordinate(t.piece1)] == 0 &&
                grid[xCoordinate(t.piece2) - 1][yCoordinate(t.piece2)] == 0 &&
                grid[xCoordinate(t.piece3) - 1][yCoordinate(t.piece3)] == 0 &&
                grid[xCoordinate(t.piece4) - 1][yCoordinate(t.piece4)] == 0);
    }
    
    public static void moveRight(Tetromino t, int[][] grid) {
        if (canMoveRight(t, grid)) {
            t.piece1.setX(t.piece1.getX() + 30);
            t.piece2.setX(t.piece2.getX() + 30);
            t.piece3.setX(t.piece3.getX() + 30);
            t.piece4.setX(t.piece4.getX() + 30);
        }
    }
    
    public static boolean canMoveRight(Tetromino t, int[][] grid){
        return (t.piece1.getX() + 30 < 400 &&
                t.piece2.getX() + 30 < 400 &&
                t.piece3.getX() + 30 < 400 &&
                t.piece4.getX() + 30 < 400 &&
                grid[xCoordinate(t.piece1) + 1][yCoordinate(t.piece1)] == 0 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2)] == 0 &&
                grid[xCoordinate(t.piece3) + 1][yCoordinate(t.piece3)] == 0 &&
                grid[xCoordinate(t.piece4) + 1][yCoordinate(t.piece4)] == 0);
    }
    
    public static void rotate(Tetromino t){
        switch(t.name){
            case "O":
                break;
            case "I":
                
            case "S":
                
            case "Z":
                
            case "L":
                
            case "J":
                
            case "T":
                
        }
    }
}