package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Utility.driver;

public class ProductPage {
    By nextPage = By.id("next2");
    By previousPage = By.id("prev2");
    By addToCart = By.xpath("//a[@onclick=\"addToCart(1)\"]");
    By phonesButton = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    By cartButton = By.id("cartur");
    By placeOrderButton = By.xpath("//button[.='Place Order']");
    By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    By purchaseDetail = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String generateLocator(String itemName){
        String locator = "//a[.='"+ itemName + "']/parent::h4/parent::div/parent::div/a";
        return locator;
    }

    public void clickItem(String item)throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath(generateLocator(item))).click();
    }

    public void buttonNextPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(nextPage).click();
    }

    public void assertPage2() {
        driver.findElement(previousPage).isDisplayed();
    }

    public void buttonPreviousPage() throws InterruptedException {
            Thread.sleep(2000);
        driver.findElement(previousPage).click();
    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void assertPhonesButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(phonesButton).click();
    }

    public void validateAllertMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();

        // Dapatkan teks dari alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Terima alert
        alert.accept();
    }
    public void setCartButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(cartButton).click();
    }

    public void setPlaceOrderButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(placeOrderButton).click();
    }

    public void setPurchaseButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(purchaseButton).click();
    }

    public void purchaseOrder() {
        driver.findElement(purchaseDetail).isDisplayed();
    }
}