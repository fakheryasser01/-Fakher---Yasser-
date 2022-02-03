package apiTest;

import apiFactory.ApiBase;
import apiFactory.StoresApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StoresAPiTest {

    private ApiBase apiBase;
    private StoresApi storesApi;
    private String storeId;


    @BeforeClass
    public void beforeClass() {
        apiBase = new ApiBase();
        storesApi = new StoresApi(apiBase);
    }


    @Test
    public void testGetAllStoresSuccessfully() {
        Response response = storesApi.getAllStores();
        Assert.assertEquals(response.jsonPath().get("data[0].id").toString(), "4");
        Assert.assertEquals(response.jsonPath().get("limit").toString(), "10");
        Assert.assertNotEquals(response.jsonPath().get("total").toString(), "0");

    }


    @Test
    public void testAddStoreSuccessfully() {
        Response response = storesApi.addNewStore();
        storeId = response.jsonPath().get("id").toString();
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "StoreTestName");
        Assert.assertEquals(response.jsonPath().get("city").toString(), "Cairo");
        Assert.assertEquals(response.jsonPath().get("lat").toString(), "5");
        Assert.assertEquals(response.jsonPath().get("address").toString(), "12 st");

    }

    @Test
    public void testGetStoreByIdSuccessfully() {
        Response response = storesApi.getStoreByID(storeId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), storeId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "StoreTestName");
        Assert.assertEquals(response.jsonPath().get("city").toString(), "Cairo");
        Assert.assertEquals(response.jsonPath().get("lat").toString(), "5");
        Assert.assertEquals(response.jsonPath().get("address").toString(), "12 st");

    }

    @Test
    public void testUpdateStoreSuccessfully() {
        Response response = storesApi.updateStoreDetails(storeId);
        Assert.assertEquals(response.jsonPath().get("id").toString(), storeId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Store Name Value");
        Assert.assertEquals(response.jsonPath().get("type").toString(), "Updated Store type value");
        Assert.assertEquals(response.jsonPath().get("city").toString(), "Cairo");
        Assert.assertEquals(response.jsonPath().get("lat").toString(), "5");
        Assert.assertEquals(response.jsonPath().get("address").toString(), "12 st");

    }

    @Test
    public void testDeleteStoreSuccessfully() {
        Response response = storesApi.deleteStore(storeId);
        System.out.println(response.jsonPath().get("id").toString());
        Assert.assertEquals(response.jsonPath().get("id").toString(), storeId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Store Name Value");
        Assert.assertEquals(response.jsonPath().get("type").toString(), "Updated Store type value");
        Assert.assertEquals(response.jsonPath().get("city").toString(), "Cairo");
        Assert.assertEquals(response.jsonPath().get("lat").toString(), "5");
        Assert.assertEquals(response.jsonPath().get("address").toString(), "12 st");

    }


}
