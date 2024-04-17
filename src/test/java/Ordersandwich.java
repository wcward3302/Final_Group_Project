import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ordersandwich {

    public WebDriver chrome_driver;

    @Test (priority = 1)
    void open_browser() throws InterruptedException{
        
        // Open new chrome driver, maximize, and navigate to site
        chrome_driver = new ChromeDriver();
        chrome_driver.manage().window().maximize();
        chrome_driver.get("https://publix.com/");

        // Will run into issues if location is not selected at this point
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[2]/div/div/button")).click();
        Thread.sleep(1000);
        // end location input a string as then return to fetch 
        chrome_driver.findElement(By.name("search")).sendKeys("Estero" + Keys.RETURN);
        Thread.sleep(1000);
        chrome_driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[1]/div/div/div[2]/div[1]/div/button")).click();
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    void order_ahead() throws InterruptedException{

        // Click order ahead for list of sandwiches
        chrome_driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/div[1]/a")).click();
        Thread.sleep(1000);

        // Select customize sandwich
        chrome_driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div/button[2]")).click();
        Thread.sleep(1000);

        //Review order
        chrome_driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(1000);

        // Confirm location
        chrome_driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/div/button[2]")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 10)
    void close_browser() throws InterruptedException {

        // quit and close web driver
        Thread.sleep(3000);
        chrome_driver.close();
        chrome_driver.quit();
    }

}