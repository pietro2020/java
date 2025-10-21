import java.util.Scanner;
import java.util.List;

public class Cliente {
    String nome;
    String email;
    String senha;
    String cpf;
    String dataNasc;

    public Cliente(String nome, String email, String senha, String cpf, String dataNasc) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public void setEmail(String email){ this.email = email; }
    public void setSenha(String senha){ this.senha = senha; }

    public static void cadastrarCliente(Scanner scanner, List<Cliente> listaDeClientes) {
        System.out.print("Qual o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o seu email: ");
        String email = scanner.nextLine();

        System.out.print("Qual será sua senha: ");
        String senha = scanner.nextLine();

        System.out.print("Qual o seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Qual a sua data de nascimento: ");
        String dataNasc = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, senha, cpf, dataNasc);

        listaDeClientes.add(cliente);

        System.out.println(cliente);
    }

    @Override
    public String toString(){
        return "-----------------" +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nNascimento: " + dataNasc;
    }

    public void opcoes(){
        System.out.println("----- PIPI LOJINHAS -----");
        System.out.println("Olá " + nome + ", o que deseja hoje?");
        System.out.println("1. VER PRODUTOS");
        System.out.println("2. PROCURAR PRODUTO");
        System.out.println("3. ATUALIZAR MINHAS INFORMAÇÕES");
        System.out.println("4. SAIR DA CONTA");
        System.out.print("Digite o que deseja: ");
    }

    public void verProdutos(List<Produto> listaDeProdutos, Scanner scanner){
        int quantiProdutos = 1;
        for(Produto p : listaDeProdutos){
            System.out.printf("%d | Produto: %s | Valor: %.2f |\n", quantiProdutos, p.nome, p.precoLuc);
            quantiProdutos++;
        }
        System.out.print("Digite o número do produto que você deseja: ");
        int produtoDesejado = Integer.parseInt(scanner.nextLine());

        Produto produtoComprar = listaDeProdutos.get(produtoDesejado - 1);

        System.out.printf("| %s | Quantidade que você deseja: ", produtoComprar.nome);
        int quantiProdutoDesej = Integer.parseInt(scanner.nextLine());


        fimCompra:
        while(true){
            System.out.println("Valor total " + (quantiProdutoDesej * produtoComprar.getPrecoVenda()) + " reais");
            System.out.print("Finalzar compra(S/N): ");
            String finalizar = scanner.nextLine();

            if(finalizar.equalsIgnoreCase("s")) {
                produtoComprar.setQuantidade(produtoComprar.getQuantidade() - quantiProdutoDesej);

                System.out.println("Compra finalizada com sucesso!");

                break fimCompra;
            } else if(finalizar.equalsIgnoreCase("n")) {
                System.out.println("Compra cancelada!");
                break fimCompra;

            } else{
                System.out.println("Digite uma letra válida!");

            }
        }
    }

    public void procurarProduto(List<Produto> listaDeProdutos, Scanner scanner){
        Produto produtoAchado = null;

        System.out.print("Qual o nome do produto: ");
        String produtoProcurado = scanner.nextLine();

        for(Produto p : listaDeProdutos){
            if(p.nome.equalsIgnoreCase(produtoProcurado)){
                produtoAchado = p;
                System.out.printf(" Produto: %s | Valor: %.2f |\n", p.nome, p.precoLuc);
            }
        }
        System.out.print("Deseja comprar este produto(S/N): ");
        String deseja = scanner.nextLine();

        if (deseja.equalsIgnoreCase("s")){


            System.out.printf("| %s | Quantidade que você deseja: ", produtoAchado.nome);
            int quantiProdutoDesej = Integer.parseInt(scanner.nextLine());


            fimCompra:
            while(true){
                System.out.println("Valor total " + (quantiProdutoDesej * produtoAchado.getPrecoVenda()) + " reais");
                System.out.print("Finalzar compra(S/N): ");
                String finalizar = scanner.nextLine();

                if(finalizar.equalsIgnoreCase("s")) {
                    produtoAchado.setQuantidade(produtoAchado.getQuantidade() - quantiProdutoDesej);

                    System.out.println("Compra finalizada com sucesso!");

                    break fimCompra;
                } else if(finalizar.equalsIgnoreCase("n")) {
                    System.out.println("Compra cancelada!");
                    break fimCompra;

                } else{
                    System.out.println("Digite uma letra válida!");

                }
            }
        }
    }

    public void mudarDados(Scanner scanner, List<Cliente> listaDeClientes){
        System.out.println("----- ATUALIZAR DADOS -----");
        System.out.println("1. Mudar email");
        System.out.println("2. Mudar senha");
        System.out.print("Qual dado vc deseja atualizar: ");
        String oqAtualizar = scanner.nextLine();

        switch (oqAtualizar){
            case "1":

                System.out.print("Qual seu novo email: ");
                String emailNovo = scanner.nextLine();

                setEmail(emailNovo);

                break;
            case "2":
                System.out.print("Verificação de senha, qual sua senha: ");
                String senha = scanner.nextLine();

                if(senha.equals(this.senha)) {
                    System.out.print("Qual sua nova senha: ");
                    String senhaNova = scanner.nextLine();

                    setSenha(senhaNova);
                    System.out.print("Nova senha salva com sucesso!");
                }

                break;
            default:
                System.out.print("Senha errada, tente novamente!");
                break;
        }
    }
}
