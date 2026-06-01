package com.google.firebase.sessions.settings;

import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import e6.p;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@e(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {126}, m = "invokeSuspend")
public final class RemoteSettings$updateSettings$2$1 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, c<? super RemoteSettings$updateSettings$2$1> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettings;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, cVar);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Boolean bool;
        Double d8;
        Integer num;
        Integer num2;
        Double d9;
        Boolean bool2;
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            JSONObject jSONObject = (JSONObject) this.L$0;
            Log.d(FirebaseSessions.TAG, "Fetched settings: " + jSONObject);
            Integer num3 = null;
            if (jSONObject.has("app_quality")) {
                Object obj2 = jSONObject.get("app_quality");
                k.c(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj2;
                try {
                    bool2 = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                    try {
                        d9 = jSONObject2.has("sampling_rate") ? (Double) jSONObject2.get("sampling_rate") : null;
                        try {
                            num2 = jSONObject2.has("session_timeout_seconds") ? (Integer) jSONObject2.get("session_timeout_seconds") : null;
                        } catch (JSONException e) {
                            e = e;
                            num2 = null;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        num2 = null;
                        d9 = null;
                    }
                } catch (JSONException e8) {
                    e = e8;
                    num2 = null;
                    d9 = null;
                    bool2 = null;
                }
                try {
                    if (jSONObject2.has("cache_duration")) {
                        num3 = (Integer) jSONObject2.get("cache_duration");
                    }
                } catch (JSONException e9) {
                    e = e9;
                    new Integer(Log.e(FirebaseSessions.TAG, "Error parsing the configs remotely fetched: ", e));
                }
                num = num2;
                d8 = d9;
                bool = bool2;
            } else {
                bool = null;
                d8 = null;
                num = null;
            }
            SettingsCache settingsCache = this.this$0.settingsCache;
            SessionConfigs sessionConfigs = new SessionConfigs(bool, d8, num, new Integer(num3 != null ? num3.intValue() : RemoteSettings.Companion.getDefaultCacheDuration()), new Long(this.this$0.timeProvider.currentTime().getSeconds()));
            this.label = 1;
            if (settingsCache.updateConfigs(sessionConfigs, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(JSONObject jSONObject, c<? super x> cVar) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, cVar)).invokeSuspend(x.f13520a);
    }
}
