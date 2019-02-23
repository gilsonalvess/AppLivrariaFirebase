package com.dwm.ufg.applivrariafirebase;

import java.io.Serializable;

public class Livro implements Serializable {

    String uid;
    String titulo;
    String autor;
    String editora;
    double valor = 0.0;
    String imagem;

    public Livro() {
    }

    public Livro(String titulo, String autor, String editora, double valor, String imagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
