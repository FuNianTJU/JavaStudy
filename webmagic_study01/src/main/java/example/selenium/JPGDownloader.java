package example.selenium;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.yan.selenium.SeleniumDownloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

public class JPGDownloader implements PageProcessor {
	public static InputStream inStream = null;
	Site site = Site.me()
			.setRetryTimes(3)
			.setSleepTime(3000)
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
	
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}
 
	public void process(Page page) {
		
		String pageRegex = "https://support.microsoft.com/zh-cn/help/\\S+";
		//将其他图片页的链接加入待爬取队列
		page.addTargetRequests(page.getHtml().links().regex(pageRegex).all());
		
		String pictureRegex = "https://kbdevstorage1.blob.core.windows.net/asset-blobs/\\S+";
		//将匹配到的图片链接都存储到links集合中
		List<String> links = page.getHtml().links().regex(pictureRegex).all();
		//遍历links集合中的链接，然后下载
		for(int i = 0; i < links.size(); i++){
			String link = links.get(i);
			String[] str = link.split("/");
			String name = str[str.length-1];
			try {
				URL url = new URL(link);
				URLConnection con = url.openConnection();
				inStream = con.getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buf = new byte[10240];
				int len = 0;
				while((len = inStream.read(buf)) != -1){
					outStream.write(buf,0,len);
				}
				File file = new File("D://webmagic//img//"+name+".jpg");	//图片下载地址
				FileOutputStream op = new FileOutputStream(file);
				
				op.write(outStream.toByteArray());
				op.close();
				inStream.close();
				outStream.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args){
		String URL = "https://support.microsoft.com/zh-cn/help/17780";
		//系统配置文件
		//System.setProperty("selenuim_config", "D:\\jse-workspace\\WebMagicTest\\NovelSpider\\TuPian\\First\\config.ini");	
		Spider.create(new JPGDownloader())
		.addUrl(URL)	//要爬取的总链接
		.setDownloader(new SeleniumDownloader())//模拟启动浏览器
		.setScheduler(new FileCacheQueueScheduler("D:\\webmagic\\"))
		.thread(1)	//线程
		.run();
	}

}














