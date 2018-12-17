package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import main.SIMarket;
import negocio.excecao.CodigoJaExisteException;
import negocio.excecao.SecaoNaoEncontradaException;

import java.io.IOException;

public class ControlerTelaCadastroProduto {

    Fachada fachada = new Fachada();

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtValorCompra;
    @FXML
    private TextField txtValorVenda;
    @FXML
    private TextField txtSecao;
    @FXML
    private TextField txtCodigoBarras;
    
    @FXML
    public void clikVoltar(){
        try{
            if(SIMarket.getUser().isGerente()){
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
            }else{
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }
    @FXML
    public void cadastrarProduto() throws IOException {
        try{

            if(!txtId.getText().equals("")){
                fachada.adicionarProduto(Integer.parseInt(txtId.getText()), txtCodigoBarras.getText(), txtDescricao.getText(),
                                         Double.parseDouble(txtValorCompra.getText()), Double.parseDouble(txtValorVenda.getText()),
                                         Integer.parseInt(txtSecao.getText()));
            }else{
                fachada.adicionarProduto(txtCodigoBarras.getText(), txtDescricao.getText(),
                        Double.parseDouble(txtValorCompra.getText()), Double.parseDouble(txtValorVenda.getText()),
                        Integer.parseInt(txtSecao.getText()));
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CADASTRO DE PRODUTO");
            alert.setHeaderText(null);
            alert.setContentText("PRODUTO CADASTRADO COM SUCESSO!!!");

            if(SIMarket.getUser().isGerente()){
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
            }else{
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
            }
        } catch (CodigoJaExisteException e) {
            e.printStackTrace();
        } catch (SecaoNaoEncontradaException e) {
            e.printStackTrace();
        }
    }

}
