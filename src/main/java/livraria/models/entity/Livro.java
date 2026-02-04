package livraria.models.entity;


import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @NotBlank(
        message = "O título do livro não pode estar em branco."
    )
    private String titulo;
    
    private String isbn;
    private String editora;
    private String dataPublicacao;
    private String genero;
    private String capaUrl;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    @ToString.Exclude
    private Autor autor;
}
