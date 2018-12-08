package backend_tests.tests;

import backend_tests.utils.resources;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Steps {

    private String user = "Test1";
    private String email = "raul_bogdan_alias@yahoo.com";
    private String invalidEmail = "test@";
    private String pass = "123456";
    private String wrongPass = "1234567";
    private String shortPass = "1234567";

    @Test
    public void getUsers() {
        given().
                when().
                get(resources.baseURL() + resources.getUsers()).
                then().assertThat().statusCode(200).extract().response();
    }

    @Test
    public void postUser() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("user.password", pass).
                formParam("confirmationPassword", pass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(302).extract().response();
    }

    @Test
    @Description("Should have 400 status code - same user exists, same email exists")
    public void postUserWithSameName() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("user.password", pass).
                formParam("confirmationPassword", pass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - cannot create a user without name")
    public void postUserWithoutName() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.email", email).
                formParam("user.password", pass).
                formParam("confirmationPassword", pass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - cannot create a user without password")
    public void postUserWithoutPassword() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("confirmationPassword", pass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - cannot create a user without confirmation password")
    public void postUserWithoutConfirmationPassword() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("user.password", pass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - repeat password is not the same")
    public void postUserWIthWrongRepeatPassword() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("user.password", pass).
                formParam("confirmationPassword", wrongPass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - password is too short")
    public void postUserWIthShortPassword() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", email).
                formParam("user.password", pass).
                formParam("confirmationPassword", shortPass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    @Description("Should have 400 status code - email is invalid")
    public void postUserWIthInvalidEmail() {
        given().
                contentType(ContentType.fromContentType("application/x-www-form-urlencoded")).
                formParam("user.name", user).
                formParam("user.email", invalidEmail).
                formParam("user.password", pass).
                formParam("confirmationPassword", shortPass).
                when().
                post(resources.baseURL() + resources.placePostData()).
                then().assertThat().statusCode(400).extract().response();
    }

    @Test
    public void deleteUsers() {
        given().
                when().
                delete(resources.baseURL() + resources.deleteUsers()).
                then().assertThat().statusCode(200).extract().response();
    }

}
