import dados.RepositorioSecao;
import entidades.Secao;

import java.util.Scanner;

public class SIMarket {

    private static RepositorioSecao repositorioSecao = new RepositorioSecao();

    public static void main (String[] args)
    {

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

    public static boolean login(String user, String senha)
    {
        if (user.equals("igor") && senha.equals("123")){
            return true;
        }
        return false;
    }

    public static void menu()
    {
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
            }


        }while (opcao != 88);

    }
    public static void subMenuSecao(){

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
                System.out.println(repositorioSecao.listarSecoes());
                break;
             default:
                 menu();
                 break;
        }

    }
    public static boolean chamadaLogin()
    {
        Scanner entradaUser = new Scanner(System.in);
        Scanner entradaSenha = new Scanner(System.in);

        System.out.printf("LOGIN: \t");
        String user = entradaUser.nextLine();
        System.out.printf("SENHA: \t");
        String senha = entradaSenha.nextLine();
        return login(user,senha);
    }


}
