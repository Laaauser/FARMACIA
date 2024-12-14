
public class Medicamento {
    private String nome;
    private int quantidadeOriginal;
    private int quantidadeEmEstoque;
    private double preco;

    // construtor
    public Medicamento(String nome, int quantidadeEmEstoque, double preco) {
        this.nome = nome;
        this.quantidadeOriginal = quantidadeEmEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
    }

    // criaçao do get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //reduzir o estoque depois de uma compra
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    //comprar um medicamento//
    public boolean comprar(int quantidade) {
        if (quantidadeEmEstoque >= quantidade) {
            quantidadeEmEstoque -= quantidade;
            return true;
        }
        return false;
    }
    // retornar valor inicial quando limpar
    public void resetarQuantidade() {
        this.quantidadeEmEstoque = this.quantidadeOriginal;
    }

    // override para evitar erro de nao corresponder//
    @Override
    public String toString() {
        return "Medicamento{" +
                "nome='" + nome + '\'' +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                ", preco=" + preco +
                '}';
    }
}