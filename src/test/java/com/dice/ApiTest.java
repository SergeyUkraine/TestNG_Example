package com.dice;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {

    Logger log;
    private static final String URL = "https://reqres.in";

    @Test
    public void testCanCheckFormatOfResponse(){

        get(URL + "/api/users?page=2")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user_list.json"));
    }

    @Test
    public void testCanCheckSecondUserFromList(){

        get(URL + "/api/users?page=2")
                .then()
                .body("data.id[1]", equalTo(5))
                .body("data.first_name[1]", equalTo("Charles"))
                .body("data.last_name[1]", equalTo("Morris"));
    }

    @Test
    public void testCanRegisterAndReceiveTheToken(){
        Map<String, String> userData = new HashMap<>();
        userData.put("email", "sydney@fife");
        userData.put("password", "pistol");

        given()
                .body(userData)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/register")
                .then()
                .assertThat()
                .body("token", equalTo("QpwL5tke4Pnpja7X"));
    }
}
