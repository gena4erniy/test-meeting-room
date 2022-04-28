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
        public static final String NAME_DEVICE = "emulator-5554";
        public static final String APP_PACKAGE = "com.andersenlab.meeting_room.debug";
        public static final String APP_ACTIVITY = "com.meetingroom.android.ui.MainActivity";
        public static final String NAME_AUTOMATION = "Appium";
    }

    public static class ValidCredo {
        public static final String VALID_MAIL = "user1@gmail.com";
        public static final String VALID_PASS = "1111";
    }
}