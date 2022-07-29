import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    // public static String[] words = {"ant", "baboon", "badger", "bat", "bear",
    // "beaver", "camel",
    // "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    // "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    // "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    // "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
    // "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    // "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    // "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    // "wombat", "zebra"};

    public static String[] words = { "ant" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        //Life
        int hangManCounter = 0;
        int myLife = 6;

        // Estabilishing scanner
        Scanner scan = new Scanner(System.in);

        // Creating table -------------------------------
        List<String> myTable = new ArrayList();
        for (int i = 0; i < words[0].length(); i++) {
            myTable.add("_");
        }

        // Print out table
        printTable(myTable);

        // Ask user to guess
        guessMethod(scan, myTable, myLife, gallows, hangManCounter);

    }

    // Ask user to guess
    private static void guessMethod(Scanner scan, List<String> myTable, int myLife, String[] gallows, int hangManCounter) {
        resetStats(myLife, hangManCounter);
        System.out.println("Guess: ");
        String userGuess = scan.nextLine();

        // Checking if user guess (letter) is in the word
        try {
            // Get the index of the guessed letter from word
            int indexOfGuess = words[0].indexOf(userGuess);
            // return the letter using the index
            char guessedLetter = words[0].charAt(indexOfGuess);
            // transform char to string
            String guessedLetterString = String.valueOf(guessedLetter);

            // Replacing the returned letter in 'myTable'
            myTable.set(indexOfGuess, guessedLetterString);
            printTable(myTable);

            // Check if guessed all
            boolean guessedAll =  myTable.contains("_");
            if (!guessedAll == true){
                System.out.println("You won!");
                askToPlayMore(scan, myTable, myLife, gallows, hangManCounter);
            }

            guessMethod(scan, myTable, myLife, gallows, hangManCounter);
            

        } catch (Exception e) {
            myLife--;
            hangManCounter++;
            System.out.println("You have " + myLife + " life left.");

            // TODO: print out current hangman
            System.out.println(gallows[hangManCounter]);

            // Check if lost
            if (myLife == 0) {
                System.out.println("You lost!");
                askToPlayMore(scan, myTable, myLife, gallows, hangManCounter);
            }
            else{
                guessMethod(scan, myTable, myLife, gallows, hangManCounter);
            }


            
        }
    }

    private static void askToPlayMore(Scanner scan, List<String> myTable, int myLife, String[] gallows, int hangManCounter) {
        System.out.println("Play one more? (y/n)");
        String playMore = scan.nextLine();
        if (playMore.equals("y")){
            guessMethod(scan, myTable, myLife, gallows, hangManCounter);
        }
        else if (playMore.equals("n")){
            System.out.println("Good Bye!!!");
            System.exit(0);
        }
    }

    // Print out table
    private static void printTable(List<String> myTable) {
        System.out.print("\n\t");
        for (int i = 0; i < myTable.size(); i++) {
            System.out.print(myTable.get(i) + " ");
        }
        System.out.println("\n");
    }

    public static int resetStats(int myLife, int hangManCounter) {
        myLife = 6;
        hangManCounter = 0;

        
        
        return myLife;
    }
}
