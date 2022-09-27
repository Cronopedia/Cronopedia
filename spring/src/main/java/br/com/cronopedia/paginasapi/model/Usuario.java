package br.com.cronopedia.paginasapi.model;

import java.sql.Date;

public class Usuario {
    
    private String nickname;
    private String nome;
    private String senha;
    private String email;
    private Date dataNascimento;

    // ManyToMany com paginas (varios usuários poderão ser donos de varias paginas) -> princípio da colaboração
    
    public Usuario() {
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
