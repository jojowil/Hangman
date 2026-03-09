public class Hangman {

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

See board below.

You have 6 of 6 guesses remaining.
The word is ________
                 
Let's begin.
 """);

    }
    static void main() {

        String[] words = {"SYNDROME", "BANDWAGON", "TRANSCRIPT", "NIGHTCLUB",
                "VAPORIZE", "JACKPOT", "BOOKWORM", "GALVANIZE", "EMBEZZLE",
                "STRONGHOLD", "YOUTHFUL", "STRENGTH", "TRANSPLANT"};

        System.out.println("The number of available words is " + words.length);

        int maxGuesses=6, wrongGuesses=0;
        StringBuilder word = ?? ;

        printInstructions();
    }
}
