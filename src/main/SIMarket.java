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

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

   /* public void setJanela(String janela) throws IOException {
        try {
            parent = FXMLLoader.load(getClass().getClassLoader().getResource(janela));
        }catch (Exception e){
            e.getMessage();
        }
    }*/

    public static void main(String[] args){
        launch(args);
    }

}
