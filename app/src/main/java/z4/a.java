package z4;

import java.util.concurrent.Callable;
import x4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Callable, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17980a;

    public a(Object obj) {
        this.f17980a = obj;
    }

    @Override // x4.c
    public final Object apply(Object obj) {
        return this.f17980a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f17980a;
    }
}
