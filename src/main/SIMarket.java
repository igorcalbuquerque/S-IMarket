/**
 *
 *
 *
 * @author Saú Cesar e Igor Albuquerque
 */
package main;

import dados.*;
import entidades.*;
import validacao.ValidaDados;

import java.util.Scanner;

public class SIMarket {

    private static EstoqueProduto estoque = new EstoqueProduto();
    private static RepositorioCliente clientes = new RepositorioCliente();
    private static RepositorioFornecedor fornecedores = new RepositorioFornecedor();
    private static RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();
    private static RepositorioNotas notas = new RepositorioNotas();
    private static RepositorioProduto repositorioProduto = new RepositorioProduto();
    private static RepositorioSecao repositorioSecao = new RepositorioSecao();
    private static RepositorioVenda vendas = new RepositorioVenda();
    private static RepositorioCliente repositorioCliente = new RepositorioCliente();
    private static Funcionario usuario;

    public static void main(String[] args){

        iniciarCadastroPadrao();

        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("============== S & I Markets ==============");
        System.out.println("===========================================");
        System.out.println("===========================================");

        boolean logado = login();
        while (!logado){
            logado= login();
        }

    }
    public static boolean login() {
        String login;
        String senha;
        Funcionario usuario;

        do{

            Scanner entradaUser = new Scanner(System.in);
            Scanner entradaSenha = new Scanner(System.in);

            System.out.print("LOGIN: \t");
            login = entradaUser.nextLine();
            System.out.print("SENHA: \t");
            senha = entradaSenha.nextLine();

            usuario = repositorioFuncionario.buscarPorLogin(login);

            if(usuario!=null){
                if(usuario.getSenha().equals(senha)){
                    break;
                }else{
                    System.out.println("SENHA INVALIDA!!!");
                }
            }else{
                System.out.println("USUARIO INVALIDO!!!");
            }
        }while ((usuario == null) || (usuario.getSenha().equals(senha)==false));

        Funcionario user = repositorioFuncionario.buscarPorLogin(login);
        if(user!=null){
            if(user.getSenha().equals(senha)){
                setUsuario(user);
                if (usuario.isGerente())
                {
                    menu();
                }
                else
                {
                    menuAssociado();
                }
                return true;
            }
        }
        return false;
    }
    public static void menuAssociado() {
        Scanner entradaOpcao = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("========== S & I Markets (MENU) ===========");
            System.out.println("===========================================");
            System.out.println("===========================================");

            System.out.println("1 - CAIXA");
            System.out.println("2 - CLIENTES");
            System.out.println("3 - ESTOQUE ");
            System.out.println("4 - MUDAR USUARIO ");
            System.out.println("88 - SAIR !!!");

            System.out.print("Digite a Opção desejada: \t");
            opcao = entradaOpcao.nextInt();

            switch (opcao) {
                case 1:
                    subMenuCaixa();
                    break;
                case 2:
                    subMenuCliente();
                    break;
                case 3:
                    subMenuEstoque();
                    break;
                case 4:

                    while (!login()){
                        login();
                    }
                    break;
            }

        } while (opcao != 88);
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
            System.out.println("5 - FUNCIONARIOS");
            System.out.println("6 - ESTOQUE ");
            System.out.println("7 - FORNECEDORES");
            System.out.println("88 - SAIR !!!");

            System.out.print("Digite a Opção desejada: \t");
            opcao = entradaOpcao.nextInt();

