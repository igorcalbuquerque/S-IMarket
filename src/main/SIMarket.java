/**
 *
 *
 *
 * @author Saú Cesar e Igor Albuquerque
 */
package main;

import dados.*;
import entidades.*;
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

        login();

    }
    public static void login() {

        String login;
        String senha;
        Funcionario usuario;

        do{

            login = SolicitaDados.solicitarString("O LOGIN");
            senha = SolicitaDados.solicitarString("A SENHA");

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
        }while ((usuario == null) || !(usuario.getSenha().equals(senha)));

        if (usuario.isGerente()) {
            menu();
        }
        else {
            menuAssociado();
        }

        setUsuario(usuario);
    }
    public static void menuAssociado() {

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

            opcao = SolicitaDados.solicitaOpcao();

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
                    login();
                    break;
            }

        } while (opcao != 88);
    }
    public static void menu(){

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
            System.out.println("7 - FORNECEDOR");
            System.out.println("8 - RELATORIO DE VENDAS");
            System.out.println("88 - SAIR !!!");

            opcao = SolicitaDados.solicitaOpcao();

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

                case 7:

                    subMenuFornecedor();
                    break;

                case 8:

                    relatorioDeVendas();
                    break;
            }

        }while (opcao != 88);
    }
    public static void subMenuEstoque(){

        int opcao;

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
            System.out.println("7 - EXCLUIR NOTA");
            System.out.println("88 - SAIR");

            opcao = SolicitaDados.solicitaOpcao();


            Scanner entradaFornecedor = new Scanner(System.in);
            Scanner entradaNumero = new Scanner(System.in);

            Data dataEmissao;
            int codigoFornecedor;
            Fornecedor fornecedor;
            Data dataEntrada;

            switch (opcao){

                case 1:

                    Scanner entradaSerie = new Scanner(System.in);

                    System.out.print("NUMERO DA NOTA : \t");
                    int numero = entradaNumero.nextInt();

                    System.out.print("SERIE : \t");
                    int serie = entradaSerie.nextInt();

                    System.out.println("DATA DE EMISSAO");
                    dataEmissao = SolicitaDados.solicitarData();

                    do{
                        System.out.print("CODIGO FORNECEDOR : \t");
                        codigoFornecedor = entradaFornecedor.nextInt();

                        fornecedor = fornecedores.buscarFornecedor(codigoFornecedor);

                        if(fornecedor==null){
                            System.out.println("CODIGO DE FORNECEDOR INVALIDO!!!");
                        }

                    }while (fornecedor==null);

                    NotaFiscal nota = new NotaFiscal(numero,serie,dataEmissao,fornecedor);

                    int codigoProduto;
                    Produto produto;
                    double valorCompra;
                    double quantidade;

                    Scanner entradaQuantidade = new Scanner(System.in);
                    Scanner entradaValorCompra = new Scanner(System.in);

                    do{

                        codigoProduto = SolicitaDados.solicitarInt("CODIGO DO PRODUTO");

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

                        System.out.println("DIGITE (1) PARA ADICIONAR PRODUTO (88)PARA FECHAR NOTA");
                        opcao = SolicitaDados.solicitaOpcao();

                    }while(opcao != 88);

                    estoque.incrementar(nota);
                    notas.adicionarNotas(nota);

                    subMenuEstoque();
                    break;

                case 2:

                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR DATA EMISSAO) ======");
                    System.out.println("===========================================");

                    System.out.println("DATA DE EMISSAO");
                    dataEmissao = SolicitaDados.solicitarData();

                    System.out.println(notas.listarNotasPorEmissao(dataEmissao));
                    break;

                case 3:
                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR DATA ENTRADA) ======");
                    System.out.println("===========================================");

                    System.out.println("DATA DE ENTRADA");
                    dataEntrada = SolicitaDados.solicitarData();

                    System.out.println(notas.listarNotasPorEntrada(dataEntrada));
                    subMenuEstoque();
                    break;
                case 4:

                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR NUMERO) ======");
                    System.out.println("===========================================");

                    System.out.println("Insira o Numero : ");
                    int num = entradaNumero.nextInt();

                    System.out.println(notas.listarNotasPorNumero(num));
                    subMenuEstoque();
                    break;

                case 5:

                    System.out.println("===========================================");
                    System.out.println("===== LISTAR NOTAS(POR FORNECEDOR) ======");
                    System.out.println("===========================================");

                    codigoFornecedor = SolicitaDados.solicitarInt("CODIGO DO FORNECEDOR");

                    System.out.println(notas.listarNotas(codigoFornecedor));

                    subMenuEstoque();
                    break;

                case 6:
                    System.out.println(estoque.listarEstoque());
                    subMenuEstoque();
                    break;

                case 7:

                    System.out.println("===========================================");
                    System.out.println("========== EXCLUIR NOTA FISCAL ============");
                    System.out.println("===========================================");

                    numero = SolicitaDados.solicitarInt("NUMERO DA NOTA");
                    codigoFornecedor = SolicitaDados.solicitarInt("CODIGO NO FORNECEDOR (DIGITE(88) PARA CANCELAR)");

                    if(numero!=88){

                        nota = notas.buscarNota(numero,codigoFornecedor);
                        if (nota!=null){
                            estoque.decrementar(nota);
                        }
                        notas.removerNota(numero,codigoFornecedor);

                    }else{
                        System.out.println("========= OPERACAO CANCELADA!! ============");
                    }

                    subMenuEstoque();
                    break;
                default:

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
                System.out.println("===========================================");
                System.out.println("============ CADASTRAR SECAO===============");
                System.out.println("===========================================");

                String descricaoSecao = SolicitaDados.solicitaNome();

                System.out.print("\nDeseja gerar codigo Automaticamente? (1)SIM (2)NAO \t");
                int opcaoCodigo =  SolicitaDados.solicitaOpcao();

                Secao novaSecao;

                switch (opcaoCodigo){
                    case 1:
                        novaSecao = new Secao(descricaoSecao);
                        repositorioSecao.addSecao(novaSecao);
                        System.out.println(repositorioSecao.listarSecoes());
                        break;
                    case 2:

                        int codigo = SolicitaDados.solicitarInt("CODIGO DA SECAO");

                        novaSecao = new Secao(codigo, descricaoSecao);
                        repositorioSecao.addSecao(novaSecao);
                        System.out.println(repositorioSecao.listarSecoes());

                        subMenuSecao();
                        break;
                }
                break;

            case 2:

                System.out.println("===========================================");
                System.out.println("============ REMOVER SECAO ================");
                System.out.println("===========================================");

                System.out.print("\nDigite o Codigo da Seção a ser Removida : \t");
                int codigo = SolicitaDados.solicitarInt("CODIGO DA SECAO");
                repositorioSecao.removeSecao(codigo);
                break;

            case 3:
                System.out.println("=========== SECOES CADASTRADAS =============");
                System.out.println(repositorioSecao.listarSecoes());

                subMenuSecao();
                break;

             default:
                 subMenuSecao();
                 break;
        }

    }
    public static void subMenuProduto(){

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

        int opcao = SolicitaDados.solicitaOpcao();

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

                System.out.println("Insira as informacoes Solicitadas !!!");
                System.out.print("Gerar codigo Automatico? (1)SIM (2)NAO \t");
                int opcaoCodigo = SolicitaDados.solicitaOpcao();

                switch (opcaoCodigo){

                    case 1:

                        codigoBarra = SolicitaDados.solicitarString("O CODIGO DE BARRA");
                        descricao = SolicitaDados.solicitarString("A DESCRICAO");

                        valorCompra = SolicitaDados.solicitarDouble("VALOR DE COMPRA");
                        valorVenda = SolicitaDados.solicitarDouble("VALOR DE VENDA");

                        codigoSecao = SolicitaDados.solicitarInt("CODIGO DA SECAO");
                        secao = repositorioSecao.buscarSecao(codigoSecao);

                        produto = new Produto(codigoBarra,descricao,valorCompra,valorVenda,secao);

                        repositorioProduto.adicionarProduto(produto);
                        estoque.adicionarProduto(produto);

                        break;

                    case 2:

                        codigoProduto = SolicitaDados.solicitarInt("CODIGO DO PRODUTO");
                        codigoBarra = SolicitaDados.solicitarString("CODIGO DE BARRA");
                        descricao =  SolicitaDados.solicitarString("A DESCRICAO");;
                        valorCompra = SolicitaDados.solicitarDouble("VALOR COMPRA");
                        valorVenda = SolicitaDados.solicitarDouble("VALOR VENDA");

                        do{

                            codigoSecao = SolicitaDados.solicitarInt("CODIGO DA SECAO");

                            secao = repositorioSecao.buscarSecao(codigoSecao);
                            if (secao==null){
                                System.out.println("INSIRA UMA SECAO VALIDA");
                            }

                        }while (secao==null);

                        produto = new Produto(codigoProduto,codigoBarra,descricao,valorCompra,valorVenda,secao);
                        repositorioProduto.adicionarProduto(produto);
                        estoque.adicionarProduto(produto);
                        break;
                }
                subMenuProduto();
                break;

            case 2:

                codigoProduto = SolicitaDados.solicitarInt("CODIGO DO PRODUTO");

                repositorioProduto.removerProduto(codigoProduto);
                estoque.removerProduto(codigoProduto);

                subMenuProduto();
                break;

            case 3:

                System.out.println(repositorioProduto.listarProdutos());

                subMenuProduto();
                break;

            case 4:

                codigoProduto = SolicitaDados.solicitarInt("CODIGO DO PRODUTO");
                produto = repositorioProduto.buscarProduto(codigoProduto);

                if(produto!=null){

                    System.out.println("========== INFORMACAO ATUAL ============");
                    System.out.println(produto.toString());

                    System.out.println("1 - MODIFICAR CODIGO ");
                    System.out.println("2 - MODIFICAR DESCRICAO");
                    System.out.println("3 - MODIFICAR VALOR COMPRA");
                    System.out.println("4 - MODIFICAR VALOR VENDA");
                    System.out.println("5 - MODIFICAR SECAO ");
                    System.out.println("6 - MODIFICAR CODIGO BARRA ");
                    System.out.println("88 - SAIR !!!");

                    opcaoModificacao = SolicitaDados.solicitaOpcao();

                    switch (opcaoModificacao){
                        case 1:

                            System.out.println("============== ALTERAR CODIGO ==============");

                            codigoProduto = SolicitaDados.solicitarInt("NOVO CODIGO");
                            if(repositorioProduto.buscarProduto(codigoProduto)==null){

                                produto.setCodigoProduto(codigoProduto);
                                System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");

                            }else {
                                System.out.println("=========== O CODIGO JA EXISTE!!! ==========");
                            }

                            subMenuProduto();
                            break;

                        case 2:

                            System.out.println("============= ALTERAR DESCRICAO ============");

                            descricao = SolicitaDados.solicitarString("A DESCRICAO");

                            produto.setDescricao(descricao);
                            System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");

                            subMenuProduto();
                            break;
                        case 3:

                            System.out.println("========== ALTERAR VALOR COMPRA ============");

                            valorCompra = SolicitaDados.solicitarDouble("VALOR DE COMPRA");

                            produto.setValorCompra(valorCompra);
                            System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");

                            subMenuProduto();
                            break;

                        case 4:

                            System.out.println("=========== ALTERAR VALOR VENDA ============");

                            valorVenda= SolicitaDados.solicitarDouble("VALOR DE VENDA");

                            produto.setValorVenda(valorVenda);
                            System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");

                            subMenuProduto();
                            break;
                        case 5:

                            System.out.println("============== ALTERAR SECAO ===============");

                            codigoSecao= SolicitaDados.solicitarInt("CODIGO DA SECAO");

                            secao = repositorioSecao.buscarSecao(codigoSecao);

                            if (secao != null){
                                produto.setSecao(secao);
                                System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");
                            }

                            subMenuProduto();
                            break;

                        case 6:

                            System.out.println("============ ALTERAR CODIGO BARRA =============");

                            codigoBarra= SolicitaDados.solicitarString("O CODIGO DE BARRA");

                            produto = repositorioProduto.buscarPorCodBarra(codigoBarra);

                            if (produto != null){
                                produto.setCodigoBarra(codigoBarra);
                                System.out.println("=== INFORMACAO ATUALIZADA COM SUCESSO!!! ===");
                            }else{
                                System.out.println("=== CODIGO INFORMADO JA EXISTE!!! ===");
                            }

                            subMenuProduto();
                            break;


                        default:

                            menu();
                            break;
                    }
                }

                subMenuProduto();
                break;

             default:

                 menu();
                 break;
        }

    }
    public static void subMenuFornecedor(){

        System.out.println("===========================================");
        System.out.println("=== S & I Markets (MENU  FORNECEDORES) ====");
        System.out.println("===========================================");

        System.out.println("1 - CADASTRAR ");
        System.out.println("2 - REMOVER POR CODIGO");
        System.out.println("3 - REMOVER POR CNPJ");
        System.out.println("4 - MODIFICAR ");
        System.out.println("5 - LISTAR TODOS ");
        System.out.println("88 - SAIR !!!");

        int opcao = SolicitaDados.solicitaOpcao();

        int codigo;
        String nome;
        String cnpj;
        Endereco endereco;
        Fornecedor fornecedor;

        do{
            switch (opcao){

                case 1:

                    System.out.println("=========== CADASTRAR FORNECEDOR ==========");

                    codigo = SolicitaDados.solicitarInt("CODIGO");
                    nome = SolicitaDados.solicitaNome();
                    cnpj = SolicitaDados.solicitarString("O CNPJ");
                    endereco = SolicitaDados.solicitaEndereco();

                    fornecedor = new Fornecedor(codigo,nome,cnpj,endereco);
                    fornecedores.adicionarFornecedor(fornecedor);
                    subMenuFornecedor();
                    break;

                case 2:
                    System.out.println("=========== REMOVER FORNECEDOR ==========");
                    codigo = SolicitaDados.solicitarInt("CODIGO");

                    fornecedores.removerFornecedor(codigo);

                    subMenuFornecedor();
                    break;

                case 3:

                    System.out.println("=========== REMOVER FORNECEDOR ==========");
                    cnpj = SolicitaDados.solicitarString("O CNPJ");

                    fornecedores.removerFornecedor(cnpj);

                    subMenuFornecedor();
                    break;

                case 4:

                    System.out.println("===========================================");
                    System.out.println("=========== MODIFICAR FORNECEDOR ==========");
                    System.out.println("===========================================");

                    do{

                        codigo = SolicitaDados.solicitarInt("CODIGO DO FORNECEDOR ");
                        fornecedor = fornecedores.buscarFornecedor(codigo);
                        if (fornecedor==null){
                            System.out.println("====== INSIRA UM FORNECEDOR VALIDO ========");
                        }

                    }while(fornecedor==null);

                    System.out.println("1 - MODIFICAR CODIGO ");
                    System.out.println("2 - MODIFICAR NOME");
                    System.out.println("3 - MODIFICAR CNPJ ");
                    System.out.println("4 - MODIFICAR ENDERECO ");
                    System.out.println("88 - SAIR !!!");

                    opcao = SolicitaDados.solicitaOpcao();

                    switch (opcao){

                        case 1:

                            System.out.println("=========== MODIFICAR CODIGO ==========");
                            codigo = SolicitaDados.solicitarInt("NOVO CODIGO");

                            Fornecedor f = fornecedores.buscarFornecedor(codigo);
                            if(f == null){
                                fornecedor.setCodigo(codigo);
                                System.out.println("====== INFORMACAO ATUALIZADA!!! =======");
                            }

                            subMenuFornecedor();
                            break;

                        case 2:

                            System.out.println("=========== MODIFICAR NOME ==========");
                            nome = SolicitaDados.solicitarString("O NOVO NOME");

                            fornecedor.setNome(nome);
                            System.out.println("====== INFORMACAO ATUALIZADA!!! =======");

                            subMenuFornecedor();
                            break;

                        case 3:

                            System.out.println("=========== MODIFICAR CNPJ ============");
                            cnpj = SolicitaDados.solicitarString("O NOVO CNPJ");

                            Fornecedor forn = fornecedores.buscarFornecedor(cnpj);
                            if(forn == null){
                                fornecedor.setCnpj(cnpj);
                                System.out.println("====== INFORMACAO ATUALIZADA!!! =======");
                            }

                            subMenuFornecedor();
                            break;

                        case 4:

                            System.out.println("=========== MODIFICAR ENDERECO ============");

                            endereco = SolicitaDados.solicitaEndereco();
                            fornecedor.setEndereco(endereco);

                            System.out.println("====== INFORMACAO ATUALIZADA!!! =======");

                            subMenuFornecedor();
                            break;

                        default:

                            subMenuFornecedor();
                            break;
                    }

                    break;
                case 5:

                    System.out.println("========= LISTAR FORNECEDORES ==========");
                    System.out.println(fornecedores.listarFornecedores());


                    break;

                default:

                    subMenuFornecedor();
                    break;
            }

        }while (opcao != 88);

        menu();
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

        int opcao = SolicitaDados.solicitaOpcao();

        String nome;
        String cpf;
        String rg;
        Endereco endereco;
        String login;
        String senha;

        switch (opcao)
        {

            case 1:

                nome = SolicitaDados.solicitaNome();
                cpf = SolicitaDados.solicitaCpf();
                rg = SolicitaDados.solicitaRg();
                endereco = SolicitaDados.solicitaEndereco();
                login = SolicitaDados.solicitaLogin();
                senha = SolicitaDados.solicitaSenha();

                Funcionario funcionario;

                if(login.equals("")){
                    funcionario = new Funcionario(nome, rg, cpf, endereco, false, senha);
                }else{
                    funcionario = new Funcionario(nome, rg, cpf, endereco, false, login,senha);
                }

                repositorioFuncionario.adicionarPessoa(funcionario);

                subMenuFuncionario();
                break;

            case 2:

                System.out.println("==========================================");
                System.out.println("=========== REMOVER FUNCIONÁRIO ==========");
                System.out.println("==========================================");

                String cpfFuncionario = SolicitaDados.solicitaCpf();

                repositorioFuncionario.removerPessoaCpf(cpfFuncionario);

                subMenuFuncionario();
                break;

            case 3:

                System.out.println("==========================================");
                System.out.println("==========================================");
                System.out.println("========== LISTA DE FUNCIONÁRIOS =========");
                System.out.println("==========================================");
                System.out.println("==========================================");

                System.out.println(repositorioFuncionario.listarFucionarios());

                subMenuFuncionario();
                break;

            case 4:

                Funcionario func = null;
                String cpfBuscado;

                do{
                    System.out.println("==========================================");
                    System.out.println("=== MODIFICAR DADOS DE FUNCIONÁRIOS ======");
                    System.out.println("==========================================");
                    System.out.println("DIGITE 0 PARA SAIR)");
                    cpfBuscado = SolicitaDados.solicitaCpf();

                    if(cpfBuscado.equals("0")){
                        break;
                    }else{
                        func = (Funcionario) repositorioFuncionario.buscarPessoaPorCpf(cpfBuscado);
                        if(func == null){
                            System.out.println("CPF BUSCADO NAO EXISTE!!!");
                        }
                    }

                }while(func == null || !cpfBuscado.equals("0"));

                if(func!=null){

                    System.out.println("====================================================");
                    System.out.println(" 1 - MODIFICAR NOME");
                    System.out.println(" 2 - MODIFICAR CPF");
                    System.out.println(" 3 - MODIFICAR RG");
                    System.out.println(" 4 - MODIFICAR LOGIN");
                    System.out.println(" 5 - MODIFICAR SENHA");
                    System.out.println(" 6 - MODIFICAR ENDERECO");
                    System.out.println(" 7 - PARA CANCELAR A QUALQUER MOMENTO");
                    opcao = SolicitaDados.solicitaOpcao();
                    System.out.println("====================================================");

                    switch (opcao){

                        case 1:

                            nome = SolicitaDados.solicitaNome();

                            if(!nome.equals("7")){

                                func.setNome(nome);
                                System.out.println("======= NOME MODIFICADO COM SUCESSO!!! =======");

                            }else{

                                System.out.println("=============== CANCELADO !!! ================");

                            }

                            subMenuFuncionario();
                            break;

                        case 2:

                            cpf = SolicitaDados.solicitaCpf();

                            if(!cpf.equals("7")){

                                func.setCpf(cpf);
                                System.out.println("======= CPF MODIFICADO COM SUCESSO!!! ========");

                            }else{

                                System.out.println("=============== CANCELADO !!! ================");

                            }
                            subMenuFuncionario();
                            break;

                        case 3:

                            rg = SolicitaDados.solicitaNome();

                            if(!rg.equals("7")){

                                func.setRg(rg);
                                System.out.println("======== RG MODIFICADO COM SUCESSO!!! ========");

                            }else{

                                System.out.println("=============== CANCELADO !!! ================");

                            }
                            subMenuFuncionario();
                            break;

                        case 4:

                            System.out.println("================ OPCIONAL ====================");
                            login = SolicitaDados.solicitaLogin();

                            if(!login.equals("7")){

                                func.setLogin(login);
                                System.out.println("====== LOGIN MODIFICADO COM SUCESSO!!! =======");

                            }else{

                                System.out.println("=============== CANCELADO !!! ================");

                            }
                            subMenuFuncionario();
                            break;

                        case 5:

                            senha = SolicitaDados.solicitaSenha();

                            if(!senha.equals("7")){

                                func.setSenha(senha);
                                System.out.println("====== SENHA MODIFICADA COM SUCESSO!!! =======");

                            }else{

                                System.out.println("=============== CANCELADO !!! ================");

                            }

                            subMenuFuncionario();
                            break;

                        case 6:

                            endereco = SolicitaDados.solicitaEndereco();
                            func.setEndereco(endereco);

                            System.out.println("==== ENDERECO MODIFICADA COM SUCESSO!!! ======");

                            subMenuFuncionario();
                            break;

                        default:

                            subMenuFuncionario();
                            break;
                    }
                }
            case 88:
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

        int opcao = SolicitaDados.solicitaOpcao();

        Scanner entradaTelefone = new Scanner(System.in);
        Scanner entradaEmail = new Scanner(System.in);


        String nome;
        String cpf;
        String rg;
        String telefone;
        String email;
        Endereco endereco;
        Cliente cliente;

        switch (opcao)
        {
            case 1:

                nome = SolicitaDados.solicitaNome();

                do{
                    cpf = SolicitaDados.solicitaCpf();

                    cliente = (Cliente)repositorioCliente.buscarPessoaPorCpf(cpf);

                    if(cliente!=null){
                        System.out.println("====== O CPF INFORMADO JA EXISTE!!! =======");
                    }

                }while (cliente!=null);


                do{
                    rg = SolicitaDados.solicitaRg();

                    cliente = (Cliente)repositorioCliente.buscarPessoaPorRg(rg);

                    if(cliente!=null){
                        System.out.println("====== O RG INFORMADO JA EXISTE!!! =======");
                    }

                }while (cliente!=null);

                endereco = SolicitaDados.solicitaEndereco();

                System.out.println("Digite o Telefone: \t");
                telefone = entradaTelefone.nextLine();

                System.out.println("Digite o EMAIL: \t");
                email = entradaEmail.nextLine();

                cliente = new Cliente(nome,rg,cpf,endereco,telefone,email);
                repositorioCliente.adicionarPessoa(cliente);

                break;




            case 2:

                System.out.println("==========================================");
                System.out.println("=========== REMOVER CLIENTE ==============");
                System.out.println("==========================================");

                String cpfCliente = SolicitaDados.solicitaCpf();

                repositorioCliente.removerPessoaCpf(cpfCliente);

                subMenuCliente();
                break;

            case 3:

                System.out.println("==========================================");
                System.out.println("========== LISTA DE CLIENTES =============");
                System.out.println("==========================================");

                System.out.println(repositorioCliente.listarClientes());

                subMenuCliente();
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

        System.out.println("1 - REALIZAR VENDA");
        System.out.println("2 - CONSULTAR PRECO");
        System.out.println("3 - CANCELAR VENDA ");
        System.out.println("88 - SAIR");
        opcao = SolicitaDados.solicitaOpcao();

        String codigo;
        double quantidade;
        double valorPago;

        switch (opcao){

            case 1:

                Carrinho carrinho = new Carrinho(getUsuario());

                do{

                    System.out.println(" (A) PARA FINALIZAR VENDA (B) MODIFICAR QUANTIDADE (C) REMOVER PRODUTO");
                    System.out.println("(D)ATRIBUIR CLIENTE (E) REMOVER CLIENTE ");

                    codigo = SolicitaDados.solicitarString("O CODIGO BARRA OU OPCAO DESEJADA");

                    switch (codigo.toCharArray()[0]){

                        case 'A':
                            break;

                        case 'B':

                            System.out.println("========= MODIFICAR QUANTIDADE ============");

                            codigo = SolicitaDados.solicitarString("O CODIGO");

                            quantidade = SolicitaDados.solicitarDouble(" QUANTIDADE ");
                            ProdutoVenda produtoVenda = carrinho.buscarProduto(codigo);

                            if(produtoVenda != null){
                                produtoVenda.setQuantidade(quantidade);
                            }

                            break;

                        case 'C':

                            System.out.println("========== REMOVER PRODUTO ================");
                            codigo = SolicitaDados.solicitarString("O CODIGO DO PRODUTO");
                            carrinho.removerItem(codigo);

                            break;

                        case 'D':

                            System.out.println("=========== ATRIBIUR CLIENTE ==============");
                            String cpf = SolicitaDados.solicitaCpf();
                            Cliente cliente = (Cliente) clientes.buscarPessoaPorCpf(cpf);
                            if(cliente!=null){
                                carrinho.atribuirCliente(cliente);
                            }

                            break;

                        case 'E':

                            carrinho.removerCliente();
                            System.out.println("=========== CLIENTE REMOVIDO ==============");

                            break;

                        default:

                            Produto produto = repositorioProduto.buscarPorCodBarra(codigo);

                            if (produto != null){

                                quantidade = SolicitaDados.solicitarDouble("QUATIDADE");
                                carrinho.adicionarItem(produto,quantidade);

                            }

                            break;
                    }

                    System.out.println("===========================================");
                    System.out.println(carrinho.listarItens());
                    System.out.println("===========================================");

                }while(!codigo.equals("A"));

                do {

                    valorPago = SolicitaDados.solicitarDouble("VALOR RECEBIDO");

                    if(valorPago<carrinho.getValorTotal()){
                        System.out.println("======== VALOR INSUFICIENTE!!! ========");
                    }

                }while(valorPago < carrinho.getValorTotal());

                System.out.println("======== OBRIGADO PELA PREFERENCIA!!! =========");
                System.out.printf("TROCO : RS %.2f\n",(valorPago-carrinho.getValorTotal()));

                vendas.adicionarVenda(carrinho);
                estoque.decrementar(carrinho);

                subMenuCaixa();
                break;
            case 2:

                System.out.println("===========================================");
                System.out.println("============ CONSULTAR PRECO  =============");
                System.out.println("===========================================");

               do{

                   codigo = SolicitaDados.solicitarString("O CODIGO DE BARRA(DIGITE (S) PARA SAIR)");
                   if(codigo.equals("S") ){
                       break;
                   }else{

                       Produto produto = repositorioProduto.buscarPorCodBarra(codigo);

                       if(produto!=null){
                           System.out.println(produto.toString());
                       }
                   }
               }while (!codigo.equals("S"));

                subMenuCaixa();
                break;

            case 3:

                System.out.println("===========================================");
                System.out.println("============= CANCELAR VENDA  =============");
                System.out.println("===========================================");

                int numero = SolicitaDados.solicitarInt("CODIGO DA VENDA");

                vendas.removerVenda(numero);

                Carrinho venda = vendas.buscarCarrinho(numero);

                if(venda !=null){
                    estoque.incrementar(venda);
                }

                subMenuCaixa();
                break;

            case 88:

                menu();
                break;
        }
    }
    public static void relatorioDeVendas(){

        System.out.println("===========================================");
        System.out.println("========== RELATORIOS DE VENDA ============");
        System.out.println("===========================================");

        System.out.println("1 - VENDA POR PERIODO");
        System.out.println("2 - VENDA POR FUNCIONARIO");
        System.out.println("4 - VENDA POR PRODUTO");
        System.out.println("5 - VENDA POR CLIENTE");
        System.out.println("88 - SAIR !!!");

        int opcao = SolicitaDados.solicitaOpcao();
        int codigo;
        Secao secao;
        String cpf;
        Produto produto;
        Cliente cliente;
        Funcionario funcionario;
        Data dataInicial;
        Data dataFinal;

        switch (opcao){

            case 1:

                System.out.println("=========== VENDA POR PERIODO =============");

                System.out.println("DATA INICIAL");
                dataInicial = SolicitaDados.solicitarData();

                System.out.println("DATA FINAL");
                dataFinal = SolicitaDados.solicitarData();

                System.out.println("===========================================");
                System.out.println(vendas.relatorioVenda(dataInicial,dataFinal));
                System.out.println("===========================================");

                relatorioDeVendas();
                break;

            case 2:

                System.out.println("========= VENDA POR FUNCIONARIO ===========");

                cpf = SolicitaDados.solicitarString("O CPF DO FUNCIONARIO");
                funcionario = (Funcionario) repositorioFuncionario.buscarPessoaPorCpf(cpf);

                if(funcionario!=null){

                    System.out.println("DATA INICIAL");
                    dataInicial = SolicitaDados.solicitarData();

                    System.out.println("DATA FINAL");
                    dataFinal = SolicitaDados.solicitarData();

                    System.out.println("===========================================");
                    System.out.println(vendas.relatorioVenda(funcionario,dataInicial,dataFinal));
                    System.out.println("===========================================");

                }else{
                    System.out.println("========= FUNCIONARIO NAO ENCOTRADO ===========");

                }

                relatorioDeVendas();
                break;

            case 3:
                System.out.println("========= VENDA POR SECAO ===========");

                codigo = SolicitaDados.solicitarInt("CODIGO DA SECAO");
                secao = repositorioSecao.buscarSecao(codigo);

                if(secao!=null){

                    System.out.println("DATA INICIAL");
                    dataInicial = SolicitaDados.solicitarData();

                    System.out.println("DATA FINAL");
                    dataFinal = SolicitaDados.solicitarData();

                    System.out.println("===========================================");
                    System.out.println(vendas.relatorioVenda(secao,dataInicial,dataFinal));
                    System.out.println("===========================================");

                }else{
                    System.out.println("========= SECAO NAO ENCONTRADA ===========");

                }

                relatorioDeVendas();
                break;

            case 4:

                System.out.println("============ VENDA POR PRODUTO =============");

                codigo = SolicitaDados.solicitarInt("CODIGO DO PRODUTO");
                produto = repositorioProduto.buscarProduto(codigo);

                if(produto!=null){

                    System.out.println("DATA INICIAL");
                    dataInicial = SolicitaDados.solicitarData();

                    System.out.println("DATA FINAL");
                    dataFinal = SolicitaDados.solicitarData();

                    System.out.println("===========================================");
                    System.out.println(vendas.relatorioVenda(produto,dataInicial,dataFinal));
                    System.out.println("===========================================");

                }else{
                    System.out.println("============ PRODUTO  NAO ENCONTRADO =============");
                }
                relatorioDeVendas();
                break;

            case 5:

                System.out.println("============= VENDA POR CLIENTE ==============");

                cpf = SolicitaDados.solicitarString("O CPF DO CLIENTE");
                cliente = (Cliente) repositorioCliente.buscarPessoaPorCpf(cpf);

                if(cliente!=null){

                    System.out.println("DATA INICIAL");
                    dataInicial = SolicitaDados.solicitarData();

                    System.out.println("DATA FINAL");
                    dataFinal = SolicitaDados.solicitarData();

                    System.out.println("===========================================");
                    System.out.println(vendas.relatorioVenda(cliente,dataInicial,dataFinal));
                    System.out.println("===========================================");

                }else{
                    System.out.println("============= CLIENTE NAO ENCONTRADO !!! ==============");
                }

                relatorioDeVendas();
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
        Secao secao = new Secao("BEBIDAS");
        Produto produto = new Produto("7894900010015","COCA COLA 350ML",1.49,2.49,secao);
        Fornecedor fornecedor = new Fornecedor(1,"DISTR. CESAR","123.123.124/0012",endereco);
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
