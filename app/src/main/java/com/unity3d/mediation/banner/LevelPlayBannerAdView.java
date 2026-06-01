package com.unity3d.mediation.banner;

import a1.a;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ironsource.C2670z7;
import com.ironsource.Da;
import com.ironsource.X2;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdSize;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayBannerAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Da f10932a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Config {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LevelPlayAdSize f10933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Double f10934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f10935c;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private LevelPlayAdSize f10936a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Double f10937b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f10938c;

            public final Config build() {
                return new Config(this.f10936a, this.f10937b, this.f10938c);
            }

            public final Builder setAdSize(LevelPlayAdSize adSize) {
                k.e(adSize, "adSize");
                this.f10936a = adSize;
                return this;
            }

            public final Builder setBidFloor(double d8) {
                this.f10937b = Double.valueOf(d8);
                return this;
            }

            public final Builder setPlacementName(String placementName) {
                k.e(placementName, "placementName");
                this.f10938c = placementName;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Config empty() {
                return new Config(null, null, null, 7, null);
            }

            private Companion() {
            }
        }

        public Config() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Config copy$default(Config config, LevelPlayAdSize levelPlayAdSize, Double d8, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                levelPlayAdSize = config.f10933a;
            }
            if ((i2 & 2) != 0) {
                d8 = config.f10934b;
            }
            if ((i2 & 4) != 0) {
                str = config.f10935c;
            }
            return config.copy(levelPlayAdSize, d8, str);
        }

        public final LevelPlayAdSize component1() {
            return this.f10933a;
        }

        public final Double component2() {
            return this.f10934b;
        }

        public final String component3() {
            return this.f10935c;
        }

        public final Config copy(LevelPlayAdSize levelPlayAdSize, Double d8, String str) {
            return new Config(levelPlayAdSize, d8, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return k.a(this.f10933a, config.f10933a) && k.a(this.f10934b, config.f10934b) && k.a(this.f10935c, config.f10935c);
        }

        public final LevelPlayAdSize getAdSize() {
            return this.f10933a;
        }

        public final Double getBidFloor() {
            return this.f10934b;
        }

        public final String getPlacementName() {
            return this.f10935c;
        }

        public int hashCode() {
            LevelPlayAdSize levelPlayAdSize = this.f10933a;
            int iHashCode = (levelPlayAdSize == null ? 0 : levelPlayAdSize.hashCode()) * 31;
            Double d8 = this.f10934b;
            int iHashCode2 = (iHashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
            String str = this.f10935c;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            LevelPlayAdSize levelPlayAdSize = this.f10933a;
            Double d8 = this.f10934b;
            String str = this.f10935c;
            StringBuilder sb = new StringBuilder("Config(adSize=");
            sb.append(levelPlayAdSize);
            sb.append(", bidFloor=");
            sb.append(d8);
            sb.append(", placementName=");
            return a.r(sb, str, ")");
        }

        public Config(LevelPlayAdSize levelPlayAdSize, Double d8, String str) {
            this.f10933a = levelPlayAdSize;
            this.f10934b = d8;
            this.f10935c = str;
        }

        public /* synthetic */ Config(LevelPlayAdSize levelPlayAdSize, Double d8, String str, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : levelPlayAdSize, (i2 & 2) != 0 ? null : d8, (i2 & 4) != 0 ? null : str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(Context context) {
        this(context, null, 0, 6, null);
        k.e(context, "context");
    }

    private final Da a(String str, Config config) {
        Context context = getContext();
        k.d(context, "context");
        X2 x2A = a(context);
        addView(x2A);
        return new Da(C2670z7.f10631a.a(), str, x2A, config, null, 16, null);
    }

    public final void destroy() {
        this.f10932a.b();
    }

    public final String getAdId() {
        String string = this.f10932a.c().toString();
        k.d(string, "bannerViewInternal.adId.toString()");
        return string;
    }

    public final LevelPlayAdSize getAdSize() {
        return this.f10932a.d();
    }

    public final String getAdUnitId() {
        return this.f10932a.e();
    }

    public final LevelPlayBannerAdViewListener getBannerListener() {
        return this.f10932a.f();
    }

    public final String getPlacementName() {
        return this.f10932a.g();
    }

    public final void loadAd() {
        this.f10932a.i();
    }

    public final void pauseAutoRefresh() {
        this.f10932a.j();
    }

    public final void resumeAutoRefresh() {
        this.f10932a.k();
    }

    public final void setBannerListener(LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        this.f10932a.a(levelPlayBannerAdViewListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.e(context, "context");
    }

    public /* synthetic */ LevelPlayBannerAdView(Context context, AttributeSet attributeSet, int i2, int i8, f fVar) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, (i8 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.e(context, "context");
        IronLog.API.info("context: ".concat(context.getClass().getSimpleName()));
        i iVarA = Da.f6611n.a(context, attributeSet);
        this.f10932a = a((String) iVarA.f13498a, (Config) iVarA.f13499b);
    }

    private final X2 a(Context context) {
        X2 x2 = new X2(context);
        x2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return x2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(Context context, String adUnitId) {
        this(context, adUnitId, Config.Companion.empty());
        k.e(context, "context");
        k.e(adUnitId, "adUnitId");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(Context context, String adUnitId, Config config) {
        super(context);
        k.e(context, "context");
        k.e(adUnitId, "adUnitId");
        k.e(config, "config");
        IronLog.API.info("adUnitId: " + adUnitId + ", config: " + config + ", context: " + context.getClass().getSimpleName());
        this.f10932a = a(adUnitId, config);
    }
}
