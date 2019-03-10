package com.yan.monitor;

import com.yan.spiderbyredis.MySpiderByRedis;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * 监控待抓取队列，队列为空时重置URL去重检查集合，将种子URL加入待抓取队列
 * @author yan
 *
 */
public class QueueListener {
	
	/*public static void checkAndRestart() {
		Spider spider = MySpiderByRedis.spider;
		RedisScheduler scheduler = (RedisScheduler) spider.getScheduler();
		
		if(scheduler.getLeftRequestsCount(spider)==0){
			scheduler.resetDuplicateCheck(spider);
			spider.addUrl(MySpiderByRedis.seedUrl);
		}
	}*/
}
