package com.ironsource;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class V9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    U6 f7737a = new U6();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnumC2558se f7738b;

        public a(EnumC2558se enumC2558se) {
            this.f7738b = enumC2558se;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            V9.this.f7737a.a(Q6.g0, new JSONArray().put(this.f7738b.b()));
        }
    }

    public void a(JSONObject jSONObject) {
        this.f7737a.a(Q6.f7470u, (Object) jSONObject);
    }

    public void b(JSONObject jSONObject) {
        this.f7737a.a(Q6.f7438e1, (Object) jSONObject);
    }

    public void c(String str) {
        this.f7737a.a(Q6.J0, str);
    }

    public void d(String str) {
        this.f7737a.a(Q6.L0, str);
    }

    public void e(String str) {
        this.f7737a.a(com.ironsource.mediationsdk.metadata.a.f9242i, str);
    }

    public void f(String str) {
        this.f7737a.a(Q6.Z0, str);
    }

    public void g(String str) {
        this.f7737a.a(Q6.A, str);
    }

    public void h(String str) {
        this.f7737a.a(Q6.f7434c1, str);
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7737a.a(Q6.f7437e0, str);
    }

    public void a(boolean z2) {
        this.f7737a.a(Q6.Q0, Boolean.valueOf(z2));
    }

    public void b(boolean z2) {
        this.f7737a.a("gpi", Boolean.valueOf(z2));
    }

    public void c(int i2) {
        this.f7737a.a(Q6.f0, Integer.valueOf(i2));
    }

    public void a(Context context) {
        this.f7737a.a(context);
    }

    public void b(int i2) {
        if (i2 >= 0) {
            this.f7737a.a(Q6.S0, Integer.valueOf(i2));
        }
    }

    public void a(Boolean bool) {
        this.f7737a.a(Q6.T0, bool);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7737a.a(Q6.C1, str);
    }

    public void a(EnumC2558se enumC2558se) {
        new Thread(new a(enumC2558se)).start();
    }

    public void b(Context context) {
        B7 b7I = Mb.U().i();
        ActivityManager.MemoryInfo memoryInfoN = b7I.n(context);
        this.f7737a.a(Q6.f7476w, b7I.c(memoryInfoN));
        this.f7737a.a(Q6.f7479x, b7I.b(memoryInfoN));
    }

    public void a(U7 u7) {
        try {
            HashMap map = new HashMap();
            map.put(Q6.E, u7.a());
            map.put(Q6.D, u7.b());
            map.put(Q6.V, u7.c());
            this.f7737a.a(map);
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7737a.a("abt", str);
    }

    public void a(int i2) {
        this.f7737a.a(Q6.i0, Integer.valueOf(i2));
    }
}
