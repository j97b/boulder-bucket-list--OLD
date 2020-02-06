package com.bae.tests.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BucketListPage {

    @FindBy(id="userInfo")
    private WebElement username;

    @FindBy(id="deleteUser")
    private WebElement deleteUserButton;

    @FindBy(xpath="/html/body/div[7]/div/div/div[3]/button[2]")
    private WebElement confirmDeleteUser;


    public void deleteUser() throws InterruptedException {
        Thread.sleep(500);
        this.deleteUserButton.click();
        Thread.sleep(500);
        this.confirmDeleteUser.click();
    }

    public String loggedInUser() {
        return this.username.getText();
    }

}
