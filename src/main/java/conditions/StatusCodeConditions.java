package conditions;

import io.restassured.response.Response;

public class StatusCodeConditions implements Condition {
    private int statusCode;

    public StatusCodeConditions(int statusCode) {
    }

    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "status code is " + statusCode;
    }
}
