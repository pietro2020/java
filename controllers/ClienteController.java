package controllers;

import classes.Cliente;
import classes.Produto;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> listaDeClientes;

    public ClienteController() {
        this.listaDeClientes = new ArrayList<>();
    }

    public void addList(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public Cliente verificaEmail(String email){
        for(Cliente c : listaDeClientes){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c;
            }
        }
        return null;
    }

    public Cliente verificaLogin(String email, int senha){
        Cliente cliente = verificaEmail(email);
        if(cliente != null && cliente.verificarSenha(senha)){
            return cliente;
        }
        return null;
    }

    public void mudarEmail(Cliente cliente, String emailNovo){
        cliente.setEmail(emailNovo);
    }

    public void mudarSenha(Cliente cliente, int senhaNova){
        cliente.setSenha(senhaNova);
    }
}
