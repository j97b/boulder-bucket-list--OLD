package com.bae.tests.selenium.tests;

import com.bae.tests.selenium.constants.Constants;
import com.bae.tests.selenium.pages.BucketListPage;
import com.bae.tests.selenium.pages.IndexPage;
import org.apache.tomcat.util.bcel.Const;
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

import static org.junit.Assert.*;

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
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1600, 700));
    }

    @Test
    public void userSetupTest() throws InterruptedException {
        this.driver.get("http://18.130.213.255:8086/bbl/index.html");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        BucketListPage bucketListPage = PageFactory.initElements(driver, BucketListPage.class);
        indexPage.addUser("james","password");
        indexPage.login("james","password");
        assertEquals(bucketListPage.loggedInUser(),"james");
    }

    @After
    public void tearDown() {
        this.driver.close();
    }

}
