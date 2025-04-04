package org.example.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utils.DriverFactory;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
