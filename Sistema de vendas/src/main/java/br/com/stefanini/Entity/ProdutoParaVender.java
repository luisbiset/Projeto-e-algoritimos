package br.com.stefanini.Entity;

public class ProdutoParaVender extends Produto {
    private Float quantidade;
    

    public ProdutoParaVender(String nome, String codigo, Float preco, Float estoque, Integer id, Float quantidade) {
        super(nome, codigo, preco, estoque, id);
        this.quantidade = quantidade;
    }

    public ProdutoParaVender(String nome, String codigo, Float preco, Float estoque, Float quantidade) {
        super(nome, codigo, preco, estoque);
        this.quantidade = quantidade;
    }

    public void aumentarProdutosAvender() {
        this.quantidade++;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public Float getTotal() {
        return this.getPreco() * this.quantidade;
    }
    
}
