package org.example;

import java.util.Random;

public class DifficultyController {
    public DiffLevel currentLevel;

    public DifficultyController(DiffLevel lvl) {
        this.currentLevel = lvl;
    }

    public void createLevel(SudokuBoard sudokuBoard) {
        currentLevel.createLevel(sudokuBoard);
    }
}
