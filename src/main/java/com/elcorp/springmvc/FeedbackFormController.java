package com.elcorp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feedback")
public class FeedbackFormController {

	@RequestMapping("/form")
	public String renderRequest() {
		return "feedback-request";
	}
	
//	// HttpServletRequest
//	@RequestMapping("/submitted")
//	public String renderResponse(HttpServletRequest request, Model model) {
//		String name = request.getParameter("studentName");
//		model.addAttribute("title","Yo " + name.toUpperCase() + "!");
//		model.addAttribute("message","Your feedback has been submitted successfully.");
//		return "feedback-response";
//	}
	
	// @RequestParam
	@RequestMapping("/submitted")
	public String renderResponse(@RequestParam("studentName") String name, Model model) {
		model.addAttribute("title","Yo " + name.toUpperCase() + "!");
		model.addAttribute("message","Your feedback has been submitted successfully.");
		return "feedback-response";
	}
	
}
