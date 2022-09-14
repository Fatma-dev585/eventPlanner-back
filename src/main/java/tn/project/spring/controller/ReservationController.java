package tn.project.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.project.spring.entity.Reservation;
import tn.project.spring.service.IReservationService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins= "http://localhost:8082/")
public class ReservationController {
	
	@Autowired 
	IReservationService reservationService;
	
	@PostMapping("/add")
	@ResponseBody
	public Reservation addReservation(@RequestBody Reservation reservation)
	{
		reservationService.addReservation(reservation);
		return reservation;
	}
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Reservation getReservationById(@PathVariable("id")int id)
	{
		
		return reservationService.getReservationById(id);
	}
	
	@PostMapping("/addToAvailibility/{availibilityId}")
	@ResponseBody
	public ResponseEntity<Reservation> addReservationToAvailibility(@PathVariable("availibilityId")int availibilityId ,@RequestBody Reservation reservation)
	{
		
		reservationService.addReservationToAvailibility( availibilityId ,reservation);
		if (reservation.getId() == 0)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reservation);
		}
		return ResponseEntity.status(HttpStatus.OK).body(reservation);
	}
	
	@GetMapping(value = "/getAll")
    @ResponseBody
    public List<Reservation> getReservations() {
		
		return reservationService.getReservations();
	}
	
	@DeleteMapping("/deleteById/{idReservation}") 
	@ResponseBody
	public void deleteReservationById(@PathVariable("idReservation")int idReservation) {
		reservationService.deleteReservationById(idReservation);
	}

}
