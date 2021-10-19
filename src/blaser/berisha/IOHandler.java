package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

import java.util.Scanner;

/**
 * Class to print menu and handle user input.
 */
public class IOHandler {
    public static Scanner scan = new Scanner(System.in);
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\033[0m";
    public static String color = WHITE;

    public static void printColors() {
        System.out.println(WHITE + "╔═══════════════════════════════════╗");
        System.out.println(WHITE + "\u001B[1m║ Available colors:                 ║\u001B[0m");
        System.out.println(WHITE + "║───────────────────────────────────║");
        System.out.println("║" + getColor() + " Blue (b)                          " + WHITE + "║");
        System.out.println("║ " + BLUE_BACKGROUND + BLACK + "Black on blue (bob)              " + RESET + WHITE + " ║");
        System.out.println("║" + PURPLE + " Purple (p)                        " + WHITE + "║");
        System.out.println("║ " + PURPLE_BACKGROUND + BLACK + "Black on purple (bop)            " + RESET + WHITE + " ║");
        System.out.println("║" + CYAN + " Cyan (c)                          " + WHITE + "║");
        System.out.println("║ " + CYAN_BACKGROUND + BLACK + "Black on cyan (boc)              " + RESET + WHITE + " ║");
        System.out.println("║ White (w)                         ║");
        System.out.println("║ " + WHITE_BACKGROUND + BLACK + "Black on white (bow)             " + RESET + WHITE + " ║");
        System.out.println(WHITE + "╚═══════════════════════════════════╝");
    }

    public static String chooseColor() {
        String chosen = scan.nextLine();
        switch (chosen) {
            case "b":
                setColor(getColor());
                break;
            case "bob":
                setColor(BLUE_BACKGROUND + BLACK);
                break;
            case "p":
                setColor(PURPLE);
                break;
            case "bop":
                setColor(PURPLE_BACKGROUND + BLACK);
                break;
            case "c":
                setColor(CYAN);
                break;
            case "boc":
                setColor(CYAN_BACKGROUND + BLACK);
                break;
            case "w":
                setColor(WHITE);
                break;
            case "bow":
                setColor(WHITE_BACKGROUND + BLACK);
                break;
        }
        return color;
    }


    public static void printStartMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗");
        System.out.println(getColor() + "\u001B[1m║ Enter the number to..             ║\u001B[0m");
        System.out.println(getColor() + "║───────────────────────────────────║");
        System.out.println(getColor() + "║ 1. show all sets                  ║");
        System.out.println(getColor() + "║ 2. create new set                 ║");
        System.out.println(getColor() + "║ 3. delete set                     ║");
        System.out.println(getColor() + "║ 4. end program                    ║");
        System.out.println(getColor() + "╚═══════════════════════════════════╝");
    }

    public static void printSetMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ Enter the number in braces to..   ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ 1. show all flashcards            ║" + RESET);
        System.out.println(getColor() + "║ 2. create new flashcard           ║" + RESET);
        System.out.println(getColor() + "║ 3. delete flashcard               ║" + RESET);
        System.out.println(getColor() + "║ 4. back to start menu             ║" + RESET);
        System.out.println(getColor() + "║ 5. flashcard learning             ║" + RESET);
        System.out.println(getColor() + "║ 6. learn writing                  ║" + RESET);
        System.out.println(getColor() + "║ 7. end program                    ║" + RESET);
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }


    public static void printSets(QuizManager manager) {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ SETS                              ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        for (int i = 0; i < manager.getSets().size(); i++) {
            String toPad = manager.getSets().get(i).getTitle();
            String padded = String.format("%-30s", toPad);
            System.out.println(getColor() + "║ " + i + ". " + padded + " ║" + RESET);

        }
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }

    public static void printFlashcards(Set set) {
        System.out.println(getColor() + "╔═════════════════════════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ CARDS                                               ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║─────────────────────────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ Nr.  Word                           Definition      ║" + RESET);
        System.out.println(getColor() + "║─────────────────────────────────────────────────────║" + RESET);
        for (int i = 0; i < set.getSet().size(); i++) {
            String toPad = (String.format("%-20s", set.getSet().get(i).getWord()) + "---->" + String.format("%20s", set.getSet().get(i).getDefinition()));
            String padded = String.format("%-45s", toPad);
            System.out.println(getColor() + "║ " + i + ".   " + padded + "  ║" + RESET);

        }
        System.out.println(getColor() + "╚═════════════════════════════════════════════════════╝" + RESET);
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        IOHandler.color = color;
    }
}
