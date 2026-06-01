package com.google.firebase.sessions.settings;

import e6.p;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
public final class SettingsCacheImpl$removeConfigs$2 extends i implements p {
    int label;

    public SettingsCacheImpl$removeConfigs$2(c<? super SettingsCacheImpl$removeConfigs$2> cVar) {
        super(2, cVar);
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new SettingsCacheImpl$removeConfigs$2(cVar);
    }

    @Override // e6.p
    public final Object invoke(SessionConfigs sessionConfigs, c<? super SessionConfigs> cVar) {
        return ((SettingsCacheImpl$removeConfigs$2) create(sessionConfigs, cVar)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        return SessionConfigsSerializer.INSTANCE.getDefaultValue();
    }
}
