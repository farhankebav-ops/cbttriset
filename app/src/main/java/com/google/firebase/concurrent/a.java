package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5533c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f5531a = i2;
        this.f5532b = obj;
        this.f5533c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5531a) {
            case 0:
                ((CustomThreadFactory) this.f5532b).lambda$newThread$0((Runnable) this.f5533c);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$3((Callable) this.f5532b, (DelegatingScheduledFuture.Completer) this.f5533c);
                break;
            default:
                ((LimitedConcurrencyExecutor) this.f5532b).lambda$decorate$0((Runnable) this.f5533c);
                break;
        }
    }
}
