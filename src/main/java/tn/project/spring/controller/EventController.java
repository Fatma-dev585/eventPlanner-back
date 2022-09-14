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

import tn.project.spring.entity.Event;
import tn.project.spring.service.IEventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins= "http://localhost:8082/")
public class EventController {
	
	@Autowired
	IEventService eventService;
	
	@PostMapping("/add")
	@ResponseBody
	public Event ajouterEvent(@RequestBody Event event)
	{
		eventService.ajouterEvent(event);
		return event;
	}
	
	@GetMapping(value = "/getAll")
    @ResponseBody
    public List<Event> getEvents() {
		
		return eventService.getEvents();
	}
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Event getEventById(@PathVariable("id")int id)
	{
		
		return eventService.getEventById(id);
	}
	
	@GetMapping(value = "/availableSlots/{idEvent}")
    @ResponseBody
    public List<Object[]> getAvailableSlots(@PathVariable("idEvent")int idEvent) {
		
		return eventService.getAvailableSlots(idEvent);
	}
	
	@DeleteMapping("/deleteById/{idEvent}") 
	@ResponseBody
	public void deleteEventById(@PathVariable("idEvent")int idEvent) {
		eventService.deleteEventById(idEvent);
	}
	


}
