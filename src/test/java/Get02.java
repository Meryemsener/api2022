import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

@Test
    public void get02(){
    //i) Set the url
    String  url="https://restful-booker.herokuapp.com/booking/1005";

    //      ii)Set the expected data(POST_PUT_PATCH)

    //      iii)Type code to send request
    Response response=given().when().get(url);
    response.prettyPrint();

    //      iv)Do Assertion
    response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

    //response body'de bulunn spesifik veri nasil assert edilir
    assertTrue(response.asString().contains("Not Found"));

    //response body'de bulunn spesifik veri bulunmadigini nasil assert edilir
    response.asString().contains("TechProEd");

    System.out.println(response.header("Server"));//Cowboy
    assertEquals("Cowboy",response.header("Server"));//Cowboy
}
}
