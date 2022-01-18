package com.urlshortner.urlshortDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class URLShortDAOImpl implements URLShortDAO {
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public String saveUrl(String url) {
		// TODO Auto-generated method stub
		
		String result=encrypt(url);
		
		String sql="Insert into url(url,result) values(?,?)";
		
		jdbc.update(sql, url,result);
		
		return result;
	}

	@Override
	public String getCryptedUrl(String url) {
		// TODO Auto-generated method stub
		String sql="select result from url where url = ?";
		return jdbc.queryForObject(sql, new Object[] {url},String.class);
	}

	@Override
	public Boolean check(String url) {
		// TODO Auto-generated method stub
		
		String sql="Select count(*) from url where url=?";
		Integer count = jdbc.queryForObject(sql,new Object[] {url}, Integer.class);
		if(count==0)
			return false;
		return true;
	}

	@Override
	public String encrypt(String url) {
		// TODO Auto-generated method stub
		char ch1=(char)((int)(Math.random()*10)+65);
		char ch2=(char)((int)(Math.random()*10)+65);
		char ch3=(char)((int)(Math.random()*10)+65);
		String a=ch1+"";
		String b=ch2+"";
		String c=ch3+"";
		String res=(int)(Math.random()*10)+a+(int)(Math.random()*10)+b+(int)(Math.random()*10)+c+"a";
		return res;
	}

	@Override
	public String getUrl(String url) {
		// TODO Auto-generated method stub
		String sql= "Select url from url where result=?";
		
		String data=jdbc.queryForObject(sql,new Object[] {url},String.class);
		
		
		return data;
	}

	

}
