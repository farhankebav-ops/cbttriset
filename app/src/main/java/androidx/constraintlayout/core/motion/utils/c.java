package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "easing":
                return TypedValues.CycleType.TYPE_EASING;
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
            case "alpha":
                return 403;
            case "curveFit":
                return 401;
            case "pathRotate":
                return 416;
            case "visibility":
                return 402;
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
        if (i2 == 416) {
            return 4;
        }
        if (i2 == 420 || i2 == 421) {
            return 8;
        }
        switch (i2) {
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
                return 4;
            default:
                switch (i2) {
                    case 401:
                    case 402:
                        return 2;
                    case 403:
                        return 4;
                    default:
                        switch (i2) {
                            case TypedValues.CycleType.TYPE_WAVE_PERIOD /* 423 */:
                            case TypedValues.CycleType.TYPE_WAVE_OFFSET /* 424 */:
                            case TypedValues.CycleType.TYPE_WAVE_PHASE /* 425 */:
                                return 4;
                            default:
                                return -1;
                        }
                }
        }
    }
}
