package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5705b;

    public /* synthetic */ p(Object obj, int i2) {
        this.f5704a = i2;
        this.f5705b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5704a) {
            case 0:
                ((SharedPreferencesQueue) this.f5705b).syncState();
                break;
            default:
                ((WithinAppServiceConnection.BindRequest) this.f5705b).lambda$arrangeTimeout$0();
                break;
        }
    }
}
