package com.translator.roman.number;


public class AbstractRomanNumber {
    private int intValue;
    private Character romanSymbol;

    boolean isGreaterThanEquals(AbstractRomanNumber anotherNumber){
        return  this.getIntValue() >= anotherNumber.getIntValue() ;
    }


    public AbstractRomanNumber(int intValue, Character romanChar) {
        this.intValue = intValue;
        this.romanSymbol = romanChar;
    }

    public int getIntValue() {
        return intValue;
    }

    public Character getRomanSymbol() {
        return romanSymbol;
    }
}
