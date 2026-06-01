package com.ironsource.sdk.controller;

import com.ironsource.C2267c7;
import com.ironsource.C2300e4;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2535r8;
import com.ironsource.Mb;
import com.ironsource.R3;
import com.ironsource.S3;
import com.ironsource.Ue;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FeaturesManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile FeaturesManager f9848d = null;
    private static final String e = "debugMode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, ?> f9849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f9850b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2535r8 f9851c = Mb.U().t();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends ArrayList<String> {
        public a() {
            add(C2300e4.d.f8329f);
            add(C2300e4.d.e);
            add(C2300e4.d.g);
            add(C2300e4.d.h);
            add(C2300e4.d.f8330i);
            add(C2300e4.d.j);
            add(C2300e4.d.k);
            add(C2300e4.d.l);
            add(C2300e4.d.m);
        }
    }

    private FeaturesManager() {
        if (f9848d != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.f9849a = new HashMap();
    }

    public static FeaturesManager getInstance() {
        if (f9848d == null) {
            synchronized (FeaturesManager.class) {
                try {
                    if (f9848d == null) {
                        f9848d = new FeaturesManager();
                    }
                } finally {
                }
            }
        }
        return f9848d;
    }

    public ArrayList<String> a() {
        return new ArrayList<>(this.f9850b);
    }

    public JSONObject getDataManagerConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return networkConfiguration.has(C2300e4.a.f8294d) ? networkConfiguration.optJSONObject(C2300e4.a.f8294d) : new JSONObject();
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.f9849a.containsKey("debugMode")) {
                num = (Integer) this.f9849a.get("debugMode");
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public R3 getFeatureFlagCatchUrlError() {
        return new R3(SDKUtils.getNetworkConfiguration().optJSONObject(R3.a.f7539c));
    }

    public S3 getFeatureFlagClickCheck() {
        return new S3(SDKUtils.getNetworkConfiguration());
    }

    public C2267c7 getFeatureFlagHealthCheck() {
        JSONObject jSONObjectA = this.f9851c.a(C2300e4.a.f8300r);
        return jSONObjectA != null ? new C2267c7(jSONObjectA) : new C2267c7(null);
    }

    public int getInitRecoverTrials() {
        JSONObject jSONObjectOptJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject(C2300e4.a.f8295f);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optInt(C2300e4.a.e, 0);
        }
        return 0;
    }

    public Ue getSessionHistoryConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return new Ue(networkConfiguration.has(C2300e4.a.f8301s) ? networkConfiguration.optJSONObject(C2300e4.a.f8301s) : new JSONObject());
    }

    public boolean getStopUseOnResumeAndPause() {
        return Boolean.TRUE.equals(this.f9851c.c(C2300e4.a.f8303u));
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.f9849a = map;
    }
}
