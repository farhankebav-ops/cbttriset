package com.onesignal.location.internal.common;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.LocationListener;
import com.huawei.hms.location.LocationCallback;
import com.onesignal.common.AndroidUtils;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationUtils {
    public static final LocationUtils INSTANCE = new LocationUtils();

    private LocationUtils() {
    }

    public final boolean hasGMSLocationLibrary() {
        try {
            return AndroidUtils.INSTANCE.opaqueHasClass(LocationListener.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean hasHMSLocationLibrary() {
        try {
            return AndroidUtils.INSTANCE.opaqueHasClass(LocationCallback.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean hasLocationPermission(Context context) {
        k.e(context, "context");
        return ContextCompat.checkSelfPermission(context, LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING) == 0 || ContextCompat.checkSelfPermission(context, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING) == 0;
    }
}
