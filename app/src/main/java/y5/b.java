package y5;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import r5.e;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends e implements a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f17851a;

    public b(Enum[] entries) {
        k.e(entries, "entries");
        this.f17851a = entries;
    }

    @Override // r5.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        return ((Enum) j.p0(r42.ordinal(), this.f17851a)) == r42;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        r5.b bVar = e.Companion;
        Enum[] enumArr = this.f17851a;
        int length = enumArr.length;
        bVar.getClass();
        r5.b.b(i2, length);
        return enumArr[i2];
    }

    @Override // r5.a
    public final int getSize() {
        return this.f17851a.length;
    }

    @Override // r5.e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        if (((Enum) j.p0(iOrdinal, this.f17851a)) == r42) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // r5.e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        if (((Enum) j.p0(iOrdinal, this.f17851a)) == r42) {
            return iOrdinal;
        }
        return -1;
    }
}
