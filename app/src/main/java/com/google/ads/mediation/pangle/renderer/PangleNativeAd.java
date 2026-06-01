package com.google.ads.mediation.pangle.renderer;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleNativeAd extends UnifiedNativeAdMapper {

    @VisibleForTesting
    static final String ASSET_ID_ADCHOICES_TEXT_VIEW = "3012";

    @VisibleForTesting
    static final double PANGLE_SDK_IMAGE_SCALE = 1.0d;
    private final MediationNativeAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> adLoadCallback;
    private MediationNativeAdCallback callback;
    private PAGNativeAd pagNativeAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class PangleNativeMappedImage extends NativeAd.Image {
        private final Drawable drawable;
        private final Uri imageUri;
        private final double scale;

        public /* synthetic */ PangleNativeMappedImage(PangleNativeAd pangleNativeAd, Uri uri) {
            this(null, uri, PangleNativeAd.PANGLE_SDK_IMAGE_SCALE);
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        @NonNull
        public Drawable getDrawable() {
            return this.drawable;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return this.scale;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        @NonNull
        public Uri getUri() {
            return this.imageUri;
        }

        private PangleNativeMappedImage(Drawable drawable, Uri uri, double d8) {
            this.drawable = drawable;
            this.imageUri = uri;
            this.scale = d8;
        }
    }

    public PangleNativeAd(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, @NonNull PangleInitializer pangleInitializer, @NonNull PangleSdkWrapper pangleSdkWrapper, @NonNull PangleFactory pangleFactory) {
        this.adConfiguration = mediationNativeAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mapNativeAd(PAGNativeAd pAGNativeAd) {
        this.pagNativeAd = pAGNativeAd;
        PAGNativeAdData nativeAdData = pAGNativeAd.getNativeAdData();
        setHeadline(nativeAdData.getTitle());
        setBody(nativeAdData.getDescription());
        setCallToAction(nativeAdData.getButtonText());
        if (nativeAdData.getIcon() != null) {
            setIcon(new PangleNativeMappedImage(this, Uri.parse(nativeAdData.getIcon().getImageUrl())));
        }
        setOverrideClickHandling(true);
        setMediaView(nativeAdData.getMediaView());
        setAdChoicesContent(nativeAdData.getAdLogoView());
    }

    public void render() {
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load native ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = this.adConfiguration.getBidResponse();
            this.pangleInitializer.initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(@NonNull AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleNativeAd.this.adLoadCallback.onFailure(adError);
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGNativeRequest pAGNativeRequestCreatePagNativeRequest = PangleNativeAd.this.pangleFactory.createPagNativeRequest();
                    pAGNativeRequestCreatePagNativeRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGNativeRequestCreatePagNativeRequest, bidResponse, PangleNativeAd.this.adConfiguration);
                    PangleNativeAd.this.pangleSdkWrapper.loadNativeAd(string, pAGNativeRequestCreatePagNativeRequest, new PAGNativeAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i2, String str) {
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i2, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleNativeAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            PangleNativeAd.this.mapNativeAd(pAGNativeAd);
                            PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                            pangleNativeAd.callback = (MediationNativeAdCallback) pangleNativeAd.adLoadCallback.onSuccess(PangleNativeAd.this);
                        }
                    });
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void trackViews(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
        HashMap map3 = new HashMap(map);
        map3.remove("3011");
        map3.remove(ASSET_ID_ADCHOICES_TEXT_VIEW);
        View view2 = (View) map3.get("3002");
        ArrayList arrayList = new ArrayList();
        if (view2 != null) {
            arrayList.add(view2);
        }
        this.pagNativeAd.registerViewForInteraction((ViewGroup) view, new ArrayList(map3.values()), arrayList, (View) null, new PAGNativeAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                if (PangleNativeAd.this.callback != null) {
                    PangleNativeAd.this.callback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                if (PangleNativeAd.this.callback != null) {
                    PangleNativeAd.this.callback.reportAdImpression();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
            }
        });
        getAdChoicesContent().setOnClickListener(new View.OnClickListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                PangleNativeAd.this.pagNativeAd.showPrivacyActivity();
            }
        });
    }
}
