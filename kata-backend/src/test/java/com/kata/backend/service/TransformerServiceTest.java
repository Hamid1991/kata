package com.kata.backend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerServiceTest {

    private final TransformerService transformerService = new TransformerService();

    @Test
    public void transformNumber_returnsFOOFOO_whenNumberIsEqualTo3() {
        //Given
        Integer three = 3;

        //When
        String actualResult = transformerService.transformNumber(three);

        //Then
        String expectedResult = "FOOFOO";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsBARBAR_whenNumberIsEqualTo5() {
        //Given
        Integer five = 5;

        //When
        String actualResult = transformerService.transformNumber(five);

        //Then
        String expectedResult = "BARBAR";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsQUIX_whenNumberIsEqualTo7() {
        //Given
        Integer seven = 7;

        //When
        String actualResult = transformerService.transformNumber(seven);

        //Then
        String expectedResult = "QUIX";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsBAR_whenNumberIsOneHundred() {
        //Given
        Integer oneHundred = 100;

        //When
        String actualResult = transformerService.transformNumber(oneHundred);

        //Then
        String expectedResult = "BAR";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOOBAR_whenNumberIsZero() {
        //Given
        Integer zero = 0;

        //When
        String actualResult = transformerService.transformNumber(zero);

        //Then
        String expectedResult = "FOOBAR";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsErrorMessage_whenNumberIsGreaterThanOneHundred() {
        //Given
        Integer oneHundredAndOne = 101;

        //When
        String actualResult = transformerService.transformNumber(oneHundredAndOne);

        //Then
        String expectedResult = "the number 101 is out of range [0-100]";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsErrorMessage_whenNumberIsLowerThanZero() {
        //Given
        Integer minusOne = -1;

        //When
        String actualResult = transformerService.transformNumber(minusOne);

        //Then
        String expectedResult = "the number -1 is out of range [0-100]";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOO_whenNumberIsOnlyDivisibleBy3() {
        //Given
        Integer nine = 9;

        //When
        String actualResult = transformerService.transformNumber(nine);

        //Then
        String expectedResult = "FOO";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOOBARBAR_whenNumberIsDivisibleBy3And5AndContains5InOnesDigit() {
        //Given
        Integer fifteen = 15;

        //When
        String actualResult = transformerService.transformNumber(fifteen);

        //Then
        String expectedResult = "FOOBARBAR";
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void transformNumber_returnsBAR_whenNumberIsOnlyDivisibleBy5() {
        //Given
        Integer twenty = 20;

        //When
        String actualResult = transformerService.transformNumber(twenty);

        //Then
        String expectedResult = "BAR";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOOBARFOO_whenNumberIsDivisibleBy3And5AndContains3InTensDigit() {
        //Given
        Integer thirty = 30;

        //When
        String actualResult = transformerService.transformNumber(thirty);

        //Then
        String expectedResult = "FOOBARFOO";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOOBAR_whenNumberIsDivisibleBy3And5AndContains5() {
        //Given
        Integer fiftyOne = 51;

        //When
        String actualResult = transformerService.transformNumber(fiftyOne);

        //Then
        String expectedResult = "FOOBAR";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsBARFOO_whenNumberContains5And3() {
        //Given
        Integer fiftyThree = 53;

        //When
        String actualResult = transformerService.transformNumber(fiftyThree);

        //Then
        String expectedResult = "BARFOO";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void transformNumber_returnsFOOFOOFOO_whenNumberIsDivisibleBy3AndContains3() {
        //Given
        Integer fiftyThree = 33;

        //When
        String actualResult = transformerService.transformNumber(fiftyThree);

        //Then
        String expectedResult = "FOOFOOFOO";
        assertEquals(expectedResult, actualResult);
    }
}