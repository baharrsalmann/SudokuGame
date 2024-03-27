package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuFieldTest {

    SudokuField myField = new SudokuField();

    @Test
    public void getAndSetTest()
    {
        myField.setFieldValue(5);
        assertEquals(5,myField.getFieldValue());
    }

}