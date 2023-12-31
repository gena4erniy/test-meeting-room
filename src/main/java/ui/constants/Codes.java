package ui.constants;

import lombok.Getter;

@Getter
public enum Codes {

    SUCCESS_OK("200", ""),
    SUCCESS_NO_CONTENT("204", ""),
    ERROR_BAD_REQUEST("400", "Bad Request"),
    ERROR_UNAUTHORIZED("401", "Unauthorized"),
    ERROR_NOT_FOUND("404", "Not Found"),
    ERROR_METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    ERROR_NOT_ACCEPTABLE("406", "");

    Codes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
}
