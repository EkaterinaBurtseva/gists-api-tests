package services;

import configs.ProjectConfigs;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiBaseService {
    ProjectConfigs config = ConfigFactory.create(ProjectConfigs.class, System.getProperties());
    static String ALL_GISTS = "/gists";
        protected RequestSpecification setup() {
            return RestAssured
                    .given().auth().oauth2(config.authToken())
                    .contentType(ContentType.JSON)
                    .filters(getFilters());
        }
    protected RequestSpecification setupUnAuthorized() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

        private List<Filter> getFilters() {
            if (config.logging())
                return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
            else
                return Collections.singletonList(new AllureRestAssured());

        }
}
