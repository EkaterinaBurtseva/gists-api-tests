package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;

public class DeleteOperationGistIdService extends ApiBaseService {

    @Step("Delete gist by id {id}")
    public AssertableResponse deleteGistById(String id) {
        return new AssertableResponse(setup()
                .delete(ALL_GISTS + id)
        );
    }

    @Step("Delete star from gist by id {id}")
    public AssertableResponse deleteStarGistById(String id) {
        return new AssertableResponse(setup()
                .delete(String.format("%s/%s/star", ALL_GISTS, id))
        );
    }

    @Step("Get gists for unathorized user")
    public AssertableResponse getGistsForUnathorizedUser() {
        return new AssertableResponse(setupUnAuthorized()
                .delete(String.format(ALL_GISTS))
        );
    }
}
