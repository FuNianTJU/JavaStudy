package com.yan.dao;

/**
 * 存储到数据库中的网页信息结构
 * @author yan
 *
 */
public class UrlDomain {
	private String url;
	private String urlId; //url MD5码
	private String fileSum; //文件摘要 MD5码
	private Integer version;
	
	public String getUrlId() {
		return urlId;
	}
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileSum() {
		return fileSum;
	}
	public void setFileSum(String fileSum) {
		this.fileSum = fileSum;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "UrlDomain [url=" + url + ", urlId=" + urlId + ", fileSum=" + fileSum + ", version=" + version + "]";
	}
	
}
