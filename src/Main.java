import entidades.Produto;
import entidades.Secao;
import entidades.Endereco;

import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        int opcao = 0;

        do{

            System.out.println("==============================");
            System.out.println("==============================");
            System.out.println("======= SI Markets Sys =======");
            System.out.println("==============================");
            System.out.println("==============================");

            System.out.println("01 - Cadastrar Secao\n");
            System.out.println("02 - Cadastrar Produto\n");
            System.out.println("20 - Sair do Sistema\n");

            if (opcao == 01)
            {
                Scanner nomeSecao = new Scanner(System.in);

            }


        }while(opcao != 20);










        Endereco endereco = new Endereco("Antonio Paulo de Miranda", "Centro", "Garanhuns", "55293340", "PE");
        Secao secao = new Secao("Cereais");
        Secao secao2 = new Secao("Bebidas");
        Secao secaoLimpeza = new Secao("Limpeza");
        Produto produto = new Produto("Cereal", 20.0, 25,secao);
        Produto produto2 = new Produto("Cerveja", 6.87, 7.10, secao2);
        Produto produtoLimpeza = new Produto("Detergente", 5.70, 7.50, secaoLimpeza);

        System.out.println(produto.toString());
        System.out.println(produto2.toString());
        System.out.println(produtoLimpeza.toString());
        System.out.println(endereco.toString());
    }
}
