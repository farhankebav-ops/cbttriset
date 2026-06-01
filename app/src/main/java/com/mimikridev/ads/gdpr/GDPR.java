package com.mimikridev.ads.gdpr;

import android.app.Activity;
import android.util.Log;
import androidx.camera.camera2.interop.d;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.google.android.gms.ads.MobileAds;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.firebase.inappmessaging.internal.j;
import com.mimikridev.ads.util.Constant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class GDPR {
    public static final String TAG = "GDPR";
    Activity activity;
    ConsentForm consentForm;
    ConsentInformation consentInformation;
    ConsentDebugSettings debugSettings;
    private GoogleMobileAdsConsentManager googleMobileAdsConsentManager;
    AtomicBoolean isMobileAdsInitializeCalled = new AtomicBoolean(false);
    ConsentRequestParameters params;

    public GDPR(Activity activity) {
        this.activity = activity;
    }

    private void initializeMobileAdsSdk() {
        if (this.isMobileAdsInitializeCalled.getAndSet(true)) {
            return;
        }
        MobileAds.initialize(this.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadForm$3(Activity activity, FormError formError) {
        loadForm(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadForm$4(final Activity activity, ConsentForm consentForm) {
        this.consentForm = consentForm;
        if (this.consentInformation.getConsentStatus() == 2) {
            consentForm.show(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.mimikridev.ads.gdpr.b
                @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
                public final void onConsentFormDismissed(FormError formError) {
                    this.f10669a.lambda$loadForm$3(activity, formError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGDPRConsentStatus$0() {
        if (this.consentInformation.isConsentFormAvailable()) {
            loadForm(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGDPRConsentStatus$2(FormError formError) {
        if (formError != null) {
            Log.w(TAG, formError.getErrorCode() + ": " + formError.getMessage());
        }
        if (this.googleMobileAdsConsentManager.canRequestAds()) {
            initializeMobileAdsSdk();
        }
        this.googleMobileAdsConsentManager.isPrivacyOptionsRequired();
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b8 : bArrDigest) {
                String hexString = Integer.toHexString(b8 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public void loadForm(Activity activity) {
        UserMessagingPlatform.loadConsentForm(activity, new d(7, this, activity), new j(28));
    }

    public void updateGDPRConsentStatus() {
        ConsentRequestParameters consentRequestParametersBuild = new ConsentRequestParameters.Builder().build();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(this.activity);
        this.consentInformation = consentInformation;
        consentInformation.requestConsentInfoUpdate(this.activity, consentRequestParametersBuild, new a(this), new j(29));
        Log.d(TAG, "AdMob GDPR is selected");
    }

    public void updateGDPRConsentStatus(String str, boolean z2, boolean z7) {
        str.getClass();
        if (str.equals(Constant.PANGLE)) {
            PAGConfig.setGDPRConsent(1);
            PAGConfig.getGDPRConsent();
        } else if (str.equals(Constant.ADMOB)) {
            try {
                GoogleMobileAdsConsentManager googleMobileAdsConsentManager = GoogleMobileAdsConsentManager.getInstance(this.activity);
                this.googleMobileAdsConsentManager = googleMobileAdsConsentManager;
                googleMobileAdsConsentManager.gatherConsent(this.activity, z2, z7, new a(this));
                if (this.googleMobileAdsConsentManager.canRequestAds()) {
                    initializeMobileAdsSdk();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadForm$5(FormError formError) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateGDPRConsentStatus$1(FormError formError) {
    }
}
