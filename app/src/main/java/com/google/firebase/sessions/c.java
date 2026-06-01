package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.FirebaseSessionsComponent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5736b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f5735a = i2;
        this.f5736b = obj;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f5735a) {
            case 0:
                return FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore$lambda$2((Context) this.f5736b);
            case 1:
                return FirebaseSessionsComponent.MainModule.Companion.sessionDataStore$lambda$5((Context) this.f5736b);
            default:
                return ProcessDataManagerImpl.myUuid_delegate$lambda$1((UuidGenerator) this.f5736b);
        }
    }
}
