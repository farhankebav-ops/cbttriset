package androidx.camera.camera2.internal;

import androidx.annotation.OptIn;
import androidx.camera.core.ExperimentalLensFacing;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class LensFacingUtil {
    private LensFacingUtil() {
    }

    @OptIn(markerClass = {ExperimentalLensFacing.class})
    public static int getCameraSelectorLensFacing(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        throw new IllegalArgumentException(a1.a.h(i2, "The given lens facing integer: ", " can not be recognized."));
    }

    @OptIn(markerClass = {ExperimentalLensFacing.class})
    public static int getLensFacingInt(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        throw new IllegalArgumentException(a1.a.h(i2, "The given lens facing: ", " can not be recognized."));
    }
}
