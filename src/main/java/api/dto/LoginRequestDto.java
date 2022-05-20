package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class LoginRequestDto {
    private String email;
    private String password;

    public JSONObject createBody() {
        JSONObject body = new JSONObject();
        body.put("email", getEmail());
        body.put("password", getPassword());
        return body;
    }
}