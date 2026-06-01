package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static void b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i2));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i2) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, String str, int i2, Bundle bundle) {
    }
}
