package com.yan.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class JedisPoolTest {
	@Autowired
	JedisPool pool;
	
	@Test
	public void test() {
		Jedis jedis = pool.getResource();
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping()+"\n");
        
        System.out.println("======================\n");
        
        //设置字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        //获取存储的字符串
        System.out.println("redis存储的字符串为："+jedis.get("runoobkey")+"\n");
	}

}
