public class TetrisGrid {
    boolean[][] grid;

    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    boolean[][] getGrid(){
        return grid;
    }

    void clearRows(){
        for (int i = grid.length - 1; i >= 0; i--) {
            boolean isFull = true;
            for (boolean j : grid[i]){
                if (j == false) {
                    isFull = false;
                    break;
                }
            }

            if (isFull){
                if (i == grid.length - 1){
                    for (int j = 0; j < grid[i].length; j++){
                        grid[i][j] = false;
                    }
                }

                for (int j = i + 1; j < grid.length; j++) {
                    for (int k = 0; k < grid[j].length; k++) {
                        grid[j-1][k] = grid[j][k];
                    }
                }
            }
        }
    }
}
