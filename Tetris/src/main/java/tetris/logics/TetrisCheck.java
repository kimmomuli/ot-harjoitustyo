package tetris.logics;

import tetris.ui.GameGUI;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Check is game over and is it possible to remove full rows
 * @author kimmo
 */
public class TetrisCheck {

    /**
     * Check top row
     * @param grid grid(int[][])
     * @return false if something in top row, otherwise true
     */
    public static boolean gameOver(int[][] grid) {
        for (int i = 0; i < 10; i++) {
            if (grid[i][0] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Can you remove full row
     * 
     * This is the hardest part of the project. This idea coming from web.
     * 
     * If you have a full row add it into ArrayList
     * 
     * @param grid grid(int[][])
     * @param screen Pane
     */
    public static void removeRows(int[][] grid, Pane screen) {
        ArrayList<Integer> row = isFullRow(grid);
        while (!row.isEmpty()) {
            checkCounter(row.size());
            removeRow(grid, screen, row);
        }
    }
    
    /**
     * Add points by how many rows to delete
     * @param counter remove rows
     */
    public static void checkCounter(int counter) {
        if (counter == 1) {
            GameGUI.pointsNumber += 100;
        }
        if (counter == 2) {
            GameGUI.pointsNumber += 200;
        }
        if (counter == 3) {
            GameGUI.pointsNumber += 400;
        }
        if (counter == 4) {
            GameGUI.pointsNumber += 800;
        }
    } 
    
    /**
     * Check is in grid full rows
     * @param grid grid(int[][])
     * @return true if is and false if isn't
     */
    public static ArrayList<Integer> isFullRow(int[][] grid) {
        ArrayList<Integer> rows = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[j][i] == 1) {
                    count++;
                }
            }
            if (count == 10) {
                rows.add(i);
            }
            count = 0;
        }
        return rows;
    }
    
    /**
     * Add all rectangles into ArrayList
     * @param grid grid(int[][])
     * @param screen Pane
     * @param row full row
     */
    public static void removeRow(int[][] grid, Pane screen, ArrayList<Integer> row) {
        ArrayList<Node> removeRectangles = new ArrayList<>();
        for (Node a : screen.getChildren()) {
            if (a instanceof Rectangle) {
                removeRectangles.add(a);
            }
        }
        if (!removeRectangles.isEmpty()) {
            deleteLine(removeRectangles, grid, screen, row);
        }
    }
    
    /**
     * Delete full line and otherwise add other ArrayList
     * @param list Rectangles
     * @param grid grid(int[][])
     * @param screen Pane
     * @param row full row
     */
    public static void deleteLine(ArrayList<Node> list, int[][] grid, Pane screen, ArrayList<Integer> row) {
        ArrayList<Node> restTectagle = new ArrayList<>();
        for (Node rec : list) {
            Rectangle rectangle = (Rectangle) rec;
            if (rectangle.getY() == 50 + (row.get(0) * 30)) {
                grid[(int) (rectangle.getX() - 100) / 30][(int) (rectangle.getY() - 50) / 30] = 0;
                screen.getChildren().remove(rectangle);
            } else {
                restTectagle.add(rectangle);
            }
        }
        dropUpperRectangels(grid, screen, restTectagle, row);
    }
    
    /**
     * Check is rectangle upper than full row if it is set on a grid 0
     * @param grid grid(int[][])
     * @param screen Pane
     * @param list All rectangles but no full row rectangles
     * @param row full row
     */
    public static void dropUpperRectangels(int[][] grid, Pane screen, ArrayList<Node> list, ArrayList<Integer> row) {
        for (Node rec : list) {
            Rectangle rectangle = (Rectangle) rec;
            if (rectangle.getY() < 50 + (row.get(0) * 30)) {
                grid[((int) rectangle.getX() - 100) / 30][((int) rectangle.getY() - 50) / 30] = 0;
                rectangle.setY(rectangle.getY() + 30);
            }
        }
        row.remove(0);
        updateGrid(screen, grid);
    }
    
    /**
     * Get all rectangles and set them on a grid 1
     * @param screen Pane
     * @param grid grid([][])
     */
    public static void updateGrid(Pane screen, int[][] grid) {
        ArrayList<Node> update = new ArrayList<>();
        for (Node rec : screen.getChildren()) {
            if (rec instanceof Rectangle) {
                update.add(rec);
            }
        }
        for (Node rec : update) {
            Rectangle rectangle = (Rectangle) rec;
            grid[((int) rectangle.getX() - 100) / 30][((int) rectangle.getY() - 50) / 30] = 1;
        }
    } 
}
