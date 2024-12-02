package com.kata.backend.service;

import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class TransformerService {

    public static final String THE_NUMBER_D_IS_OUT_OF_RANGE_0_100 = "the number %d is out of range [0-100]";
    public static final String FOO = "FOO";
    public static final String BAR = "BAR";
    public static final String QUIX = "QUIX";

    public String transformNumber(Integer number){

        if(number > 100 || number < 0) {
            return format(THE_NUMBER_D_IS_OUT_OF_RANGE_0_100, number);
        }

        StringBuilder transformedNumber = new StringBuilder();

        boolean isDivisibleBy3 = number % 3 == 0;
        if(isDivisibleBy3) {
            applyNumberDivisibilityRule(transformedNumber, 3);
        }

        boolean isDivisibleBy5 = number % 5 == 0;
        if(isDivisibleBy5) {
            applyNumberDivisibilityRule(transformedNumber, 5);
        }

        boolean divisibilityCheckIsKo = !isDivisibleBy3 && !isDivisibleBy5;

        int tensDigit = number / 10;

        if (tensDigit != 0) {
            applyDigitEqualityRule(transformedNumber, divisibilityCheckIsKo, tensDigit);
        }

        int onesDigit = number % 10;

        if (onesDigit != 0) {
            applyDigitEqualityRule(transformedNumber, divisibilityCheckIsKo, onesDigit);
        }

        return transformedNumber.toString();
    }

    private void applyDigitEqualityRule(StringBuilder transformedNumber, boolean divisibleCheckIsKo, int digit) {
            switch (digit) {
                case 3:
                    transformedNumber.append(FOO);
                    break;
                case 5:
                    transformedNumber.append(BAR);
                    break;
                case 7:
                    transformedNumber.append(QUIX);
                    break;
                default:
                    transformedNumber.append(divisibleCheckIsKo ? digit : "");
                    break;
            }
    }

    private void applyNumberDivisibilityRule(StringBuilder transformedNumber, int divisor) {
        switch (divisor){
            case 3 -> transformedNumber.append(FOO);
            case 5 -> transformedNumber.append(BAR);
        }
    }

}