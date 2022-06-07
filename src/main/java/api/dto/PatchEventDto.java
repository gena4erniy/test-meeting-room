package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder

public class PatchEventDto {
    private String description;
    private String title;
    private Integer roomId;


    public JSONObject createPatchEventBody(String startDateTime, Integer id, String endDateTime) {
        JSONObject body = new JSONObject();
        body.put("description", getDescription());
        body.put("endDateTime", endDateTime);
        body.put("id", id);
        body.put("roomId", getRoomId());
        body.put("startDateTime", startDateTime);
        body.put("title", getTitle());
        return body;
    }
}
