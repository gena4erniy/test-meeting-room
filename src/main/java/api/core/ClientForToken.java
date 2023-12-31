package api.core;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ClientForToken extends BaseApiClient {

    @Override
    protected String getBaseURL() {
        return "https://meetingroom.andersenlab.dev/";
    }

    @Override
    protected RequestSpecification request() {
        return super.request()
                .contentType(ContentType.JSON)
                .header("charset", "utf-8")
                .header("User-Agent", "Passport-Test")
                .header("responseType", "ResponseType.json")
                .header("followRedirects", true)
                .header("connectTimeout", 0)
                .header("receiveTimeout", 0);
    }
}