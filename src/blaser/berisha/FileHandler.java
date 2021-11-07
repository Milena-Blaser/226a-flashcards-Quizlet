package blaser.berisha;

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
    private static String line;

    public static void createSetFile(Set set) {
        try {
            FileWriter fileWriter = new FileWriter(set.getTitle() + ".txt");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void addFlashcardsToFile(Set set) {
        File file = new File(set.getTitle() + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line = set.getSet().get(i).getWord() + "," + set.getSet().get(i).getDefinition();
                while (true) {
                    if (!line.equals(bufferedReader.readLine())) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                    break;
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteFlashcardFromFile(Set set, Flashcard card) {
        String lineToRemove = card.getWord() + "," + card.getDefinition();
        File file = new File(set.getTitle() + ".txt");
        File tempFile = new File(set.getTitle() + "New.txt");
        if (!file.isFile()) {
            System.out.println("File doesn't exist");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
                while (true) {
                    if ((line = bufferedReader.readLine()) == null) break;
                    if (!line.trim().equals(lineToRemove)) {
                        bufferedWriter.write(line);
                    }
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedReader.close();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void updateFlashcardInFile(Set set, Flashcard card, String newLine) {
        File file = new File(set.getTitle() + ".txt");
        String lineToUpdate = card.getWord() + "," + card.getDefinition();
        String line;
        try {
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fr);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line = bufferedReader.readLine();
                while (line != null) {
                    if (lineToUpdate.equals(line)) {
                        bufferedWriter.write(newLine);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(line);

                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            fr.flush();
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
            BufferedWriter bufferedWriter = new BufferedWriter(fr);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void readSetFile(ArrayList<Set> sets) {
        File file = new File("setFile.txt");
        ArrayList<Flashcard> set;
        String title;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String nextLine = bufferedReader.readLine();
                while (nextLine != null) {
                    set = new ArrayList<>();
                    title = nextLine.replace(".txt", "");
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
        String[] parts;
        String line;
        String word;
        String definition;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    parts = line.split(",");
                    word = parts[0];
                    definition = parts[1];
                    set.getSet().add(new Flashcard(word, definition));
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.gc();
    }


}
