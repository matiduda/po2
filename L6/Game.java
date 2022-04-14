// import java.util.InputMismatchException;
// import java.util.Scanner;
// import static java.lang.System.out;

// class Game {
//     private final Scanner scan;
//     private final int numberRange;
//     private final int numberToGuess;

//     public Game(Scanner scan, int numberRange) {
//         this.scan = scan;
//         this.numberRange = numberRange;
//     }

//     public Game(Scanner scan) {
//         this(scan, selectRandomNumber(scan));
//     }

//     private static int selectRandomNumber(Scanner scan) {
//         return getInt(scan, "Number range: ");
//     }

//     private static int getInt(Scanner scan, String message) {
//         while (true) {
//             out.print(message);
//             try {
//                 return scan.nextInt();
//             }
//             catch (InputMismatchException exc) {
//                 out.println("Incorrect input");
//             }
//             finally {
//                 scan.nextLine();
//             }
//         }
//     }

//     /**
//      * @return true if won.
//      */
//     private boolean gameRound() {
//         int guess = getInt(
//             scan, String.format("Make a guess (0 - %d): ", numberRange)
//         );

//         if (guess < numberToGuess) {
//             out.println("Not enough");
//             return false;
//         }
//         if (guess > numberToGuess) {
//             out.println("Too much");
//             return false;
//         }

//         return true;
//     }

//     public void play() {
//         int tries;
//         for (tries = 1; !gameRound(); tries++) ;
//         out.printf("Nice! Number of tries: %d%n", tries);
//     }
// }