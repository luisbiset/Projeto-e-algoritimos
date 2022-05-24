package br.com.stefanini.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stefanini.Entity.Produto;
import br.com.stefanini.Entity.ProdutoParaVender;
import br.com.stefanini.Entity.ProdutoVendido;
import br.com.stefanini.Entity.Venda;
import br.com.stefanini.repository.ProdutosRepository;
import br.com.stefanini.repository.ProdutosVendidosRepository;
import br.com.stefanini.repository.VendasRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/vender")
public class VenderController {
    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private VendasRepository vendasRepository;
    @Autowired
    private ProdutosVendidosRepository produtosVendidosRepository;

    @PostMapping(value = "/sair/{indice}")
    public String sairDoCarrinho(@PathVariable int indice, HttpServletRequest request) {
        ArrayList<ProdutoParaVender> carrinho = this.obterCarrinho(request);
        if (carrinho != null && carrinho.size() > 0 && carrinho.get(indice) != null) {
            carrinho.remove(indice);
            this.salvarCarrinho(carrinho, request);
        }
        return "redirect:/vender/";
    }

    private void limparCarrinho(HttpServletRequest request) {
        this.salvarCarrinho(new ArrayList<>(), request);
    }

    @GetMapping(value = "/limpar")
    public String cancelarVenda(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        this.limparCarrinho(request);
        redirectAttrs
                .addFlashAttribute("mensagem", "venda cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/vender/";
    }

    @PostMapping(value = "/fechar")
    public String fecharVenda(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProdutoParaVender> carrinho = this.obterCarrinho(request);
       
        if (carrinho == null || carrinho.size() <= 0) {
            return "redirect:/vender/";
        }
        Venda v = vendasRepository.save(new Venda());
        
        for (ProdutoParaVender produtoParaVender : carrinho) {
            
            Produto p = produtosRepository.findById(produtoParaVender.getId()).orElse(null);
            if (p == null) continue; // 
            
            p.subtraiEstoque(produtoParaVender.getQuantidade());
            
            produtosRepository.save(p);
           
            ProdutoVendido produtoVendido = new ProdutoVendido(produtoParaVender.getQuantidade(), produtoParaVender.getPreco(), produtoParaVender.getNome(), produtoParaVender.getCodigo(), v);
            
            produtosVendidosRepository.save(produtoVendido);
        }

        
        this.limparCarrinho(request);
     
        redirectAttrs
                .addFlashAttribute("mensagem:", "Venda realizada com Sucesso!!")
                .addFlashAttribute("clase", "success");
        return "redirect:/vender/";
    }

    @GetMapping(value = "/")
    public String interfaceVender(Model model, HttpServletRequest request) {
        model.addAttribute("produto", new Produto());
        float total = 0;
        ArrayList<ProdutoParaVender> carrinho = this.obterCarrinho(request);
        for (ProdutoParaVender p: carrinho) total += p.getTotal();
        model.addAttribute("total", total);
        return "vender/vender";
    }

    private ArrayList<ProdutoParaVender> obterCarrinho(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
		ArrayList<ProdutoParaVender> carrinho = (ArrayList<ProdutoParaVender>) request.getSession().getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }
        return carrinho;
    }

    private void salvarCarrinho(ArrayList<ProdutoParaVender> carrinho, HttpServletRequest request) {
        request.getSession().setAttribute("carrinho", carrinho);
    }

    @PostMapping(value = "/adicionar")
    public String adicionarAoCarrinho(@ModelAttribute Produto produto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProdutoParaVender> carrinho = this.obterCarrinho(request);
        Produto buscarProdutoPorCodigo = produtosRepository.findFirstByCodigo(produto.getCodigo());
        if (buscarProdutoPorCodigo == null) {
            redirectAttrs
                    .addFlashAttribute("Mensagem", "O produto com o código " + produto.getCodigo() + " nao existe")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        if (buscarProdutoPorCodigo.semEstoque()) {
            redirectAttrs
                    .addFlashAttribute("Mensagem:", "Produto sem estoque!!")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        boolean encontrado = false;
        for (ProdutoParaVender produtoParaVenderAtual : carrinho) {
            if (produtoParaVenderAtual.getCodigo().equals(buscarProdutoPorCodigo.getCodigo())) {
                produtoParaVenderAtual.aumentarProdutosAvender();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            carrinho.add(new ProdutoParaVender(buscarProdutoPorCodigo.getNome(), buscarProdutoPorCodigo.getCodigo(), buscarProdutoPorCodigo.getPreco(), buscarProdutoPorCodigo.getEstoque(), buscarProdutoPorCodigo.getId(),1f));
        }
        this.salvarCarrinho(carrinho, request);
        return "redirect:/vender/";
    }
}

