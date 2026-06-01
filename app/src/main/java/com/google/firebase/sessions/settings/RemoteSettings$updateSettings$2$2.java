package com.google.firebase.sessions.settings;

import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import e6.p;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@e(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
public final class RemoteSettings$updateSettings$2$2 extends i implements p {
    /* synthetic */ Object L$0;
    int label;

    public RemoteSettings$updateSettings$2$2(c<? super RemoteSettings$updateSettings$2$2> cVar) {
        super(2, cVar);
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(cVar);
        remoteSettings$updateSettings$2$2.L$0 = obj;
        return remoteSettings$updateSettings$2$2;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        Log.e(FirebaseSessions.TAG, "Error failed to fetch the remote configs: " + ((String) this.L$0));
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(String str, c<? super x> cVar) {
        return ((RemoteSettings$updateSettings$2$2) create(str, cVar)).invokeSuspend(x.f13520a);
    }
}
