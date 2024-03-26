package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {

    private int[][] board;
    private SudokuSolver mySolver;

    public SudokuBoard(SudokuSolver solver) {
        this.board = new int[9][9];
        this.mySolver = solver;
    }

    public void solveGame() {
        //BackTrackingSudokuSolver mySolver = new BackTrackingSudokuSolver();

        mySolver.solve(this);
    }

    public int getPoint(int row, int column) {
        return this.board[row][column];
    }

    public void setPoint(int row, int column, int value) {
        this.board[row][column] = value;
    }

}
