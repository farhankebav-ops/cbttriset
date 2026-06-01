package r5;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends e implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13630c;

    public d(e eVar, int i2, int i8) {
        this.f13628a = eVar;
        this.f13629b = i2;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.d(i2, i8, size);
        this.f13630c = i8 - i2;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        e.Companion.getClass();
        b.b(i2, this.f13630c);
        return this.f13628a.get(this.f13629b + i2);
    }

    @Override // r5.a
    public final int getSize() {
        return this.f13630c;
    }

    @Override // r5.e, java.util.List
    public final List subList(int i2, int i8) {
        e.Companion.getClass();
        b.d(i2, i8, this.f13630c);
        int i9 = this.f13629b;
        return new d(this.f13628a, i2 + i9, i9 + i8);
    }
}
