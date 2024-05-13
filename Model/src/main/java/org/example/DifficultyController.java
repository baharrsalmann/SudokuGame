package org.example;

import java.util.Random;

public class DifficultyController {
    public DiffLevel currentLevel;

    public DifficultyController(DiffLevel lvl) {
        this.currentLevel = lvl;
    }

    public void createLevel(SudokuBoard sudokuBoard) {
        int loopTime = 0;

        if (currentLevel == DiffLevel.easy) {
            // 15 tane sayı cıkar
            loopTime = 15;

        } else if (currentLevel == DiffLevel.medium) {
            // 30 sayı cıkar
            loopTime = 40;
        } else {
            // 60 sayı cıkar
            loopTime = 70;
        }

        for (int i = 0; i < loopTime; i++) {
            int row = new Random().nextInt(0,9);
            int column = new Random().nextInt(0,9);

            sudokuBoard.setPoint(row,column,0);
        }
    }
}
