package org.example;

public class SudokuRow extends SudokuElement {

    public boolean verifyRow() {
        return this.verifyArray();
    }
}
