public class CharGrid {
    private char[][] grid;

    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    int charArea(char ch){
        int minX = grid[0].length + 1, maxX = -1;
        int minY = grid.length + 1, maxY = -1;
        int area = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == ch) {
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);

                    area = (maxX - minX + 1) * (maxY - minY + 1);
                }
            }
        }

        return area;
    }

    int countPlus(){
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != ' ') {
                    int cnt1 = countLength(i, j, 1, 0);
                    int cnt2 = countLength(i, j, 0, 1);
                    int cnt3 = countLength(i, j, -1, 0);
                    int cnt4 = countLength(i, j, 0, -1);
                    if (cnt1 >= 2 && cnt1 == cnt2 && cnt2 == cnt3 && cnt3 == cnt4) count++;
                }
            }
        }

        return count;
    }

    int countLength(int x, int y, int xi, int yi){
        int count = 1;

        while (grid[x][y] == grid[x + xi][y + yi]) {
            x += xi;
            y += yi;
            count++;
            if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) break;
        }

        return count;
    }

}
