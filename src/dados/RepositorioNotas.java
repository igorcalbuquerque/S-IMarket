/**
 *
 *
 *
 * @author Saú Cesar
 */
package dados;

import dados.interfaces.IRepositorioNotas;
import negocio.entidades.Data;
import negocio.entidades.Fornecedor;
import negocio.entidades.NotaFiscal;
import java.util.ArrayList;

public class RepositorioNotas implements IRepositorioNotas {

    private ArrayList<NotaFiscal> notas;

    public RepositorioNotas(){ this.notas = new ArrayList<NotaFiscal>(); }
    public void adicionarNotas(NotaFiscal nota){ this.notas.add(nota); }
    @Override
    public String toString(){
        String str = "";

        for(NotaFiscal nota:this.notas){
            str += nota.toStringBasico();
        }
        return str;
    }
    public void removerNota(int numero,Fornecedor fornecedor){
        NotaFiscal nota = this.buscarNota(numero,fornecedor);
        this.notas.remove(nota);
    }
    public String listarNotasPorEntrada(Data data){
        String str = "";

        for(NotaFiscal nota: this.notas){
            if(data.equals(nota.getDataEntrada())){
                str += nota.toStringBasico();
            }
        }

        return str;
    }
    public String listarNotasPorEmissao(Data data){
        String str = "";

        for(NotaFiscal nota: this.notas){
            if(data.equals(nota.getDataEmissao())){
                str += nota.toStringBasico();
            }
        }
        return str;
    }
    public String listarNotasPorNumero(int numero){
        String str = "";

        for(NotaFiscal nota:notas){
            if(nota.getNumero() == numero){
                str += nota.toStringBasico();
            }
        }
        return str;
    }
    public String listarNotasPorFornecedor(Fornecedor fornecedor){
        String str = "";

        for(NotaFiscal nota:notas){
            if(nota.getFornecedor().equals(fornecedor)){
                str += nota.toStringBasico();
            }
        }
        return str;
    }
    public NotaFiscal buscarNota(int numero,Fornecedor fornecedor){
        for(NotaFiscal nota:this.notas){
            if (nota.getNumero() == numero && nota.getFornecedor().equals(fornecedor)){
                return nota;
            }
        }
        return null;
    }
}
