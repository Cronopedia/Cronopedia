package br.com.cronopedia.paginasapi.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Assuntos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String tag;

    @ManyToOne
    @JsonBackReference
    private Pagina paginasAssociadas;

    public Assuntos() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Pagina getPaginasAssociadas() {
        return paginasAssociadas;
    }

    public void setPaginasAssociadas(Pagina paginasAssociadas) {
        this.paginasAssociadas = paginasAssociadas;
    }

    
}
