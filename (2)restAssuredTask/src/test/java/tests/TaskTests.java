package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TaskTests extends BaseTest {
    @Test
    public void getPosts(){

        given().contentType(ContentType.JSON)
                .when()
                .get("posts")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getPostByID(){
        String response = given().contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then().assertThat().statusCode(200)
                .body("userId", equalTo(1))
                .body("id",equalTo(1)).extract().response().asString();
        System.out.println(response);
    }

    @Test
    public void postTest(){
        String payLoad = "{\n" +
                "\t\"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";
        String response = given().contentType(ContentType.JSON).body(payLoad)
                .when()
                .post("posts")
                .then().assertThat().statusCode(201)
                .body("title",equalTo("foo"))
                .body("body",equalTo("bar"))
                .body("userId",equalTo(1))
                .body("id",equalTo(101)).extract().response().asString();
        System.out.println(response);
    }

}
