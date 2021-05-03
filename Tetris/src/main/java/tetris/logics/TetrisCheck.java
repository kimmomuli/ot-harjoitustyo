package tetris.logics;

import tetris.ui.Tetris;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class TetrisCheck {
    public static boolean gameOver(int[][] grid){
        for (int i = 0; i < 10; i++) {
            if (grid[i][0] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void removeRows(int[][] grid, Pane screen){
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            int row = isFullRow(grid);
            if (row != -1) {
                counter++;
                removeRow(grid, screen, row);
            } else {
                if (counter == 1) Tetris.pointsNumber += 100;
                if (counter == 2) Tetris.pointsNumber += 200;
                if (counter == 3) Tetris.pointsNumber += 400;
                if (counter == 4) Tetris.pointsNumber += 800;
                break;
            }
        }
    }
    
    public static int isFullRow(int[][] grid){
        int help = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[j][i] == 1) help++;
            }
            if (help == 10) return i;
            help = 0;
        }
        return -1;
    }
    
    public static void removeRow(int[][] grid, Pane screen, int row){
        ArrayList<Node> removeRectangles = new ArrayList<>();
        ArrayList<Node> dropRectangles = new ArrayList<>();
        for (Node a : screen.getChildren()) {
            if (a instanceof Rectangle) {
                Rectangle removeRectangle = (Rectangle) a;
                if (removeRectangle.getY() == 50 + (row * 30)) {
                    removeRectangles.add(a);
                } else if (removeRectangle.getY() < (50 + (row * 30))) {
                    dropRectangles.add(a);
                }
            }
        }
        if (removeRectangles.size() != 0) deleteLine(removeRectangles, grid, screen);
        if (dropRectangles.size() != 0) dropUpperRectangels(grid, screen, dropRectangles);
    }
    
    public static void deleteLine(ArrayList<Node> list, int[][] grid, Pane screen){
        for (Node rec : list) {
            Rectangle rectangle = (Rectangle) rec;
            grid[(int) (rectangle.getX() - 100) / 30][(int) (rectangle.getY() - 50) / 30] = 0;
            screen.getChildren().remove(rectangle);
        }
    }
    
    public static void dropUpperRectangels(int[][] grid, Pane screen, ArrayList<Node> list) {
        for (Node rec : list) {
            Rectangle rectangle = (Rectangle) rec;
            grid[((int) rectangle.getX() - 100) / 30][((int) rectangle.getY() - 50) / 30] = 0;
            rectangle.setY(rectangle.getY() + 30);
        }
        updateGrid(screen, grid);
    }
    
    public static void updateGrid(Pane screen, int[][] grid) {
        ArrayList<Node> update = new ArrayList<>();
        for (Node rec : screen.getChildren()) {
            if (rec instanceof Rectangle) update.add(rec);
        }
        for (Node rec : update) {
            Rectangle rectangle = (Rectangle) rec;
            grid[((int) rectangle.getX() - 100) / 30][((int) rectangle.getY() - 50) / 30] = 1;
        }
    } 
}
