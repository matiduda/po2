import java.util.Scanner;
import static java.lang.System.out;

class Program {
    private final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new Program().run();
    }

    public void run() {
        do {
            new Game(scan).play();
        } while (shouldPlayAgain());
    }

    private boolean shouldPlayAgain() {
        while (true) {
            out.print("Do you want to play again? (y|n): ");
            String answer = scan.nextLine().toLowerCase();

            if (answer.startsWith("y"))
                return true;
            if (answer.startsWith("n"))
                return false;
        }
    }
}