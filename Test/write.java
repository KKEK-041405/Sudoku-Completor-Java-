package Test;

import Sudoku.Block;

public class write {
    public static void writedata(Block[][] Data) {
        for (Block[] row : Data) {
            for (Block block : row) {
                System.out.print(block.number + " ");
                System.out.println(block.hints);
            }
        }
    }
}
