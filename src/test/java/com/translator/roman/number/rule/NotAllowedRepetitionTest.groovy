package com.translator.roman.number.rule

import spock.lang.Specification

/**
 * Created by yraut on 27/11/16.
 */
class NotAllowedRepetitionTest extends Specification {

    def repeteAllowedSymbols=[]
    def repetitionFrequency =1
    def rule

    void setup() {
        for(char c:"DLV".toCharArray()){
            repeteAllowedSymbols.add(c)
        }
        rule = new Repetition(repeteAllowedSymbols,repetitionFrequency)

    }

    def "should not allow repetition for D"() {
        given:
        def array = "IIIVXXDDDXX".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "should not allow repetition for L"() {
        given:
        def array = "IIIVLLC".toCharArray();
        def list=[]
        for(char c:array){
            list.add(c)
        }

        when:
        rule.apply(list)

        then:
        thrown(NumberFormatException)

    }
    def "should not allow repetition for V"() {
        given:
        def array = "IIIVVLC".toCharArray();
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
