package tn.project.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Availibility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	private String duration;
	
	//@JsonIgnore
	@OneToOne(mappedBy="availibility", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Reservation reservation;
	
	@ManyToOne
	private Event event; 

	
	
	

	public Availibility() {
		super();
	}

	public Availibility(int id, Date start, Date end, String duration, Reservation reservation, Event event) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.reservation = reservation;
		this.event = event;
	}

	

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}


	public Reservation getReservation() {
		return reservation;
	}

	public Event getEvent() {
		return event;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
	

}