            switch (opcao){
                case 1:
                    subMenuCaixa();
                    break;
                case 2:
                    subMenuProduto();
                    break;
                case 3:
                    subMenuSecao();
                    break;
                case 4:
                    subMenuCliente();
                    break;
                case 5:
                    subMenuFuncionario();
                    break;
                case 6:
                    subMenuEstoque();
                    break;
            }

        }while (opcao != 88);
    }
    public static void subMenuEstoque(){
        int opcao;
        Scanner entradaOpcao = new Scanner(System.in);
        do{

            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===== S & I Markets (MENU  ESTOQUE) =======");
            System.out.println("===========================================");
            System.out.println("===========================================");

            System.out.println("1 - NOTA DE ENTRADA");
            System.out.println("2 - LISTAR NOTAS(POR DATA EMISSAO)");
            System.out.println("3 - LISTAR NOTAS(POR DATA ENTRADA)");
            System.out.println("4 - LISTAR NOTAS(POR NUMERO)");
            System.out.println("5 - LISTAR NOTAS(POR FORNECEDOR)");
            System.out.println("6 - RELATORIO DE ESTOQUE");
            System.out.println("88 - SAIR");
            System.out.println("Insira a opcao desejada : \t");
            opcao = entradaOpcao.nextInt();

            int dia,mes,ano;
            Scanner entradaData = new Scanner(System.in);
            Scanner entradaFornecedor = new Scanner(System.in);
            Scanner entradaNumero = new Scanner(System.in);

            switch (opcao){
                case 1:

                    int opcaoNota;
                    Scanner entradaOpcaoNota = new Scanner(System.in);

                    int numero;
                    int serie;
                    Data dataEmissao;
                    int codigoFornecedor;
                    Fornecedor fornecedor;


                    Scanner entradaSerie = new Scanner(System.in);

                    System.out.print("NUMERO DA NOTA : \t");
                    numero = entradaNumero.nextInt();
                    System.out.print("SERIE : \t");
                    serie = entradaSerie.nextInt();
                    do{
                        System.out.println("DATA DE EMISSAO");
                        System.out.print("DIA : ");
                        dia = entradaData.nextInt();
                        System.out.print("MES : ");
                        mes = entradaData.nextInt();
                        System.out.print("ANO : ");
                        ano = entradaData.nextInt();
                        dataEmissao = new Data(dia,mes,ano);
                        if(!ValidaDados.isData(dataEmissao)){
                            System.out.println("DATA INVALIDA!!!");
                        }
                    }while (!ValidaDados.isData(dataEmissao));

                    do{
                        System.out.print("CODIGO FORNECEDOR : \t");
                        codigoFornecedor = entradaFornecedor.nextInt();
                        fornecedor = fornecedores.buscarFornecedor(codigoFornecedor);
                    }while (fornecedor==null);

                    NotaFiscal nota = new NotaFiscal(numero,serie,dataEmissao,fornecedor);

                    int codigoProduto;
                    Produto produto;
                    double valorCompra;
                    double quantidade;

                    Scanner entradaCodigoProduto = new Scanner(System.in);
                    Scanner entradaQuantidade = new Scanner(System.in);
                    Scanner entradaValorCompra = new Scanner(System.in);

                    do{
                        System.out.print("INSIRA O CODIGO DO PRODUTO : \t");
                        codigoProduto = entradaCodigoProduto.nextInt();
                        produto = repositorioProduto.buscarProduto(codigoProduto);

                        if(produto!=null){
                          System.out.print("INSIRA O VALOR DE COMPRA : \t");
                          valorCompra = entradaValorCompra.nextDouble();
                          System.out.print("INSIRA QUANTIDADE : \t");
                          quantidade = entradaQuantidade.nextDouble();
                          nota.adicionarProduto(produto,valorCompra,quantidade);
                        }else{
                            System.out.println("CODIGO INVALIDO!!!");
                        }
                        System.out.println("DIGITE (1)PARA CONTINUAR (88)PARA FECHAR NOTA");
                        opcao = entradaOpcao.nextInt();
                    }while(opcao != 88);

                    estoque.incrementar(nota);
                    notas.adicionarNotas(nota);
                    subMenuEstoque();
                    break;
                case 2:
                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR DATA EMISSAO) ======");
                    System.out.println("===========================================");

                    do{
                        System.out.println("DATA DE EMISSAO");
                        System.out.print("DIA : ");
                        dia = entradaData.nextInt();
                        System.out.print("MES : ");
                        mes = entradaData.nextInt();
                        System.out.print("ANO : ");
                        ano = entradaData.nextInt();
                        dataEmissao = new Data(dia,mes,ano);
                        if(!ValidaDados.isData(dataEmissao)){
                            System.out.println("DATA INVALIDA!!!");
                        }
                    }while (!ValidaDados.isData(dataEmissao));

                    System.out.println(notas.listarNotasPorEmissao(dataEmissao));
                    break;
                case 3:
                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR DATA ENTRADA) ======");
                    System.out.println("===========================================");

                    Data dataEntrada;

                    do{
                        System.out.println("DATA DE ENTRADA");
                        System.out.print("DIA : ");
                        dia = entradaData.nextInt();
                        System.out.print("MES : ");
                        mes = entradaData.nextInt();
                        System.out.print("ANO : ");
                        ano = entradaData.nextInt();
                        dataEntrada = new Data(dia,mes,ano);
                        if(!ValidaDados.isData(dataEntrada)){
                            System.out.println("DATA INVALIDA!!!");
                        }
                    }while (!ValidaDados.isData(dataEntrada));

                    System.out.println(notas.listarNotasPorEntrada(dataEntrada));
                    break;
                case 4:
                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR NUMERO) ======");
                    System.out.println("===========================================");

                    System.out.println("Insira o Numero : ");
                    int num = entradaNumero.nextInt();

                    System.out.println(notas.listarNotasPorNumero(num));

                    break;
                case 5:
                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR FORNECEDOR) ======");
                    System.out.println("===========================================");

                    System.out.println("Insira o codigo : ");
                    codigoFornecedor = entradaFornecedor.nextInt();

                    System.out.println(notas.listarNotas(codigoFornecedor));
                    break;

                case 6:
                    System.out.println(estoque.listarEstoque());
                    subMenuEstoque();
                    break;
            }

        }while(opcao!=88);
        menu();
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

        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("====== S & I Markets (MENU PRODUTO) =======");
        System.out.println("===========================================");
        System.out.println("===========================================");

        System.out.println("1 - INSERIR PRODUTO ");
        System.out.println("2 - REMOVE PRODUTO ");
        System.out.println("3 - LISTAR PRODUTOS");
        System.out.println("4 - MODIFICAR PRODUTO");
        System.out.println("88 - SAIR !!!");

        System.out.print("Digite sua opcao :  \t");
        int opcao = entradaOpcao.nextInt();

        Scanner entradaCodigo = new Scanner(System.in);
        Scanner entradaCodigoBarra = new Scanner(System.in);
        Scanner entradaDescricao = new Scanner(System.in);
        Scanner entradaValorCompra = new Scanner(System.in);
        Scanner entradaValorVenda = new Scanner(System.in);
        Scanner entradaSecao = new Scanner(System.in);
        Scanner entradaOpcaoModificao = new Scanner(System.in);

        int codigoProduto;
        String codigoBarra;
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
                        System.out.print("Codigo Barra :  \t");
                        codigoBarra = entradaCodigoBarra.nextLine();
                        System.out.print("Descricao :  \t");
                        descricao = entradaDescricao.nextLine();
                        System.out.print("Valor de Compra :  \t");
                        valorCompra = entradaValorCompra.nextDouble();
                        System.out.print("Valor de Venda :   \t");
                        valorVenda = entradaValorVenda.nextDouble();
                        System.out.print("Codigo da Secao :   \t");
                        codigoSecao = entradaSecao.nextInt();
                        secao = repositorioSecao.buscarSecao(codigoSecao);

                        produto = new Produto(codigoBarra,descricao,valorCompra,valorVenda,secao);
                        repositorioProduto.adicionarProduto(produto);
                        estoque.adicionarProduto(produto);
                        break;

                    case 2:

                        System.out.print("Codigo :  \t");
                        codigoProduto = entradaCodigo.nextInt();
                        System.out.print("Codigo Barra :  \t");
                        codigoBarra = entradaCodigoBarra.nextLine();
                        System.out.print("Descricao :  \t");
                        descricao = entradaDescricao.nextLine();
                        System.out.print("Valor de Compra :  \t");
                        valorCompra = entradaValorCompra.nextDouble();
                        System.out.print("Valor de Venda :   \t");
                        valorVenda = entradaValorVenda.nextDouble();
                        System.out.print("Codigo da Secao :   \t");
                        codigoSecao = entradaSecao.nextInt();
                        secao = repositorioSecao.buscarSecao(codigoSecao);

                        produto = new Produto(codigoProduto,codigoBarra,descricao,valorCompra,valorVenda,secao);
                        repositorioProduto.adicionarProduto(produto);
                        estoque.adicionarProduto(produto);
                        break;
                }
                break;

            case 2:

                System.out.print("Insira o Codigo do produto que deseja remover :  \t");
                codigoProduto = entradaCodigo.nextInt();
                repositorioProduto.removerProduto(codigoProduto);
                estoque.removerProduto(codigoProduto);
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
    public static void subMenuFuncionario(){
        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("==== S & I Markets (MENU FUNCIONARIO) =====");
        System.out.println("===========================================");
        System.out.println("===========================================");

        System.out.println("1 - INSERIR FUNCIONARIO ");
        System.out.println("2 - REMOVE FUNCIONARIO ");
        System.out.println("3 - LISTAR FUNCIONARIO");
        System.out.println("4 - MODIFICAR FUNCIONARIO");
        System.out.println("88 - SAIR !!!");

        Scanner entradaOpcao = new Scanner (System.in);

        System.out.print("Digite sua opcao :  \t");
        int opcao = entradaOpcao.nextInt();

        Scanner entradaNomeFuncionario = new Scanner(System.in);
        Scanner entradaCpfFuncionario = new Scanner(System.in);
        Scanner entradargFuncionario = new Scanner(System.in);
        Scanner entradaEndereco = new Scanner(System.in);
        Scanner entradaLogin = new Scanner(System.in);
        Scanner entradaSenha = new Scanner(System.in);
        Scanner entradaConfirmaSenha = new Scanner(System.in);

        String nome;
        String cpf;
        String rg;
        String login;
        String senha;





        switch (opcao)
        {

            case 1:
                System.out.print("Digite o Nome do Funcionário: \t");
                nome = entradaNomeFuncionario.nextLine();

                do {
                    System.out.print("Digite o CPF do Funcionário: \t");
                    cpf = entradaCpfFuncionario.nextLine();
                    if (ValidaDados.isCPF(cpf) != true)
                    {
                        System.out.println("CPF INVÁLIDO!!! DIGITE NOVAMENTE!");
                    }
                }while (ValidaDados.isCPF(cpf) != true);

                System.out.print("Digite o RG do Funcionário: \t");
                rg = entradargFuncionario.nextLine();
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
                System.out.print("Digite o Login (OPCIONAL): \t");
                login = entradaLogin.nextLine();
                System.out.print("Digite a Senha Desejada: \t");
                senha = entradaSenha.nextLine();
                System.out.print("Confirme a Senha Digitada: \t");
                String confirmaSenha = entradaConfirmaSenha.nextLine();

                if (senha.equals(confirmaSenha))
                {
                    Endereco enderecoSalvar = new Endereco(rua, numero, bairro, cidade, cep, uf);
                    Funcionario funcionario = new Funcionario(nome, rg, cpf, enderecoSalvar, false, senha);

                    repositorioFuncionario.adicionarPessoa(funcionario);
                }
                else
                {
                    boolean confere = false;
                    System.out.println("Senha Não confere!!!");
                    while(confere == false)
                    {
                        System.out.print("Digite a Senha Desejada: \t");
                        senha = entradaSenha.nextLine();
                        System.out.print("Confirme a Senha Digitada: \t");
                        confirmaSenha = entradaConfirmaSenha.nextLine();

                        if (senha.equals(confirmaSenha))
                        {
                            Endereco enderecoSalvar = new Endereco(rua, numero, bairro, cidade, cep, uf);
                            Funcionario funcionario = new Funcionario(nome, rg, cpf, enderecoSalvar, false, senha);

                            repositorioFuncionario.adicionarPessoa(funcionario);
                            confere = true;
                        }
                    }

                }
                menu();
                break;

            case 2:

                System.out.println("Digite o CPF do Funcionário a Ser Removido: \t");
                String cpfFuncionario = entradaCpfFuncionario.nextLine();
                repositorioFuncionario.removerPessoaCpf(cpfFuncionario);
                menu();
                break;

            case 3:
                System.out.println("==========================================");
                System.out.println("==========================================");
                System.out.println("========== LISTA DE FUNCIONÁRIOS =========");
                System.out.println("==========================================");
                System.out.println("==========================================");
                System.out.println(repositorioFuncionario.listarFucionarios());
                menu();
                break;
        }




    }
    public static void subMenuCliente(){
        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("==== S & I Markets (MENU CLIENTE) =========");
        System.out.println("===========================================");
        System.out.println("===========================================");

        System.out.println("1 - INSERIR CLIENTE ");
        System.out.println("2 - REMOVE CLIENTE ");
        System.out.println("3 - LISTAR CLIENTE");
        System.out.println("4 - MODIFICAR CLIENTE");
        System.out.println("88 - SAIR !!!");

        Scanner entradaOpcao = new Scanner (System.in);

        System.out.print("Digite sua opcao :  \t");
        int opcao = entradaOpcao.nextInt();

        Scanner entradaNomeCliente = new Scanner(System.in);
        Scanner entradaCpfCliente = new Scanner(System.in);
        Scanner entradargCliente = new Scanner(System.in);
        Scanner entradaEndereco = new Scanner(System.in);
        Scanner entradaTelefone = new Scanner(System.in);


        String nome;
        String cpf;
        String rg;
        String telefone;


        switch (opcao)
        {
            case 1:

                ValidaDados ValidaDados = new ValidaDados();



                    System.out.print("Digite o Nome do Cliente: \t");
                    nome = entradaNomeCliente.nextLine();
                do{
                    System.out.print("Digite o CPF do Cliente: \t");
                    cpf = entradaCpfCliente.nextLine();
                    if (ValidaDados.isCPF(cpf) != true)
                    {
                        System.out.println("CPF INVÁLIDO!!! DIGITE NOVAMENTE!");
                    }
                }while (ValidaDados.isCPF(cpf) != true);

                    System.out.print("Digite o RG do Cliente: \t");
                    rg = entradargCliente.nextLine();
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
                    System.out.print("Digite o Telefone: \t");
                    telefone = entradaTelefone.nextLine();
                    System.out.print("Digite o E-Mail: \t");
                    String email = entradaEndereco.nextLine();

                    Endereco enderecoSalvar = new Endereco(rua, numero, bairro, cidade, cep, uf);

                    Cliente cliente = new Cliente(nome, rg, cpf, enderecoSalvar, telefone, email);
                    repositorioCliente.adicionarPessoa(cliente);


                break;




            case 2:

                System.out.println("Digite o CPF do Cliente a Ser Removido: \t");
                String cpfCliente = entradaCpfCliente.nextLine();
                repositorioCliente.removerPessoaCpf(cpfCliente);
                menu();
                break;

            case 3:
                System.out.println("==========================================");
                System.out.println("==========================================");
                System.out.println("========== LISTA DE CLIENTES =============");
                System.out.println("==========================================");
                System.out.println("==========================================");
                System.out.println(repositorioCliente.listarClientes());
                menu();
                break;
        }




    }
    public static void subMenuCaixa(){
        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("======= S & I Markets (MENU  VENDA) =======");
        System.out.println("===========================================");
        System.out.println("===========================================");

        int opcao;
        Scanner entradaOpcao = new Scanner(System.in);

        System.out.println("1 - REALIZAR VENDA");
        System.out.println("2 - CONSULTAR PRECO");
        System.out.println("3 - CANCELAR VENDA ");
        System.out.println("88 - SAIR");
        System.out.println("Insira a opcao desejada : \t");
        opcao = entradaOpcao.nextInt();

        String codigo = "0";
        double quantidade;
        double valor;

        Scanner entradaValor = new Scanner(System.in);
        Scanner entradaCodigo = new Scanner(System.in);
        Scanner entradaQuantidade = new Scanner(System.in);

        switch (opcao){
            case 1:
                Carrinho carrinho = new Carrinho(getUsuario());
                do{
                    System.out.println(" (0) para finalizar Venda (1) Modificar Quantidade (2) Remover Produto ");
                    System.out.print("Codigo do produto ou Opcao desejada: \t");
                    codigo = entradaCodigo.next();
                    switch (codigo.toCharArray()[0]){
                        case '0':
                            break;
                        case '1':
                            System.out.println("Modificacao de Quantidade");
                            System.out.print("Insira o Codigo : \t");
                            codigo = entradaQuantidade.next();
                            System.out.print("Insira a quantidade : \t");
                            quantidade = entradaQuantidade.nextDouble();
                            ProdutoVenda produtoVenda = carrinho.buscarProduto(codigo);
                            if(produtoVenda != null){
                                produtoVenda.setQuantidade(quantidade);
                            }
                            break;
                        case '2':
                            System.out.println("Remover Produto!!!");
                            System.out.print("Insira o Codigo : \t");
                            codigo = entradaQuantidade.next();
                            carrinho.removerItem(codigo);
                            break;
                        default:
                            Produto produto = repositorioProduto.buscarPorCodBarra(codigo);
                            if (produto != null){
                                System.out.print("Insira a quantidade : \t");
                                quantidade = entradaQuantidade.nextDouble();

                                carrinho.adicionarItem(produto,quantidade);
                            }
                            break;
                    }
                    System.out.println("===========================================");
                    System.out.println(carrinho.listarItens());
                    System.out.println("===========================================");

                }while(!codigo.equals("0"));

                do {
                    System.out.print("Insira o valor recebido : \t");
                    valor = entradaValor.nextDouble();
                    if(valor>=carrinho.getValorTotal()){
                        System.out.println("Obrigado Pela Preferencia!!!");
                        System.out.printf("Troco : RS %.2f\n",(valor-carrinho.getValorTotal()));
                        vendas.adicionarVenda(carrinho);
                    }
                }while(valor < carrinho.getValorTotal());
                subMenuCaixa();
                break;
            case 88:
                menu();
                break;
        }
    }
    public static Funcionario getUsuario(){
        return usuario;
    }
    public static void setUsuario(Funcionario funcionario){
        usuario = funcionario;
    }
    public static void iniciarCadastroPadrao(){

        Endereco endereco = new Endereco("RUA MELO PEIXOTO","12","BOA VISTA","GARANHUNS","55293-190","PE");
        Endereco enderecoAssociado = new Endereco("RUA SÂO JOSÉ","375","CENTRO","GARANHUNS","55293-340","PE");
        Cliente cliente = new Cliente("BENEVENUTO DACIOLO FONSECA DOS SANTOS","0000000","196.861.118-59",endereco,"(87)9999-9999","");
        Secao secao = new Secao(1,"BEBIDAS");
        Produto produto = new Produto("7894900010015","COCA COLA 350ML",1.49,2.49,secao);
        Fornecedor fornecedor = new Fornecedor(1,"DISTR. CESAR",endereco);
        Funcionario funcionario = new Funcionario("ADMIN","0000001","07068093868",endereco,true,"ADMIN","1234");
        Funcionario associado = new Funcionario("Jair Messias Bolsonaro", "8579645", "45317828791", enderecoAssociado, false, "BOZO", "123456");
        NotaFiscal nota = new NotaFiscal(1,1,new Data(23,10,2018),fornecedor);

        nota.adicionarProduto(produto,1.55,1);
        estoque.adicionarProduto(produto);
        estoque.incrementar(nota);
        repositorioCliente.adicionarPessoa(cliente);
        fornecedores.adicionarFornecedor(fornecedor);
        repositorioFuncionario.adicionarPessoa(funcionario);
        repositorioFuncionario.adicionarPessoa(associado);
        notas.adicionarNotas(nota);
        repositorioProduto.adicionarProduto(produto);
        repositorioSecao.addSecao(secao);
    }
}
