package n6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements m6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f13083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e6.p f13085c;

    public c(CharSequence input, int i2, e6.p pVar) {
        kotlin.jvm.internal.k.e(input, "input");
        this.f13083a = input;
        this.f13084b = i2;
        this.f13085c = pVar;
    }

    @Override // m6.h
    public final Iterator iterator() {
        return new b(this);
    }
}
