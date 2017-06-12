package pl.seweryn.book.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import pl.seweryn.book.dto.BookDto;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @NotEmpty
    private String author;
    @Column(unique = true, nullable = false)
    private String isbn;

    BookDto dto() {
        return BookDto.builder()
                .id(id)
                .title(title)
                .author(author)
                .isbn(isbn)
                .build();
    }
}
