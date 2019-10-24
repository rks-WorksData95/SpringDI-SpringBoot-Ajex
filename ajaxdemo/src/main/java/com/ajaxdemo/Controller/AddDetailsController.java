package com.ajaxdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ajaxdemo.Repository.cityRepository;
import com.ajaxdemo.Repository.countryRepository;
import com.ajaxdemo.model.city;
import com.ajaxdemo.model.country;

@RestController
public class AddDetailsController {
	@Autowired
	cityRepository cityRepo;

	@Autowired
	countryRepository countryRepo;

	@GetMapping("/home")
	public ModelAndView showHomePage(ModelAndView model) {
		List<country> cdata = countryRepo.findAll();
		model.addObject("countryList", cdata);
		model.setViewName("home");
		return model;
	}

	@PostMapping("/getData/{id}")
	public List<city> saveData(@PathVariable int id) {
		System.out.println(id);
		List<city> list = cityRepo.findAllById(id);
		System.out.println(list.size());
		return list;
	}
}
