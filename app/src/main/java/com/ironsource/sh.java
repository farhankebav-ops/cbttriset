package com.ironsource;

import android.app.Activity;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class sh implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ub f10231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10232c;

    public /* synthetic */ sh(Ub ub, Object obj, int i2) {
        this.f10230a = i2;
        this.f10231b = ub;
        this.f10232c = obj;
    }

    @Override // com.ironsource.sdk.controller.l.a
    public final void a(f.a aVar) {
        switch (this.f10230a) {
            case 0:
                Ub.a(this.f10231b, (Activity) this.f10232c, aVar);
                break;
            default:
                Ub.a(this.f10231b, (G8) this.f10232c, aVar);
                break;
        }
    }
}
