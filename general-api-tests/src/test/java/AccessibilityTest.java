import conditions.Conditions;
import configs.ProjectConfigs;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.DeleteOperationGistIdService;

public class AccessibilityTest {
    DeleteOperationGistIdService deleteOperationGistIdService = new DeleteOperationGistIdService();

    @BeforeClass
    public static void setUp() {
        ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void verifyNoAccessForUnathorizedUser() {
        deleteOperationGistIdService.getGistsForUnathorizedUser().shouldHave(Conditions.statusCode(404));

    }
}
