package com.yan.mypipeline;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yan.dao.UrlDAO;
import com.yan.dao.UrlDomain;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class DBPipeline implements Pipeline {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
	//@Autowired
	private static UrlDAO urlDao=(UrlDAO) context.getBean("urlDAO");

	@Override
	public void process(ResultItems resultItems, Task task) {
		
		String url = resultItems.getRequest().getUrl();
		Map<String, Object> result = resultItems.getAll();
		String fileSum = DigestUtils.md5Hex(result.get("file").toString());
		
		UrlDomain urlDomain = new UrlDomain();
		urlDomain.setFileSum(fileSum);
		urlDomain.setUrl(url);
		urlDomain.setUrlId(DigestUtils.md5Hex(url));
		urlDomain.setVersion(0);
		
		put(urlDomain);
	}
	
	public static void put(UrlDomain urlDomain){
		UrlDomain urlDomain2 = null;
		try {
			//System.err.println(urlDao);
			urlDomain2 = urlDao.loadByKey(urlDomain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(urlDomain2==null){
			urlDao.insert(urlDomain);
		}else{
			if(!urlDomain.getFileSum().equals(urlDomain2.getFileSum())){
				urlDomain.setVersion(urlDomain2.getVersion()+1);
				urlDao.updateByKey(urlDomain);
			}
		}
	}
}
