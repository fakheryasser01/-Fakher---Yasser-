package apiTest;

import apiFactory.ApiBase;
import apiFactory.ProductsApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProductsAPiTest {

    private ApiBase apiBase;
    private ProductsApi productsApi;
    private String productId;
    String endPoint = "products";

    @BeforeClass
    public void beforeClass() {
        apiBase = new ApiBase();
        productsApi = new ProductsApi(apiBase);
    }


    @Test
    public void testGetALlProductsSuccessfully() {
        Response response = productsApi.getProducts();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("data[0].id").toString(), "43900");
        Assert.assertEquals(response.jsonPath().get("limit").toString(), "10");
        Assert.assertNotEquals(response.jsonPath().get("total").toString(), "0");

    }


    @Test
    public void testAddProductSuccessfully() {
        Response response = productsApi.addProduct();
        productId = response.jsonPath().get("id").toString();
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "apiTest");
        Assert.assertEquals(response.jsonPath().get("shipping").toString(), "456");
        Assert.assertEquals(response.jsonPath().get("description").toString(), "We are Testing");
        Assert.assertEquals(response.jsonPath().get("model").toString(), "hjk845151");
    }

    @Test
    public void testFindProductByIdSuccessfully() {
        Response response = productsApi.getProductByID(productId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), productId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "apiTest");
        Assert.assertEquals(response.jsonPath().get("shipping").toString(), "456");
        Assert.assertEquals(response.jsonPath().get("description").toString(), "We are Testing");
        Assert.assertEquals(response.jsonPath().get("model").toString(), "hjk845151");
    }

    @Test
    public void testUpdateProductSuccessfully() {
        Response response = productsApi.updateProduct(productId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), productId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Test Name value");
        Assert.assertEquals(response.jsonPath().get("type").toString(), "Updated type value");
        Assert.assertEquals(response.jsonPath().get("shipping").toString(), "456");
        Assert.assertEquals(response.jsonPath().get("description").toString(), "We are Testing");
        Assert.assertEquals(response.jsonPath().get("model").toString(), "hjk845151");

    }

    @Test
    public void testDeleteProductSuccessfully() {
        Response response = productsApi.deleteProduct(productId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), productId);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Updated Test Name value");
        Assert.assertEquals(response.jsonPath().get("type").toString(), "Updated type value");
        Assert.assertEquals(response.jsonPath().get("shipping").toString(), "456");
        Assert.assertEquals(response.jsonPath().get("description").toString(), "We are Testing");
        Assert.assertEquals(response.jsonPath().get("model").toString(), "hjk845151");

    }


    @Test
    public void testLimitedProduct() {
        Response response = productsApi.getLimitedProduct("1");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void testSkippedProduct() {
        Response response = productsApi.getSkippedProduct("25000");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestSortProductByHighestPrice() {
        Response response = productsApi.sortProductByHighestPrice();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestSortProductByLowestPrice() {
        Response response = productsApi.sortProductByLowestPrice();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestShownNameAndPriceOfAllProducts() {
        Response response = productsApi.shownNameAndPriceOfAllProducts();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void TestProductsWithHardGood() {
        Response response = productsApi.productsWithHardGood();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void TestProductsWithPriceLessThanDollar() {
        Response response = productsApi.productsWithPriceLessThanDollar();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void showSpecPrice() {
        Response response = productsApi.showSpecPrice();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void showProductsWithShipPriceMoreThan10Dollar() {
        Response response = productsApi.productsWithShipPriceMoreThan10Dollar();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void showSpecType() {
        Response response = productsApi.showSpecType();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void showProductsByCategoryName() {
        Response response = productsApi.productsByCategoryName();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void showProductsByCategoryId() {
        Response response = productsApi.productsByCategoryId();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
