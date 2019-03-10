package com.yan.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UrlDAO {
	/**
	 * 新增一条URL信息
	 * @author yan
	 */
	public int insert(UrlDomain urlDomain);
	
	/**
	 * 根据主键更新
	 * @param urlDomain
	 * @return
	 */
	public int updateByKey(UrlDomain urlDomain);
	
	/**
	 * 根据主键查询一条URL信息
	 * @param urlDomain
	 * @return
	 */
	public UrlDomain loadByKey(UrlDomain urlDomain);
}
