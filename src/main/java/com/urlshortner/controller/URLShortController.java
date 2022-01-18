package com.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.urlshortner.api.URLdata;
import com.urlshortner.urlshortDAO.URLShortDAO;
import com.urlshortner.urlshortDAO.URLShortDAOImpl;

@Controller
public class URLShortController {
	
	@Autowired
	private URLShortDAO DAOImpl;

	@GetMapping("/")
	public String home(Model model) {
		URLdata data=new URLdata();
		model.addAttribute("data",data);
		//System.out.println(123);
		return "home";

	}

	@PostMapping("/save-url")
	public String saveUrl(URLdata data,Model model) {
		
		String url=data.getUrl();
		String crypt="";
		if(DAOImpl.check(url))
		{
			crypt=DAOImpl.getCryptedUrl(url);
			
		}
		else
		{
			crypt=DAOImpl.saveUrl(url);
			
		}
		//System.out.println(crypt);
		//System.out.println("hashing will be done");
		crypt="localhost:8080/URLShortner/"+crypt.trim();
		model.addAttribute("data",crypt.trim());
		return "result";
		
	}
	@GetMapping("/{data}")
	public String redirect(@PathVariable String data)
	{
		//System.out.println(data);
		String url=DAOImpl.getUrl(data);
		System.out.println(url);
		
		return "redirect:http://"+url;
		
	}

}
