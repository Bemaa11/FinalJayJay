package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Utility.driver;

public class FormPage {

    By inputName = By.id("name");
    By inputCountry = By.id("country");
    By inputCity = By.id("city");
    By inputCreditCard = By.id("card");
    By inputMonth = By.id("month");
    By inputYear = By.id("year");

    private WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setCountry(String country) {
        driver.findElement(inputCountry).sendKeys(country);
    }

    public void setCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
    }

    public void setCreditCard(String creditCard) {
        driver.findElement(inputCreditCard).sendKeys(creditCard);
    }

    public void setMonth(String month) {
        driver.findElement(inputMonth).sendKeys(month);
    }

    public void setYear(String year) {
        driver.findElement(inputYear).sendKeys(year);
    }
}
