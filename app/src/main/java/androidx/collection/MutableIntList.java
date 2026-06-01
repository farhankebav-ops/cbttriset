package androidx.collection;

import a1.a;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.b;
import r5.e;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = mutableIntList._size;
        }
        mutableIntList.trim(i2);
    }

    public final boolean add(int i2) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i8 = this._size;
        iArr[i8] = i2;
        this._size = i8 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, int[] elements) {
        int i8;
        k.e(elements, "elements");
        if (i2 < 0 || i2 > (i8 = this._size)) {
            StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i8 + elements.length);
        int[] iArr = this.content;
        int i9 = this._size;
        if (i2 != i9) {
            j.c0(elements.length + i2, i2, i9, iArr, iArr);
        }
        j.g0(i2, 0, 12, elements, iArr);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        int[] iArr = this.content;
        if (iArr.length < i2) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i2, (iArr.length * 3) / 2));
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int i2) {
        remove(i2);
    }

    public final void plusAssign(IntList elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(int i2) {
        int iIndexOf = indexOf(i2);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(int[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        for (int i8 : elements) {
            remove(i8);
        }
        return i2 != this._size;
    }

    public final int removeAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this._size)) {
            StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int[] iArr = this.content;
        int i9 = iArr[i2];
        if (i2 != i8 - 1) {
            j.c0(i2, i2 + 1, i8, iArr, iArr);
        }
        this._size--;
        return i9;
    }

    public final void removeRange(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i8) {
        int i9;
        if (i2 < 0 || i2 > (i9 = this._size) || i8 < 0 || i8 > i9) {
            StringBuilder sbW = a.w(i2, "Start (", ") and end (", i8, ") must be in 0..");
            sbW.append(this._size);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException("Start (" + i2 + ") is more than end (" + i8 + ')');
        }
        if (i8 != i2) {
            if (i8 < i9) {
                int[] iArr = this.content;
                j.c0(i2, i8, i9, iArr, iArr);
            }
            this._size -= i8 - i2;
        }
    }

    public final boolean retainAll(int[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        int[] iArr = this.content;
        int i8 = i2 - 1;
        while (true) {
            int i9 = 0;
            int i10 = -1;
            if (-1 >= i8) {
                break;
            }
            int i11 = iArr[i8];
            int length = elements.length;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                if (elements[i9] == i11) {
                    i10 = i9;
                    break;
                }
                i9++;
            }
            if (i10 < 0) {
                removeAt(i8);
            }
            i8--;
        }
        return i2 != this._size;
    }

    public final int set(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, int i8) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbV = a.v(i2, "set index ", " must be between 0 .. ");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int[] iArr = this.content;
        int i9 = iArr[i2];
        iArr[i2] = i8;
        return i9;
    }

    public final void sort() {
        int[] iArr = this.content;
        int i2 = this._size;
        k.e(iArr, "<this>");
        Arrays.sort(iArr, 0, i2);
    }

    public final void sortDescending() {
        int[] iArr = this.content;
        int i2 = this._size;
        k.e(iArr, "<this>");
        Arrays.sort(iArr, 0, i2);
        b bVar = e.Companion;
        int length = iArr.length;
        bVar.getClass();
        b.d(0, i2, length);
        int i8 = i2 / 2;
        if (i8 == 0) {
            return;
        }
        int i9 = i2 - 1;
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = iArr[i10];
            iArr[i10] = iArr[i9];
            iArr[i9] = i11;
            i9--;
        }
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        int[] iArr = this.content;
        if (iArr.length > iMax) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public /* synthetic */ MutableIntList(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(int[] elements) {
        k.e(elements, "elements");
        for (int i2 : elements) {
            remove(i2);
        }
    }

    public final void plusAssign(int[] elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableIntList(int i2) {
        super(i2, null);
    }

    public final void plusAssign(int i2) {
        add(i2);
    }

    public final void add(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, int i8) {
        int i9;
        if (i2 >= 0 && i2 <= (i9 = this._size)) {
            ensureCapacity(i9 + 1);
            int[] iArr = this.content;
            int i10 = this._size;
            if (i2 != i10) {
                j.c0(i2 + 1, i2, i10, iArr, iArr);
            }
            iArr[i2] = i8;
            this._size++;
            return;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final void minusAssign(IntList elements) {
        k.e(elements, "elements");
        int[] iArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            remove(iArr[i8]);
        }
    }

    public final boolean removeAll(IntList elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        int i8 = elements._size - 1;
        if (i8 >= 0) {
            int i9 = 0;
            while (true) {
                remove(elements.get(i9));
                if (i9 == i8) {
                    break;
                }
                i9++;
            }
        }
        return i2 != this._size;
    }

    public final boolean retainAll(IntList elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        int[] iArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!elements.contains(iArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, IntList elements) {
        k.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            int[] iArr = this.content;
            int i8 = this._size;
            if (i2 != i8) {
                j.c0(elements._size + i2, i2, i8, iArr, iArr);
            }
            j.c0(i2, 0, elements._size, elements.content, iArr);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final boolean addAll(IntList elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(int[] elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }
}
