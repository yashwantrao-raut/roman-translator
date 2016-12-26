package com.translator.roman.number.rule;

import java.util.List;

public class Repetition implements Rule {
    private List<Character> repeteAllowedSymbols;
    private int repetitionFrequency;

    public Repetition(List<Character> repeteAllowedSymbols, int repetitionFrequency) {
        this.repeteAllowedSymbols = repeteAllowedSymbols;
        this.repetitionFrequency = repetitionFrequency;
    }

    public void apply(List<Character> symbols) {
        for (int index=0;index<repeteAllowedSymbols.size(); index++) {
            int allowedRepeatSymbolIndex = symbols.indexOf(repeteAllowedSymbols.get(index));
            if (allowedRepeatSymbolIndex == -1) {
                continue;
            } else {
                int repetition=1;
                while (allowedRepeatSymbolIndex<symbols.size()-1){
                    allowedRepeatSymbolIndex++;
                    if(symbols.get(allowedRepeatSymbolIndex)==repeteAllowedSymbols.get(index)){
                        repetition++;
                    }
                    else {
                        repetition=0;
                    }
                    if(repetition > repetitionFrequency)
                    {
                        throw new NumberFormatException(String.format("Number is not in valid format : Sysmbol %c exceeds max repetitionFrequency : %d",repeteAllowedSymbols.get(index),repetitionFrequency));
                    }
                }

            }

        }


    }
}
