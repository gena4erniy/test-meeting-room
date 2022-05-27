package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class EventDto {
    private String description;
    private String title;

    public JSONObject createEventBody() {
        JSONObject body = new JSONObject();
        body.put("description", getDescription());
        body.put("endDateTime", "2022-05-27T19:53:47.439");
        body.put("roomId", 1);
        body.put("startDateTime", "2022-05-27T17:53:47.439");
        body.put("title", getTitle());
        return body;
    }
}

