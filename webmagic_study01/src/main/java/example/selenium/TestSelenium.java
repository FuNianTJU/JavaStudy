package example.selenium;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium {
	private static Set<Cookie> cookies;
	public static void login() {
	 	//驱动位置
    	System.getProperties().setProperty("webdriver.chrome.driver","D:/ProgramFiles/chromedriver_win32/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	//浏览器位置
    	options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    	//System.getProperties().setProperty("webdriver.chrome.bin", ""); 
        WebDriver driver = new ChromeDriver(options);
        //打开百度登入页面
        driver.get("https://passport.baidu.com/v2/?login&tpl=mn");
        //切换用户名密码登入
        driver.findElement(By.id("TANGRAM__PSP_3__footerULoginBtn")).click();
        //输入账号
        driver.findElement(By.id("TANGRAM__PSP_3__userName")).clear();
        driver.findElement(By.id("TANGRAM__PSP_3__userName")).sendKeys("18222668371");
        //输入密码
        driver.findElement(By.id("TANGRAM__PSP_3__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_3__password")).sendKeys("yan_3013216087");
        //人工输入验证码
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        driver.findElement(By.id("TANGRAM__PSP_3__verifyCode")).clear();
        driver.findElement(By.id("TANGRAM__PSP_3__verifyCode")).sendKeys(s);
        driver.findElement(By.id("TANGRAM__PSP_3__submit")).click();
        //获取cookie信息
        cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
        //后续把cookie 添加进header
        driver.quit(); 
    }
//	public static void main(String[] args)  {
//		
//		login();
//		
//	}
	public static void main(String[] args) {
        System.getProperties().setProperty("webdriver.chrome.driver", "D:/ProgramFiles/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://huaban.com/");
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        webDriver.close();
	}
}