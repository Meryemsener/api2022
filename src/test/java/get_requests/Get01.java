package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
/*
1)Postman manuel API testi icin kullanilir
2)API otomasyon testi icin Rest-Assured kullaniyoruz.
3)Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
   a)Gereksinimleri anlamak
   b)Test Case'i yazma
      i)Test case yazimi icin "Gherkin Language" kullaniyoruz
      "Gherkin" bazi keywordlere sahiptir. Bunlar:
      x)Given:On kosullar
      y)When: Aksiyonlar-> Get, Put,....
      z)Then: Donutler-> dogrulama response
      t)And: Coklu islemler icin

   c) Testing kodunun yazilmasi
      i) Set the url
      ii)Set the expected data(POST_PUT_PATCH)
      iii)Type code to send request
      iv)Do Assertion

 */

    /*
    TEST CASE
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

@Test
    public void get01() {
    // i) Set the url
    String url = "https://restful-booker.herokuapp.com/booking/3";

    // ii)Set the expected data(POST_PUT_PATCH)


    // iii)Type code to send request
    Response response = given().when().get(url);
    response.prettyPrint();

    // iv)Do Assertion
    response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");


    //status code nasil yazdirilir
    System.out.println(response.statusCode());

    //content type nasil yazdirilir
    System.out.println(response.contentType());


}
}
