package com.bae.tests.selenium.tests;

import com.bae.tests.selenium.constants.Constants;
import com.bae.tests.selenium.pages.IndexPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @Before
    public void startup() {
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setBinary("/opt/google/chrome/");
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1600, 700));
    }

    @Test
    public void userSetupTest() {
        this.driver.get("http://localhost:" + port + "/index.html");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.addUser("barry");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/table/tr/td")));
        if (indexPage.checkUser("Barry")) {
        } else {
            fail("Registration failed");
        }
    }

    @After
    public void tearDown() {
        this.driver.close();
    }

}
