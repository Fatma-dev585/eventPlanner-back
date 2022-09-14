package tn.project.spring.service;

import java.util.List;
import tn.project.spring.entity.Event;

public interface IEventService {

	int ajouterEvent(Event event);

	List<Event> getEvents();

	void deleteEventById(int idEvent);

	List<Object[]> getAvailableSlots(int idEvent);

	Event getEventById(int id);


}
