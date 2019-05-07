package com.yan.spiderbyredis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yan.mypipeline.DBPipeline;

import redis.clients.jedis.JedisPool;

//import com.yan.mypipeline.DBPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * 分布式爬虫原型，使用Redis调度器管理URL
 * 实现采集网页元数据写入mysql,采集文件保存到本地
 * @author yan
 * 使用redis作为URL队列
 */
public class MySpiderByRedis implements PageProcessor {
	
	public static String seedUrl = "http://www.lianzais.com/";
	
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
    	
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("file", page.getHtml());
        
    	// 部分三：从页面发现后续的url地址来抓取
    	page.addTargetRequests(page.getHtml().links().regex("(http://www\\.lianzais\\.com/\\w*/\\w*)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
//    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
//    	JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");
    	
        Spider.create(new MySpiderByRedis())
        .setScheduler(new RedisScheduler("localhost"))//使用redis调度器
        .setUUID("testSpider") //设置任务uuid,使不同的spider抓取同一个队列
        .addPipeline(new FilePipeline("D:\\webmagic\\"))
        .addPipeline(new DBPipeline())
        //开启5个线程抓取
        .thread(1)
        .addUrl("http://www.lianzais.com/")
        //启动爬虫
        .run();
    }
}
