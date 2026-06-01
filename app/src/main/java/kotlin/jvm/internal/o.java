package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class o extends q implements l6.j {
    @Override // kotlin.jvm.internal.c
    public l6.b computeReflected() {
        b0.f12719a.getClass();
        return this;
    }

    @Override // l6.o
    public Object getDelegate(Object obj) {
        return ((l6.j) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ l6.k getGetter() {
        mo3448getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ l6.f getSetter() {
        mo3449getSetter();
        return null;
    }

    @Override // e6.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // l6.o
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public l6.n mo3448getGetter() {
        ((l6.j) getReflected()).mo3448getGetter();
        return null;
    }

    @Override // l6.j
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public l6.i mo3449getSetter() {
        ((l6.j) getReflected()).mo3449getSetter();
        return null;
    }
}
