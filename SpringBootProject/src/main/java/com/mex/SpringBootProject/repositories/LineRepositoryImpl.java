
package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.Line;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public class LineRepositoryImpl implements LineRepositoryCustom {

    @Inject
    private EntityManager em;
  
    @Override
    public List<Line> getLinesByRaio(@Param("latitud") Double latitud, @Param("longitud") Double longitud, @Param("raio") Double raio) {
        System.out.println("LATITUD: "+latitud+"LONGITUD: "+longitud+"RAIO: "+raio);
        String queryItin = "SELECT p.itineraryId.idLine FROM Itinerary p where ";

        if ((Objects.nonNull(latitud) || Objects.nonNull(longitud)) && Objects.nonNull(raio)) {
            if (Objects.nonNull(latitud)) {
                queryItin += "p.latitud between " + (latitud - raio) + " and " + (latitud + raio);
            }

            if (Objects.nonNull(longitud)) {
                if (Objects.nonNull(latitud)) {
                    queryItin += " and ";
                }
                queryItin += "p.longitud between " + (longitud - raio) + " and " + (longitud + raio);
            }
        } else if ((Objects.nonNull(latitud) || Objects.nonNull(longitud)) && Objects.isNull(raio)) {
            if (Objects.nonNull(latitud)) {
                queryItin += "p.latitud = " + latitud;
            }
            if (Objects.nonNull(longitud)) {
                if (Objects.nonNull(latitud)) {
                    queryItin += " and ";
                }
                queryItin += "p.longitud = " + longitud;
            }
        } else {
            return null;
        }
        String query = "SELECT l from Line l where l.id in (" + queryItin + ")";
        return em.createQuery(query).getResultList();
    }
}
