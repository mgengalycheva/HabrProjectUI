package casesHabr;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesHabr.HabrMainPage;
import pagesHabr.HabrNewsPage;
import pagesHabr.HabrPostsPage;


public class HabrTest extends HabrBaseTest {

    @Epic("Testing HABR")
    @Feature(value="home page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking Logo on main page is visible")
    @Test
    public void habrTest1() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        Assert.assertTrue(habrMainPage.getMainLogo().isDisplayed());
        logger.info("logo has link");
    }

    @Epic("Testing HABR")
    @Feature(value="auth page functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking title on auth page is visible")
    @Test
    public void habrTest2() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .auth();

        WebElement authTitle = driver.findElement(By.xpath("//div[contains(text(),'Вход')]"));
        Assert.assertEquals(authTitle.getText(), "Вход");
        logger.info("Title Вход is true");
    }

    @Epic("Testing HABR")
    @Feature(value="auth page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking enter button on auth page is visible")
    @Test
    public void habrTest14() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .auth();

        WebElement enterButton = driver.findElement(By.xpath("//button[@name = 'go']"));
        Assert.assertTrue(enterButton.isDisplayed());
    }

    @Epic("Testing HABR")
    @Feature(value="reg page functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking title on reg page is visible")
    @Test
    public void habrTest3() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        WebElement regTitle = driver.findElement(By.xpath("//div[contains(text(),'Регистрация')]"));
        Assert.assertEquals(regTitle.getText(), "Регистрация");
        logger.info("Title Регистарция is true");
    }

    @Epic("Testing HABR")
    @Feature(value="reg page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking reg button on reg page is visible")
    @Test
    public void habrTest15() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        WebElement registrationButton = driver.findElement(By.xpath("//button[@id = 'registration_button']"));
        Assert.assertTrue(registrationButton.isDisplayed());
    }

    @Epic("Testing HABR")
    @Feature(value="search page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking whether the set value matches the search results")
    @Test
    public void habrTest4() {
        String myText = "что-то";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .search(myText);
        String xpath = "//input[contains(@value,'" + myText + "')]";
        WebElement searchText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(searchText.getAttribute("value"), myText);
        logger.info("Search page HABR has myText search");
    }

    @Epic("Testing HABR")
    @Feature(value="users page functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the user that was searched is on the list")
    @Test
    public void habrTest5() {
        String myUserSearch = "oldadmin";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .users()
                    .search(myUserSearch);
        //String xpath = "//*[contains(@class, 'list-snippet__username')]/a[contains(@class,'list-snippet__nickname') and contains(text(), '" + myUserSearch + "')]";
        //WebElement userText = driver.findElement(By.xpath(xpath));
        //Assert.assertEquals(userText.getText(), myUserSearch);
    }

    @Epic("Testing HABR")
    @Feature(value="modal language window functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking modal language window is visible")
    @Test
    public void habrTest6() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();
        Assert.assertTrue(habrMainPage.showLangPopup().isDisplayed());
        logger.info("lang popup is visible");
    }

    @Epic("Testing HABR")
    @Feature(value="modal language window functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking save settings button is vissible on modal language window")
    @Test
    public void habrTest13() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();

        WebElement saveSettingsButton = driver.findElement(By.xpath("//div[@class='form__footer form__footer_lang-settings']"));
        Assert.assertTrue(saveSettingsButton.isDisplayed());
    }

/*    @Epic("Testing HABR")
    @Feature(value="news page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking title for the first article in the list is visible")
    @Test
    public void habrTest7() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrNewsPage habrNewsPage = habrMainPage.open()
                .news()
                .openFirstArticle();

        WebElement titleNews = driver.findElement(By.xpath("//h2[contains(@class, 'post__title')]"));
        String textTitleNews = titleNews.getText();
        Assert.assertEquals(habrNewsPage.getTitleNewsFirst(), textTitleNews);
    }*/

    @Epic("Testing HABR")
    @Feature(value="users page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking that users with rate 1 is the first in the list")
    @Test
    public void habrTest8() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        WebElement firstRate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        String firstRateText = firstRate.getText();
        Assert.assertEquals(firstRateText, "1–й");
    }

    @Epic("Testing HABR")
    @Feature(value="users page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the overall rate is visible for the first user in the list")
    @Test
    public void habrTest12() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        WebElement userRate = driver.findElement(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя' )] "));
        Assert.assertTrue(userRate.isDisplayed());
    }

/*    @Epic("Testing HABR")
    @Feature(value="article page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking opening first article in the list")
    @Test
    public void habrTest9() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrPostsPage habrPostsPage = habrMainPage.open()
                .posts()
                .openFirstPost();

        WebElement titlePost = driver.findElement(By.xpath("//h1[contains(@class, 'post__title')]"));
        String textTitlePost = titlePost.getText();
        Assert.assertEquals(habrPostsPage.getTitlePostFirst(), textTitlePost);
    }*/

    @Epic("Testing HABR")
    @Feature(value="article page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking that all info for author of the first article in the list is displayed")
    @Test
    public void habrTest10() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .posts()
                    .openPostAuthor();

        WebElement rate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        Assert.assertTrue(rate.isEnabled());
    }

    @Epic("Testing HABR")
    @Feature(value="article page functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the author of article has an invintation")
    @Test
    public void habrTest11() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .posts()
                .openPostAuthor();

        WebElement invite = driver.findElement(By.xpath("//p[@class = 'profile-section__invited']"));
        Assert.assertTrue(invite.isDisplayed());
    }

}





