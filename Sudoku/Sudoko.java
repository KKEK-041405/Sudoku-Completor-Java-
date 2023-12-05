package Sudoku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * sudoko
 */
public class Sudoko {
    ArrayList<Integer>[] row = new ArrayList[9];
    ArrayList<Integer>[] cols = new ArrayList[9];
    public Block[][] blocks = new Block[9][9];
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> nums = new ArrayList<Integer>();

    public Sudoko() {

        for (int i = 0; i < 9; i++) {

            nums.add(i);// add hints

            row[i] = new ArrayList<Integer>();// creating new rows

            System.out.println("enter the " + i + "th row elements");

            for (int j = 0; j < 9; j++) {
                int num = sc.nextInt();// getting each element in a row
                blocks[i][j] = new Block(num);// creating Block object for each element in a row
            }
        }

        // printing the sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(blocks[i][j].number + " ");
            }
            System.out.println();
        }
        nums.add(9);
    }

    public int hints(int x, int y) {
        if (!blocks[x][y].ismutable)
            return -1;

        ArrayList<Integer> hint = (ArrayList<Integer>) nums.clone();

        for (int i = 0; i < 9; i++) {
            if (hint.contains(blocks[x][i].number))
                hint.remove(hint.indexOf(blocks[x][i].number));
            if (hint.contains(blocks[i][y].number))
                hint.remove(hint.indexOf(blocks[i][y].number));
        }
        int xlimt = x / 3;
        xlimt *= 3;
        int ylimt = y / 3;
        ylimt *= 3;
        for (int i = xlimt; i < xlimt + 3; i++) {
            for (int j = ylimt; j < ylimt + 3; j++) {
                if (hint.contains(blocks[i][j].number))
                    hint.remove(hint.indexOf(blocks[i][j].number));
            }
        }

        blocks[x][y].hints = hint;
        if (hint.size() == 1 && blocks[x][y].ismutable)
            return adjust(blocks[x][y], 0);

        System.out.println(blocks[x][y].hints);
        return 0;

    }

    private int adjust(Block block, int i) {
        block.number = block.hints.get(i);
        block.ismutable = false;
        return 1;
    }

    public void Verify() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (hints(i, j) == 1) {
                    i = 0;
                    j = 0;
                }
            }
        }
    }
}