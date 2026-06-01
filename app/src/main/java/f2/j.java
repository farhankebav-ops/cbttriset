package f2;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11334b;

    public j(Object obj) {
        this.f11333a = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f11334b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11334b) {
            throw new NoSuchElementException();
        }
        this.f11334b = true;
        return this.f11333a;
    }
}
