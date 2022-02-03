package apiTest;

import apiFactory.ApiBase;
import apiFactory.ServicesApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ServicesAPiTest {

    private ApiBase apiBase;
    private ServicesApi servicesApi;
    private String serviceId;


    @BeforeClass
    public void beforeClass() {
        apiBase = new ApiBase();
        servicesApi = new ServicesApi(apiBase);
    }


    @Test
    public void TestGetAllServices() {
        Response response = servicesApi.getAllServices();
        System.out.println(response.jsonPath().get("data[0].id").toString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }


    @Test
    public void addServices() {
        Response response = servicesApi.addNewService();
        serviceId = response.jsonPath().get("id").toString();

    }

    @Test
    public void TestServicesAppears() {
        Response response = servicesApi.getServicesByID(serviceId);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestUpdateServicesDetails() {
        Response response = servicesApi.updateServiceDetails(serviceId);

    }

    @Test
    public void deleteServices() {
        Response response = servicesApi.deleteService(serviceId);
        System.out.println(response.jsonPath().get("id").toString());

    }


}
