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

    /**
     * This method is responsible for creating a new File when a new Set is added
     * @param set the new Set that was added
     */

    public static void createSetFile(Set set) {
        try {
            FileWriter fileWriter = new FileWriter(set.getTitle().concat(".txt"));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * This method adds all the flashcards of a set to the matching txt-file
     * by going through the file until a empty line is located. The flashcard
     * -> word and definition are added with a , in between
     * @param set where the flashcards are added to
     */
    public static void addFlashcardsToFile(Set set) {
        File file = new File(set.getTitle().concat(".txt"));
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line = set.getSet().get(i).getWord().concat(",").concat(set.getSet().get(i).getDefinition());
                if (bufferedReader.readLine() == null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method deletes a flashcard from the matching set file by
     * creating a new file and adding all the flashcards expect the to-deleted-flashcard
     * to this file. After that the old file is deleted and the new file renamed so that
     * it has the old files name
     * @param set the set where the flashcards needs to be delete from
     * @param card the card that needs to be deleted
     */
    public static void deleteFlashcardFromFile(Set set, Flashcard card) {
        String lineToRemove = card.getWord().concat(",").concat(card.getDefinition());
        File file = new File(set.getTitle().concat(".txt"));
        File tempFile = new File(set.getTitle().concat("New.txt"));
        if (!file.isFile()) {
            System.out.println("File doesn't exist");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
                while(bufferedReader.readLine() != null) {
                    if (!line.trim().equals(lineToRemove)) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }else{
                        bufferedWriter.newLine();
                    }
                }
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

    /**
     * This method updates the flashcard in the matching txt-file by
     * creating a new file and adding all the flashcards to this file. When the line with
     * the flashcard that needs to be updated is reached, it will be exchanged for the newer
     * version of the flashcard. After that the old file is deleted and the new file renamed so that
     * it has the old files name
     * @param set that needs to be updated
     * @param card specific card that needs to be updated
     * @param newLine the new version of the flashcard
     */
    public static void updateFlashcardInFile(Set set, Flashcard card, String newLine) {
        File file = new File(set.getTitle().concat(".txt"));
        File tempFile = new File(set.getTitle().concat("NEW.txt"));
        String lineToUpdate = card.getWord().concat(",").concat(card.getDefinition());
        String line;
        try {
            FileWriter fr = new FileWriter(tempFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fr);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line = bufferedReader.readLine();
                if (lineToUpdate.equals(line)) {
                    bufferedWriter.write(newLine);
                    bufferedWriter.newLine();
                }else {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file)) {
                System.out.println("Could not rename file");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    /**
     * This method deletes a set from the setFile
     * @param set that needs to be deleted
     */
    public static void deleteFromSetFile(Set set) {
        String lineToRemove =set.getTitle().concat(".txt");
        File file = new File("setFile.txt");
        File tempFile = new File("setFileNew.txt");
        if (!file.isFile()) {
            System.out.println("File doesn't exist");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
                while(bufferedReader.readLine() != null) {
                    if (!line.trim().equals(lineToRemove)) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }else{
                        bufferedWriter.newLine();
                    }
                }
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

    /**
     * This method updates the setFile if the title of a set
     * is changed
     * @param set that has a new title
     * @param newTitle new title that we needs to update
     */
    public static void updateSetFile(Set set, String newTitle ) {
        File file = new File("setFile.txt");
        File tempFile = new File("SetFileNEW.txt");
        String lineToUpdate = set.getTitle();
        String line;
        try {
            FileWriter fr = new FileWriter(tempFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fr);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < set.getSet().size(); i++) {
                line = bufferedReader.readLine();
                if (lineToUpdate.equals(line)) {
                    bufferedWriter.write(newTitle);
                    bufferedWriter.newLine();
                }else {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }


            }
            bufferedWriter.close();
            bufferedReader.close();
            fr.close();
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file)) {
                System.out.println("Could not rename file");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    /**
     * This method adds a set to the setFile when a new set is created
     * @param sets Arraylist of sets that are looped through so that newest set can be addded
     */
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

    /**
     * This method reads the setFile into the Arraylist sets,
     * so that pre-existing sets can be used
     * @param sets Arraylist of sets
     */
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

    /**
     * This method reads a Flashcard into the set file of the matching set.
     * The line in the file is split into the word and the defintion by the ","
     * @param set the flashcard belongs to
     */
    public static void readFlashcards(Set set) {
        File file = new File(set.getTitle().concat(".txt"));
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
