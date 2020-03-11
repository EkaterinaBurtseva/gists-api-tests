package services;

import assertions.AssertableResponse;
import configs.ProjectConfigs;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.List;

public class ReadGistsInfoApiService extends ApiBaseService {
    static String ALL_PUBLIC_GISTS = ALL_GISTS + "/public";
    static String ALL_STARRED_GISTS = ALL_GISTS + "/starred";
    ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
    String userName = config.username();

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

    @Step("Get all gists for user {userName}")
    public AssertableResponse getListOfAllGistsForUser() {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", userName, ALL_GISTS))
        );
    }

    @Step("Get public gists for user {userName}")
    public AssertableResponse getListOfAllPublicGistsForUser() {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", userName, ALL_PUBLIC_GISTS))
        );
    }

    @Step("Get starred gists for user {userName}")
    public AssertableResponse getListOfAllStarredGistsForUser() {
        return new AssertableResponse(setup()
                .get(String.format("/users/%s%s", userName, ALL_STARRED_GISTS))
        );
    }

    public List<String> getAllListByField(String field){
      return ((List<String>)getListOfAllGistsForUser().response.body().path(field));
    }

}
