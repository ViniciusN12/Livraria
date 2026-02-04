package livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import livraria.models.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
