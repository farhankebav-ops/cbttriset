package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f5606b;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController, int i2) {
        this.f5605a = i2;
        this.f5606b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5605a) {
            case 0:
                return this.f5606b.lambda$getHeartBeatsHeader$1();
            default:
                return this.f5606b.lambda$registerHeartBeat$0();
        }
    }
}
