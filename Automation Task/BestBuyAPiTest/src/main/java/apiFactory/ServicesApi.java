package apiFactory;

import data.RequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


public class ServicesApi {

    private ApiBase apiBase;
    String endPoint = "services";

    public ServicesApi(ApiBase apiBase) {
        this.apiBase = apiBase;
    }


    public Response getAllServices() {
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, null, null);
    }


    public Response addNewService() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "apiTest");

        JSONObject header = new JSONObject();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");

        return apiBase.performRequest(RequestType.POST, endPoint, 201, header,
                ContentType.JSON, null, null, requestBody);
    }


    public Response getServicesByID(String id) {
        return apiBase.performRequest(RequestType.GET, endPoint + "/" + id, 200, null,
                ContentType.JSON, null, null, null);
    }

    public Response updateServiceDetails(String serviceId) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Updated Store Name Value");
        requestBody.put("type", "Updated Store type value");
        return apiBase.performRequest(RequestType.PATCH, endPoint + "/" + serviceId, 200, null,
                ContentType.JSON, null, null, requestBody);
    }

    public Response deleteService(String ServiceId) {

        return apiBase.performRequest(RequestType.DELETE, endPoint + "/" + ServiceId, 200, null,
                ContentType.JSON, null, null, null);
    }

}
