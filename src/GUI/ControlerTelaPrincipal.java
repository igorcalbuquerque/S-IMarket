package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import main.SIMarket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlerTelaPrincipal {

    @FXML
    private Button btnCadastroProduto;
    @FXML
    private Button btnCadastroPessoa;
    @FXML
    private Button btnEntradaNota;
    @FXML
    private Button btnProduto;
    @FXML
    private Button btnCliente;
    @FXML
    private Button btnFuncionario;
    @FXML
    private Button btnVenda;
    @FXML
    private Button btnSair;

    @FXML
    public void cliqueCadastroProduto(){
        try {
            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaCadastroProduto.fxml")));
        }catch (IOException e){
            e.getMessage();
        }
    }
    @FXML
    public void cliqueCadastroPessoa(){
        try {
            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaCadastroPessoa.fxml")));
        }catch (IOException e){
            e.getMessage();
        }
    }
    @FXML
    public void cliqueFornecedor(){
        try {
            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaFornecedor.fxml")));
        }catch (IOException e){
            e.getMessage();
        }
    }
    @FXML
    public void cliqueConsultaProduto(){
        try {
            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaConsultaProduto.fxml")));
        }catch (IOException e){
            e.getMessage();
        }
    }
    @FXML
    public void cliqueConsultaCliente(){
        try {
            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaConsultaCliente.fxml")));
        }catch (IOException e){
            e.getMessage();
        }

    }
    @FXML
    public void cliqueConsultaFuncionario(){
        try {

            SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaConsultaFuncionario.fxml")));
        }catch (IOException e){
            e.getMessage();
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Funcionarios");
        alert.setHeaderText("");
        alert.setContentText(Fachada.getInstance().listarFuncionarios());



        alert.showAndWait();
    }







}
