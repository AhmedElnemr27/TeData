package TESTS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class TeData {


        public WebDriver Driver;

        @BeforeTest
        public void beforetest(){
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            Driver = new ChromeDriver(co);
            Driver.navigate().to("https://my.te.eg/user/login");
        }

        @Test
        public void TeData() throws InterruptedException {
            Thread.sleep(8000);
            WebElement UserName = Driver.findElement(By.xpath("//*[@id=\"login-service-number-et\"]"));
            UserName.sendKeys("0224482666");
            WebElement ServiceType = Driver.findElement(By.xpath("/html/body/app-root/div/div[1]/app-login/div/div/div/p-card[1]/div/div/div/form/div/div[1]/div[2]/app-service-number-type/div/p-dropdown/div/span"));
            ServiceType.click();
            Driver.findElement(By.xpath("/html/body/app-root/div/div[1]/app-login/div/div/div/p-card[1]/div/div/div/form/div/div[1]/div[2]/app-service-number-type/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li")).click();
            WebElement Password = Driver.findElement(By.id("login-password-et"));
            Password.sendKeys("Nemr1230");
            WebElement LogIn = Driver.findElement(By.id("login-login-btn"));
            LogIn.click();
            //Thread.sleep(7000);
            WebDriverWait wait = new WebDriverWait(Driver,Duration.ofSeconds(20));
            WebElement FAssertion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/app-dashboard/div/div/div[3]/p-card/div/div/div/div[1]/button")));
            //WebElement FAssertion = Driver.findElement(By.xpath("//*[@id=\"welcome_card\"]/div/div/div[2]/div/div[1]/div/p-dropdown/div/span"));
            Assert.assertTrue(FAssertion.isDisplayed(),"Failed");
            // System.out.println("LginSuccesfully");
            Thread.sleep(5000);
            WebElement Usage = Driver.findElement(By.xpath("/html/body/app-root/div/div[1]/app-dashboard/div/div/div[3]/p-card/div/div/div/div[1]/button"));
            Usage.click();
            WebDriverWait waitt = new WebDriverWait(Driver,Duration.ofSeconds(20));
            WebElement qouta = waitt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/app-offering/app-usage/div/div/p-card/div/div/div/div[1]/div[1]/app-gauge/div/span[1]")));
            String quotaText = qouta.getText();
            String numericValue = quotaText.replaceAll("[^0-9]", "");
            if (Integer.parseInt(numericValue) < 40) {
                System.out.println("Qouta is Under 40 MB");
            } else {
                System.out.println("Qouta is sufficient");
            }







        }
    }

