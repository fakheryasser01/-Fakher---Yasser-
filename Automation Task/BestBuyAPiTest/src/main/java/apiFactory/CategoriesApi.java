package apiFactory;

import data.RequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


public class CategoriesApi {

    private ApiBase apiBase;
    String endPoint = "categories";

    public CategoriesApi(ApiBase apiBase) {
        this.apiBase = apiBase;
    }


    public Response getAllCategories() {
        return apiBase.performRequest(RequestType.GET, endPoint, 200, null,
                ContentType.JSON, null, null, null);
    }


    public Response addNewCategories() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "test names v");
        requestBody.put("id", "test ids v");

        JSONObject header = new JSONObject();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");

        return apiBase.performRequest(RequestType.POST, endPoint, 201, header,
                ContentType.JSON, null, null, requestBody);
    }


    public Response getCategoriesByID(String id) {
        return apiBase.performRequest(RequestType.GET, endPoint + "/" + id, 200, null,
                ContentType.JSON, null, null, null);
    }

    public Response updateCategoriesDetails(String serviceId) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Updated Category Name Value");

        return apiBase.performRequest(RequestType.PATCH, endPoint + "/" + serviceId, 200, null,
                ContentType.JSON, null, null, requestBody);
    }

    public Response deleteCategories(String ServiceId) {

        return apiBase.performRequest(RequestType.DELETE, endPoint + "/" + ServiceId, 200, null,
                ContentType.JSON, null, null, null);
    }

}
