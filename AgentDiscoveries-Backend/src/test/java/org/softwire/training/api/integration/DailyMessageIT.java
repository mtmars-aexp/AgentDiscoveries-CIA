package org.softwire.training.api.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softwire.training.api.core.MessageProcessor;
import org.softwire.training.api.integration.helper.LoginHelper;
import org.softwire.training.api.integration.helper.WebDriverHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DailyMessageIT {

    public static final String TARGET_ADDRESS =System.getProperty("target.address");

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        driver = WebDriverHelper.getSharedDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testCanEncodeAndDecodeMessage() {
        MessageProcessor messageProcessor = new MessageProcessor();

        String plaintext = "aTestMessage";
        String encoded = messageProcessor.encode(plaintext);

        LoginHelper.login(driver, TARGET_ADDRESS);
        try {
            driver.get(TARGET_ADDRESS + "/#/message");
        } catch (Exception e) {
            if (e.getClass() != TimeoutException.class) {
                throw e;
            }
        }
        WebElement userNameInput = driver.findElement(By.id("message-input"));
        userNameInput.sendKeys(plaintext);

        WebElement encodeButton = driver.findElement(By.id("encode-button"));
        encodeButton.click();
        WebElement resultDiv = driver.findElement(By.id("code-result"));
        wait.until(ExpectedConditions.textToBePresentInElement(resultDiv, encoded));

        WebElement decodeButton = driver.findElement(By.id("decode-button"));
        decodeButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(resultDiv, plaintext));
    }
}
