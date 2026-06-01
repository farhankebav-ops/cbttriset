package com.ironsource.mediationsdk.adquality;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.C2270ca;
import com.ironsource.C2350h0;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.Mb;
import com.ironsource.N6;
import com.ironsource.O6;
import com.ironsource.adqualitysdk.sdk.ISAdQualityConfig;
import com.ironsource.adqualitysdk.sdk.ISAdQualityDeviceIdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitError;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdQualityBridge {
    public static final Companion Companion = new Companion(null);
    private static Boolean isGetVersionMethodExist;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGetVersionMethodExist() throws JSONException {
            try {
                if (AdQualityBridge.isGetVersionMethodExist != null) {
                    return k.a(AdQualityBridge.isGetVersionMethodExist, Boolean.TRUE);
                }
                boolean z2 = IronSourceAdQuality.class.getDeclaredMethods().length >= 10;
                AdQualityBridge.isGetVersionMethodExist = Boolean.valueOf(z2);
                return z2;
            } catch (Throwable th) {
                C2531r4.d().a(th);
                logEvent$default(this, D5.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST, null, null, 6, null);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logEvent(D5 d52, Integer num, String str) throws JSONException {
            JSONObject jSONObjectB = IronSourceUtils.b(false);
            if (num != null) {
                jSONObjectB.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            }
            if (str != null) {
                jSONObjectB.put("reason", str);
            }
            jSONObjectB.put(IronSourceConstants.EVENTS_EXT1, a.f8995a.a().b());
            Mb.f7131s.d().q().a(new C5(d52, jSONObjectB));
        }

        public static /* synthetic */ void logEvent$default(Companion companion, D5 d52, Integer num, String str, int i2, Object obj) throws JSONException {
            if ((i2 & 2) != 0) {
                num = null;
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            companion.logEvent(d52, num, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int versionCompare(String input, String input2) {
            if (TextUtils.isEmpty(input) || TextUtils.isEmpty(input2)) {
                return -1;
            }
            Pattern patternCompile = Pattern.compile("[^0-9.]");
            k.d(patternCompile, "compile(...)");
            k.e(input, "input");
            String strReplaceAll = patternCompile.matcher(input).replaceAll("");
            k.d(strReplaceAll, "replaceAll(...)");
            int i2 = 0;
            String[] strArr = (String[]) m.K0(strReplaceAll, new String[]{"."}, 6).toArray(new String[0]);
            Pattern patternCompile2 = Pattern.compile("[^0-9.]");
            k.d(patternCompile2, "compile(...)");
            k.e(input2, "input");
            String strReplaceAll2 = patternCompile2.matcher(input2).replaceAll("");
            k.d(strReplaceAll2, "replaceAll(...)");
            String[] strArr2 = (String[]) m.K0(strReplaceAll2, new String[]{"."}, 6).toArray(new String[0]);
            while (i2 < strArr.length && i2 < strArr2.length && k.a(strArr[i2], strArr2[i2])) {
                i2++;
            }
            if (i2 >= strArr.length || i2 >= strArr2.length) {
                return Integer.signum(strArr.length - strArr2.length);
            }
            int iIntValue = Integer.valueOf(strArr[i2]).intValue();
            Integer numValueOf = Integer.valueOf(strArr2[i2]);
            k.d(numValueOf, "valueOf(vals2[i])");
            return Integer.signum(k.g(iIntValue, numValueOf.intValue()));
        }

        public final boolean adQualityAvailable() {
            return versionCompare(getAdQualitySdkVersion(), "7.9.0") >= 0;
        }

        public final String getAdQualitySdkVersion() {
            if (!isGetVersionMethodExist()) {
                return new String();
            }
            String sDKVersion = IronSourceAdQuality.getSDKVersion();
            k.d(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }

        private Companion() {
        }

        private static /* synthetic */ void isGetVersionMethodExist$annotations() {
        }
    }

    public AdQualityBridge(Context context, String appKey, String str, C2350h0 adQualityDataProvider, int i2) throws JSONException {
        k.e(context, "context");
        k.e(appKey, "appKey");
        k.e(adQualityDataProvider, "adQualityDataProvider");
        ISAdQualityConfig.Builder deviceIdType = new ISAdQualityConfig.Builder().setInitializationSource("LevelPlay").setLogLevel(convertToAdQualityLogLevel(i2)).setAdQualityInitListener(new ISAdQualityInitListener() { // from class: com.ironsource.mediationsdk.adquality.AdQualityBridge$configBuilder$1
            @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener
            public void adQualitySdkInitFailed(ISAdQualityInitError isAdQualityInitError, String message) throws JSONException {
                k.e(isAdQualityInitError, "isAdQualityInitError");
                k.e(message, "message");
                D5 d52 = D5.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT;
                if (isAdQualityInitError == ISAdQualityInitError.AD_QUALITY_ALREADY_INITIALIZED) {
                    d52 = D5.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT;
                }
                AdQualityBridge.Companion.logEvent(d52, Integer.valueOf(isAdQualityInitError.getValue()), message);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Ad Quality failed to initialize: ".concat(message), 3);
            }

            @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener
            public void adQualitySdkInitSuccess() throws JSONException {
                AdQualityBridge.Companion.logEvent$default(AdQualityBridge.Companion, D5.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT, null, null, 6, null);
            }
        }).setCoppa(getCoppaValue()).setDeviceIdType(getDeviceIdType());
        if (!TextUtils.isEmpty(str)) {
            deviceIdType.setUserId(str);
        }
        Companion companion = Companion;
        if (companion.versionCompare(companion.getAdQualitySdkVersion(), "7.14.1") >= 0) {
            JSONObject jSONObjectA = adQualityDataProvider.a();
            if (jSONObjectA.length() > 0) {
                deviceIdType.setMetaData(jSONObjectA);
            }
        }
        Companion.logEvent$default(companion, D5.TROUBLESHOOTING_INITIALIZING_AD_QUALITY_SDK_EVENT, null, null, 6, null);
        IronSourceAdQuality.getInstance().initialize(context, appKey, deviceIdType.build());
    }

    public static final boolean adQualityAvailable() {
        return Companion.adQualityAvailable();
    }

    private final ISAdQualityLogLevel convertToAdQualityLogLevel(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.ERROR : ISAdQualityLogLevel.WARNING : ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.VERBOSE;
    }

    public static final String getAdQualitySdkVersion() {
        return Companion.getAdQualitySdkVersion();
    }

    private final boolean getCoppaValue() {
        String strA = N6.a().a("is_coppa");
        return strA != null && Boolean.parseBoolean(strA);
    }

    private final ISAdQualityDeviceIdType getDeviceIdType() {
        return !TextUtils.isEmpty(N6.a().a(O6.N)) ? ISAdQualityDeviceIdType.NONE : ISAdQualityDeviceIdType.GAID;
    }

    private static final boolean isGetVersionMethodExist() {
        return Companion.isGetVersionMethodExist();
    }

    private static final void logEvent(D5 d52, Integer num, String str) throws JSONException {
        Companion.logEvent(d52, num, str);
    }

    private static final int versionCompare(String str, String str2) {
        return Companion.versionCompare(str, str2);
    }

    public final void changeUserId(String userId) {
        k.e(userId, "userId");
        IronSourceAdQuality.getInstance().changeUserId(userId);
    }

    public final void setSegment(C2270ca segment) {
        k.e(segment, "segment");
        ISAdQualitySegment.Builder builder = new ISAdQualitySegment.Builder();
        if (segment.g() != null) {
            builder.setSegmentName(segment.g());
        }
        if (segment.a() > -1) {
            builder.setAge(segment.a());
        }
        if (segment.b() != null) {
            builder.setGender(segment.b());
        }
        if (segment.e() > -1) {
            builder.setLevel(segment.e());
        }
        if (segment.d() != null) {
            builder.setIsPaying(segment.d().get());
        }
        if (segment.c() > -1.0d) {
            builder.setInAppPurchasesTotal(segment.c());
        }
        if (segment.h() > 0) {
            builder.setUserCreationDate(segment.h());
        }
        ArrayList<Pair<String, String>> arrayListF = segment.f();
        int size = arrayListF.size();
        int i2 = 0;
        while (i2 < size) {
            Pair<String, String> pair = arrayListF.get(i2);
            i2++;
            Pair<String, String> pair2 = pair;
            String key = (String) pair2.first;
            String str = (String) pair2.second;
            k.d(key, "key");
            if (t.n0(key, "custom_", false)) {
                builder.setCustomData(m.F0(key, "custom_"), str);
            }
        }
        IronSourceAdQuality.getInstance().setSegment(builder.build());
    }
}
