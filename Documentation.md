#Introduction#

The task of this project is to create an app of our liking. We have decided to program a flashcard app, with which you can study. 
In the flashcard app, the user can: 

-	Create a set 
     - a set can be added, containing flashcards. i.e., French vocabulary set. There can be several sets saved.
-	Add flashcards 
     - single flashcards with words and their definitions can be added to a set
-	Remove flashcards 
     - flashcards can be removed from a set
-	Update flashcards 
     - definition or word of a flashcard can be changed
-	Remove a set
-	Go through the flashcards
     - Turn them around
     - flashcard can be flipped to show the correct answer
     - Swipe left/right (knew it vs. didn’t know it) 
     - the user can determine whether or not they knew it and swipe accordingly. Swiping left meaning they knew it and swiping right meaning they         didn’t know it.
-	Go through the flashcards but by writing the answer on their own 
     - instead of simply flipping and swiping the flashcards, the answers now must be written out and will be corrected by the app itself.
     - Click “I don’t know” button to see answer 
     - if the user doesn’t know the answer, they can click a button, to see the answer. 
- Check answer 
     - once the user entered an answer, they can check whether it’s correct. The next step is determined by whether or not the answer they entered        is correct.       
     - if correct it goes to the next flashcard. You must get a flashcard correctly twice to have ‘completed’
     - if wrong, the correct answer & spelling will be shown, and the user must repeat the correct answer to move on
-	show sets 
     - shows all sets and the number of flashcards in those sets that have been added by the user. 
-	show flashcards of a set 
     - all flashcards of the set can be seen. They’re shown as a list or table, where we can see the index of the word, the word and the definition of it.

 
##Planning
We created a GitHub repository fairly quickly, after that, we started with our first class diagram. We brainstormed and wrote down what we needed, which we then put into the diagram.
After the first diagram was created, we started to split up tasks to start. 
That way we decided that Milena is going to create the diagrams, while Blerinë gets started on the documentation and creates the base structure for the project. 

To split the tasks up and make sure we have a good general overview over everything, we created a project in GitHub and opened issues.
The four columns we created are: 
-	To do
    - Tasks that have to be done for this project, that haven’t been started yet.
-	In progress
    - Tasks that have been started but aren’t done yet or have been rejected in the “Done” column.
-	Review
    - Tasks that are done and are currently being reviewed. If there are mistakes or errors, the task will be dragged to “In progress” and the           mistakes must be corrected/the task needs improvement.
-	Done
    - Tasks that are done, have been reviewed and have been accepted.

We kept creating more issues and writing comments, to get a better overview, over what needs to be done in this issue.

We assigned the issues via GitHub.
Decisions
We decided not to create a GUI but instead give the user a pretty console output.


Here we have the default color for the box and text before the colours are shown and already show what the colours look like, as to not mislead the user.
For the output of the sets and flashcards, let’s say to see all sets or all flashcards, we decided to also give them a box output, to be consistent and clearly show, where the info is.


##Implementation
The first thing shown to the user is the menu. From there on decisions can be made about how to proceed. 

When the user makes the decision to see all the flashcards, they will always see the index (“Nr.”), the word itself, an arrow and then the definition on the right side of the box. 
The sets and flashcards are saved to files, so even when the user closes the program, the next time they reopen it, they can just pick up where they left off. 
The user can look at all the sets, create sets, delete sets, change the titles of the sets, choose a set to practice or edit the flashcards and change the color of all output. 
Most of the program works via number input (what doesn’t work via number input: the addition, deletion, editing and choice of set). 
If the user wants to create a new set, they will simply be asked for the title they would like to set and get the confirmative “Set added!” in the console. 
If the user wants to delete a set, they can first search for a set. They can either enter what they would like to search for or just hit enter again and see all sets.
It’s the same principle for change set title and choose set. The user is asked what set they would like to practice or what set title they would like to change and accordingly a new output will be given. 
Once a set has been chosen, there will be another menu, which looks as follows: 
 
The user can decide once again, if they would like to see, add, edit or delete flashcards, go back to the start menu, end the program altogether or if they want to practice this set, either by flipping the cards or by writing the words/definitions.
 
In the start menu there’s also the option of changing the color (see here), where we took into consideration that the contrast should always be high enough. Therefore, there is only black writing on all the colours, since that can be seen best ( accessibility options in our program). 

It’s the same principle for change set title and choose set. The user is asked what set they would like to practice or what set title they would like to change and accordingly a new output will be given. 
Once a set has been chosen, there will be another menu, which looks as follows: 
 
The user can decide once again, if they would like to see, add, edit or delete flashcards, go back to the start menu, end the program altogether or if they want to practice this set, either by flipping the cards or by writing the words/definitions.


In the start menu there’s also the option of changing the color, where we took into consideration that the contrast should always be high enough. Therefore, there is only black writing on all the colours, since that can be seen best (-> accessibility options in our program). 
