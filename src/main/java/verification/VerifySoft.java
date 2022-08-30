package verification;

import org.testng.asserts.SoftAssert;

public class VerifySoft {

    private static SoftAssert softAssert = new SoftAssert();

    public static <T> void verifyEqualsSoft(T actual, T expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void showAllChecking() {
        try {
            softAssert.assertAll();
        } finally {
            resetSoftAssert();
        }
    }

    public static void resetSoftAssert() {
        softAssert = new SoftAssert();
    }
}
