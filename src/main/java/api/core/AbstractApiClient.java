package api.core;

import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public abstract class AbstractApiClient {

    protected abstract String getBaseURL();

    protected static final EncoderConfig UTF8_ENCODER = EncoderConfig.encoderConfig()
            .defaultContentCharset(StandardCharsets.UTF_8);

    protected static final Logger logger
            = LoggerFactory.getLogger(AbstractApiClient.class);

    protected <T> RequestSpecification request(Map<String, T> headers) {
        return request().headers(headers);
    }

    protected RequestSpecification request() {
        return given()
//                .filter(new AllureRestAssured())
                .filter(new RequestLoggingFilter())
                .baseUri(getBaseURL())
                .contentType(ContentType.JSON);
    }

    protected <T> RequestSpecification response(Map<String, T> headers, Map<String, String> formParams) {
        return request(headers)
                .config(config.encoderConfig(UTF8_ENCODER))
                .params(formParams);
    }

    protected RequestSpecification responseQuery(Map<String, Object> query) {
        return request()
                .queryParams(query)
                .config(config.encoderConfig(UTF8_ENCODER))
                .header("Origin", getBaseURL());
    }

    protected Response performGetCall(String endpointPart) {
        Response response = request().get(endpointPart);
        return response;
    }

    protected Response performGetCallQuery(String endpointPart, Map<String, Object> query) {
        Response response = responseQuery(query).get(endpointPart);
        return response;
    }

    protected Response performPostCall(String endpointPart, JSONObject body) {
        return request().body(body.toString()).post(endpointPart);
    }

    protected Response performPatchCall(String endpointPart, JSONObject body) {
        return request().body(body.toString()).patch(endpointPart);
    }

    protected Response performDeleteCall(String endpointPart) {
        Response response = request().delete(endpointPart);
        return response;
    }

    protected Response performPutCall(String endpointPart, JSONObject body) {
        return request().body(body.toString()).put(endpointPart);
    }

}