package ru.job4j.oop;


import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(2, 0);
        int expected = 2;
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when01to02then1() {
        Point firstPoint = new Point(0, 1);
        Point secondPoint = new Point(0, 2);
        int expected = 1;
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to00then0() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(0, 0);
        int expected = 0;
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to00to00then0() {
        Point firstPoint = new Point(0, 0, 0);
        Point secondPoint = new Point(0, 0, 0);
        int expected = 0;
        double out = firstPoint.distance3d(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when001to000then1() {
        Point firstPoint = new Point(0, 0, 1);
        Point secondPoint = new Point(0, 0, 0);
        int expected = 1;
        double out = firstPoint.distance3d(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }
}