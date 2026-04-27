import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstAPITest {

    static String token;

    @Test
    public void loginTest() {
        token = given()
                .contentType("application/json")
                .body("{\"username\": \"emilys\", \"password\": \"emilyspass\"}")
                .when()
                .post("https://dummyjson.com/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");

        System.out.println("Token:" + token);

        given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 1)
                .when()
                .get("https://dummyjson.com/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("email", containsString("@"))
                .body("firstName", notNullValue())
                .body("age", greaterThan(18))
                .log().all();
    }
}

//    @DataProvider(name = "loginData")
//    public Object[][] getData() {
//        return new Object[][] {
//                {1},{2}
//        };
//    }
//
//    @Test(dataProvider = "loginData")
//    public void loginTest(int id) {
//
//        given()
//                .contentType("application/json")
//                .body("{ \"id\": \"" + id + "\" }")
//                .when()
//                .get("https://dummyjson.com/users")
//                .then()
//                .log().all();

//        int userId = given()
//                .contentType("application/json")
//                .body("{ \"firstName\": \"Prasad\", \"age\": 25 }")
//                .when()
//                .post("https://dummyjson.com/users/add")
//                .then()
//                .log().all()
//                .statusCode(201)
//                .extract()
//                .path("id");
//
//        // 👉 PRINT ID
//        System.out.println("User ID: " + userId);
//
//        given()
//                .pathParam("id", userId)
//                .when()
//                .get("https://dummyjson.com/users/{id}")
//                .then()
//                .log().all()
//                .statusCode(404)
//                .body("id", equalTo(userId))
//                .log().all();

        // DELETE - Delete user
//        given()
//                .pathParam("id", 1)
//                .when()
//                .delete("https://dummyjson.com/users/{id}")
//                .then()
//                .statusCode(200);


        // PUT (Update) - Update existing data
//        given()
//                .contentType("application/json")
//                .body("{ \"firstName\": \"UpdatedName\" }")
//                .pathParam("id", 1)
//                .when()
//                .put("https://dummyjson.com/users/{id}")
//                .then()
//                .statusCode(200)
//                .body("firstName", equalTo("UpdatedName"));

        //GET(Read) - Fetch created data
//        given()
//                .pathParam("id", 1)
//                .when()
//                .get("https://dummyjson.com/users/{id}")
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(1));

        //POST(Create) - Creating new data
//        given()
//                .contentType("application/json")
//                .body("{ \"firstName\": \"Prasad\", \"age\": 22}")
//                .when()
//                .post("https://dummyjson.com/users/add")
//                .then()
//                .statusCode(201)
//                .body("firstName", equalTo("Prasad"))
//                .log().all();

        //headers+responseTime
//        given()
//                .pathParam("id", 1)
//                .when()
//                .get("https://dummyjson.com/users/{id}")
//                .then()
//                .statusCode(200)
//                .header("Content-Type", containsString("application/json"))
//                .time(lessThan(3000L))
//                .body("id", equalTo(1))
//                .body("email", containsString("@"))
//                .log().all();

        //pathParam
//        given()
//                .pathParam("id",2)
//                .when()
//                .get("https://dummyjson.com/users/{id}")
//                .then()
//                .statusCode(200)
//                .body("id",equalTo(2))
//                .log().all();

        //queryParam
//            given()
//                    .queryParam("limit", 1)
//                    .when()
//                    .get("https://dummyjson.com/users")
//                    .then()
//                    .statusCode(200)
//                    .body("limit",equalTo(1))
//                    .log().all();

        //NegativeTesting
//        given()
//                .contentType("application/json")
//                .body("{ \"username\": \"wrong\", \"password\": \"wrong\" }")
//                .when()
//                .post("https://dummyjson.com/auth/login")
//                .then()
//                .statusCode(400)
//                .log().all();

        //Response Validation
//        given()
//                .when()
//                .get("https://jsonplaceholder.typicode.com/users")
//                .then()
//                .statusCode(200)
//                .body("[0].name", equalTo("Leanne Graham"))
//                .body("[0].id",equalTo(1))
//                .body("[0].email",containsString("@"));
