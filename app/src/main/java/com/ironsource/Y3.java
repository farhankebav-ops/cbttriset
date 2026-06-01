package com.ironsource;

import android.content.Context;
import com.ironsource.C2300e4;
import com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Y3 implements InterfaceC2619w7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2602v7 f7823a;

    public Y3(JSONObject jSONObject, Context context) {
        InterfaceC2602v7 interfaceC2602v7A = a(jSONObject, context);
        this.f7823a = interfaceC2602v7A;
        Logger.i("Y3", "created ConnectivityAdapter with strategy ".concat(interfaceC2602v7A.getClass().getSimpleName()));
    }

    @Override // com.ironsource.InterfaceC2619w7
    public void a() {
    }

    @Override // com.ironsource.InterfaceC2619w7
    public void b(String str, JSONObject jSONObject) {
    }

    public void c(Context context) {
        this.f7823a.a(context);
    }

    @Override // com.ironsource.InterfaceC2619w7
    public void a(String str, JSONObject jSONObject) {
    }

    public void b(Context context) {
        this.f7823a.b(context);
    }

    public JSONObject a(Context context) {
        return this.f7823a.c(context);
    }

    public void b() {
        this.f7823a.a();
    }

    private InterfaceC2602v7 a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(C2300e4.i.g0) == 1) {
            return new BroadcastReceiverStrategy(this);
        }
        if (!C1.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return new BroadcastReceiverStrategy(this);
        }
        return new C2397jc(this);
    }
}
