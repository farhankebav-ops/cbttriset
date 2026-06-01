package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.P7;
import com.ironsource.V3;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Me {
    protected static final boolean A = false;
    protected static final String A0 = "waitUntilAllProvidersFinishInit";
    protected static final String A1 = "providerNetworkKey";
    protected static final int B = 60;
    protected static final String B0 = "sharedManagersThread";
    protected static final String B1 = "spId";
    protected static final int C = 10000;
    protected static final String C0 = "parallelLoad";
    protected static final String C1 = "mpis";
    protected static final int D = 10000;
    protected static final String D0 = "bidderExclusive";
    protected static final String D1 = "auction";
    protected static final int E = -1;
    protected static final String E0 = "adapterTimeOutInSeconds";
    protected static final String E1 = "auctionData";
    protected static final int F = 5000;
    protected static final String F0 = "atim";
    protected static final String F1 = "auctioneerURL";
    protected static final int G = 3;
    protected static final String G0 = "bannerInterval";
    protected static final String G1 = "extAuctioneerURL";
    protected static final int H = 3;
    protected static final String H0 = "isOneFlow";
    protected static final String H1 = "objectPerWaterfall";
    protected static final int I = 3;
    protected static final String I0 = "expiredDurationInMinutes";
    protected static final String I1 = "minTimeBeforeFirstAuction";
    protected static final int J = 0;
    protected static final String J0 = "server";
    protected static final String J1 = "timeToWaitBeforeAuction";
    protected static final int K = 2;
    protected static final String K0 = "publisher";
    protected static final String K1 = "timeToWaitBeforeLoad";
    protected static final int L = 15;
    protected static final String L0 = "console";
    protected static final String L1 = "auctionRetryInterval";
    protected static final long M = 10000;
    protected static final String M0 = "sendUltraEvents";
    protected static final String M1 = "isLoadWhileShow";
    protected static final long N = 3000;
    protected static final String N0 = "sendEventsToggle";
    protected static final String N1 = "auctionTrials";
    protected static final boolean O = false;
    protected static final String O0 = "eventsCompression";
    protected static final String O1 = "auctionTimeout";
    protected static final boolean P = false;
    protected static final String P0 = "eventsCompressionLevel";
    protected static final String P1 = "auctionSavedHistory";
    protected static final int Q = 30000;
    protected static final String Q0 = "serverEventsURL";
    protected static final String Q1 = "disableLoadWhileShowSupportFor";
    protected static final int R = -1;
    protected static final String R0 = "serverEventsType";
    protected static final String R1 = "tokenPerAdapter";
    protected static final int S = 5000;
    protected static final String S0 = "backupThreshold";
    protected static final String S1 = "enableAuctionFallback";
    protected static final int T = 1;
    protected static final String T0 = "maxNumberOfEvents";
    protected static final String T1 = "timeToDeleteOldWaterfallAfterAuction";
    protected static final boolean U = false;
    protected static final String U0 = "maxEventsPerBatch";
    protected static final String U1 = "compressAuctionRequest";
    protected static final int V = 15000;
    protected static final String V0 = "optOut";
    protected static final String V1 = "compressAuctionResponse";
    protected static final int W = 15000;
    protected static final String W0 = "optIn";
    protected static final String W1 = "encryptionVersion";
    protected static final String X = "providerOrder";
    protected static final String X0 = "triggerEvents";
    protected static final String X1 = "shouldSendBannerBURLFromImpression";
    protected static final String Y = "providerSettings";
    protected static final String Y0 = "nonConnectivityEvents";
    protected static final String Y1 = "impressionTimeout";
    protected static final String Z = "configurations";
    protected static final String Z0 = "shouldSendPublisherLogsOnUIThread";
    protected static final String Z1 = "optInKeys";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected static final String f7164a0 = "genericParams";

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    protected static final String f7165a1 = "pixel";

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    protected static final String f7166a2 = "tokenGenericParams";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected static final String f7167b0 = "adUnits";

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    protected static final String f7168b1 = "pixelEventsUrl";

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    protected static final String f7169b2 = "compressToken";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected static final String f7170c0 = "providerLoadName";

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    protected static final String f7171c1 = "pixelEventsEnabled";

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    protected static final String f7172c2 = "compressExternalToken";
    protected static final String d0 = "application";

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    protected static final String f7173d1 = "placements";

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    protected static final String f7174d2 = "instanceType";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected static final String f7175e0 = "rewardedVideo";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    protected static final String f7176e1 = "placementId";

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    protected static final String f7177e2 = "maxAdsPerSession";
    protected static final String f0 = "interstitial";

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    protected static final String f7178f1 = "placementName";

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    protected static final String f7179f2 = "reward";
    protected static final String g0 = "banner";

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    protected static final String f7180g1 = "delivery";

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    protected static final String f7181g2 = "name";
    protected static final String h0 = "nativeAd";

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    protected static final String f7182h1 = "isDefault";

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    protected static final String f7183h2 = "amount";
    protected static final String i0 = "integration";

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    protected static final String f7184i1 = "capping";
    protected static final String i2 = "bannerRefreshRate";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    protected static final String f7185j0 = "loggers";

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    protected static final String f7186j1 = "pacing";

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    protected static final String f7187j2 = "protocolVersion";
    protected static final String k0 = "segment";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    protected static final String f7188k1 = "enabled";

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    protected static final String f7189k2 = "adFormats";
    public static final String l = "appKey";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected static final String f7190l0 = "events";

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    protected static final String f7191l1 = "maxImpressions";

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    protected static final String f7192l2 = "adUnits";
    public static final String m = "userId";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected static final String f7193m0 = "crashReporter";

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    protected static final String f7194m1 = "numOfSeconds";
    protected static final String m2 = "rewarded";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7195n = "response";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected static final String f7196n0 = "token";

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    protected static final String f7197n1 = "unit";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static final String f7198o = "error";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected static final String f7199o0 = "external";

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    protected static final String f7200o1 = "virtualItemName";
    protected static final int p = 3;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected static final String f7201p0 = "mediationTypes";

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    protected static final String f7202p1 = "virtualItemCount";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected static final boolean f7203q = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected static final String f7204q0 = "providerDefaultInstance";

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    protected static final String f7205q1 = "uuidEnabled";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected static final boolean f7206r = true;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected static final String f7207r0 = "testSuite";
    protected static final String r1 = "abt";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static final boolean f7208s = true;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected static final String f7209s0 = "controllerUrl";

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    protected static final String f7210s1 = "delayLoadFailure";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final int f7211t = 2;
    protected static final String t0 = "AdQuality";

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    protected static final String f7212t1 = "keysToInclude";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected static final int f7213u = 2;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    protected static final String f7214u0 = "initMode";

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    protected static final String f7215u1 = "reporterURL";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected static final int f7216v = 1;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected static final String f7217v0 = "adq_init_blob";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    protected static final String f7218v1 = "reporterKeyword";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected static final int f7219w = 1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected static final String f7220w0 = "settings";

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    protected static final String f7221w1 = "includeANR";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected static final boolean f7222x = true;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    protected static final String f7223x0 = "collectBiddingDataTimeout";

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    protected static final String f7224x1 = "timeout";
    protected static final boolean y = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected static final String f7225y0 = "providers";

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    protected static final String f7226y1 = "setIgnoreDebugger";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected static final boolean f7227z = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected static final String f7228z0 = "parallelInit";

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    protected static final String f7229z1 = "adSourceName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bd f7230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dd f7231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private V3 f7232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7233d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f7234f;
    private Context g;
    private a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private P7.a f7235i;
    private boolean j;
    private Q5 k;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        NOT_SET("0"),
        CACHE("1"),
        SERVER("2");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7239a;

        a(String str) {
            this.f7239a = str;
        }

        public String b() {
            return this.f7239a;
        }
    }

    public Me(Context context, String str, String str2, String str3) {
        this.h = a.NOT_SET;
        this.j = false;
        this.g = context;
        this.f7235i = Mb.O().x();
        try {
            if (TextUtils.isEmpty(str3)) {
                this.f7234f = new JSONObject();
            } else {
                this.f7234f = new JSONObject(str3);
            }
            this.j = n();
            s();
            q();
            r();
            this.f7233d = TextUtils.isEmpty(str) ? "" : str;
            this.e = TextUtils.isEmpty(str2) ? "" : str2;
            b(this.f7234f);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            a();
        }
    }

    public static a a(Me me) {
        return me != null ? me.h() : a.NOT_SET;
    }

    private void b(JSONObject jSONObject) {
        this.k = new Q5(jSONObject.optJSONObject(C2609ve.f10457d));
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private C2371i3 d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("placementId", -1);
        String strOptString = jSONObject.optString("placementName", "");
        boolean zOptBoolean = jSONObject.optBoolean(f7182h1, false);
        C2452md c2452mdA = a(jSONObject);
        if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        C2371i3 c2371i3 = new C2371i3(iOptInt, strOptString, zOptBoolean, c2452mdA);
        if (c2452mdA != null) {
            this.f7235i.b(this.g, c2371i3, IronSource.a.BANNER);
        }
        return c2371i3;
    }

    private K9 e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("placementId", -1);
        String strOptString = jSONObject.optString("placementName", "");
        boolean zOptBoolean = jSONObject.optBoolean(f7182h1, false);
        C2452md c2452mdA = a(jSONObject);
        if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        K9 k9 = new K9(iOptInt, strOptString, zOptBoolean, c2452mdA);
        if (c2452mdA != null) {
            this.f7235i.b(this.g, k9, IronSource.a.INTERSTITIAL);
        }
        return k9;
    }

    private String l() {
        return this.j ? "rewarded" : "rewardedVideo";
    }

    private boolean m() {
        JSONObject jSONObjectC;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectC2 = c(this.f7234f, "providerOrder");
        JSONArray jSONArrayNames = jSONObjectC2.names();
        if (jSONArrayNames == null) {
            return true;
        }
        JSONObject jSONObjectC3 = c(c(this.f7234f, "configurations"), b());
        for (int i8 = 0; i8 < jSONArrayNames.length(); i8++) {
            String strOptString = jSONArrayNames.optString(i8);
            JSONArray jSONArrayOptJSONArray2 = jSONObjectC2.optJSONArray(strOptString);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0 && (jSONObjectC = c(jSONObjectC3, strOptString)) != null && ((jSONArrayOptJSONArray = jSONObjectC.optJSONArray("placements")) == null || jSONArrayOptJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean n() {
        int iOptInt;
        try {
            iOptInt = this.f7234f.optInt(f7187j2, 0);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            iOptInt = 0;
        }
        return iOptInt == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q() {
        /*
            Method dump skipped, instruction units count: 2243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Me.q():void");
    }

    private void r() {
        try {
            JSONObject jSONObjectC = c(this.f7234f, "providerOrder");
            JSONArray jSONArrayB = b(jSONObjectC, l());
            JSONArray jSONArrayB2 = b(jSONObjectC, "interstitial");
            JSONArray jSONArrayB3 = b(jSONObjectC, "banner");
            JSONArray jSONArrayB4 = b(jSONObjectC, "nativeAd");
            this.f7230a = new Bd();
            if (jSONArrayB != null && c() != null && c().f() != null) {
                for (int i8 = 0; i8 < jSONArrayB.length(); i8++) {
                    String strOptString = jSONArrayB.optString(i8);
                    this.f7230a.d(strOptString);
                    NetworkSettings networkSettingsB = Dd.c().b(strOptString);
                    if (networkSettingsB != null) {
                        networkSettingsB.setRewardedVideoPriority(i8);
                    }
                }
            }
            if (jSONArrayB2 != null && c() != null && c().d() != null) {
                for (int i9 = 0; i9 < jSONArrayB2.length(); i9++) {
                    String strOptString2 = jSONArrayB2.optString(i9);
                    this.f7230a.b(strOptString2);
                    NetworkSettings networkSettingsB2 = Dd.c().b(strOptString2);
                    if (networkSettingsB2 != null) {
                        networkSettingsB2.setInterstitialPriority(i9);
                    }
                }
            }
            if (jSONArrayB3 != null) {
                for (int i10 = 0; i10 < jSONArrayB3.length(); i10++) {
                    String strOptString3 = jSONArrayB3.optString(i10);
                    this.f7230a.a(strOptString3);
                    NetworkSettings networkSettingsB3 = Dd.c().b(strOptString3);
                    if (networkSettingsB3 != null) {
                        networkSettingsB3.setBannerPriority(i10);
                    }
                }
            }
            if (jSONArrayB4 != null) {
                for (int i11 = 0; i11 < jSONArrayB4.length(); i11++) {
                    String strOptString4 = jSONArrayB4.optString(i11);
                    this.f7230a.c(strOptString4);
                    NetworkSettings networkSettingsB4 = Dd.c().b(strOptString4);
                    if (networkSettingsB4 != null) {
                        networkSettingsB4.setNativeAdPriority(i11);
                    }
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void s() {
        JSONObject jSONObject;
        Iterator<String> it;
        try {
            this.f7231b = Dd.c();
            JSONObject jSONObjectC = c(this.f7234f, "providerSettings");
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("mpis", false);
                    String strOptString = jSONObjectOptJSONObject.optString("spId", "0");
                    String strOptString2 = jSONObjectOptJSONObject.optString("adSourceName", null);
                    String strOptString3 = jSONObjectOptJSONObject.optString("providerNetworkKey", null);
                    String strOptString4 = jSONObjectOptJSONObject.optString("providerLoadName", next);
                    String strOptString5 = jSONObjectOptJSONObject.optString("providerDefaultInstance", strOptString4);
                    JSONObject jSONObjectC2 = c(jSONObjectOptJSONObject, b());
                    JSONObject jSONObjectC3 = c(jSONObjectOptJSONObject, "application");
                    JSONObject jSONObjectC4 = c(jSONObjectC2, l());
                    JSONObject jSONObjectC5 = c(jSONObjectC2, "interstitial");
                    JSONObject jSONObjectC6 = c(jSONObjectC2, "banner");
                    JSONObject jSONObjectC7 = c(jSONObjectC2, "nativeAd");
                    JSONObject jSONObjectB = IronSourceUtils.b(jSONObjectC4, jSONObjectC3);
                    JSONObject jSONObjectB2 = IronSourceUtils.b(jSONObjectC5, jSONObjectC3);
                    JSONObject jSONObjectB3 = IronSourceUtils.b(jSONObjectC6, jSONObjectC3);
                    JSONObject jSONObjectB4 = IronSourceUtils.b(jSONObjectC7, jSONObjectC3);
                    if (this.f7231b.a(next)) {
                        Mb.U().q().a(new C5(D5.TROUBLESHOOTING_MERGE_LOCAL_SETTINGS, (JSONObject) null));
                        NetworkSettings networkSettingsB = this.f7231b.b(next);
                        JSONObject rewardedVideoSettings = networkSettingsB.getRewardedVideoSettings();
                        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
                        JSONObject bannerSettings = networkSettingsB.getBannerSettings();
                        JSONObject nativeAdSettings = networkSettingsB.getNativeAdSettings();
                        networkSettingsB.setRewardedVideoSettings(IronSourceUtils.b(rewardedVideoSettings, jSONObjectB));
                        networkSettingsB.setInterstitialSettings(IronSourceUtils.b(interstitialSettings, jSONObjectB2));
                        networkSettingsB.setBannerSettings(IronSourceUtils.b(bannerSettings, jSONObjectB3));
                        networkSettingsB.setNativeAdSettings(IronSourceUtils.b(nativeAdSettings, jSONObjectB4));
                        networkSettingsB.setIsMultipleInstances(zOptBoolean);
                        networkSettingsB.setSubProviderId(strOptString);
                        networkSettingsB.setAdSourceNameForEvents(strOptString2);
                        networkSettingsB.setProviderNetworkKey(strOptString3);
                    } else {
                        if (b(strOptString4)) {
                            jSONObject = jSONObjectC;
                            NetworkSettings networkSettingsB2 = this.f7231b.b("Mediation");
                            JSONObject rewardedVideoSettings2 = networkSettingsB2.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = networkSettingsB2.getInterstitialSettings();
                            JSONObject bannerSettings2 = networkSettingsB2.getBannerSettings();
                            JSONObject nativeAdSettings2 = networkSettingsB2.getNativeAdSettings();
                            it = itKeys;
                            NetworkSettings networkSettings = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, IronSourceUtils.b(new JSONObject(rewardedVideoSettings2.toString()), jSONObjectB), IronSourceUtils.b(new JSONObject(interstitialSettings2.toString()), jSONObjectB2), IronSourceUtils.b(new JSONObject(bannerSettings2.toString()), jSONObjectB3), IronSourceUtils.b(new JSONObject(nativeAdSettings2.toString()), jSONObjectB4));
                            networkSettings.setIsMultipleInstances(zOptBoolean);
                            networkSettings.setSubProviderId(strOptString);
                            networkSettings.setAdSourceNameForEvents(strOptString2);
                            this.f7231b.a(networkSettings);
                        } else {
                            jSONObject = jSONObjectC;
                            it = itKeys;
                            NetworkSettings networkSettings2 = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, jSONObjectB, jSONObjectB2, jSONObjectB3, jSONObjectB4);
                            networkSettings2.setIsMultipleInstances(zOptBoolean);
                            networkSettings2.setSubProviderId(strOptString);
                            networkSettings2.setAdSourceNameForEvents(strOptString2);
                            this.f7231b.a(networkSettings2);
                        }
                        jSONObjectC = jSONObject;
                        itKeys = it;
                    }
                }
            }
            this.f7231b.b();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public C2269c9 f() {
        return new C2269c9(this.f7233d, this.e);
    }

    public List<IronSource.a> g() {
        Bd bd;
        Bd bd2;
        Bd bd3;
        Bd bd4;
        if (this.f7234f == null || this.f7232c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f7232c.f() != null && (bd4 = this.f7230a) != null && !bd4.d().isEmpty()) {
            arrayList.add(IronSource.a.REWARDED_VIDEO);
        }
        if (this.f7232c.d() != null && (bd3 = this.f7230a) != null && !bd3.b().isEmpty()) {
            arrayList.add(IronSource.a.INTERSTITIAL);
        }
        if (this.f7232c.c() != null && (bd2 = this.f7230a) != null && !bd2.a().isEmpty()) {
            arrayList.add(IronSource.a.BANNER);
        }
        if (this.f7232c.e() != null && (bd = this.f7230a) != null && !bd.c().isEmpty()) {
            arrayList.add(IronSource.a.NATIVE_AD);
        }
        return arrayList;
    }

    public a h() {
        return this.h;
    }

    public JSONObject i() {
        return this.f7234f;
    }

    public Bd j() {
        return this.f7230a;
    }

    public Dd k() {
        return this.f7231b;
    }

    public boolean o() {
        return !TextUtils.isEmpty(c().g().b());
    }

    public boolean p() {
        JSONObject jSONObject = this.f7234f;
        return (jSONObject == null || jSONObject.has("error") || this.f7230a == null || this.f7231b == null || this.f7232c == null || !m()) ? false : true;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.f7233d);
            jSONObject.put("userId", this.e);
            jSONObject.put(f7195n, this.f7234f);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObject.toString();
    }

    private String b() {
        return this.j ? "adFormats" : X0.f7791c;
    }

    private C2272cc f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("placementId", -1);
        String strOptString = jSONObject.optString("placementName", "");
        boolean zOptBoolean = jSONObject.optBoolean(f7182h1, false);
        C2452md c2452mdA = a(jSONObject);
        if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        C2272cc c2272cc = new C2272cc(iOptInt, strOptString, zOptBoolean, c2452mdA);
        if (c2452mdA != null) {
            this.f7235i.b(this.g, c2272cc, IronSource.a.NATIVE_AD);
        }
        return c2272cc;
    }

    private Of h(JSONObject jSONObject) {
        Of of = new Of();
        JSONObject jSONObjectC = c(jSONObject, "testSuite");
        if (jSONObjectC != null) {
            of.b(jSONObjectC.optString("controllerUrl"));
        }
        return of;
    }

    public V3 c() {
        return this.f7232c;
    }

    private JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        if (!this.j) {
            return jSONObject.optJSONArray(str);
        }
        JSONObject jSONObjectC = c(jSONObject, str);
        String strA = a(str);
        if (jSONObjectC == null || strA == null) {
            return null;
        }
        return jSONObjectC.optJSONArray(strA);
    }

    private com.ironsource.mediationsdk.adquality.a c(JSONObject jSONObject) {
        com.ironsource.mediationsdk.adquality.a aVar = new com.ironsource.mediationsdk.adquality.a();
        JSONObject jSONObjectC = c(jSONObject, "AdQuality");
        if (jSONObjectC != null) {
            aVar.a(jSONObjectC.optInt("initMode", 0));
            new V9().b(jSONObjectC.optString("adq_init_blob"));
        }
        return aVar;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    private void a() {
        this.f7234f = new JSONObject();
        this.f7233d = "";
        this.e = "";
        this.f7230a = new Bd();
        this.f7231b = Dd.c();
        this.f7232c = new V3.a().a();
        this.f7235i = Mb.O().x();
        b(this.f7234f);
    }

    private boolean b(String str) {
        return this.f7231b.a("Mediation") && StringUtils.toLowerCase("IronSource").equals(StringUtils.toLowerCase(str));
    }

    private JSONObject d(JSONObject jSONObject, String str) {
        JSONObject jSONObjectC = c(jSONObject, str);
        return jSONObjectC != null ? jSONObjectC : new JSONObject();
    }

    public Q5 e() {
        return this.k;
    }

    private Context d() {
        return this.g;
    }

    private String a(String str) {
        try {
            JSONObject jSONObjectC = c(c(c(c(this.f7234f, "configurations"), "adFormats"), str), X0.f7791c);
            if (jSONObjectC == null) {
                return null;
            }
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectC2 = c(jSONObjectC, next);
                if (jSONObjectC2 != null && jSONObjectC2.optBoolean(f7182h1)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    public static C2258bg b(Me me) {
        if (me != null && me.p()) {
            return me.c().b().k();
        }
        return C2258bg.a();
    }

    private C2434ld g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("placementId", -1);
        String strOptString = jSONObject.optString("placementName", "");
        boolean zOptBoolean = jSONObject.optBoolean(f7182h1, false);
        String strOptString2 = jSONObject.optString("virtualItemName", "");
        int iOptInt2 = jSONObject.optInt("virtualItemCount", -1);
        C2452md c2452mdA = a(jSONObject);
        if (iOptInt < 0 || TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || iOptInt2 <= 0) {
            return null;
        }
        C2434ld c2434ld = new C2434ld(iOptInt, strOptString, zOptBoolean, strOptString2, iOptInt2, c2452mdA);
        if (c2452mdA != null) {
            this.f7235i.b(this.g, c2434ld, IronSource.a.REWARDED_VIDEO);
        }
        return c2434ld;
    }

    public Me(Me me) {
        this.h = a.NOT_SET;
        this.j = false;
        try {
            this.g = me.d();
            this.f7234f = new JSONObject(me.f7234f.toString());
            this.f7233d = me.f7233d;
            this.e = me.e;
            this.j = me.j;
            this.f7230a = me.j();
            this.f7231b = me.k();
            this.f7232c = me.c();
            this.h = me.h();
            this.f7235i = Mb.O().x();
            b(this.f7234f);
        } catch (Exception e) {
            C2531r4.d().a(e);
            a();
        }
    }

    private H1 a(JSONObject jSONObject, Boolean bool) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        boolean zOptBoolean = jSONObject.optBoolean("sendEventsToggle", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("eventsCompression", false);
        int iOptInt = jSONObject.optInt("eventsCompressionLevel", -1);
        String strOptString = jSONObject.optString("serverEventsURL", "");
        String strOptString2 = jSONObject.optString("serverEventsType", "");
        int iOptInt2 = jSONObject.optInt("backupThreshold", -1);
        int iOptInt3 = jSONObject.optInt("maxNumberOfEvents", -1);
        int iOptInt4 = jSONObject.optInt("maxEventsPerBatch", 5000);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("optOut");
        int[] iArr4 = null;
        if (jSONArrayOptJSONArray != null) {
            int[] iArr5 = new int[jSONArrayOptJSONArray.length()];
            for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                iArr5[i8] = jSONArrayOptJSONArray.optInt(i8);
            }
            iArr = iArr5;
        } else {
            iArr = null;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("optIn");
        if (jSONArrayOptJSONArray2 != null) {
            int[] iArr6 = new int[jSONArrayOptJSONArray2.length()];
            for (int i9 = 0; i9 < jSONArrayOptJSONArray2.length(); i9++) {
                iArr6[i9] = jSONArrayOptJSONArray2.optInt(i9);
            }
            iArr2 = iArr6;
        } else {
            iArr2 = null;
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("triggerEvents");
        if (jSONArrayOptJSONArray3 != null) {
            int[] iArr7 = new int[jSONArrayOptJSONArray3.length()];
            for (int i10 = 0; i10 < jSONArrayOptJSONArray3.length(); i10++) {
                iArr7[i10] = jSONArrayOptJSONArray3.optInt(i10);
            }
            iArr3 = iArr7;
        } else {
            iArr3 = null;
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("nonConnectivityEvents");
        if (jSONArrayOptJSONArray4 != null) {
            iArr4 = new int[jSONArrayOptJSONArray4.length()];
            for (int i11 = 0; i11 < jSONArrayOptJSONArray4.length(); i11++) {
                iArr4[i11] = jSONArrayOptJSONArray4.optInt(i11);
            }
        }
        return new H1(bool.booleanValue(), zOptBoolean, zOptBoolean2, iOptInt, strOptString, strOptString2, iOptInt2, iOptInt3, iOptInt4, iArr, iArr2, iArr3, iArr4);
    }

    private int[] a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArrayOptJSONArray.length()];
        for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
            iArr[i8] = jSONArrayOptJSONArray.optInt(i8);
        }
        return iArr;
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z2) {
        return jSONObject.has(str) ? jSONObject.optBoolean(str, z2) : jSONObject2.has(str) ? jSONObject2.optBoolean(str, z2) : z2;
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i8) {
        int iOptInt = 0;
        if (jSONObject.has(str)) {
            iOptInt = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            iOptInt = jSONObject2.optInt(str, 0);
        }
        return iOptInt == 0 ? i8 : iOptInt;
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        long jOptLong;
        if (jSONObject.has(str)) {
            jOptLong = jSONObject.optLong(str, 0L);
        } else {
            jOptLong = jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        }
        return jOptLong == 0 ? j : jOptLong;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[PHI: r7
  0x0036: PHI (r7v3 com.ironsource.qd) = (r7v1 com.ironsource.qd), (r7v2 com.ironsource.qd) binds: [B:10:0x0034, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ironsource.C2452md a(org.json.JSONObject r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            com.ironsource.md$a r1 = new com.ironsource.md$a
            r1.<init>()
            java.lang.String r2 = "delivery"
            r3 = 1
            boolean r2 = r10.optBoolean(r2, r3)
            r1.a(r2)
            java.lang.String r2 = "capping"
            org.json.JSONObject r2 = r10.optJSONObject(r2)
            java.lang.String r4 = "enabled"
            r5 = 0
            if (r2 == 0) goto L59
            java.lang.String r6 = "unit"
            java.lang.String r6 = r2.optString(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L45
            com.ironsource.qd r7 = com.ironsource.EnumC2524qd.PER_DAY
            java.lang.String r8 = r7.toString()
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L38
        L36:
            r0 = r7
            goto L45
        L38:
            com.ironsource.qd r7 = com.ironsource.EnumC2524qd.PER_HOUR
            java.lang.String r8 = r7.toString()
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L45
            goto L36
        L45:
            java.lang.String r6 = "maxImpressions"
            int r6 = r2.optInt(r6, r5)
            boolean r2 = r2.optBoolean(r4, r5)
            if (r2 == 0) goto L55
            if (r6 <= 0) goto L55
            r2 = r3
            goto L56
        L55:
            r2 = r5
        L56:
            r1.a(r2, r0, r6)
        L59:
            java.lang.String r0 = "pacing"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            if (r10 == 0) goto L74
            java.lang.String r0 = "numOfSeconds"
            int r0 = r10.optInt(r0, r5)
            boolean r10 = r10.optBoolean(r4, r5)
            if (r10 == 0) goto L70
            if (r0 <= 0) goto L70
            goto L71
        L70:
            r3 = r5
        L71:
            r1.a(r3, r0)
        L74:
            com.ironsource.md r10 = r1.a()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Me.a(org.json.JSONObject):com.ironsource.md");
    }
}
