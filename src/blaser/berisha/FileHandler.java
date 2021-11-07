package blaser.berisha;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/*************************************************************
 Program:
 Author:Milena
 Date:04.11.2021
 Project:
 Description:
 **************************************************************/

public class FileHandler {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;
    private static int sets = 0;


    public static void createSetFile(Set set) {
        String name = set.getTitle();
        String word;
        try {
            FileWriter file = new FileWriter(name + ".txt");
            bufferedWriter = new BufferedWriter(file);
            bufferedWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void addFlashcardsToFile(Set set) {
        File file = new File(set.getTitle() + ".txt");
        String word;
        try {
            FileWriter fr = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fr);
            bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                word = set.getSet().get(i).getWord() + "," + set.getSet().get(i).getDefinition();
                while (true) {
                    if (!word.equals(bufferedReader.readLine())) {
                        bufferedWriter.write(word);
                        bufferedWriter.newLine();
                    }
                    break;
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteFlashcardFromFile(Set set, Flashcard card) {
        String lineToRemove = card.getWord() + "," + card.getDefinition();
        File file = new File(set.getTitle() + ".txt");
        File tempFile = new File(set.getTitle() + "New.txt");
        String row = null;
        if (!file.isFile()) {
            System.out.println("File doesn't exist");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while (true) {
                if ((row = bufferedReader.readLine()) == null) break;
                if (!row.trim().equals(lineToRemove)) {
                    bufferedWriter.write(row);
                }
            }
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file)) {
                System.out.println("Could not rename file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void updateFlashcardInFile(Set set, Flashcard card, String newLine) {
        File file = new File(set.getTitle() + ".txt");
        String lineToUpdate = card.getWord() + "," + card.getDefinition();
        String line;
        try {
            FileWriter fr = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fr);
            bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line =  bufferedReader.readLine();
                while (line != null) {
                    if (lineToUpdate.equals(line)) {
                        bufferedWriter.write(newLine);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(line);

                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


    }

    public static void addToSetFile(ArrayList<Set> sets) {
        File file = new File("setFile.txt");
        String title;
        try {
            FileWriter fr = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fr);
            bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < sets.size(); i++) {
                title = sets.get(i).getTitle() + ".txt";
                while (true) {
                    if (!title.equals(bufferedReader.readLine())) {
                        bufferedWriter.write(title);
                        bufferedWriter.newLine();
                    }
                    break;
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void readSetFile(ArrayList<Set> sets) {
        File file = new File("setFile.txt");
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String nextLine = bufferedReader.readLine();
                while (nextLine != null) {

                    ArrayList<Flashcard> set = new ArrayList<>();
                    String title = nextLine.replace(".txt", "");
                    sets.add(new Set(set, title));
                    nextLine = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void readFlashcards(Set set) {
        File file = new File(set.getTitle() + ".txt");
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String nextLine = bufferedReader.readLine();
                while (nextLine != null) {
                    String line = nextLine;
                    String[] parts = line.split(",");
                    String word = parts[0];
                    String definition = parts[1];
                    set.getSet().add(new Flashcard(word, definition));
                    nextLine = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
