package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5680c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f5678a = i2;
        this.f5679b = obj;
        this.f5680c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5678a) {
            case 0:
                ((FcmLifecycleCallbacks) this.f5679b).lambda$onActivityCreated$0((Intent) this.f5680c);
                break;
            default:
                ((ImageDownload) this.f5679b).lambda$start$0((TaskCompletionSource) this.f5680c);
                break;
        }
    }
}
