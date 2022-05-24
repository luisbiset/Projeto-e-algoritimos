package br.com.stefanini.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ProdutoVendido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float quantidade;
    private Float preco;
    private String nome, codigo;
    
    @ManyToOne
    @JoinColumn
    private Venda venda;

    public ProdutoVendido(Float quantidade, Float preco, String nome, String codigo, Venda venda) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
        this.codigo = codigo;
        this.venda = venda;
    }

    public ProdutoVendido() {
    }

    public Float getTotal() {
        return this.quantidade * this.preco;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenta(Venda venda) {
        this.venda = venda;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
