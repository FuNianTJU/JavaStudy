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

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class WindowsTheme implements PageProcessor {
	public static InputStream inStream = null;
	Site site = Site.me()
			.setRetryTimes(3)
			.setSleepTime(1000)
			.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");;
	
	@Override
	public void process(us.codecraft.webmagic.Page page) {
		page.addTargetRequests(page.getHtml().links().regex("https://support\\.microsoft\\.com/zh-cn/help/[0-9]{5}").all());
		
		List<String> links = page.getHtml().links().regex("https://kbdevstorage1\\.blob\\.core\\.windows\\.net/asset-blobs/[a-z0-9_]+").all();
		long start = System.currentTimeMillis();
		//遍历links集合中的链接，然后下载
		for(int i = 0; i < links.size(); i++){
			String link = links.get(i);
			try {
				URL url = new URL(link);
				URLConnection con = url.openConnection();
				inStream = con.getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int len = 0;
				while((len = inStream.read(buf)) != -1){
					outStream.write(buf,0,len);
				}
				inStream.close();
				outStream.close();
				File file = new File("D://webmagic//windows//"+link.hashCode()+".jpg");	//图片下载地址
				FileOutputStream op = new FileOutputStream(file);
				op.write(outStream.toByteArray());
				op.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("下载本网页图片所用时间为："+(System.currentTimeMillis()-start));
		
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}
	
	public static void main(String[] args){
		Spider.create(new WindowsTheme())
		.addUrl("https://support.microsoft.com/zh-cn/help/17780")	//要爬取的总链接
		.setDownloader(new SeleniumDownloader())//模拟启动浏览器
		.thread(1)	//线程
		.run();
	}

}
