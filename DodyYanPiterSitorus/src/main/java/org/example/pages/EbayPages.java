package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.utils.DriverFactory;
import org.example.utils.Waitility;

import java.util.ArrayList;
import java.util.List;

public class EbayPages {

    public void fillSearchBar(String query) {
        String searchBar = "//div[@id='gh-search-box']//input";
        WebElement searchBarElement = DriverFactory.getDriver().findElement(By.xpath(searchBar));
        searchBarElement.click();
        searchBarElement.sendKeys(query);
    }

    public void clickButtonSearch() {
        String searchBtn = "//div[@class='gh-search-button__wrap']//button";
        WebElement searchBtnElement = DriverFactory.getDriver().findElement(By.xpath(searchBtn));
        searchBtnElement.click();
    }

    public List<String> listOfResultQuery() {
        String listOfQuery = "//div[contains(@class, 'srp-river-results')]//div[contains(@class, 's-item__title')]//span[@role='heading']";
        Waitility.waitForElements(By.xpath(listOfQuery));
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(listOfQuery));

        List<String> resultText = new ArrayList<>();
        for (WebElement element : elements) {
            resultText.add(element.getText());
        }
        return resultText;
    }

    public void clickShopByCategoryBtn() {
        String shopByCategoryBtn = "//div[@class='gh-flyout is-left-aligned']/button[@class='gh-flyout__target']";
        WebElement shopByCategoryElement = DriverFactory.getDriver().findElement(By.xpath(shopByCategoryBtn));
        shopByCategoryElement.click();
    }

    public void selectCategory(String category) {
        String listOfCategories = "//div[@class='gh-categories__group']//a[@class='gh-categories__cat']";
        Waitility.waitForElements(By.xpath(listOfCategories));
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(listOfCategories));

        for (WebElement element : elements) {
            if (element.getText().equals(category)) {
                element.click();
                break;
            }
        }
    }

    public void selectFilter(String filter) {
        String listOfFilters = "//button[@class='filter-button filter-button--unselected filter-menu-button__button']";
        Waitility.waitForElements(By.xpath(listOfFilters));
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(listOfFilters));

        for (WebElement element : elements) {
            if (element.getText().equals(filter)) {
                element.click();
                break;
            }
        }
    }

    public void selectCondition(String condition) {
        String listOfConditions = "//div[@class='filter-menu-button__content show']//li[@class='brwr__inputs']//a[@class='brwr__inputs__actions']";
        Waitility.waitForElements(By.xpath(listOfConditions));
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(listOfConditions));

        for (WebElement element : elements) {
            if (element.getText().contains(condition)) {
                element.click();
                break;
            }
        }
    }

    public void clickFilterAppliedBtn(String query) {
        String filterApplied = "//div[@class='main-content']//section[@class='brw-region brw-region--right']//button[@class='filter-button filter-button--selected filter-menu-button__button']";
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(filterApplied));

        for (WebElement element : elements) {
            if (element.getText().contains(query)) {
                element.click();
                break;
            }
        }
    }

    public List<String> listOfFiltersApplied() {
        String listOfFiltersApplied = "//ul[@class='filter-menu-button__content__list']//span[contains(@class,'filter-label')]";
        Waitility.waitForElements(By.xpath(listOfFiltersApplied));
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath(listOfFiltersApplied));

        List<String> actualFiltersApplied = new ArrayList<>();
        for (WebElement element : elements) {
            actualFiltersApplied.add(element.getText());
        }
        return actualFiltersApplied;
    }
}
