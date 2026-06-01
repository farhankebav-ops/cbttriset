package com.ironsource.mediationsdk;

import com.ironsource.Bb;
import com.ironsource.C2270ca;
import com.ironsource.C2461n2;
import com.ironsource.InterfaceC2233a9;
import com.ironsource.Y8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<InterfaceC2233a9> f9229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.ironsource.r f9230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected C2270ca f9231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected AdInfo f9232d;

    public m(HashSet<InterfaceC2233a9> hashSet, C2270ca c2270ca) {
        new HashSet();
        this.f9229a = hashSet;
        this.f9230b = new com.ironsource.r();
        this.f9231c = c2270ca;
    }

    public void a(InterfaceC2233a9 interfaceC2233a9) {
        synchronized (this) {
            this.f9229a.add(interfaceC2233a9);
        }
    }

    public void b(InterfaceC2233a9 interfaceC2233a9) {
        synchronized (this) {
            this.f9229a.remove(interfaceC2233a9);
        }
    }

    public void c() {
        synchronized (this) {
            this.f9229a.clear();
        }
    }

    public String e() {
        return "fallback_" + System.currentTimeMillis();
    }

    public void f() {
        this.f9232d = null;
    }

    public void a(C2270ca c2270ca) {
        this.f9231c = c2270ca;
    }

    public void a(Y8 y8, Bb bb) {
        if (y8 != null) {
            this.f9232d = new AdInfo(y8, bb);
        }
    }

    public void a(C2461n2 c2461n2, String str) {
        HashSet<InterfaceC2233a9> hashSet;
        if (c2461n2 != null) {
            Y8 y8A = c2461n2.a(str);
            if (y8A != null) {
                synchronized (this) {
                    hashSet = (HashSet) this.f9229a.clone();
                }
                for (InterfaceC2233a9 interfaceC2233a9 : hashSet) {
                    IronLog.CALLBACK.info("onImpressionSuccess " + interfaceC2233a9.getClass().getSimpleName() + ": " + y8A);
                    interfaceC2233a9.a(y8A);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }

    public void a(JSONObject jSONObject, IronSource.a aVar) {
        this.f9230b.a(aVar, jSONObject != null ? jSONObject.optBoolean(d.f9037f, false) : false);
    }

    public void a(IronSource.a aVar) {
        this.f9230b.a(aVar, false);
    }
}
