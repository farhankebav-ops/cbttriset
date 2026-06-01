package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2314f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f8504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UUID f8505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C2434ld f8507d;
    private final Hf e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Double f8508f;

    /* JADX INFO: renamed from: com.ironsource.f0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8509a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.a.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f8509a = iArr;
        }
    }

    public C2314f0(IronSource.a adFormat, UUID adId, String adUnitId, C2434ld c2434ld, Hf hf, Double d8) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        this.f8504a = adFormat;
        this.f8505b = adId;
        this.f8506c = adUnitId;
        this.f8507d = c2434ld;
        this.e = hf;
        this.f8508f = d8;
    }

    public final IronSource.a a() {
        return this.f8504a;
    }

    public final UUID b() {
        return this.f8505b;
    }

    public final String c() {
        return this.f8506c;
    }

    public final Double d() {
        return this.f8508f;
    }

    public final LevelPlay.AdFormat e() {
        int i2 = a.f8509a[this.f8504a.ordinal()];
        if (i2 == 1) {
            return LevelPlay.AdFormat.REWARDED;
        }
        if (i2 == 2) {
            return LevelPlay.AdFormat.INTERSTITIAL;
        }
        if (i2 == 3) {
            return LevelPlay.AdFormat.BANNER;
        }
        if (i2 == 4) {
            return LevelPlay.AdFormat.NATIVE_AD;
        }
        throw new e2.s(3);
    }

    public final C2434ld f() {
        return this.f8507d;
    }

    public final Hf g() {
        return this.e;
    }

    public final void a(C2434ld c2434ld) {
        this.f8507d = c2434ld;
    }

    public /* synthetic */ C2314f0(IronSource.a aVar, UUID uuid, String str, C2434ld c2434ld, Hf hf, Double d8, int i2, kotlin.jvm.internal.f fVar) {
        this(aVar, uuid, str, (i2 & 8) != 0 ? null : c2434ld, (i2 & 16) != 0 ? null : hf, (i2 & 32) != 0 ? null : d8);
    }
}
