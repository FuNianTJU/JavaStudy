package com.yan.redisUtils;

public interface TaskQueue {
	/**
	 * 获取队列名
	 * @return
	 */
	public String getName();
	
	/**
	 * 向队列中添加任务
	 * @param task
	 */
	public void pushTask(String task);
	
	/**
	 * 从队列中取任务
	 * @return
	 */
	public String popTask();

}
