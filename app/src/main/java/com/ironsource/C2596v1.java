package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: renamed from: com.ironsource.v1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2596v1 extends AbstractC2581u3 {
    public C2596v1() {
        this.H = "outcome";
        this.G = 4;
        this.I = IronSourceConstants.APP_EVENT_TYPE;
        e();
    }

    @Override // com.ironsource.AbstractC2581u3
    public int c(C5 c52) {
        return 1;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void d() {
    }

    @Override // com.ironsource.AbstractC2581u3
    public String e(int i2) {
        return "";
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean h(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean j(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean d(C5 event) {
        kotlin.jvm.internal.k.e(event, "event");
        int iC = event.c();
        return iC == D5.FIRST_INSTANCE.b() || iC == D5.INIT_COMPLETE.b() || iC == D5.SDK_INIT_FAILED.b() || iC == D5.SDK_INIT_SUCCESS.b();
    }

    @Override // com.ironsource.AbstractC2581u3
    public void f(C5 c52) {
    }
}
