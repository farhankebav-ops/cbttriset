package com.ironsource;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class dj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8259d;
    public final /* synthetic */ Object e;

    public /* synthetic */ dj(Object obj, Object obj2, int i2, Object obj3, int i8) {
        this.f8256a = i8;
        this.f8258c = obj;
        this.f8259d = obj2;
        this.f8257b = i2;
        this.e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8256a) {
            case 0:
                AbstractC2662z.a((AbstractC2662z) this.f8258c, (AdapterErrorType) this.f8259d, this.f8257b, (String) this.e);
                return;
            default:
                final v0.f fVar = (v0.f) this.f8258c;
                final p0.k kVar = (p0.k) this.f8259d;
                final int i2 = this.f8257b;
                Runnable runnable = (Runnable) this.e;
                x0.c cVar = fVar.f17585f;
                try {
                    try {
                        w0.d dVar = fVar.f17583c;
                        Objects.requireNonNull(dVar);
                        ((w0.i) cVar).j(new j7.a(dVar, 8));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) fVar.f17581a.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((w0.i) cVar).j(new x0.b() { // from class: v0.e
                                @Override // x0.b
                                public final Object execute() {
                                    fVar.f17584d.l(kVar, i2 + 1, false);
                                    return null;
                                }
                            });
                        } else {
                            fVar.a(kVar, i2);
                        }
                        break;
                    } catch (x0.a unused) {
                        fVar.f17584d.l(kVar, i2 + 1, false);
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
        }
    }
}
