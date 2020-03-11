import conditions.Conditions;
import configs.ProjectConfigs;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.aeonbits.owner.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.ILoggerFactory;
import services.ReadGistsInfoApiService;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertTrue;

@Slf4j
public class AllGistsTest {
    ReadGistsInfoApiService readGistsInfoApiService = new ReadGistsInfoApiService();


    @BeforeClass
    public static void setUp() {

        ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void verifyAllAvailableGists() {
        readGistsInfoApiService.getListOfAlllGists()
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField(".", not(isEmptyOrNullString())));
    }

    @Test
    public void verifyAllPublicGists() {
        ArrayList<Boolean> values = readGistsInfoApiService.getListOfAllPublicGists()
                .shouldHave(Conditions.statusCode(200))
                .response.body().path("public");
        assertTrue("Not all gists are public", values.stream().distinct().collect(Collectors.toList()).get(0));

//make sure that it should be sorted by recently updated
    }

    @Test
    public void verifyAllStarredGists() {
        readGistsInfoApiService.getListOfAllStarredGists()
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField(".", not(isEmptyOrNullString())));
    }

    @Test
    public void verifyAllPublicGistsForUser() {
        ArrayList<Boolean> values = readGistsInfoApiService.getListOfAllGistsForUser()
                .shouldHave(Conditions.statusCode(200))
                .response.body().path("public");
        if (values.stream().distinct().collect(Collectors.toList()).isEmpty()) {
        }
        assertTrue("Not all gists are public", values.stream().distinct().collect(Collectors.toList()).get(0));
    }

}
