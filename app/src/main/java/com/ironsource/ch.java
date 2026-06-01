package com.ironsource;

import android.view.View;
import com.ironsource.Qf;
import com.ironsource.X2;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ch implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8164b;

    public /* synthetic */ ch(Object obj, int i2) {
        this.f8163a = i2;
        this.f8164b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8163a) {
            case 0:
                Ae.a((InterfaceC2541re) this.f8164b);
                break;
            case 1:
                Ae.a((IronSourceError) this.f8164b);
                break;
            case 2:
                Ae.b((Me) this.f8164b);
                break;
            case 3:
                Na.a((Na) this.f8164b);
                break;
            case 4:
                P9.a((InitListener) this.f8164b);
                break;
            case 5:
                Qf.e((Qf) this.f8164b);
                break;
            case 6:
                Qf.a((V8) this.f8164b);
                break;
            case 7:
                Qf.b.a((Qf.b) this.f8164b);
                break;
            case 8:
                X2.a.a((View) this.f8164b);
                break;
            case 9:
                C2308ec.a((C2308ec) this.f8164b);
                break;
            case 10:
                AbstractC2477o0.e((AbstractC2477o0) this.f8164b);
                break;
            case 11:
                C2567t6.h((C2567t6) this.f8164b);
                break;
            default:
                C2677ze.b((C2592ue) this.f8164b);
                break;
        }
    }
}
