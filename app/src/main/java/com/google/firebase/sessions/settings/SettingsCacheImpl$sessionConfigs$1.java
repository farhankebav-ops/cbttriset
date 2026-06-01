package com.google.firebase.sessions.settings;

import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$sessionConfigs$1", f = "SettingsCache.kt", l = {64}, m = "invokeSuspend")
public final class SettingsCacheImpl$sessionConfigs$1 extends i implements p {
    int label;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$sessionConfigs$1(SettingsCacheImpl settingsCacheImpl, c<? super SettingsCacheImpl$sessionConfigs$1> cVar) {
        super(2, cVar);
        this.this$0 = settingsCacheImpl;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new SettingsCacheImpl$sessionConfigs$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return obj;
        }
        q.z0(obj);
        t6.e data = this.this$0.sessionConfigsDataStore.getData();
        this.label = 1;
        Object objL = x0.l(data, this);
        return objL == aVar ? aVar : objL;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super SessionConfigs> cVar) {
        return ((SettingsCacheImpl$sessionConfigs$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
