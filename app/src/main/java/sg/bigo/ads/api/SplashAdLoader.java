package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public class SplashAdLoader extends AbstractAdLoader<SplashAd, SplashAdRequest> {

    public static class Builder implements AdLoader.Builder<SplashAd, Builder, SplashAdLoader> {
        private AdLoadListener<SplashAd> mAdLoadListener;
        private String mExt;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(@Nullable AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<SplashAd>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public SplashAdLoader build() {
            return new SplashAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withAdLoadListener(@Nullable AdLoadListener<SplashAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withExt(String str) {
            this.mExt = str;
            return this;
        }
    }

    public SplashAdLoader(Builder builder) {
        super(builder.mAdLoadListener, builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    @Nullable
    public final /* synthetic */ Ad a(g gVar) {
        if (gVar.f15496a.x() != 12) {
            return (SplashAd) super.a(gVar);
        }
        m mVarQ = gVar.f15496a.d().q();
        m mVarE = gVar.f15496a.e();
        sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
        if (cVarA == null) {
            return null;
        }
        return new sg.bigo.ads.ad.splash.b(cVarA, gVar, mVarQ, mVarE);
    }
}
