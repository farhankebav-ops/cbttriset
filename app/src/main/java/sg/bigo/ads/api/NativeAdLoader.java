package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.Q6;
import java.util.Map;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public class NativeAdLoader extends AbstractAdLoader<NativeAd, NativeAdRequest> {

    public static class Builder implements AdLoader.Builder<NativeAd, Builder, NativeAdLoader> {
        private AdLoadListener<NativeAd> mAdLoadListener;
        private String mExt;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(@Nullable AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<NativeAd>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public NativeAdLoader build() {
            return new NativeAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @NonNull
        public Builder withAdLoadListener(@Nullable AdLoadListener<NativeAd> adLoadListener) {
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

    public NativeAdLoader(Builder builder) {
        super(builder.mAdLoadListener, builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    @Nullable
    public final /* synthetic */ Ad a(g gVar) {
        Map<String, String> map;
        if (gVar.f15496a.x() != 1) {
            return (NativeAd) super.a(gVar);
        }
        sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
        if (cVarA != null) {
            sg.bigo.ads.api.core.c cVar = (sg.bigo.ads.core.a.a) cVarA.f();
            if ((cVar instanceof sg.bigo.ads.controller.c.b) && cVar.al() && (map = ((sg.bigo.ads.controller.c.b) cVar).B) != null && !q.a((Object) Q6.I0) && !q.a((Object) "1") && !map.containsKey(Q6.I0)) {
                map.put(Q6.I0, "1");
            }
        }
        return cVarA;
    }
}
