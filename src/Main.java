import entidades.Funcionario;
import entidades.Produto;
import entidades.Secao;
import entidades.Endereco;

import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {


        //Endereco endereco = new Endereco("Antonio Paulo de Miranda", "Centro", "Garanhuns", "55293340", "PE");
        Secao secao = new Secao("Cereais");
        Secao secao2 = new Secao("Bebidas");
        Secao secaoLimpeza = new Secao("Limpeza");
        Produto produto = new Produto("Cereal", 20.0, 25,secao);
        Produto produto2 = new Produto("Cerveja", 6.87, 7.10, secao2);
        Produto produtoLimpeza = new Produto("Detergente", 5.70, 7.50, secaoLimpeza);

        System.out.println(produto.toString());
        System.out.println(produto2.toString());
        System.out.println(produtoLimpeza.toString());
        //System.out.println(endereco.toString());
        //Funcionario funcionario = new Funcionario("Igor", "08976547385", endereco, "Gerente", "mae");

        //System.out.println(funcionario.toString());
        //teste sau
    }
}
