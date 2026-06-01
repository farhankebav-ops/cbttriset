package com.ironsource;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class rg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9772c;

    public rg(boolean z2, boolean z7, boolean z8) {
        this.f9770a = z2;
        this.f9771b = z7;
        this.f9772c = z8;
    }

    public final boolean a() {
        return this.f9770a;
    }

    public final boolean b() {
        return this.f9771b;
    }

    public final boolean c() {
        return this.f9772c;
    }

    public final boolean d() {
        return this.f9772c;
    }

    public final boolean e() {
        return this.f9770a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rg)) {
            return false;
        }
        rg rgVar = (rg) obj;
        return this.f9770a == rgVar.f9770a && this.f9771b == rgVar.f9771b && this.f9772c == rgVar.f9772c;
    }

    public final boolean f() {
        return this.f9771b;
    }

    public final JSONObject g() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(C2393j8.k, this.f9770a).put(C2393j8.l, this.f9771b).put(C2393j8.m, this.f9772c);
        kotlin.jvm.internal.k.d(jSONObjectPut, "JSONObject()\n        .pu…ts.IS_SHOWN_KEY, isShown)");
        return jSONObjectPut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.f9770a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = r02 * 31;
        boolean z7 = this.f9771b;
        ?? r22 = z7;
        if (z7) {
            r22 = 1;
        }
        int i8 = (i2 + r22) * 31;
        boolean z8 = this.f9772c;
        return i8 + (z8 ? 1 : z8);
    }

    public String toString() {
        boolean z2 = this.f9770a;
        boolean z7 = this.f9771b;
        boolean z8 = this.f9772c;
        StringBuilder sb = new StringBuilder("ViewVisibilityParams(isVisible=");
        sb.append(z2);
        sb.append(", isWindowVisible=");
        sb.append(z7);
        sb.append(", isShown=");
        return a1.a.u(sb, z8, ")");
    }

    public final rg a(boolean z2, boolean z7, boolean z8) {
        return new rg(z2, z7, z8);
    }

    public static /* synthetic */ rg a(rg rgVar, boolean z2, boolean z7, boolean z8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = rgVar.f9770a;
        }
        if ((i2 & 2) != 0) {
            z7 = rgVar.f9771b;
        }
        if ((i2 & 4) != 0) {
            z8 = rgVar.f9772c;
        }
        return rgVar.a(z2, z7, z8);
    }
}
