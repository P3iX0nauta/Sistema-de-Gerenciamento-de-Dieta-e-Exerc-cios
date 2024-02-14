package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaEsqueciSenha {

    private Stage primaryStage;

    public TelaEsqueciSenha(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void exibirTelaEsqueciSenha() {
        Label tituloLabel = new Label("Precisamos verificar\nsua identidade");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label subtituloLabel = new Label("Informe seu email para receber um link de verificação");
        Label emailLabel = new Label("EMAIL");
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Digite seu email cadastrado");
        Button confirmarEmailButton = new Button("Confirmar Email");
        confirmarEmailButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        Button voltarButton = new Button("Voltar para o Login");
        voltarButton.setOnAction(e -> voltarParaLogin());

        confirmarEmailButton.setOnAction(e -> enviarEmail());

        VBox layoutEsqueciSenha = new VBox(10);
        layoutEsqueciSenha.setPadding(new Insets(20));
        layoutEsqueciSenha.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutEsqueciSenha.getChildren().addAll(tituloLabel, subtituloLabel, emailLabel, emailTextField, confirmarEmailButton, voltarButton);

        Scene sceneEsqueciSenha = new Scene(layoutEsqueciSenha, 500, 400);

        primaryStage.setScene(sceneEsqueciSenha);
        primaryStage.setTitle("Esqueci Minha Senha");
        primaryStage.show();
    }

    private void voltarParaLogin() {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.start(primaryStage);
    }

    private void enviarEmail() {
        Stage avisoStage = new Stage();
        Label avisoLabel = new Label("AVISO:\nEmail enviado!\nSiga o passo a passo\npara verificar sua identidade");
        VBox avisoLayout = new VBox(10);
        avisoLayout.setPadding(new Insets(20));
        avisoLayout.getChildren().add(avisoLabel);
        Scene avisoScene = new Scene(avisoLayout, 250, 150);
        avisoStage.setScene(avisoScene);
        avisoStage.setTitle("ATENÇÃO");
        avisoStage.show();
    }
}
