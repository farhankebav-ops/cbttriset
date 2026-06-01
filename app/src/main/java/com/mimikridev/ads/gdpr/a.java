package com.mimikridev.ads.gdpr;

import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;
import com.mimikridev.ads.gdpr.GoogleMobileAdsConsentManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener, ConsentInformation.OnConsentInfoUpdateSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GDPR f10668a;

    public /* synthetic */ a(GDPR gdpr) {
        this.f10668a = gdpr;
    }

    @Override // com.mimikridev.ads.gdpr.GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener
    public void consentGatheringComplete(FormError formError) {
        this.f10668a.lambda$updateGDPRConsentStatus$2(formError);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
    public void onConsentInfoUpdateSuccess() {
        this.f10668a.lambda$updateGDPRConsentStatus$0();
    }
}
