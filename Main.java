import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int xlimt = new Scanner(System.in).nextInt() / 3;
        xlimt *= 3;
        int ylimt = new Scanner(System.in).nextInt() / 3;
        ylimt *= 3;
        for (int i = 0; i < xlimt + 3; i++) {
            for (int j = ylimt; j < ylimt + 3; j++) {
                System.out.println("" + i + " " + j);
            }
        }
    }
}
