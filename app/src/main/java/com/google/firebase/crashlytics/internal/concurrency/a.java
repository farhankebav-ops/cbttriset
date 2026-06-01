package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f5586b;

    public /* synthetic */ a(Callable callable, int i2) {
        this.f5585a = i2;
        this.f5586b = callable;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        switch (this.f5585a) {
            case 0:
                return CrashlyticsWorker.lambda$submit$0(this.f5586b, task);
            case 1:
                return CrashlyticsWorker.lambda$submitTask$2(this.f5586b, task);
            case 2:
                return CrashlyticsWorker.lambda$submitTask$3(this.f5586b, task);
            default:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$4(this.f5586b, task);
        }
    }
}
