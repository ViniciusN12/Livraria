package livraria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import livraria.models.entity.Autor;
import livraria.repository.AutorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor findById(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void delete(Autor autor) {
        autorRepository.delete(autor);
    }
}
