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

        StringBuilder transformedNumber = new StringBuilder();

        boolean isDivisibleBy3 = isDivisibleBy3(number);
        if (isDivisibleBy3) {
            transformedNumber.append("FOO");
        }

        boolean isDivisibleBy5 = isDivisibleBy5(number);
        if (isDivisibleBy5) {
            transformedNumber.append("BAR");
        }

        int onesDigits = number % 10;
        int tensDigits = number / 10;

        if (tensDigits != 0) {

            switch (tensDigits) {
                case 3:
                    transformedNumber.append("FOO");
                    break;
                case 5:
                    transformedNumber.append("BAR");
                    break;
                case 7:
                    transformedNumber.append("QUIX");
                    break;
                default:
                    transformedNumber.append(!isDivisibleBy5 && !isDivisibleBy3 ? tensDigits : "");
                    break;
            }
        }

        if (onesDigits != 0) {

            switch (onesDigits) {
                case 3:
                    transformedNumber.append("FOO");
                    break;
                case 5:
                    transformedNumber.append("BAR");
                    break;
                case 7:
                    transformedNumber.append("QUIX");
                    break;
                default:
                    transformedNumber.append(!isDivisibleBy5 && !isDivisibleBy3 ? onesDigits : "");
                    break;
            }
        }

        return transformedNumber.toString();
    }

    private boolean isDivisibleBy3(int digit) {
        return digit % 3 == 0;
    }

    private boolean isDivisibleBy5(int digit) {
        return digit % 5 == 0;
    }

}