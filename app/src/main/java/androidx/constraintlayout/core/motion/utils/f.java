package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "transitionEasing":
                return 501;
            case "percentWidth":
                return 503;
            case "percentHeight":
                return 504;
            case "drawPath":
                return 502;
            case "sizePercent":
                return 505;
            case "percentX":
                return 506;
            case "percentY":
                return 507;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 == 100) {
            return 2;
        }
        if (i2 == 101) {
            return 8;
        }
        switch (i2) {
            case 501:
            case 502:
                return 8;
            case 503:
            case 504:
            case 505:
            case 506:
            case 507:
                return 4;
            case 508:
                return 2;
            default:
                return -1;
        }
    }
}
