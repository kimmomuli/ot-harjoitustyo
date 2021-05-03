package tetris.logics;

import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

public class TetrisMoves {
    public final static boolean moveDown(Tetromino t, int[][] grid, Pane screen) {
        if (inArea(t) && canMoveDown(t, grid)) {
            moveDown(t);
            return false;
        }
        savePlace(t, grid);
        TetrisCheck.removeRows(grid, screen);
        return true;
    }
    
    public static void moveDown(Tetromino t) {
        t.piece1.setY(t.piece1.getY() + 30);
        t.piece2.setY(t.piece2.getY() + 30);
        t.piece3.setY(t.piece3.getY() + 30);
        t.piece4.setY(t.piece4.getY() + 30);
    }
    
    public static boolean inArea(Tetromino t) {
        return (t.piece1.getY() < 620 &&
                t.piece2.getY() < 620 &&
                t.piece3.getY() < 620 &&
                t.piece4.getY() < 620);
    }
    
    public static boolean canMoveDown(Tetromino t, int[][] grid) {
        return (grid[xCoordinate(t.piece1)][yCoordinate(t.piece1) + 1] == 0 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) + 1] == 0 &&
                grid[xCoordinate(t.piece3)][yCoordinate(t.piece3) + 1] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) + 1] == 0);
    }
    
    public static void savePlace(Tetromino t, int[][] grid) {
        grid[xCoordinate(t.piece1)][yCoordinate(t.piece1)] = 1;
        grid[xCoordinate(t.piece2)][yCoordinate(t.piece2)] = 1;
        grid[xCoordinate(t.piece3)][yCoordinate(t.piece3)] = 1;
        grid[xCoordinate(t.piece4)][yCoordinate(t.piece4)] = 1;                         
    }
    
    public static int xCoordinate(Rectangle piece) {
        return (int) ((piece.getX() - 100) / 30);
    }
    
    public static int yCoordinate(Rectangle piece) {
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
    
    public static boolean canMoveLeft(Tetromino t, int[][] grid) {
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
    
    public static boolean canMoveRight(Tetromino t, int[][] grid) {
        return (t.piece1.getX() + 30 < 400 &&
                t.piece2.getX() + 30 < 400 &&
                t.piece3.getX() + 30 < 400 &&
                t.piece4.getX() + 30 < 400 &&
                grid[xCoordinate(t.piece1) + 1][yCoordinate(t.piece1)] == 0 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2)] == 0 &&
                grid[xCoordinate(t.piece3) + 1][yCoordinate(t.piece3)] == 0 &&
                grid[xCoordinate(t.piece4) + 1][yCoordinate(t.piece4)] == 0);
    }
    
    public static void rotate(Tetromino t, int[][] grid) {
        if (t.name.equals("I")) {
            rotatePieceI(t, grid);
        }
        if (t.name.equals("S")) {
            rotatePieceS(t, grid);
        }
        if (t.name.equals("Z")) {
            rotatePieceZ(t, grid);
        }
        if (t.name.equals("L")) {
            rotatePieceL(t, grid);
        }
        if (t.name.equals("J")) {
            rotatePieceJ(t, grid);
        }
        if (t.name.equals("T")) {
            rotatePieceT(t, grid);
        }
    }
    
    public static void rotatePieceI(Tetromino t, int[][] grid) {
        if (t.position == 1 || t.position == 3) {
            if (canRotateITo2(t, grid)) {
                rotateIto2(t);
            }
        } else {
            if (canRotateITo3(t, grid)) {
                rotateIto3(t);
            }
        }
    }
    
    public static void rotateIto2(Tetromino t) {
        t.piece1.setX(t.piece1.getX() + 30);
        t.piece2.setY(t.piece2.getY() + 30);
        t.piece3.setX(t.piece3.getX() - 30);
        t.piece3.setY(t.piece3.getY() + 60);
        t.piece4.setX(t.piece4.getX() - 60);
        t.piece4.setY(t.piece4.getY() + 90);
        t.changePostion();
    }
    
    public static void rotateIto3(Tetromino t) {
        t.piece1.setX(t.piece1.getX() - 30);
        t.piece2.setY(t.piece2.getY() - 30);
        t.piece3.setX(t.piece3.getX() + 30);
        t.piece3.setY(t.piece3.getY() - 60);
        t.piece4.setX(t.piece4.getX() + 60);
        t.piece4.setY(t.piece4.getY() - 90);
        t.changePostion();
    }
    
    public static boolean canRotateITo2(Tetromino t, int[][] grid) {
        return  (t.piece2.getY() < 560 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) + 1] == 0 && 
                grid[xCoordinate(t.piece3) - 1][yCoordinate(t.piece3) + 2] == 0 &&
                grid[xCoordinate(t.piece4) - 2][yCoordinate(t.piece4) + 3] == 0);
    }
    
    public static boolean canRotateITo3(Tetromino t, int[][] grid) {
        int xHelp = xCoordinate(t.piece1);
        int yHelp = yCoordinate(t.piece1);
        return (t.piece1.getX() > 100 && 
                t.piece1.getX() < 340 &&
                grid[xHelp - 1][yHelp] == 0 &&
                grid[xHelp + 1][yHelp] == 0 &&
                grid[xHelp + 2][yHelp] == 0);
    }
    
    public static void rotatePieceS(Tetromino t, int[][] grid) {
        if (t.position == 1 || t.position == 3) {
            if (canRotateSto2(t, grid)) {
                t.piece3.setY(t.piece3.getY() - 60);
                t.piece4.setX(t.piece4.getX() + 60);
                t.changePostion();
            }
        } else {
            if (canRotateSto3(t, grid)) {
                t.piece3.setY(t.piece3.getY() + 60);
                t.piece4.setX(t.piece4.getX() - 60);
                t.changePostion();
            }
        }
    }
    
    public static boolean canRotateSto2(Tetromino t, int[][] grid) {
        return (t.piece1.getY() > 50 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) - 1] == 0 &&
                grid[xCoordinate(t.piece1)][yCoordinate(t.piece1) + 1] == 0);
    }
    
    public static boolean canRotateSto3(Tetromino t, int[][] grid) {
        return (t.piece2.getX() > 100 && 
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) + 1] == 0 && 
                grid[xCoordinate(t.piece4) - 2][yCoordinate(t.piece4)] == 0);
    }
    
    public static void rotatePieceZ(Tetromino t, int[][] grid) {
        if (t.position == 1 || t.position == 3) {
            if (canRotateZto2(t, grid)) {
                t.piece1.setX(t.piece1.getX() + 60);
                t.piece4.setY(t.piece4.getY() - 60);
                t.changePostion();
            }
        } else {
            if (canRotateZto3(t, grid)) {
                t.piece1.setX(t.piece1.getX() - 60);
                t.piece4.setY(t.piece4.getY() + 60);
                t.changePostion();
            }
        }
    }
    
    public static boolean canRotateZto2(Tetromino t, int[][] grid) {
        return (t.piece1.getY() > 50 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2)] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) - 2] == 0);
    }
    
    public static boolean canRotateZto3(Tetromino t, int[][] grid) {
        return (t.piece2.getX() > 100 &&
                grid[xCoordinate(t.piece2) - 1][yCoordinate(t.piece2)] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) + 2] == 0);
    }
    
    public static void rotatePieceL(Tetromino t, int[][] grid) {
        if (t.position == 1) {
            if (canRotateLto2(t, grid)) {
                rotateLto2(t);
            }
        } else if (t.position == 2) {
            if (canRotateLto3(t, grid)) {
                rotateLto3(t);
            }
        } else if (t.position == 3) {
            if (canRotateLto4(t, grid)) {
                rotateLto4(t);
            }
        } else if (t.position == 4) {
            if (canRotateLto1(t, grid)) {
                rotateLto1(t);
            }
        } 
    }
    
    public static void rotateLto2(Tetromino t) {
        t.piece1.setY(t.piece1.getY() - 60);
        t.piece2.setY(t.piece2.getY() - 30);
        t.piece2.setX(t.piece2.getX() + 30);
        t.piece4.setY(t.piece4.getY() + 30);
        t.piece4.setX(t.piece4.getX() - 30);
        t.changePostion();
    }
    
    public static void rotateLto3(Tetromino t) {
        t.piece1.setX(t.piece1.getX() + 60);
        t.piece2.setX(t.piece2.getX() + 30);
        t.piece2.setY(t.piece2.getY() + 30);
        t.piece4.setY(t.piece4.getY() - 30);
        t.piece4.setX(t.piece4.getX() - 30);
        t.changePostion();
    }
    
    public static void rotateLto4(Tetromino t) {
        t.piece1.setY(t.piece1.getY() + 60);
        t.piece2.setX(t.piece2.getX() - 30);
        t.piece2.setY(t.piece2.getY() + 30);
        t.piece4.setY(t.piece4.getY() - 30);
        t.piece4.setX(t.piece4.getX() + 30);
        t.changePostion();
    }
    
    public static void rotateLto1(Tetromino t) {
        t.piece1.setX(t.piece1.getX() - 60);
        t.piece2.setX(t.piece2.getX() - 30);
        t.piece2.setY(t.piece2.getY() - 30);
        t.piece4.setY(t.piece4.getY() + 30);
        t.piece4.setX(t.piece4.getX() + 30);
        t.changePostion();
    }
    
    public static boolean canRotateLto2(Tetromino t, int[][] grid) {
        return (t.piece2.getY() > 50 &&
                grid[xCoordinate(t.piece1)][yCoordinate(t.piece1) - 2] == 0 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2) - 1] == 0 &&
                grid[xCoordinate(t.piece4) - 1][yCoordinate(t.piece4) + 1] == 0);
    }
    
    public static boolean canRotateLto3(Tetromino t, int[][] grid) {
        return (t.piece2.getX() < 370 &&
                grid[xCoordinate(t.piece1) + 2][yCoordinate(t.piece1)] == 0 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2) + 1] == 0 &&
                grid[xCoordinate(t.piece4) - 1][yCoordinate(t.piece4) - 1] == 0);
    }
    
    public static boolean canRotateLto4(Tetromino t, int[][] grid) {
        return (t.piece2.getY() < 620 && 
                grid[xCoordinate(t.piece1)][yCoordinate(t.piece1) + 2] == 0 &&
                grid[xCoordinate(t.piece2) - 1][yCoordinate(t.piece2) + 1] == 0 &&
                grid[xCoordinate(t.piece4) + 1][yCoordinate(t.piece4) - 1] == 0);
    }
    
    public static boolean canRotateLto1(Tetromino t, int[][] grid) {
        return (t.piece2.getX() > 100 &&
                grid[xCoordinate(t.piece1) - 2][yCoordinate(t.piece1)] == 0 &&
                grid[xCoordinate(t.piece2) - 1][yCoordinate(t.piece2) - 1] == 0 &&
                grid[xCoordinate(t.piece4) + 1][yCoordinate(t.piece4) + 1] == 0);
    }
    
    public static void rotatePieceJ(Tetromino t, int[][] grid) {
        if (t.position == 1) {
            if (canRotateJto2(t, grid)) {
                rotateJto2(t);
            }
        } else if (t.position == 2) {
            if (canRotateJto3(t, grid)) {
                rotateJto3(t);
            }
        } else if (t.position == 3) {
            if (canRotateJto4(t, grid)) {
                rotateJto4(t);
            }
        } else if (t.position == 4) {
            if (canRotateJto1(t, grid)) {
                rotateJto1(t);
            }
        } 
    }
    
    public static void rotateJto2(Tetromino t) {
        t.piece1.setY(t.piece1.getY() - 30);
        t.piece1.setX(t.piece1.getX() + 30);
        t.piece3.setY(t.piece3.getY() + 30);
        t.piece3.setX(t.piece3.getX() - 30);
        t.piece4.setX(t.piece4.getX() - 60);
        t.changePostion();
    }
    
    public static void rotateJto3(Tetromino t) {
        t.piece1.setY(t.piece1.getY() + 30);
        t.piece1.setX(t.piece1.getX() + 30);
        t.piece3.setY(t.piece3.getY() - 30);
        t.piece3.setX(t.piece3.getX() - 30);
        t.piece4.setY(t.piece4.getY() - 60);
        t.changePostion();
    }
    
    public static void rotateJto4(Tetromino t) {
        t.piece1.setY(t.piece1.getY() + 30);
        t.piece1.setX(t.piece1.getX() - 30);
        t.piece3.setY(t.piece3.getY() - 30);
        t.piece3.setX(t.piece3.getX() + 30);
        t.piece4.setX(t.piece4.getX() + 60);
        t.changePostion();
    }
    
    public static void rotateJto1(Tetromino t) {
        t.piece1.setY(t.piece1.getY() - 30);
        t.piece1.setX(t.piece1.getX() - 30);
        t.piece3.setY(t.piece3.getY() + 30);
        t.piece3.setX(t.piece3.getX() + 30);
        t.piece4.setY(t.piece4.getY() + 60);
        t.changePostion();
    }
    
    public static boolean canRotateJto2(Tetromino t, int[][] grid) {
        return (t.piece2.getY() > 50 &&
                grid[xCoordinate(t.piece1) + 1][yCoordinate(t.piece1) - 1] == 0 &&
                grid[xCoordinate(t.piece3) - 1][yCoordinate(t.piece3) + 1] == 0 &&
                grid[xCoordinate(t.piece4) - 2][yCoordinate(t.piece4)] == 0);
    }
    
    public static boolean canRotateJto3(Tetromino t, int[][] grid) {
        return (t.piece2.getX() < 370 &&
                grid[xCoordinate(t.piece1) + 1][yCoordinate(t.piece1) + 1] == 0 &&
                grid[xCoordinate(t.piece3) - 1][yCoordinate(t.piece3) - 1] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) - 2] == 0);
    }
    
    public static boolean canRotateJto4(Tetromino t, int[][] grid) {
        return (t.piece2.getY() < 620 &&
                grid[xCoordinate(t.piece1) - 1][yCoordinate(t.piece1) + 1] == 0 &&
                grid[xCoordinate(t.piece3) + 1][yCoordinate(t.piece3) - 1] == 0 &&
                grid[xCoordinate(t.piece4) + 2][yCoordinate(t.piece4)] == 0);
    }
    
    public static boolean canRotateJto1(Tetromino t, int[][] grid) {
        return (t.piece2.getX() > 100 &&
                grid[xCoordinate(t.piece1) - 1][yCoordinate(t.piece1) - 1] == 0 &&
                grid[xCoordinate(t.piece3) + 1][yCoordinate(t.piece3) + 1] == 0 &&
                grid[xCoordinate(t.piece4)][yCoordinate(t.piece4) + 2] == 0);
    }
    
    public static void rotatePieceT(Tetromino t, int[][] grid) {
        if (t.position == 1) {
            if (canRotateTo2(t, grid)) {
                rotateTto2(t);
            }
        } else if (t.position == 2) {
            if (canRotateTo3(t, grid)) {
                rotateTto3(t);
            }
        } else if (t.position == 3) {
            if (canRotateTo4(t, grid)) {
                rotateTto4(t);
            }
        } else if (t.position == 4) {
            if (canRotateTo1(t, grid)) {
                rotateTto1(t);
            }
        } 
    }

    public static void rotateTto2(Tetromino t) {
        t.piece3.setY(t.piece3.getY() - 30);
        t.piece3.setX(t.piece3.getX() - 30);
        t.changePostion();
    }
    
    public static void rotateTto3(Tetromino t) {
        t.piece4.setY(t.piece4.getY() - 30);
        t.piece4.setX(t.piece4.getX() + 30);
        t.changePostion();
    }
    
    public static void rotateTto4(Tetromino t) {
        t.piece1.setY(t.piece1.getY() + 30);
        t.piece1.setX(t.piece1.getX() + 30);
        t.changePostion();
    }
    
    public static void rotateTto1(Tetromino t) {
        t.piece1.setY(t.piece1.getY() - 30);
        t.piece1.setX(t.piece1.getX() - 30);
        t.piece3.setY(t.piece3.getY() + 30);
        t.piece3.setX(t.piece3.getX() + 30);
        t.piece4.setY(t.piece4.getY() + 30);
        t.piece4.setX(t.piece4.getX() - 30);
        t.changePostion();
    }
    
    public static boolean canRotateTo2(Tetromino t, int[][] grid) {
        return (t.piece2.getY() > 50 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) - 1] == 0);
    }
    
    public static boolean canRotateTo3(Tetromino t, int[][] grid) {
        return (t.piece2.getX() < 370 &&
                grid[xCoordinate(t.piece2) + 1][yCoordinate(t.piece2)] == 0);
    }
    
    public static boolean canRotateTo4(Tetromino t, int[][] grid) {
        return (t.piece2.getY() < 620 &&
                grid[xCoordinate(t.piece2)][yCoordinate(t.piece2) + 1] == 0);
    }
    
    public static boolean canRotateTo1(Tetromino t, int[][] grid) {
        return (t.piece2.getX() > 100 &&
                grid[xCoordinate(t.piece2) - 1][yCoordinate(t.piece2)] == 0);
    }
}