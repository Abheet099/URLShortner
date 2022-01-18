package com.urlshortner.urlshortDAO;

public interface URLShortDAO {

	public String saveUrl(String url);

	public String getCryptedUrl(String url);

	public Boolean check(String url);
	
	public String encrypt(String url);

	public String getUrl(String url);
	

}
