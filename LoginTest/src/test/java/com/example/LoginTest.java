package com.example;

// Gerekli kütüphaneler import ediliyor
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * Bu sınıf, Selenium WebDriver kullanarak hatalı bir login denemesi testini gerçekleştirir.
 * Eğer hata mesajı doğru şekilde görüntülenirse, sayfanın ekran görüntüsü alınır.
 */
public class LoginTest {

    WebDriver driver;

    // Her testten önce çalışacak method. Tarayıcı başlatılıyor.
    @BeforeEach
    public void setUp() {
        // WebDriverManager, ChromeDriver'ı otomatik olarak indirip yapılandırır.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Asıl test metodu
    @Test
    public void testInvalidLogin() throws IOException {
        // Test edilecek siteye gidiliyor
        driver.get("https://the-internet.herokuapp.com/login");

        // Giriş formundaki alanlar bulunuyor
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Hatalı kullanıcı adı ve şifre giriliyor
        username.sendKeys("wronguser");
        password.sendKeys("wrongpass");
        loginButton.click();

        // Hata mesajı kontrol ediliyor
        WebElement errorMessage = driver.findElement(By.id("flash"));
        if (errorMessage.getText().contains("Your username is invalid")) {
            // Eğer beklenen hata mesajı görünüyorsa ekran görüntüsü alınıyor
            takeScreenshot("invalid_login_error.png");
        }
    }

    // Ekran görüntüsü alan yardımcı metod
    private void takeScreenshot(String fileName) throws IOException {
        // Sayfanın ekran görüntüsü alınır ve belirtilen dosyaya yazılır
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("screenshots/" + fileName));
    }

    // Her testten sonra çalışacak method. Tarayıcı kapatılıyor.
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}