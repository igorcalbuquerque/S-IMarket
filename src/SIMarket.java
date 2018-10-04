import dados.*;
import entidades.*;

import java.util.Scanner;

public class SIMarket {

    private static RepositorioSecao repositorioSecao = new RepositorioSecao();
    private static RepositorioProduto repositorioProduto = new RepositorioProduto();

    public static void main (String[] args){

        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("============== S & I Markets ==============");
        System.out.println("===========================================");
        System.out.println("===========================================");

        while(chamadaLogin() == false){
            chamadaLogin();
        }
        menu();
    }

    public static boolean login(String user, String senha) {
        if (user.equals("igor") && senha.equals("123")){
            return true;
        }
        return false;
    }

    public static void menu(){
        Scanner entradaOpcao = new Scanner(System.in);
        int opcao;
        do{

            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("========== S & I Markets (MENU) ===========");
            System.out.println("===========================================");
            System.out.println("===========================================");

            System.out.println("1 - CAIXA");
            System.out.println("2 - PRODUTOS");
            System.out.println("3 - SEÇÂO");
            System.out.println("4 - CLIENTES");
            System.out.println("88 - SAIR !!!");

            System.out.printf("Digite a Opção desejada: \t");
            opcao = entradaOpcao.nextInt();

            switch (opcao)
            {
                case 3:
                    subMenuSecao();
                    break;
                case 2:
                    subMenuProduto();
                    break;
            }



        }while (opcao != 88);

    }
    public static void subMenuSecao(){

        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("====== S & I Markets (MENU SEÇÂO) =========");
        System.out.println("===========================================");
        System.out.println("===========================================");

        int opcao;
        Scanner entradaOpcao = new Scanner(System.in);
        System.out.println("1 - CADASTRAR SECAO");
        System.out.println("2 - REMOVER SECAO");
        System.out.println("3 - LISTAR SECOES");
        System.out.println("4 - SAIR !!!");

        System.out.println("Insira a opcao desejada : \t");
        opcao = entradaOpcao.nextInt();

        switch (opcao){
            case 1:
                Scanner entradaDescricaoSecao = new Scanner(System.in);
                Scanner entradaOpcaoCodigo = new Scanner(System.in);
                System.out.print("\nDigite o nome da Seção que Deseja Cadastrar: \t");
                String descricaoSecao = entradaDescricaoSecao.nextLine();

                System.out.print("\nDeseja gerar codigo Automaticamente? (1)SIM (2)NAO \t");
                int opcaoCodigo =  entradaOpcaoCodigo.nextInt();
                Secao novaSecao;

                switch (opcaoCodigo){
                    case 1:
                        novaSecao = new Secao(descricaoSecao);
                        repositorioSecao.addSecao(novaSecao);
                        System.out.println(repositorioSecao.listarSecoes());
                        break;
                    case 2:
                        Scanner entradaCodigo = new Scanner(System.in);
                        System.out.print("\nDigite o Codigo da Seção que Deseja Cadastrar: \t");
                        int codigo = entradaCodigo.nextInt();
                        novaSecao = new Secao(codigo, descricaoSecao);
                        repositorioSecao.addSecao(novaSecao);
                        System.out.println(repositorioSecao.listarSecoes());
                        break;
                }
                break;
            case 2:
                Scanner entradaCodigo = new Scanner(System.in);
                int codigo;
                System.out.print("\nDigite o Codigo da Seção a ser Removida : \t");
                codigo = entradaCodigo.nextInt();
                repositorioSecao.removeSecao(codigo);
                break;
            case 3:
                System.out.println("=======SECOES CADASTRADAS=======");
                System.out.println(repositorioSecao.listarSecoes());
                break;
             default:
                 menu();
                 break;
        }

    }
    public static void subMenuProduto(){
        Scanner entradaOpcao = new Scanner(System.in);

        System.out.println("1 - INSERIR PRODUTO ");
        System.out.println("2 - REMOVE PRODUTO ");
        System.out.println("3 - LISTAR PRODUTOS");
        System.out.println("4 - MODIFICAR PRODUTO");
        System.out.println("88 - SAIR !!!");

        System.out.print("Digite sua opcao :  \t");
        int opcao = entradaOpcao.nextInt();

        Scanner entradaCodigo = new Scanner(System.in);
        Scanner entradaDescricao = new Scanner(System.in);
        Scanner entradaValorCompra = new Scanner(System.in);
        Scanner entradaValorVenda = new Scanner(System.in);
        Scanner entradaSecao = new Scanner(System.in);
        Scanner entradaOpcaoModificao = new Scanner(System.in);

        int codigoProduto;
        String descricao;
        double valorCompra;
        double valorVenda;
        int codigoSecao;
        Secao secao;
        Produto produto;
        int opcaoModificacao;

        switch (opcao){
            case 1:
                Scanner opcaoDeCodigo = new Scanner(System.in);

                System.out.println("Insira as informacoes Solicitadas !!!");
                System.out.print("Gerar codigo Automatico? (1)SIM (2)NAO \t");
                int opcaoCodigo = opcaoDeCodigo.nextInt();

                switch (opcaoCodigo){

                    case 1:

                        System.out.print("Descricao :  \t");
                        descricao = entradaDescricao.nextLine();
                        System.out.print("Valor de Compra :  \t");
                        valorCompra = entradaValorCompra.nextDouble();
                        System.out.print("Valor de Venda :   \t");
                        valorVenda = entradaValorVenda.nextDouble();
                        System.out.print("Codigo da Secao :   \t");
                        codigoSecao = entradaSecao.nextInt();
                        secao = repositorioSecao.buscarSecao(codigoSecao);

                        produto = new Produto(descricao,valorCompra,valorCompra,secao);
                        repositorioProduto.adicionarProduto(produto);
                        break;

                    case 2:

                        System.out.print("Codigo :  \t");
                        codigoProduto = entradaCodigo.nextInt();
                        System.out.print("Descricao :  \t");
                        descricao = entradaDescricao.nextLine();
                        System.out.print("Valor de Compra :  \t");
                        valorCompra = entradaValorCompra.nextDouble();
                        System.out.print("Valor de Venda :   \t");
                        valorVenda = entradaValorVenda.nextDouble();
                        System.out.print("Codigo da Secao :   \t");
                        codigoSecao = entradaSecao.nextInt();
                        secao = repositorioSecao.buscarSecao(codigoSecao);

                        produto = new Produto(codigoProduto,descricao,valorCompra,valorVenda,secao);
                        repositorioProduto.adicionarProduto(produto);
                        break;
                }
                break;

            case 2:

                System.out.print("Insira o Codigo do produto que deseja remover :  \t");
                codigoProduto = entradaCodigo.nextInt();
                repositorioProduto.removerProduto(codigoProduto);
                break;

            case 3:

                System.out.println(repositorioProduto.listarProdutos());
                break;

            case 4:

                System.out.print("Insira o Codigo do produto que deseja Modificar :  \t");
                codigoProduto = entradaCodigo.nextInt();
                produto = repositorioProduto.buscarProduto(codigoProduto);

                System.out.println("Informacao Atual");
                System.out.println(produto.toString());

                System.out.println("1 - MODIFICAR CODIGO ");
                System.out.println("2 - MODIFICAR DESCRICAO");
                System.out.println("3 - MODIFICAR VALOR COMPRA");
                System.out.println("4 - MODIFICAR VALOR VENDA");
                System.out.println("5 - MODIFICAR SECAO ");
                System.out.println("88 - SAIR !!!");
                opcaoModificacao = entradaOpcaoModificao.nextInt();
                switch (opcaoModificacao){
                    case 1:
                        System.out.print("Insira o Novo Codigo :  \t");
                        codigoProduto = entradaCodigo.nextInt();
                        produto.setCodigoProduto(codigoProduto);
                        break;
                    case 2:
                        System.out.print("Insira a Nova Descricao :  \t");
                        descricao = entradaDescricao.nextLine();
                        produto.setDescricao(descricao);
                        break;
                    case 3:
                        System.out.print("Insira a Novo Valor de Compra :  \t");
                        valorCompra = entradaValorCompra.nextDouble();
                        produto.setValorCompra(valorCompra);
                        break;
                    case 4:
                        System.out.print("Insira a Novo Valor de Venda :  \t");
                        valorVenda= entradaValorCompra.nextDouble();
                        produto.setValorVenda(valorVenda);
                        break;
                    case 5:
                        System.out.print("Insira o Codigo da Nova Secao :  \t");
                        codigoSecao= entradaSecao.nextInt();
                        secao = repositorioSecao.buscarSecao(codigoSecao);
                        produto.setSecao(secao);
                        break;
                    default:
                        subMenuProduto();
                        break;
                }
                break;

             default:
                 menu();
                 break;
        }

    }
    public static boolean chamadaLogin() {
        Scanner entradaUser = new Scanner(System.in);
        Scanner entradaSenha = new Scanner(System.in);

        System.out.printf("LOGIN: \t");
        String user = entradaUser.nextLine();
        System.out.printf("SENHA: \t");
        String senha = entradaSenha.nextLine();
        return login(user,senha);
    }
}
