package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.Line;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 *
 * @author marcos
 */
@Component
public interface LineRepository extends Repository<Line, String>, LineRepositoryCustom {

    @Override
    public List<Line> getLinesByRaio(@Param("latitud") Double latitud, @Param("longitud") Double longitud, @Param("raio") Double raio);
}
