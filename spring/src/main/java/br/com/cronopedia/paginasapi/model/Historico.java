package br.com.cronopedia.paginasapi.model;

import java.sql.Date;

public class Historico {
    
    private Date datAlteracao;
    private String editorNickname;
    private String descricao;
    
    // Dúvida:
    // ManyToOne com usuário responsavel pela edição 
    // n : 1

    public Historico() {
    }

    public Date getDatAlteracao() {
        return datAlteracao;
    }
    public void setDatAlteracao(Date datAlteracao) {
        this.datAlteracao = datAlteracao;
    }


    public String getEditorNickname() {
        return editorNickname;
    }
    public void setEditorNickname(String editorNickname) {
        this.editorNickname = editorNickname;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
