package com.cts.microsoft.cognitive.search.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
}
