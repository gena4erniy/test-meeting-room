package api.dto;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ListOfOfficesResponse {
    private String jsonListOffices ="[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"country\": \"Belarus\",\n" +
            "        \"city\": \"Minsk\",\n" +
            "        \"timezone\": null,\n" +
            "        \"rooms\": [\n" +
            "            \"White\",\n" +
            "            \"Black\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 2,\n" +
            "        \"country\": \"Belarus\",\n" +
            "        \"city\": \"Gomel\",\n" +
            "        \"timezone\": null,\n" +
            "        \"rooms\": [\n" +
            "            \"Red\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 3,\n" +
            "        \"country\": \"Russia\",\n" +
            "        \"city\": \"Saint Petersburg\",\n" +
            "        \"timezone\": null,\n" +
            "        \"rooms\": [\n" +
            "            \"Yellow\",\n" +
            "            \"Orange\",\n" +
            "            \"Gray\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 4,\n" +
            "        \"country\": \"Ukraine\",\n" +
            "        \"city\": \"Kiev\",\n" +
            "        \"timezone\": null,\n" +
            "        \"rooms\": [\n" +
            "            \"Red\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 5,\n" +
            "        \"country\": \"Russia\",\n" +
            "        \"city\": \"Kazan\",\n" +
            "        \"timezone\": null,\n" +
            "        \"rooms\": [\n" +
            "            \"Blue\"\n" +
            "        ]\n" +
            "    }\n" +
            "]";
}
