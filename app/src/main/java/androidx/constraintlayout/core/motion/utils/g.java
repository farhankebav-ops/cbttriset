package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class g {
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "transitionFlags":
                return 707;
            case "duration":
                return 700;
            case "motionInterpolator":
                return 705;
            case "autoTransition":
                return 704;
            case "to":
                return 702;
            case "from":
                return 701;
            case "pathMotionArc":
                return 509;
            case "staggered":
                return 706;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 == 509) {
            return 2;
        }
        switch (i2) {
            case 700:
                return 2;
            case 701:
            case 702:
                return 8;
            default:
                switch (i2) {
                    case 705:
                    case 707:
                        return 8;
                    case 706:
                        return 4;
                    default:
                        return -1;
                }
        }
    }
}
