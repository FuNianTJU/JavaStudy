package com.yan.dao;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yan.mypipeline.DBPipeline;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UrlDAOTest {
	@Autowired
	private UrlDAO urlDAO;
	
	@Test
	public void testInsert() {
		try {
			UrlDomain query = new UrlDomain();
			System.out.println(query);
			query.setUrlId("001");
			query.setFileSum("baidu2");
			query.setUrl("www.baidu.com");
			query.setVersion(0);
			//urlDAO.insert(query);
			DBPipeline.put(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadByKey() {
		UrlDomain query = new UrlDomain();
		query.setUrlId("002");
		query.setFileSum("baidu");
		query.setUrl("www.baidu.com");
		query.setVersion(0);
		
		UrlDomain urlDomain2 = urlDAO.loadByKey(query);
		System.out.println(urlDomain2);
		System.err.println(null!=urlDomain2);
	}

}
