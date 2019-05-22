package com.mex.SpringBootProject.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Itinerary implements Serializable {

    @EmbeddedId
    private ItineraryId itineraryId;

    @Column
    private Double latitud;
    @Column
    private Double longitud;

    public Itinerary() {
    }

    public Itinerary(ItineraryId id, Double lat, Double lng) {
        this.itineraryId = id;
        this.latitud = lat;
        this.longitud = lng;
    }

    public ItineraryId getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(ItineraryId id) {
        this.itineraryId = id;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
