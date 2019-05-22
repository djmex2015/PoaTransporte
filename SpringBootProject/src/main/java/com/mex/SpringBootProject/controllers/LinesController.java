package com.mex.SpringBootProject.controllers;

import com.mex.SpringBootProject.repositories.LineRepository;
import com.mex.SpringBootProject.entities.Line;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lineraio")
public class LinesController {

    @Autowired
    private LineRepository linesRepository;

    @RequestMapping("raio")
    public List<Line> getLinesByRaio(@Param("latitud") Double latitud, @Param("longitud") Double longitud, @Param("raio") Double raio) {
        return linesRepository.getLinesByRaio(latitud, longitud, raio);
    }
}
