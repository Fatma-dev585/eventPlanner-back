package tn.project.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.project.spring.entity.Reservation;;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation,Integer>{

}
