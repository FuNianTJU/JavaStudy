package example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * chromeDriver是谷歌的浏览器驱动，用来适配Selenium,有图形页面存在，
 * 在调试爬虫下载运行的功能的时候会相对方便
 * @author yan
 *
 */
public class TestChromeDriver {
	public static void main(String[] args) {
        System.getProperties().setProperty("webdriver.chrome.driver", "D:/ProgramFiles/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        
        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().maximize();//窗口最大化
        
        //获取网页内容
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        
        System.out.println(webDriver.getTitle());
        
        webDriver.quit();
	}
}
