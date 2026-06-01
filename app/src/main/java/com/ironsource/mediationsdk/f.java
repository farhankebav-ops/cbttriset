package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.C2370i2;
import com.ironsource.C2496p2;
import com.ironsource.S1;
import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2496p2 f9179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9180b;

    public f(C2496p2 settings, String sessionId) {
        kotlin.jvm.internal.k.e(settings, "settings");
        kotlin.jvm.internal.k.e(sessionId, "sessionId");
        this.f9179a = settings;
        this.f9180b = sessionId;
    }

    @Override // com.ironsource.mediationsdk.g
    public e.a a(Context context, i auctionRequestParams, S1 auctionListener) throws JSONException {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(auctionRequestParams, "auctionRequestParams");
        kotlin.jvm.internal.k.e(auctionListener, "auctionListener");
        JSONObject jSONObjectA = a(context, auctionRequestParams);
        String strA = this.f9179a.a(auctionRequestParams.s());
        return auctionRequestParams.s() ? new C2370i2(auctionListener, new URL(strA), jSONObjectA, auctionRequestParams.t(), this.f9179a) : new e.a(auctionListener, new URL(strA), jSONObjectA, auctionRequestParams.t(), this.f9179a);
    }

    @Override // com.ironsource.mediationsdk.g
    public boolean b() {
        return this.f9179a.g() > 0;
    }

    @Override // com.ironsource.mediationsdk.g
    public boolean a() {
        return this.f9179a.n();
    }

    private final JSONObject a(Context context, i iVar) throws JSONException {
        JSONObject jSONObjectA = d.b().a(iVar);
        kotlin.jvm.internal.k.d(jSONObjectA, "getInstance().enrichToke…low(auctionRequestParams)");
        return jSONObjectA;
    }
}
