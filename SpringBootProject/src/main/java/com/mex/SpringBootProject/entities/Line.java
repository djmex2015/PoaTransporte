package com.mex.SpringBootProject.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Line implements Serializable {

    @Id
    @Column(length = 50)
    private String id;
    @Column
    private String nome;
    @Column
    private String codigo;

    public Line() {
    }

    public Line(String nome) {
        this.nome = nome;
    }

    public Line(String id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
