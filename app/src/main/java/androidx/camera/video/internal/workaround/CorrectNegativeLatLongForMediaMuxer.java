package androidx.camera.video.internal.workaround;

import android.util.Pair;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CorrectNegativeLatLongForMediaMuxer {
    private CorrectNegativeLatLongForMediaMuxer() {
    }

    public static Pair<Double, Double> adjustGeoLocation(double d8, double d9) {
        if (DeviceQuirks.get(NegativeLatLongSavesIncorrectlyQuirk.class) != null) {
            d8 = adjustInternal(d8);
            d9 = adjustInternal(d9);
        }
        return Pair.create(Double.valueOf(d8), Double.valueOf(d9));
    }

    private static double adjustInternal(double d8) {
        return d8 >= 0.0d ? d8 : ((d8 * 10000.0d) - 1.0d) / 10000.0d;
    }
}
