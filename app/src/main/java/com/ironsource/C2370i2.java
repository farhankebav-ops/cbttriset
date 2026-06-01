package com.ironsource;

import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.i2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2370i2 extends e.a {
    public C2370i2(S1 s12, URL url, JSONObject jSONObject, boolean z2, C2496p2 c2496p2) {
        super(s12, url, jSONObject, z2, c2496p2);
    }

    @Override // com.ironsource.mediationsdk.e.a
    public void a(boolean z2, S1 s12, long j) {
        try {
            if (z2) {
                ((InterfaceC2244b2) s12).a(this.f9170b, this.f9173f + 1, j, this.j, this.f9174i);
            } else {
                s12.a(this.f9171c, this.f9172d, this.f9173f + 1, this.g, j);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            s12.a(1009, e.getMessage(), this.f9173f + 1, this.g, j);
        }
    }
}
