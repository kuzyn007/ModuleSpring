package pl.seweryn.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Kuzyn on 10.06.2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private Long bookId;

    public BookNotFoundException(Long id) {
        this.bookId = id;
    }

    public Long getBookId() {
        return bookId;
    }
}
