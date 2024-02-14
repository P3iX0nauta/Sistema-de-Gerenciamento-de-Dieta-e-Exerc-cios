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
import javafx.stage.Stage;

import java.text.DecimalFormat;

import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.PesoIgualException;

public class TelaDefinirMeta extends Application {

    private Stage primaryStage;

    public TelaDefinirMeta(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaDefinirMeta();
    }

    public void exibirTelaDefinirMeta() {
        Label tituloLabel = new Label("DEFINIR META");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label pesoAtualLabel = new Label("Digite seu peso atual (em KG):");
        TextField pesoAtualTextField = new TextField();
        pesoAtualTextField.setPromptText("0.00");
        pesoAtualTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.?\\d{0,2}")) {
                pesoAtualTextField.setText(oldValue);
            }
        });

        Label pesoDesejadoLabel = new Label("Digite o peso desejado (em KG):");
        TextField pesoDesejadoTextField = new TextField();
        pesoDesejadoTextField.setPromptText("0.00");
        pesoDesejadoTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.?\\d{0,2}")) {
                pesoDesejadoTextField.setText(oldValue);
            }
        });

        Button salvarButton = new Button("Salvar Meta");
        salvarButton.setOnAction(e -> {
            String pesoAtualStr = pesoAtualTextField.getText();
            String pesoDesejadoStr = pesoDesejadoTextField.getText();

            try {
                double pesoAtual = Double.parseDouble(pesoAtualStr);
                double pesoDesejado = Double.parseDouble(pesoDesejadoStr);

                if (pesoAtual == pesoDesejado) {
                    throw new PesoIgualException("O peso desejado deve ser diferente do peso atual.");
                }

                // Simulação de salvamento da meta
                salvarMeta(pesoAtual, pesoDesejado);

                primaryStage.close();
            } catch (NumberFormatException ex) {
                exibirErro("Por favor, insira valores válidos para os pesos.");
            } catch (PesoIgualException ex) {
                exibirErro(ex.getMessage());
            }
        });

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> {
            retornarTelaAnterior();
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(tituloLabel, pesoAtualLabel, pesoAtualTextField, pesoDesejadoLabel,
                pesoDesejadoTextField, salvarButton, voltarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Definir Meta");
        primaryStage.show();
    }

    private void salvarMeta(double pesoAtual, double pesoDesejado) {
        // lógica para salvar a meta
        DecimalFormat df = new DecimalFormat("#.##");
        String mensagem = "Meta salva com sucesso:\n" +
                "Peso Atual: " + df.format(pesoAtual) + "\n" +
                "Peso Desejado: " + df.format(pesoDesejado);
        exibirAviso(mensagem);
    }

    private void exibirErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void exibirAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Meta Salva");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void retornarTelaAnterior() {
        primaryStage.close();
    }
}