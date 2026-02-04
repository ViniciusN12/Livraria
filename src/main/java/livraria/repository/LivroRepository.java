package livraria.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import livraria.models.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE " +
           "(:genero IS NULL OR LOWER(l.genero) LIKE LOWER(CONCAT('%', :genero, '%'))) AND " +
           "(:nomeAutor IS NULL OR LOWER(l.autor.nomeAutor) LIKE LOWER(CONCAT('%', :nomeAutor, '%')))")
    List<Livro> findByGeneroAndNomeAutor(@Param("genero") String genero, @Param("nomeAutor") String nomeAutor);

}
