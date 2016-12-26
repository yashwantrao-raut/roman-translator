package com.translator.roman.number

/**
 * Created by yraut on 26/11/16.
 */
class RomanNumberParserTest extends spock.lang.Specification {

    def "should convert MCMXLIV to 1944"() {
        given:
        def romanNumberParser= new RomanNumberParser()

        when:
        def roman = romanNumberParser.parse("MCMXLIV")

        then:
        roman==1944

    }
    def "should convert MMVI to 2006"() {
        given:
        def romanNumberParser= new RomanNumberParser()

        when:
        def roman = romanNumberParser.parse("MMVI")

        then:
        roman==2006

    }
}
