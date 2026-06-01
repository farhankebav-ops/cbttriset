package com.google.firebase.inappmessaging.internal;

import androidx.work.WorkRequest;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.protobuf.ExtensionRegistryLite;
import i4.c1;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class GrpcClient {
    private final r2.p stub;

    public GrpcClient(r2.p pVar) {
        this.stub = pVar;
    }

    public r2.o fetchEligibleCampaigns(r2.l lVar) throws Throwable {
        r2.p pVar = this.stub;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        i4.e eVar = pVar.f13620a;
        i4.d dVar = pVar.f13621b;
        dVar.getClass();
        if (timeUnit == null) {
            i4.j jVar = i4.r.f11941d;
            throw new NullPointerException("units");
        }
        i4.r rVar = new i4.r(timeUnit.toNanos(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
        i4.c cVarB = i4.d.b(dVar);
        cVarB.f11830a = rVar;
        i4.d dVar2 = new i4.d(cVarB);
        r2.q.D(eVar, "channel");
        c1 c1Var = r2.q.f13622a;
        if (c1Var == null) {
            synchronized (r2.q.class) {
                try {
                    c1Var = r2.q.f13622a;
                    if (c1Var == null) {
                        String strD = c1.d("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns");
                        r2.l lVarF = r2.l.f();
                        ExtensionRegistryLite extensionRegistryLite = o4.c.f13193a;
                        c1 c1Var2 = new c1(strD, new o4.b(lVarF), new o4.b(r2.o.c()));
                        r2.q.f13622a = c1Var2;
                        c1Var = c1Var2;
                    }
                } finally {
                }
            }
        }
        Logger logger = p4.e.f13333a;
        p4.c cVar = new p4.c();
        i4.c cVarB2 = i4.d.b(dVar2.c(p4.e.f13335c, p4.b.f13325a));
        cVarB2.f11831b = cVar;
        i4.f fVarF = eVar.f(c1Var, new i4.d(cVarB2));
        boolean z2 = false;
        try {
            try {
                p4.a aVarB = p4.e.b(fVarF, lVar);
                while (!aVarB.isDone()) {
                    try {
                        cVar.a();
                    } catch (InterruptedException e) {
                        try {
                            fVarF.a("Thread interrupted", e);
                            z2 = true;
                        } catch (Error e4) {
                            e = e4;
                            p4.e.a(fVarF, e);
                            throw null;
                        } catch (RuntimeException e8) {
                            e = e8;
                            p4.e.a(fVarF, e);
                            throw null;
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                cVar.shutdown();
                Object objC = p4.e.c(aVarB);
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                return (r2.o) objC;
            } catch (Error e9) {
                e = e9;
            } catch (RuntimeException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
