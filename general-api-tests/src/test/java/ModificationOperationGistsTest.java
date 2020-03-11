import conditions.Conditions;
import configs.ProjectConfigs;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import models.FileData;
import models.FileInfoContent;
import models.GistInfo;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ReadGistsInfoApiService;
import services.ReadGistsInfoByIdService;
import services.UpdatesApiService;

@Slf4j
public class ModificationOperationGistsTest {

    UpdatesApiService updatesApiService = new UpdatesApiService();
    ReadGistsInfoApiService readGistsInfoApiService = new ReadGistsInfoApiService();
    String selectedId = readGistsInfoApiService.getAllListByField("id").get(0);
    ReadGistsInfoByIdService readGistsInfoByIdService = new ReadGistsInfoByIdService();

    @BeforeClass
    public static void setUp() {
        ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
    }


    @Test
    public void verifyAdditionOfNewGists() {
        int actValue = readGistsInfoApiService.getAllListByField("id").size();
        FileInfoContent fileInfoContent = new FileInfoContent().content("blabla")
                .fileName("kb-test-file");
        FileData fileData = new FileData().fileDataName(fileInfoContent);
        GistInfo gistInfo = new GistInfo().description("new gist -test")
                .files(fileData);
        updatesApiService.addGists(gistInfo).shouldHave(Conditions.statusCode(200));
        int changedValue = readGistsInfoApiService.getAllListByField("id").size();
        Assert.assertTrue(actValue < changedValue, "Gist isn't added");
    }


    @Test
    public void verifyUpdateOperationForExistingGistById() {
        FileInfoContent fileInfoContent = new FileInfoContent().content("anycontent")
                .fileName("kb-test-file");
        FileData fileData = new FileData().fileDataName(fileInfoContent);
        GistInfo gistInfo = new GistInfo().description("updated gist -test")
                .files(fileData);
        updatesApiService.updateGist(gistInfo, selectedId).shouldHave(Conditions.statusCode(200));
    }

    @Test
    public void verifyListOfCommitsForExistedGist() {
        ReadGistsInfoByIdService readGistsInfoByIdService = new ReadGistsInfoByIdService();
        readGistsInfoByIdService.getCommitsGistById(selectedId).shouldHave(Conditions.statusCode(200));
    }

    @Test
    public void verifySpecificVersionOfGistByRevision() {
//TODO:implement a method
    }

    @Test
    public void verifyAbilityToSetStarGistById() {
    }

    @Test
    public void verifyWhetherGistByIdStarred() {
        readGistsInfoByIdService.getStarredStatusOfGistById(selectedId).shouldHave(Conditions.statusCode(200));
    }
}
