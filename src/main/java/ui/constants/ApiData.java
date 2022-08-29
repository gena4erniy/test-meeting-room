package ui.constants;

import helpers.PropertiesProvider;

public class ApiData {

    public static final String DB_URL = PropertiesProvider.provideProperty("dbUrl");
    public static final String DB_USER = PropertiesProvider.provideProperty("dbUser");
    public static final String DB_PASS = PropertiesProvider.provideProperty("dbPass");
}
