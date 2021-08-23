package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HabrNewsPage extends HabrBasePage{

    public List<WebElement> articles = driver.findElements(By.xpath("//h2[contains(@class, 'tm-article-snippet__title_h2')]//a//span"));
    private final String titleNewsFirst = articles.get(0).getText();

    public HabrNewsPage(WebDriver driver) {
        super(driver);
    }

    @Step("open first news article")
    public HabrNewsPage openFirstArticle() {
        articles.get(0).click();
        logger.info("First article is open");
        return this;
    }

    @Step("getting title for first article")
    public String getTitleNewsFirst() {return titleNewsFirst;}
}
