import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys("webinar.test@gmail.com");
        element = driver.findElement(By.name("passwd"));
        element.sendKeys("Xcg7299bnSmMuRLp9ITw");
        element = driver.findElement(By.name("submitLogin"));
        element.submit();
        Thread.sleep(2000);
        element = driver.findElement(By.id("employee_infos"));
        element.click();
        Thread.sleep(3000);
        element = driver.findElement(By.id("header_logout"));
        element.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
