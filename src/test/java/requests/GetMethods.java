package requests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.Test;

public class GetMethods {
    @Test
    public void getAllGrocery() {
        Response response = null;
        response = RestAssured.given().when().get("http://localhost:3000/allGrocery");
        System.out.println("Response 1 : " + response.asString());
        System.out.println("Status code : " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getGroceryName() {
        Response response = null;
        response = RestAssured.given().when().get("http://localhost:3000/allGrocery/apple");
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("Response 1 : " + response.asString());
        System.out.println("Status code : " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
//        System.out.println(jsonPathEvaluator.getInt("$[data]..id"));
//        Assert.assertEquals(jsonPathEvaluator.get("$[data]..id"), 1);
//        Assert.assertEquals(jsonPathEvaluator.get("$[data]..name"), "apple");
//        Assert.assertEquals(jsonPathEvaluator.get("$[data]..price"), 3);
//        Assert.assertEquals(jsonPathEvaluator.get("$[data]..stock"), 100);
    }

    @Test
    public void add() {
        Response response = null;
        response = RestAssured.given().when().post("http://localhost:3000/add");
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("Response 1 : " + response.asString());
        System.out.println("Status code : " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPathEvaluator.get("name"), "string");
        Assert.assertEquals(jsonPathEvaluator.getDouble("price"), 12.3);
        Assert.assertEquals(jsonPathEvaluator.getInt("stock"), 3);
   }
}