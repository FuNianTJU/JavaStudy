package example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
	
	@Test
	public void testSelenium(){
		//驱动位置
    	System.getProperties().setProperty("webdriver.chrome.driver","D:/ProgramFiles/chromedriver_win32/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	//浏览器位置
    	options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("http://huaban.com/");
        WebElement webElement = driver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        driver.close();    
	}
}





































