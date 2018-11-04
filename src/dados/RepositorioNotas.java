/**
 * Validator used to check whether given string is
 * no longer than the specified amount of characters.
 *
 * @author Saú Cesar
 */
package dados;

import entidades.Data;
import entidades.Fornecedor;
import entidades.NotaFiscal;
import java.util.ArrayList;

public class RepositorioNotas {
    private ArrayList<NotaFiscal> notas;
    public RepositorioNotas(){
        this.notas = new ArrayList<NotaFiscal>();
    }
    public void adicionarNotas(NotaFiscal nota){
        this.notas.add(nota);
    }
    public String listarNotas(){
        String lista = "";
        for(NotaFiscal nota:this.notas){
            lista+=nota.toStringBasico();
        }
        return lista;
    }
    public void removerNota(int numero,int fornecedor){
        NotaFiscal nota = this.buscarNota(numero,fornecedor);

        if(nota!=null){
            this.notas.remove(nota);
        }else{
            System.out.println("======= A NOTA SOLICITADA NAO EXISTE!!! =========");
        }
    }
    public String listarNotasPorEntrada(Data data){

        String lista = "";

        for(NotaFiscal nota: this.notas){
            Data dataEntradaNota = new Data(nota.getDataEntrada().DAY_OF_MONTH,nota.getDataEntrada().MONTH,nota.getDataEntrada().YEAR);
            if(data.equals(dataEntradaNota)){
                lista+=nota.toStringBasico();
            }
        }
        return lista;
    }
    public String listarNotasPorEmissao(Data data){

        String lista = "";

        for(NotaFiscal nota: this.notas){
            Data dataEmissao = new Data(nota.getDataEmissao().getDia(),nota.getDataEmissao().getMes(),nota.getDataEmissao().getAno());
            if(data.equals(dataEmissao)){
                lista+=nota.toStringBasico();
            }
        }
        return lista;
    }
    public String listarNotasPorNumero(int numero){
        String lista = "";
        for(NotaFiscal nota:notas){
            if(nota.getNumero() == numero){
                lista += nota.toStringBasico();
            }
        }
        return lista;
    }
    public String listarNotas(int codigoFornecedor){
        String lista = "";
        for(NotaFiscal nota:notas){
            if(nota.getFornecedor().getCodigo() == codigoFornecedor){
                lista += nota.toStringBasico();
            }
        }
        return lista;
    }
    public String listarNotas(String cnpj){
        String lista = "";
        for(NotaFiscal nota:notas){
            if(nota.getFornecedor().getCnpj().equals(cnpj)){
                lista += nota.toStringBasico();
            }
        }
        return lista;
    }
    public NotaFiscal buscarNota(int numero,int codigoFornecedor){
        for(NotaFiscal nota:this.notas){
            if (nota.getNumero() == numero && nota.getFornecedor().getCodigo() == codigoFornecedor){
                return nota;
            }
        }
        return null;
    }
    public NotaFiscal buscarNota(int numero,String cnpj){
        for(NotaFiscal nota:this.notas){
            if (nota.getNumero() == numero && nota.getFornecedor().getCnpj() == cnpj){
                return nota;
            }
        }
        return null;
    }
}
