package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public class IconAdsLoader extends AbstractAdLoader<IconAds, IconAdsRequest> {

    public static class a implements AdLoader.Builder<IconAds, a, IconAdsLoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdLoadListener<IconAds> f15432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f15433b;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(@Nullable AdLoadListener adLoadListener) {
            this.f15432a = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ AdLoader.Builder withExt(String str) {
            this.f15433b = str;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IconAdsLoader build() {
            return new IconAdsLoader(this);
        }
    }

    public IconAdsLoader(a aVar) {
        super(aVar.f15432a, aVar.f15433b);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    public final /* synthetic */ Ad a(@NonNull b bVar, g[] gVarArr) {
        return new sg.bigo.ads.ad.a.a(bVar, gVarArr);
    }
}
