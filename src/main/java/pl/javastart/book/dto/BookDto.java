package pl.javastart.book.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by Seweryn Adamczyk on 2017-04-26.
 */

@Builder
@Getter
@EqualsAndHashCode
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
}
