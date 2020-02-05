package com.bae.tests.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class IndexPage {
    @FindBy(xpath = "/html/body/div/button")
    private WebElement addUserButton;

    @FindBy(id="userName")
    private WebElement setUsername;

    @FindBy(id="userPassword")
    private WebElement setPassword;

    @FindBy(id="userPasswordConfirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[3]/button[2]")
    private WebElement submitButton;

    @FindBy(id="usernameInput")
    private WebElement inputUsername;

    @FindBy(id="passwordInput")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[5]/button")
    private WebElement signInButton;

    public void addUser(String username, String password) throws InterruptedException {
        this.addUserButton.click();
        Thread.sleep(500);
        this.setUsername.sendKeys(username);
        Thread.sleep(500);
        this.setPassword.sendKeys(password);
        Thread.sleep(500);
        this.confirmPassword.sendKeys(password);
        Thread.sleep(500);
        this.submitButton.click();
        Thread.sleep(500);
    }

    public void login(String username, String password) throws InterruptedException {
        this.inputUsername.sendKeys(username);
        Thread.sleep(500);
        this.inputPassword.sendKeys(password);
        Thread.sleep(500);
        this.signInButton.click();
    }

}
