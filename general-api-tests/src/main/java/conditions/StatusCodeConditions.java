package conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCodeConditions implements Condition {
    private final int statusCode;

    @Override
    public void check(Response response) {

    }

    @Override
    public String toString() {
        return "StatusCodeCondition{" +
                "statusCode=" + statusCode +
                '}';
    }
}
