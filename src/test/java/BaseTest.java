import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

import java.io.IOException;

public class BaseTest {
 @BeforeSuite
    public void setup() throws IOException {
     RestAssured.baseURI=PropertyReader.getValue("baseUrl");

 }
}