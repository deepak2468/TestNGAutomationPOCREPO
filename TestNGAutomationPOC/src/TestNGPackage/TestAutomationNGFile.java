package TestNGPackage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;


@Test
public class TestAutomationNGFile {
       
  public WebDriver driver; 
  public String driverPath = DeclareConstants.DRIVER_PATH;

  /**
   * 
   */
  @BeforeTest
  public void launchBrowser() {
         System.setProperty(DeclareConstants.CHROME_DRIVER, driverPath); 
         driver = new ChromeDriver();
         driver.navigate().to("\r\n" + DeclareConstants.WEBSITE_URL);
  }
  
  /**
   * 
   * @throws InterruptedException
   */
  @Test(priority=0)
  public void validateLogin()  throws InterruptedException {
	  
	  		  // To verify title of login page
	  		  Assert.assertEquals(DeclareConstants.LOGIN_PAGE_TITLE, driver.getTitle());
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
	  		
	     	  // To verify title of search hotel page
              Assert.assertEquals(DeclareConstants.SEARCH_HOTEL_PAGE_TITLE, driver.getTitle());
              
              //To verify the login user
              WebElement userNameElement = driver.findElement(By.xpath("//*[@id='username_show']"));
              String userName = userNameElement.getAttribute("value");
              Assert.assertEquals("Hello deepak123!", userName);
	  		  
	  		  TimeUnit.MILLISECONDS.sleep(2000);
              Select location= new Select(driver.findElement(By.xpath("//*[@id='location']")));
              location.selectByVisibleText(DeclareConstants.LOCATION);
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select hotels= new Select(driver.findElement(By.xpath("//*[@id='hotels']")));
              hotels.selectByVisibleText(DeclareConstants.HOTEL_NAME);
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select roomType= new Select(driver.findElement(By.xpath("//*[@id=\'room_type\']")));
              roomType.selectByVisibleText(DeclareConstants.ROOM_TYPE);
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              Select childRoom= new Select(driver.findElement(By.xpath("//*[@id=\'child_room\']")));
              childRoom.selectByVisibleText(DeclareConstants.CHILD_ROOM_TYPE);
              
              TimeUnit.MILLISECONDS.sleep(2000);
              
              //Click on reset button
              driver.findElement(By.xpath("//*[@id=\'Reset\']")).click();
              
              //To verify that select boxes resets to default values
              Assert.assertEquals("- Select Location -", location.getFirstSelectedOption().getText());
              Assert.assertEquals("- Select Hotel -", hotels.getFirstSelectedOption().getText());
              Assert.assertEquals("- Select Room Type -", roomType.getFirstSelectedOption().getText());
              Assert.assertEquals("- Select Children per Room -", childRoom.getFirstSelectedOption().getText());
              
              TimeUnit.MILLISECONDS.sleep(2000);
              location.selectByVisibleText(DeclareConstants.LOCATION);
              TimeUnit.MILLISECONDS.sleep(2000);
              hotels.selectByVisibleText(DeclareConstants.HOTEL_NAME);
              TimeUnit.MILLISECONDS.sleep(2000);
              roomType.selectByVisibleText(DeclareConstants.ROOM_TYPE);
              TimeUnit.MILLISECONDS.sleep(2000);
              childRoom.selectByVisibleText(DeclareConstants.CHILD_ROOM_TYPE);
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
	  
 	  		  // To verify title of book hotel page
      		  Assert.assertEquals(DeclareConstants.BOOKING_CONFIRMATION_PAGE_TITLE, driver.getTitle());
      
              driver.findElement(By.xpath("//*[@id=\'first_name\']")).sendKeys(DeclareConstants.BOOKING_HOLDER_FIRST_PAGE);
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'last_name\']")).sendKeys(DeclareConstants.BOOKING_HOLDER_LAST_PAGE);
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'address\']")).sendKeys(DeclareConstants.BOOKING_HOLDER_ADDRESS);
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              driver.findElement(By.xpath("//*[@id=\'cc_num\']")).sendKeys(DeclareConstants.CC_NUM);
              TimeUnit.MILLISECONDS.sleep(1000);
              
              
              Select ccType= new Select(driver.findElement(By.xpath("//*[@id=\'cc_type\']")));
              ccType.selectByVisibleText(DeclareConstants.CC_TYPE);
              TimeUnit.MILLISECONDS.sleep(1000);
              
              Select ccExpMonth= new Select(driver.findElement(By.xpath("//*[@id=\'cc_exp_month\']")));
              ccExpMonth.selectByVisibleText(DeclareConstants.MONTH); 
              TimeUnit.MILLISECONDS.sleep(1000);
              
              Select ccExpYear= new Select(driver.findElement(By.xpath("//*[@id=\'cc_exp_year\']")));
              ccExpYear.selectByVisibleText(DeclareConstants.YEAR); 
              TimeUnit.MILLISECONDS.sleep(1000);
              
              driver.findElement(By.xpath("//*[@id=\'cc_cvv\']")).sendKeys(DeclareConstants.CC_CVV);   
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


