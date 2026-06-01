package com.ironsource;

import android.content.Context;
import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2354h4 f7100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Z4 f7101d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C2390j5 f7102f;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f7103i = "Lg";
    private a j;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        NOT_RECOVERED,
        RECOVERED,
        IN_RECOVERING,
        NOT_ALLOWED
    }

    public Lg(Context context, C2354h4 c2354h4, Z4 z42, int i2, C2390j5 c2390j5, String str) {
        a aVarH = h();
        this.j = aVarH;
        if (aVarH != a.NOT_ALLOWED) {
            this.f7099b = context;
            this.f7100c = c2354h4;
            this.f7101d = z42;
            this.e = i2;
            this.f7102f = c2390j5;
            this.g = 0;
        }
        this.f7098a = str;
    }

    private a h() {
        this.h = FeaturesManager.getInstance().getInitRecoverTrials();
        Logger.i(this.f7103i, "getInitialState mMaxAllowedTrials: " + this.h);
        if (this.h > 0) {
            return a.NOT_RECOVERED;
        }
        Logger.i(this.f7103i, "recovery is not allowed by config");
        return a.NOT_ALLOWED;
    }

    private void j() {
        if (this.g != this.h) {
            this.j = a.NOT_RECOVERED;
            return;
        }
        Logger.i(this.f7103i, "handleRecoveringEndedFailed | Reached max trials");
        this.j = a.NOT_ALLOWED;
        a();
    }

    private void k() {
        a();
        this.j = a.RECOVERED;
    }

    public boolean a(C2569t8.c cVar, C2569t8.b bVar) {
        Logger.i(this.f7103i, "shouldRecoverWebController: ");
        a aVar = this.j;
        if (aVar == a.NOT_ALLOWED) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | recover is not allowed");
            return false;
        }
        if (cVar != C2569t8.c.Native) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | current controller type is: " + cVar);
            return false;
        }
        if (bVar == C2569t8.b.Loading || bVar == C2569t8.b.None) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | a Controller is currently loading");
            return false;
        }
        if (aVar == a.RECOVERED) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | already recovered");
            return false;
        }
        if (aVar == a.IN_RECOVERING) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | currently in recovering");
            return false;
        }
        if (this.f7099b == null || this.f7100c == null || this.f7101d == null) {
            Logger.i(this.f7103i, "shouldRecoverWebController: false | missing mandatory param");
            return false;
        }
        Logger.i(this.f7103i, "shouldRecoverWebController: true | allow recovering ");
        return true;
    }

    public Context b() {
        return this.f7099b;
    }

    public String c() {
        return this.f7098a;
    }

    public C2354h4 d() {
        return this.f7100c;
    }

    public int e() {
        return this.e;
    }

    public Z4 f() {
        return this.f7101d;
    }

    public C2390j5 g() {
        return this.f7102f;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C2300e4.h.A0, m());
            jSONObject.put(C2300e4.h.B0, this.g);
            jSONObject.put(C2300e4.h.C0, this.h);
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }

    public boolean l() {
        return this.j == a.IN_RECOVERING;
    }

    public boolean m() {
        return this.j == a.RECOVERED;
    }

    public void n() {
        a aVar = this.j;
        a aVar2 = a.IN_RECOVERING;
        if (aVar != aVar2) {
            this.g++;
            Logger.i(this.f7103i, "recoveringStarted - trial number " + this.g);
            this.j = aVar2;
        }
    }

    public void a() {
        this.f7099b = null;
        this.f7100c = null;
        this.f7101d = null;
        this.f7102f = null;
    }

    public void a(boolean z2) {
        if (this.j != a.IN_RECOVERING) {
            return;
        }
        if (z2) {
            k();
        } else {
            j();
        }
    }
}
