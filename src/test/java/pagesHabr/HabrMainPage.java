package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HabrMainPage extends HabrBasePage{
    public static String URL = "https://habr.com/ru";
    private By authBtn = By.xpath("//a[@id=\"login\"]");
    private By regBtn = By.xpath("//a[contains(@class, 'btn_navbar_registration')]");
    private By searchBtn = By.xpath("//a[contains(@class, 'tm-header-user-menu__search')]");
    private By searchField = By.xpath("//input[@name=\"searchQuery\"]");
    private By searchFieldSearchPage = By.xpath("//input[@name=\"q\"]");
    private By logo = By.xpath("//a[contains(@class, 'tm-header__logo')]");
    private By usersLink = By.xpath("//span//a[@href='/ru/users/']");
    private By langBtn = By.xpath("//span[contains(@class, 'tm-user-menu__menu-link-text')]");
    private By langPopup = By.xpath("//form[contains(@class, 'tm-popup-page-settings__form')]");
    private By newsLink = By.xpath("//span[@class= 'tm-tabs__tab-item']//a[contains(text(),'Новости')]");
    private By postsLink = By.xpath("//span[@class= 'tm-tabs__tab-item']//a[contains(text(),'Статьи')]");
    private By profile = By.xpath("//div[contains(@class, 'tm-header-user-menu__item')]");
    private By authButton = By.xpath("//div[contains(@class, 'tm-user-menu__auth-buttons')]//a[contains(text(),'Войти')]");
    private By registrationButton = By.xpath("//div[contains(@class, 'tm-user-menu__auth-buttons')]//a[contains(text(),'Регистрация')]");

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("open main page")
    public HabrMainPage open() {
        driver.get(URL);
        logger.info("Main page HABR is open");
        return new HabrMainPage(driver);
    }

    public WebElement getMainLogo(){
        return driver.findElement(logo);
    }

    @Step("open profile window")
    public HabrMainPage profileWindow() {
        driver.findElement(profile).click();
        logger.info("profile window is open");
        return new HabrMainPage(driver);
    }

    @Step("open auth page")
    public HabrAuthPage auth() {
        driver.findElement(authButton).click();
        logger.info("Auth page HABR is open");
        return new HabrAuthPage();
    }

    @Step("open reg page")
    public HabrRegPage reg() {
        driver.findElement(registrationButton).click();
        logger.info("Reg page HABR is open");
        return new HabrRegPage();
    }

    @Step("open search page")
    public HabrSearchPage search(String myText) {
        driver.findElement(searchBtn).click();
        driver.findElement(searchFieldSearchPage).sendKeys(myText);
        driver.findElement(searchFieldSearchPage).sendKeys(Keys.ENTER);
        logger.info("Search page HABR is open");
        return new HabrSearchPage();
    }

    @Step("open users page")
    public HabrUsersPage users() {
        driver.findElement(usersLink).click();
        logger.info("Users page HABR is open");
        return new HabrUsersPage(driver);
    }

    @Step("open change language window")
    public HabrMainPage openLangPopup() {
        driver.findElement(langBtn).click();
        logger.info("Language window HABR is open");
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-lang_settings\"]/div[@class=\"popup\"]")));
        return new HabrMainPage(driver);
    }

    @Step("displaying launguage window")
    public WebElement showLangPopup() {
        return driver.findElement(langPopup);
    }

    @Step("open news page")
    public HabrNewsPage news() {
        driver.findElement(newsLink).click();
        logger.info("News page HABR is open");
        return new HabrNewsPage(driver);
    }

    @Step("open articles page")
    public HabrPostsPage posts() {
        driver.findElement(postsLink).click();
        logger.info("Article page HABR is open");
        return new HabrPostsPage(driver);
    }

}
