package tn.project.spring.service;

import java.util.List;
import tn.project.spring.entity.Reservation;

public interface IReservationService {

	int addReservation(Reservation reservation);

	List<Reservation> getReservations();

	void deleteReservationById(int idReservation);

	int addReservationToAvailibility(int availibilityId, Reservation reservation);

	Reservation getReservationById(int id);

}
