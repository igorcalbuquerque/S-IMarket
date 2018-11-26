/**
 *
 *
 *
 * @author Saú Cesar
 */

package main;

import negocio.entidades.Data;
import negocio.entidades.Endereco;
import negocio.validacao.ValidaDados;
import java.util.Scanner;

public class SolicitaDados {

    private static ValidaDados validaDados = ValidaDados.getInstance();

    public static String solicitaRg(){

        Scanner entradaRg = new Scanner(System.in);
        String rg;

        do{
            System.out.print("Digite o RG: \t");
            rg = entradaRg.next();
            if(!validaDados.isRg(rg)){
                System.out.print("INSIRA UM RG VALIDO!!!");
            }
        }while (!validaDados.isRg(rg));

        return rg;
    }
    public static String solicitaCpf(){

        Scanner entradaCpf = new Scanner(System.in);
        String cpf;

        do {
            System.out.print("Digite o CPF : \t");
            cpf = entradaCpf.next();
            if (!validaDados.isCPF(cpf))
            {
                System.out.println("CPF INVÁLIDO!!! DIGITE NOVAMENTE!");
            }
        }while (!validaDados.isCPF(cpf));

        return cpf;
    }
    public static String solicitaNome(){

        Scanner entradaNome = new Scanner(System.in);
        String nome;
        do{

            System.out.print("Digite o Nome: \t");
            nome = entradaNome.nextLine();
            if(!validaDados.isName(nome)){
                System.out.println("INSIRA UM NOME VALIDO!!!");
            }
        }while(!validaDados.isName(nome));
        return nome;
    }
    public static Endereco solicitaEndereco(){

        Scanner entradaEndereco = new Scanner(System.in);

        System.out.print("Digite o nome da Rua: \t");
        String rua = entradaEndereco.nextLine();
        System.out.print("Digite o nome do Bairro: \t");
        String bairro = entradaEndereco.nextLine();
        System.out.print("Digite o número da casa: \t");
        String numero = entradaEndereco.nextLine();
        System.out.print("Digite o nome da Cidade: \t");
        String cidade = entradaEndereco.nextLine();
        System.out.print("Digite o número do CEP: \t");
        String cep = entradaEndereco.nextLine();
        System.out.print("Digite o nome da UF: \t");
        String uf = entradaEndereco.nextLine();

        return new Endereco(rua, numero, bairro, cidade, cep, uf);
    }
    public static String solicitaLogin(){
        Scanner entradaLogin = new Scanner(System.in);

        System.out.print("Digite o Login : \t");
        String  login = entradaLogin.nextLine();

       return login;
    }
    public static String solicitaSenha(){

        Scanner entradaSenha = new Scanner(System.in);
        Scanner entradaConfirmaSenha = new Scanner(System.in);
        String senha;
        String confirmaSenha;

        do{

            System.out.print("Digite a Senha Desejada: \t");
            senha = entradaSenha.nextLine();
            System.out.print("Confirme a Senha Digitada: \t");
            confirmaSenha = entradaConfirmaSenha.nextLine();
            if(!senha.equals(confirmaSenha)){
                System.out.println("Senha Não confere!!!");
            }

        }while (!senha.equals(confirmaSenha));

        return senha;
    }
    public static int solicitaOpcao(){

        Scanner entradaOpcao = new Scanner (System.in);

        System.out.print("Digite sua opcao :  \t");
        int opcao = entradaOpcao.nextInt();

        return opcao;
    }
    public static Data solicitarData(){

        int dia,mes,ano;
        Scanner entradaData = new Scanner(System.in);
        Data data;

        do{

            System.out.print("DIA : ");
            dia = entradaData.nextInt();

            System.out.print("MES : ");
            mes = entradaData.nextInt();

            System.out.print("ANO : ");
            ano = entradaData.nextInt();

            data = new Data(dia,mes,ano);

            if(!validaDados.isData(data)){
                System.out.println("INSIRA UMA DATA VALIDA!!!");
            }

        }while (!validaDados.isData(data));

        return data;
    }
    public static int solicitarInt(String str){

        Scanner entradaCodigo = new Scanner(System.in);

        System.out.print("DIGITE O "+str+":\t");
        int codigo = entradaCodigo.nextInt();

        return codigo;
    }
    public static double solicitarDouble(String str){

        Scanner entrada = new Scanner(System.in);

        System.out.print("INSIRA O(A) "+str+":\t");
        double valor = entrada.nextDouble();

        return valor;
    }
    public static String solicitarString(String str){

        Scanner entrada = new Scanner(System.in);

        System.out.print("INSIRA "+str+":\t");
        String descricao = entrada.next();

        return descricao;
    }
}
