package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "easing":
                return 317;
            case "rotationX":
                return 308;
            case "rotationY":
                return 309;
            case "rotationZ":
                return 310;
            case "translationX":
                return 304;
            case "translationY":
                return 305;
            case "translationZ":
                return 306;
            case "progress":
                return 315;
            case "pivotX":
                return 313;
            case "pivotY":
                return 314;
            case "scaleX":
                return 311;
            case "scaleY":
                return 312;
            case "target":
                return 101;
            case "elevation":
                return 307;
            case "alpha":
                return 303;
            case "frame":
                return 100;
            case "curveFit":
                return 301;
            case "pathRotate":
                return 316;
            case "pivotTarget":
                return 318;
            case "visibility":
                return 302;
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
            case 301:
            case 302:
                return 2;
            case 303:
            case 304:
            case 305:
            case 306:
            case 307:
            case 308:
            case 309:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 315:
            case 316:
                return 4;
            case 317:
            case 318:
                return 8;
            default:
                return -1;
        }
    }
}
