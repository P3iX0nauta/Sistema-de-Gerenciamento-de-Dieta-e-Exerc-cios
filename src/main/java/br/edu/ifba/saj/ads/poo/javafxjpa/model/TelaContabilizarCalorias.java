package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaContabilizarCalorias extends Application {

    private Stage primaryStage;

    public TelaContabilizarCalorias(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaContabilizarCalorias();
    }

    public void exibirTelaContabilizarCalorias() {
        Label tituloLabel = new Label("CONTABILIZAR CALORIAS");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Calcular as calorias de todos os alimentos registrados
        Label resultadoLabel = new Label("Total de calorias: X cal");
        Label mediaLabel = new Label("A média de calorias de uma pessoa saudável: 2.000 a 2.400 cal");

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> {
            retornarTelaAnterior();
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(tituloLabel,resultadoLabel,mediaLabel, voltarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Contabilizar Calorias");
        primaryStage.show();
    }

    private void retornarTelaAnterior() {
        TelaGerenciarDieta telaGerenciarDieta = new TelaGerenciarDieta(primaryStage);
        telaGerenciarDieta.start(primaryStage);
    }
}