package sg.bigo.ads.api;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class SplashAdRequest extends b {

    @DrawableRes
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f15442i;

    public static class Builder extends c<Builder, SplashAdRequest> {

        @DrawableRes
        private int mAppLogoResId;
        private String mAppName;

        @Override // sg.bigo.ads.api.c
        public SplashAdRequest createAdRequest() {
            return new SplashAdRequest(this.mSlotId, this.mAppLogoResId, this.mAppName, this.mServerBidPayload);
        }

        @NonNull
        public Builder withAppLogo(@DrawableRes int i2) {
            this.mAppLogoResId = i2;
            return this;
        }

        @NonNull
        public Builder withAppName(String str) {
            this.mAppName = str;
            return this;
        }
    }

    public SplashAdRequest(String str, @DrawableRes int i2, String str2, String str3) {
        super(str, str3);
        this.h = i2;
        this.f15442i = str2;
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return 12;
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final Map<String, Object> d() {
        return null;
    }
}
