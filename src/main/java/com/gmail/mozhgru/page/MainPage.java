package com.gmail.mozhgru.page;

import com.gmail.mozhgru.config.Config;
import com.gmail.mozhgru.config.PageHandler;
import com.gmail.mozhgru.elements.Button;
import com.gmail.mozhgru.elements.Label;
import com.gmail.mozhgru.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//div[@aria-label=\"Информация об аккаунте\"]/div[1]/div/div[2]")
    private WebElement profileContainer;
    private Label labelProfileContainer = new Label(profileContainer);

    @FindBy(xpath = "//a[contains(text(), 'Выйти')]")
    private WebElement logOut;
    private Button bttnLogOut = new Button(logOut);

    @FindBy(xpath = "//tr[1]//div[2]//span[contains(text(), 'Черновик')]")
    private WebElement lastDraft;

    @FindBy(xpath = "//a[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")
    private WebElement bttnAccount;
    private Button bttnAcc = new Button(bttnAccount);

    @FindBy(xpath = "//div[contains(text(), 'Написать')]")
    private WebElement bttnCompose;

    @FindBy(xpath = "//div[contains(@data-tooltip, 'Черновики')]")
    private WebElement bttnDrafts;

    @FindBy(xpath = "//div[contains(@data-tooltip, 'Отправленные')]")
    private WebElement bttnSentMessages;

    @FindBy(xpath = "//tr[1]//td//div[contains(text(), 'Кому')]")
    private WebElement lastLetter;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void tryLogOut(){
        bttnAcc.click();
        bttnLogOut.click();
    }

    public String getCurrentUser(){
        return labelProfileContainer.getText();
    }

    public void chooseLastDraft(){
        lastDraft.click();
    }

    public void chooseLastLetter(){
        lastLetter.click();
    }

    public void checkAccount() {
        bttnAcc.click();
    }

    public void compose() {
        bttnCompose.click();
    }

    public void checkDrafts() {
        bttnDrafts.click();
    }

    public void checkSentMessages() {
        try {
            bttnSentMessages.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            bttnSentMessages.click();
        }
    }

    @Override
    protected void waitForLoadFinished() {
        new WebDriverWait(driver, 10000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
