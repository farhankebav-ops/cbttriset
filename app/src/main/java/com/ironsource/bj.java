package com.ironsource;

import android.content.Context;
import com.ironsource.C2677ze;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class bj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8097c;

    public /* synthetic */ bj(int i2, Object obj, Object obj2) {
        this.f8095a = i2;
        this.f8096b = obj;
        this.f8097c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8095a) {
            case 0:
                C2655y9.a((IronSourceError) this.f8096b, (C2655y9) this.f8097c);
                break;
            case 1:
                AbstractC2662z.a((AbstractC2662z) this.f8096b, (Map) this.f8097c);
                break;
            default:
                C2677ze.b.a((Context) this.f8096b, (C2435le) this.f8097c);
                break;
        }
    }
}
