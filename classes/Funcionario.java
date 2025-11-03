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
        return this.id == (idDigitado);
    }

    public boolean verificaSenha(int senhaDigitada){
        return this.senha == (senhaDigitada);
    }




}
