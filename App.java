import Sudoku.Sudoko;
import Test.write;
import UI.UI;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("enter the rows in sudoku");
        // creating new sudoku
        Sudoko sudoko = new Sudoko();

        // initlizing the user interface
        new UI(sudoko.blocks);
        // sloving the sudoku
        sudoko.slove();

        // printing the sloved sudoku
        write.writedata(sudoko.blocks);
    }
}