package org.example;

public class SudokuColumn extends SudokuElement {

    public boolean verifyColumn() {
        return this.verifyArray();
    }
}
