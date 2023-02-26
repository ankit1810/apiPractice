import apiConfigs.APIPath;
import apiConfigs.HeadersConfigs;
import dataProvider.PostCallDataProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.DataPojo;
import models.PostCallPojo;
import org.testng.annotations.Test;
import models.ListPojo;
import utils.PropertyReader;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestClass extends BaseTest {
    HeadersConfigs headers= new HeadersConfigs();
    @Test
    public void getCall(){
        Response response=given()
                .headers(headers.defaultHeaders())
                .when()
                .get(APIPath.apiPath.GET_SINGLE_USER);
        System.out.println(response.statusCode());
    }
    @Test
    public void postCall(){
        Response response= given()
                .headers(headers.headers())
                .when()
                .post(APIPath.apiPath.CREATE_USER);
    }
    @Test
    public void DesertTest(){
        ListPojo listPojo = given().headers(headers.defaultHeaders()).when().get(APIPath.apiPath.GET_CALL).as(ListPojo.class);
        System.out.println(listPojo.toString());
    }
    @Test(dataProviderClass = PostCallDataProvider.class,
    dataProvider = "postNameJobMethod")
    public void postCall1(String name, String job){
        PostCallPojo postCallPojo=new PostCallPojo();
        postCallPojo.setJob(job);
        postCallPojo.setName(name);
        Response response=given().headers(headers.defaultHeaders())
                .when()
                .body(postCallPojo)
                .post(APIPath.apiPath.CREATE_USER);
        System.out.println(response.prettyPrint());
    }
    @Test
    public void postCall2(){
        String payload="{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"leader\"\n" +
                "}";
        Response response= given()
                .headers(headers.defaultHeaders())
                .body(payload)
                .when()
                .post(APIPath.apiPath.CREATE_USER);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void DesertTest1(){
        ListPojo listPojo = given().headers(headers.defaultHeaders()).when().get(APIPath.apiPath.GET_CALL).as(ListPojo.class);
        List<DataPojo> list=listPojo.getData();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFirst_name().equalsIgnoreCase("michael"))
                System.out.println(list.get(i));
        }
    }
    @Test
    public void uploadFile(){
        RestAssured.baseURI="https://the-internet.herokuapp.com/upload";
        File jbdngkxjnh = new File(PropertyReader.path);
        Response response=given().multiPart("file", jbdngkxjnh,"multipart/form-data")
                .post();
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

    }
    @Test
    public void usingJSONPath(){
        Response listPojo = given().headers(headers.defaultHeaders()).when().get(APIPath.apiPath.GET_CALL);
        JsonPath jsonPath = new JsonPath(listPojo.asString());
        List list=jsonPath.get("data");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(jsonPath.getString("data["+i+"].first_name"));
        }
        ListPojo lp = given().headers(headers.defaultHeaders()).when().get(APIPath.apiPath.GET_CALL).as(ListPojo.class);
        List<DataPojo> list1=lp.getData();
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getFirst_name());
        }

    }
}

