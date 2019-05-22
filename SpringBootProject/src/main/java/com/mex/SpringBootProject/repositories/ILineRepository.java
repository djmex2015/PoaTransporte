package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.Line;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "line", collectionResourceRel = "line")
public interface ILineRepository extends CrudRepository<Line, String> {

    @RestResource(path = "nome")
    @Query("SELECT p FROM Line p WHERE LOWER(p.nome) LIKE CONCAT('%',LOWER(:nome),'%')")
    List<Line> findByNome(@Param("nome") String nome);

    @RestResource(path = "idlinhas")
    @Query("SELECT p FROM Line p ORDER BY p.id ASC")
    List<Line> findIdlinhas();
}
