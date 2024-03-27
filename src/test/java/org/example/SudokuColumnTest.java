package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuColumnTest {
    SudokuBoard myBoard = new SudokuBoard(new BackTrackingSudokuSolver());

    @Test
    public void verifyTest() {
        myBoard.solveGame();

        for (int i = 0; i < 9; i++) {
            SudokuColumn mySudokuColumn = myBoard.getColumn(i);
            int counter = 0;

            for (int j = 0; j < 9; j++) {
                counter += mySudokuColumn.getArrayPoint(j).getFieldValue();
            }

            assertEquals((counter == 45), mySudokuColumn.verifyColumn());
        }
    }

}