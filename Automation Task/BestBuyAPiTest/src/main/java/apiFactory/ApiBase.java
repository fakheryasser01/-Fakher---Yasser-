package apiFactory;

import data.RequestType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiBase {


    private String baseURL = "http://localhost:3030/";
    private RequestSpecification request;
    private Response response;


    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .log(LogDetail.ALL).build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.BODY).build();


    public Response performRequest(RequestType requestType, String endPoint, int expectedStatusCode,
                                   Map<String, Object> headers, ContentType contentType, Map<String, Object> formParams,
                                   Map<String, Object> queryParams, Object body) {

        String requestUrl = baseURL + endPoint;

        System.out.println("Request Log : ");
        System.out.println("__________________________________________");

        request = given().spec(requestSpec);

        if (headers != null) {
            request.headers(headers);

        }

        if (contentType != null) {
            request.contentType(contentType);
        }

        if (formParams != null) {
            request.formParams(formParams);

        }

        if (queryParams != null) {
            request.queryParams(queryParams);

        }

        if (body != null) {
            request.body(body);

        }


        switch (requestType) {
            case POST:
                response = request.post(requestUrl);
                break;
            case GET:
                response = request.get(requestUrl);
                break;
            case PUT:
                response = request.put(requestUrl);
                break;
            case DELETE:
                response = request.delete(requestUrl);
                break;
            case PATCH:
                response = request.patch(requestUrl);
                break;
        }
        System.out.println("Response Log :  ");
        System.out.println("__________________________________________");
        response.then().spec(responseSpec).statusCode(expectedStatusCode);


        return response;
    }


}
