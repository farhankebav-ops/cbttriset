package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11760c;

    public h(com.unity3d.scar.adapter.common.a aVar, boolean z2) {
        super(aVar);
        this.f11760c = z2;
    }

    @Override // h7.g
    public final void h(String value) {
        kotlin.jvm.internal.k.e(value, "value");
        if (this.f11760c) {
            super.h(value);
        } else {
            f(value);
        }
    }
}
