package tn.project.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.project.spring.entity.Event;

@Repository
public interface EventRepo extends CrudRepository<Event,Integer>{

}
