package example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *  PhantomJs是一个基于webkit内核的无头浏览器，即没有UI界面，即它就是一个浏览器，只是其内的点击、翻页等人为相关操作需要程序设计实现;
 * 因为爬虫如果每次爬取都调用一次谷歌浏览器来实现操作,在性能上会有一定影响,而且连续开启十几个浏览器简直是内存噩梦,
 * 因此选用phantomJs来替换chromeDriver
 * PhantomJs在本地开发时候还好，如果要部署到服务器，就必须下载linux版本的PhantomJs,相比window操作繁琐
 * @author yan
 *
 */
public class TestPhantomJsDriver {
	
	/**
	 * 创建浏览器驱动实例
	 * @return
	 */
	public static PhantomJSDriver getPlantJSDriver(){
		//设置浏览器配置
		DesiredCapabilities dcaps = new DesiredCapabilities();
		//ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		//截屏支持
        dcaps.setCapability("takesScreenshot", false);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //设置浏览器路径
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
        		, "D:/ProgramFiles/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        
        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
        return driver;
	}
	
	public static void main(String[] args){
		WebDriver driver = null;
		try {
			driver = getPlantJSDriver();
			driver.get("https://www.baidu.com/");
			System.out.println(driver.getTitle());
		} finally {
			if(driver!=null)
				driver.quit();
		}
	}
}


































