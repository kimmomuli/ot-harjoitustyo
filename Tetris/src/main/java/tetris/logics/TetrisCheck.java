package tetris.logics;

public class TetrisCheck {
    public static boolean gameOver(int[][] grid){
        for (int i = 0; i < 10; i++) {
            if (grid[i][0] == 1) {
                return false;
            }
        }
        return true;
    }
}
