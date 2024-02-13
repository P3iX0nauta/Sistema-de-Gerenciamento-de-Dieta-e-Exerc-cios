package br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions;

public class SenhaNaoCorrespondeException extends Exception {
    public SenhaNaoCorrespondeException() {
        super("A senha digitada nos campos não corresponde.");
    }

    public SenhaNaoCorrespondeException(String mensagem) {
        super(mensagem);
    }
}
