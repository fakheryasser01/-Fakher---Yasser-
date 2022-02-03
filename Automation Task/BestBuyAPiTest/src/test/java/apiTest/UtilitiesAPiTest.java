package apiTest;

import apiFactory.ApiBase;
import apiFactory.UtilitiesApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UtilitiesAPiTest {

    private ApiBase apiBase;
    private UtilitiesApi utilitiesAPi;


    @BeforeClass
    public void beforeClass() {
        apiBase = new ApiBase();
        utilitiesAPi = new UtilitiesApi(apiBase);
    }


    @Test
    public void TestGetVersion() {
        Response response = utilitiesAPi.getVersion();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestGetHealthCheck() {
        Response response = utilitiesAPi.getHealthCheck();
        Assert.assertEquals(response.getStatusCode(), 200);

    }


}
