package blaser.berisha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * -----------------------------------------------------
 * Author:          Blerinë Berisha
 * Date:            date
 * Project:         project name
 * Description:     Short description
 * ------------------------------------------------------
 **/
public class FileHandlerTest{

    @BeforeEach
    public void start(){
        ArrayList<Set> sets = new ArrayList<>();
        FileHandler.addToSetFile(sets);
        FileHandler.readSetFile(sets);
        for(int i = 0; i < sets.size(); i++){
            FileHandler.readFlashcards(sets.get(i));
        }
        QuizManager qm = new QuizManager(sets);
        Quiz quiz = new Quiz(qm);
        quiz.startQuiz();
    }

    /*@Test
    public boolean doesFileExist(){
        start();


    }*/
}
