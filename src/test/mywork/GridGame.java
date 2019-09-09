package test.mywork;

import java.util.HashSet;

public class GridGame {

    static boolean isAlive(int grid[][], int row, int col)
    {
        return (row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length) && (grid[row][col] == 1);
    }

    static int computeNeighbours(int grid[][], int x, int y){
        int count = 0;
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int k = 0; k < 8; ++k)
            if(isAlive(grid, rowNbr[k] + x, colNbr[k] + y))
                count++;

        return count;
    }

    static void gridCompute (int grid[][], int rules[], int k){

        if(grid.length ==0 || rules.length ==0 || k==0)
            return;

        HashSet<Integer> rulSet = new HashSet<Integer>();

        for (int x : rules)
            rulSet.add(x);

        int neighbours[][] = new int[grid.length][grid[0].length];

        while (k>0){
            for (int i =0; i<grid.length; i++)
                for (int j=0; j<grid[0].length; j++) {
                    neighbours[i][j] = computeNeighbours(grid, i, j);
                }

            for (int i =0; i<grid.length; i++)
                for (int j=0; j<grid[0].length; j++) {
                    if (rulSet.contains(neighbours[i][j]))
                        grid[i][j] = 1;
                    else
                        grid[i][j] = 0;
                }

            k--;
        }
    }

    public static void main(String args[]){

        int grid [][] = {{0, 1, 1, 0},
                        {1, 1, 0, 0}};

        int lst [] = {3,5};

        gridCompute(grid, lst, 1);

        for (int i =0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

}
