package data;

public enum RequestType {
    POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE"), PATCH("PATCH");

    private String value;

    RequestType(String type) {
        this.value = type;
    }

    protected String getValue() {
        return value;
    }

}

