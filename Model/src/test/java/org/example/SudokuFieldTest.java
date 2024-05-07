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

    @Test
    public void stringTest() {
        myField.setFieldValue(3);
        assertEquals("3",myField.toString());
    }

    @Test
    public void equalsTest() {
        SudokuField otherField = new SudokuField();

        myField.setFieldValue(5);
        otherField.setFieldValue(5);

        assertTrue(myField.equals(otherField));

        SudokuField sameField = myField;
        assertTrue(myField.equals(sameField));

        SudokuElement anotherType = new SudokuElement();
        assertFalse(myField.equals(anotherType));
    }

    @Test
    public void hashCodeTest() {
        myField.setFieldValue(2);
        int myHashCode = myField.hashCode();

        SudokuField otherField = new SudokuField();
        otherField.setFieldValue(2);
        int otherHashCode = otherField.hashCode();

        assertEquals(myHashCode,otherHashCode);

        // test different objects
        otherField.setFieldValue(5);
        otherHashCode = otherField.hashCode();
        if(myHashCode == otherHashCode) {
            assertFalse(myField.equals(otherField));
        }
        else {
            assertNotEquals(myHashCode,otherHashCode);
        }
    }

}