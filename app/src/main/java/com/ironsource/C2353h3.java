package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.h3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class C2353h3 extends P0 {
    public C2353h3(N0 n02, Gb gb) {
        super(n02, gb);
    }

    private boolean n() {
        return b().b() > 0;
    }

    private boolean p() {
        return b().d() >= 0;
    }

    public void l() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    public void m() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    public boolean o() {
        return b().a() == N0.a.MANUAL_WITH_LOAD_ON_SHOW;
    }

    public void q() {
        if (o() && d()) {
            IronLog.INTERNAL.verbose();
            a(b().c());
        }
    }

    public void r() {
        if (!n()) {
            IronLog.INTERNAL.verbose("banner reload interval is disabled");
        } else if (o() && p()) {
            IronLog.INTERNAL.verbose();
            a(b().d());
        }
    }
}
