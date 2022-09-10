package br.com.cronopedia.paginasapi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pagina {
    private static int idCounter = 0;
    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    private int id;
    private String titulo;
    private String autor;
    private Date date = new Date();
    private String data;
    private String resumo;
    private String conteudo;
    private ArrayList<String> assuntos;
    private ArrayList<String> imagensURL;

    public Pagina() {
        this.id = ++Pagina.idCounter;
        this.data = formatter.format(date);
    }

    public Pagina(String titulo, String autor, String resumo, String conteudo, String assuntos, String url) {

        this.id = ++Pagina.idCounter;
        this.data = formatter.format(date);
        this.titulo = titulo;
        this.autor = autor;
        this.resumo = resumo;
        this.conteudo = conteudo;
        this.assuntos = new ArrayList<>();
        this.assuntos.add(titulo);
        this.assuntos.add(assuntos);
        this.imagensURL = new ArrayList<>();
        this.imagensURL.add(url);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addAssunto(String termo) {
        this.assuntos.add(termo);
    }

    public void removeAssunto(String termoToRemove) {
        this.assuntos.remove(termoToRemove);
    }

    public ArrayList<String> getAssuntos() {
        return assuntos;
    }

    public void addImagem(String url) {
        this.imagensURL.add(url);
    }

    public void removeImagem(String urlToRemove) {
        this.imagensURL.remove(urlToRemove);
    }

    public ArrayList<String> getImagens() {
        return imagensURL;
    }

    // Termos identicos
    public Boolean relecionada(String assunto) {
        if (this.getAssuntos().contains(assunto)) {
            return true;
        }

        return false;
    }

    // Regex
    public Boolean relacionadaRX(String assunto) {
        // Criando um regex de busca
        Pattern pattern = Pattern.compile(assunto, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < this.assuntos.size(); i++) {
            Matcher matcher = pattern.matcher(this.assuntos.get(i));

            // percorrendo os matches
            while (matcher.find()) {
                // return
                return true;
            }
        }

        return false;
    }
}
