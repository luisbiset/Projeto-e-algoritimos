package br.com.stefanini.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "nome")
    @Size(min = 1, max = 50, message = "nome deve ter no maximo 50 caracteres")
    private String nome;

    @NotNull(message = "especifique o codigo")
    @Size(min = 1, max = 50, message = "codigo deve ter no maximo 50 caracteres")
    private String codigo;

    @NotNull(message = "digite o preço")
    @Min(value = 0, message = "preço minimo é 0")
    private Float preco;

    @NotNull(message = "digite a quantidade de estoque")
    @Min(value = 0, message = "quantidade minima: 0")
    private Float estoque;


    public Produto(String nome, String codigo, Float preco, Float estoque, Integer id) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
        this.id = id;
    }

    public Produto(String nome, String codigo, Float preco, Float estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(@NotNull(message = "obrigatorio digitar o codigo") @Size(min = 1, max = 50, message = "codigo deve ter no maximo 50 caracteres") String codigo) {
        this.codigo = codigo;
    }

    public Produto() {
    }

    public boolean semEstoque() {
        return this.estoque <= 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    public void subtraiEstoque(Float estoque) {
        this.estoque -= estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
