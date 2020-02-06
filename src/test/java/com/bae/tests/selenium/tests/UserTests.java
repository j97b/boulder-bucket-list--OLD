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
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @Before
    public void setup() {
        if (isLinux()){
            System.setProperty("webdriver.chrome.driver", "/snap/bin/chromium.chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(
                (ChromeDriverService)(new ChromeDriverService.Builder() {
                    @Override
                    protected File findDefaultExecutable() {
                        if (new File("/snap/bin/chromium.chromedriver").exists()) {
                            return new File("/snap/bin/chromium.chromedriver") {
                                @Override
                                public String getCanonicalPath() throws IOException {
                                    return this.getAbsolutePath();
                                }
                            };
                        } else {
                            return super.findDefaultExecutable();
                        }
                    }
                }).build(), options );
    }
    public boolean isLinux(){
        String os = System.getProperty("os.name").toLowerCase();
        return !os.contains("win");
    }

    @Test
    public void userSetupTest() throws InterruptedException {
        this.driver.get("http://localhost:" + port + "/bbl/index.html");
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
