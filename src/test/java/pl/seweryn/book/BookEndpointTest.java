package pl.seweryn.book;

import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.seweryn.book.domain.BookFacade;
import pl.seweryn.book.dto.BookDto;
import pl.seweryn.book.exceptions.BookNotFoundException;
import pl.seweryn.security.SecurityConfig;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Kuzyn on 10.06.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookEndpoint.class)
@Import(SecurityConfig.class)
public class BookEndpointTest {

    BookDto bookNumberOne;
    BookDto bookNumberTwo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BookFacade bookFacade;

    @Before
    public void setUp() throws Exception {

        bookNumberOne = BookDto.builder()
                .id(1L)
                .title("Testowa1")
                .author("Anonim1")
                .isbn("1234567890")
                .build();

        bookNumberTwo = BookDto.builder()
                .id(2L)
                .title("Testowa2")
                .author("Anonim2")
                .isbn("1234567890")
                .build();
    }

    @Test
    public void getBooksRequestShouldReturnBooks() throws Exception {
        List<BookDto> bookDtos = Arrays.asList(bookNumberOne, bookNumberTwo);
        given(bookFacade.findAll()).willReturn(bookDtos);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    @Test
    public void getBookRequestThrowNotFoundException() throws Exception {
        given(bookFacade.findOne(3L)).willThrow(new BookNotFoundException(3L));

        mockMvc.perform(get("/books/{id}", 3L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void add() throws Exception {
        given(bookFacade.add(bookNumberOne)).willReturn(bookNumberOne);

        mockMvc.perform(post("/books").with())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Testowa1")));
    }

}