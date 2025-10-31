package classes;

public class Produto {
    private String nome;
    private float precoCus;
    private float precoLuc;
    private int quanti;

    public Produto(String nome, float precoCus, float precoLuc, int quanti){
        this.nome = nome;
        this.precoCus = precoCus;
        this.precoLuc = precoLuc;
        this.quanti = quanti;
    }

    public void exibirProduto(){
        System.out.println("---- PRODUTO ----");
        System.out.println("Nome do produto: " + nome);
        System.out.println("Valor gasto: " + precoCus);
        System.out.println("Valor a cobrar: " + precoLuc);
        System.out.println("Quantidade: " + quanti);

    }

    /*Getters e setters:
    Getter: retorna um valor
    setter: muda um valor
    */
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public float getPrecoCusto() { return precoCus; }
    public void setPrecoCusto(float precoCusto) { this.precoCus = precoCusto; }

    public float getPrecoVenda() { return precoLuc; }
    public void setPrecoVenda(float precoVenda) { this.precoLuc = precoVenda; }

    public int getQuantidade() { return quanti; }
    public void setQuantidade(int quantidade) { this.quanti = quantidade; }

    //validações
    public boolean validaNome(String nomeDigitado){
        return this.nome.equalsIgnoreCase(nomeDigitado);
    }


}
