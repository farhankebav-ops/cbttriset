package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.d1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c1<a1> f10837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d1 f10838b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final z0 f10839a = new z0();
    }

    public static z0 a() {
        return b.f10839a;
    }

    public d1 b() {
        if (this.f10838b == null) {
            synchronized (z0.class) {
                try {
                    if (this.f10838b == null) {
                        this.f10838b = a("ssdk_net_handler");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10838b;
    }

    public d1 c() {
        if (this.f10838b == null) {
            synchronized (z0.class) {
                try {
                    if (this.f10838b == null) {
                        this.f10838b = a("ssdk_handler");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10838b;
    }

    private z0() {
        this.f10837a = c1.a(2);
    }

    public d1 a(String str) {
        return b(null, str);
    }

    private a1 a(d1.a aVar, String str) {
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new a1(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public d1 b(d1.a aVar, String str) {
        a1 a1Var = (a1) this.f10837a.a();
        if (a1Var != null) {
            a1Var.a(aVar);
            a1Var.a(str);
            return a1Var;
        }
        return a(aVar, str);
    }
}
