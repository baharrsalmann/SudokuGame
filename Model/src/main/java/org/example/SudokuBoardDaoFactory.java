package org.example;

public class SudokuBoardDaoFactory {
    public Dao<SudokuBoard> getFileDao(String fileName) {
        FileSudokuBoardDao myDao = new FileSudokuBoardDao(fileName);

        return myDao;
    }
}
