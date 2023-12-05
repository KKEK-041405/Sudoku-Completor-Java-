package UI;

import Sudoku.Block;
import Sudoku.Sudoko;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * UI
 */

public class UI {
    public static JFrame window = new JFrame();;

    public UI(Block[][] blocks) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                window.add(blocks[i][j]);
            }

        }

        window.setSize(300, 300);
        window.setLayout(new GridLayout(9, 9, 2, 2));
        window.setVisible(true);
    }

    public static void update(Block[][] blocks) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                window.add(blocks[i][j]);
            }

        }
    }

}