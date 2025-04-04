package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waitility {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    public static List<WebElement> waitForElements(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
