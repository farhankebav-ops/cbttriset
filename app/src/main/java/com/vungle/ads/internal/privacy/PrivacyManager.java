package com.vungle.ads.internal.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.VisibleForTesting;
import com.ironsource.Y1;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.Logger;
import e2.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PrivacyManager {
    private static PrivacyConsent ccpaConsent;
    private static FilePreferences filePreferences;
    private static String gdprConsent;
    private static String gdprConsentMessageVersion;
    private static String gdprConsentSource;
    private static Long gdprConsentTimestamp;
    private static SharedPreferences sharedPreferences;
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum DeviceIdAllowed {
        ALLOW_ID,
        DISABLE_ID,
        FALLBACK
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DeviceIdAllowed.values().length];
            iArr[DeviceIdAllowed.DISABLE_ID.ordinal()] = 1;
            iArr[DeviceIdAllowed.FALLBACK.ordinal()] = 2;
            iArr[DeviceIdAllowed.ALLOW_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConfigPayload.IABSettings.TcfStatus.values().length];
            iArr2[ConfigPayload.IABSettings.TcfStatus.DISABLE_ID.ordinal()] = 1;
            iArr2[ConfigPayload.IABSettings.TcfStatus.ALLOW_ID.ordinal()] = 2;
            iArr2[ConfigPayload.IABSettings.TcfStatus.LEGACY.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private PrivacyManager() {
    }

    private final void saveCcpaConsent(PrivacyConsent privacyConsent) {
        FilePreferences filePreferencesPut;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 == null || (filePreferencesPut = filePreferences2.put(Cookie.CCPA_CONSENT_STATUS, privacyConsent.getValue())) == null) {
            return;
        }
        filePreferencesPut.apply();
    }

    private final void saveCoppaConsent(boolean z2) {
        FilePreferences filePreferencesPut;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 == null || (filePreferencesPut = filePreferences2.put("is_coppa", z2)) == null) {
            return;
        }
        filePreferencesPut.apply();
    }

    private final void saveGdprConsent(String str, String str2, String str3, long j) {
        FilePreferences filePreferencesPut;
        FilePreferences filePreferencesPut2;
        FilePreferences filePreferencesPut3;
        FilePreferences filePreferencesPut4;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 == null || (filePreferencesPut = filePreferences2.put(Cookie.GDPR_CONSENT_STATUS, str)) == null || (filePreferencesPut2 = filePreferencesPut.put(Cookie.GDPR_CONSENT_SOURCE, str2)) == null || (filePreferencesPut3 = filePreferencesPut2.put(Cookie.GDPR_CONSENT_MESSAGE_VERSION, str3)) == null || (filePreferencesPut4 = filePreferencesPut3.put(Cookie.GDPR_CONSENT_TIMESTAMP, j)) == null) {
            return;
        }
        filePreferencesPut4.apply();
    }

    public final DeviceIdAllowed allowDeviceIDFromTCF() {
        Boolean gdprAppliesFromPreferences = getGdprAppliesFromPreferences();
        if (!k.a(gdprAppliesFromPreferences, Boolean.TRUE)) {
            return gdprAppliesFromPreferences == null ? DeviceIdAllowed.FALLBACK : DeviceIdAllowed.ALLOW_ID;
        }
        ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
        int i2 = tcfStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                return DeviceIdAllowed.DISABLE_ID;
            }
            if (i2 == 2) {
                return DeviceIdAllowed.ALLOW_ID;
            }
            if (i2 != 3) {
                throw new s(3);
            }
        }
        return DeviceIdAllowed.FALLBACK;
    }

    public final String getCcpaStatus() {
        String value;
        PrivacyConsent privacyConsent = ccpaConsent;
        return (privacyConsent == null || (value = privacyConsent.getValue()) == null) ? PrivacyConsent.UNKNOWN.getValue() : value;
    }

    public final String getConsentMessageVersion() {
        String str = gdprConsentMessageVersion;
        return str == null ? "" : str;
    }

    public final String getConsentSource() {
        String str = gdprConsentSource;
        return str == null ? "no_interaction" : str;
    }

    public final String getConsentStatus() {
        String str = gdprConsent;
        return str == null ? "unknown" : str;
    }

    public final long getConsentTimestamp() {
        Long l = gdprConsentTimestamp;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final COPPA getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        return atomicReference.get() == null ? COPPA.COPPA_NOTSET : k.a(atomicReference.get(), Boolean.TRUE) ? COPPA.COPPA_ENABLED : k.a(atomicReference.get(), Boolean.FALSE) ? COPPA.COPPA_DISABLED : COPPA.COPPA_NOTSET;
    }

    @VisibleForTesting
    public final Boolean getDisableAdId$vungle_ads_release() {
        return disableAdId.get();
    }

    public final Boolean getGdprAppliesFromPreferences() {
        Object objM;
        Object objM2;
        String string;
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            objM = sharedPreferences2 != null ? Integer.valueOf(sharedPreferences2.getInt(Cookie.IABTCF_GDPR_APPLIES, -1)) : null;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (q5.k.a(objM) != null) {
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                objM2 = (sharedPreferences3 == null || (string = sharedPreferences3.getString(Cookie.IABTCF_GDPR_APPLIES, Y1.f7808f)) == null) ? null : Integer.valueOf(Integer.parseInt(string));
            } catch (Throwable th2) {
                objM2 = q.M(th2);
            }
            objM = objM2;
        }
        if (objM instanceof j) {
            objM = null;
        }
        Integer num = (Integer) objM;
        if (num != null && num.intValue() == 1) {
            return Boolean.TRUE;
        }
        if (num != null && num.intValue() == 0) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final String getIABTCFString() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString("IABTCF_TCString", "") : null;
        return string == null ? "" : string;
    }

    public final String getPreviousTcfToken() {
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null) {
            return filePreferences2.getString("previous_tcf_token", "");
        }
        return null;
    }

    public final SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public final synchronized void init(Context context) {
        Throwable th;
        try {
            try {
                k.e(context, "context");
                AtomicBoolean atomicBoolean = initialized;
                try {
                    if (atomicBoolean.get()) {
                        Logger.Companion.w("PrivacyManager", "PrivacyManager already initialized");
                        return;
                    }
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    FilePreferences filePreferences2 = (FilePreferences) ServiceLocator.Companion.getInstance(context).getService(FilePreferences.class);
                    filePreferences = filePreferences2;
                    AtomicReference<Boolean> atomicReference = disableAdId;
                    Boolean bool = atomicReference.get();
                    if (bool != null) {
                        saveDisableAdId(bool.booleanValue());
                    } else {
                        Boolean bool2 = filePreferences2.getBoolean(Cookie.COPPA_DISABLE_AD_ID);
                        if (bool2 != null) {
                            atomicReference.set(bool2);
                        }
                    }
                    String str = gdprConsent;
                    if (str != null) {
                        String str2 = gdprConsentSource;
                        if (str2 == null) {
                            str2 = "";
                        }
                        String str3 = gdprConsentMessageVersion;
                        if (str3 == null) {
                            str3 = "";
                        }
                        Long l = gdprConsentTimestamp;
                        saveGdprConsent(str, str2, str3, l != null ? l.longValue() : 0L);
                    } else {
                        String string = filePreferences2.getString(Cookie.GDPR_CONSENT_STATUS);
                        PrivacyConsent privacyConsent = PrivacyConsent.OPT_IN;
                        if (k.a(string, privacyConsent.getValue())) {
                            string = privacyConsent.getValue();
                        } else {
                            PrivacyConsent privacyConsent2 = PrivacyConsent.OPT_OUT;
                            if (k.a(string, privacyConsent2.getValue())) {
                                string = privacyConsent2.getValue();
                            }
                        }
                        gdprConsent = string;
                        gdprConsentSource = filePreferences2.getString(Cookie.GDPR_CONSENT_SOURCE);
                        gdprConsentMessageVersion = filePreferences2.getString(Cookie.GDPR_CONSENT_MESSAGE_VERSION);
                        gdprConsentTimestamp = Long.valueOf(filePreferences2.getLong(Cookie.GDPR_CONSENT_TIMESTAMP, 0L));
                    }
                    PrivacyConsent privacyConsent3 = ccpaConsent;
                    if (privacyConsent3 != null) {
                        saveCcpaConsent(privacyConsent3);
                    } else {
                        String string2 = filePreferences2.getString(Cookie.CCPA_CONSENT_STATUS);
                        PrivacyConsent privacyConsent4 = PrivacyConsent.OPT_OUT;
                        if (!k.a(privacyConsent4.getValue(), string2)) {
                            privacyConsent4 = PrivacyConsent.OPT_IN;
                        }
                        ccpaConsent = privacyConsent4;
                    }
                    AtomicReference<Boolean> atomicReference2 = coppaStatus;
                    Boolean bool3 = atomicReference2.get();
                    if (bool3 != null) {
                        saveCoppaConsent(bool3.booleanValue());
                    } else {
                        Boolean bool4 = filePreferences2.getBoolean("is_coppa");
                        if (bool4 != null) {
                            atomicReference2.set(bool4);
                        }
                    }
                    atomicBoolean.set(true);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @VisibleForTesting
    public final void saveDisableAdId(boolean z2) {
        FilePreferences filePreferencesPut;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 == null || (filePreferencesPut = filePreferences2.put(Cookie.COPPA_DISABLE_AD_ID, z2)) == null) {
            return;
        }
        filePreferencesPut.apply();
    }

    public final void setPreviousTcfToken(String str) {
        FilePreferences filePreferences2;
        FilePreferences filePreferencesPut;
        if (str == null || str.length() == 0 || (filePreferences2 = filePreferences) == null || (filePreferencesPut = filePreferences2.put("previous_tcf_token", str)) == null) {
            return;
        }
        filePreferencesPut.apply();
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences2) {
        sharedPreferences = sharedPreferences2;
    }

    public final boolean shouldReturnTrueForLegacy$vungle_ads_release() {
        String iABTCFString = getIABTCFString();
        if (k.a(getPreviousTcfToken(), iABTCFString)) {
            return false;
        }
        setPreviousTcfToken(iABTCFString);
        return true;
    }

    public final boolean shouldSendAdIds() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[allowDeviceIDFromTCF().ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                throw new s(3);
            }
            Boolean disableAdId$vungle_ads_release = getDisableAdId$vungle_ads_release();
            if (disableAdId$vungle_ads_release != null && !disableAdId$vungle_ads_release.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean shouldSendTCFString() {
        if (!k.a(getGdprAppliesFromPreferences(), Boolean.TRUE)) {
            return false;
        }
        ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
        int i2 = tcfStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i2 != -1) {
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            if (i2 != 3) {
                throw new s(3);
            }
        }
        return shouldReturnTrueForLegacy$vungle_ads_release();
    }

    public final void updateCcpaConsent(PrivacyConsent consent) {
        k.e(consent, "consent");
        ccpaConsent = consent;
        saveCcpaConsent(consent);
    }

    public final void updateCoppaConsent(boolean z2) {
        coppaStatus.set(Boolean.valueOf(z2));
        saveCoppaConsent(z2);
    }

    public final void updateDisableAdId(boolean z2) {
        disableAdId.set(Boolean.valueOf(z2));
        saveDisableAdId(z2);
    }

    public final void updateGdprConsent(String consent, String source, String str) {
        k.e(consent, "consent");
        k.e(source, "source");
        gdprConsent = consent;
        gdprConsentSource = source;
        gdprConsentMessageVersion = str;
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        gdprConsentTimestamp = Long.valueOf(jCurrentTimeMillis);
        String str2 = gdprConsentMessageVersion;
        if (str2 == null) {
            str2 = "";
        }
        saveGdprConsent(consent, source, str2, jCurrentTimeMillis);
    }
}
