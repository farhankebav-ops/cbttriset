package com.ironsource;

import com.ironsource.AbstractC2581u3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class H9 extends AbstractC2581u3 {
    private static H9 Q;
    private String O;
    private final P8 P = Mb.U().s();

    private H9() {
        this.H = "ironbeast";
        this.G = 2;
        this.I = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.O = "";
    }

    public static synchronized H9 i() {
        try {
            if (Q == null) {
                H9 h9 = new H9();
                Q = h9;
                h9.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return Q;
    }

    @Override // com.ironsource.AbstractC2581u3
    public int c(C5 c52) {
        int iF = f(c52.c());
        return iF == AbstractC2581u3.e.BANNER.b() ? this.P.a(IronSource.a.BANNER) : iF == AbstractC2581u3.e.NATIVE_AD.b() ? this.P.a(IronSource.a.NATIVE_AD) : this.P.a(IronSource.a.INTERSTITIAL);
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean d(C5 c52) {
        int iC = c52.c();
        return iC == D5.IS_CALLBACK_LOAD_SUCCESS.b() || iC == D5.IS_INSTANCE_OPENED.b() || iC == D5.IS_INSTANCE_CLOSED.b() || iC == D5.IS_AUCTION_SUCCESS.b() || iC == D5.IS_AUCTION_FAILED.b() || iC == D5.BN_INSTANCE_SHOW.b() || iC == D5.BN_AUCTION_SUCCESS.b() || iC == D5.BN_AUCTION_FAILED.b() || iC == D5.NT_INSTANCE_LOAD_SUCCESS.b() || iC == D5.NT_INSTANCE_SHOW.b() || iC == D5.NT_AUCTION_SUCCESS.b() || iC == D5.NT_AUCTION_FAILED.b();
    }

    @Override // com.ironsource.AbstractC2581u3
    public String e(int i2) {
        return this.O;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void f(C5 c52) {
        this.O = c52.b().optString("placement");
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean j(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void d() {
        com.google.android.gms.ads.internal.client.a.o(D5.IS_LOAD_CALLED, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_CALLBACK_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_LOAD_FAILED, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_LOAD_NO_FILL, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_READY_TRUE, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.IS_INSTANCE_READY_FALSE, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_CALLBACK_LOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_RELOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_CALLBACK_RELOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_CALLBACK_RELOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_RELOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_LOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_RELOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_RELOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.BN_INSTANCE_SHOW, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_CALLBACK_LOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_INSTANCE_LOAD, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_INSTANCE_LOAD_SUCCESS, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_INSTANCE_LOAD_ERROR, this.J);
        com.google.android.gms.ads.internal.client.a.o(D5.NT_INSTANCE_SHOW, this.J);
    }
}
