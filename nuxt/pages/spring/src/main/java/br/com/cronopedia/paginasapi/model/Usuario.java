package br.com.cronopedia.paginasapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String nickname;
    private String nome;
    private String senha;
    private String email;
    private Date dataNascimento;

    // ManyToMany com paginas (varios usuários poderão ser donos de varias paginas)
    // -> princípio da colaboração
    @ManyToOne
    @JsonBackReference
    private Pagina paginasAssociadas;

    public Usuario() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public Pagina getPaginasAssociadas() {
        return paginasAssociadas;
    }

    public void setPaginasAssociadas(Pagina paginasAssociadas) {
        this.paginasAssociadas = paginasAssociadas;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
