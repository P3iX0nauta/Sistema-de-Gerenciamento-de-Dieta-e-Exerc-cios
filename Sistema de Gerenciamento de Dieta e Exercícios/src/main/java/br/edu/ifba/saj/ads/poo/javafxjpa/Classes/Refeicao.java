package br.edu.ifba.saj.ads.poo.javafxjpa.Classes;

import java.util.List;

public class Refeicao {
    private String tipo;
    private List<ItemRefeicao> itens;

    public Refeicao(String tipo, List<ItemRefeicao> itens) {
        this.tipo = tipo;
        this.itens = itens;
    }

    public String getTipo() {
        return tipo;
    }

    public List<ItemRefeicao> getItens() {
        return itens;
    }
}
