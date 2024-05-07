package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoxTest {

    SudokuBoard myBoard = new SudokuBoard(new BackTrackingSudokuSolver());

    @Test
    public void verifyTest() {
        myBoard.solveGame();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SudokuBox mySudokuBox = myBoard.getBox(i,j);
                int counter = 0;

                for (int k = 0; k < 9; k++) {
                    counter += mySudokuBox.getArrayPoint(k).getFieldValue();
                }

                assertEquals((counter == 45), mySudokuBox.verifyBox());
            }
        }
    }

}