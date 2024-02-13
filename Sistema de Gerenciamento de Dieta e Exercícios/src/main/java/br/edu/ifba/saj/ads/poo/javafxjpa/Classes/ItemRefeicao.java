package br.edu.ifba.saj.ads.poo.javafxjpa.Classes;

public class ItemRefeicao {
    private String nome;
    private int calorias;

    public ItemRefeicao(String nome, int calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public int getCalorias() {
        return calorias;
    }
}
