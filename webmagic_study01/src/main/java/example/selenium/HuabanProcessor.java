package example.selenium;

import com.yan.selenium.SeleniumDownloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * 花瓣网抽取器。<br>
 * 使用Selenium做页面动态渲染。<br>
 * @author code4crafter@gmail.com <br>
 * Date: 13-7-26 <br>
 * Time: 下午4:08 <br>
 */
public class HuabanProcessor implements PageProcessor {

    private Site site;

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://huaban\\.com/.*").all());
        if (page.getUrl().toString().contains("pins")) {
            page.putField("img", page.getHtml().xpath("//div[@class='image-holder']/a/img/@src").toString());
        } else {
            page.getResultItems().setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        if (null == site) {
            site = Site.me().setDomain("huaban.com").setSleepTime(0);
        }
        return site;
    }

    public static void main(String[] args) {
    	//selenium系统配置，其中的路径写自己config文件的路径,在config文件中配置浏览器驱动信息
//    	System.setProperty("selenuim_config",
//    			"D:\\jse-workspace\\WebMagicTest\\Study\\src\\main\\java\\Four\\config.ini");
        Spider.create(new HuabanProcessor()).thread(5)
                .addPipeline(new FilePipeline("D:\\webmagic"))
                .setDownloader(new SeleniumDownloader())
                .addUrl("http://huaban.com/")
                .runAsync();
    }
}
