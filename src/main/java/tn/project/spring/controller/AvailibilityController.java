package tn.project.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.project.spring.entity.Availibility;
import tn.project.spring.service.IAvailibilityService;
import tn.project.spring.service.IEventService;

@RestController
@CrossOrigin(origins= "http://localhost:8082/")
@RequestMapping("/availibility")
public class AvailibilityController {
	
	@Autowired
	IAvailibilityService availibilityService;
	
	@Autowired
	IEventService eventService;
	
	@PostMapping("/add")
	@ResponseBody
	public Availibility addAvailibility(@RequestBody Availibility availibility)
	{
		availibilityService.addAvailibility(availibility);
		return availibility;
	}
	
	@PostMapping("/addToEvent/{eventId}")
	@ResponseBody
	public Availibility addAvailibilityToEvent(@PathVariable("eventId")int eventId ,@RequestBody Availibility availibility)
	{
		availibilityService.addAvailibilityToEvent(availibility,eventId);

		return availibility;
	}
	
	@GetMapping(value = "/getAll")
    @ResponseBody
    public List<Availibility> getAvailibilities() {
		
		return availibilityService.getAvailibilities();
	}
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Availibility getAvailibilityById(@PathVariable("id")int id)
	{
		
		return availibilityService.getAvailibilityById(id);
	}
	
	@DeleteMapping("/deleteById/{idAvailibility}") 
	@ResponseBody
	public void deleteAvailibilityById(@PathVariable("idAvailibility")int idAvailibility) {
		availibilityService.deleteAvailibilityById(idAvailibility);
	}
}
