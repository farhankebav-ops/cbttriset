package com.ironsource;

import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class uh implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ub f10415b;

    public /* synthetic */ uh(Ub ub, int i2) {
        this.f10414a = i2;
        this.f10415b = ub;
    }

    @Override // com.ironsource.sdk.controller.l.a
    public final void a(f.a aVar) {
        switch (this.f10414a) {
            case 0:
                Ub.a(this.f10415b, aVar);
                break;
            default:
                Ub.b(this.f10415b, aVar);
                break;
        }
    }
}
