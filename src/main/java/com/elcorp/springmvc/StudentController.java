package com.elcorp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/form")
	public String renderStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "student-create";
	}
	
	@RequestMapping("/submit")
	public String processStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("title","ElCorp Student Creation");
		model.addAttribute("message", student.getFirstName() + " " + student.getLastName() + " has been created successfully");
		return "student-created";
	}

}
