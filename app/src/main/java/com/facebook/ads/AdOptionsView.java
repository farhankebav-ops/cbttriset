package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.AdComponentFrameLayout;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class AdOptionsView extends AdComponentFrameLayout {
    private final AdOptionsViewApi mAdOptionsViewApi;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout) {
        super(context);
        AdOptionsViewApi adOptionsViewApiCreateAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, this);
        this.mAdOptionsViewApi = adOptionsViewApiCreateAdOptionsView;
        attachAdComponentViewApi(adOptionsViewApiCreateAdOptionsView);
    }

    public void setIconColor(int i2) {
        this.mAdOptionsViewApi.setIconColor(i2);
    }

    public void setIconSizeDp(int i2) {
        this.mAdOptionsViewApi.setIconSizeDp(i2);
    }

    public void setSingleIcon(boolean z2) {
        this.mAdOptionsViewApi.setSingleIcon(z2);
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, Orientation orientation, int i2) {
        super(context);
        AdOptionsViewApi adOptionsViewApiCreateAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, orientation, i2, this);
        this.mAdOptionsViewApi = adOptionsViewApiCreateAdOptionsView;
        attachAdComponentViewApi(adOptionsViewApiCreateAdOptionsView);
    }
}
