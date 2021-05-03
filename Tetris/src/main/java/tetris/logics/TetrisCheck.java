package tetris.logics;

import tetris.ui.GameGUI;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class TetrisCheck {
    public static boolean gameOver(int[][] grid) {
        for (int i = 0; i < 10; i++) {
            if (grid[i][0] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void removeRows(int[][] grid, Pane screen) {
        ArrayList<Integer> row = isFullRow(grid);
        while (!row.isEmpty()) {
            checkCounter(row.size());
            removeRow(grid, screen, row);
        }
    }
    
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
