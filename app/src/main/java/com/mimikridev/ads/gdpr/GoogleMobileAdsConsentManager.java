package com.mimikridev.ads.gdpr;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import androidx.camera.core.processing.h;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class GoogleMobileAdsConsentManager {
    private static GoogleMobileAdsConsentManager instance;
    private final ConsentInformation consentInformation;
    ConsentRequestParameters params;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnConsentGatheringCompleteListener {
        void consentGatheringComplete(FormError formError);
    }

    private GoogleMobileAdsConsentManager(Context context) {
        this.consentInformation = UserMessagingPlatform.getConsentInformation(context);
    }

    public static GoogleMobileAdsConsentManager getInstance(Context context) {
        if (instance == null) {
            instance = new GoogleMobileAdsConsentManager(context);
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAndShowConsentFormIfRequired, reason: merged with bridge method [inline-methods] */
    public void lambda$gatherConsent$0(Activity activity, final OnConsentGatheringCompleteListener onConsentGatheringCompleteListener) {
        Objects.requireNonNull(onConsentGatheringCompleteListener);
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.mimikridev.ads.gdpr.c
            @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
            public final void onConsentFormDismissed(FormError formError) {
                onConsentGatheringCompleteListener.consentGatheringComplete(formError);
            }
        });
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

    public boolean canRequestAds() {
        return this.consentInformation.canRequestAds();
    }

    public void gatherConsent(Activity activity, boolean z2, boolean z7, OnConsentGatheringCompleteListener onConsentGatheringCompleteListener) {
        if (z2) {
            this.params = new ConsentRequestParameters.Builder().setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setDebugGeography(1).addTestDeviceHashedId(md5(Settings.Secure.getString(activity.getContentResolver(), "android_id")).toUpperCase()).build()).setTagForUnderAgeOfConsent(z7).build();
        } else {
            this.params = new ConsentRequestParameters.Builder().setTagForUnderAgeOfConsent(z7).build();
        }
        ConsentInformation consentInformation = this.consentInformation;
        ConsentRequestParameters consentRequestParameters = this.params;
        h hVar = new h(this, activity, onConsentGatheringCompleteListener, 8);
        Objects.requireNonNull(onConsentGatheringCompleteListener);
        consentInformation.requestConsentInfoUpdate(activity, consentRequestParameters, hVar, new androidx.camera.core.impl.b(onConsentGatheringCompleteListener, 25));
    }

    public boolean isPrivacyOptionsRequired() {
        return this.consentInformation.getPrivacyOptionsRequirementStatus() == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
    }

    public void showPrivacyOptionsForm(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity, onConsentFormDismissedListener);
    }
}
