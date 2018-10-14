package dados;

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
    public String listarNotas(int dia,int mes, int ano){
        String dataBuscada = dia+" - "+mes+" - "+ano;
        String lista = "";
        for(NotaFiscal nota: this.notas){
            String dataEntradaNota = nota.getDataEntrada().DAY_OF_MONTH+" - "+nota.getDataEntrada().MONTH+
                   " - "+nota.getDataEntrada().YEAR;
            if(dataBuscada.equals(dataEntradaNota)){
                lista+=nota.toStringBasico();
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
