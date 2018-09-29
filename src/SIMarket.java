import java.util.Scanner;

public class SIMarket {

    public static void main (String[] args)
    {

        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("============== S & I Markets ==============");
        System.out.println("===========================================");
        System.out.println("===========================================");




        if(chamadas())
        {
            menu();
        }



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
            System.out.println("3 - CADASTRAR PRODUTOS");
            System.out.println("4 - CADASTRAR SEÇÂO");
            System.out.println("5 - CLIENTES");
            System.out.println("6 - CADASTRAR CLIENTES");
            System.out.printf("Digite a Opção desejada: \t");
            opcao = entradaOpcao.nextInt();

            switch (opcao)
            {

            }


        }while (opcao != 88);
    }
    public static boolean chamadas()
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
