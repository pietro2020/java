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
        System.out.println("3. VER CARRINHO DE COMPRAS");
        System.out.println("4. ATUALIZAR MINHAS INFORMAÇÕES");
        System.out.println("5. SAIR DA CONTA");
        System.out.print("Digite o que deseja: ");
    }
}
