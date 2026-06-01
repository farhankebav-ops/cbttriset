package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.C2234aa;
import com.ironsource.C2243b1;
import com.ironsource.C2531r4;
import com.ironsource.adapters.ironsource.IronSourceLoadParameters;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f9149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected C2243b1 f9150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected JSONObject f9151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f9152d;
    private Timer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f9153f;
    protected String g;
    protected JSONObject h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected List<String> f9154i;
    protected String j;
    private final Object k = new Object();
    private final Object l = new Object();
    protected final IronSource.a m;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public m(C2243b1 c2243b1, AbstractAdapter abstractAdapter) {
        this.f9150b = c2243b1;
        this.m = c2243b1.b();
        this.f9149a = abstractAdapter;
        JSONObject jSONObjectC = c2243b1.c();
        this.f9151c = jSONObjectC;
        try {
            jSONObjectC.put(IronSourceLoadParameters.Constants.DEMAND_ONLY, true);
        } catch (JSONException e) {
            C2531r4.d().a(e);
        }
        this.f9152d = a.NOT_LOADED;
        this.e = null;
        this.g = "";
        this.h = null;
        this.f9154i = new ArrayList();
    }

    public boolean a(a aVar, a aVar2) {
        synchronized (this.k) {
            try {
                if (this.f9152d != aVar) {
                    return false;
                }
                b(aVar2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(a aVar) {
        IronLog.INTERNAL.verbose("DemandOnlySmash " + this.f9150b.f() + ": current state=" + this.f9152d + ", new state=" + aVar);
        synchronized (this.k) {
            this.f9152d = aVar;
        }
    }

    public C2243b1 f() {
        return this.f9150b;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.f9150b.f();
    }

    public int i() {
        return this.f9150b.d();
    }

    public Map<String, Object> j() {
        HashMap map = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.f9149a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f9149a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            map.put("spId", this.f9150b.i());
            map.put(IronSourceConstants.EVENTS_PROVIDER, this.f9150b.a());
            map.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            map.put("instanceType", Integer.valueOf(this.f9150b.d()));
            if (!TextUtils.isEmpty(this.g)) {
                map.put("auctionId", this.g);
            }
            JSONObject jSONObject = this.h;
            if (jSONObject != null && jSONObject.length() > 0) {
                map.put("genericParams", this.h);
            }
            if (!TextUtils.isEmpty(this.j)) {
                map.put("dynamicDemandSource", this.j);
            }
            if (o()) {
                map.put("isOneFlow", 1);
            }
            return map;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + h() + ")", e);
            return map;
        }
    }

    public String k() {
        a aVar = this.f9152d;
        return aVar == null ? "null" : aVar.toString();
    }

    public String l() {
        return this.f9150b.i();
    }

    public List<String> m() {
        return this.f9154i;
    }

    public boolean n() {
        return this.f9150b.j();
    }

    public boolean o() {
        return this.f9151c.optBoolean("isOneFlow", false);
    }

    public void p() {
        synchronized (this.l) {
            try {
                Timer timer = this.e;
                if (timer != null) {
                    timer.cancel();
                    this.e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a a(a[] aVarArr, a aVar) {
        a aVar2;
        synchronized (this.k) {
            try {
                aVar2 = this.f9152d;
                if (Arrays.asList(aVarArr).contains(this.f9152d)) {
                    b(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar2;
    }

    public void b(String str) {
        this.j = com.ironsource.mediationsdk.d.b().c(str);
    }

    public boolean a(a aVar) {
        boolean z2;
        synchronized (this.k) {
            z2 = this.f9152d == aVar;
        }
        return z2;
    }

    public void a(boolean z2) {
        try {
            this.f9151c.put("isOneFlow", z2);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.verbose("Can't set isOneFlow = " + z2 + ". Error: " + e.getMessage());
        }
    }

    public void a(TimerTask timerTask) {
        synchronized (this.l) {
            p();
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(timerTask, this.f9153f);
        }
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void a(List<String> list, String str, int i2, String str2, String str3) {
        Iterator it = ((List) C2234aa.a((ArrayList) list, new ArrayList())).iterator();
        while (it.hasNext()) {
            String str4 = str;
            int i8 = i2;
            com.ironsource.mediationsdk.d.b().a(str3, str4, com.ironsource.mediationsdk.d.b().a((String) it.next(), str4, i8, str2, "", "", "", ""));
            str = str4;
            i2 = i8;
        }
    }
}
