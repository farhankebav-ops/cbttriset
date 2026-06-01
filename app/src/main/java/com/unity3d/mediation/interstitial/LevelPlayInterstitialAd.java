package com.unity3d.mediation.interstitial;

import android.app.Activity;
import com.ironsource.C2271cb;
import com.ironsource.C2325fb;
import com.ironsource.C2374i6;
import com.ironsource.C2459n0;
import com.ironsource.C2670z7;
import com.ironsource.D0;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.Mb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayInterstitialAd {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2325fb f10942b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final boolean isPlacementCapped(String placementName) {
            k.e(placementName, "placementName");
            return C2271cb.f8140n.a(placementName, LevelPlay.AdFormat.INTERSTITIAL);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Config implements C2271cb.b {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Double f10943a;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Double f10944a;

            public final Config build() {
                return new Config(this.f10944a);
            }

            public final Builder setBidFloor(double d8) {
                this.f10944a = Double.valueOf(d8);
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Config empty() {
                return new Config(null, 1, 0 == true ? 1 : 0);
            }

            private Companion() {
            }
        }

        public Config() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Config copy$default(Config config, Double d8, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                d8 = config.f10943a;
            }
            return config.copy(d8);
        }

        public final Double component1() {
            return this.f10943a;
        }

        public final Config copy(Double d8) {
            return new Config(d8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Config) && k.a(this.f10943a, ((Config) obj).f10943a);
        }

        @Override // com.ironsource.C2271cb.b
        public Double getBidFloor() {
            return this.f10943a;
        }

        public int hashCode() {
            Double d8 = this.f10943a;
            if (d8 == null) {
                return 0;
            }
            return d8.hashCode();
        }

        public String toString() {
            return "Config(bidFloor=" + this.f10943a + ")";
        }

        public Config(Double d8) {
            this.f10943a = d8;
        }

        public /* synthetic */ Config(Double d8, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : d8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayInterstitialAd(String adUnitId) {
        this(adUnitId, Config.Companion.empty());
        k.e(adUnitId, "adUnitId");
    }

    public static final boolean isPlacementCapped(String str) {
        return Companion.isPlacementCapped(str);
    }

    public static /* synthetic */ void showAd$default(LevelPlayInterstitialAd levelPlayInterstitialAd, Activity activity, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        levelPlayInterstitialAd.showAd(activity, str);
    }

    public final String getAdId() {
        return this.f10942b.b();
    }

    public final String getAdUnitId() {
        return this.f10941a;
    }

    public final boolean isAdReady() {
        return this.f10942b.c();
    }

    public final void loadAd() {
        this.f10942b.d();
    }

    public final void setListener(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        this.f10942b.a(levelPlayInterstitialAdListener);
    }

    public final void showAd(Activity activity) {
        k.e(activity, "activity");
        showAd$default(this, activity, null, 2, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayInterstitialAd(String adUnitId, Config config) {
        this(adUnitId, new C2271cb.c(new C2459n0(IronSource.a.INTERSTITIAL, D0.b.MEDIATION), new C2374i6(), Mb.f7131s.d(), new InterfaceC2565t4.a(), C2670z7.f10631a, config));
        k.e(adUnitId, "adUnitId");
        k.e(config, "config");
    }

    public final void showAd(Activity activity, String str) {
        k.e(activity, "activity");
        this.f10942b.a(activity, str);
    }

    public LevelPlayInterstitialAd(String adUnitId, C2271cb.c payload) {
        k.e(adUnitId, "adUnitId");
        k.e(payload, "payload");
        IronLog.API.info("adUnitId: " + adUnitId + ", config: " + payload.c());
        this.f10941a = adUnitId;
        this.f10942b = new C2325fb(adUnitId, payload.c(), payload.b(), payload.a(), payload.f(), payload.d(), payload.e());
    }
}
