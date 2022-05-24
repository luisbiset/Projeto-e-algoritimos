package br.com.stefanini.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stefanini.Entity.Produto;
import br.com.stefanini.repository.ProdutosRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping(value = "/cadastrar")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/cadastrar_produto";
    }

    @GetMapping(value = "/mostrar")
    public String mostrarProdutos(Model model) {
        model.addAttribute("produtos", produtosRepository.findAll());
        return "produtos/mostrar_produtos";
    }

    @PostMapping(value = "/deletar")
    public String deletarProduto(@ModelAttribute Produto produto, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensagem:", "produto deletado com sucesso")
                .addFlashAttribute("clase", "warning");
        produtosRepository.deleteById(produto.getId());
        return "redirect:/produtos/mostrar";
    }

   
    @PostMapping(value = "/editar/{id}")
    public String atualizarProduto(@ModelAttribute @Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            if (produto.getId() != null) {
                return "produtos/editar_produto";
            }
            return "redirect:/produtos/mostrar";
        }
        Produto possivelProdutoExistente = produtosRepository.findFirstByCodigo(produto.getCodigo());

        if (possivelProdutoExistente != null && !possivelProdutoExistente.getId().equals(produto.getId())) {
            redirectAttrs
                    .addFlashAttribute("mensagem:", "Ja existe um produto com esse código")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/produtos/cadastrar";
        }
        produtosRepository.save(produto);
        redirectAttrs
                .addFlashAttribute("mensagem:", "Produto editado com sucesso!!")
                .addFlashAttribute("clase", "success");
        return "redirect:/produtos/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtosRepository.findById(id).orElse(null));
        return "produtos/editar_produto";
    }

    @PostMapping(value = "/cadastrar")
    public String salvarProduto(@ModelAttribute @Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "produtos/cadastrar_produto";
        }
        if (produtosRepository.findFirstByCodigo(produto.getCodigo()) != null) {
            redirectAttrs
                    .addFlashAttribute("mensagem:", "Ja existe um produto com esse código")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/produtos/cadastrar";
        }
        produtosRepository.save(produto);
        redirectAttrs
                .addFlashAttribute("mensagem:", "Produto cadastrado com sucesso!!")
                .addFlashAttribute("clase", "success");
        return "redirect:/produtos/cadastrar";
    }
}
