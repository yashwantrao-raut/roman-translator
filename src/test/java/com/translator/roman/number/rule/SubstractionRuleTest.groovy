package com.translator.roman.number.rule

import spock.lang.Specification

class SubstractionRuleTest extends Specification {
    def "I can substracted from v and x only"() {
        given:
        char symbol ='I';
        def allwedSubstarctSymbols=[]
        for(char c:"VX".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "II".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "X can substracted from L and C only"() {
        given:
        char symbol ='X';
        def allwedSubstarctSymbols=[]
        for(char c:"LC".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "IIIVXXV".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "C can substracted from D and M only"() {
        given:
        char symbol ='C';
        def allwedSubstarctSymbols=[]
        for(char c:"DM".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "CCX".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "V  never be substracted "() {
        given:
        char symbol ='V';
        def allwedSubstarctSymbols=[]
        for(char c:"I".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "VIIX".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "L  never be substracted "() {
        given:
        char symbol ='L';
        def allwedSubstarctSymbols=[]
        for(char c:"IVX".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "ILC".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "D  never be substracted "() {
        given:
        char symbol ='D';
        def allwedSubstarctSymbols=[]
        for(char c:"IVXLC".toCharArray()){
            allwedSubstarctSymbols.add(c)
        }
        Rule rule = new SubstractionRule(symbol,allwedSubstarctSymbols)
        def array = "ILDM".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
}
