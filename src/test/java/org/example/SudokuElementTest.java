package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuElementTest {

    SudokuElement myElement = new SudokuElement();

    @Test
    public void getAndSetTest() {
        for (int i = 0; i < 9; i++) {
            myElement.setArrayPoint(i,i * 2);
            assertEquals(myElement.fieldArray[i].getFieldValue(), i * 2);

            int getValue = myElement.getArrayPoint(i).getFieldValue();
            assertEquals(i * 2, getValue);
        }
    }


    @Test
    public void verifyTest() {

        // false verification
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                myElement.setArrayPoint(i,i);
            }
            else {
                myElement.setArrayPoint(i,i + 1);
            }
        }
        assertFalse(myElement.verifyArray());

        //correct verification
        for (int i = 0; i < 9; i++) {
            myElement.setArrayPoint(i,i + 1);
        }
        assertTrue(myElement.verifyArray());

    }

}