package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import negocio.excecao.CodigoJaExisteException;
import negocio.excecao.SecaoNaoEncontradaException;

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
    public void cadastrarProduto(){
        try{

            fachada.adicionarProduto(Integer.parseInt(txtId.getText()), txtCodigoBarras.getText(), txtDescricao.getText(), Double.parseDouble(txtValorCompra.getText()), Double.parseDouble(txtValorVenda.getText()), Integer.parseInt(txtSecao.getText()));


        } catch (CodigoJaExisteException e) {
            e.printStackTrace();
        } catch (SecaoNaoEncontradaException e) {
            e.printStackTrace();
        }
    }

}
