package TestNGPackage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test
public class TestAutomationNGFile {
       
  public WebDriver driver; 
  public String driverPath = "D:/chromedriver.exe";

  /**
   * 
   */
  @BeforeTest
  public void launchBrowser() {
         System.setProperty("webdriver.chrome.driver", driverPath);  
         driver = new ChromeDriver();
         driver.navigate().to("\r\n" + "http://adactin.com/HotelApp/");
  }
  
  /**
   * 
   * @throws InterruptedException
   */
  @Test(priority=0)
  public void validateLogin()  throws InterruptedException {
              driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("deepak123");
              driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("Infosys123");
              driver.findElement(By.xpath("//*[@id=\'login\']")).click();
  }
  
  /**
   * 
   * @throws InterruptedException
   */
  @Test(priority=1)
  public void searchHotel() throws InterruptedException {
              
              TimeUnit.MILLISECONDS.sleep(2000);
              Select location= new Select(driver.findElement(By.xpath("//*[@id='location']")));
              location.selectByVisibleText("Sydney");
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select hotels= new Select(driver.findElement(By.xpath("//*[@id='hotels']")));
              hotels.selectByVisibleText("Hotel Creek");
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select roomType= new Select(driver.findElement(By.xpath("//*[@id=\'room_type\']")));
              roomType.selectByVisibleText("Standard");
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select childRoom= new Select(driver.findElement(By.xpath("//*[@id=\'child_room\']")));
              childRoom.selectByVisibleText("1 - One");
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              
              driver.findElement(By.xpath("//*[@id=\'Submit\']")).click();
              TimeUnit.MILLISECONDS.sleep(1000);
  }    
      
  /**
   * 
   * @throws InterruptedException
   */
  @Test(priority=2) 
  public void selectHotel() throws InterruptedException {
              driver.findElement(By.xpath("//*[@id='radiobutton_0']")).click();
              TimeUnit.MILLISECONDS.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id=\'continue\']")).click();
              TimeUnit.MILLISECONDS.sleep(1000);
  }
  
  /**
   * Author :  Avneet Singh
   * @throws InterruptedException
   */
  @Test(priority=3)
  public void bookingConfirmation() throws InterruptedException {       
              driver.findElement(By.xpath("//*[@id=\'first_name\']")).sendKeys("Deepak");
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'last_name\']")).sendKeys("Arora");
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'address\']")).sendKeys("H No 100 A/City");
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'cc_num\']")).sendKeys("1234567891234567");
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              Select ccType= new Select(driver.findElement(By.xpath("//*[@id=\'cc_type\']")));
              ccType.selectByVisibleText("VISA");
              TimeUnit.MILLISECONDS.sleep(1000);
              
              Select ccExpMonth= new Select(driver.findElement(By.xpath("//*[@id=\'cc_exp_month\']")));
              ccExpMonth.selectByVisibleText("June"); 
              TimeUnit.MILLISECONDS.sleep(1000);
              
              Select ccExpYear= new Select(driver.findElement(By.xpath("//*[@id=\'cc_exp_year\']")));
              ccExpYear.selectByVisibleText("2022"); 
              TimeUnit.MILLISECONDS.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id=\'cc_cvv\']")).sendKeys("1234");   
              TimeUnit.MILLISECONDS.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id=\'book_now\']")).click();
              
              TimeUnit.MILLISECONDS.sleep(5000);
    }
  
  /**
   * 
   * @throws InterruptedException
   */
    @Test(priority=4)
    public void logout() throws InterruptedException {            
                            driver.findElement(By.xpath("//*[@id=\'logout\']")).click();//*[@id="logout"]
                           
                           TimeUnit.MILLISECONDS.sleep(10000);
       }

	/**
	 * 
	 */
    @AfterTest
    public void terminateBrowser() {
              driver.close();
       }
}


