package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class TelaAdicionarRefeicao extends Application {

    private Stage primaryStage;

    public TelaAdicionarRefeicao(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaAdicionarRefeicao();
    }

    public void exibirTelaAdicionarRefeicao() {
        Label tituloLabel = new Label("ADICIONAR REFEIÇÃO");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label nomeRefeicaoLabel = new Label("Nome da Refeição:");
        TextField nomeRefeicaoTextField = new TextField();
        nomeRefeicaoTextField.setPromptText("Nome da Refeição");

        Label caloriasLabel = new Label("Calorias:");
        TextField caloriasTextField = new TextField();
        caloriasTextField.setPromptText("0.00");
        caloriasTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.?\\d{0,2}")) {
                caloriasTextField.setText(oldValue);
            }
        });

        Label tipoRefeicaoLabel = new Label("Tipo de Refeição:");
        ComboBox<String> tipoRefeicaoComboBox = new ComboBox<>();
        tipoRefeicaoComboBox.getItems().addAll("Café", "Lanche da Manhã", "Almoço", "Lanche da Tarde", "Janta", "Lanche da Noite");
        tipoRefeicaoComboBox.setPromptText("Selecione o Tipo de Refeição");

        Button salvarButton = new Button("Salvar Refeição");
        salvarButton.setOnAction(e -> {
            String nomeRefeicao = nomeRefeicaoTextField.getText();
            String caloriasStr = caloriasTextField.getText();
            String tipoRefeicao = tipoRefeicaoComboBox.getValue();

            try {
                if (nomeRefeicao.isEmpty() || caloriasStr.isEmpty() || tipoRefeicao == null) {
                    throw new IllegalArgumentException("Por favor, preencha todos os campos.");
                }

                double calorias = Double.parseDouble(caloriasStr);

                // Simulação de salvamento da refeição
                salvarRefeicao(nomeRefeicao, calorias, tipoRefeicao);

                primaryStage.close();
            } catch (NumberFormatException ex) {
                exibirErro("Por favor, insira um valor válido para as calorias.");
            } catch (IllegalArgumentException ex) {
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
        layout.getChildren().addAll(tituloLabel, nomeRefeicaoLabel, nomeRefeicaoTextField, caloriasLabel,
                caloriasTextField, tipoRefeicaoLabel, tipoRefeicaoComboBox, salvarButton, voltarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Adicionar Refeição");
        primaryStage.show();
    }

    private void salvarRefeicao(String nomeRefeicao, double calorias, String tipoRefeicao) {
        // salvar a refeição
        DecimalFormat df = new DecimalFormat("#.##");
        String mensagem = "Refeição adicionada com sucesso:\n" +
                "Nome: " + nomeRefeicao + "\n" +
                "Calorias: " + df.format(calorias) + "\n" +
                "Tipo: " + tipoRefeicao;
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
        alert.setTitle("Refeição Adicionada");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void retornarTelaAnterior() {
        primaryStage.close();
    }
}
