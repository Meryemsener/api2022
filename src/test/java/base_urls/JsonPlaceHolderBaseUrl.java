package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    // @Before annotation u kullndigimiz methotlar her methoddan once calisir
    @Before
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();


    }


}
