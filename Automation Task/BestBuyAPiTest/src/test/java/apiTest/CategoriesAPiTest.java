package apiTest;

import apiFactory.ApiBase;
import apiFactory.CategoriesApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CategoriesAPiTest {

    private ApiBase apiBase;
    private CategoriesApi categoriesApi;
    private String categoriesId;


    @BeforeClass
    public void beforeClass() {
        apiBase = new ApiBase();
        categoriesApi = new CategoriesApi(apiBase);
    }


    @Test
    public void testGetALlCategoriesSuccessfully() {
        Response response = categoriesApi.getAllCategories();
        System.out.println(response.jsonPath().get("data[0].id").toString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("data[0].id").toString(), "abcat0010000");
        Assert.assertEquals(response.jsonPath().get("limit").toString(), "10");
        Assert.assertNotEquals(response.jsonPath().get("total").toString(), "0");

    }


    @Test
    public void testAddCategorySuccessfully() {
        Response response = categoriesApi.addNewCategories();
        categoriesId = response.jsonPath().get("id").toString();
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "test names v");
        Assert.assertEquals(response.jsonPath().get("id").toString(), "test ids v");


    }

    @Test
    public void testFindCategoryByIdSuccessfully() {
        Response response = categoriesApi.getCategoriesByID(categoriesId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), categoriesId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "test names v");
        Assert.assertEquals(response.jsonPath().get("id").toString(), "test ids v");

    }


    @Test
    public void testUpdateCategorySuccessfully() {
        Response response = categoriesApi.updateCategoriesDetails(categoriesId);
        Assert.assertEquals(response.jsonPath().get("id").toString(), categoriesId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Category Name Value");
        Assert.assertEquals(response.jsonPath().get("id").toString(), "test ids v");

    }

    @Test
    public void testDeleteCategorySuccessfully() {
        Response response = categoriesApi.deleteCategories(categoriesId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), categoriesId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Category Name Value");
        Assert.assertEquals(response.jsonPath().get("id").toString(), "test ids v");
    }


}
