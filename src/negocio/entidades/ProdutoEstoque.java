/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

import negocio.entidades.abstratas.ProdutoAbstrato;

public class ProdutoEstoque extends ProdutoAbstrato {

    protected Produto produto;
    protected double quantidade;

    public ProdutoEstoque(Produto prod, double quant){
        super(prod,quant);
    }
    public ProdutoEstoque(Produto prod){
        super(prod,0);
    }
}
