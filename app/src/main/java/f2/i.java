package f2;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i extends a implements Set {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f11331c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient e f11332b;

    public static int g(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            r2.q.y(iMax < 1073741824, "collection too large");
            return BasicMeasure.EXACTLY;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static i h(int i2, Object... objArr) {
        if (i2 == 0) {
            return q.j;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new t(obj);
        }
        int iG = g(i2);
        Object[] objArr2 = new Object[iG];
        int i8 = iG - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                throw new NullPointerException(a1.a.g(i11, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iP = n7.b.P(iHashCode);
            while (true) {
                int i12 = iP & i8;
                Object obj3 = objArr2[i12];
                if (obj3 == null) {
                    objArr[i10] = obj2;
                    objArr2[i12] = obj2;
                    i9 += iHashCode;
                    i10++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iP++;
            }
        }
        Arrays.fill(objArr, i10, i2, (Object) null);
        if (i10 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new t(obj4);
        }
        if (g(i10) < iG / 2) {
            return h(i10, objArr);
        }
        int length = objArr.length;
        if (i10 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new q(objArr, i9, objArr2, i8, i10);
    }

    @Override // f2.a
    public e a() {
        e eVar = this.f11332b;
        if (eVar != null) {
            return eVar;
        }
        e eVarI = i();
        this.f11332b = eVarI;
        return eVarI;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof i) && (this instanceof q) && (((i) obj) instanceof q) && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public e i() {
        Object[] array = toArray(a.f11310a);
        c cVar = e.f11320b;
        return e.g(array.length, array);
    }
}
