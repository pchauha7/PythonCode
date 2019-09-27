package test.mywork;

import java.util.HashSet;
import java.util.*;

import static java.util.Arrays.asList;

public class GridGame2 {

    static boolean isAlive(List<List<Integer>> grid, int row, int col)
    {
        return (row >= 0) && (row < grid.size()) && (col >= 0) && (col < grid.get(0).size()) && (grid.get(row).get(col) == 1);
    }

    static int computeNeighbours(List<List<Integer>> grid, int x, int y){
        int count = 0;
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int k = 0; k < 8; ++k)
            if(isAlive(grid, rowNbr[k] + x, colNbr[k] + y))
                count++;

        return count;
    }

    static void gridCompute (List<List<Integer>> grid, List<Integer> rules, int k){

        if(grid.size() ==0 || rules.size() ==0 || k==0)
            return;

        HashSet<Integer> rulSet = new HashSet<Integer>();

        for (int x : rules)
            rulSet.add(x);

        int r = grid.size();
        int c = grid.get(0).size();

        int neighbours[][] = new int[r][c];

        while (k>0){
            for (int i =0; i<r; i++)
                for (int j=0; j<c; j++) {
                    neighbours[i][j] = computeNeighbours(grid, i, j);
                }

            for (int i =0; i<r; i++)
                for (int j=0; j<c; j++) {
                    if (rulSet.contains(neighbours[i][j]))
                        grid.get(i).set(j,1);
                    else
                        grid.get(i).set(j,1);
                }

            k--;
        }
    }

    public static void main(String args[]){

        List<List<Integer>> grid = asList(
                asList(0, 1, 1, 0),
                asList(1, 1, 0, 0)
                );

        List<Integer> lst = asList(3,5);

        gridCompute(grid, lst, 1);

        for (int i =0; i<grid.size(); i++) {
            for (int j=0; j<grid.get(0).size(); j++)
                System.out.print(grid.get(i).get(j) + " ");
            System.out.println();
        }
    }

}
