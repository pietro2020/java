package controllers;

import classes.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> listaDeProdutos = new ArrayList<>();

    public ProdutoController() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void listarProdutos() {
        int quantiProdutos = 1;

        for (Produto p : listaDeProdutos) {

            System.out.printf("%d | Produto: %s | Valor: %.2f |\n", quantiProdutos, p.getNome(), p.getPrecoCusto());
            quantiProdutos++;
        }
    }

    public Produto escolherProduto(int index){
        return listaDeProdutos.get(index - 1);
    }

    public boolean darBaixa(Produto produto, int quantidade){
        if(produto.getQuantidade() >= quantidade){
            produto.setQuantidade(produto.getQuantidade() - quantidade);

            return true;
        }
        return false;
    }

    public String produtoDesejado(Produto produto){
        return produto.getNome();
    }

    public float valorTotal(int quantidade, Produto produto){
        return (quantidade * produto.getPrecoVenda());
    }

    public Produto procurarProduto(String produto){
        for (Produto p : listaDeProdutos) {
            if(produto.equalsIgnoreCase(p.getNome())) {
                System.out.printf("| Produto: %s | Valor: %.2f |\n", p.getNome(), p.getPrecoCusto());
                return p;
            }

        }
        return null;
    }
}
