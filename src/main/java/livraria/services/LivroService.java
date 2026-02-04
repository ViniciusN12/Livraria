package livraria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import livraria.models.entity.Livro;
import livraria.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> findByGeneroAndNomeAutor(String genero, String nomeAutor) {
        return livroRepository.findByGeneroAndNomeAutor(genero, nomeAutor);
    }
    
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(Livro livro) {
        livroRepository.delete(livro);
    }
}
