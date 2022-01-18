package com.urlshortner.api;

public class URLdata {
	
	private int id;
	private String url;
	private String code;
	
	@Override
	public String toString() {
		return "URLdata [id=" + id + ", url=" + url + ", code=" + code + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
