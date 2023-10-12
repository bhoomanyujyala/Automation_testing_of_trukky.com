package trukky;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class trunkky_auto {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","D:\\setup\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trukky.com/door-to-door-goods-delivery");

        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Page Title: " + pageTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/span")));

        WebElement pickupCityInput = driver.findElement(By.xpath("//input[@placeholder='Enter pickup city']"));
        pickupCityInput.sendKeys("Hyderabad");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).click();

        WebElement dropCityInput = driver.findElement(By.xpath("//input[@placeholder='Enter drop city']"));
        dropCityInput.sendKeys("Delhi");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/ul[1]/li[1]")).click();
        WebElement checkPriceButton = driver.findElement(By.xpath("//button[normalize-space()='Check price']"));
        checkPriceButton.click();

        WebElement personalServiceRadio=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='jsx-665002787 serviceDetails'])[2]")));
        personalServiceRadio.click();

        WebElement loadService=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Few packed items ( 1 - 5 )']")));
        loadService.click();

        WebElement addMaterialButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]")));
        addMaterialButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Add material 1 details']")));
        Select chooseMaterialDropdown = new Select(driver.findElement(By.xpath("(//select[@class='jsx-1905266029'])[1]")));
        chooseMaterialDropdown.selectByVisibleText("Window AC");

        WebElement noOfItemsInput = driver.findElement(By.xpath("(//input[@placeholder='Enter No. of item'])[1]"));
        noOfItemsInput.sendKeys("2");

        WebElement forwardButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]"));
        forwardButton.click();

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Next'])[1]")));
        nextButton.click();

        WebElement dateselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[19]/abbr[1]")));
        dateselect.click();

        nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Next'])[1]")));
        nextButton.click();

        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Whatsapp no. recommended'])[1]")));
        phoneInput.sendKeys("6397903211");

        WebElement getprice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Get price'])[1]")));
        getprice.click();
    }
}
