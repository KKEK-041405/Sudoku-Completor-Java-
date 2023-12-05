package Test;

import Sudoku.Block;

public class write {
    public static void writedata(Block[][] Data) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Data[i][j].number + " ");
            }
            System.out.println();
        }
    }
}
