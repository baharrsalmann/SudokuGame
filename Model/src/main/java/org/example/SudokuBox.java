package org.example;

public class SudokuBox extends SudokuElement {

    public boolean verifyBox() {
        return this.verifyArray();
    }
}
