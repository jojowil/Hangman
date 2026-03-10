import java.util.Scanner;

public class Hangman {

    static Scanner kb = new Scanner(System.in);
    static StringBuilder usedChars = new StringBuilder();
    static int guesses;

    static void printInstructions() {
        System.out.println("""

In Hangman, you must guess the mysterious
word. You have only 6 chances to get to the
end. You stay alive by continuing to match
letters in the word or solving the puzzle.

On your turn, decide if you want to guess a
letter or the entire word. Failure to guess a
correct letter or the whole word removes one
chances.
                 
Let's begin.
 """);

    }

    static boolean takeTurn(String word, StringBuilder hmword) {
        while (true) {
            //System.out.println("The word is " + word); //debug
            System.out.println("\nYou have " + guesses + " guesses remaining.");
            System.out.println("The word is " + word.length() + " characters long: " + hmword);

            System.out.print("Please enter a LETTER: ");
            char choice = kb.next().toUpperCase().charAt(0);

            // check for alpha
            if (!Character.isAlphabetic(choice)) {
                System.out.println("\nYour choice MUST be alphabetic!\n");
                continue;
            }

            // check used letter list
            if (usedChars.toString().indexOf(choice) != -1) {
                System.out.println("\nYou've already used " + choice + "!");
                continue;
            }

            // add choice to used list
            usedChars.append(choice);
            StringBuilder temp = new StringBuilder(hmword);
            // take valid choice and fill in if match
            for (int x = 0; x < word.length(); x++)
                if (word.charAt(x) == choice)
                    hmword.setCharAt(x, choice);

            // if nothing changed, remove a guess
            if (temp.compareTo(hmword) == 0)
                guesses--;

            break;
        }
        return word.contentEquals(hmword);
    }

    static void main() {

        String[] words = {"SYNDROME", "BANDWAGON", "TRANSCRIPT", "NIGHTCLUB",
                "VAPORIZE", "JACKPOT", "BOOKWORM", "GALVANIZE", "EMBEZZLE",
                "STRONGHOLD", "YOUTHFUL", "STRENGTH", "TRANSPLANT"};

        System.out.println("The number of available words is " + words.length);

        String word = words[(int)(Math.random() * words.length)];
        StringBuilder hmword = new StringBuilder();

        // create hangman word of unknown characters
        hmword.append("_".repeat(word.length()));

        printInstructions();

        // main loop based on remaining guesses
        guesses = 6;
        while (guesses > 0) {
            if (takeTurn(word, hmword)) {
                System.out.println("\n\nCongratulations! You figured it out!\n");
                return;
            }
        }

        System.out.println("\n\nThe word was \"" + word + "\". Better luck next time!\n");
    }
}
