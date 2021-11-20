package com.probability;

import java.util.Objects;

public class Probability {

   private double value;
   private final double EVENT_WILL_OCCUR = 1;

    public Probability(double value) {
        this.value = value;
    }

    //method To calculate the Probability of Two Independent Events occuring together
    public Probability calculateProbOfEventsOccuringTogether(Probability prob)
    {
        if (prob == null) return null;
        Probability probOfAandB = new Probability(this.value * prob.value);
        return probOfAandB;
    }


    //method To calculate the Probability of Event not occuring
    public Probability calculateProbOfEventsNotOccuring()
    {
        Probability probNotOccuring = new Probability(EVENT_WILL_OCCUR - this.value);
        return probNotOccuring;
    }

    //Method to Calculate the Probability of Either two events Occuring
    public Probability calculateProbOfEitherEventOccuring(Probability prob)
    {
        if (prob == null) return null;
        Probability probOfAorB = new Probability(this.value + prob.value - (this.value * prob.value));
        return probOfAorB;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
