package com.unity3d.mediation;

import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import e2.s;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10930a = new a();

    /* JADX INFO: renamed from: com.unity3d.mediation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class C0219a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10931a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f10931a = iArr;
        }
    }

    private a() {
    }

    public static final IronSource.a a(LevelPlay.AdFormat adFormat) {
        k.e(adFormat, "<this>");
        int i2 = C0219a.f10931a[adFormat.ordinal()];
        if (i2 == 1) {
            return IronSource.a.BANNER;
        }
        if (i2 == 2) {
            return IronSource.a.INTERSTITIAL;
        }
        if (i2 == 3) {
            return IronSource.a.REWARDED_VIDEO;
        }
        if (i2 == 4) {
            return IronSource.a.NATIVE_AD;
        }
        throw new s(3);
    }
}
