package example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyPageProcessor implements PageProcessor {
	
	private static List<String> ignoredUrls;
	
	static{
		try {
			File ignoredFile = new File(MyPageProcessor.class.getClassLoader().getResource("ignoredUrls.txt").toURI());
			ignoredUrls = FileUtils.readLines(ignoredFile);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
    		.setRetryTimes(3)
    		.setSleepTime(100);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
    	
        // 部分二：定义如何抽取页面信息，并保存下来
    	
    	//css选择器
        //page.putField("title", page.getHtml().$("title","text").toString());
        //page.putField("h2", page.getHtml().$("h2").toString());
    	
    	//xpath选择器
//    	page.putField("title", page.getHtml().xpath("//title/text()").toString());
//    	page.putField("contentTitle", page.getHtml().xpath("//div[@id=\"read-content\"]/h2/text()").toString());
//    	page.putField("content", page.getHtml().xpath("//body/allText()").toString());
    	
    	//抽取本域名下的所有连接,并使用黑名单对链接进行过滤
//    	List<String> links = page.getHtml().links().all();
    	List<String> links = page.getHtml().links().all()
                .stream()
                .map(s -> {
                    int indexOfSharp = s.indexOf("#");
                    return s.substring(0, indexOfSharp == -1 ? s.length() : indexOfSharp);
                })
                .filter(s -> {
                	//String suffix = s.substring(s.length()-4, s.length());
                	
                    for (String ignoredPostfix : ignoredUrls) {
                        if (s.toLowerCase().endsWith(ignoredPostfix)) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toCollection(LinkedList::new));
    	
    	for(String link : links){
    		System.out.println(link);
    	}
    	
    	// 部分三：从页面发现后续的url地址来抓取
    	//page.addTargetRequests(page.getHtml().links().regex("(http://www\\.lianzais\\.com/\\w*/\\w*)").all());
    	//page.addTargetRequests(links);
    }

    @Override
    public Site getSite() {
//    	site.addHeader("If-Modified-Since", "Wed, 21 Nov 2018 02:55:32 GMT")
//    	.addHeader("If-None-Match", "1542769101|");
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new MyPageProcessor())
        //从"https://github.com/code4craft"开始抓
        //.addUrl("https://baike.baidu.com/item/WebMagic/22066484?fr=aladdin")
        .addUrl("https://pc.qq.com/detail/0/detail_1300.html")
        //.addPipeline(new ConsolePipeline())
        //开启5个线程抓取
        .thread(1)
        //启动爬虫
        .run();
    }
}
