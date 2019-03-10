package com.yan.redisUtils;

import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Pool;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis连接池管理器
 * @author yan
 */
public class RedisManager {
	private final static Logger logger = Logger.getLogger(RedisManager.class);
	@Autowired
	public static JedisPool pool;
	
	/**
	 * 获取jedis实例
	 * @param dbIndex 数据库序号
	 * @return
	 */
	public static Jedis getResource(int dbIndex){
		Jedis jedis = pool.getResource();
		jedis.select(dbIndex);
		return jedis;
	}
	
	/**
	 * 归还jedis实例
	 * @param jedis
	 */
	public static void returnResource(Jedis jedis){
		if(jedis!=null){
			jedis.close();
		}
	}
}



























