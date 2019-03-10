package com.yan.redisUtils;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

public class ESTaskQueueRedisImpl implements TaskQueue {
	private static Logger logger = Logger.getLogger(ESTaskQueueRedisImpl.class);
	
	private final static int dbIndex = 0;//redis数据库序号
	
	private final static String name = "ESProcessTask";
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void pushTask(String task) {
		Jedis jedis = null;
		try {
			jedis = RedisManager.getResource(dbIndex);
			jedis.lpush(name, task);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			if(jedis!=null){
                RedisManager.returnResource(jedis);
            }
		}
		
	}

	@Override
	public String popTask() {
		Jedis jedis = null;
        String task = null;
        try{
            jedis = RedisManager.getResource(dbIndex);
            task = jedis.rpop(name);
        }catch(Throwable e){
            logger.error(e.getMessage(),e);
        }finally{
            if(jedis!=null){
                RedisManager.returnResource(jedis);
            }
        }
        return task;
	}

}
