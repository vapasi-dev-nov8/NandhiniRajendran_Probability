package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void shouldReturnTrueIfProbOfTwoEventsAreEqual()
    {
        Probability occOfHeads = new Probability(0.5);
        Probability occOfTails = new Probability(0.5);

        assertTrue(occOfHeads.equals(occOfTails));

        Probability occOf4in6FaceDice = new Probability(0.166);
        Probability occOf5in6FaceDice = new Probability(0.166);
        assertTrue(occOf4in6FaceDice.equals(occOf5in6FaceDice));
    }

    @Test
    void shouldReturnProbOfTwoEventsOccuringTogether()
    {
        Probability getting5In6FaceDie = new Probability(0.166);
        Probability getting4In6FaceDie = new Probability(0.166);
        Probability getting4And5 = new Probability(0.166*0.166);
        assertTrue(getting4And5.equals(getting5In6FaceDie.calculateProbOfEventsOccuringTogether(getting4In6FaceDie)));
    }

    @Test
    void shouldReturnProbOfEventNotOccuring()
    {
        Probability get5In6FaceDice = new Probability(0.166);
        Probability getANumberOtherThan5 = new Probability(1-0.166);
        assertTrue(getANumberOtherThan5.equals(get5In6FaceDice.calculateProbOfEventsNotOccuring()));
    }

    @Test
    void shouldReturnProbOfEitherEventsOccurring()
    {
        Probability getEvenNumber = new Probability(0.5);
       // Probability getMultipleOf3 = new Probability(0.3333);
        Probability getMultipleOf3 = null;
        Probability getEvenNumberOrMultipleOf3 = new Probability(0.5 + 0.3333 - (0.5*0.3333));
        assertTrue(getEvenNumberOrMultipleOf3.equals(getEvenNumber.calculateProbOfEitherEventOccuring(getMultipleOf3)));
    }

    @Test
    void shouldReturnFalseIfAnyEventIsNull()
    {
        Probability getEvenNumber = new Probability(0.5);
        Probability getMultipleOf3 = null;
        Probability getEvenNumberOrMultipleOf3 = new Probability(0.5 + 0.3333 - (0.5*0.3333));
        Probability getEvenNumberAndMultipleOf3 = new Probability(0.08333);
        assertFalse(getEvenNumberOrMultipleOf3.equals(getEvenNumber.calculateProbOfEitherEventOccuring(getMultipleOf3)));
        assertFalse(getEvenNumberAndMultipleOf3.equals(getEvenNumber.calculateProbOfEventsOccuringTogether(getMultipleOf3)));
    }

}