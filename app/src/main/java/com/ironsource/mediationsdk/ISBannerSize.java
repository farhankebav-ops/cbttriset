package com.ironsource.mediationsdk;

import android.content.Context;
import com.google.mlkit.common.MlKitException;
import com.ironsource.Y7;
import com.unity3d.mediation.LevelPlayAdSize;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ISBannerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8982d;
    Y7 e;
    public static final ISBannerSize BANNER = l.a(l.f9204a, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final ISBannerSize LARGE = l.a(l.f9205b, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90);
    public static final ISBannerSize RECTANGLE = l.a(l.f9206c, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final ISBannerSize f8978f = l.a();
    public static final ISBannerSize SMART = l.a(l.e, 0, 0);

    public ISBannerSize(int i2, int i8) {
        this("CUSTOM", i2, i8);
    }

    public static int getMaximalAdaptiveHeight(int i2) {
        return l.b(i2);
    }

    public void a(Y7 y7) {
        if (l.a(y7, this.f8979a, this.f8980b)) {
            this.e = y7;
        }
    }

    public String getDescription() {
        return this.f8981c;
    }

    public int getHeight() {
        return this.f8980b;
    }

    public int getWidth() {
        return this.f8979a;
    }

    public boolean isAdaptive() {
        return this.f8982d;
    }

    public boolean isSmart() {
        return this.f8981c.equals(l.e);
    }

    public void setAdaptive(boolean z2) {
        this.f8982d = z2;
    }

    public LevelPlayAdSize toLevelPlayAdSize(Context context) {
        if (isAdaptive()) {
            return LevelPlayAdSize.createAdaptiveAdSize(context, Integer.valueOf(this.e.d()));
        }
        String description = getDescription();
        description.getClass();
        switch (description) {
            case "RECTANGLE":
            case "MEDIUM_RECTANGLE":
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            case "LARGE":
                return LevelPlayAdSize.LARGE;
            case "BANNER":
                return LevelPlayAdSize.BANNER;
            case "CUSTOM":
                return LevelPlayAdSize.createCustomSize(this.f8979a, this.f8980b);
            default:
                return LevelPlayAdSize.BANNER;
        }
    }

    public ISBannerSize(String str, int i2, int i8) {
        this.f8981c = str;
        this.f8979a = i2;
        this.f8980b = i8;
        this.e = new Y7(i2, i8);
    }
}
