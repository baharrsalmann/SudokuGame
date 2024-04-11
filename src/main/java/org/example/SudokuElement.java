package org.example;

import java.util.ArrayList;

public class SudokuElement {

    protected ArrayList<SudokuField> fieldArray;

    public SudokuElement() {

        fieldArray = new ArrayList<SudokuField>();

        for (int i = 0; i < 9; i++) {
            SudokuField newField = new SudokuField();
            newField.setFieldValue(0);
            fieldArray.add(newField);
        }
    }

    protected boolean verifyArray() {
        int[] verifyingArray = new int[9];
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            verifyingArray[counter] = this.fieldArray.get(i).getFieldValue();

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
        SudokuField newField = new SudokuField();
        newField.setFieldValue(value);
        fieldArray.set(x,newField);
    }

    public SudokuField getArrayPoint(int x) {
        return fieldArray.get(x);
    }

}
