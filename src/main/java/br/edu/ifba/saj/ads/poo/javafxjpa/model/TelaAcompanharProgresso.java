package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TelaAcompanharProgresso extends Application {

    private Stage primaryStage;
    private ProgressBar[] progressBars;
    private String[] categorias = {"Categoria 1", "Categoria 2", "Categoria 3", "Categoria 4", "Categoria 5"};

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaAcompanhamentoProgresso();
    }

    public void exibirTelaAcompanhamentoProgresso() {
        Label tituloLabel = new Label("ACOMPANHAMENTO DE PROGRESSO");
        tituloLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        tituloLabel.setTextFill(Color.WHITE);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox tituloLayout = new HBox();
        tituloLayout.getChildren().add(tituloLabel);
        tituloLayout.setAlignment(Pos.CENTER);

        layout.getChildren().add(tituloLayout);

        progressBars = new ProgressBar[categorias.length];

        for (int i = 0; i < categorias.length; i++) {
            final int index = i;
            Label categoriaLabel = new Label(categorias[index]);
            categoriaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            categoriaLabel.setTextFill(Color.WHITE);

            progressBars[index] = new ProgressBar(0);
            progressBars[index].setPrefWidth(300);

            Button aumentarButton = new Button("+");
            aumentarButton.setStyle("-fx-font-size: 1.5em; -fx-min-width: 30px;");
            aumentarButton.setOnAction(e -> aumentarProgresso(index));

            Button diminuirButton = new Button("-");
            diminuirButton.setStyle("-fx-font-size: 1.5em; -fx-min-width: 30px;");
            diminuirButton.setOnAction(e -> diminuirProgresso(index));

            HBox botoesLayout = new HBox(10);
            botoesLayout.getChildren().addAll(aumentarButton, diminuirButton);
            botoesLayout.setAlignment(Pos.CENTER);

            HBox categoriaLayout = new HBox(10);
            categoriaLayout.getChildren().addAll(categoriaLabel, progressBars[index], botoesLayout);
            categoriaLayout.setAlignment(Pos.CENTER);

            layout.getChildren().add(categoriaLayout);
        }

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> retornarTelaAnterior());

        VBox botaoLayout = new VBox();
        botaoLayout.getChildren().add(voltarButton);
        botaoLayout.setAlignment(Pos.CENTER);

        layout.getChildren().add(botaoLayout);

        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Acompanhamento de Progresso");
        primaryStage.show();
    }

    private void aumentarProgresso(int index) {
        double progress = progressBars[index].getProgress();
        if (progress < 1.0) {
            progress += 0.1;
            progressBars[index].setProgress(progress);
        }
    }

    private void diminuirProgresso(int index) {
        double progress = progressBars[index].getProgress();
        if (progress > 0.0) {
            progress -= 0.1;
            progressBars[index].setProgress(progress);
        }
    }

    private void retornarTelaAnterior() {
        primaryStage.close();
    }
}
