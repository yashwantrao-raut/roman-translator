package com.translator.roman.number.rule

import spock.lang.Specification

class RepetitionTest extends Specification {
    def repeteAllowedSymbols=[]
    def repetitionFrequency =3
    Rule rule

    void setup() {
        for(char c:"IXCM".toCharArray()){
            repeteAllowedSymbols.add(c)
        }
       rule = new Repetition(repeteAllowedSymbols,repetitionFrequency)

    }


    def "should allow repetition if I only 3 times in number succession"() {
        given:
        def array = "IIIIVII".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }

    def "should allow repetition if X only 3 times in number succession"() {
        given:
        def array = "XXXXIVII".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }

    def "should allow repetition if C only 3 times in number succession"() {
        given:
        def array = "XXXIVIICCCC".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }

    def "should allow repetition if M only 3 times in number succession"() {
        given:
        def array = "XXXMMMMICCCC".toCharArray();
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
