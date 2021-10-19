package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

/**
 * Class to print menu and handle user input.
 */
public class IOHandler {
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";

    public static void printStartMenu() {
        System.out.println(BLUE + "╔═══════════════════════════════════╗");
        System.out.println(BLUE + "\u001B[1m║ Enter the number to..             ║\u001B[0m");
        System.out.println(BLUE + "║───────────────────────────────────║");
        System.out.println(BLUE + "║ 1. show all sets                  ║");
        System.out.println(BLUE + "║ 2. create new set                 ║");
        System.out.println(BLUE + "║ 3. delete set                     ║");
        System.out.println(BLUE + "║ 4. end program                    ║");
        System.out.println(BLUE + "╚═══════════════════════════════════╝");
    }

    public static void printSetMenu() {
        System.out.println(BLUE + "╔═══════════════════════════════════╗");
        System.out.println(BLUE + "\u001B[1m║ Enter the number in braces to..   ║\u001B[0m");
        System.out.println(BLUE + "║───────────────────────────────────║");
        System.out.println(BLUE + "║ 1. show all flashcards            ║");
        System.out.println(BLUE + "║ 2. create new flashcard           ║");
        System.out.println(BLUE + "║ 3. delete flashcard               ║");
        System.out.println(BLUE + "║ 4. back to start menu             ║");
        System.out.println(BLUE + "║ 5. flashcard learning             ║");
        System.out.println(BLUE + "║ 6. learn writing                  ║");
        System.out.println(BLUE + "║ 7. end program                    ║");
        System.out.println(BLUE + "╚═══════════════════════════════════╝");
    }

    public static void printSets(QuizManager manager) {
        System.out.println(BLUE + "╔═══════════════════════════════════╗");
        System.out.println(BLUE + "\u001B[1m║ SETS                              ║\u001B[0m");
        System.out.println(BLUE + "║───────────────────────────────────║");
        for (int i = 0; i < manager.getSets().size(); i++) {
            String toPad = manager.getSets().get(i).getTitle();
            String padded = String.format("%-30s", toPad);
            System.out.println("║ " + i + ". " + padded + " ║");

        }
        System.out.println(BLUE + "╚═══════════════════════════════════╝");
    }
}
