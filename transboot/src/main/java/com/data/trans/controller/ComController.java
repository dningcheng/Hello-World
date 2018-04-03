package com.data.trans.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.data.trans.model.Translog;
import com.data.trans.service.TranslogService;

@Controller
public class ComController {
	
	@Autowired
	TranslogService translogService;
	
	@RequestMapping("/login")
	public String login(Map<String,Object> map){
		
		List<Translog> logs = translogService.getTranslogList(null);
		
		map.put("logs", logs);
		
		return "/index";
	}
	
}