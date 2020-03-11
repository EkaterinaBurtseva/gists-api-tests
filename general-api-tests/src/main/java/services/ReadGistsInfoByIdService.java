package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;

public class ReadGistsInfoByIdService extends ApiBaseService {

    @Step("Get gist by id {}")
    public AssertableResponse getGistById(String id) {
        return new AssertableResponse(setup()
                .get(String.format("%s/%s", ALL_GISTS, id))
        );
    }

    @Step("Get gist by id {} and revision {}")
    public AssertableResponse getGistByIdAndRevision(String id, String revision) {
        return new AssertableResponse(setup()
                .get(String.format("%s/%s/%s", ALL_GISTS, id, revision))
        );
    }

    @Step("Get commits of gist by id {}")
    public AssertableResponse getCommitsGistById(String id) {
        return new AssertableResponse(setup()
                .get(String.format("%s/%s/commits", ALL_GISTS, id))
        );
    }

    @Step("Get starred status of gist by id {}")
    public AssertableResponse getStarredStatusOfGistById(String id) {
        return new AssertableResponse(setup()
                .get(String.format("%s/%s/star", ALL_GISTS, id))
        );
    }

    @Step("Get fork of gist by id {}")
    public AssertableResponse getForkOfGistById(String id) {
        return new AssertableResponse(setup()
                .get(String.format("%s/%s/fork", ALL_GISTS, id))
        );
    }
}
