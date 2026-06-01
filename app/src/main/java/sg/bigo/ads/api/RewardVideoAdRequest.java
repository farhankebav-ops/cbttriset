package sg.bigo.ads.api;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class RewardVideoAdRequest extends b {

    public static class Builder extends c<Builder, RewardVideoAdRequest> {
        @Override // sg.bigo.ads.api.c
        public RewardVideoAdRequest createAdRequest() {
            return new RewardVideoAdRequest(this.mSlotId, this.mServerBidPayload);
        }
    }

    public RewardVideoAdRequest(String str, String str2) {
        super(str, str2);
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return 4;
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final Map<String, Object> d() {
        return null;
    }
}
