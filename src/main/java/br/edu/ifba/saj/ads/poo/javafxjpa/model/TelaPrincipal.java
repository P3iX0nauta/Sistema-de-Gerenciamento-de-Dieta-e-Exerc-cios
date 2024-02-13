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

public class TelaPrincipal extends Application {

    private Stage primaryStage;
    private String nomeUsuario;
    
    public TelaPrincipal(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nomeUsuario = "Gustavo"; // nome de usuario
    }
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        exibirTelaPrincipal();
    }

    public void exibirTelaPrincipal() {
        Label tituloLabel = new Label("OLÁ, " + nomeUsuario.toUpperCase());
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label subtituloLabel = new Label("O QUE VOCÊ DESEJA?");
        
        Button gerenciarDietaButton = new Button("GERENCIAR DIETA");
        gerenciarDietaButton.setOnAction(e -> abrirTelaGerenciarDieta());
        gerenciarDietaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button gerenciarExerciciosButton = new Button("GERENCIAR MEUS EXERCÍCIOS");
        gerenciarExerciciosButton.setOnAction(e -> abrirTelaGerenciarExercicios());
        gerenciarExerciciosButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button sugestoesDietaButton = new Button("SUGESTÕES DE DIETA");
        sugestoesDietaButton.setOnAction(e -> abrirTelaSugestaoDieta());
        sugestoesDietaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button sugestoesExerciciosButton = new Button("SUGESTÕES DE EXERCÍCIOS");
        sugestoesExerciciosButton.setOnAction(e -> abrirTelaSugestaoExercicios());
        sugestoesExerciciosButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button acompanharProgressoButton = new Button("ACOMPANHAR MEU PROGRESSO");
        acompanharProgressoButton.setOnAction(e -> abrirTelaAcompanharProgresso());
        acompanharProgressoButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button sairButton = new Button("SAIR");
        sairButton.setOnAction(e -> encerrarPrograma());
        sairButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutPrincipal.getChildren().addAll(tituloLabel, subtituloLabel, gerenciarDietaButton,
                                               gerenciarExerciciosButton, sugestoesDietaButton,
                                               sugestoesExerciciosButton, acompanharProgressoButton,
                                               sairButton);
        layoutPrincipal.setAlignment(Pos.CENTER);

        Scene scenePrincipal = new Scene(layoutPrincipal, 500, 400);

        primaryStage.setScene(scenePrincipal);
        primaryStage.setTitle("Tela Principal");
        primaryStage.show();
    }

    private void abrirTelaGerenciarDieta() {
        TelaGerenciarDieta telaGerenciarDieta = new TelaGerenciarDieta(primaryStage);
        telaGerenciarDieta.start(primaryStage);
    }
    
    private void abrirTelaGerenciarExercicios() {
        TelaGerenciarExercicios telaGerenciarExercicios = new TelaGerenciarExercicios(primaryStage);
        telaGerenciarExercicios.start(new Stage());
    }
    private void abrirTelaSugestaoDieta() {
        TelaSugestaoDieta telaSugestaoDieta = new TelaSugestaoDieta();
        telaSugestaoDieta.start(new Stage());
    }
    private void abrirTelaSugestaoExercicios() {
        Stage stage = new Stage();
        TelaSugestaoExercicios telaExercicios = new TelaSugestaoExercicios(stage);
        telaExercicios.start(stage);
    }
    
    private void abrirTelaAcompanharProgresso() {
        TelaAcompanharProgresso telaAcompanharProgresso = new TelaAcompanharProgresso();
        Stage stage = new Stage();
        telaAcompanharProgresso.start(stage);
    }
    

    private void encerrarPrograma() {
        primaryStage.close();
    }
}