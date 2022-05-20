package api.core;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class BaseApiClient extends AbstractApiClient {

    public String baseUrl;

    public BaseApiClient setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public BaseApiClient getBaseUrl() {
        baseUrl = baseUrl;
        return this;
    }

    public <T> T getCall(String endpoint) throws JSONException {
        return getResponseAnswer(performGetCall(endpoint));
    }

    public <T> T getCallQuery(String endpoint, Map<String, Object> query) throws JSONException {
        return getResponseAnswer(performGetCallQuery(endpoint, query));
    }

    public <T> T postCall(String endpoint, JSONObject object) throws JSONException {
        return getResponseAnswer(performPostCall(endpoint, object));
    }

    public <T> T patchCall(String endpoint, JSONObject object) throws JSONException {
        return getResponseAnswer(performPatchCall(endpoint, object));
    }

    public <T> T getResponseAnswer(Response r) throws JSONException {

        logger.debug("-------------------------------");
        logger.debug("Headers : ");
        logger.debug("" + r.getHeaders());
        logger.debug("-------------------------------");
        logger.debug("Execute Time: " + r.getTime());
        logger.debug("-------------------------------");
        logger.debug("Status Code: " + r.getStatusCode());
        logger.debug("-------------------------------");

        try {
            JSONObject body = new JSONObject(r.getBody().prettyPrint());
            body.put("Status Code", r.getStatusCode());
            logger.info("-------------------------------");
            return (T) body;
        } catch (JSONException ex) {
            try {
                JSONObject body = new JSONObject();
                body.put("Status Code", r.getStatusCode());
                body.put("Body", new JSONArray((r.getBody())));
                return (T) body;
            } catch (Exception e) {
                JSONObject body = new JSONObject();
                body.put("Status Code", r.getStatusCode());
                body.put("Body", r.getBody().prettyPrint());
                logger.debug("Body Response: " + r.getBody());
                return (T) body;
            }
        }
    }

    @Override
    protected String getBaseURL() {
        return null;
    }
}