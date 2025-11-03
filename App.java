import classes.Cliente;
import classes.Funcionario;
import classes.Produto;
import controllers.ClienteController;
import controllers.ProdutoController;

import java.util.*;

public class App {
    private ClienteController clienteController;
    private ProdutoController produtoController;

    public App(ClienteController clienteController, ProdutoController produtoController) {
        this.clienteController = clienteController;
        this.produtoController = produtoController;
    }

    public String iniciar(Scanner scanner){
        //Começo do software
        System.out.println("--- DIGITE O TIPO DE USUÁRIO ---");
        System.out.println("1. Cliente");
        System.out.println("2. Funcionário");
        System.out.print("Qual seu tipo de usuário: ");
        String usuario = scanner.nextLine();

        return usuario;
    }

    public String possuiConta(Scanner scanner) {
        System.out.print("Já possui conta?(S/N): ");
        String possuiCont = scanner.nextLine();

        return possuiCont;
    }

    public static void cadastrarCliente(Scanner scanner, ClienteController clienteController) {
        System.out.print("Qual o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o seu email: ");
        String email = scanner.nextLine();

        System.out.print("Qual será sua senha: ");
        int senha = Integer.parseInt(scanner.nextLine());

        System.out.print("Qual o seu CPF: ");
        int cpf = Integer.parseInt(scanner.nextLine());

        System.out.print("Qual a sua data de nascimento: ");
        String dataNasc = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, senha, cpf, dataNasc);

        clienteController.addList(cliente);

