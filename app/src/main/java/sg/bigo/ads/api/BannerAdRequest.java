package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class BannerAdRequest extends b<BannerAdRequest> {

    @NonNull
    public final List<AdSize> h;

    public static class Builder extends c<Builder, BannerAdRequest> {
        private List<AdSize> mAdSizes;

        @Override // sg.bigo.ads.api.c
        public BannerAdRequest createAdRequest() {
            return new BannerAdRequest(this.mSlotId, this.mAdSizes, this.mServerBidPayload);
        }

        public Builder withAdSizes(AdSize... adSizeArr) {
            this.mAdSizes = Arrays.asList(adSizeArr);
            return this;
        }
    }

    public BannerAdRequest(String str, List<AdSize> list, String str2) {
        super(str, str2);
        this.h = new ArrayList();
        if (list != null) {
            for (AdSize adSize : list) {
                if (adSize != null) {
                    this.h.add(adSize);
                }
            }
        }
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final /* synthetic */ b a() {
        BannerAdRequest bannerAdRequest = new BannerAdRequest(this.f15458a, new ArrayList(this.h), this.f15459b);
        bannerAdRequest.a(this.g.f15463a);
        bannerAdRequest.f15460c = this.f15460c;
        return bannerAdRequest;
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final sg.bigo.ads.api.core.d b() {
        sg.bigo.ads.api.core.d dVarB = super.b();
        if (dVarB != null) {
            return dVarB;
        }
        if (this.h.isEmpty()) {
            return new sg.bigo.ads.api.core.d(1001, 10003, "Ad sizes cannot be empty.");
        }
        return null;
    }

    @Override // sg.bigo.ads.api.b
    public int c() {
        return 2;
    }

    @Override // sg.bigo.ads.api.b
    public final Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put("ad_size", sg.bigo.ads.ad.banner.a.a(this.h));
        return map;
    }
}
