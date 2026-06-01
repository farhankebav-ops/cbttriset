package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.z5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2668z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2668z5 f10625a = new C2668z5();

    private C2668z5() {
    }

    public static /* synthetic */ IronSourceError a(C2668z5 c2668z5, EnumC2304e8 enumC2304e8, IronSourceError ironSourceError, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            ironSourceError = null;
        }
        return c2668z5.a(enumC2304e8, ironSourceError);
    }

    public final IronSourceError b() {
        return a(this, EnumC2304e8.ISErrorInitHttpRequestFailed, null, 2, null);
    }

    public final IronSourceError c() {
        return a(this, EnumC2304e8.ISErrorInitInvalidResponse, null, 2, null);
    }

    public final IronSourceError d() {
        return a(this, EnumC2304e8.ISErrorLoadADMDecryptionFailure, null, 2, null);
    }

    public final IronSourceError e() {
        return a(this, EnumC2304e8.ISErrorLoadADMEmptyServerData, null, 2, null);
    }

    public final IronSourceError f() {
        return a(this, EnumC2304e8.ISErrorLoadADMEmptyWaterfall, null, 2, null);
    }

    public final IronSourceError g() {
        return a(this, EnumC2304e8.ISErrorLoadADMInvalidConfigurationForRequestedNetwork, null, 2, null);
    }

    public final IronSourceError h() {
        return a(this, EnumC2304e8.ISErrorLoadADMInvalidJSON, null, 2, null);
    }

    public final IronSourceError i() {
        return a(this, EnumC2304e8.ISErrorLoadADMNoAuctionID, null, 2, null);
    }

    public final IronSourceError j() {
        return a(this, EnumC2304e8.ISErrorLoadADMNoConfigurationForRequestedNetwork, null, 2, null);
    }

    public final IronSourceError k() {
        return a(this, EnumC2304e8.ISErrorLoadBannerNetworkViewIsNull, null, 2, null);
    }

    public final IronSourceError l() {
        return a(this, EnumC2304e8.ISErrorLoadBannerNotSupportedSize, null, 2, null);
    }

    public final IronSourceError m() {
        return a(this, EnumC2304e8.ISErrorLoadBannerSizeIsNull, null, 2, null);
    }

    public final IronSourceError n() {
        return a(this, EnumC2304e8.ISErrorLoadBiddingInNonBidding, null, 2, null);
    }

    public final IronSourceError o() {
        return a(this, EnumC2304e8.ISErrorLoadInstanceNotInInitResponse, null, 2, null);
    }

    public final IronSourceError p() {
        return a(this, EnumC2304e8.ISErrorLoadNoAdFormatConfigurations, null, 2, null);
    }

    public final IronSourceError q() {
        return a(this, EnumC2304e8.ISErrorLoadNullADM, null, 2, null);
    }

    public final IronSourceError r() {
        return a(this, EnumC2304e8.ISErrorLoadSDKNotInitialized, null, 2, null);
    }

    public final IronSourceError s() {
        return a(this, EnumC2304e8.ISErrorLoadTimedOut, null, 2, null);
    }

    public final IronSourceError t() {
        return a(this, EnumC2304e8.ISErrorShowNotReadyToShowAd, null, 2, null);
    }

    private final IronSourceError a(EnumC2304e8 enumC2304e8, IronSourceError ironSourceError) {
        String strC;
        if (ironSourceError != null) {
            strC = enumC2304e8.c() + " Underlying network error: '" + ironSourceError.getErrorCode() + ":" + ironSourceError.getErrorMessage() + "'";
        } else {
            strC = enumC2304e8.c();
        }
        return new IronSourceError(enumC2304e8.b(), strC);
    }

    public final IronSourceError b(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        return a(EnumC2304e8.ISErrorLoadNetworkFailed, error);
    }

    public final IronSourceError c(String description) {
        kotlin.jvm.internal.k.e(description, "description");
        return a(EnumC2304e8.ISErrorLoadNetworkFailed, description);
    }

    public final IronSourceError d(String str) {
        return a(EnumC2304e8.ISErrorRewardedLoadNoConfig, str);
    }

    public static /* synthetic */ IronSourceError b(C2668z5 c2668z5, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return c2668z5.b(str);
    }

    public final IronSourceError c(IronSourceError networkError) {
        kotlin.jvm.internal.k.e(networkError, "networkError");
        return a(EnumC2304e8.ISErrorShowNetworkFailed, networkError);
    }

    public static /* synthetic */ IronSourceError c(C2668z5 c2668z5, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return c2668z5.d(str);
    }

    public final IronSourceError b(String str) {
        return a(EnumC2304e8.ISErrorInterstitialLoadNoConfig, str);
    }

    private final IronSourceError a(EnumC2304e8 enumC2304e8, String str) {
        if (str == null || str.length() == 0) {
            str = enumC2304e8.c();
        }
        return new IronSourceError(enumC2304e8.b(), str);
    }

    public final IronSourceError a(IronSourceError networkError) {
        kotlin.jvm.internal.k.e(networkError, "networkError");
        return a(EnumC2304e8.ISErrorInitNetworkFailed, networkError);
    }

    public final IronSourceError a() {
        return a(this, EnumC2304e8.ISErrorInitDecryptionFailure, null, 2, null);
    }

    public static /* synthetic */ IronSourceError a(C2668z5 c2668z5, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return c2668z5.a(str);
    }

    public final IronSourceError a(String str) {
        return a(EnumC2304e8.ISErrorBannerLoadNoConfig, str);
    }
}
