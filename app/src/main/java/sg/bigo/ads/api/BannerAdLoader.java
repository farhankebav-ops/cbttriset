package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public class BannerAdLoader extends AbstractAdLoader<BannerAd, BannerAdRequest> {

    public static class Builder implements AdLoader.Builder<BannerAd, Builder, BannerAdLoader> {
        private AdLoadListener<BannerAd> mBannerAdLoader;
        private String mExt;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(@Nullable AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<BannerAd>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public BannerAdLoader build() {
            return new BannerAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withAdLoadListener(@Nullable AdLoadListener<BannerAd> adLoadListener) {
            this.mBannerAdLoader = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withExt(String str) {
            this.mExt = str;
            return this;
        }
    }

    public BannerAdLoader(Builder builder) {
        super(builder.mBannerAdLoader, builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    @Nullable
    public final /* synthetic */ Ad a(g gVar) {
        return gVar.f15496a.x() == 2 ? sg.bigo.ads.ad.banner.d.a(gVar) : (BannerAd) super.a(gVar);
    }
}
