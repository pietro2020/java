package classes;

import java.util.Scanner;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private int senha;
    private int cpf;
    private String dataNasc;

    public Cliente(String nome, String email, int senha, int cpf, String dataNasc) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    //getters e setters
    //nome
    public String getNome(){return this.nome;}

    //email
    public String getEmail(){return this.email;}
    public void setEmail(String email){ this.email = email; }

    //senha
    public void setSenha(int senha){ this.senha = senha; }

    //cpf
    public int getCpf(){return this.cpf;}

    //data de nascimento
    public String getDataNasc(){return this.dataNasc;}


    public boolean verificarSenha(int senhaDigitada){
        return this.senha == (senhaDigitada);
    }

    public boolean verificarNome(String nomeDigitado){
        return this.nome.equalsIgnoreCase(nomeDigitado);
    }


    @Override
    public String toString(){
        return "-----------------" +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nNascimento: " + dataNasc;
    }


}
