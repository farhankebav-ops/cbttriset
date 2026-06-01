package com.google.firebase.crashlytics.internal;

import androidx.camera.camera2.interop.d;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import p0.k;
import v0.f;
import w0.i;
import x0.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Deferred.DeferredHandler, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5566d;

    public /* synthetic */ a(String str, String str2, long j, StaticSessionData staticSessionData) {
        this.f5564b = str;
        this.f5565c = str2;
        this.f5563a = j;
        this.f5566d = staticSessionData;
    }

    @Override // x0.b
    public Object execute() {
        f fVar = (f) this.f5564b;
        Iterable iterable = (Iterable) this.f5565c;
        k kVar = (k) this.f5566d;
        i iVar = (i) fVar.f17583c;
        iVar.getClass();
        if (iterable.iterator().hasNext()) {
            iVar.e(new d(12, iVar, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + i.k(iterable)));
        }
        iVar.e(new w0.f(fVar.g.getTime() + this.f5563a, kVar));
        return null;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy.lambda$prepareNativeSession$1((String) this.f5564b, (String) this.f5565c, this.f5563a, (StaticSessionData) this.f5566d, provider);
    }

    public /* synthetic */ a(f fVar, Iterable iterable, k kVar, long j) {
        this.f5564b = fVar;
        this.f5565c = iterable;
        this.f5566d = kVar;
        this.f5563a = j;
    }
}
