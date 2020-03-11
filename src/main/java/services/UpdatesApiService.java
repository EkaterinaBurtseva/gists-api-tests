package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;

public class UpdatesApiService extends ApiBaseService {
    String generateGist() {
        return "";
    }

    @Step("Get gist by id {}")
    public AssertableResponse getGistById(String gistInfo) {
        return new AssertableResponse(setup()
                .body(gistInfo)
                .post(ALL_GISTS)
        );
    }

}
