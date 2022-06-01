package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class EventDto {
    private String description;
    private String title;

    public JSONObject createEventBody(String startDateTime, String endDateTime) {
        JSONObject body = new JSONObject();
        body.put("description", getDescription());
        body.put("endDateTime", endDateTime);
        body.put("roomId", 1);
        body.put("startDateTime", startDateTime);
        body.put("title", getTitle());
        return body;
    }
}


