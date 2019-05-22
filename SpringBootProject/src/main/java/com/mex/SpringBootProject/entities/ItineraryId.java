package com.mex.SpringBootProject.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marcos
 */
@Embeddable
public class ItineraryId implements Serializable {

    @Column(length = 50)
    private String idLine;
    @Column(length = 50)
    private String posIndex;

    public ItineraryId() {
    }

    public ItineraryId(String idlinha, String posIndex) {
        this.idLine = idlinha;
        this.posIndex = posIndex;
    }

    public String getIdLine() {
        return idLine;
    }

    public void setIdLine(String idLine) {
        this.idLine = idLine;
    }

    public String getPosIndex() {
        return posIndex;
    }

    public void setPosIndex(String posIndex) {
        this.posIndex = posIndex;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItineraryId other = (ItineraryId) obj;
        if (!Objects.equals(this.idLine, other.idLine)) {
            return false;
        }
        if (!Objects.equals(this.posIndex, other.posIndex)) {
            return false;
        }
        return true;
    }
}
