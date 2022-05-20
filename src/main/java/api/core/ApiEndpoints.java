package api.core;

public class ApiEndpoints {
    // auth-controller
    public static final String AUTH_REFRESH = "api/auth/refresh"; //POST
    public static final String AUTH_SIGNIN = "api/auth/signin"; //POST

    // event-by-admin-controller
    public static final String ADMIN_EVENTS = "api/admin/events"; //POST & PUT
    public static final String ADMIN_EVENTS_PARAM = "api/admin/events/%s"; //DELETE {eventId}
    public static final String ADMIN_ME_EVENTS = "api/admin/me/events"; //GET
    public static final String ADMIN_NOTIFY = "api/admin/notify"; //POST

    // event-controller
    public static final String EVENTS = "api/events"; //POST & PATCH
    public static final String EVENTS_PARAM = "api/events/%s"; //GET & DELETE
    public static final String ME_EVENTS = "api/me/events"; //GET

    // office-controller
    public static final String OFFICES = "api/offices"; //GET
    public static final String OFFICES_PARAM = "/api/offices/%s"; //GET {id}

    // room-controller
    public static final String ROOMS = "api/rooms"; //GET
    public static final String ROOMS_ACTIVE = "api/rooms/active"; //GET
    public static final String ROOMS_EVENTS = "api/rooms/events"; //GET
    public static final String ROOMS_EVENTS_IN_ROOMS = "api/rooms/eventsInRooms"; //GET
    public static final String ROOMS_OCCUPIED_FREE = "api/rooms/occupied-free"; //POST

    // user-controller
    public static final String USERS_ADD_DEVICE_TOKEN = "api/users/add-device-token"; //POST
    public static final String USERS_ME = "api/users/me"; //GET
    public static final String USERS_ME_OFFICE = "api/users/me/office"; //GET
}