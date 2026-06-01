package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: renamed from: com.ironsource.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2385j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2385j0 f8740a = new C2385j0();

    private C2385j0() {
    }

    public static final int a() {
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        try {
            return SdkExtensions.getExtensionVersion(1000000);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return 0;
        }
    }

    public static final MeasurementManager a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        if (Build.VERSION.SDK_INT < 30 || a() < 4) {
            return null;
        }
        try {
            return androidx.privacysandbox.ads.adservices.customaudience.a.u(context.getSystemService(androidx.privacysandbox.ads.adservices.customaudience.a.v()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void b() {
    }
}
