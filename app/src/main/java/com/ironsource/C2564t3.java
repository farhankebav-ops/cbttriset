package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;

/* JADX INFO: renamed from: com.ironsource.t3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2564t3 implements InterfaceC2279d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V3 f10266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Dd f10267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IronSource.a f10268c;

    /* JADX INFO: renamed from: com.ironsource.t3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10269a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            try {
                iArr[IronSource.a.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10269a = iArr;
        }
    }

    public C2564t3(V3 adFormatConfigurations, Dd dd, IronSource.a adFormat) {
        kotlin.jvm.internal.k.e(adFormatConfigurations, "adFormatConfigurations");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        this.f10266a = adFormatConfigurations;
        this.f10267b = dd;
        this.f10268c = adFormat;
    }

    @Override // com.ironsource.InterfaceC2279d1
    public InterfaceC2430l9 a(InterfaceC2676zd providerName) {
        NetworkSettings networkSettingsB;
        Zd zdF;
        kotlin.jvm.internal.k.e(providerName, "providerName");
        Dd dd = this.f10267b;
        if (dd == null || (networkSettingsB = dd.b(providerName.value())) == null) {
            return null;
        }
        int i2 = a.f10269a[this.f10268c.ordinal()];
        if (i2 == 1) {
            V2 v2C = this.f10266a.c();
            if (v2C != null) {
                return new C2227a3(new C2243b1(networkSettingsB, networkSettingsB.getBannerSettings(), this.f10268c), v2C);
            }
            return null;
        }
        if (i2 != 2) {
            if (i2 == 3 && (zdF = this.f10266a.f()) != null) {
                return new Md(new C2243b1(networkSettingsB, networkSettingsB.getRewardedVideoSettings(), this.f10268c), zdF);
            }
            return null;
        }
        F9 f9D = this.f10266a.d();
        if (f9D != null) {
            return new I9(new C2243b1(networkSettingsB, networkSettingsB.getInterstitialSettings(), this.f10268c), f9D);
        }
        return null;
    }
}
