import classes.*;
import controllers.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = new Funcionario(1234, 1234, "Trabaio");

        ClienteController clienteController = new ClienteController();
        App app = new App();

        boolean encontrado = false;

        while (true) {

            String usuario = app.iniciar(scanner);

            if (usuario.equals("1")) {

                String possuiConta = app.possuiConta(scanner);

                if (possuiConta.equalsIgnoreCase("n")) {

                    //Cadastra e mostra o cliente
                    App.cadastrarCliente(scanner, clienteController);

                    /* Mostra a lista de clientes (teste)
                    System.out.println(listaDeClientes);*/

                } else if (possuiConta.equalsIgnoreCase("s")) {

                    Cliente clienteLogado = app.verificarLogin(scanner, clienteController);
                    if (clienteLogado != null) {

                        //todas as funções q os clientes podem fazer
                        clientesFuncoes:
                        while (true) {
                            String opcao = app.opcoesCliente(clienteLogado, scanner);

                            switch (opcao) {
                                case "1":
                                    app.verProdutosClientes(scanner);

                                    break;
                                case "2":
                                    app.procurarProduto(scanner);

                                    break;
                                case "3":
                                    Cliente cliente = app.mudarDados(scanner);
                                    if (cliente == null) {
                                        break clientesFuncoes;
                                    }

                                    break;
                                case "4":

                                    break clientesFuncoes;
                                default:
                                    System.out.println("Digite um número válido!");
                            }
                        }
                    }
                }

            } else if (usuario.equals("2")) {
                System.out.print("Id: ");
                int id = Integer.parseInt(scanner.nextLine());

                if (funcionario.verificaId(id)) {
                    System.out.print("Senha: ");
                    int senha = Integer.parseInt(scanner.nextLine());

                    if (funcionario.verificaSenha(senha)) {

                        //todas as funções que os funcionários fazem
                        funcionarioFuncoes:
                        while (true) {
                            funcionario.opcoes();
                            String opcao = scanner.nextLine();

                            switch (opcao){
                                case "1":
                                    funcionario.adicionarProduto(scanner, listaDeProdutos);

                                    break;
                                case "2":
                                    funcionario.modificaProduto(scanner,listaDeProdutos);

                                    break;
                                case "3":
                                    funcionario.verProdutos(listaDeProdutos);

                                    break;
                                case "4":
                                    funcionario.listarClientes(listaDeClientes);

                                    break;
                                case "5":
                                    funcionario.procurarCliente(scanner, listaDeClientes);

                                    break;
                                case "6":


                                    break;
                                case "7":
                                    break funcionarioFuncoes;

                                default:
                                    System.out.println("Digite um número válido!");

                            }
                        }
                    } else {
                        System.out.println("Senha errada, tente novamente!");
                    }
                }
                else{
                    System.out.println("ID não encontrado, faça o cadastro!");
                }



            } else {
                System.out.println("Digite um número válido!");
            }
        }

    }
}
