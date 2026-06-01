package q0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13374b;

    public /* synthetic */ e(Object obj, int i2) {
        this.f13373a = i2;
        this.f13374b = obj;
    }

    @Override // p5.a
    public final Object get() {
        switch (this.f13373a) {
            case 0:
                return new e2.h((Context) ((e) this.f13374b).f13374b, new r4.c(6), new w1.f(5));
            default:
                return this.f13374b;
        }
    }
}
