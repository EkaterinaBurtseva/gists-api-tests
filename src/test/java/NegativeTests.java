import org.junit.Test;

public class NegativeTests {
    @Test()
    void verifyAccesstoGistForNonAuthorizedUser(){

    }

    @Test
    void verifyUpdateOperationForNonExistedGistById(){
        //should be an error or 404?
    }

    @Test
    void verifyListOfCommitsForNonExistedGist(){

    }

    @Test
    void verifyAllGistsForNonExistedUser(){

    }
}
