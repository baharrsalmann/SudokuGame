package org.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {
    private int value;

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int newValue) {
        this.value = newValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SudokuField)) {
            return false;
        }

        SudokuField otherField = (SudokuField) obj;

        return new EqualsBuilder().append(this.value,otherField.value).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.value).toHashCode();
    }

    @Override
    public SudokuField clone() throws CloneNotSupportedException {
        return (SudokuField) super.clone();
    }

    @Override
    public int compareTo(SudokuField o) {

        if (o == null) {
            throw new NullPointerException();
        }

        return Integer.compare(this.getFieldValue(),o.getFieldValue());
    }
}
