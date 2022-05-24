package br.com.stefanini.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.stefanini.repository.VendasRepository;

@Controller
@RequestMapping(path = "/vendas")
public class VendasController {
    @Autowired
    VendasRepository vendasRepository;

    @GetMapping(value = "/")
    public String mostrarVendas(Model model) {
        model.addAttribute("vendas", vendasRepository.findAll());
        return "vendas/mostrar_vendas";
    }
}
