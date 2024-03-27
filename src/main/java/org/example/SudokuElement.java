package org.example;

import java.util.ArrayList;

public class SudokuElement {

    protected SudokuField[] fieldArray;

    public SudokuElement() {

        fieldArray = new SudokuField[9];

        for (int i = 0; i < 9; i++) {
            SudokuField newField = new SudokuField();
            newField.setFieldValue(0);
            fieldArray[i] = newField;
        }
    }

    protected boolean verifyArray() {
        int[] verifyingArray = new int[9];
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            verifyingArray[counter] = this.fieldArray[i].getFieldValue();

            for (int j = 0; j < i; j++) {
                if (verifyingArray[j] == verifyingArray[counter]) {
                    return false;
                }
            }

            counter++;
        }

        return true;

    }

    public void setArrayPoint(int x, int value) {
        fieldArray[x].setFieldValue(value);
    }

    public SudokuField getArrayPoint(int x) {
        return fieldArray[x];
    }

}
