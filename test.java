import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> myList = new ArrayList<String>();
        String myWord = "ant";

        for (int i = 0; i < myWord.length(); i++) {
            myList.add("_");
        }

        // Print myList
        for (int i = 0; i < 1; i++) {
            System.out.print("\n\t");
        }
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("\n");

        // Getting user guess
        game(scan, myList, myWord);

    }

    private static void game(Scanner scan, List<String> myList, String myWord) {
        System.out.println("Guess: \n");
        String userGuess = scan.nextLine();

        for (int i = 0; i < myWord.length(); i++) {
            try {
                // Getting the index of the guess from 'myWord'
                int indexOfGuess = myWord.indexOf(userGuess);
                // Return the guessed letter from 'myWord' by it's index
                char guessedLetter = myWord.charAt(indexOfGuess);
                // Converting char to string
                String guessedLetterString = String.valueOf(guessedLetter);

                // Replace guessed letter to it's index
                myList.set(indexOfGuess, guessedLetterString);

                // 'Clear' terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Print myList
                for (int d = 0; d < 1; d++) {
                    System.out.print("\n\t");
                }
                for (int c = 0; c < myList.size(); c++) {
                    System.out.print(myList.get(c) + " ");
                }
                System.out.println("\n");

                // Break out (or start guess over) the loop after printing 'myList' once
                game(scan, myList, myWord);

            } catch (Exception e) {
                System.out.println("No such letter...");
                game(scan, myList, myWord);
            }

        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
