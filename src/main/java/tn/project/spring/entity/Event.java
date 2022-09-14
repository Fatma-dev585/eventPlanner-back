package tn.project.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    
    private String description;
    
    @OneToMany(mappedBy="event")
    @JsonIgnore
	private List<Availibility> availibilities;

	public Event() {
		super();
	}

	

	public Event(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}



	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Availibility> getAvailibilities() {
		return availibilities;
	}



	public void setAvailibilities(List<Availibility> availibilities) {
		this.availibilities = availibilities;
	}



	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    

}
