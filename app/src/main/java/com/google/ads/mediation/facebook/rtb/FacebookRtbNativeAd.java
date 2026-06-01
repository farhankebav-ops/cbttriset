package com.google.ads.mediation.facebook.rtb;

import a1.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    private MediaView mediaView;
    private final MetaFactory metaFactory;
    private NativeAdBase nativeAdBase;
    private MediationNativeAdCallback nativeAdCallback;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class FacebookAdapterNativeAdImage extends NativeAd.Image {
        private Drawable drawable;
        private Uri uri;

        public FacebookAdapterNativeAdImage() {
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        @Nullable
        public Drawable getDrawable() {
            return this.drawable;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return 1.0d;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        @NonNull
        public Uri getUri() {
            return this.uri;
        }

        public FacebookAdapterNativeAdImage(Uri uri) {
            this.uri = uri;
        }

        public FacebookAdapterNativeAdImage(Drawable drawable) {
            this.drawable = drawable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface NativeAdMapperListener {
        void onMappingFailed(AdError adError);

        void onMappingSuccess();
    }

    public FacebookRtbNativeAd(@NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        this.callback = mediationAdLoadCallback;
        this.metaFactory = metaFactory;
    }

    private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAdBase nativeAdBase) {
        boolean z2 = (nativeAdBase.getAdHeadline() == null || nativeAdBase.getAdBodyText() == null || nativeAdBase.getAdIcon() == null || nativeAdBase.getAdCallToAction() == null) ? false : true;
        return nativeAdBase instanceof NativeBannerAd ? z2 : (!z2 || nativeAdBase.getAdCoverImage() == null || this.mediaView == null) ? false : true;
    }

    public void mapNativeAd(@NonNull Context context, @NonNull NativeAdMapperListener nativeAdMapperListener) {
        if (!containsRequiredFieldsForUnifiedNativeAd(this.nativeAdBase)) {
            AdError adError = new AdError(108, "Ad from Meta Audience Network doesn't have all required assets.", "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
            nativeAdMapperListener.onMappingFailed(adError);
            return;
        }
        setHeadline(this.nativeAdBase.getAdHeadline());
        if (this.nativeAdBase.getAdCoverImage() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdCoverImage().getUrl())));
            setImages(arrayList);
        }
        setBody(this.nativeAdBase.getAdBodyText());
        if (this.nativeAdBase.getPreloadedIconViewDrawable() != null) {
            setIcon(new FacebookAdapterNativeAdImage(this.nativeAdBase.getPreloadedIconViewDrawable()));
        } else if (this.nativeAdBase.getAdIcon() == null) {
            setIcon(new FacebookAdapterNativeAdImage());
        } else {
            setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdIcon().getUrl())));
        }
        setCallToAction(this.nativeAdBase.getAdCallToAction());
        setAdvertiser(this.nativeAdBase.getAdvertiserName());
        this.mediaView.setListener(new MediaViewListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.1
            @Override // com.facebook.ads.MediaViewListener
            public void onComplete(MediaView mediaView) {
                if (FacebookRtbNativeAd.this.nativeAdCallback != null) {
                    FacebookRtbNativeAd.this.nativeAdCallback.onVideoComplete();
                }
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onEnterFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onExitFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenBackground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenForeground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPause(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPlay(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onVolumeChange(MediaView mediaView, float f4) {
            }
        });
        setHasVideoContent(true);
        setMediaView(this.mediaView);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("id", this.nativeAdBase.getId());
        bundle.putCharSequence(FacebookMediationAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.nativeAdBase.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.nativeAdBase, null));
        nativeAdMapperListener.onMappingSuccess();
    }

    public void render(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration) {
        String placementID = FacebookMediationAdapter.getPlacementID(mediationNativeAdConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.callback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(mediationNativeAdConfiguration);
        this.mediaView = this.metaFactory.createMediaView(mediationNativeAdConfiguration.getContext());
        try {
            this.nativeAdBase = NativeAdBase.fromBidPayload(mediationNativeAdConfiguration.getContext(), placementID, mediationNativeAdConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(mediationNativeAdConfiguration.getWatermark())) {
                this.nativeAdBase.setExtraHints(new ExtraHints.Builder().mediationData(mediationNativeAdConfiguration.getWatermark()).build());
            }
            NativeAdBase nativeAdBase = this.nativeAdBase;
            nativeAdBase.loadAd(nativeAdBase.buildLoadAdConfig().withAdListener(new NativeListener(mediationNativeAdConfiguration.getContext(), this.nativeAdBase)).withBid(mediationNativeAdConfiguration.getBidResponse()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e) {
            AdError adError2 = new AdError(109, a.j(e, new StringBuilder("Failed to create native ad from bid payload: ")), "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            this.callback.onFailure(adError2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void trackViews(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList(map.values());
        View view2 = map.get("3003");
        NativeAdBase nativeAdBase = this.nativeAdBase;
        if (!(nativeAdBase instanceof NativeBannerAd)) {
            if (!(nativeAdBase instanceof com.facebook.ads.NativeAd)) {
                Log.w(FacebookMediationAdapter.TAG, "Native ad type is not of type NativeAd or NativeBannerAd. It is not currently supported by the Meta Audience Network Adapter. Meta Audience Network impression recording might be impacted for this ad.");
                return;
            }
            com.facebook.ads.NativeAd nativeAd = (com.facebook.ads.NativeAd) nativeAdBase;
            if (view2 instanceof ImageView) {
                nativeAd.registerViewForInteraction(view, this.mediaView, (ImageView) view2, arrayList);
                return;
            } else {
                Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView. Calling registerViewForInteraction() without a reference to the icon view.");
                nativeAd.registerViewForInteraction(view, this.mediaView, arrayList);
                return;
            }
        }
        if (view2 == null) {
            Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Meta Audience Network impression recording might be impacted for this ad.");
            return;
        }
        if (view2 instanceof ImageView) {
            ((NativeBannerAd) nativeAdBase).registerViewForInteraction(view, (ImageView) view2, arrayList);
            return;
        }
        Log.w(FacebookMediationAdapter.TAG, "Native ad icon asset is rendered with an incompatible class type. Meta Audience Network impression recording might be impacted for this ad. Expected: ImageView, actual: " + view2.getClass() + ".");
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void untrackView(@NonNull View view) {
        NativeAdBase nativeAdBase = this.nativeAdBase;
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
        }
        super.untrackView(view);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class NativeListener implements AdListener, NativeAdListener {
        private final WeakReference<Context> context;
        private final NativeAdBase nativeAd;

        public NativeListener(Context context, NativeAdBase nativeAdBase) {
            this.nativeAd = nativeAdBase;
            this.context = new WeakReference<>(context);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            FacebookRtbNativeAd.this.nativeAdCallback.reportAdClicked();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdOpened();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdLeftApplication();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            if (ad != this.nativeAd) {
                AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", "com.google.ads.mediation.facebook");
                Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
                FacebookRtbNativeAd.this.callback.onFailure(adError);
                return;
            }
            Context context = this.context.get();
            if (context != null) {
                FacebookRtbNativeAd.this.mapNativeAd(context, new NativeAdMapperListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeListener.1
                    @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                    public void onMappingFailed(AdError adError2) {
                        Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
                        FacebookRtbNativeAd.this.callback.onFailure(adError2);
                    }

                    @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                    public void onMappingSuccess() {
                        FacebookRtbNativeAd facebookRtbNativeAd = FacebookRtbNativeAd.this;
                        facebookRtbNativeAd.nativeAdCallback = (MediationNativeAdCallback) facebookRtbNativeAd.callback.onSuccess(FacebookRtbNativeAd.this);
                    }
                });
                return;
            }
            AdError adError2 = new AdError(107, "Context is null.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError2.getMessage());
            FacebookRtbNativeAd.this.callback.onFailure(adError2);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            FacebookRtbNativeAd.this.callback.onFailure(adError2);
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }
    }
}
