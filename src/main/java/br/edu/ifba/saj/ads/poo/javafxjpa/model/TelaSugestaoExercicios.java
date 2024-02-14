package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelaSugestaoExercicios extends Application {

    private Stage primaryStage;
    private List<String> sugestoes = new ArrayList<>();
    private int index = 0;

    public TelaSugestaoExercicios(List<String> sugestoes) {
        this.sugestoes = sugestoes;
    }

    public TelaSugestaoExercicios(Stage primaryStage) {
        this.primaryStage = primaryStage;
        inicializarSugestoesPadrao();
    }

    private void inicializarSugestoesPadrao() {
        sugestoes.add("Exercício 1:\n- Corrida de 30 minutos\n- 3 séries de flexões\n- 3 séries de agachamentos\n\nExercício 2:\n- Caminhada rápida por 1 hora\n- 4 séries de abdominais\n- 3 séries de lunges");
        sugestoes.add("Exercício 1:\n- Ciclismo por 45 minutos\n- 3 séries de burpees\n- 3 séries de prancha\n\nExercício 2:\n- Pular corda por 20 minutos\n- 4 séries de polichinelos\n- 3 séries de afundos");
        sugestoes.add("Exercício 1:\n- Natação por 1 hora\n- 3 séries de flexões de braço\n- 3 séries de agachamento com peso\n\nExercício 2:\n- Yoga por 40 minutos\n- 4 séries de elevações de perna\n- 3 séries de prancha lateral");
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaSugestaoExercicios();
    }

    public void exibirTelaSugestaoExercicios() {
        Label tituloLabel = new Label("SUGESTÕES DE EXERCÍCIOS");
        tituloLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        tituloLabel.setTextFill(Color.WHITE);

        VBox sugestaoLayout = new VBox(20);
        sugestaoLayout.setPadding(new Insets(20));
        sugestaoLayout.setAlignment(Pos.CENTER);

        Text sugestaoText = new Text(sugestoes.get(index));
        sugestaoText.setFont(Font.font("Arial", 16));
        sugestaoText.setFill(Color.WHITE);
        sugestaoText.setTextAlignment(TextAlignment.CENTER);
        sugestaoLayout.getChildren().add(sugestaoText);

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> retornarTelaAnterior());

        Button salvarSugestaoButton = new Button("Salvar Sugestão");
        salvarSugestaoButton.setOnAction(e -> salvarSugestao());

        Button gerarNovaSugestaoButton = new Button("Gerar Nova Sugestão");
        gerarNovaSugestaoButton.setOnAction(e -> {
            gerarNovaSugestao();
            sugestaoText.setText(sugestoes.get(index));
        });

        HBox botoesLayout = new HBox(10);
        botoesLayout.getChildren().addAll(voltarButton, salvarSugestaoButton, gerarNovaSugestaoButton);
        botoesLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(tituloLabel, sugestaoLayout, botoesLayout);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sugestões de Exercícios");
        primaryStage.show();
    }

    private void salvarSugestao() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sugestão Salva");
        alert.setHeaderText(null);
        alert.setContentText("Sugestão de exercício salva com sucesso!");
        alert.showAndWait();
        primaryStage.close();
    }

    private void gerarNovaSugestao() {
        Random rand = new Random();
        int newIndex = rand.nextInt(sugestoes.size());
        while (newIndex == index) {
            newIndex = rand.nextInt(sugestoes.size());
        }
        index = newIndex;
    }

    private void retornarTelaAnterior() {
        primaryStage.close();
    }
}
