package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class l implements Continuation, OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5696b;

    public /* synthetic */ l(Object obj, int i2) {
        this.f5695a = i2;
        this.f5696b = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f5695a) {
            case 1:
                WakeLockHolder.completeWakefulIntent((Intent) this.f5696b);
                break;
            case 2:
                ((WithinAppServiceConnection.BindRequest) this.f5696b).finish();
                break;
            default:
                ((ScheduledFuture) this.f5696b).cancel(false);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ((GmsRpc) this.f5696b).lambda$extractResponseWhenComplete$0(task);
    }
}
