package com.vungle.ads;

import com.ironsource.Ib;
import com.vungle.ads.internal.privacy.PrivacyConsent;
import com.vungle.ads.internal.privacy.PrivacyManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VunglePrivacySettings {
    public static final VunglePrivacySettings INSTANCE = new VunglePrivacySettings();

    private VunglePrivacySettings() {
    }

    public static final String getCCPAStatus() {
        return PrivacyManager.INSTANCE.getCcpaStatus();
    }

    public static final String getCOPPAStatus() {
        return PrivacyManager.INSTANCE.getCoppaStatus().name();
    }

    public static final String getGDPRMessageVersion() {
        return PrivacyManager.INSTANCE.getConsentMessageVersion();
    }

    public static final String getGDPRSource() {
        return PrivacyManager.INSTANCE.getConsentSource();
    }

    public static final String getGDPRStatus() {
        return PrivacyManager.INSTANCE.getConsentStatus();
    }

    public static final long getGDPRTimestamp() {
        return PrivacyManager.INSTANCE.getConsentTimestamp();
    }

    public static final void setCCPAStatus(boolean z2) {
        PrivacyManager.INSTANCE.updateCcpaConsent(z2 ? PrivacyConsent.OPT_IN : PrivacyConsent.OPT_OUT);
    }

    public static final void setCOPPAStatus(boolean z2) {
        PrivacyManager.INSTANCE.updateCoppaConsent(z2);
    }

    public static final void setGDPRStatus(boolean z2, String str) {
        PrivacyManager.INSTANCE.updateGdprConsent(z2 ? PrivacyConsent.OPT_IN.getValue() : PrivacyConsent.OPT_OUT.getValue(), Ib.f6987b, str);
    }
}
