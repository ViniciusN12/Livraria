package livraria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import livraria.models.entity.Autor;
import livraria.services.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService autorService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("autores", autorService.findAll());
        return "autores";
    }
    
    @GetMapping("/{id}")
    public String getAutorById(@PathVariable Long id, Model model) {
        Autor autor = autorService.findById(id);
        if (autor != null) {
            model.addAttribute("autor", autor);
            return "autor";
        }
        return "redirect:/autores";
    }

    @GetMapping("/cadastrar")
    public String cadastrarAutorForm(Model model) {
        model.addAttribute("autor", new Autor());
        return "createAutor";
    }

    @PostMapping("/salvar")
    public String save(Autor autor){
        autorService.save(autor);
        return "redirect:/autores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAutor(@PathVariable Long id) {
        Autor autor = autorService.findById(id);
        if (autor != null) {
            autorService.delete(autor);
        }
        return "redirect:/autores";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarAutorForm(@PathVariable Long id, Model model) {
        Autor autor = autorService.findById(id);
        if (autor != null) {
            model.addAttribute("autor", autor);
            return "updateAutor";
        }
        return "redirect:/autores";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarAutor(@PathVariable Long id, Autor autor) {
        Autor existingAutor = autorService.findById(id);
        if (existingAutor != null) {
            autor.setIdAutor(id);
            autorService.save(autor);
        }
        return "redirect:/autores";
    }
    
}
