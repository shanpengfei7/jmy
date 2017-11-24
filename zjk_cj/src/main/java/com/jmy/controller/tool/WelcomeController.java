package com.jmy.controller.tool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@RequestMapping("/admin")
	public String admin() {
		return "admin/login";
	}
	@RequestMapping("/user")
	public String user() {
		return "user/login";
	}
}
