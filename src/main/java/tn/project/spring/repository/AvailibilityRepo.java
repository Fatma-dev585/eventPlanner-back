package tn.project.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.project.spring.entity.Availibility;;

@Repository
public interface AvailibilityRepo extends CrudRepository<Availibility,Integer>{

}
