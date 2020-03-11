package conditions;

import io.restassured.response.Response;
import org.hamcrest.Matcher;

public class BodyFieldCondition implements Condition {
    private String jsonPath;
    private Matcher matcher;

    public BodyFieldCondition(String jsonPath, Matcher matcher) {
    }

    @Override
    public String toString() {
        return "body field [" + jsonPath + "]" + matcher;
    }

    @Override
    public void check(Response response) {
        response.then().assertThat().body(jsonPath, matcher);
    }
}
