package stepDef;

import com.github.javafaker.Faker;
import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.FormPage;
import pages.ProductPage;
import pages.WebPage;


public class WebStep {

    WebPage webPage;
    ProductPage productPage;
    FormPage formPage;

    String nameFaker;
    String countryFaker;
    String cityFaker;
    String creditCardFaker;
    String monthFaker;
    String yearFaker;



    public WebStep() {
        this.webPage = new WebPage();
        productPage = new ProductPage(Utility.driver);
        formPage = new FormPage(Utility.driver);
    }

    @Given(": open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        webPage.buttonLogin();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String pwd) {
        webPage.inputpwd(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.inputLogin();
    }

    @And("user will see icon name of user")
    public void userWillSeeIconNameOfUser() {
        webPage.assertHomePage();
    }

    @And("user on the page and will see error message {string}")
    public void userOnThePageAndWillSeeErrorMessage(String message) throws InterruptedException {
        webPage.validateErrorMessage(message);
    }

    @And("user click next page")
    public void userClickNextPage() throws InterruptedException {
        productPage.buttonNextPage();
    }

    @And("user will see button previous page")
    public void userWillSeeButtonPreviousPage() {
        productPage.assertPage2();
    }

    @And("user click previous page")
    public void userClickPreviousPage() throws InterruptedException {
        productPage.buttonPreviousPage();
    }

    @And("click  button add to cart")
    public void clickButtonAddToCart() {
        productPage.addToCart();
    }

    @And("user click phones button")
    public void userClickPhonesButton() throws InterruptedException {
        productPage.assertPhonesButton();
    }

    @And("click detail item {string}")
    public void clickDetailItem(String item) throws InterruptedException {
        Thread.sleep(1000);
        productPage.clickItem(item);
    }


    @And("user success added the product {string}")
    public void userSuccessAddedTheProduct(String message) throws InterruptedException {
        productPage.validateAllertMessage(message);
    }

    @And("user click cart button")
    public void userClickCartButton() throws InterruptedException {
        productPage.setCartButton();
    }

    @And("user click place order button")
    public void userClickPlaceOrderButton() throws InterruptedException {
        productPage.setPlaceOrderButton();
    }


    @And("user set the name {string}")
    public void userSetTheName(String name) {
        FormPage formPage = new FormPage(Utility.driver);
        if (name.equals("random")) {
            Faker faker = new Faker();
            nameFaker = faker.name().name();
        } else {
            nameFaker = name;
        }
        formPage.setName(name);
    }

    @And("user set the country {string}")
    public void userSetTheCountry(String country) {
        FormPage formPage = new FormPage(Utility.driver);
        if (country.equals("random")) {
            Faker faker = new Faker();
            countryFaker = faker.country().countryCode2();
        } else {
            countryFaker = country;
        }
        formPage.setCountry(country);
    }

    @And("user set the city {string}")
    public void userSetTheCity(String city) {
        FormPage formPage = new FormPage(Utility.driver);
        if (city.equals("random")) {
            Faker faker = new Faker();
            cityFaker = faker.address().city();
        } else {
            cityFaker = city;
        }
        formPage.setCity(city);
    }

    @And("user set the credit card {string}")
    public void userSetTheCreditCard(String creditCard) {
        FormPage formPage = new FormPage(Utility.driver);
        if (creditCard.equals("random")) {
            Faker faker = new Faker();
            creditCardFaker = faker.number().digits(12);
        } else {
            creditCardFaker = creditCard;
        }
        formPage.setCreditCard(creditCardFaker);
    }

    @And("user set the month {string}")
    public void userSetTheMonth(String month) {
        FormPage formPage = new FormPage(Utility.driver);
        if (month.equals("random")) {
            Faker faker = new Faker();
            int randomNumber = faker.number().numberBetween(1, 12);
            // Convert the random number to a string
            monthFaker = String.valueOf(randomNumber);
        }else {
            monthFaker = month;
        }
        formPage.setMonth(monthFaker);
    }

    @And("user set the year {string}")
    public void userSetTheYear(String year) {
        FormPage formPage = new FormPage(Utility.driver);
        if (year.equals("random")) {
            Faker faker = new Faker();
            int randomNumber = faker.number().numberBetween(1960, 2025);
            yearFaker = String.valueOf(randomNumber);
        }else  {
            yearFaker = year;
        }
        formPage.setYear(yearFaker);
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() throws InterruptedException{
        productPage.setPurchaseButton();
    }

    @And("user gets notification of purchase details")
    public void userGetsNotificationOfPurchaseDetails() {
        productPage.purchaseOrder();
    }
}