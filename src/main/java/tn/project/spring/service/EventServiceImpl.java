package tn.project.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.project.spring.entity.Availibility;
import tn.project.spring.entity.Event;
import tn.project.spring.repository.AvailibilityRepo;
import tn.project.spring.repository.EventRepo;

@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	EventRepo eventRepo;
	
	@Autowired
	AvailibilityRepo availibilityRepo;

	@Override
	public int ajouterEvent(Event event) {
		// TODO Auto-generated method stub
		eventRepo.save(event);
		return event.getId();
	}

	@Override
	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		return (List<Event>) eventRepo.findAll();
	}

	@Override
	public void deleteEventById(int idEvent) {
		// TODO Auto-generated method stub
		Event event = eventRepo.findById(idEvent).get();
		if( event.getAvailibilities().size() >= 1)
		{	
			for(Availibility av : event.getAvailibilities()){
				availibilityRepo.delete(av);
			}
		}
		
		eventRepo.delete(event);
	}

	@Override
	public List<Object[]> getAvailableSlots(int idEvent) {
		// TODO Auto-generated method stub
		Event event = eventRepo.findById(idEvent).get();
		List<Object[]> myList = new ArrayList<>();
		for(Availibility av : event.getAvailibilities()){
			if(av.getReservation() == null)
			{
				myList.add(new Object[]{av.getId(),event.getTitle(),av.getStart(), av.getEnd(), av.getDuration()});
			}
		}
		return  myList;
	}

	@Override
	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(id).get();
	}
}
