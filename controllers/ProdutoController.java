package controllers;

import classes.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> listaDeProdutos = new ArrayList<>();

    public ProdutoController() {
        this.listaDeProdutos = new ArrayList<>();
    }

    /*lista os produtos para os clientes
    printa uma lista com os produtos
     */
    public void listarProdutos() {
        int quantiProdutos = 1;

        for (Produto p : listaDeProdutos) {

            System.out.printf("%d | Produto: %s | Valor: %.2f |\n", quantiProdutos, p.getNome(), p.getPrecoCusto());
            quantiProdutos++;
        }
    }

    public void verProdutos(){
        int quantiProdutos = 1;

        for (Produto p : listaDeProdutos) {

            System.out.printf("| Produto: %s | Custo: %.2f | Valor: %.2f | Quantidade: %d |\n", p.getNome(), p.getPrecoCusto(), p.getPrecoVenda(), p.getQuantidade());
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

    public Produto criarProduto(String nome, float precoCus, float precoLuc, int quanti){
        Produto produto = new Produto(nome, precoCus, precoLuc, quanti);

        listaDeProdutos.add(produto);
        return produto;
    }

    public void mudarNome(Produto produto, String novoNome){
        produto.setNome(novoNome);
    }

    public void mudarCusto(Produto produto, float novoCusto){
        produto.setPrecoCusto(novoCusto);
    }

    public void mudarValor(Produto produto, float novoValor){
        produto.setPrecoVenda(novoValor);
    }

    public void mudarQuantidade(Produto produto, int novaQuantidade){
        produto.setQuantidade(novaQuantidade);
    }

    public Produto verificarExistencia(String nomeDigitado){
        for(Produto p : listaDeProdutos){
            if(p.validaNome(nomeDigitado)){
                return p;
            }
        }
        return null;
    }
}
