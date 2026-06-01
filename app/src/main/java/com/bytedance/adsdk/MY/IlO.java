package com.bytedance.adsdk.MY;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IlO<E> implements Collection<E>, Set<E> {
    private static Object[] Bc;
    private static Object[] Cc;
    private static int lEW;
    private static int vCE;
    private int[] DmF;
    Object[] IlO;
    int MY;
    private ea<E, E> NV;
    private static final int[] EO = new int[0];
    private static final Object[] tV = new Object[0];

    public IlO() {
        this(0);
    }

    private int IlO(Object obj, int i2) {
        int i8 = this.MY;
        if (i8 == 0) {
            return -1;
        }
        int iIlO = MY.IlO(this.DmF, i8, i2);
        if (iIlO < 0 || obj.equals(this.IlO[iIlO])) {
            return iIlO;
        }
        int i9 = iIlO + 1;
        while (i9 < i8 && this.DmF[i9] == i2) {
            if (obj.equals(this.IlO[i9])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iIlO - 1; i10 >= 0 && this.DmF[i10] == i2; i10--) {
            if (obj.equals(this.IlO[i10])) {
                return i10;
            }
        }
        return ~i9;
    }

    private void tV(int i2) {
        if (i2 == 8) {
            synchronized (IlO.class) {
                Object[] objArr = Bc;
                if (objArr != null) {
                    this.IlO = objArr;
                    Bc = (Object[]) objArr[0];
                    this.DmF = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    lEW--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (IlO.class) {
                Object[] objArr2 = Cc;
                if (objArr2 != null) {
                    this.IlO = objArr2;
                    Cc = (Object[]) objArr2[0];
                    this.DmF = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    vCE--;
                    return;
                }
            }
        }
        this.DmF = new int[i2];
        this.IlO = new Object[i2];
    }

    public E EO(int i2) {
        Object[] objArr = this.IlO;
        E e = (E) objArr[i2];
        int i8 = this.MY;
        if (i8 <= 1) {
            IlO(this.DmF, objArr, i8);
            this.DmF = EO;
            this.IlO = tV;
            this.MY = 0;
            return e;
        }
        int[] iArr = this.DmF;
        if (iArr.length <= 8 || i8 >= iArr.length / 3) {
            int i9 = i8 - 1;
            this.MY = i9;
            if (i2 < i9) {
                int i10 = i2 + 1;
                System.arraycopy(iArr, i10, iArr, i2, i9 - i2);
                Object[] objArr2 = this.IlO;
                System.arraycopy(objArr2, i10, objArr2, i2, this.MY - i2);
            }
            this.IlO[this.MY] = null;
            return e;
        }
        tV(i8 > 8 ? i8 + (i8 >> 1) : 8);
        this.MY--;
        if (i2 > 0) {
            System.arraycopy(iArr, 0, this.DmF, 0, i2);
            System.arraycopy(objArr, 0, this.IlO, 0, i2);
        }
        int i11 = this.MY;
        if (i2 < i11) {
            int i12 = i2 + 1;
            System.arraycopy(iArr, i12, this.DmF, i2, i11 - i2);
            System.arraycopy(objArr, i12, this.IlO, i2, this.MY - i2);
        }
        return e;
    }

    public E MY(int i2) {
        return (E) this.IlO[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int iIlO;
        if (e == null) {
            iIlO = IlO();
            i2 = 0;
        } else {
            int iHashCode = e.hashCode();
            i2 = iHashCode;
            iIlO = IlO(e, iHashCode);
        }
        if (iIlO >= 0) {
            return false;
        }
        int i8 = ~iIlO;
        int i9 = this.MY;
        int[] iArr = this.DmF;
        if (i9 >= iArr.length) {
            int i10 = 8;
            if (i9 >= 8) {
                i10 = (i9 >> 1) + i9;
            } else if (i9 < 4) {
                i10 = 4;
            }
            Object[] objArr = this.IlO;
            tV(i10);
            int[] iArr2 = this.DmF;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.IlO, 0, objArr.length);
            }
            IlO(iArr, objArr, this.MY);
        }
        int i11 = this.MY;
        if (i8 < i11) {
            int[] iArr3 = this.DmF;
            int i12 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i12, i11 - i8);
            Object[] objArr2 = this.IlO;
            System.arraycopy(objArr2, i8, objArr2, i12, this.MY - i8);
        }
        this.DmF[i8] = i2;
        this.IlO[i8] = e;
        this.MY++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        IlO(collection.size() + this.MY);
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.MY;
        if (i2 != 0) {
            IlO(this.DmF, this.IlO, i2);
            this.DmF = EO;
            this.IlO = tV;
            this.MY = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return IlO(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.MY; i2++) {
                try {
                    if (!set.contains(MY(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.DmF;
        int i2 = this.MY;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            i8 += iArr[i9];
        }
        return i8;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.MY <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return MY().tV().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIlO = IlO(obj);
        if (iIlO < 0) {
            return false;
        }
        EO(iIlO);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z2 = false;
        for (int i2 = this.MY - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.IlO[i2])) {
                EO(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.MY;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.MY;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.IlO, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.MY * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.MY; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E eMY = MY(i2);
            if (eMY != this) {
                sb.append(eMY);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public IlO(int i2) {
        if (i2 == 0) {
            this.DmF = EO;
            this.IlO = tV;
        } else {
            tV(i2);
        }
        this.MY = 0;
    }

    private ea<E, E> MY() {
        if (this.NV == null) {
            this.NV = new ea<E, E>() { // from class: com.bytedance.adsdk.MY.IlO.1
                @Override // com.bytedance.adsdk.MY.ea
                public void EO() {
                    IlO.this.clear();
                }

                @Override // com.bytedance.adsdk.MY.ea
                public int IlO() {
                    return IlO.this.MY;
                }

                @Override // com.bytedance.adsdk.MY.ea
                public Map<E, E> MY() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.MY.ea
                public Object IlO(int i2, int i8) {
                    return IlO.this.IlO[i2];
                }

                @Override // com.bytedance.adsdk.MY.ea
                public int IlO(Object obj) {
                    return IlO.this.IlO(obj);
                }

                @Override // com.bytedance.adsdk.MY.ea
                public void IlO(int i2) {
                    IlO.this.EO(i2);
                }
            };
        }
        return this.NV;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.MY) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.MY));
        }
        System.arraycopy(this.IlO, 0, tArr, 0, this.MY);
        int length = tArr.length;
        int i2 = this.MY;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    private int IlO() {
        int i2 = this.MY;
        if (i2 == 0) {
            return -1;
        }
        int iIlO = MY.IlO(this.DmF, i2, 0);
        if (iIlO < 0 || this.IlO[iIlO] == null) {
            return iIlO;
        }
        int i8 = iIlO + 1;
        while (i8 < i2 && this.DmF[i8] == 0) {
            if (this.IlO[i8] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iIlO - 1; i9 >= 0 && this.DmF[i9] == 0; i9--) {
            if (this.IlO[i9] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    private static void IlO(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (IlO.class) {
                try {
                    if (lEW < 10) {
                        objArr[0] = Bc;
                        objArr[1] = iArr;
                        for (int i8 = i2 - 1; i8 >= 2; i8--) {
                            objArr[i8] = null;
                        }
                        Bc = objArr;
                        lEW++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (IlO.class) {
                try {
                    if (vCE < 10) {
                        objArr[0] = Cc;
                        objArr[1] = iArr;
                        for (int i9 = i2 - 1; i9 >= 2; i9--) {
                            objArr[i9] = null;
                        }
                        Cc = objArr;
                        vCE++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void IlO(int i2) {
        int[] iArr = this.DmF;
        if (iArr.length < i2) {
            Object[] objArr = this.IlO;
            tV(i2);
            int i8 = this.MY;
            if (i8 > 0) {
                System.arraycopy(iArr, 0, this.DmF, 0, i8);
                System.arraycopy(objArr, 0, this.IlO, 0, this.MY);
            }
            IlO(iArr, objArr, this.MY);
        }
    }

    public int IlO(Object obj) {
        return obj == null ? IlO() : IlO(obj, obj.hashCode());
    }
}
