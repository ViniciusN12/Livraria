package livraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import livraria.models.entity.Livro;
import livraria.services.AutorService;
import livraria.services.LivroService;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LivrariaController {
    private final LivroService livroService;
    private final AutorService autorService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("livros", livroService.findAll());
        return "index";
    }

    @GetMapping("/livro/cadastrar")
    public String cadastrarLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorService.findAll());
        return "createLivro";
    }

    @PostMapping("/livro/salvar")
    public String salvarLivro(@Valid Livro livro) {
        livroService.save(livro);
        return "redirect:/";
    }

    @GetMapping("/livro/deletar/{id}")
    public String deletarLivro(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        if (livro != null) {
            livroService.delete(livro);
        }
        return "redirect:/";
    }

    @GetMapping("/livro/atualizar/{id}")
    public String atualizarLivroForm(@PathVariable Long id, Model model) {
        Livro livro = livroService.findById(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
            model.addAttribute("autores", autorService.findAll());
            return "updateLivro";
        }
        return "redirect:/";
    }

    @PostMapping("/livro/atualizar/{id}")
    public String atualizarLivro(@PathVariable Long id, Livro livro) {
        livro.setIdLivro(id);
        livroService.save(livro);
        return "redirect:/";
    }

    @GetMapping("/livro/{id}")
    public Livro getLivroById(@PathVariable Long id) {
        return livroService.findById(id);
    }

    @GetMapping("/livros")
    public List<Livro> getLivrosByGeneroAndNomeAutor(
        @RequestParam(required = false) String genero,
        @RequestParam(required = false) String nomeAutor) {
        return livroService.findByGeneroAndNomeAutor(genero, nomeAutor);
    }
}
