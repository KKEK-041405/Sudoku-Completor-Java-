package Sudoku;

import java.util.ArrayList;
import java.util.Scanner;

import Test.write;

/**
 * sudoko
 */
public class Sudoko {
    ArrayList<Integer>[] row = new ArrayList[9];
    ArrayList<Integer>[] cols = new ArrayList[9];
    public Block[][] blocks = new Block[9][9];
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> nums = new ArrayList<Integer>();

    public Sudoko() throws InterruptedException {

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
        write.writedata(blocks);
        nums.add(9);

        System.out.println("sudoku is created");
        Thread.currentThread().sleep(1000);
    }

    public int hints(int x, int y) throws InterruptedException {
        if (!blocks[x][y].ismutable)
            return -1;

        ArrayList<Integer> hint = (ArrayList<Integer>) nums.clone();

        for (int i = 0; i < 9; i++) {
            if (hint.contains(blocks[x][i].number))
                hint.remove(hint.indexOf(blocks[x][i].number));
            if (hint.contains(blocks[i][y].number))
                hint.remove(hint.indexOf(blocks[i][y].number));
        }
        // setting the current box limits
        int xlimt = x / 3;
        xlimt *= 3;
        int ylimt = y / 3;
        ylimt *= 3;
        // fecthing the numbers in current box
        for (int i = xlimt; i < xlimt + 3; i++) {
            for (int j = ylimt; j < ylimt + 3; j++) {
                if (hint.contains(blocks[i][j].number))
                    hint.remove(hint.indexOf(blocks[i][j].number));
            }
        }
        // saving hints
        blocks[x][y].hints = hint;

        // if the number of hints availabe for current block is one
        // then it is the value of the block
        if (hint.size() == 1 && blocks[x][y].ismutable)
            return adjust(blocks[x][y], 0);

        return 0;

    }

    private int adjust(Block block, int i) throws InterruptedException {
        block.number = block.hints.get(i);
        block.ismutable = false;
        UI.UI.window.repaint();
        (Thread.currentThread()).sleep(1000);
        return 1;
    }

    public void slove() throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (hints(i, j) == 1) {
                    i = 0;
                    j = -1;
                }
            }
        }
    }
}