package com.ironsource;

import com.ironsource.mediationsdk.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ah implements O2, r.b, C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8020b;

    public /* synthetic */ ah(Object obj, int i2) {
        this.f8019a = i2;
        this.f8020b = obj;
    }

    @Override // com.ironsource.O2
    public M2 a(boolean z2) {
        switch (this.f8019a) {
            case 0:
                return Aa.a((Aa) this.f8020b, z2);
            default:
                return C2614w2.a((C2614w2) this.f8020b, z2);
        }
    }

    @Override // com.ironsource.C
    public AbstractC2662z a(A a8, G g) {
        switch (this.f8019a) {
            case 2:
                return M2.a((M2) this.f8020b, a8, g);
            case 3:
                return C2326fc.a((C2326fc) this.f8020b, a8, g);
            default:
                return C2567t6.a((C2567t6) this.f8020b, a8, g);
        }
    }

    @Override // com.ironsource.mediationsdk.r.b
    public void a(String str) {
        Ke.a((kotlin.jvm.internal.a0) this.f8020b, str);
    }
}
