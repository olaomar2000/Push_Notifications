package com.example.push_notifications.TDD;

import static org.junit.Assert.*;

import android.graphics.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProfilePresenterTest {

   ProfilePresenter presenter;


    @Mock
    iProfileView view;
    @Before
    public void setUp() throws Exception {
        presenter = new ProfilePresenter(view);
    }

    @After
    public void tearDown() throws Exception {
    }



    // counter
    @Test
    public void testIfuiUpdateColorRed() {
        int length = 201;
        int max = 200;
        int color = Color.RED;
        presenter.setView(length,max);
        Mockito.verify(view).updateColor(color);
    }
    @Test
    public void testIfuiUpdateColorGRAY() {

        int length = 150;
        int max = 200;
        int color = Color.GRAY;
        presenter.setView(length,max);
        Mockito.verify(view).updateColor(color);
    }
}