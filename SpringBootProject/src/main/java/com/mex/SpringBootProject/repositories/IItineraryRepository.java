package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.Itinerary;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "itinerary", collectionResourceRel = "itinerary")
public interface IItineraryRepository extends CrudRepository<Itinerary, String> {

    @RestResource(path = "linha", rel = "linha")
    @Query("SELECT p FROM Itinerary p WHERE p.itineraryId.idLine = :linha")
    List<Itinerary> findByIdlinha(@Param("linha") String linha);
}
