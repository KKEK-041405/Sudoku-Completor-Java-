import Sudoku.Sudoko;
import Test.write;
import UI.UI;

public class App {
    public static void main(String[] args) {
        System.out.println("enter the rows in sudoku");
        Sudoko sudoko = new Sudoko();

        new UI(sudoko.blocks);
        sudoko.Verify();
        write.writedata(sudoko.blocks);
    }
}