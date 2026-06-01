package l7;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends r5.e implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m[] f12848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f12849b;

    public f0(m[] mVarArr, int[] iArr) {
        this.f12848a = mVarArr;
        this.f12849b = iArr;
    }

    @Override // r5.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof m) {
            return super.contains((m) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return this.f12848a[i2];
    }

    @Override // r5.a
    public final int getSize() {
        return this.f12848a.length;
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof m) {
            return super.indexOf((m) obj);
        }
        return -1;
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof m) {
            return super.lastIndexOf((m) obj);
        }
        return -1;
    }
}
