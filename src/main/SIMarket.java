/**
 *
 *
 *
 * @author Saú Cesar e Igor Albuquerque
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SIMarket  extends Application{

    private Parent parent;

    public static void main(String[] args){
        launch(args);
    }
    public void setJanela(String janela) throws IOException {
        parent = FXMLLoader.load(getClass().getClassLoader().getResource(janela));
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        parent = FXMLLoader.load(getClass().getClassLoader().getResource("../GUI/TelaLogin.fxml"));
        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.setTitle("LOGIN");
        primaryStage.show();
    }
}
