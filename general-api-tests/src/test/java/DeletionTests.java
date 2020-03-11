import conditions.Conditions;
import configs.ProjectConfigs;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.DeleteOperationGistIdService;
import services.ReadGistsInfoApiService;

public class DeletionTests {
        DeleteOperationGistIdService deleteOperationGistIdService = new DeleteOperationGistIdService();
        ReadGistsInfoApiService readGistsInfoApiService = new ReadGistsInfoApiService();

        @BeforeClass
        public static void setUp() {
            ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
            RestAssured.baseURI = config.baseUrl();
        }


        @Test
        public void verifyDeletionGistById(){
            String selectedId = readGistsInfoApiService.getAllListByField("id").get(0);
            deleteOperationGistIdService.deleteGistById(selectedId).shouldHave(Conditions.statusCode(204));
        }

        @Test
        public void verifyStarDeletionFromGist(){
            String selectedId = readGistsInfoApiService.getAllListByField("id").get(0);
            deleteOperationGistIdService.deleteStarGistById(selectedId).shouldHave(Conditions.statusCode(204));
            //TODO: cover step when there is no star for selected gist
        }

    }

