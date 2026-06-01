package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.e.h;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public class RewardVideoAdLoader extends AbstractAdLoader<RewardVideoAd, RewardVideoAdRequest> {

    public static class Builder implements AdLoader.Builder<RewardVideoAd, Builder, RewardVideoAdLoader> {
        private AdLoadListener<RewardVideoAd> mAdLoadListener;
        private String mExt;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(@Nullable AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<RewardVideoAd>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public RewardVideoAdLoader build() {
            return new RewardVideoAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withAdLoadListener(@Nullable AdLoadListener<RewardVideoAd> adLoadListener) {
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

    public RewardVideoAdLoader(Builder builder) {
        super(builder.mAdLoadListener, builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    @Nullable
    public final /* synthetic */ Ad a(g gVar) {
        if (gVar.f15496a.x() != 4) {
            return (RewardVideoAd) super.a(gVar);
        }
        int iW = gVar.f15496a.w();
        if (iW == 1 || iW == 2) {
            return new h(gVar);
        }
        if (iW != 3) {
            return null;
        }
        return new sg.bigo.ads.ad.e.b(gVar);
    }
}
