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

public class TelaSugestaoDieta extends Application {

    private Stage primaryStage;
    private List<String> sugestoes = new ArrayList<>();
    private int index = 0;

    public TelaSugestaoDieta() {
        sugestoes.add("Café da manhã:\nOpção 1: Omelete com vegetais\nOpção 2: Smoothie de banana e aveia\n\nLanche da manhã:\nOpção 1: Mix de frutas secas\nOpção 2: Barrinha de cereal integral\n\nAlmoço:\nOpção 1: Salada de quinoa e frango grelhado\nOpção 2: Wrap de frango e vegetais\n\nLanche da tarde:\nOpção 1: Iogurte com frutas\nOpção 2: Castanhas e frutas\n\nJantar:\nOpção 1: Salmão ao molho de maracujá\nOpção 2: Espaguete integral com molho de tomate e legumes\n\nLanche da noite:\nOpção 1: Chá de camomila\nOpção 2: Leite com mel");
        sugestoes.add("Café da manhã:\nOpção 1: Panquecas de aveia com morangos\nOpção 2: Smoothie de abacate e manga\n\nLanche da manhã:\nOpção 1: Iogurte natural\nOpção 2: Vitamina de frutas com aveia\n\nAlmoço:\nOpção 1: Salada de grão-de-bico e atum\nOpção 2: Filé de frango grelhado com batata-doce\n\nLanche da tarde:\nOpção 1: Banana com pasta de amendoim\nOpção 2: Palitos de cenoura e pepino com homus\n\nJantar:\nOpção 1: Filé de peixe com legumes no vapor\nOpção 2: Sopa de lentilha com vegetais\n\nLanche da noite:\nOpção 1: Maçã cozida\nOpção 2: Chá de erva-cidreira");
        sugestoes.add("Café da manhã:\nOpção 1: Mingau de aveia com frutas vermelhas\nOpção 2: Tapioca recheada com queijo branco\n\nLanche da manhã:\nOpção 1: Frutas da estação\nOpção 2: Barra de cereais\n\nAlmoço:\nOpção 1: Salada de rúcula, tomate e queijo feta\nOpção 2: Quibe assado de abóbora\n\nLanche da tarde:\nOpção 1: Smoothie de abacaxi com hortelã\nOpção 2: Palitos de cenoura com guacamole\n\nJantar:\nOpção 1: Risoto de cogumelos\nOpção 2: Peito de frango recheado com espinafre\n\nLanche da noite:\nOpção 1: Iogurte com granola\nOpção 2: Chá de camomila");
    }

    public TelaSugestaoDieta(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaSugestaoDieta();
    }

    public void exibirTelaSugestaoDieta() {
        Label tituloLabel = new Label("SUGESTÕES DE DIETA");
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
        layout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(tituloLabel, sugestaoLayout, botoesLayout);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sugestões de Dieta");
        primaryStage.show();
    }

    private void salvarSugestao() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sugestão Salva");
        alert.setHeaderText(null);
        alert.setContentText("Sugestão de dieta salva com sucesso!");
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
