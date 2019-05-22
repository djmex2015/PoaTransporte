package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.Line;
import java.util.List;

/**
 *
 * @author marcos
 */
public interface LineRepositoryCustom {
     List<Line> getLinesByRaio(Double latitud, Double longitud, Double raio);
}
