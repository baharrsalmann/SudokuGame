package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {

    private final SudokuField[][] board;
    private final SudokuSolver mySolver;

    public SudokuBoard(SudokuSolver solver) {

        this.board = new SudokuField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuField newField = new SudokuField();
                newField.setFieldValue(0);
                this.board[i][j] = newField;
            }
        }

        this.mySolver = solver;
    }

    public boolean solveGame() {
        //BackTrackingSudokuSolver mySolver = new BackTrackingSudokuSolver();

        mySolver.solve(this);

        return checkBoard();
    }

    public int getPoint(int row, int column) {
        return this.board[row][column].getFieldValue();
    }

    public void setPoint(int row, int column, int value) {
        this.board[row][column].setFieldValue(value);
    }

    public SudokuRow getRow(int x) {
        SudokuRow currentRow = new SudokuRow();

        for (int i = 0; i < 9; i++) {
            currentRow.setArrayPoint(i,board[x][i].getFieldValue());
        }

        return currentRow;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn currentColumn = new SudokuColumn();

        for (int i = 0; i < 9; i++) {
            currentColumn.setArrayPoint(i,board[i][x].getFieldValue());
        }

        return currentColumn;
    }

    public SudokuBox getBox(int x, int y) {
        SudokuBox currentBox = new SudokuBox();

        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentBox.setArrayPoint(counter,board[x * 3 + i][y * 3 + j].getFieldValue());
                counter++;
            }
        }

        return currentBox;
    }

    private boolean checkBoard() {

        boolean currentState = true;

        for (int i = 0; i < 9; i++) {

            // check row
            SudokuRow currentRow = getRow(i);
            if (currentRow.verifyRow() == false) {
                currentState = false;
            }

            // check column
            SudokuColumn currentColumn = getColumn(i);
            if (currentColumn.verifyColumn() == false) {
                currentState = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                //check box
                SudokuBox currentBox = getBox(i,j);
                if (currentBox.verifyBox() == false) {
                    currentState = false;
                }
            }
        }

        return currentState;
    }
}
