package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class InitSettingsBuilder implements AudienceNetworkAds.InitSettingsBuilder {
    public static final String PLACEMENTS_KEY = "PLACEMENTS_KEY";
    private final Context mContext;
    private final MultithreadedBundleWrapper mInitSettings = new MultithreadedBundleWrapper();
    private AudienceNetworkAds.InitListener mInitializationListener;

    public InitSettingsBuilder(Context context) {
        this.mContext = context;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder
    public void initialize() {
        DynamicLoaderFactory.initialize(this.mContext, this.mInitSettings, this.mInitializationListener, false);
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder
    public /* bridge */ /* synthetic */ AudienceNetworkAds.InitSettingsBuilder withPlacementIds(List list) {
        return withPlacementIds((List<String>) list);
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder
    public InitSettingsBuilder withInitListener(AudienceNetworkAds.InitListener initListener) {
        this.mInitializationListener = initListener;
        return this;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder
    public InitSettingsBuilder withMediationService(String str) {
        AdSettings.setMediationService(str);
        return this;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder
    public InitSettingsBuilder withPlacementIds(List<String> list) {
        this.mInitSettings.putStringArrayList(PLACEMENTS_KEY, new ArrayList<>(list));
        return this;
    }
}
