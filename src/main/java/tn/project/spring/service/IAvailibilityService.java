package tn.project.spring.service;

import java.util.List;
import tn.project.spring.entity.Availibility;

public interface IAvailibilityService {

	int addAvailibility(Availibility availibility);

	List<Availibility> getAvailibilities();

	void deleteAvailibilityById(int idAvailibility);

	void addAvailibilityToEvent(Availibility availibility, int eventId);

	Availibility getAvailibilityById(int id);


}
