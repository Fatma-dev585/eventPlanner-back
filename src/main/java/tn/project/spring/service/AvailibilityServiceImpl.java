package tn.project.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.project.spring.entity.Availibility;
import tn.project.spring.entity.Event;
import tn.project.spring.repository.AvailibilityRepo;
import tn.project.spring.repository.EventRepo;

@Service
public class AvailibilityServiceImpl implements IAvailibilityService{
	
	@Autowired 
	AvailibilityRepo availibilityRepo;
	
	@Autowired
	EventRepo eventRepo;

	@Override
	public int addAvailibility(Availibility availibility) {
		// TODO Auto-generated method stub
		//Determine dduration
		String ch = findDifference(availibility.getStart(), availibility.getEnd());
		availibility.setDuration(ch);
		
		availibilityRepo.save(availibility);
		return availibility.getId();
	}
	
	@Override
	public void addAvailibilityToEvent(Availibility availibility, int eventId) {
		// TODO Auto-generated method stub
		Event event = eventRepo.findById(eventId).get();
		availibility.setEvent(event);
		
		String ch = findDifference(availibility.getStart(), availibility.getEnd());
		availibility.setDuration(ch);
		
		availibilityRepo.save(availibility);
	}

	@Override
	public List<Availibility> getAvailibilities() {
		// TODO Auto-generated method stub
		return (List<Availibility>) availibilityRepo.findAll();
	}

	@Override
	public void deleteAvailibilityById(int idAvailibility) {
		// TODO Auto-generated method stub
		Availibility availibility = availibilityRepo.findById(idAvailibility).get();
		availibility.setEvent(null);
		availibilityRepo.delete(availibility);
	}

	 public String findDifference(Date start_date, Date end_date)
	    {
		 String ch = null;
		 // Try Block
	        try {
	  
	            long difference_In_Time
	                = end_date.getTime() - start_date.getTime();
	  
	            // Calucalte time difference in
	            // seconds, minutes, hours, years,
	            // and days
	            long difference_In_Seconds
	                = (difference_In_Time
	                   / 1000)
	                  % 60;
	  
	            long difference_In_Minutes
	                = (difference_In_Time
	                   / (1000 * 60))
	                  % 60;
	  
	            long difference_In_Hours
	                = (difference_In_Time
	                   / (1000 * 60 * 60))
	                  % 24;
	  
	            long difference_In_Days
	                = (difference_In_Time
	                   / (1000 * 60 * 60 * 24))
	                  % 365;
	  
	            // Print the date difference in
	            // years, in days, in hours, in
	            // minutes, and in seconds
	  
	            ch = difference_In_Days
	                + " days, "
	                + difference_In_Hours
	                + " hours, "
	                + difference_In_Minutes
	                + " minutes, "
	                + difference_In_Seconds
	                + " seconds";
	        }
	  
	        // Catch the Exception
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ch;
	    }

	@Override
	public Availibility getAvailibilityById(int id) {
		// TODO Auto-generated method stub
		return availibilityRepo.findById(id).get();
	}

}
