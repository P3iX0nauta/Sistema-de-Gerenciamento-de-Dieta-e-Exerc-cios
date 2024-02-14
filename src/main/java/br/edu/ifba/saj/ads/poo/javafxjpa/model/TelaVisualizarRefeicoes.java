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

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.saj.ads.poo.javafxjpa.Classes.ItemRefeicao;
import br.edu.ifba.saj.ads.poo.javafxjpa.Classes.Refeicao;

public class TelaVisualizarRefeicoes extends Application {

    private Stage primaryStage;
    private List<Refeicao> refeicoes;
    private List<String> sugestoes;

    public TelaVisualizarRefeicoes(Stage primaryStage, @SuppressWarnings("exports") List<Refeicao> refeicoes, List<String> sugestoes) {
        this.primaryStage = primaryStage;
        this.refeicoes = refeicoes;
        this.sugestoes = sugestoes;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaVisualizarRefeicoes();
    }


    public void exibirTelaVisualizarRefeicoes() {
        refeicoes = new ArrayList<>();
        sugestoes = new ArrayList<>();

        List<ItemRefeicao> cafeDaManhaItens = new ArrayList<>();
        cafeDaManhaItens.add(new ItemRefeicao("Cereal", 200));
        cafeDaManhaItens.add(new ItemRefeicao("Leite", 100));
        refeicoes.add(new Refeicao("Café da Manhã", cafeDaManhaItens));

        List<ItemRefeicao> almocoItens = new ArrayList<>();
        almocoItens.add(new ItemRefeicao("Arroz", 300));
        almocoItens.add(new ItemRefeicao("Feijão", 200));
        almocoItens.add(new ItemRefeicao("Carne", 400));
        refeicoes.add(new Refeicao("Almoço", almocoItens));
        
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        Label tituloLabel = new Label("Refeições Cadastradas");
        tituloLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        layout.getChildren().add(tituloLabel);

        for (Refeicao refeicao : refeicoes) {
            VBox detalhesRefeicao = new VBox(10);
            detalhesRefeicao.setAlignment(Pos.CENTER_LEFT);

            Label tipoLabel = new Label("Tipo: " + refeicao.getTipo());
            tipoLabel.setStyle("-fx-font-weight: bold;");

            Label itensLabel = new Label("Itens:");
            StringBuilder itensStringBuilder = new StringBuilder();
            for (ItemRefeicao item : refeicao.getItens()) {
                itensStringBuilder.append(item.getNome()).append(" (").append(item.getCalorias()).append(" cal)").append("\n");
            }
            Label itensDetalheLabel = new Label(itensStringBuilder.toString());

            detalhesRefeicao.getChildren().addAll(tipoLabel, itensLabel, itensDetalheLabel);
            layout.getChildren().add(detalhesRefeicao);
        }

        if (!sugestoes.isEmpty()) {
            Label sugestoesLabel = new Label("Sugestões Salvas:");
            sugestoesLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            layout.getChildren().add(sugestoesLabel);

            for (String sugestao : sugestoes) {
                Label sugestaoLabel = new Label(sugestao);
                layout.getChildren().add(sugestaoLabel);
            }
        }

        Button fecharButton = new Button("Fechar");
        fecharButton.setOnAction(e -> primaryStage.close());

        layout.getChildren().add(fecharButton);

        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Refeições Cadastradas");
        primaryStage.show();
    }
}
