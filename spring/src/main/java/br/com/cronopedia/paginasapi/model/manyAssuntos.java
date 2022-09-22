package br.com.cronopedia.paginasapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class manyAssuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String tag;

    @ManyToMany(mappedBy = "assuntosMany")
    private List<Pagina> paginas;

    public manyAssuntos() {
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

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

    
}