package br.com.stefanini.Entity;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private Set<ProdutoVendido> produtos;

    public Venda() {
        this.data = Utils.obterData();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public double getTotal() {
        double total = 0f;
        for (ProdutoVendido produtoVendido : this.produtos) {
            total += produtoVendido.getTotal();
        }
        return total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<ProdutoVendido> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoVendido> produtos) {
        this.produtos = produtos;
    }
}
