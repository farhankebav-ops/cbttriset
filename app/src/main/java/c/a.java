package c;

import android.content.pm.ApkChecksum;
import android.media.ApplicationMediaCapabilities;
import android.media.metrics.PlaybackMetrics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ApkChecksum b(Object obj) {
        return (ApkChecksum) obj;
    }

    public static /* synthetic */ ApplicationMediaCapabilities.Builder c() {
        return new ApplicationMediaCapabilities.Builder();
    }

    public static /* bridge */ /* synthetic */ PlaybackMetrics.Builder g(Object obj) {
        return (PlaybackMetrics.Builder) obj;
    }
}
