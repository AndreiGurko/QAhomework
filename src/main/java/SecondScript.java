import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SecondScript {
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
        Thread.sleep(5000);
        List<WebElement> webList;
        webList = driver.findElements(By.xpath("//li[contains(@class, 'maintab')]"));
        List<String> menuString = new ArrayList<String>();
        int size = webList.size();

        for (int i = 0; i < size; i++) {
            menuString.add(webList.get(i).getText());
        }

        String beforeRefreshItem = null;
        String afterRefreshItem = null;
        WebElement linkOfMenu = null;

        for (int i = 0; i < size; i++) {
            linkOfMenu = driver.findElement(By.linkText(menuString.get(i)));
            linkOfMenu.click();
            beforeRefreshItem = driver.getTitle();
            Thread.sleep(2000);
            driver.navigate().refresh();
            afterRefreshItem = driver.getTitle();
            System.out.println("before refresh = " + beforeRefreshItem + ", after refresh = " + afterRefreshItem + ", is equal = " + beforeRefreshItem.equals(afterRefreshItem));
            Thread.sleep(2000);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
