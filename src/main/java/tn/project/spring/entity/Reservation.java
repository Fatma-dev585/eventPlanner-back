package tn.project.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	private String duration;
	
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "availibility_id", referencedColumnName = "id")
	private Availibility availibility;

	public Reservation() {
		super();
	}

	public Reservation(int id, Date start, Date end, String duration, String email, Availibility availibility) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.email = email;
		this.availibility = availibility;
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

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Availibility getAvailibility() {
		return availibility;
	}

	public void setAvailibility(Availibility availibility) {
		this.availibility = availibility;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", duration=" + duration + ", email=" + email + ", getId()=" + getId()
				+ ", getDuration()=" + getDuration() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
