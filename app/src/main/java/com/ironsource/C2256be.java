package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: renamed from: com.ironsource.be, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2256be extends AbstractC2581u3 {
    private static C2256be Q;
    private String O;
    private final P8 P = Mb.U().s();

    private C2256be() {
        this.H = "outcome";
        this.G = 3;
        this.I = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.O = "";
    }

    public static synchronized C2256be i() {
        try {
            if (Q == null) {
                C2256be c2256be = new C2256be();
                Q = c2256be;
                c2256be.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return Q;
    }

    @Override // com.ironsource.AbstractC2581u3
    public int c(C5 c52) {
        return this.P.a(IronSource.a.REWARDED_VIDEO);
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean d(C5 c52) {
        int iC = c52.c();
        return iC == D5.FIRST_INSTANCE.b() || iC == D5.INIT_COMPLETE.b() || iC == D5.SDK_INIT_FAILED.b() || iC == D5.SDK_INIT_SUCCESS.b() || iC == D5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS.b() || iC == D5.RV_BUSINESS_INSTANCE_OPENED.b() || iC == D5.RV_INSTANCE_CLOSED.b() || iC == D5.RV_BUSINESS_INSTANCE_REWARDED.b() || iC == D5.RV_AUCTION_FAILED.b() || iC == D5.RV_AUCTION_SUCCESS.b();
    }

    @Override // com.ironsource.AbstractC2581u3
    public String e(int i2) {
        return (i2 == 15 || (i2 >= 300 && i2 < 400)) ? this.O : "";
    }

    @Override // com.ironsource.AbstractC2581u3
    public void f(C5 c52) {
        if (c52.c() == 15 || (c52.c() >= 300 && c52.c() < 400)) {
            this.O = c52.b().optString("placement");
        }
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean j(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void d() {
        com.google.android.gms.ads.internal.client.a.o(D5.RV_BUSINESS_MEDIATION_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_BUSINESS_INSTANCE_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_LOAD_FAILED, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_SHOW_CHANCE, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_READY_TRUE, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_READY_FALSE, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_LOAD_FAILED_REASON, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_INSTANCE_LOAD_NO_FILL, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.RV_MEDIATION_LOAD_ERROR, this.J);
    }
}
