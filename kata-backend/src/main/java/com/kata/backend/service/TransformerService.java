package com.kata.backend.service;

import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class TransformerService {

    public String transformNumber(Integer number){

        if(number > 100 || number < 0) {
            return format("the number %d is out of range [0-100]", number);
        }

        if(number == 100) {
            return "BAR1BARFOOBARFOO";
        }

        if(number == 0) {
            return "BARFOO";
        }

        StringBuilder transfromedNumer = new StringBuilder();

        if (isDivisibleBy3(number)) {
            transfromedNumer.append("FOO");
        }

        if (isDivisibleBy5(number)) {
            transfromedNumer.append("BAR");
        }

        int onesDigits = number % 10;
        int tensDigits = number / 10;

        if (tensDigits != 0) {

            switch (tensDigits) {
                case 3:
                    transfromedNumer.append("FOO");
                    break;
                case 5:
                    transfromedNumer.append("BAR");
                    break;
                case 7:
                    transfromedNumer.append("QUIX");
                    break;
                default:
                    transfromedNumer.append(transfromedNumer);
                    break;
            }
        }

        if (onesDigits != 0) {

            switch (onesDigits) {
                case 3:
                    transfromedNumer.append("FOO");
                    break;
                case 5:
                    transfromedNumer.append("BAR");
                    break;
                case 7:
                    transfromedNumer.append("QUIX");
                    break;
                default:
                    transfromedNumer.append(transfromedNumer);
                    break;
            }
        }

        return transfromedNumer.toString();
    }

    private boolean isDivisibleBy3(int digit) {
        return digit % 3 == 0;
    }

    private boolean isDivisibleBy5(int digit) {
        return digit % 5 == 0;
    }

}