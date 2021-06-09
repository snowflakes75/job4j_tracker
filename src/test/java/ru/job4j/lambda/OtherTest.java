package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OtherTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Other function = new Other();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionQvadraResults() {
        Other function = new Other();
        List<Double> result = function.diapason(1, 3, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(3D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionPocasaltResults() {
        Other function = new Other();
        List<Double> result = function.diapason(2, 4, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(5D, 10D);
        assertThat(result, is(expected));
    }
}