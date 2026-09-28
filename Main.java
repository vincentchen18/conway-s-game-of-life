package ConwaysGameOfLife;

import java.util.HashMap;

public class Main {
    static HashMap<Boolean, String> dic = new HashMap<Boolean, String>();

    public static void main(String[] args) {
        final int W = 15;
        final int H = 15;
        boolean[][] grid = new boolean[H][W];
        dic.put(false, ".");
        dic.put(true, "X");
        for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if ((i==0&&j==1)||(i==1&&j==2)||(i==2&&(j==0||j==1||j==2))){
                        grid[i][j] = true;
                    } else {
                        grid[i][j] = false;
                    }
                }
        }

        ppprint(grid);

        while (not_end(grid)) {
            boolean[][] newgrid = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    check(j, i, grid, newgrid);
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    grid[i][j] = newgrid[i][j];
                }
            }
            ppprint(grid);
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Thread was interrupted!");
            }
            System.out.println();
            

        }


    }

    public static int checker(int cell_x, int cell_y, boolean[][] grad) {
            if (cell_x < 0 || cell_y < 0 || cell_x >= grad[0].length || cell_y >= grad.length) {
                return 0;
            }
            if (grad[cell_y][cell_x]) {
                return 1;
            } else {
                return 0;
            }
    }
    public static boolean[][] check(int cell_x, int cell_y, boolean[][] grad, boolean[][] naw) {
        if (grad[cell_y][cell_x]) {
            int val = checker(cell_x+1, cell_y, grad) + checker(cell_x-1, cell_y, grad) + checker(cell_x, cell_y+1, grad) + checker(cell_x, cell_y-1, grad) + checker(cell_x+1, cell_y+1, grad) + checker(cell_x+1, cell_y-1, grad) + checker(cell_x-1, cell_y+1, grad) + checker(cell_x-1, cell_y-1, grad);
            if (val == 2 || val == 3){
                naw[cell_y][cell_x] = true;
            }
        } else{ 
            int val = checker(cell_x+1, cell_y, grad) + checker(cell_x-1, cell_y, grad) + checker(cell_x, cell_y+1, grad) + checker(cell_x, cell_y-1, grad) + checker(cell_x+1, cell_y+1, grad) + checker(cell_x+1, cell_y-1, grad) + checker(cell_x-1, cell_y+1, grad) + checker(cell_x-1, cell_y-1, grad);
            if (val == 3) {
                naw[cell_y][cell_x] = true;
            }
        }
    return naw;
    }
    public static void ppprint(boolean[][] g) {
        for (boolean[] r:g) {
            String[] row = new String[r.length];
            for (int j = 0; j < r.length; j++) {
                row[j] = dic.get(r[j]);
            }
            System.out.println(String.join(" ", row));
        }
    }
    public static boolean not_end(boolean[][] greed) {
    for (boolean[] row: greed) {
        for (boolean cell: row) {
            if (cell) {
                return true;
            }
        }
    }
    return false;
}
}