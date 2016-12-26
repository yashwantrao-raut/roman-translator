package com.translator.roman.number.rule;

import java.util.List;

public class SubstractionRule implements Rule{
    Character symbol;
    List<Character> subsequentSymbolAllowed;

    public SubstractionRule(Character symbol, List<Character> subsequentSymbolAllowed) {
        this.symbol = symbol;
        this.subsequentSymbolAllowed = subsequentSymbolAllowed;
    }

    public void apply(List<Character> symbols) {
        for(int index=0;index<symbols.size();index++){
            if(symbols.get(index) ==symbol){
                if(index+1< symbols.size()){
                    Character nextChar = symbols.get(index + 1);
                    if(nextChar!=symbols.get(index)&&!subsequentSymbolAllowed.contains(nextChar)){
                        throw new NumberFormatException("");
                    }
                }
            }
        }

    }
}
