package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberMatrixTest {

    @Test
    public void whenFindAddress() {
        Integer[][] matrix = new Integer[2][2];
        matrix[0][0] = 12;
        matrix[0][1] = 22;
        matrix[1][0] = 112;
        matrix[1][1] = 122;
        assertThat(List.of(12, 22, 112, 122), is(NumberMatrix.convertMatrixToList(matrix)));
    }
}