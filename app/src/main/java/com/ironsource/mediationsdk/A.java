package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.C2243b1;
import com.ironsource.C2531r4;
import com.ironsource.C2627wf;
import com.ironsource.O8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class A implements O8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f8973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected C2243b1 f8974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected JSONObject f8976d;
    protected String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f8977f;
    protected Long g = null;

    public A(C2243b1 c2243b1, AbstractAdapter abstractAdapter) {
        this.f8974b = c2243b1;
        this.f8973a = abstractAdapter;
        this.f8976d = c2243b1.c();
    }

    public void a(boolean z2) {
        this.f8975c = z2;
    }

    @Override // com.ironsource.O8.b
    public int b() {
        return this.f8974b.e();
    }

    @Override // com.ironsource.O8.b
    public String c() {
        return this.f8974b.f();
    }

    public abstract IronSource.a d();

    public Long e() {
        return this.g;
    }

    public String f() {
        return i() + " " + hashCode();
    }

    public int g() {
        return this.f8974b.d();
    }

    public boolean h() {
        return this.f8975c;
    }

    public String i() {
        return this.f8974b.h().isMultipleInstances() ? this.f8974b.h().getProviderTypeForReflection() : this.f8974b.h().getProviderName();
    }

    public String j() {
        return this.f8974b.g();
    }

    public abstract String k();

    public int l() {
        return 1;
    }

    public Map<String, Object> m() {
        HashMap map = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.f8973a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f8973a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            map.put("spId", this.f8974b.i());
            map.put(IronSourceConstants.EVENTS_PROVIDER, this.f8974b.a());
            map.put("instanceType", Integer.valueOf(p() ? 2 : 1));
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(l()));
            if (!TextUtils.isEmpty(this.e)) {
                map.put("dynamicDemandSource", this.e);
            }
            return map;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + c() + ")", th);
            return map;
        }
    }

    public int n() {
        return this.f8977f;
    }

    public boolean o() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !this.f8973a.isUsingActivityBeforeImpression(C2627wf.a(d()))) {
                return false;
            }
            ironLog.verbose(c() + " - is using activity before impression and activity is null");
            return true;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("Exception while calling adapter.isUsingActivityBeforeImpression() - " + th.getLocalizedMessage());
            return true;
        }
    }

    public boolean p() {
        return this.f8974b.j();
    }

    public void q() {
        this.f8973a = null;
    }

    public boolean r() {
        if (o()) {
            return false;
        }
        return p() || s();
    }

    public boolean s() {
        return this.f8974b.k();
    }

    public void a(String str) {
        a(str, 0);
    }

    public void b(String str) {
        a(str, 3);
    }

    public void c(String str) {
        this.e = d.b().c(str);
    }

    private void a(String str, int i2) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, k() + " " + c() + " : " + str, i2);
    }
}
