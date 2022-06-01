package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class OfficeIdDto {
    private String officeId;


    public JSONObject createOfficeIdBody(Integer officeId) {
        JSONObject body = new JSONObject();
        body.put("officeId", officeId);
        return body;
    }
}
