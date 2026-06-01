package com.google.firebase.crashlytics.internal.common;

import com.ironsource.C2271cb;
import com.unity3d.mediation.LevelPlayAdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5583d;

    public /* synthetic */ g(Object obj, long j, Object obj2, int i2) {
        this.f5580a = i2;
        this.f5581b = obj;
        this.f5582c = j;
        this.f5583d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5580a) {
            case 0:
                ((CrashlyticsCore) this.f5581b).lambda$log$2(this.f5582c, (String) this.f5583d);
                break;
            case 1:
                ((CrashlyticsCore) this.f5581b).lambda$log$3(this.f5582c, (String) this.f5583d);
                break;
            default:
                C2271cb.a((C2271cb) this.f5581b, this.f5582c, (LevelPlayAdError) this.f5583d);
                break;
        }
    }
}
