package apiFactory;

import data.RequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UtilitiesApi {

    private ApiBase apiBase;


    public UtilitiesApi(ApiBase apiBase) {
        this.apiBase = apiBase;
    }


    public Response getVersion() {
        return apiBase.performRequest(RequestType.GET, "version", 200, null,
                ContentType.JSON, null, null, null);
    }

    public Response getHealthCheck() {
        return apiBase.performRequest(RequestType.GET, "healthcheck", 200, null,
                ContentType.JSON, null, null, null);
    }


}
