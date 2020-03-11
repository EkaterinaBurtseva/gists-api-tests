import configs.ProjectConfigs;
import io.restassured.RestAssured;
import models.AllGistsResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import services.ReadGistsInfoApiService;

public class AllGistsTest {

    @BeforeClass
    public static void setUp() {

        ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        String userName = config.username();
    }

    //GET /gists
    @Test
    public void verifyAllAvailableGists(){
        ReadGistsInfoApiService readGistsInfoApiService = new ReadGistsInfoApiService();
        readGistsInfoApiService.getListOfAlllGists()
                .asPojo(AllGistsResponse.class);

    }

    @Test
    public void verifyAllPublicGists(){
//make sure that it should be sorted by recently updated
    }

    @Test
    public void verifyAllStarredGists(){

    }

}
