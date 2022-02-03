package apiFactory;

import data.RequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.HashMap;


public class ProductsApi {

    private ApiBase apiBase;
    String endPoint = "products";

    public ProductsApi(ApiBase apiBase) {
        this.apiBase = apiBase;
    }


    public Response getProducts() {

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, null, null);
    }


    public Response addProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "apiTest");
        requestBody.put("type", "TestType");
        requestBody.put("price", 123);
        requestBody.put("shipping", 456);
        requestBody.put("upc", "UPCTest");
        requestBody.put("description", "We are Testing");
        requestBody.put("manufacturer", "manufacturerTest");
        requestBody.put("model", "hjk845151");
        requestBody.put("url", "https://www.google");
        requestBody.put("image", "ImageTest");


//        Map<String , Object > header = new HashMap<String,Object>();
//        header.put("Content-Type","application/json");
//        header.put("Accept","application/json");
        return apiBase.performRequest(RequestType.POST, endPoint, 201, null,
                ContentType.JSON, null, null, requestBody);
    }


    public Response updateProduct(String productID) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Updated Test Name value");
        requestBody.put("type", "Updated type value");
        return apiBase.performRequest(RequestType.PATCH, endPoint + "/" + productID, 200, null,
                ContentType.JSON, null, null, requestBody);
    }


    public Response deleteProduct(String productID) {

        return apiBase.performRequest(RequestType.DELETE, endPoint + "/" + productID, 200, null,
                ContentType.JSON, null, null, null);
    }


    public Response getProductByID(String id) {
        return apiBase.performRequest(RequestType.GET, endPoint + "/" + id, 200, null,
                ContentType.JSON, null, null, null);
    }

    public Response getLimitedProduct(String limit) {

        JSONObject queryParams = new JSONObject();
        queryParams.put("$limit", limit);
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }

    public Response getSkippedProduct(String skip) {

        JSONObject queryParams = new JSONObject();
        queryParams.put("$skip", skip);
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }

    public Response sortProductByHighestPrice() {

        JSONObject queryParams = new JSONObject();
        queryParams.put("$sort[price]", "-1");
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }

    public Response sortProductByLowestPrice() {

        JSONObject queryParams = new JSONObject();
        queryParams.put("$sort[price]", "1");
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response shownNameAndPriceOfAllProducts() {

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("$select[]", Arrays.asList("name", "price"));

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }

    public Response productsWithHardGood() {

        JSONObject queryParams = new JSONObject();
        queryParams.put("type", "HardGood");

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response productsWithPriceLessThanDollar() {
        JSONObject queryParams = new JSONObject();
        queryParams.put("price[$lte]", "1");

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response showSpecPrice() {

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("price[$in]", Arrays.asList("0.99", "1.99"));

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }

    public Response productsWithShipPriceMoreThan10Dollar() {
        JSONObject queryParams = new JSONObject();
        queryParams.put("shipping[$gt]", "10");

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response showSpecType() {

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("type[$nin][]", Arrays.asList("HardGood", "Software"));

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response productsByCategoryName() {
        JSONObject queryParams = new JSONObject();
        queryParams.put("category.name", "Coffee Pods");

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }


    public Response productsByCategoryId() {
        JSONObject queryParams = new JSONObject();
        queryParams.put("category.id", "abcat0106004");

        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, queryParams, null);
    }
}
