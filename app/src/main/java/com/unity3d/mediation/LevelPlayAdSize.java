package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.C2297e1;
import com.ironsource.C2403k0;
import com.ironsource.mediationsdk.l;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayAdSize {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10916f = 320;
    private static final int g = 50;
    private static final int h = 320;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f10917i = 90;
    private static final int j = 300;
    private static final int k = 250;
    private static final int m = 90;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f10921d;
    private final LevelPlayAdSize e;
    public static final Companion Companion = new Companion(null);
    public static final LevelPlayAdSize BANNER = new LevelPlayAdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, l.f9204a, false, null, 16, null);
    public static final LevelPlayAdSize MEDIUM_RECTANGLE = new LevelPlayAdSize(300, 250, l.g, false, null, 16, null);
    private static final int l = 728;
    public static final LevelPlayAdSize LEADERBOARD = new LevelPlayAdSize(l, 90, l.f9207d, false, null, 16, null);
    public static final LevelPlayAdSize LARGE = new LevelPlayAdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90, l.f9205b, false, null, 16, null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ LevelPlayAdSize createAdaptiveAdSize$default(Companion companion, Context context, Integer num, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                num = null;
            }
            return companion.createAdaptiveAdSize(context, num);
        }

        public final LevelPlayAdSize createAdSize$mediationsdk_release(String adSize) {
            k.e(adSize, "adSize");
            int iHashCode = adSize.hashCode();
            if (iHashCode != -96588539) {
                if (iHashCode != 72205083) {
                    if (iHashCode != 446888797) {
                        if (iHashCode == 1951953708 && adSize.equals(l.f9204a)) {
                            return LevelPlayAdSize.BANNER;
                        }
                    } else if (adSize.equals(l.f9207d)) {
                        return LevelPlayAdSize.LEADERBOARD;
                    }
                } else if (adSize.equals(l.f9205b)) {
                    return LevelPlayAdSize.LARGE;
                }
            } else if (adSize.equals(l.g)) {
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            }
            throw new IllegalArgumentException("Wrong Ad Size");
        }

        public final LevelPlayAdSize createAdaptiveAdSize(Context context) {
            k.e(context, "context");
            return createAdaptiveAdSize$default(this, context, null, 2, null);
        }

        public final LevelPlayAdSize createCustomSize(int i2, int i8) {
            return new LevelPlayAdSize(i2, i8, "CUSTOM", false, null, 16, null);
        }

        private Companion() {
        }

        public final LevelPlayAdSize createAdaptiveAdSize(Context context, Integer num) {
            k.e(context, "context");
            return new C2297e1(new C2403k0()).a(context, num);
        }
    }

    public LevelPlayAdSize(int i2, int i8, String str, boolean z2, LevelPlayAdSize levelPlayAdSize) {
        this.f10918a = i2;
        this.f10919b = i8;
        this.f10920c = str;
        this.f10921d = z2;
        this.e = levelPlayAdSize;
    }

    public static final LevelPlayAdSize createAdaptiveAdSize(Context context) {
        return Companion.createAdaptiveAdSize(context);
    }

    public static final LevelPlayAdSize createCustomSize(int i2, int i8) {
        return Companion.createCustomSize(i2, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!LevelPlayAdSize.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type com.unity3d.mediation.LevelPlayAdSize");
        LevelPlayAdSize levelPlayAdSize = (LevelPlayAdSize) obj;
        return this.f10918a == levelPlayAdSize.f10918a && this.f10919b == levelPlayAdSize.f10919b && k.a(this.f10920c, levelPlayAdSize.f10920c);
    }

    public final String getDescription() {
        return String.valueOf(this.f10920c);
    }

    public final LevelPlayAdSize getFallbackAdSize$mediationsdk_release() {
        return this.e;
    }

    public final int getHeight() {
        return this.f10919b;
    }

    public final int getWidth() {
        return this.f10918a;
    }

    public int hashCode() {
        int i2 = ((this.f10918a * 31) + this.f10919b) * 31;
        String str = this.f10920c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isAdaptive() {
        return this.f10921d;
    }

    public String toString() {
        return this.f10920c + " " + this.f10918a + "x" + this.f10919b;
    }

    public static final LevelPlayAdSize createAdaptiveAdSize(Context context, Integer num) {
        return Companion.createAdaptiveAdSize(context, num);
    }

    public /* synthetic */ LevelPlayAdSize(int i2, int i8, String str, boolean z2, LevelPlayAdSize levelPlayAdSize, int i9, f fVar) {
        this(i2, i8, (i9 & 4) != 0 ? null : str, z2, (i9 & 16) != 0 ? null : levelPlayAdSize);
    }
}
