package org.example;

public class SudokuBoardDaoFactory {
    public Dao getFileDao(String fileName) {
        FileSudokuBoardDao myDao = new FileSudokuBoardDao(fileName);

        return myDao;
    }
}
