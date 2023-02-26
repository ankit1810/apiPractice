package dataProvider;

import org.testng.annotations.DataProvider;

public class PostCallDataProvider {
    @DataProvider(name = "postNameJobMethod")
    public Object[][] postNameJobMethod(){
        Object obj[][] = new Object[2][2];

        obj[0][0]="Vishesh";
        obj[0][1]="Soft engineer";

        obj[1][0]="Ankit";
        obj[1][1]="Berozgaar";

        return obj;
    }
}
