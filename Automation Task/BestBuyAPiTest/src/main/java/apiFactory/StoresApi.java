package apiFactory;

import data.RequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


public class StoresApi {

    private ApiBase apiBase;
    String endPoint = "stores";

    public StoresApi(ApiBase apiBase) {
        this.apiBase = apiBase;
    }


    public Response getAllStores() {
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, null, null);
    }


    public Response addNewStore() {
        JSONObject services = new JSONObject();

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "StoreTestName");
        requestBody.put("type", "StoreType");
        requestBody.put("address", "12 st");
        requestBody.put("address2", "15 st");
        requestBody.put("city", "Cairo");
        requestBody.put("state", "Cairo");
        requestBody.put("zip", "02277");
        requestBody.put("lat", 5);
        requestBody.put("lng", 5);
        requestBody.put("services", services);


        JSONObject header = new JSONObject();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");

        return apiBase.performRequest(RequestType.POST, endPoint, 201, header,
                ContentType.JSON, null, null, requestBody);
    }


    public Response getStoreByID(String id) {
        return apiBase.performRequest(RequestType.GET, endPoint + "/" + id, 200, null,
                ContentType.JSON, null, null, null);
    }

    public Response updateStoreDetails(String storeId) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Updated Store Name Value");
        requestBody.put("type", "Updated Store type value");
        return apiBase.performRequest(RequestType.PATCH, endPoint + "/" + storeId, 200, null,
                ContentType.JSON, null, null, requestBody);
    }

    public Response deleteStore(String storeId) {

        return apiBase.performRequest(RequestType.DELETE, endPoint + "/" + storeId, 200, null,
                ContentType.JSON, null, null, null);
    }

}
