package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */
    @Test
    public void get03() {

        //i) Set the url
        //String url = "https://jsonplaceholder.typicode.com/todos/23"; bu onerilmiyor
        //baseUrl deki spec kullanilir
        spec.pathParams("first","todos","second",23);


        //      ii)Set the expected data(POST_PUT_PATCH)

        //      iii)Type code to send request
        Response response =given().spec(spec).when().get("/{first}/{second}");


        //      iv)Do Assertion
        //1. yol
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo("false")).
                body("userId",equalTo(2));


        //2. yol
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"completed",equalTo("false"),"userId",equalTo(2));

/*
      Note 1: Assetion yaparken Java çalışmayı durdurduğunda hata sonrası kodlar çalışmaz.
              Böylece hata sonrası assertion'lar hakkında bilgi sahibi olamayız.
              Fakat hata öncesi assertion'lar geçmiştir.

     Not 2: Eğer kodumuzu hata noktasında duracak şekilde yazarsak "Hard Assertion" yapmış oluyoruz.

     Not 3: Eğer kodumuzu hata noktasında duramayacak şekilde yazarsak "soft Assertion" yapmış oluyoruz.

     Not 4: Eğer çoklu body() methodu içinde assert yaparsak "Hard Assert",
            tek body() methodu içinde assert yaparsak "Soft Assert"  yapmış oluyoruz.


 */


    }
}