package br.com.cronopedia.paginasapi.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Assuntos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String tag;

    @ManyToMany(mappedBy = "assuntos")
    private List<Pagina> paginasAssociadas;

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

    public List<Pagina> getPaginasAssociadas() {
        return paginasAssociadas;
    }

    public void setPaginasAssociadas(List<Pagina> paginasAssociadas) {
        this.paginasAssociadas = paginasAssociadas;
    }

    
}
