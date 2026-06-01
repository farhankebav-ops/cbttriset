package sg.bigo.ads.api;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d implements AdInteractionListener {
    public abstract void a(@NonNull NativeAd nativeAd);

    public abstract void a(@NonNull NativeAd nativeAd, @NonNull AdError adError);

    public abstract void b(@NonNull NativeAd nativeAd);

    public abstract void c(@NonNull NativeAd nativeAd);

    public abstract void d(@NonNull NativeAd nativeAd);

    @Override // sg.bigo.ads.api.AdInteractionListener
    @Deprecated
    public final void onAdClicked() {
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    @Deprecated
    public final void onAdClosed() {
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    @Deprecated
    public final void onAdImpression() {
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    @Deprecated
    public final void onAdOpened() {
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    @Deprecated
    public final void onAdError(@NonNull AdError adError) {
    }
}
