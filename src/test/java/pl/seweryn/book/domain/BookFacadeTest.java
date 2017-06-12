package pl.seweryn.book.domain;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;


/**
 * Created by Kuzyn on 10.06.2017.
 */
public class BookFacadeTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        when().get("http://www.google.com").then().statusCode(200);
    }

}