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

public class TelaGerenciarDieta extends Application {

    private Stage primaryStage;

    public TelaGerenciarDieta() {
    }

    public TelaGerenciarDieta(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaGerenciarDieta();
    }

    public void exibirTelaGerenciarDieta() {
        Label tituloLabel = new Label("GERENCIANDO DIETA");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button definirMetaButton = new Button("DEFINIR META");
        definirMetaButton.setOnAction(e -> {
            Stage novaStage = new Stage();
            TelaDefinirMeta telaDefinirMeta = new TelaDefinirMeta(novaStage); 
            telaDefinirMeta.start(novaStage); 
        });
        definirMetaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button adicionarRefeicaoButton = new Button("ADICIONAR REFEIÇÃO");
        adicionarRefeicaoButton.setOnAction(e -> {
            Stage stage = new Stage();
            TelaAdicionarRefeicao telaAdicionarRefeicao = new TelaAdicionarRefeicao(stage);
            telaAdicionarRefeicao.start(stage);
        });
        Button verRefeicoesCadastradasButton = new Button("VER REFEIÇÕES CADASTRADAS");
        verRefeicoesCadastradasButton.setOnAction(e -> {
        TelaVisualizarRefeicoes telaVisualizarRefeicoes = new TelaVisualizarRefeicoes(primaryStage, null, null);
        telaVisualizarRefeicoes.start(new Stage());   
        });
        verRefeicoesCadastradasButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        
        adicionarRefeicaoButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button contabilizarCaloriasButton = new Button("CONTABILIZAR CALORIAS");
        contabilizarCaloriasButton.setOnAction(e -> {
            TelaContabilizarCalorias telaContabilizarCalorias = new TelaContabilizarCalorias(primaryStage);
            telaContabilizarCalorias.start(primaryStage);
        });
        
        contabilizarCaloriasButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> {
         TelaPrincipal telaPrincipal = new TelaPrincipal(primaryStage);
         try {
            telaPrincipal.start(primaryStage);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    });

    

        VBox layoutGerenciarDieta = new VBox(20);
        layoutGerenciarDieta.setPadding(new Insets(20));
        layoutGerenciarDieta.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutGerenciarDieta.getChildren().addAll(tituloLabel, definirMetaButton, adicionarRefeicaoButton,verRefeicoesCadastradasButton,contabilizarCaloriasButton, voltarButton);
        layoutGerenciarDieta.setAlignment(Pos.CENTER);

        Scene sceneGerenciarDieta = new Scene(layoutGerenciarDieta, 500, 400);

        primaryStage.setScene(sceneGerenciarDieta);
        primaryStage.setTitle("Tela de Gerenciamento de Dieta");
        primaryStage.show();
    }

}