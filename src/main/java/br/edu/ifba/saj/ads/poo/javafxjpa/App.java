package br.edu.ifba.saj.ads.poo.javafxjpa;

import br.edu.ifba.saj.ads.poo.javafxjpa.model.TelaLogin;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.start(primaryStage);
    }

}
