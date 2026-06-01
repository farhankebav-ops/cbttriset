package com.mimikridev.ads.gdpr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class LegacyGDPR {
    Activity activity;

    public LegacyGDPR(Activity activity) {
        this.activity = activity;
    }

    public static Bundle getBundleAd(Activity activity) {
        return new Bundle();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class GDPRForm {
        Activity activity;

        private GDPRForm(Activity activity) {
            this.activity = activity;
        }

        private URL getUrlPrivacyPolicy(String str) {
            try {
                return new URL(str);
            } catch (MalformedURLException e) {
                Log.e(GDPR.TAG, e.getMessage());
                return null;
            }
        }

        private void displayConsentForm(String str) {
        }
    }

    public void updateLegacyGDPRConsentStatus(String str, String str2) {
    }
}
