/**
 *
 *
 *
 * @author Saú Cesar e Igor Albuquerque
 */
package main;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import fachada.Fachada;
import fachada.interfaces.IFachadaAssociado;
import fachada.interfaces.IFachadaGerente;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.entidades.Endereco;
import negocio.entidades.Funcionario;
import negocio.excecao.CpfJaExisteException;
import negocio.excecao.FuncionarioJaCadastrado;
import negocio.excecao.RgJaExisteException;
import negocio.excecao.UsuarioOuSenhaInvalidoException;

import java.io.IOException;

public class SIMarket  extends Application{

    private static Parent root;
    private static Funcionario user;
    private static Stage palco;

    @Override
    public void start(Stage stage) throws Exception {
        palco = stage;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void setUser(Funcionario usuario){user = usuario;}
    public static Funcionario getUser(){return user; }
    public static void setJanela(Parent janela) throws IOException{
        try {
            root = janela;
            Scene scene = new Scene(root);
            palco.setScene(scene);
            palco.show();
        }catch (Exception e){
            e.getMessage();
        }
    }
    public static void main(String[] args){

        launch(args);
    }

}
