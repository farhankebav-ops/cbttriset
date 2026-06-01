package com.unity3d.ads.core.configuration;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidManifestIntPropertyReader {
    private final Context context;

    public AndroidManifestIntPropertyReader(Context context) {
        k.e(context, "context");
        this.context = context;
    }

    public final Integer getPropertyByName(String propertyName) {
        Bundle bundle;
        Integer numValueOf;
        k.e(propertyName, "propertyName");
        try {
            bundle = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData;
            numValueOf = Integer.valueOf(bundle.getInt(propertyName));
        } catch (Exception unused) {
        }
        if (bundle.containsKey(propertyName)) {
            return numValueOf;
        }
        return null;
    }
}
