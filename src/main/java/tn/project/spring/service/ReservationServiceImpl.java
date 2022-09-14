package tn.project.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.project.spring.entity.Availibility;
import tn.project.spring.entity.Reservation;
import tn.project.spring.repository.AvailibilityRepo;
import tn.project.spring.repository.ReservationRepo;

@Service
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	ReservationRepo reservationRepo;
	
	@Autowired
	AvailibilityRepo availibilityRepo;

	@Override
	public int addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		String ch = findDifference(reservation.getStart(), reservation.getEnd());
		reservation.setDuration(ch);
		
		reservationRepo.save(reservation);
		return reservation.getId();
	}

	@Override
	public List<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return (List<Reservation>) reservationRepo.findAll();
	}

	@Override
	@Transactional
	public void deleteReservationById(int idReservation) {
		// TODO Auto-generated method stub
		Reservation reservation = reservationRepo.findById(idReservation).get();
		Availibility av = reservation.getAvailibility();
		av.setReservation(null);
		
		reservation.setAvailibility(null);
		
		reservationRepo.save(reservation);
	
		reservationRepo.delete(reservation);
		
	}

	@Override
	public int addReservationToAvailibility(int availibilityId, Reservation reservation) {
		// TODO Auto-generated method stub
		
		// determine duration
		String ch = findDifference(reservation.getStart(), reservation.getEnd());
		reservation.setDuration(ch);
		
		// assign reservation to availibility
		Availibility av = availibilityRepo.findById(availibilityId).get();
		if( av.getReservation() == null)
		{
			reservation.setAvailibility(av);			
			reservationRepo.save(reservation);
		}
		return reservation.getId();
	}

	@Override
	public Reservation getReservationById(int id) {
		// TODO Auto-generated method stub
		return reservationRepo.findById(id).get();
	}
	
	public String findDifference(Date start_date, Date end_date)
    {
	 String ch = null;
	 // Try Block
        try {
            // Calucalte time difference
            // in milliseconds
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
}
