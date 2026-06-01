package androidx.camera.video.internal.config;

import android.util.Rational;
import androidx.camera.core.Logger;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureEncodeRatesKt {
    private static final String TAG = "CaptureEncodeRates";

    private static final boolean isInvalidCaptureToEncodeRatio(Rational rational) {
        return k.a(rational, Rational.NaN) || k.a(rational, Rational.ZERO) || k.a(rational, Rational.NEGATIVE_INFINITY) || k.a(rational, Rational.POSITIVE_INFINITY);
    }

    public static final int toCaptureRate(int i2, Rational rational) {
        if (rational == null) {
            return i2;
        }
        if (!isInvalidCaptureToEncodeRatio(rational)) {
            return a.a.U(rational.floatValue() * i2);
        }
        Logger.w(TAG, "Invalid capture-to-encode ratio: " + rational);
        return i2;
    }

    public static final int toEncodeRate(int i2, Rational rational) {
        if (rational == null) {
            return i2;
        }
        if (!isInvalidCaptureToEncodeRatio(rational)) {
            return a.a.U(i2 / rational.floatValue());
        }
        Logger.w(TAG, "Invalid capture-to-encode ratio: " + rational);
        return i2;
    }
}
