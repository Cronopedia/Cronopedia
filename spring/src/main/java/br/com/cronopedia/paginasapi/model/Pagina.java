package br.com.cronopedia.paginasapi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagina {
    private static Long idCounter = (long) 0;
    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String autor;
    private Date date = new Date();
    private String data;
    private String resumo;
    private String conteudo;
    private ArrayList<String> assuntos;
    private ArrayList<String> imagensURL;
    private Long relevancia = (long) 0;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public static Long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(Long idCounter) {
        Pagina.idCounter = idCounter;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAssuntos(ArrayList<String> assuntos) {
        this.assuntos = assuntos;
    }

    public ArrayList<String> getImagensURL() {
        return imagensURL;
    }

    public void setImagensURL(ArrayList<String> imagensURL) {
        this.imagensURL = imagensURL;
    }

    public Long getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(Long relevancia) {
        this.relevancia = relevancia;
    }

    // Termos identicos (Deprecated)
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

    public static Pagina voidPage() {
        Pagina voidPage = new Pagina("Página inexistente", "Cronopédia", "",
                "Não foi possivel encontrar a página solicitada.", "", "");

        return voidPage;
    }
}
