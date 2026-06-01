package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class o implements x4.c, Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5651d;
    public final /* synthetic */ Object e;

    public /* synthetic */ o(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f5648a = obj;
        this.f5649b = obj2;
        this.f5650c = obj3;
        this.f5651d = obj4;
        this.e = obj5;
    }

    @Override // x4.c
    public Object apply(Object obj) {
        return ((InAppMessageStreamManager) this.f5648a).lambda$createFirebaseInAppMessageStream$14((String) this.f5649b, (k) this.f5650c, (n) this.f5651d, (j) this.e, (r2.o) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ((ConfigFetchHandler) this.f5648a).lambda$fetchIfCacheExpiredAndNotThrottled$2((Task) this.f5649b, (Task) this.f5650c, (Date) this.f5651d, (Map) this.e, task);
    }
}
