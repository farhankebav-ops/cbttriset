package androidx.camera.view;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static String nameOf(int i2) {
        if (i2 == 0) {
            return "AUTO";
        }
        if (i2 == 1) {
            return "ON";
        }
        if (i2 == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException(a1.a.g(i2, "Unknown flash mode "));
    }

    public static int valueOf(String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        switch (str) {
            case "ON":
                return 1;
            case "OFF":
                return 2;
            case "AUTO":
                return 0;
            default:
                throw new IllegalArgumentException("Unknown flash mode name ".concat(str));
        }
    }
}
