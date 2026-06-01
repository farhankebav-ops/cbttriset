package com.google.firebase.crashlytics.internal.common;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5571c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f5569a = i2;
        this.f5570b = obj;
        this.f5571c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f5569a) {
            case 0:
                ((CrashlyticsController) this.f5570b).lambda$openSession$1((String) this.f5571c);
                break;
            case 1:
                ((CrashlyticsCore) this.f5570b).lambda$setCustomKeys$6((Map) this.f5571c);
                break;
            case 2:
                ((CrashlyticsCore) this.f5570b).lambda$logFatalException$8((Throwable) this.f5571c);
                break;
            default:
                ((CrashlyticsCore) this.f5570b).lambda$setUserId$4((String) this.f5571c);
                break;
        }
    }
}
