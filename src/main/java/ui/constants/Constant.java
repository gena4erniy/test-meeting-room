package ui.constants;

public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 4;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls {
        public static final String DRIVER_URL = "http://127.0.0.1:4723/wd/hub";
    }

    public static class Capabilities {
        public static final String NAME_DEVICE = "Pixel 2 XL API 30";
        public static final String APP_PACKAGE = "com.andersenlab.meeting_room.debug";
        public static final String APP_ACTIVITY = "com.meetingroom.android.ui.MainActivity";
        public static final String NAME_AUTOMATION = "uiautomator2";
    }

    public static class ValidCredo {
        public static final String VALID_MAIL = "user1@gmail.com";
        public static final String VALID_PASS = "1111";

        public static final String VALID_MAIL_ADMIN = "n.ermakov@andersenlab.com";
        public static final String VALID_PASS_ADMIN = "helloworld";
    }
    public static class ValidNoEventRoomCredo{
        public static final String VALID_MAIL_NO_EVENT_ROOM = "user8@gmail.com";
        public static final String VALID_PASS_NO_EVENT_ROOM = "8888";
    }
    public static class ValidCredoSpace {
        public static final String VALID_MAIL_SPACE = "user1 @gmail.com";
        public static final String VALID_PASS_SPACE = "11 11";
    }

    public static class InValidCredo {
        public static final String INVALID_MAIL= "user131@gmail.com";
        public static final String INVALID_PASS = "112311";
        public static final String MAX_MAIL = "1234567890123456789012345678901234567890123456789012345678901234";
        public static final String MORE_MAX_MAIL = "12345678901234567890123456789012345678901234567890123456789012345";
    }
}