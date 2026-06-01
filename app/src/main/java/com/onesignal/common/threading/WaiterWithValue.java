package com.onesignal.common.threading;

import a.a;
import s6.l;
import s6.n;
import s6.o;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WaiterWithValue<TType> {
    private final l channel = a.a(-1, 6, null);

    public final Object waitForWake(c<? super TType> cVar) {
        return this.channel.m(cVar);
    }

    public final void wake(TType ttype) {
        Object objD = this.channel.d(ttype);
        if (objD instanceof n) {
            throw new Exception("WaiterWithValue.wait failed", o.a(objD));
        }
    }
}
