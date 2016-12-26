package com.translator.roman.number;

import com.translator.roman.number.rule.Repetition;
import com.translator.roman.number.rule.Rule;
import com.translator.roman.number.rule.SubstractionRule;

import java.util.*;

public class RomanNumberParser {

    Map<Character,AbstractRomanNumber> symbolsMap = new HashMap();
    List<Rule> rules= new ArrayList<Rule>();

    public RomanNumberParser(){
        buildSymbolMap();

        buildRepetitionRule();

        buildRepetitionAllowedOnlyOnceRule();

        buildSubtractionRuleForI();

        buildSubtractionRuleForX();

        buildSubtractionRuleForC();

        buildSubtractionRuleForV();

        buildSubtractionRuleForL();

        buildSubtractionRuleForD();
    }

    private void buildSubtractionRuleForI() {
        List<Character> allowedSubtractSymbols = new ArrayList<Character>();
        for(Character character:"VX".toCharArray())
            allowedSubtractSymbols.add(character);
        char ruleForSymbol = 'I';
        Rule subtractionRuleForI = new SubstractionRule(ruleForSymbol, allowedSubtractSymbols);
        rules.add(subtractionRuleForI);
    }
    private void buildSubtractionRuleForX() {
        List<Character> allowedSubtractSymbols = new ArrayList<Character>();
        for(Character character:"LC".toCharArray())
            allowedSubtractSymbols.add(character);
        char ruleForSymbol = 'X';
        Rule subtractionRuleForX = new SubstractionRule(ruleForSymbol, allowedSubtractSymbols);
        rules.add(subtractionRuleForX);
    }
    private void buildSubtractionRuleForC() {
        List<Character> allowedSubtractSymbols = new ArrayList<Character>();
        for(Character character:"DM".toCharArray())
            allowedSubtractSymbols.add(character);
        char ruleForSymbol = 'C';
        Rule subtractionRuleForC = new SubstractionRule(ruleForSymbol, allowedSubtractSymbols);
        rules.add(subtractionRuleForC);
    }
    private void buildSubtractionRuleForV() {
        List<Character> allowedSubSequentSymbols = new ArrayList<Character>();
        for(Character character:"I".toCharArray())
            allowedSubSequentSymbols.add(character);
        char ruleForSymbol = 'V';
        Rule subtractionRuleForV = new SubstractionRule(ruleForSymbol, allowedSubSequentSymbols);
        rules.add(subtractionRuleForV);
    }

    private void buildSubtractionRuleForL() {
        List<Character> allowedSubSequentSymbols = new ArrayList<Character>();
        for(Character character:"IVX".toCharArray())
            allowedSubSequentSymbols.add(character);
        char ruleForSymbol = 'L';
        Rule subtractionRuleForL = new SubstractionRule(ruleForSymbol, allowedSubSequentSymbols);
        rules.add(subtractionRuleForL);
    }
    private void buildSubtractionRuleForD() {
        List<Character> allowedSubSequentSymbols = new ArrayList<Character>();
        for(Character character:"IVXLC".toCharArray())
            allowedSubSequentSymbols.add(character);
        char ruleForSymbol = 'D';
        Rule subtractionRuleForD = new SubstractionRule(ruleForSymbol, allowedSubSequentSymbols);
        rules.add(subtractionRuleForD);
    }


    private void buildRepetitionAllowedOnlyOnceRule() {
        List<Character> repeteNotAllowedSymbols = new ArrayList();
        for(Character character:"DLV".toCharArray())
            repeteNotAllowedSymbols.add(character);
        int repetitionFreq = 1;
        Rule notAllowedRepetition = new Repetition(repeteNotAllowedSymbols, repetitionFreq);
        rules.add(notAllowedRepetition);
    }

    private void buildRepetitionRule() {
        List<Character> repeteAllowedSymbols = new ArrayList<Character>();
        for(Character character:"IXCM".toCharArray())
            repeteAllowedSymbols.add(character);
        int repetitionFrequency = 3;
        Rule repetition = new Repetition(repeteAllowedSymbols, repetitionFrequency);
        rules.add(repetition);
    }

    private void buildSymbolMap() {
        AbstractRomanNumber one = new One();
        symbolsMap.put(one.getRomanSymbol(), one);

        AbstractRomanNumber five = new Five();
        symbolsMap.put(five.getRomanSymbol(),five);

        AbstractRomanNumber ten = new Ten();
        symbolsMap.put(ten.getRomanSymbol(), ten);

        AbstractRomanNumber fifty = new Fifty();
        symbolsMap.put(fifty.getRomanSymbol(), fifty);

        AbstractRomanNumber hundred = new Hundred();
        symbolsMap.put(hundred.getRomanSymbol(), hundred);

        AbstractRomanNumber fiveHundred = new FiveHundred();
        symbolsMap.put(fiveHundred.getRomanSymbol(), fiveHundred);

        AbstractRomanNumber thousand = new Thousand();
        symbolsMap.put(thousand.getRomanSymbol(), thousand);
    }

    int parse(String number){
        String symbolString= number.toUpperCase();
        char[] symbols = symbolString.toCharArray();

        validateAgainstRules(symbols);

        int intValue=0;
        char current=0;
        char privious='$';
        for(char symbol: symbols){
            privious=current;
            current =symbol;
            AbstractRomanNumber currentNumber = symbolsMap.get(current);
            AbstractRomanNumber previousNumber = symbolsMap.get(privious);
            if(previousNumber!=null){
                if(previousNumber.isGreaterThanEquals(currentNumber))
                {
                    intValue=intValue+currentNumber.getIntValue();
                }else {
                    intValue=(intValue-previousNumber.getIntValue())+(currentNumber.getIntValue()-previousNumber.getIntValue());
                }
            }
            else {
                intValue+=currentNumber.getIntValue();
            }

        }
        return intValue;
    }

    private void validateAgainstRules(char[] symbols) {
        List<Character> symbolsList= new ArrayList<Character>();
        for(Character symbol:symbols){
            symbolsList.add(symbol);
        }
        for(Rule rule:rules){
            rule.apply(symbolsList);
        }
    }


}
