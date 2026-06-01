package com.vungle.ads;

import android.app.Application;
import android.content.Context;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.VungleInitializer;
import com.vungle.ads.internal.VungleInternal;
import com.vungle.ads.internal.model.Placement;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleAds {
    public static final String TAG = "VungleAds";
    public static final Companion Companion = new Companion(null);
    private static VungleInternal vungleInternal = new VungleInternal();
    private static VungleInitializer initializer = new VungleInitializer();
    public static final FirstPartyData firstPartyData = new FirstPartyData();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void deInit(Context context) {
            k.e(context, "context");
            VungleAds.initializer.deInit$vungle_ads_release();
        }

        public final void getBiddingToken(Context context, BidTokenCallback callback) {
            k.e(context, "context");
            k.e(callback, "callback");
            VungleAds.vungleInternal.getAvailableBidTokensAsync(context, callback);
        }

        public final String getSdkVersion() {
            return VungleAds.vungleInternal.getSdkVersion();
        }

        public final void init(Context appContext, String appId, InitializationListener callback) {
            k.e(appContext, "context");
            k.e(appId, "appId");
            k.e(callback, "callback");
            if (!(appContext instanceof Application)) {
                appContext = appContext.getApplicationContext();
            }
            VungleInitializer vungleInitializer = VungleAds.initializer;
            k.d(appContext, "appContext");
            vungleInitializer.init(appId, appContext, callback);
        }

        public final boolean isInitialized() {
            return VungleAds.initializer.isInitialized();
        }

        public final boolean isInline(String placementId) {
            k.e(placementId, "placementId");
            Placement placement = ConfigManager.INSTANCE.getPlacement(placementId);
            if (placement != null) {
                return placement.isInline();
            }
            return false;
        }

        public final void setIntegrationName(VungleWrapperFramework wrapperFramework, String wrapperFrameworkVersion) {
            k.e(wrapperFramework, "wrapperFramework");
            k.e(wrapperFrameworkVersion, "wrapperFrameworkVersion");
            VungleAds.initializer.setIntegrationName(wrapperFramework, wrapperFrameworkVersion);
        }

        private Companion() {
        }
    }

    public static final void deInit(Context context) {
        Companion.deInit(context);
    }

    public static final void getBiddingToken(Context context, BidTokenCallback bidTokenCallback) {
        Companion.getBiddingToken(context, bidTokenCallback);
    }

    public static final String getSdkVersion() {
        return Companion.getSdkVersion();
    }

    public static final void init(Context context, String str, InitializationListener initializationListener) {
        Companion.init(context, str, initializationListener);
    }

    public static final boolean isInitialized() {
        return Companion.isInitialized();
    }

    public static final boolean isInline(String str) {
        return Companion.isInline(str);
    }

    public static final void setIntegrationName(VungleWrapperFramework vungleWrapperFramework, String str) {
        Companion.setIntegrationName(vungleWrapperFramework, str);
    }
}
