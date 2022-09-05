package com.wordpress.technologyconversations.tddtest;
 
import org.junit.Test;
import com.wordpress.technologyconversations.tdd.StringCalculator;
 
public class StringCalculatorTest {
    @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, StringCalculator.add("3"));
    }
     
    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, StringCalculator.add("3,6"));
    }
    //  @Test(expected = RuntimeException.class)
//  public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//      StringCalculator.add("1,2,3");
//  }
@Test
public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
    Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
}
@Test(expected = RuntimeException.class)
public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
    StringCalculator.add("3,-6,15,18,46,33");
}
@Test
public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("3,-6,15,-18,46,33");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
}
public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
    Assert.assertEquals(3+1000+6, StringCalculator8.add("3,1000,1001,6,1234"));
}
}