        System.out.println(cliente);
    }

    public Cliente verificarLogin(Scanner scanner, ClienteController clienteController){
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        int senha = Integer.parseInt(scanner.nextLine());

        Cliente clienteLogado = clienteController.verificaLogin(email, senha);
        if(clienteLogado != null){
            return clienteLogado;
        } else if (clienteLogado == null && clienteController.verificaEmail(email) != null) {
            System.out.println("senha errada");
        } else if (clienteLogado == null && clienteController.verificaEmail(email) == null){
            System.out.println("email não encontrado");
        } else {
            System.out.println("Erro no sistema, tente novamente");
        }
        return null;
    }

    public String opcoesCliente(Cliente cliente, Scanner scanner){
        System.out.println("----- PIPI LOJINHAS -----");
        System.out.println("Olá " + cliente.getNome() + ", o que deseja hoje?");
        System.out.println("1. VER PRODUTOS");
        System.out.println("2. PROCURAR PRODUTO");
        System.out.println("3. ATUALIZAR MINHAS INFORMAÇÕES");
        System.out.println("4. SAIR DA CONTA");
        System.out.print("Digite o que deseja: ");

        String opcao = scanner.nextLine();
        return opcao;
    }

    public void verProdutosClientes(Scanner scanner){


        System.out.println("\n--- Produtos disponíveis ---");
        produtoController.listarProdutos();

        System.out.print("Digite o número do produto que você deseja: ");
        int produtoDesejado = Integer.parseInt(scanner.nextLine());

        Produto produtoComprar = produtoController.escolherProduto(produtoDesejado);

        System.out.printf("| %s | Quantidade que você deseja: ", produtoComprar.getNome());
        int quantiProdutoDesej = Integer.parseInt(scanner.nextLine());


        fimCompra:
        while(true){
            System.out.printf("Valor total %f reais", (quantiProdutoDesej * produtoComprar.getPrecoVenda()));
            System.out.print("Finalzar compra(S/N): ");
            String finalizar = scanner.nextLine();

            if(finalizar.equalsIgnoreCase("s")) {
                if(produtoController.darBaixa(produtoComprar, quantiProdutoDesej)) {

                    System.out.println("Compra finalizada com sucesso!");
                } else {
                    System.out.println("Falha em realizar a compra, tente novamente!");
                }

                break fimCompra;
            } else if(finalizar.equalsIgnoreCase("n")) {
                System.out.println("Compra cancelada!");
                break fimCompra;

            } else{
                System.out.println("Digite uma letra válida!");

            }
        }
    }

    public void procurarProduto(Scanner scanner, Funcionario funcionario){


        System.out.print("Qual o nome do produto: ");
        String produtoProcurado = scanner.nextLine();

        Produto produtoAchado = produtoController.procurarProduto(produtoProcurado);

        if(produtoAchado != null) {

            System.out.print("Deseja comprar este produto(S/N): ");
            String deseja = scanner.nextLine();

            if (deseja.equalsIgnoreCase("s")) {


                System.out.printf("| %s | \nQuantidade que você deseja: ", produtoController.produtoDesejado(produtoAchado));
                int quantiProdutoDesej = Integer.parseInt(scanner.nextLine());


                fimCompra:
                while (true) {
                    System.out.println("Valor total " + produtoController.valorTotal(quantiProdutoDesej, produtoAchado) + " reais");
                    System.out.print("Finalzar compra(S/N): ");
                    String finalizar = scanner.nextLine();

                    if (finalizar.equalsIgnoreCase("s")) {
                        produtoAchado.setQuantidade(produtoAchado.getQuantidade() - quantiProdutoDesej);

                        System.out.println("Compra finalizada com sucesso!");

                        break fimCompra;
                    } else if (finalizar.equalsIgnoreCase("n")) {
                        System.out.println("Compra cancelada!");
                        break fimCompra;

                    } else {
                        System.out.println("Digite uma letra válida!");

                    }
                }
            }
        }
        else {
            System.out.println("Produto não encontrado, verifique a escrita!");
        }
    }

    public Cliente mudarDados(Scanner scanner, Cliente clienteLogado){
        Cliente cliente = null;

        System.out.println("----- ATUALIZAR DADOS -----");
        System.out.println("1. Mudar email");
        System.out.println("2. Mudar senha");
        System.out.print("Qual dado vc deseja atualizar: ");
        String oqAtualizar = scanner.nextLine();

        cliente = verificarLogin(scanner, clienteController);

        if(cliente != null && cliente == clienteLogado) {
            switch (oqAtualizar) {
                case "1":

                    System.out.print("Qual seu novo email: ");
                    String emailNovo = scanner.nextLine();

                    clienteController.mudarEmail(cliente, emailNovo);
                    System.out.println("Novo email salvo com sucesso!");

                    break;
                case "2":

                    System.out.print("Qual sua nova senha: ");
                    int senhaNova = Integer.parseInt(scanner.nextLine());

                    clienteController.mudarSenha(cliente, senhaNova);
                    System.out.print("Nova senha salva com sucesso!");

                    break;
                default:
                    System.out.print("Senha errada, tente novamente!");
                    break;
            }
        }
        return cliente;
    }

    public void opcoesFuncionario(){
        System.out.println("+------------+");
        System.out.println("|Olá |");
        System.out.println("+-- OPÇÕES --+");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Modificar produto");
        System.out.println("3. Ver produtos");
        System.out.println("4. Lista de clientes");
        System.out.println("5. Procurar cliente");
        System.out.println("6. Relatório de vendas");
        System.out.println("7. Sair");
        System.out.print("Digite o que deseja: ");
    }

    public void adicionarProduto(Scanner scanner){
        System.out.print("Qual o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quanto custou o produto: ");
        float precoCus = scanner.nextFloat();

        System.out.print("Quanto será cobrado pelo produto: ");
        float precoLuc = scanner.nextFloat();

        System.out.print("Qual a quantidade do produto: ");
        int quanti = scanner.nextInt();
        scanner.nextLine();

        Produto produtoCriado = produtoController.criarProduto(nome, precoCus, precoLuc, quanti);

        produtoController.procurarProduto(nome);

        System.out.printf("Produto %s adicionado com sucesso!", nome);
    }

    public void verProdutos(){
        produtoController.verProdutos();
    }

    public void modificaProduto(Scanner scanner){
        System.out.print("Qual o nome do produto que será modificado: ");
        String nomeModificar = scanner.nextLine();

        Produto produtoModificar = produtoController.verificarExistencia(nomeModificar);

        if (produtoModificar != null){
            System.out.println("--- O QUE VOCÊ DESEJA MODIFICAR ---");
            System.out.println("1. Nome do produto");
            System.out.println("2. Custo do produto");
            System.out.println("3. Valor do produto");
            System.out.println("4. Quantidade do produto");
            System.out.println("5. Desistir");
            System.out.print("Digite sua escolha: ");
            String oqMudar = scanner.nextLine();

            switch (oqMudar){
                case "1":
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    produtoController.mudarNome(produtoModificar, novoNome);
                    break;

                case "2":
                    System.out.print("Digite o novo custo: ");
                    float novoCusto = Float.parseFloat(scanner.nextLine());
                    produtoController.mudarCusto(produtoModificar, novoCusto);
                    break;
                case "3":
                    System.out.print("Digite o novo preço de venda: ");
                    float novaVenda = Float.parseFloat(scanner.nextLine());
                    produtoController.mudarValor(produtoModificar, novaVenda);
                    break;
                case "4":
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    produtoController.mudarQuantidade(produtoModificar, novaQuantidade);
                    break;
                case "5":
                    System.out.println("Modificação cancelada.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void verClientes(){
        clienteController.listarClientes();
    }

    public void procurarCliente(Scanner scanner){

        System.out.print("Digite o nome do cliente procurado: ");
        String clienteProcurado = scanner.nextLine();

        Cliente cliente = clienteController.clienteAchado(clienteProcurado);
        if(cliente == null){
            System.out.println("Nenhum cliente encontrando com esse nome, tente novamente!");
        } else if (cliente != null) {
            clienteController.mostrarCliente(cliente);
        }
    }
}