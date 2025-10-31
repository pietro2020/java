package classes;

import java.util.List;
import java.util.Scanner;

public class Funcionario {
    private int id;
    private int senha;
    private String nome;

    public Funcionario(int id, int senha, String nome){
        this.id = id;
        this.senha = senha;
        this.nome = nome;
    }

    //verificações
    public boolean verificaId(int idDigitado){
        return this.id == (id);
    }

    public boolean verificaSenha(int senhaDigitada){
        return this.senha == (senha);
    }

    public void opcoes(){
        System.out.println("+------------+");
        System.out.println("|Olá " + nome + " |");
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

    public Produto adicionarProduto(Scanner scanner, List<Produto> listaDeProdutos){
        System.out.print("Qual o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quanto custou o produto: ");
        float precoCus = scanner.nextFloat();

        System.out.print("Quanto será cobrado pelo produto: ");
        float precoLuc = scanner.nextFloat();

        System.out.print("Qual a quantidade do produto: ");
        int quanti = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new Produto(nome, precoCus, precoLuc, quanti);

        listaDeProdutos.add(produto);

        produto.exibirProduto();

        return produto;
    }

    public void modificaProduto(Scanner scanner, List<Produto> listaDeProdutos){
        System.out.print("Qual o nome do produto que será modificado: ");
        String nomeModificar = scanner.nextLine();

        for(Produto p : listaDeProdutos){
            if (p.validaNome(nomeModificar)){
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
                        p.setNome(novoNome);
                        break;
                    case "2":
                        System.out.print("Digite o novo custo: ");
                        float novoCusto = scanner.nextFloat();
                        p.setPrecoCusto(novoCusto);
                        break;
                    case "3":
                        System.out.print("Digite o novo preço de venda: ");
                        float novoPrecoVenda = scanner.nextFloat();
                        p.setPrecoVenda(novoPrecoVenda);
                        break;
                    case "4":
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        p.setQuantidade(novaQuantidade);
                        break;
                    case "5":
                        System.out.println("Modificação cancelada.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    public void verProdutos(List<Produto> listaDeProdutos){
        for(Produto p : listaDeProdutos){
            System.out.printf("| classes.Produto: %s | Custo: %.2f | Valor: %.2f | Quantidade: %d |\n", p.getNome(), p.getPrecoCusto(), p.getPrecoVenda(), p.getQuantidade());
        }
    }

    public void listarClientes(List<Cliente> listaDeClientes){
        for(Cliente c : listaDeClientes){
            System.out.printf("| classes.Cliente: %s | Email: %s | CPF: %s | Data de Nascimento: %s |\n", c.getNome(), c.getEmail(), c.getCpf(), c.getDataNasc());
        }
    }

    public void procurarCliente(Scanner scanner, List<Cliente> listaDeClientes){
        boolean clienteAchado = false;

        System.out.print("Digite o nome do cliente procurado: ");
        String clienteProcurado = scanner.nextLine();

        for(Cliente c : listaDeClientes){
            if(c.verificarNome(clienteProcurado)){
                clienteAchado = true;

                System.out.printf("| classes.Cliente: %s | Email: %s | CPF: %s | Data de Nascimento: %s |\n", c.getNome(), c.getEmail(), c.getCpf(), c.getDataNasc());
            }
        }
        if(!clienteAchado){
            System.out.println("Nenhum cliente encontrando com esse nome, tente novamente!");
        }
    }

    public void relatorioVendas(){
        //fazer após as funcionalidades prontas
    }
}
