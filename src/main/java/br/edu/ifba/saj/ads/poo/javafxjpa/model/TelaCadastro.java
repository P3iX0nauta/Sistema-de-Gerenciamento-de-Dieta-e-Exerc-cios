package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.NomeInvalidoException;
import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.SenhaCurtaException;
import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.SenhaNaoCorrespondeException;

public class TelaCadastro {

    private Stage primaryStage;

    public TelaCadastro(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void exibirTelaCadastro() {
        Label tituloLabel = new Label("SEJA BEM VINDO !");
        Label subLabel = new Label("Para começar, faça seu cadastro");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label nomeLabel = new Label("NOME (APENAS CARACTERES)");
        TextField nomeTextField = new TextField();
        nomeTextField.setPromptText("Digite seu nome");
        Label emailLabel = new Label("EMAIL");
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Digite seu email");
        Label senhaLabel = new Label("SENHA (MINÍMO 6 DÍGITOS)");
        PasswordField senhaTextField = new PasswordField();
        senhaTextField.setPromptText("Digite sua senha");
        Label confirmarSenhaLabel = new Label("CONFIRME A SENHA");
        PasswordField confirmarSenhaTextField = new PasswordField();
        confirmarSenhaTextField.setPromptText("Digite novamente sua senha");

        Button criarContaButton = new Button("CRIAR CONTA");
        criarContaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        criarContaButton.setOnAction(e -> {
            try {
                verificarCampos(nomeTextField.getText(), emailTextField.getText(), senhaTextField.getText(), confirmarSenhaTextField.getText());
                verificarSenhas(senhaTextField.getText(), confirmarSenhaTextField.getText());
                exibirAvisoContaCriada();
            } catch (NomeInvalidoException | SenhaCurtaException | SenhaNaoCorrespondeException ex) {
                exibirErro(ex.getMessage());
            }
        });

        Button voltarButton = new Button("Voltar para o Login");
        voltarButton.setOnAction(e -> voltarParaLogin());

        VBox layoutCadastro = new VBox(10);
        layoutCadastro.setPadding(new Insets(20));
        layoutCadastro.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutCadastro.getChildren().addAll(tituloLabel, subLabel, nomeLabel, nomeTextField, emailLabel, emailTextField, senhaLabel, senhaTextField, confirmarSenhaLabel, confirmarSenhaTextField, criarContaButton, voltarButton);

        Scene sceneCadastro = new Scene(layoutCadastro, 500, 450);

        primaryStage.setScene(sceneCadastro);
        primaryStage.setTitle("Tela de Cadastro");
        primaryStage.show();
    }

    private void exibirAvisoContaCriada() {
        Stage avisoStage = new Stage();
        Label avisoLabel = new Label("AVISO:\nCONTA CRIADA COM SUCESSO!\nVERIFIQUE SEU EMAIL PARA ATIVAR SUA CONTA");
        VBox avisoLayout = new VBox(10);
        avisoLayout.setPadding(new Insets(20));
        avisoLayout.getChildren().add(avisoLabel);
        Scene avisoScene = new Scene(avisoLayout, 400, 100);
        avisoStage.setScene(avisoScene);
        avisoStage.setTitle("ATENÇÃO");
        avisoStage.show();
    }

    private void exibirErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void verificarCampos(String nome, String email, String senha, String confirmarSenha) throws NomeInvalidoException, SenhaCurtaException {
        if (!nome.matches("[a-zA-Z]+")) {
            throw new NomeInvalidoException("Nome inválido. Por favor, insira um nome válido contendo apenas letras.");
        }
        if (senha.length() < 6) {
            throw new SenhaCurtaException("A senha deve ter pelo menos 6 caracteres.");
        }
    }

    private void verificarSenhas(String senha, String confirmarSenha) throws SenhaNaoCorrespondeException {
        if (!senha.equals(confirmarSenha)) {
            throw new SenhaNaoCorrespondeException("As senhas informadas não correspondem.");
        }
    }

    private void voltarParaLogin() {
        TelaLogin telaLogin = new TelaLogin(primaryStage);
        telaLogin.exibirTelaLogin();
    }
}
