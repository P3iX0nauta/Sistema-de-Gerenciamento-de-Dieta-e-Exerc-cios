package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaGerenciarExercicios extends Application {

    private Stage primaryStage;

    public TelaGerenciarExercicios(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaGerenciarExercicios();
    }

    public void exibirTelaGerenciarExercicios() {
        Label tituloLabel = new Label("GERENCIAR EXERCÍCIOS");
        tituloLabel.setFont(new Font("Arial", 24));

        VBox tabelaExercicios = new VBox(10);
        tabelaExercicios.setPadding(new Insets(20));
        tabelaExercicios.setAlignment(Pos.CENTER_LEFT);
        
        for (String dia : new String[]{"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"}) {
            Label labelDia = new Label(dia);
            TextField textFieldExercicio = new TextField();
            textFieldExercicio.setPromptText("Adicione aqui um exercício para este dia");
            tabelaExercicios.getChildren().addAll(labelDia, textFieldExercicio);
        }

        Button salvarButton = new Button("Salvar");
        salvarButton.setOnAction(e -> {
            salvarExercicios();
            retornarTelaAnterior();
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(tituloLabel, tabelaExercicios, salvarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gerenciar Exercícios");
        primaryStage.show();
    }

    private void salvarExercicios() {
        // salvar os exercícios
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exercícios Salvos");
        alert.setHeaderText(null);
        alert.setContentText("Exercícios salvos com sucesso!");
        alert.showAndWait();
    }

    private void retornarTelaAnterior() {
        primaryStage.close();
    }
}
