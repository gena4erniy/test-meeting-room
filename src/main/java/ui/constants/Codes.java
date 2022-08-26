package ui.constants;

import lombok.Getter;

@Getter
public enum Codes {

    ERROR_BAD_REQUEST(400, "Bad Request"),
    ERROR_METHOD_NOT_ALLOWED(405, "Method Not Allowed");

    Codes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;
}
