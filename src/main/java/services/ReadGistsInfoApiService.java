package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;

public class ReadGistsInfoApiService extends ApiBaseService {
    static String ALL_PUBLIC_GISTS = ALL_GISTS + "/public";
    static String ALL_STARRED_GISTS = ALL_GISTS + "/starred";

    @Step("Get all gists")
    public AssertableResponse getListOfAlllGists() {
        return new AssertableResponse(setup()
                .get(ALL_GISTS)
        );
    }

    @Step("Get all public gists")
    public AssertableResponse getListOfAllPublicGists() {
        return new AssertableResponse(setup()
                .get(ALL_PUBLIC_GISTS)
        );
    }

    @Step("Get all starred gists")
    public AssertableResponse getListOfAllStarredGists() {
        return new AssertableResponse(setup()
                .get(ALL_STARRED_GISTS)
        );
    }

    @Step("Get all gists for user {}")
    public AssertableResponse getListOfAllGistsForUser(String user) {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", user, ALL_GISTS))
        );
    }

    @Step("Get public gists for user {}")
    public AssertableResponse getListOfAllPublicGistsForUser(String user) {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", user, ALL_PUBLIC_GISTS))
        );
    }

    @Step("Get starred gists for user {}")
    public AssertableResponse getListOfAllStarredGistsForUser(String user) {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", user, ALL_STARRED_GISTS))
        );
    }

}
