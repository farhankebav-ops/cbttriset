package sg.bigo.ads.api;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class InterstitialAdRequest extends b {
    private int h;

    public static class Builder extends c<Builder, InterstitialAdRequest> {
        @Override // sg.bigo.ads.api.c
        public InterstitialAdRequest createAdRequest() {
            return new InterstitialAdRequest(this.mSlotId, this.mServerBidPayload);
        }
    }

    public InterstitialAdRequest(String str, String str2) {
        super(str, str2);
        this.h = 3;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean a(int i2) {
        if (i2 == 3) {
            this.h = 3;
            return false;
        }
        if (i2 != 20) {
            return true;
        }
        this.h = 20;
        return false;
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final Map<String, Object> d() {
        return null;
    }
}
