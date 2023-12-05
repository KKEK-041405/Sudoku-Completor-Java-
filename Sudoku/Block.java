package Sudoku;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Block extends JComponent {
    public int number;
    public Boolean ismutable = true;
    public ArrayList<Integer> hints = new ArrayList<Integer>();

    Block() {

    }

    Block(int a) {
        this.number = a;
        if (a != 0)
            ismutable = false;
    }

    void verify() {
        if (hints.size() == 1) {
            this.number = hints.get(0);
            ismutable = false;
        }
    }

    public void setNumber(int number) {
        this.number = number;
        repaint(); // Repaint the component when the number changes
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the base class paint method first

        // Draw the number centered within the component
        FontMetrics metrics = g.getFontMetrics();
        String text = String.valueOf(number);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() - textHeight) / 2 + metrics.getAscent();
        setBorder(BorderFactory.createLineBorder(Color.black));
        g.drawString(text, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        // Define the preferred size based on the font metrics and text width
        FontMetrics metrics = getFontMetrics(getFont());
        String text = String.valueOf(number);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();

        return new Dimension(textWidth + 10, textHeight + 10);
    }
}
