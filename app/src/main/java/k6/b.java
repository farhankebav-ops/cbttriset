package k6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b implements Iterable, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12711c;

    public b(int i2, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12709a = i2;
        this.f12710b = z5.b.a(i2, i8, i9);
        this.f12711c = i9;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f12709a == bVar.f12709a && this.f12710b == bVar.f12710b && this.f12711c == bVar.f12711c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f12709a * 31) + this.f12710b) * 31) + this.f12711c;
    }

    public boolean isEmpty() {
        int i2 = this.f12711c;
        int i8 = this.f12710b;
        int i9 = this.f12709a;
        return i2 > 0 ? i9 > i8 : i9 < i8;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this.f12709a, this.f12710b, this.f12711c);
    }

    public String toString() {
        StringBuilder sb;
        int i2 = this.f12710b;
        int i8 = this.f12709a;
        int i9 = this.f12711c;
        if (i9 > 0) {
            sb = new StringBuilder();
            sb.append(i8);
            sb.append("..");
            sb.append(i2);
            sb.append(" step ");
            sb.append(i9);
        } else {
            sb = new StringBuilder();
            sb.append(i8);
            sb.append(" downTo ");
            sb.append(i2);
            sb.append(" step ");
            sb.append(-i9);
        }
        return sb.toString();
    }
}
