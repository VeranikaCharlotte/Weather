import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VeranikaCharlotteOnGitHubTest {
//    Все теcты необходимо писать
//    в проекте Weather (Maven/TestNG 7.4.0/Selenium3.141.59),
//    в зеленой папке java,
//    в тестовом классе YourNickOnGitHubTest.
//
//    Для всех тест кейсов -
//            System.setProperty("webdriver.chrome.driver", "YouPathToFile/chromedriver");
//    WebDriver driver = new ChromeDriver();
//
//    String url = "https://openweathermap.org/";
//
//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
// что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testH2TagText_WhenClickGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResultUrl = "https://openweathermap.org/guide";
        driver.get(url);

        Thread.sleep(6000);

        WebElement guideElementInMenu = driver.findElement(
                By.xpath("//a[@href='/guide']")
        );
        guideElementInMenu.click();
        String actualResultUrl = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();

        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        Assert.assertEquals(actualResultTitle, expectedResultTitle);

//        WebElement searchButton = driver.findElement(
//                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
//        );
//        searchButton.click();
//        Thread.sleep(1000);
//
//        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
//                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
//        );
//        parisFRChoiceInDropdownMenu.click();
//
//        WebElement h2CityCountryHeader = driver.findElement(
//                By.xpath("//div[@id = 'weather-widget']//h2")
//        );
//        Thread.sleep(2000);
//        String actualResult = h2CityCountryHeader.getText();
//
//        Assert.assertEquals(actualResult, expectedResult);
//
        driver.quit();
    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testH2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F";

        driver.get(url);

        Thread.sleep(7000);

        WebElement MenuImperial = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class='option']/following-sibling::div")
        );

        MenuImperial.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@class='current-temp']/span"));

        String tempInF = tempF.getText();
        String actualResult = tempInF.substring(tempInF.length() - 2);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    //            TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом
// “We use cookies which are essential for the site to work. We also
// use non-essential cookies to help us improve our services. Any data
// collected is anonymised. You can allow all cookies or manage them individually.”
// 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
//
    @Test
    public void testCookiesBlockWithTextAndButtonsIsShown_WhenOpenTheBaseURL() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultDescription = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String button1Text = "Allow all";
        String button2Text = " Manage cookies ";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.className("stick-footer-panel__container")).isDisplayed());

        WebElement cookiesDescription = driver.findElement(By.className("stick-footer-panel__description"));
        String actualResultDescription = cookiesDescription.getText();

        Assert.assertEquals(actualResultDescription, expectedResultDescription);

        Assert.assertEquals(driver.findElements
                (By.xpath("//div[@class='stick-footer-panel__btn-container']/*")).size(), 2);

        Assert.assertTrue(driver.findElement
                (By.xpath("//div[@class='stick-footer-panel__btn-container']/*[text()='" + button1Text + "']")
                ).isDisplayed());

        Assert.assertTrue(driver.findElement(
                By.xpath("//div[@class='stick-footer-panel__btn-container']/*[text()='" + button2Text + "']")
        ).isDisplayed());

        driver.quit();
    }


    //    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testSupportWithText() throws InterruptedException  {

        System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedSubmenu1 = "FAQ";
        String expectedSubmenu2 = "How to start";
        String expectedSubmenu3 = "Ask a question";

        driver.get(url);
       driver.manage().window().maximize();
        Thread.sleep (5000);

        WebElement supportMenu = driver.findElement(By.id("support-dropdown"));
        supportMenu.click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElements(By.xpath("//ul[@id='support-dropdown-menu']/li")).size(),3);

        String actualSubmenu1 = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']/li[1]")).getText();
        String actualSubmenu2 = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']/li[2]")).getText();
        String actualSubmenu3 = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']/li[3]")).getText();

        Assert.assertEquals(actualSubmenu1, expectedSubmenu1);
        Assert.assertEquals(actualSubmenu2, expectedSubmenu2);
        Assert.assertEquals(actualSubmenu3, expectedSubmenu3);

        driver.quit();
    }


//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
    public void testCapcha() throws InterruptedException  {

    System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        String email = "google@gmail.com";
        String message = "Test message";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep (5000);

        WebElement supportMenu = driver.findElement
                (By.xpath("//li[@class='with-dropdown']"));

        supportMenu.click();
        Thread.sleep(5000);

        WebElement itemAskQuestion = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text()='Ask a question']")
        );
        itemAskQuestion.click();

        ArrayList<String>tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement emailField = driver.findElement(
                By.xpath("//input[@class = 'form-control string email required']")
        );
        emailField.sendKeys(email);

        WebElement selectField= driver.findElement(
                By.xpath("//select[@class='form-control select required']")

        );
        selectField.click();

        WebElement selectFieldChoice= driver.findElement(
                By.xpath("//option[@value='Sales']")
        );
        selectFieldChoice.click();

        WebElement messageField= driver.findElement(
                By.xpath("//textarea [@class='form-control text required']")

        );
        messageField.sendKeys(message);

        WebElement submitButton = driver.findElement(
                By.xpath("//input[@data-disable-with='Create Question form']")
        );
        submitButton.click();
        Thread.sleep(2000);

        WebElement reCapchaText = driver.findElement(
                By.xpath("//div[@class='help-block']")
                       );

        String actualResult = reCapchaText.getText();
        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();


}
//    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//            4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”


    @Test
    public void testErrorEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:/Drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(4000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(4500);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(3000);

        WebElement enterSubject = driver.findElement(By.xpath(
                "//select[@class='form-control select required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(4000);

        WebElement enterMessage = driver.findElement(By.xpath(
                "//textarea[@class='form-control text required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        Thread.sleep(5000);
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
        }


}

