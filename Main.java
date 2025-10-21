import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaDeClientes = new ArrayList<>();
        List<Produto> listaDeProdutos = new ArrayList<>();
        Funcionario funcionario = new Funcionario(1234, 1234, "Trabaio");

        boolean encontrado = false;

        while (true) {

            //Começo do software
            System.out.println("--- DIGITE O TIPO DE USUÁRIO ---");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionário");
            System.out.print("Qual seu tipo de usuário: ");
            String usuario = scanner.nextLine();

            if (usuario.equals("1")) {

                System.out.print("Já possui conta?(S/N): ");
                String possuiCont = scanner.nextLine();

                if (possuiCont.equalsIgnoreCase("n")) {

                    //Cadastra e mostra o cliente
                    Cliente.cadastrarCliente(scanner, listaDeClientes);

                    /* Mostra a lista de clientes (teste)
                    System.out.println(listaDeClientes);*/

                } else if (possuiCont.equalsIgnoreCase("s")) {
                    System.out.print("Email: ");
                    String email = scanner.nextLine();


                    for(Cliente cliente : listaDeClientes) {

                        if (cliente.email.equalsIgnoreCase(email)) {
                            encontrado = true;

                            System.out.print("Senha: ");
                            String senha = scanner.nextLine();

                            if (cliente.senha.equalsIgnoreCase(senha)) {

                                //todas as funções q os clientes podem fazer
                                clientesFuncoes:
                                while (true) {
                                    cliente.opcoes();
                                    String opcao = scanner.nextLine();

                                    switch (opcao){
                                        case "1":
                                            cliente.verProdutos(listaDeProdutos, scanner);

                                            break;
                                        case "2":
                                            cliente.procurarProduto(listaDeProdutos, scanner);

                                            break;
                                        case "3":
                                            cliente.mudarDados(scanner, listaDeClientes);

                                            break;
                                        case "4":

                                            break clientesFuncoes;
                                        default:
                                            System.out.println("Digite um número válido!");
                                    }
                                }
                            } else {
                                System.out.println("Senha errada, tente novamente!");
                                break;
                            }
                        }
                    }
                    if(!encontrado){
                        System.out.println("Email não encontrado, faça o cadastro!");
                    }
                }

            } else if (usuario.equals("2")) {
                System.out.print("Id: ");
                int id = Integer.parseInt(scanner.nextLine());

                if (funcionario.id == (id)) {
                    System.out.print("Senha: ");
                    int senha = Integer.parseInt(scanner.nextLine());

                    if (funcionario.senha == (senha)) {

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
