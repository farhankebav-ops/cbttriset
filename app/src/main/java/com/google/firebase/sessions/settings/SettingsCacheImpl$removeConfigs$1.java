package com.google.firebase.sessions.settings;

import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl", f = "SettingsCache.kt", l = {107}, m = "removeConfigs$com_google_firebase_firebase_sessions")
public final class SettingsCacheImpl$removeConfigs$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$removeConfigs$1(SettingsCacheImpl settingsCacheImpl, v5.c<? super SettingsCacheImpl$removeConfigs$1> cVar) {
        super(cVar);
        this.this$0 = settingsCacheImpl;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
