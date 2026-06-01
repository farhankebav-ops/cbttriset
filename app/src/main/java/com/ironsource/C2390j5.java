package com.ironsource;

import android.os.Handler;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.j5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2390j5 implements C7 {
    private static final int e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static C2390j5 f8770f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerC2373i5 f8771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f8772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f8773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8774d;

    private C2390j5(String str, V7 v7, JSONObject jSONObject) {
        this.f8774d = str;
        this.f8771a = new HandlerC2373i5(v7.a());
        this.f8772b = jSONObject;
        IronSourceStorageUtils.deleteFolder(b());
        IronSourceStorageUtils.makeDir(b());
    }

    public static synchronized C2390j5 a(String str, V7 v7, JSONObject jSONObject) {
        try {
            if (f8770f == null) {
                f8770f = new C2390j5(str, v7, jSONObject);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8770f;
    }

    private Thread b(C8 c8, String str, int i2, int i8, Handler handler) {
        if (i2 <= 0) {
            i2 = this.f8772b.optInt("connectionTimeout", 5);
        }
        if (i8 <= 0) {
            i8 = this.f8772b.optInt("readTimeout", 5);
        }
        boolean zOptBoolean = this.f8772b.optBoolean(C2336g4.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a(new C2337g5(c8, str, (int) timeUnit.toMillis(i2), (int) timeUnit.toMillis(i8), zOptBoolean, b()), handler);
    }

    public boolean c() {
        Thread thread = this.f8773c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f8770f = null;
        HandlerC2373i5 handlerC2373i5 = this.f8771a;
        if (handlerC2373i5 != null) {
            handlerC2373i5.a();
            this.f8771a = null;
        }
    }

    @Override // com.ironsource.C7
    public void a(Pc pc) {
        this.f8771a.a(pc);
    }

    private Thread a(C2337g5 c2337g5, Handler handler) {
        return new Thread(new RunnableC2526qf(c2337g5, handler));
    }

    @Override // com.ironsource.C7
    public void a(C8 c8, String str, int i2, int i8, Handler handler) {
        b(c8, str, i2, i8, handler).start();
    }

    private String b() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.f8774d, C2336g4.D);
    }

    @Override // com.ironsource.C7
    public void a(C8 c8, String str, int i2, int i8) {
        b(c8, str, i2, i8, this.f8771a).start();
    }

    @Override // com.ironsource.C7
    public void a(C8 c8, String str) {
        int iOptInt = this.f8772b.optInt("connectionTimeout", 5);
        int iOptInt2 = this.f8772b.optInt("readTimeout", 5);
        boolean zOptBoolean = this.f8772b.optBoolean(C2336g4.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Thread threadA = a(new C2337g5(c8, str, (int) timeUnit.toMillis(iOptInt), (int) timeUnit.toMillis(iOptInt2), zOptBoolean, b()), this.f8771a);
        this.f8773c = threadA;
        threadA.start();
    }

    public String a() {
        return this.f8774d;
    }
}
