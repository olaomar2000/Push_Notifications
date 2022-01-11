package com.example.push_notifications.Assignment3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.push_notifications.IMath;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Assignment3Test {
Assignment3 assignment3;
    @Before
    public void setUp() throws Exception {
        assignment3 = new Assignment3();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After ");
    }

    @Test
    public void getIevaluation() {

        iEvaluation evaluation = mock(iEvaluation.class);
        assignment3.setIevaluation(evaluation);
        when(evaluation.evaluationForGrade(95)).thenReturn("A");
        Assert.assertEquals("Result is : A",assignment3.getEvaluation(95));

    }
}