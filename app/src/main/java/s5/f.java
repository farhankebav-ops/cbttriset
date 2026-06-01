package s5;

import com.ironsource.G5;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements Map, Serializable, f6.e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f13706n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f13707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f13708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f13709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f13710d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13711f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13712i;
    public g j;
    public h k;
    public g l;
    public boolean m;

    static {
        f fVar = new f(0);
        fVar.m = true;
        f13706n = fVar;
    }

    public f() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int iJ = j(obj);
            int i2 = this.e * 2;
            int length = this.f13710d.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i8 = 0;
            while (true) {
                int[] iArr = this.f13710d;
                int i9 = iArr[iJ];
                if (i9 <= 0) {
                    int i10 = this.f13711f;
                    Object[] objArr = this.f13707a;
                    if (i10 < objArr.length) {
                        int i11 = i10 + 1;
                        this.f13711f = i11;
                        objArr[i10] = obj;
                        this.f13709c[i10] = iJ;
                        iArr[iJ] = i11;
                        this.f13712i++;
                        this.h++;
                        if (i8 > this.e) {
                            this.e = i8;
                        }
                        return i10;
                    }
                    g(1);
                } else {
                    if (k.a(this.f13707a[i9 - 1], obj)) {
                        return -i9;
                    }
                    i8++;
                    if (i8 > i2) {
                        k(this.f13710d.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.f13710d.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final f b() {
        c();
        this.m = true;
        if (this.f13712i > 0) {
            return this;
        }
        f fVar = f13706n;
        k.c(fVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return fVar;
    }

    public final void c() {
        if (this.m) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i2 = this.f13711f - 1;
        if (i2 >= 0) {
            int i8 = 0;
            while (true) {
                int[] iArr = this.f13709c;
                int i9 = iArr[i8];
                if (i9 >= 0) {
                    this.f13710d[i9] = 0;
                    iArr[i8] = -1;
                }
                if (i8 == i2) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        q.o0(0, this.f13711f, this.f13707a);
        Object[] objArr = this.f13708b;
        if (objArr != null) {
            q.o0(0, this.f13711f, objArr);
        }
        this.f13712i = 0;
        this.f13711f = 0;
        this.h++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z2) {
        int i2;
        Object[] objArr = this.f13708b;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i2 = this.f13711f;
            if (i8 >= i2) {
                break;
            }
            int[] iArr = this.f13709c;
            int i10 = iArr[i8];
            if (i10 >= 0) {
                Object[] objArr2 = this.f13707a;
                objArr2[i9] = objArr2[i8];
                if (objArr != null) {
                    objArr[i9] = objArr[i8];
                }
                if (z2) {
                    iArr[i9] = i10;
                    this.f13710d[i10] = i9 + 1;
                }
                i9++;
            }
            i8++;
        }
        q.o0(i9, i2, this.f13707a);
        if (objArr != null) {
            q.o0(i9, this.f13711f, objArr);
        }
        this.f13711f = i9;
    }

    public final boolean e(Collection m) {
        k.e(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.l;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.l = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f13712i == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        k.e(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.f13708b;
        k.b(objArr);
        return k.a(objArr[iH], entry.getValue());
    }

    public final void g(int i2) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f13707a;
        int length = objArr.length;
        int i8 = this.f13711f;
        int i9 = length - i8;
        int i10 = i8 - this.f13712i;
        if (i9 < i2 && i9 + i10 >= i2 && i10 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i11 = i8 + i2;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        if (i11 > objArr.length) {
            r5.b bVar = r5.e.Companion;
            int length2 = objArr.length;
            bVar.getClass();
            int iE = r5.b.e(length2, i11);
            Object[] objArr2 = this.f13707a;
            k.e(objArr2, "<this>");
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, iE);
            k.d(objArrCopyOf2, "copyOf(...)");
            this.f13707a = objArrCopyOf2;
            Object[] objArr3 = this.f13708b;
            if (objArr3 != null) {
                objArrCopyOf = Arrays.copyOf(objArr3, iE);
                k.d(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f13708b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f13709c, iE);
            k.d(iArrCopyOf, "copyOf(...)");
            this.f13709c = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((iE >= 1 ? iE : 1) * 3);
            if (iHighestOneBit > this.f13710d.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f13708b;
        k.b(objArr);
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i2 = this.e;
        while (true) {
            int i8 = this.f13710d[iJ];
            if (i8 == 0) {
                return -1;
            }
            if (i8 > 0) {
                int i9 = i8 - 1;
                if (k.a(this.f13707a[i9], obj)) {
                    return i9;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.f13710d.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i2 = 0;
        while (dVar.hasNext()) {
            int i8 = dVar.f13700b;
            f fVar = dVar.f13699a;
            if (i8 >= fVar.f13711f) {
                throw new NoSuchElementException();
            }
            dVar.f13700b = i8 + 1;
            dVar.f13701c = i8;
            Object obj = fVar.f13707a[i8];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f13708b;
            k.b(objArr);
            Object obj2 = objArr[dVar.f13701c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.b();
            i2 += iHashCode ^ iHashCode2;
        }
        return i2;
    }

    public final int i(Object obj) {
        int i2 = this.f13711f;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f13709c[i2] >= 0) {
                Object[] objArr = this.f13708b;
                k.b(objArr);
                if (k.a(objArr[i2], obj)) {
                    return i2;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f13712i == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f13709c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.h
            int r0 = r0 + 1
            r5.h = r0
            int r0 = r5.f13711f
            int r1 = r5.f13712i
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f13710d = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.g = r6
        L1c:
            int r6 = r5.f13711f
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f13707a
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.e
        L2c:
            int[] r3 = r5.f13710d
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f13709c
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.j;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.j = gVar2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f13707a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.k.e(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f13708b
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f13709c
            r0 = r0[r12]
            int r1 = r11.e
            int r1 = r1 * 2
            int[] r2 = r11.f13710d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.f13710d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.e
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f13710d
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f13710d
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = r2
            goto L65
        L4b:
            java.lang.Object[] r5 = r11.f13707a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f13710d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f13709c
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f13710d
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f13709c
            r0[r12] = r6
            int r12 = r11.f13712i
            int r12 = r12 + r6
            r11.f13712i = r12
            int r12 = r11.h
            int r12 = r12 + 1
            r11.h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.f.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f13708b;
        if (objArr == null) {
            int length = this.f13707a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f13708b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i2 = (-iA) - 1;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        k.e(from, "from");
        c();
        Set<Map.Entry> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f13708b;
            if (objArr == null) {
                int length = this.f13707a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f13708b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i2 = (-iA) - 1;
                if (!k.a(entry.getValue(), objArr[i2])) {
                    objArr[i2] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f13708b;
        k.b(objArr);
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f13712i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f13712i * 3) + 2);
        sb.append("{");
        int i2 = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            int i8 = dVar.f13700b;
            f fVar = dVar.f13699a;
            if (i8 >= fVar.f13711f) {
                throw new NoSuchElementException();
            }
            dVar.f13700b = i8 + 1;
            dVar.f13701c = i8;
            Object obj = fVar.f13707a[i8];
            if (obj == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append(G5.T);
            Object[] objArr = fVar.f13708b;
            k.b(objArr);
            Object obj2 = objArr[dVar.f13701c];
            if (obj2 == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.b();
            i2++;
        }
        sb.append("}");
        String string = sb.toString();
        k.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.k;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.k = hVar2;
        return hVar2;
    }

    public f(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i2];
        int[] iArr = new int[i2];
        int iHighestOneBit = Integer.highestOneBit((i2 < 1 ? 1 : i2) * 3);
        this.f13707a = objArr;
        this.f13708b = null;
        this.f13709c = iArr;
        this.f13710d = new int[iHighestOneBit];
        this.e = 2;
        this.f13711f = 0;
        this.g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
