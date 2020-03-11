package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;
import models.GistInfo;

import java.util.HashMap;
import java.util.Map;

public class UpdatesApiService extends ApiBaseService {
    private Map<String, String> getCookie(String sid) {
        Map<String, String> cookie = new HashMap<>();
        cookie.put("md.sid", sid);

        return cookie;
    }

    @Step("Add new gists")
    public AssertableResponse addGists(GistInfo gistInfo) {
        return new AssertableResponse(setup()
                .when()
                .body(gistInfo)
                .post(ALL_GISTS)
        );
    }

    @Step("Update gist by id {}")
    public AssertableResponse updateGist(GistInfo gistInfo, String id) {
        return new AssertableResponse(setup()
                .when()
                .body(gistInfo)
                .patch(String.format("%s/%s", ALL_GISTS, id))
        );
    }

    @Step("Set star to gist by id {}")
    public AssertableResponse setStarredGistById(GistInfo gistInfo) {
        return new AssertableResponse(setup()
                .when()
                .body(gistInfo)
                .put(String.format("%s/%s/star", ALL_GISTS ))
        );
    }

    @Step("Fork a gist by id {}")
    public AssertableResponse forkGistById(GistInfo gistInfo, String id) {
        return new AssertableResponse(setup()
                .when()
                .body(gistInfo)
                .put(String.format("%s/%s/fork", ALL_GISTS, id))
        );
    }
}
