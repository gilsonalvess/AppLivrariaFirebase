package com.dwm.ufg.applivrariafirebase;

import java.util.ArrayList;

public class ConstrutorBaseInicial {

    public static ArrayList<Livro> inicializeBD() {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        livros.add(
                new Livro(
                        "Android Essencial",
                        "Ricardo R. Lecheta",
                        "Navatec",
                        59.90,
                        "img_livro_android_1")
        );
        livros.add(
                new Livro(
                        "Android E. com Kotlin",
                        "Ricardo R. Lecheta",
                        "Navatec",
                        85.90,
                        "img_livro_android_2")
        );
        livros.add(
                new Livro(
                        "Programando com Kotlin",
                        "Stephen Samuel",
                        "Navatec",
                        79.90,
                        "img_livro_android_3")
        );
        livros.add(
                new Livro(
                        "Kotlin com Android",
                        "Kassiano Resende",
                        "Casa do Código",
                        49.99,
                        "img_livro_android_4")
        );
        return livros;
    }
}
