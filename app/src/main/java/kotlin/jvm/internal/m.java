package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m extends q implements l6.h {
    @Override // kotlin.jvm.internal.c
    public l6.b computeReflected() {
        b0.f12719a.getClass();
        return this;
    }

    @Override // l6.m
    public Object getDelegate() {
        return ((l6.h) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ l6.k getGetter() {
        mo3446getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ l6.f getSetter() {
        mo3447getSetter();
        return null;
    }

    @Override // e6.a
    public Object invoke() {
        return get();
    }

    @Override // l6.m
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public l6.l mo3446getGetter() {
        ((l6.h) getReflected()).mo3446getGetter();
        return null;
    }

    @Override // l6.h
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public l6.g mo3447getSetter() {
        ((l6.h) getReflected()).mo3447getSetter();
        return null;
    }
}
