package com.google.firebase.sessions;

import com.google.firebase.sessions.InstallationId;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@x5.e(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", l = {31, 39}, m = "create")
public final class InstallationId$Companion$create$1 extends x5.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstallationId.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallationId$Companion$create$1(InstallationId.Companion companion, v5.c<? super InstallationId$Companion$create$1> cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, this);
    }
}
